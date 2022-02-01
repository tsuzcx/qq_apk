package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;

class QQIdentiferLegacy$3
  extends URLSpan
{
  QQIdentiferLegacy$3(QQIdentiferLegacy paramQQIdentiferLegacy, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("title", this.this$0.getString(2131695255));
    localIntent.putExtra("selfSet_leftViewText", this.this$0.getString(2131691039));
    if ("setFaceData".equals(QQIdentiferLegacy.a(this.this$0)))
    {
      paramView = getURL() + "?appname=qq_safety";
      localIntent.putExtra("url", paramView);
      this.this$0.startActivity(localIntent);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getURL());
    if ((QQIdentiferLegacy.a(this.this$0) == null) || (TextUtils.isEmpty(QQIdentiferLegacy.a(this.this$0).appName))) {}
    for (paramView = "";; paramView = "?appname=" + QQIdentiferLegacy.a(this.this$0).appName)
    {
      paramView = paramView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.3
 * JD-Core Version:    0.7.0.1
 */