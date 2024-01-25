import React, { useState, useEffect } from "react";
import Logo from "../../../assets/logo.svg";
import "./Setup.css";
import { getTablet, createTablet } from "../../../lib/api"; // Import the postTablets function
import useLocalStorage from "src/hooks/useLocalStorage";

export default function Setup() {
  const [tabletName, setTabletName] = useState("");
  const [tabletArea, setTabletArea] = useState("");
  const [tablet, setTablet] = useLocalStorage("tablet", {});

  async function fetchTablet(id) {
    try {
      const response = await getTablet(id);
      setTablet(response);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    fetchTablet(1);
  }, []);

  const handleNameChange = (event) => {
    setTabletName(event.target.value);
  };

  const handleAreaChange = (event) => {
    setTabletArea(event.target.value);
  };

  const handleSubmit = async () => {
    try {
      await createTablet(tabletName, tabletArea);
    } catch (error) {
      console.error("Error posting tablet data:", error);
    }
  };

  return (
    <div className="set-up">
      <img className="set-up__logo" src={Logo} alt="" />
      <div className="container">
        <h1>Hello, I’m CareMinder</h1>
        <p>Please set the name of the tablet.</p>
        <p>This is used to specify tablets by bed area.</p>
        <p>
          The name can then be modified through the Preferences menu on the
          nurse's screen.
        </p>
        <div className="form">
          <p>Setting a name</p>
          <input
            className="input-form"
            type="text"
            placeholder="Enter tablet name"
            value={tabletName}
            onChange={handleNameChange}
          />

          <p>Setting an area</p>
          <input
            className="input-form"
            type="text"
            placeholder="Enter tablet area"
            value={tabletArea}
            onChange={handleAreaChange}
          />

          <button className="submit-button" onClick={handleSubmit}></button>
        </div>
      </div>
    </div>
  );
}
