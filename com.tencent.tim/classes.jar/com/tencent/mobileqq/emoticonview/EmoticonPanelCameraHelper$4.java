package com.tencent.mobileqq.emoticonview;

import afmn;
import afoo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelCameraHelper$4
  implements Runnable
{
  public EmoticonPanelCameraHelper$4(afmn paramafmn) {}
  
  public void run()
  {
    List localList = this.this$0.a.zZ;
    int i;
    afoo localafoo;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localafoo = (afoo)localList.get(i);
        if ((localafoo == null) || (localafoo.type != 11)) {}
      }
    }
    for (;;)
    {
      if ((localafoo != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.d(localafoo);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localafoo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.4
 * JD-Core Version:    0.7.0.1
 */