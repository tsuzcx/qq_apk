package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import android.widget.TextView;
import aqft;

class QQSettingMe$14$1
  implements Runnable
{
  QQSettingMe$14$1(QQSettingMe.14 param14, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.mNickName.getTop() > QQSettingMe.b(this.a.this$0).getBottom()) {
      this.a.this$0.mNickName.setMaxWidth(QQSettingMe.a(this.a.this$0) - QQSettingMe.b(this.a.this$0).getWidth());
    }
    for (;;)
    {
      if (!aqft.equalsWithNullCheck(this.aPf, QQSettingMe.a(this.a.this$0)))
      {
        QQSettingMe.a(this.a.this$0, this.aPf);
        this.a.this$0.mNickName.setText(QQSettingMe.a(this.a.this$0));
      }
      return;
      this.a.this$0.mNickName.setMaxWidth(QQSettingMe.a(this.a.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.14.1
 * JD-Core Version:    0.7.0.1
 */