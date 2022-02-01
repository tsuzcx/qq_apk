package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import anxr;
import aqdj;
import aqgv;
import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AccountManageActivity$14
  implements Runnable
{
  AccountManageActivity$14(AccountManageActivity paramAccountManageActivity, QQAppInterface paramQQAppInterface, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.g != this.this$0.app) {
          break;
        }
        if (this.g == null) {
          return;
        }
        localBitmap = this.g.a(this.aKo, (byte)1, false);
        if (localBitmap != null) {
          break label372;
        }
        if ((!AccountManageActivity.a(this.this$0).containsKey(this.aKo)) || (AccountManageActivity.a(this.this$0).get(this.aKo) == null))
        {
          aqdj localaqdj = aqdj.a(this.g, this.aKo, (byte)1);
          String str2 = aqgv.n(this.g, this.aKo);
          localObject2 = (anxr)this.g.getManager(61);
          if (localObject2 == null) {
            break label398;
          }
          localObject2 = ((anxr)localObject2).a(this.aKo);
          String str1;
          if (!this.b.isLogined())
          {
            str1 = str2;
            if (localObject2 != null)
            {
              str1 = str2;
              if (((SubAccountInfo)localObject2).subuin != null)
              {
                str1 = str2;
                if (!((SubAccountInfo)localObject2).subuin.equalsIgnoreCase(this.aKo)) {}
              }
            }
          }
          else if (!TextUtils.isEmpty(str2))
          {
            str1 = str2;
            if (!str2.equals(this.aKo)) {}
          }
          else
          {
            str1 = aqgv.o(this.g, this.aKo);
          }
          if ((TextUtils.isEmpty(str1)) || (this.aKA.equals(str1)) || (str1.equals(this.aKo))) {
            break label393;
          }
          if ((localaqdj instanceof aqdj)) {
            ((aqdj)localaqdj).setSupportMaskView(false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManageActivity", 2, String.format("updateAccountListView %b [uin,nick]=[%s,%s]", new Object[] { Boolean.valueOf(bool), aqmr.getSimpleUinForPrint(this.aKo), str1 }));
          }
          this.this$0.runOnUiThread(new AccountManageActivity.14.1(this, bool, str1, localBitmap, localaqdj));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Bitmap localBitmap = (Bitmap)AccountManageActivity.a(this.this$0).get(this.aKo);
      aqdj.a(this.g, this.aKo, (byte)1);
      Object localObject1 = null;
      continue;
      label372:
      AccountManageActivity.a(this.this$0).put(this.aKo, localBitmap);
      localObject1 = null;
      continue;
      label393:
      bool = false;
      continue;
      label398:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14
 * JD-Core Version:    0.7.0.1
 */