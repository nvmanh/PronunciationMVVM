package bluetapestudio.pronunciationmvvm.vn.model;

import android.databinding.Bindable;
import android.text.TextUtils;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class Question extends BaseModel {
    private String content;
    private String description;
    private int level;
    private int category;

    public Question(){

    }

    @Bindable
    public String getContent() {
        return TextUtils.isEmpty(content) ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Bindable
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
