import React from 'react';
import CountryAdministrationComponent from './CountryAdministrationComponent';
//import {countryList} from '../App';
import axios from 'axios';



class CountryAdministrationContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      description: '',
      id: '',
      image: '',
      price: 0,
      quantity: 0,
      title: ''
    };
    //var fromMenu;
  }

  handleChangeOfTitle = (event) => {
    this.setState({ title: event.target.value });
  }

  handleChangeOfImageUrl = (event) => {
    this.setState({ image: event.target.value });
  }

  handleChangeOfDescription = (event) => {
    this.setState({ description: event.target.value });
  }

  handleChangeOfPrice = (event) => {
    this.setState({ price: event.target.value });
  }

  handleChangeOfQuantity = (event) => {
    this.setState({ quantity: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
	axios.post('http://localhost:8080/countrys', this.state)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });

  }

  componentDidMount() {

    //console.log(this.props.history.location.pathname);
  }


  render() {
    if (this.props.history.location.pathname === "/admin/countrys/new") {
      this.fromMenu = "Kuriamas naujas produktas";
    } else {
      var pathnameArray = this.props.history.location.pathname.split('/');
      if (pathnameArray[1] === "admin" && pathnameArray[2] === "countrys") {
        var number = pathnameArray[pathnameArray.length - 1];
        this.fromMenu = "Atnaujinamas produktas id: " + number;
      }
    }
    //console.log(this.props.history);

    return (
      <CountryAdministrationComponent handleChangeOfTitle={this.handleChangeOfTitle}
        handleChangeOfImageUrl={this.handleChangeOfImageUrl}
        handleChangeOfDescription={this.handleChangeOfDescription}
        handleChangeOfPrice={this.handleChangeOfPrice}
        handleChangeOfQuantity={this.handleChangeOfQuantity}
        handleSubmit={this.handleSubmit}
        fromMenu={this.fromMenu}
      />
    );
  }
}

export default CountryAdministrationContainer;
