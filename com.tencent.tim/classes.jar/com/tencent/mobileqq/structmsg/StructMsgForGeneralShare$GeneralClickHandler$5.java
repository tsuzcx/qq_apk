package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import aprg;
import com.tencent.mobileqq.app.QQAppInterface;

class StructMsgForGeneralShare$GeneralClickHandler$5
  implements Runnable
{
  StructMsgForGeneralShare$GeneralClickHandler$5(StructMsgForGeneralShare.a parama, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str2 = aprg.bN(this.val$strUrl, "robot_uin");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    aprg.d(this.val$app, "0X8009FA4", str1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.5
 * JD-Core Version:    0.7.0.1
 */