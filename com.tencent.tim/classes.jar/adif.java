import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.DrawView2.a;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adif
  implements Handler.Callback
{
  adif(adie paramadie) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1;
    long l2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label292:
    Object localObject5;
    Object localObject6;
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      l1 = System.currentTimeMillis();
      this.this$0.bNo = true;
      paramMessage = (byte[])paramMessage.obj;
      int j = 0;
      l2 = SystemClock.uptimeMillis();
      localObject2 = this.this$0.b.detectFace(paramMessage, this.this$0.previewWidth, this.this$0.previewHeight, this.this$0.bpO);
      l2 = SystemClock.uptimeMillis() - l2;
      adic.iE(l2);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFace[TimeCost] = " + l2);
      }
      if ((localObject2 != null) && (localObject2.length > 0) && (QLog.isColorLevel())) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + localObject2.length);
      }
      ??? = this.this$0.a((FaceStatus[])localObject2);
      this.this$0.a((FaceStatus[])???, (FaceStatus[])localObject2);
      if ((??? != null) && (???.length > 0) && (!this.this$0.mIsPause))
      {
        j = ???.length;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + j);
        }
        localObject3 = new float[j][];
        localObject4 = new float[j][];
        localObject2 = this.this$0.cY;
        i = 0;
        if (i < j) {
          try
          {
            if (!this.this$0.a(this.this$0.yk, ???[i]))
            {
              localObject5 = new adie.b();
              ((adie.b)localObject5).bNp = true;
              ((adie.b)localObject5).faceID = this.this$0.cGp;
              localObject6 = this.this$0;
              ((adie)localObject6).cGp += 1;
              ((adie.b)localObject5).d = ???[i];
              this.this$0.yl.add(localObject5);
              localObject3[i] = ???[i].xys;
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = " + ((adie.b)localObject5).faceID);
              }
            }
            else if (???[i].nativeFaceAlignmentPtr != 0L)
            {
              this.this$0.b.releaseNativeFaceStatus(???[i]);
            }
          }
          finally {}
        }
        if ((this.this$0.cF != null) && (this.this$0.cF.hasMessages(1))) {
          this.this$0.cF.removeMessages(1);
        }
        paramMessage = Message.obtain(this.this$0.cF, new ARLocalFaceRecog.1.1(this, j, (float[][])localObject3, (float[][])localObject4, paramMessage));
        paramMessage.what = 1;
        i = j;
        if (this.this$0.cF != null)
        {
          this.this$0.cF.sendMessage(paramMessage);
          i = j;
        }
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE finish, faceCount = " + i + ",recoverMsgExeCost = " + (l2 - l1));
        break;
        this.this$0.bNo = false;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
          i = j;
        }
      }
    case 3: 
      if ((QLog.isColorLevel()) && (adie.bNm)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
      }
      l1 = System.currentTimeMillis();
      this.this$0.isTracking = true;
      localObject2 = (byte[])paramMessage.obj;
      paramMessage = new ArrayList();
      synchronized (this.this$0.cY)
      {
        localObject3 = this.this$0.yk.iterator();
        label726:
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label1404;
          }
          localObject4 = (adie.b)((Iterator)localObject3).next();
          if (!((adie.b)localObject4).bNp) {
            break label1284;
          }
          if ((QLog.isColorLevel()) && (adie.bNm)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.this$0.b.trackSingleFace2((byte[])localObject2, this.this$0.previewWidth, this.this$0.previewHeight, ((adie.b)localObject4).d, this.this$0.bpO);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (adie.bNm))
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = " + l2);
            adap.a().iy(l2);
          }
          if (i == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = " + ((adie.b)localObject4).cGr);
          }
          ((adie.b)localObject4).cGr += 1;
        } while (((adie.b)localObject4).cGr <= 0);
        ((adie.b)localObject4).bNp = false;
        ((adie.b)localObject4).cGr = 0;
        localObject4 = this.this$0;
        ((adie)localObject4).cGn += 1;
      }
      ((adie.b)localObject4).cGr = 0;
      if ((QLog.isColorLevel()) && (adie.bNm)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
      }
      localObject5 = new DrawView2.a();
      ((DrawView2.a)localObject5).bV = ((adie.b)localObject4).d.xys;
      ((DrawView2.a)localObject5).name = ((adie.b)localObject4).name;
      ((DrawView2.a)localObject5).by = new Rect(((adie.b)localObject4).d.x, ((adie.b)localObject4).d.y, ((adie.b)localObject4).d.x + ((adie.b)localObject4).d.width, ((adie.b)localObject4).d.y + ((adie.b)localObject4).d.height);
      ((DrawView2.a)localObject5).as = DrawView2.a.a(((DrawView2.a)localObject5).by, ((adie.b)localObject4).d.xys);
      ((DrawView2.a)localObject5).faceID = ((adie.b)localObject4).faceID;
      ((DrawView2.a)localObject5).enName = ((adie.b)localObject4).bsV;
      ((DrawView2.a)localObject5).uin = ((adie.b)localObject4).uin;
      ((DrawView2.a)localObject5).bsx = ((adie.b)localObject4).bsY;
      if (((adie.b)localObject4).faceType != 2) {}
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      ((DrawView2.a)localObject5).isStar = bool;
      if (((DrawView2.a)localObject5).isStar)
      {
        ((DrawView2.a)localObject5).bMu = this.this$0.kW(((DrawView2.a)localObject5).uin);
        if (((DrawView2.a)localObject5).bMu)
        {
          localObject6 = this.this$0.a(((DrawView2.a)localObject5).uin);
          if (localObject6 != null)
          {
            ((DrawView2.a)localObject5).imgUrl = ((ARScanStarFaceActInfo)localObject6).bsL;
            ((DrawView2.a)localObject5).url = ((ARScanStarFaceActInfo)localObject6).bsK;
          }
        }
        ((DrawView2.a)localObject5).bsv = ((adie.b)localObject4).bsX;
        ((DrawView2.a)localObject5).bsw = ((adie.b)localObject4).bsW;
      }
      ((DrawView2.a)localObject5).confidence = ((adie.b)localObject4).confidence;
      paramMessage.add(localObject5);
      break label726;
      label1284:
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Try to recover realFace, isRecovering = " + this.this$0.bNo);
      }
      if ((this.this$0.bNo) || (this.this$0.mIsPause)) {
        break label726;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
      }
      if (adie.handler.hasMessages(1)) {
        adie.handler.removeMessages(1);
      }
      localObject4 = Message.obtain();
      ((Message)localObject4).what = 1;
      ((Message)localObject4).obj = localObject2;
      adie.handler.sendMessage((Message)localObject4);
      break label726;
      label1404:
      localObject3 = this.this$0.yl.iterator();
      long l3;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (adie.b)((Iterator)localObject3).next();
        if (((adie.b)localObject4).bNp)
        {
          if ((QLog.isColorLevel()) && (adie.bNm)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.this$0.b.trackSingleFace2((byte[])localObject2, this.this$0.previewWidth, this.this$0.previewHeight, ((adie.b)localObject4).d, this.this$0.bpO);
          l3 = SystemClock.uptimeMillis();
          if ((QLog.isColorLevel()) && (adie.bNm)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = " + (l3 - l2));
          }
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
            }
            ((adie.b)localObject4).bNp = false;
            ((Iterator)localObject3).remove();
            if ((((adie.b)localObject4).d != null) && (((adie.b)localObject4).d.nativeFaceAlignmentPtr != 0L)) {
              FaceCluster.getInstance().releaseNativeFaceStatus(((adie.b)localObject4).d);
            }
          }
          else
          {
            if ((QLog.isColorLevel()) && (adie.bNm)) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = " + ((adie.b)localObject4).faceID);
            }
            localObject5 = new DrawView2.a();
            ((DrawView2.a)localObject5).bV = ((adie.b)localObject4).d.xys;
            ((DrawView2.a)localObject5).name = ((adie.b)localObject4).name;
            ((DrawView2.a)localObject5).faceID = ((adie.b)localObject4).faceID;
            ((DrawView2.a)localObject5).by = new Rect(((adie.b)localObject4).d.x, ((adie.b)localObject4).d.y, ((adie.b)localObject4).d.x + ((adie.b)localObject4).d.width, ((adie.b)localObject4).d.y + ((adie.b)localObject4).d.height);
            ((DrawView2.a)localObject5).as = DrawView2.a.a(((DrawView2.a)localObject5).by, ((adie.b)localObject4).d.xys);
            ((DrawView2.a)localObject5).bMw = true;
            paramMessage.add(localObject5);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
        }
      }
      l2 = System.currentTimeMillis();
      if ((!this.this$0.mIsPause) && (this.this$0.a != null))
      {
        ??? = new adig();
        ((adig)???).us = paramMessage;
        ((adig)???).Tl = this.this$0.Tj;
        this.this$0.a.a((adig)???);
        if ((this.this$0.Tk > 0L) && (paramMessage.size() > 0))
        {
          l3 = System.currentTimeMillis() - this.this$0.Tk;
          adic.a().Th = l3;
          adic.cRR();
          this.this$0.Tk = -1L;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = " + l3);
          }
        }
      }
      this.this$0.isTracking = false;
      if ((!QLog.isColorLevel()) || (!adie.bNm)) {
        break;
      }
      QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE finish, dataSize = " + paramMessage.size() + ",trackMsgExeCost = " + (l2 - l1) + ",curTrackFrameIndex = " + this.this$0.Tj + ",mIsPause = " + this.this$0.mIsPause);
      break;
      i += 1;
      break label292;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adif
 * JD-Core Version:    0.7.0.1
 */