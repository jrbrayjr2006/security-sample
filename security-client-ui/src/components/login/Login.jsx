import React from 'react';
import './Login.css';

const Login = () => {
    return(
        <form className="log-in-form">
            <h4 className="text-center">Log in with you email account</h4>
            <label>Email
                <input type="email" placeholder="somebody@example.com" />
            </label>
            <label>Password
                <input type="password" placeholder="Password" />
            </label>
            <input id="show-password" type="checkbox" />
                <label htmlFor="show-password">Show password</label>
                <p><input type="submit" className="button expanded" value="Log in"></input></p>
                <p className="text-center"><a href="#">Forgot your password?</a></p>
        </form>
    )
}

export default Login;