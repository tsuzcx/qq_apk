import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class alvp
  implements anid
{
  volatile boolean aIJ;
  public String bYG;
  SVHwEncoder c;
  volatile boolean czF;
  boolean czG;
  public int dym;
  Handler handler = new Handler(Looper.getMainLooper());
  int mBusiType;
  SessionInfo mSessionInfo;
  public String mVideoFileSourceDir;
  int mVideoFrames;
  
  alvp(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    this.c = paramSVHwEncoder;
    this.mSessionInfo = paramSessionInfo;
    this.mBusiType = paramInt;
    this.bYG = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public void E(String paramString, int paramInt, long paramLong)
  {
    this.czG = true;
    alvs localalvs = alvs.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.bYG);
    localBundle.putString("full_video_path", paramString);
    localBundle.putInt("video_slices_total_time_length", paramInt);
    localBundle.putLong("video_merge_mp4_time_cost", paramLong);
    localalvs.a(103, -1, localBundle);
    aqip.bj(this.bYG, "clicomp", "CompoundProcessor.svMergeOK[peak] path = " + paramString + ",totalTime = " + paramInt);
  }
  
  public void Ts(int paramInt)
  {
    try
    {
      aqip.bj(this.bYG, "CompoundProcessor.rollBack", "[peak] delReason = " + paramInt);
      jr(1, paramInt);
      dJU();
      return;
    }
    finally {}
  }
  
  public void Tt(int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.czF)
        {
          aqip.bj(this.bYG, "CompoundProcessor.notifySendBtnClicked", "already notified ,return ");
          return;
        }
        this.czF = true;
        this.mVideoFileSourceDir = paramString;
        this.dym = paramInt1;
        this.mVideoFrames = paramInt2;
        if (!this.aIJ)
        {
          Ts(121);
          aqip.bj(this.bYG, "CompoundProcessor.notifySendBtnClicked", "[peak] Thumb not ready,rollback ");
          paramString = alvs.a();
          localBundle = new Bundle();
          localBundle.putString("vidoe_record_uniseq", this.bYG);
          localBundle.putInt("ab_test_video_duration", paramInt1);
          localBundle.putLong("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          localBundle.putLong("video_record_touch_up_time", paramLong);
          localBundle.putInt("video_record_touch_up_times", paramInt3);
          paramString.a(106, -1, localBundle);
          return;
        }
      }
      finally {}
      aniu.a().a().recordSubmit();
      paramString = alvs.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.bYG);
      localBundle.putBoolean("video_full_slice_sync_to_story", paramBoolean);
      paramString.a(105, -1, localBundle);
      aqip.bj(this.bYG, "CompoundProcessor.notifySendBtnClicked ", "[peak] thumb existed");
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramString, paramInt1, paramInt2, paramLong, paramInt3, false);
  }
  
  public void dJU()
  {
    aqip.bj(this.bYG, "CompoundProcessor.cancelEncode", "[peak]  CompoundProcessor");
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.mEncodeRef.getAndSet(null);
    }
    this.c.dPQ();
  }
  
  public void dJV() {}
  
  public void dJW()
  {
    alvs localalvs = alvs.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.bYG);
    localalvs.a(102, -1, localBundle);
    aqip.bj(this.bYG, "CompoundProcessor.svEncodeEnd ", "[peak]all encode end");
  }
  
  public void jr(int paramInt1, int paramInt2)
  {
    alvs localalvs = alvs.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.bYG);
    localBundle.putInt("roll_back_reason", paramInt2);
    if (paramInt1 == 1) {
      localalvs.a().oy(this.bYG);
    }
    localalvs.a(101, paramInt1, localBundle);
    aqip.bj(this.bYG, "CompoundProcessor.cancelPreupload", "[peak] cancelType  = " + paramInt1 + ",cancleReason = " + paramInt2);
  }
  
  /* Error */
  public void js(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	alvp:bYG	Ljava/lang/String;
    //   6: ldc_w 274
    //   9: new 119	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 276
    //   19: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 278
    //   29: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 140	aqip:bj	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 157	alvp:czF	Z
    //   46: ifne +26 -> 72
    //   49: aload_0
    //   50: iconst_1
    //   51: bipush 120
    //   53: invokevirtual 150	alvp:jr	(II)V
    //   56: aload_0
    //   57: getfield 79	alvp:bYG	Ljava/lang/String;
    //   60: ldc_w 274
    //   63: ldc_w 280
    //   66: invokestatic 140	aqip:bj	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: iload_1
    //   73: iconst_m1
    //   74: if_icmpgt +29 -> 103
    //   77: iload_1
    //   78: bipush 233
    //   80: if_icmplt +23 -> 103
    //   83: aload_0
    //   84: iconst_2
    //   85: bipush 122
    //   87: invokevirtual 150	alvp:jr	(II)V
    //   90: aload_0
    //   91: getfield 79	alvp:bYG	Ljava/lang/String;
    //   94: ldc_w 274
    //   97: ldc_w 282
    //   100: invokestatic 140	aqip:bj	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 84	alvp:czG	Z
    //   107: ifne -38 -> 69
    //   110: new 284	com/tencent/mobileqq/richmedia/CompoundProcessor$1
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 287	com/tencent/mobileqq/richmedia/CompoundProcessor$1:<init>	(Lalvp;)V
    //   118: bipush 8
    //   120: aconst_null
    //   121: iconst_1
    //   122: invokestatic 293	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   125: goto -56 -> 69
    //   128: astore_3
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	alvp
    //   0	133	1	paramInt1	int
    //   0	133	2	paramInt2	int
    //   128	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	69	128	finally
    //   69	71	128	finally
    //   83	103	128	finally
    //   103	125	128	finally
    //   129	131	128	finally
  }
  
  public void m(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    alvs localalvs = alvs.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("video_slice_path", paramString);
    localBundle.putInt("video_slice_index", paramInt1);
    localBundle.putInt("video_slice_width", paramInt2);
    localBundle.putInt("video_slice_height", paramInt3);
    localBundle.putString("vidoe_record_uniseq", this.bYG);
    localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.mSessionInfo);
    localalvs.a(100, -1, localBundle);
    aqip.bj(this.bYG, "segment", "CompoundProcessor.svSegmentOK [peak] index = " + paramInt1 + ",path = " + paramString + ",width = " + paramInt2 + ",height = " + paramInt3);
  }
  
  public String mY(String paramString)
  {
    aniq.dHk = this.mVideoFrames;
    aniq.bQi = this.dym;
    Object localObject = new EncodeThread(null, new alvp.a(Looper.getMainLooper()), paramString, null, null);
    ((EncodeThread)localObject).run();
    localObject = ((EncodeThread)localObject).cdZ;
    aqip.bj(this.bYG, "CompoundProcessor.compressYUV2MP4", "[peak] videoFileDir = " + paramString + ",videoPath = " + (String)localObject + ",CodecParam.mRecordFrames = " + aniq.dHk + ",CodecParam.mRecordTime = " + aniq.bQi);
    return localObject;
  }
  
  public void n(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      this.aIJ = true;
      alvs localalvs = alvs.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.bYG);
      localBundle.putString("video_thumb_path", paramString1);
      localBundle.putInt("video_thumb_width", paramInt1);
      localBundle.putInt("video_thumb_height", paramInt2);
      localBundle.putInt("video_busi_type", this.mBusiType);
      localBundle.putString("video_thumb_md5", paramString2);
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.mSessionInfo);
      localalvs.a(104, -1, localBundle);
      aqip.bj(this.bYG, "CompoundProcessor.svThumbOK", "[peak] path = " + paramString1 + ",width = " + paramInt1 + ",height = " + paramInt2 + ",md5 = " + paramString2);
      return;
    }
    finally {}
  }
  
  public String yB()
  {
    return this.bYG;
  }
  
  static class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      alvr.d("CompoundProcessor", "handleMessage, msg.what = " + paramMessage.what + ",msg.arg1 = " + paramMessage.arg1);
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 2: 
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
        alvr.d("CompoundProcessor", "ret is " + i + ",data is " + paramMessage);
        return;
      }
      int i = paramMessage.arg1;
      switch (paramMessage.arg1)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
      alvr.d("CompoundProcessor", "ret is " + i + ",targetFile is " + paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvp
 * JD-Core Version:    0.7.0.1
 */