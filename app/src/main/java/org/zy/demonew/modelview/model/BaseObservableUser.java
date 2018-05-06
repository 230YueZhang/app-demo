package org.zy.demonew.modelview.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.zy.demonew.BR;

public class BaseObservableUser extends BaseObservable {
    public String firstName;
    private String lastName;

    public BaseObservableUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
//        notifyChange();
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
//        notifyChange();
    }

    @Bindable({"firstName", "lastName"})
    public String getName() {
        return firstName + lastName;
    }

}
