package com.tencent.mobileqq.ar.arengine;

import adht;
import adht.a;
import adie;
import adie.b;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(adie paramadie, adht paramadht, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.cY)
    {
      this.this$0.jz(this.this$0.yk);
      this.this$0.jz(this.this$0.yl);
      this.this$0.cGp = 10;
      this.this$0.b = this.c;
      if ((this.this$0.b == null) || (this.this$0.b.b == null)) {}
    }
    for (;;)
    {
      int i;
      adie.b localb;
      synchronized (this.this$0.cY)
      {
        if (this.this$0.b.b.length > 2)
        {
          this.this$0.a(this.this$0.yk, this.this$0.b);
          this.this$0.b(this.this$0.yk, this.this$0.b);
          long l1 = System.currentTimeMillis();
          long l2 = this.val$start;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = " + this.this$0.yk + ",addFaceClouDResultCost = " + (l1 - l2));
          }
          this.this$0.Tk = System.currentTimeMillis();
          this.this$0.bNn = false;
          return;
          localObject2 = finally;
          throw localObject2;
        }
        i = 0;
        if (i >= this.this$0.b.b.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.b.b[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localb = new adie.b();
        localb.faceType = 1;
        localb.name = "";
        if (this.this$0.b.ur != null)
        {
          Iterator localIterator = this.this$0.b.ur.iterator();
          if (localIterator.hasNext())
          {
            adht.a locala = (adht.a)localIterator.next();
            if (locala.faceID != i) {
              continue;
            }
            localb.faceType = 2;
            localb.name = locala.name;
            localb.bsV = locala.bsV;
            localb.uin = String.valueOf(locala.uin);
            localb.bsW = locala.bsW;
            localb.bsX = locala.bsX;
            localb.bsY = locala.bsY;
            localb.confidence = locala.confidence;
          }
        }
      }
      localb.bNp = true;
      localb.d = localObject3;
      localb.faceID = i;
      this.this$0.yk.add(localb);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */