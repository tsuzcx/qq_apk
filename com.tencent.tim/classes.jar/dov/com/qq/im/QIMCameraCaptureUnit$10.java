package dov.com.qq.im;

import android.media.MediaFormat;
import aqhq;
import awrq;
import awrr;
import azcc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rqt;

public class QIMCameraCaptureUnit$10
  implements Runnable
{
  public QIMCameraCaptureUnit$10(awrq paramawrq, List paramList) {}
  
  public void run()
  {
    rqt localrqt = new rqt();
    ArrayList localArrayList1 = new ArrayList(this.val$results.size());
    ArrayList localArrayList2 = new ArrayList(this.val$results.size());
    this.this$0.c = new CameraCaptureView.VideoCaptureResult();
    Object localObject1 = this.val$results.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CameraCaptureView.VideoCaptureResult)((Iterator)localObject1).next();
      localArrayList1.add(((CameraCaptureView.VideoCaptureResult)localObject2).videoMp4FilePath);
      if (!((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath.endsWith("/noaudio")) {
        localArrayList2.add(((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath);
      }
      CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.this$0.c;
      int i = localVideoCaptureResult.videoFrameCount;
      localVideoCaptureResult.videoFrameCount = (((CameraCaptureView.VideoCaptureResult)localObject2).videoFrameCount + i);
    }
    if (this.this$0.yI() != null)
    {
      localObject2 = this.this$0.yI() + "/" + System.currentTimeMillis() + ".mp4";
      if (localArrayList2.size() != this.val$results.size()) {
        break label509;
      }
      localObject1 = this.this$0.yI() + File.separator + "audio_data_cache" + File.separator + azcc.Ab();
      localrqt.c(localArrayList2, (String)localObject1);
      this.this$0.c.audioDataFilePath = ((String)localObject1);
      this.this$0.c.videoMp4FilePath = ((String)localObject2);
      this.this$0.c.type = ((CameraCaptureView.VideoCaptureResult)this.val$results.get(0)).type;
      this.this$0.c.orientation = ((CameraCaptureView.VideoCaptureResult)this.val$results.get(0)).orientation;
      awrq.a(this.this$0, new LocalMediaInfo());
      awrq.a(this.this$0).path = this.this$0.c.videoMp4FilePath;
      awrq.a(this.this$0).mMimeType = "video";
      localObject1 = this.this$0.b.getMediaFormat();
      if (localObject1 == null) {
        break label562;
      }
      bool = localrqt.a(localArrayList1, (String)localObject2, 0, 0, (MediaFormat)localObject1);
      if (!AudioHelper.aCA()) {
        break label542;
      }
      awrq.a(this.this$0).mTransferPosList = localrqt.a(localArrayList1, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment video merge result: " + bool);
      }
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new awrr(this), awrq.a(this.this$0));
    }
    label509:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        boolean bool;
        return;
        localObject1 = this.this$0.yI() + "/noaudio";
        aqhq.UD((String)localObject1);
        break;
        awrq.a(this.this$0).mTransferPosList = localrqt.q(localArrayList1);
      }
    }
    label542:
    label562:
    QLog.e("QIMCameraCaptureUnit", 2, "[segmentCapture]onSegmentVideoCaptured mediaFormat null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.10
 * JD-Core Version:    0.7.0.1
 */