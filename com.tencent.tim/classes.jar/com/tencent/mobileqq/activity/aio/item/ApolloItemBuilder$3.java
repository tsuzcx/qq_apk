package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

final class ApolloItemBuilder$3
  implements Runnable
{
  ApolloItemBuilder$3(Context paramContext, int paramInt, String paramString) {}
  
  public void run()
  {
    QQToast.a(this.val$context.getApplicationContext(), this.val$iconType, this.Vv, 1).show(this.val$context.getResources().getDimensionPixelSize(2131299627));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "fav action number is 144");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */