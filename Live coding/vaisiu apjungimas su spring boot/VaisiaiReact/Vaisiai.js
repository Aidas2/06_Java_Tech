import React, { Component } from 'react';
import Vaisius from './Vaisius';
import PropTypes from 'prop-types'
import axios from 'axios'
import apple from '../vaisiai_design/apple.png';
import banana from '../vaisiai_design/banana.png';
import orange from '../vaisiai_design/orange.png';

class Vaisiai extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vaisiai: props.vaisiai
        }
    }
    render() {
        if (this.state.vaisiai.length === 0) {
            return <div>Dar neuzkorviau duomenu.. Prasau palaukti..</div>
        }
        var vaisiai = this.state.vaisiai.map(vaisius => {
            var paveiksliukoObjektas = apple;
            if (vaisius.paveiksliukas === "banana") {
                paveiksliukoObjektas = banana;
            }
            if (vaisius.paveiksliukas === "orange") {
                paveiksliukoObjektas = orange;
            }
            return (<div className="col-sm-4" key={vaisius.pavadinimas}>
                <Vaisius paveiksliukas={paveiksliukoObjektas}
                         pavadinimas={vaisius.pavadinimas}
                         aprasymas={vaisius.aprasymas}
                         nuoroda={vaisius.nuoroda}
                         key={vaisius.pavadinimas}/>
            </div>);
        })
        return (<div className="container-fluid">
                    <div className="row">
                        {vaisiai}
                    </div>
                </div>);
    }
    componentDidMount = () => {
        axios.get("http://localhost:8081/vaisiai")
          .then((atsakymas) => {
              this.setState({vaisiai: atsakymas.data})
            })
          .catch((klaida) => {
              console.log(klaida)
            })
    }
}

Vaisiai.propTypes = {
    vaisiai: PropTypes.array.isRequired
}

export default Vaisiai;