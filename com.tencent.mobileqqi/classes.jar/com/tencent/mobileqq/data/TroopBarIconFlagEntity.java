package com.tencent.mobileqq.data;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class TroopBarIconFlagEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_ICON_BG = "icon_bg";
  protected static final String JSON_KEY_ICON_COLOR = "icon_color";
  protected static final String JSON_KEY_ICON_TEXT = "icon_text";
  protected static final String JSON_KEY_SUBSCRIPT_ADDR = "subscript_addr";
  protected static final long serialVersionUID = 10005L;
  public String icon_bg;
  public String icon_color;
  public String icon_text;
  public String subscript_addr;
  
  public TroopBarIconFlagEntity() {}
  
  public TroopBarIconFlagEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.icon_text = TroopBarUtils.a(paramJSONObject, "icon_text");
    this.icon_bg = TroopBarUtils.a(paramJSONObject, "icon_bg");
    this.icon_color = TroopBarUtils.a(paramJSONObject, "icon_color");
    this.subscript_addr = TroopBarUtils.a(paramJSONObject, "subscript_addr");
  }
  
  public static final void setTextViewForegroundColor(TextView paramTextView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramTextView.setTextColor(Color.parseColor(paramString));
      return;
    }
    catch (IllegalArgumentException paramTextView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopBar", 2, "setTextViewForegroundColor IllegalArgumentException, colorText = " + paramString);
    }
  }
  
  public static final void setViewBackgroundColor(Resources paramResources, View paramView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramResources = (GradientDrawable)paramResources.getDrawable(2130838426);
      paramResources.setColor(Color.parseColor(paramString));
      paramView.setBackgroundDrawable(paramResources);
      return;
    }
    catch (IllegalArgumentException paramResources)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopBar", 2, "setTextViewBackgroundColor IllegalArgumentException, colorText = " + paramString);
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.icon_text = paramObjectInput.readUTF();
    this.icon_bg = paramObjectInput.readUTF();
    this.icon_color = paramObjectInput.readUTF();
    this.subscript_addr = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.icon_text);
    paramObjectOutput.writeUTF(this.icon_bg);
    paramObjectOutput.writeUTF(this.icon_color);
    paramObjectOutput.writeUTF(this.subscript_addr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarIconFlagEntity
 * JD-Core Version:    0.7.0.1
 */