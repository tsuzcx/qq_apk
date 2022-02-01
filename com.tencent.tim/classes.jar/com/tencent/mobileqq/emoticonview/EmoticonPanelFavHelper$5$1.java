package com.tencent.mobileqq.emoticonview;

import afhf;
import afna;
import afnc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelFavHelper$5$1
  implements Runnable
{
  public EmoticonPanelFavHelper$5$1(afnc paramafnc, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.val$data).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        QQToast.a(BaseApplicationImpl.sApplication, 1, i, 0).show(this.a.this$0.a.cSg);
      }
      break;
    }
    do
    {
      return;
      i = 2131693062;
      break;
      i = 2131693064;
      break;
      i = 2131693066;
      break;
      i = 2131693065;
      break;
      i = 2131693061;
      break;
      i = 2131693063;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.bXX), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(this.a.this$0.a.ajo) });
    } while ((CameraEmoAllSend.bXX) || (!this.a.this$0.a.ajo));
    CameraEmoAllSend.bXX = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      afhf.a(this.a.this$0.a.app, this.a.this$0.a.context, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
 * JD-Core Version:    0.7.0.1
 */