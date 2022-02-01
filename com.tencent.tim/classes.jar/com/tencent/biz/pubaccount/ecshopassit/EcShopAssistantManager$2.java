package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;
import kdm;

public class EcShopAssistantManager$2
  implements Runnable
{
  public EcShopAssistantManager$2(kdm paramkdm) {}
  
  public void run()
  {
    synchronized (this.this$0.object)
    {
      Object[] arrayOfObject = this.this$0.H.toArray();
      if (this.this$0.mApp != null) {
        aqmk.a(this.this$0.mApp.getApp().getSharedPreferences(this.this$0.mApp.getAccount(), 0).edit(), "ec_shop_assist_new_unread_list", arrayOfObject).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */