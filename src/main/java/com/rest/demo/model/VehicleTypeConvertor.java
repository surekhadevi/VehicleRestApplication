package com.rest.demo.model;

import java.beans.PropertyEditorSupport;

public class VehicleTypeConvertor extends PropertyEditorSupport{

	public void setAsText(final String text) throws IllegalArgumentException {
        setValue(VehicleType.fromValue(text));
    }
}
