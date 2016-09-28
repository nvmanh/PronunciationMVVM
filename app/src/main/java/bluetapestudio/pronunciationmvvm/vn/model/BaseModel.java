package bluetapestudio.pronunciationmvvm.vn.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import bluetapestudio.pronunciationmvvm.vn.App;
import bluetapestudio.pronunciationmvvm.vn.libs.DateConvert;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class BaseModel extends BaseObservable implements Serializable{
    @SerializedName("create_date")
    private String createDate;
    @SerializedName("update_date")
    private String updateDate;
    private int id;

    public BaseModel() {
        createDate = DateConvert.today(null);
        updateDate = DateConvert.today(null);
    }
    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Bindable
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    @Bindable
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private String toJson() {
        return App.self().gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o.getClass().equals(getClass()))) return false;
        return getId() == ((BaseModel) o).getId();
    }

    @Override
    protected Object clone() {
        return App.self().gson().fromJson(toJson(), getClass());
    }

    @Override
    public String toString() {
        return App.self().gson().toJson(this);
    }
}