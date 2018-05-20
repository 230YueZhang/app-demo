package org.zy.demonew.twoway.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;

public class User implements Parcelable {
    public ObservableField<String> name =
            new ObservableField<>();
    public ObservableField<String> password =
            new ObservableField<>();
    public ObservableBoolean rememberPsw = new ObservableBoolean();

    public ObservableField<String> errorNameTips = new ObservableField<>();
    public ObservableField<String> errorPswTips = new ObservableField<>();
    public ObservableBoolean formatOk = new ObservableBoolean();

    public boolean checkFormat() {
        boolean nameOk = !TextUtils.isEmpty(name.get()) && name.get().length() > 1;
        boolean passwordOk = !TextUtils.isEmpty(password.get()) && password.get().length() > 5;

        return nameOk && passwordOk;
    }

    public void afterTextChange(Editable s) {
        formatOk.set(checkFormat());
    }


    /**
     * After LoginAction what should M do ?
     * @param user
     */
    public void afterLogin(User user) {
        if (user.rememberPsw.get()) {
            storeUserInfo();
        }
    }

    /**
     * store user info
     */
    public void storeUserInfo(){

    }


    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.name);
        dest.writeSerializable(this.password);
        dest.writeParcelable(this.rememberPsw, flags);
        dest.writeSerializable(this.errorNameTips);
        dest.writeSerializable(this.errorPswTips);
        dest.writeParcelable(this.formatOk, flags);
    }

    protected User(Parcel in) {
        this.name = (ObservableField<String>) in.readSerializable();
        this.password = (ObservableField<String>) in.readSerializable();
        this.rememberPsw = in.readParcelable(ObservableBoolean.class.getClassLoader());
        this.errorNameTips = (ObservableField<String>) in.readSerializable();
        this.errorPswTips = (ObservableField<String>) in.readSerializable();
        this.formatOk = in.readParcelable(ObservableBoolean.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
