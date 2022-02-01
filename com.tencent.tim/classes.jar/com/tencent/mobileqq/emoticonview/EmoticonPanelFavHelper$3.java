package com.tencent.mobileqq.emoticonview;

import afim;
import afna;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelFavHelper$3
  implements Runnable
{
  public EmoticonPanelFavHelper$3(afna paramafna) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.a.app;
    if (localQQAppInterface != null)
    {
      ((afim)localQQAppInterface.getManager(141)).cZP();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelFavHelper", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3
 * JD-Core Version:    0.7.0.1
 */