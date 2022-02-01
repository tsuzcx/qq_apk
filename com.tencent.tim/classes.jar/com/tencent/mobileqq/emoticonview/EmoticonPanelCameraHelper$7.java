package com.tencent.mobileqq.emoticonview;

import afgw;
import afmn;
import android.content.Context;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;

public class EmoticonPanelCameraHelper$7
  implements Runnable
{
  public EmoticonPanelCameraHelper$7(afmn paramafmn, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((!aqiw.isNetSupport(this.val$context)) || (this.val$app == null)) {
      return;
    }
    ((afgw)this.val$app.getManager(334)).cYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.7
 * JD-Core Version:    0.7.0.1
 */