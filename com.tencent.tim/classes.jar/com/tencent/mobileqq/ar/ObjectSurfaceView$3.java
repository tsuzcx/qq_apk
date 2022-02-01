package com.tencent.mobileqq.ar;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

class ObjectSurfaceView$3
  implements Runnable
{
  ObjectSurfaceView$3(ObjectSurfaceView paramObjectSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ObjectSurfaceView.a(this.this$0).size() > 0)
    {
      ObjectSurfaceView.b(this.this$0).add(this.val$uin);
      ObjectSurfaceView.a(this.this$0, this.val$url);
      return;
    }
    QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */