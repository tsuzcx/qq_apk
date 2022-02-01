package com.tencent.mobileqq.flutter.engine;

import ahfq;
import android.content.res.Resources;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QFlutterResourceLoaderNativeImp$1
  implements Runnable
{
  public QFlutterResourceLoaderNativeImp$1(ahfq paramahfq, ArrayList paramArrayList, Resources paramResources) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.wQ.clear();
    Iterator localIterator = ahfq.lb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.wQ.add(this.g.getColorStateList(((Integer)ahfq.lb.get(str)).intValue()));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "init and preCache colors cost:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.engine.QFlutterResourceLoaderNativeImp.1
 * JD-Core Version:    0.7.0.1
 */