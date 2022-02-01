package com.tencent.av.utils;

import acle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqwu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yir;

final class VideoMsgTools$3
  implements Runnable
{
  VideoMsgTools$3(int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((this.aBm == 12) || (this.aBm == 25) || (this.aBm == 42) || (this.aBm == 43) || (this.aBm == 56)) {
      aqwu.i(this.val$app, 0);
    }
    int i = ((acle)this.val$app.getBusinessHandler(13)).AX();
    Object localObject;
    if (i == 2)
    {
      if ((this.aal) || ((this.aBm != 0) && (this.aBm != 2) && (this.aBm != 24)) || (this.SU == null) || (!yir.TE())) {
        break label416;
      }
      localObject = this.val$app.getPreferences();
      if (((SharedPreferences)localObject).getBoolean("lightalk_tip_" + this.val$selfUin, false)) {
        break label416;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightalkBlueTipsBar", 2, "addBubbleVideoMsg() : TYPE_ON_SHOW =====>");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("lightalk_tip_" + this.val$selfUin, true);
      ((SharedPreferences.Editor)localObject).putString("Lightalk_tips_frdUin", this.SO);
      ((SharedPreferences.Editor)localObject).commit();
    }
    label416:
    for (i = 1;; i = 0)
    {
      int j = aqwu.e(this.val$app);
      int k = aqwu.a(this.val$app, this.val$app.getAccount(), 6, true, null);
      if ((j != 0) && (j != k))
      {
        k = aqwu.a(this.val$app, this.SO, this.val$app.getAccount());
        if (((j == 0) || (k == 0)) || ((!this.aal) && (i == 0)))
        {
          localObject = this.val$app.getPreferences();
          i = ((SharedPreferences)localObject).getInt("funcall_tip_" + this.SO, 0);
          if (i < 3)
          {
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putInt("funcall_tip_" + this.SO, i + 1);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
      return;
      if (i != 3) {
        break;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.3
 * JD-Core Version:    0.7.0.1
 */