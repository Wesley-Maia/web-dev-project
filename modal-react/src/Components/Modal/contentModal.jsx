import React from "react";
import "./Modal.css";

const ContentModal = props => {

    const { className } = props;

    return(
        <div>
            <p>Meu modal!</p>
            <h1>{className}</h1>
        </div>
    )
}

export default ContentModal;
