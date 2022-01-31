package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationSetActivity$EmojiJsBridgeListener
{
  public IndividuationSetActivity$EmojiJsBridgeListener(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void a() {}
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      switch (paramJSONObject.getInt("what"))
      {
      case 1005: 
        QQToast.a(this.a, this.a.getString(2131363415), 0).b(this.a.getTitleBarHeight());
        IndividuationSetActivity.a(this.a, false);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    QQToast.a(this.a, this.a.getString(2131363523), 0).b(this.a.getTitleBarHeight());
    IndividuationSetActivity.a(this.a, false);
    return;
    QQToast.a(this.a, this.a.getString(2131363527), 0).b(this.a.getTitleBarHeight());
    IndividuationSetActivity.a(this.a, false);
    return;
    IndividuationSetActivity.a(this.a, false);
    return;
    QQToast.a(this.a, this.a.getString(2131364515), 0).b(this.a.getTitleBarHeight());
    IndividuationSetActivity.a(this.a, false);
    return;
    this.a.a.a(this);
    return;
    IndividuationSetActivity.a(this.a, true);
    return;
    QQToast.a(this.a, this.a.getString(2131364517), 0).b(this.a.getTitleBarHeight());
    IndividuationSetActivity.a(this.a, false);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener
 * JD-Core Version:    0.7.0.1
 */