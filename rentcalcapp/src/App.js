import React, { Component } from 'react';
import './App.css';

//Main class component that displays on page
class App extends Component {

	constructor() {
		super();
		this.handleData = this.handleData.bind(this);
		this.state = {
			inputFromChild: ''
		};
	}

	handleData(data) {
		this.setState({
			inputFromChild: data
		});
	}

	render() {
		return (
			<div className="App">
				<h1>RENT CALC</h1>
				<TotalRentInput handlerFromParent={this.handleData} />
				<OutputDisplay rent={this.state.inputFromChild} />
				<RoomieInput />
			</div>
			);
	}
}

//Takes total rent amount as input
class TotalRentInput extends Component {
	constructor() {
		super();

		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.state = {
			value: ''
		};
	}

	handleChange(event) {
		this.setState({value: event.target.value});
	}

	handleSubmit(event) {
		event.preventDefault();
		this.props.handlerFromParent(this.state.value);

		this.setState({
			value: ''
		});
	}


	render() {
		return(
			<form onSubmit={this.handleSubmit}>
				<label>
					Total Rent: 
						<input type="text" value={this.state.value} onChange={this.handleChange} /> 
				</label>
				<input type="submit" value="Submit" />
			</form>

			);
	}

}

class RoomieInput extends Component {
	state = {
		roomies: [{name:"", income:""}],
	}

	handleSubmit = (e) => {e.preventDefault()};

	render() {

		let {roomies} = this.state;

		return(
			<div>
				<form>
					<label>
						Roomie name: 
						<input type="text"/>
					</label>

					<label>
						Income:
						<input type="text"/>
					</label>

					<input type="submit" value="Submit" />
				

					<button type="button">Add New Roomie</button>
					{
						roomies.map((val,idx) => {
							let roomieId = `roomie-${idx}`, incomeId=`income-${idx}`;
							<div key={idx}>
								<label htmlFor={roomieId}> {`Roomie #${idx+1}`}</label>
								<input type="text" name={roomieId} data-id={idx} id={roomieId} className="name"/>
								<label htmlFor={incomeId}>Income</label>
								<input type="text" name={incomeId} data-id={idx} id={incomeId} className="income" />
							</div>
						})
					}
					<input type="submit" value="Submit" />
				</form>
				</div>
			)
	}
}

//Displays output of data
class OutputDisplay extends Component {
	render() {
		return(
			<div className="outputbox">
					<label>Total Rent: {this.props.rent} </label>
			</div>
			)
	}
}


export default App;
