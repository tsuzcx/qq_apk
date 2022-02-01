package com.tencent.ad.tangram.canvas.views.form.framework;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import java.io.Serializable;

@Keep
public abstract class AdFormItemData
  implements Serializable
{
  public int backgroundColor = 0;
  public int contentPaddingLeft = 0;
  public int contentPaddingRight = 0;
  public int paddingBottom = 0;
  public int paddingTop = 0;
  public AdTextData placeholder;
  public boolean required;
  public AdTextData title = new AdTextData();
  public int titlePaddingLeft = 0;
  public int titlePaddingRight = 0;
  
  public abstract Object getResult();
  
  public boolean isValid()
  {
    return (this.paddingTop >= 0) && (this.paddingBottom >= 0) && (this.title != null) && (this.title.isValid()) && (!TextUtils.isEmpty(this.title.text)) && (this.titlePaddingLeft >= 0) && (this.titlePaddingRight >= 0) && (this.contentPaddingLeft >= 0) && (this.contentPaddingRight >= 0) && ((this.placeholder == null) || (this.placeholder.isValid()));
  }
  
  public abstract AdFormError validate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData
 * JD-Core Version:    0.7.0.1
 */