package com.tencent.mobileqq.ar.arengine;

import adap;
import adic;
import adie;
import adie.b;
import adif;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class ARLocalFaceRecog$1$1
  implements Runnable
{
  public ARLocalFaceRecog$1$1(adif paramadif, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    if (i < this.cGq)
    {
      if ((this.b[i] != null) && (!this.a.this$0.mIsPause))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.c[i] = this.a.this$0.b.calcuFaceFeature(this.val$data, this.a.this$0.previewWidth, this.a.this$0.previewHeight, this.b[i], this.a.this$0.bpO);
        l = SystemClock.uptimeMillis() - l;
        adic.iF(l);
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + l);
          adap.a().ix(l);
          if (this.c[i] != null) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "  calcuFaceFeature feature = " + Arrays.toString(this.c[i]));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  faceShape is null i = " + i);
        }
      }
    }
    for (;;)
    {
      adie.b localb1;
      adie.b localb2;
      synchronized (this.a.this$0.cY)
      {
        Object localObject2 = this.a.this$0.yk;
        i = ((List)localObject2).size();
        if ((i > 0) && (!this.a.this$0.mIsPause))
        {
          if (i != 1) {
            continue;
          }
          localObject2 = (adie.b)((List)localObject2).get(0);
          if ((this.a.this$0.a((adie.b)localObject2, this.c, this.b)) && (adie.handler.hasMessages(1))) {
            adie.handler.removeMessages(1);
          }
        }
        this.a.this$0.jz(this.a.this$0.yl);
        this.a.this$0.cGp = 10;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
        }
        this.a.this$0.bNo = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
        }
        return;
        if (i != 2) {
          continue;
        }
        localb1 = (adie.b)((List)localObject2).get(0);
        localb2 = (adie.b)((List)localObject2).get(1);
        if ((!localb1.bNp) && (localb2.bNp))
        {
          if ((!this.a.this$0.a(localb1, this.c, this.b)) || (!adie.handler.hasMessages(1))) {
            continue;
          }
          adie.handler.removeMessages(1);
        }
      }
      if ((localb1.bNp) && (!localb2.bNp))
      {
        if ((this.a.this$0.a(localb2, this.c, this.b)) && (adie.handler.hasMessages(1))) {
          adie.handler.removeMessages(1);
        }
      }
      else if ((!localb1.bNp) && (!localb2.bNp))
      {
        i = this.a.this$0.a(this.c, localb1.d.feature);
        int j = this.a.this$0.a(this.c, localb2.d.feature);
        if ((i < 0) && (j < 0)) {}
        for (;;)
        {
          if ((!this.a.this$0.an(localList)) || (!adie.handler.hasMessages(1))) {
            break label1029;
          }
          adie.handler.removeMessages(1);
          break;
          if ((i >= 0) && (j < 0))
          {
            localb1.d.xys = this.b[i];
            localb1.bNp = true;
          }
          else if ((i < 0) && (j >= 0))
          {
            localb2.d.xys = this.b[j];
            localb2.bNp = true;
          }
          else if (i == j)
          {
            float f1 = this.a.this$0.b.calcuSimilarity(this.c[i], localb1.d.feature);
            float f2 = this.a.this$0.b.calcuSimilarity(this.c[j], localb2.d.feature);
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + f1 + ",similarity2 = " + f2);
            }
            if (f1 > f2)
            {
              localb1.d.xys = this.b[i];
              localb1.bNp = true;
              this.c[i] = null;
              this.a.this$0.a(localb2, this.c, this.b);
            }
            else
            {
              localb2.d.xys = this.b[j];
              localb2.bNp = true;
              this.c[j] = null;
              this.a.this$0.a(localb1, this.c, this.b);
            }
          }
          else
          {
            localb1.d.xys = this.b[i];
            localb1.bNp = true;
            localb2.d.xys = this.b[j];
            localb2.bNp = true;
          }
        }
      }
      else
      {
        label1029:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
 * JD-Core Version:    0.7.0.1
 */