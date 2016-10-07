package com.javifocus2009gmail.exactsize;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jbenitez on 5/10/16.
 */

public class LineMeasure {

    private EditText quantity;
    private EditText size;
    private Button remove;

    public EditText getQuantity() {
        return quantity;
    }

    public void setQuantity(EditText quantity) {
        this.quantity = quantity;
    }

    public EditText getSize() {
        return size;
    }

    public void setSize(EditText size) {
        this.size = size;
    }

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }

    public LineMeasure() {
        setQuantity(quantity);
        setSize(size);
        setRemove(remove);
    }

}
