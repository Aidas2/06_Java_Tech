import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/lithuania.jpg';

const CountryCardComponent = (props) => {
    return (
        <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="FlagOfTheCountry"></img>
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">{props.description}</p>
                <p className="card-text">Prezidentas: {props.price} .</p>
                <p className="card-text">Sventes data: {props.quantity} .</p>
                <a href="#" className="btn btn-primary">Country details</a>
            </div>
        </div>
        );
}


CountryCardComponent.propTypes = {
    id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};


export default CountryCardComponent;
