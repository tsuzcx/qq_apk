package com.tencent.mobileqq.ar;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

class ObjectSurfaceView$4
  implements Runnable
{
  ObjectSurfaceView$4(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData) {}
  
  public void run()
  {
    if (ObjectSurfaceView.a(this.this$0).size() > 0)
    {
      ObjectSurfaceView.a(this.this$0, this.a.bsx);
      return;
    }
    QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */