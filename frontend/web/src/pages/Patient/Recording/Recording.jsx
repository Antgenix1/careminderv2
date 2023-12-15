import React from "react";

export default function Recording() {
    return ( 
        <div className="recording">
             <div className="header">
            <div className="left">
                <img
                    className="patient-img"
                    src={Logo}
                />

            <div className="home"> 
            <a href="/patient/home"><FaArrowLeft  size={50} color="black"/></a>
            
            </div>

            </div>
           

        </div>
        <div className="body">
         <PiWaveformBold size={200}/> 
        </div>
        <h2 className="record-text">Recording your voice</h2>z
        <div className="record-buttons">
         <button className="record-button"> 
          Cancel
         </button>
         <a href="/patient/recordingresults">
         <button className="record-button">
            Finish
         </button>
         </a>
        </div>
        <PatientFooter/>
        </div>
    
    );
}
