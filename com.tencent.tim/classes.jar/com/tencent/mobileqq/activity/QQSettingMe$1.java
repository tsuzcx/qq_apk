package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

class QQSettingMe$1
  implements Runnable
{
  QQSettingMe$1(QQSettingMe paramQQSettingMe, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.k(Boolean.valueOf(this.aZU));
    QQSettingMe.a(this.this$0).setImageResource(2130846951);
    QQSettingMe.b(this.this$0).setImageResource(2130846967);
    this.this$0.mNickName.setTextColor(this.this$0.c.getResources().getColor(2131166729));
    TextView localTextView = (TextView)this.this$0.ug.findViewById(2131377256);
    localTextView.setTextColor(this.this$0.c.getResources().getColor(2131166727));
    ((ImageView)this.this$0.ug.findViewById(2131368715)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.1
 * JD-Core Version:    0.7.0.1
 */