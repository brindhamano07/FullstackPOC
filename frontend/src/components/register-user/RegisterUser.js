import React, {Component} from 'react';
import PropTypes from "prop-types";
class RegisterUser extends Component{
    constructor(props) {
        super(props);
        this.state = {
            firstName:'',
            lastName:'',
            email:'',
            address:'',
            phoneNumber:'',
            source:''
        }
        this.onSubmit = this.onSubmit.bind(this);
    }

   onChange =(e) =>{
        this.setState({[e.target.name]:e.target.value})
   }
	
    onSubmit(e){
        e.preventDefault();
        //Copying state object to newUser
        let newUser = this.state;
        this.props.addUser(newUser);
        //Resetting the fields
        this.setState({
            firstName:'',
            lastName:'',
            email:'',
            address:'',
            phoneNumber:'',
            source:''
        });
    }
    render() {
        return(
            <form onSubmit={this.onSubmit}>
                <div style={{display:'flex' }}>
                    <input
                        type = "text"
                        name = "firstName"
                        placeholder="FirstName"
                        style={leftInput}
                        value={this.state.firstName}
                         onChange={this.onChange}
                    />

                    <input
                        type = "text"
                        name = "lastName"
                        placeholder="LastName"
                        style={rightInput}
                        value={this.state.lastName}
                        onChange={this.onChange}
                    />
                </div>
                <br/>
                <div style={{display:'flex', }}>
                    <input
                        type = "text"
                        name = "email"
                        placeholder="Email"
                        style={leftInput}
                        value={this.state.email}
                        onChange={this.onChange}
                    />

                    <input
                        type = "text"
                        name = "address"
                        placeholder="Address"
                        style={rightInput}
                        value={this.state.address}
                        onChange={this.onChange}
                    />
                </div>
                <br/>
                <div style={{display:'flex' }}>
                    <input
                        type = "text"
                        name = "phoneNumber"
                        placeholder="PhoneNumber"
                        style={leftInput}
                        value={this.state.phoneNumber}
                        onChange={this.onChange}
                    />
                    
                    <input
                        type = "text"
                        name = "source"
                        placeholder="Source"
                        style={rightInput}
                        value={this.state.source}
                        onChange={this.onChange}
                    />
                </div>
                <br/>
                <input
                    type="submit"
                    value="Submit"
                    className="btn"
                />
                <br/>
            </form>
        )
    }
}

const leftInput = {
    flex:'5',
    padding:'5px',
    margin:'10px 10px 0px 0px'
}

const rightInput = {
    flex:'5',
    padding:'5px',
    margin:'10px 0px 0px 10px'
}

RegisterUser.propTypes = {
    addUser:PropTypes.func.isRequired,
}

export default RegisterUser;