import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.1;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.2;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

@TargetApi(18)
public class ambu
  extends ambs
  implements Handler.Callback
{
  private ambt a;
  public CameraCaptureView a;
  private long aip;
  private long aiq;
  private long air;
  private long ais;
  private long ait;
  private long aiu;
  public MqqHandler b;
  private String bN;
  private boolean bQU;
  private String bZK;
  public alvs c;
  private boolean cBW;
  private boolean cBX;
  private boolean cBY;
  private boolean cBZ = true;
  private final boolean cCa;
  private String mAudioPath;
  public HashMap<String, String> mM = new HashMap();
  private MediaMuxer mMediaMuxer;
  SessionInfo mSessionInfo;
  private int mTrackIndex;
  private long mVideoDuration;
  private String mVideoPath;
  private ArrayList<ambt> zf = new ArrayList();
  
  public ambu(CameraCaptureView paramCameraCaptureView, long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.c = alvs.a();
    this.mSessionInfo = ((SessionInfo)((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO"));
    this.b = new MqqHandler(ThreadManagerV2.getFileThreadLooper(), this);
    this.cCa = true;
    QLog.d("SegmentManager", 1, "SegmentManager,mSegmentMode:" + this.cCa);
  }
  
  private void c(String paramString, MediaFormat paramMediaFormat)
  {
    ThreadManagerV2.executeOnFileThread(new SegmentManager.1(this, paramString, paramMediaFormat));
  }
  
  private void dMj()
  {
    try
    {
      if ((this.cBW) && (this.mAudioPath != null) && (this.cCa) && (!this.cBY))
      {
        this.cBY = true;
        Bundle localBundle = p();
        this.c.a(201, -1, localBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "sendAudioFinishedMsg");
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g(MediaFormat paramMediaFormat)
  {
    try
    {
      if ((this.mAudioPath != null) && (this.bN != null) && (this.mVideoPath != null) && (!this.cBX))
      {
        this.cBX = true;
        ThreadManagerV2.excute(new SegmentManager.2(this, paramMediaFormat), 64, null, true);
      }
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  private Bundle p()
  {
    Bundle localBundle = new Bundle();
    if (this.cCa) {}
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("video_segment_mode", i);
      localBundle.putLong("vidoe_record_uniseq", this.mSeed);
      localBundle.putBoolean("video_segment_capture_success", this.cBZ);
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.mSessionInfo);
      return localBundle;
    }
  }
  
  public void Uk(int paramInt)
  {
    this.mM.put("param_audio_error", String.valueOf(-6));
    long l;
    AudioEncoder.a locala;
    if (this.bZK != null)
    {
      l = SystemClock.uptimeMillis();
      locala = new AudioEncoder.a();
      locala.cey = this.bZK;
      locala.cez = getAudioPath();
      locala.dIG = 0;
      locala.sample_rate = paramInt;
      locala.bitrate = aniq.dHj;
      if (aniq.mAudioFormat != 2) {
        break label178;
      }
      locala.dIH = 16;
      if (aniq.ckG != 16) {
        break label188;
      }
      locala.dII = 1;
      label101:
      paramInt = AudioEncoder.el(this.bZK);
      if (paramInt == 0) {
        break label197;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "onEncodeAudioError checkSourceAudioIsOK  failed:" + paramInt);
      }
      this.mM.put("param_audio_error", String.valueOf(paramInt));
    }
    for (;;)
    {
      this.mAudioPath = "AUDIO_PROBLEM";
      g(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat());
      return;
      label178:
      locala.dIH = 8;
      break;
      label188:
      locala.dII = 2;
      break label101;
      label197:
      paramInt = AudioEncoder.a(locala);
      if (paramInt == 0) {
        break label256;
      }
      this.mM.put("param_audio_error", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "AudioEncoder.encodeSafely failed:" + paramInt);
      }
    }
    label256:
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudioError encodeSafely succ,  cost :" + (SystemClock.uptimeMillis() - l));
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat(), getAudioPath());
  }
  
  public void a(ambt paramambt, boolean paramBoolean, MediaFormat paramMediaFormat)
  {
    int i = paramambt.getIndex();
    long l = paramambt.getTimeStamp();
    String str = paramambt.yL();
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeVideoSegment:" + paramambt);
    }
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    paramambt = p();
    paramambt.putString("video_slice_path", str);
    paramambt.putInt("video_slice_index", i);
    paramambt.putInt("video_slice_width", j);
    paramambt.putInt("video_slice_height", k);
    paramambt.putLong("video_slice_timestamp", l);
    this.c.a(200, -1, paramambt);
    if (i == 0) {
      c(str, paramMediaFormat);
    }
    if (paramBoolean)
    {
      this.aiu = System.currentTimeMillis();
      this.cBW = true;
      paramambt = p();
      this.c.a(204, -1, paramambt);
      dMj();
    }
  }
  
  public void a(MediaFormat paramMediaFormat, String paramString)
  {
    this.mAudioPath = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudio:" + this.mAudioPath);
    }
    this.ais = System.currentTimeMillis();
    dMj();
    g(paramMediaFormat);
  }
  
  public void a(String paramString, MediaFormat paramMediaFormat)
  {
    this.mVideoPath = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeVideo:" + paramString + " mSegmentMode:" + this.cCa + " mSegmentEncodeSuc:" + this.cBZ + " mThumbPath:" + this.bN);
    }
    this.ait = System.currentTimeMillis();
    if (!this.cCa) {
      c(paramString, paramMediaFormat);
    }
    for (;;)
    {
      g(paramMediaFormat);
      return;
      if ((!this.cBZ) && (this.bN == null)) {
        c(paramString, paramMediaFormat);
      }
    }
  }
  
  public boolean avk()
  {
    return this.cCa;
  }
  
  public void b(String paramString, MediaFormat paramMediaFormat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudioPCM:" + paramString);
    }
    this.bZK = paramString;
  }
  
  public void bme()
  {
    this.bQU = true;
    this.b.removeCallbacksAndMessages(null);
    if (this.mMediaMuxer != null) {}
    try
    {
      this.mMediaMuxer.release();
      this.mMediaMuxer = null;
      Bundle localBundle = p();
      this.c.a(208, -1, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "cancelTask");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.cBZ) {}
    while (this.bQU) {
      return true;
    }
    int i;
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        i = this.zf.size();
        this.jdField_a_of_type_Ambt = new ambt(getBasePath(), i);
        this.zf.add(this.jdField_a_of_type_Ambt);
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "Muxer_Start :" + this.jdField_a_of_type_Ambt);
        }
        this.mMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Ambt.yL(), 0);
        this.mTrackIndex = this.mMediaMuxer.addTrack((MediaFormat)paramMessage.obj);
        this.mMediaMuxer.start();
        return true;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "onSegmentEncodeError");
      }
      this.mM.put("param_segment_fail_flag", "1");
      this.cBZ = false;
      g(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat());
      return true;
    }
    paramMessage = (amag.a)paramMessage.obj;
    MediaCodec.BufferInfo localBufferInfo = paramMessage.d;
    if (localBufferInfo.flags != 1) {
      if (localBufferInfo.flags != 1) {
        break label506;
      }
    }
    for (;;)
    {
      long l = localBufferInfo.presentationTimeUs;
      if (n(l, bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "Muxer_Data needSegment timeStamp:" + l);
        }
        this.aip = 0L;
        this.mMediaMuxer.release();
        a(this.jdField_a_of_type_Ambt, false, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat());
        i = this.zf.size();
        this.jdField_a_of_type_Ambt = new ambt(getBasePath(), i);
        this.zf.add(this.jdField_a_of_type_Ambt);
        this.mMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Ambt.yL(), 0);
        this.mTrackIndex = this.mMediaMuxer.addTrack(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat());
        this.mMediaMuxer.start();
      }
      this.jdField_a_of_type_Ambt.b(paramMessage);
      this.mMediaMuxer.writeSampleData(this.mTrackIndex, paramMessage.u, paramMessage.d);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "Muxer_Stop :" + this.jdField_a_of_type_Ambt);
      }
      this.mMediaMuxer.release();
      a(this.jdField_a_of_type_Ambt, true, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getMediaFormat());
      return true;
      return true;
      boolean bool = true;
      continue;
      label506:
      bool = false;
    }
  }
  
  public void l(int paramInt, long paramLong1, long paramLong2)
  {
    this.mVideoDuration = (paramLong2 - paramLong1);
    this.air = paramLong2;
    Bundle localBundle = p();
    localBundle.putLong("video_duration", this.mVideoDuration);
    localBundle.putLong("video_start_time", paramLong2);
    this.c.a(207, -1, localBundle);
    ainc.dsY();
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "confirmTask");
    }
  }
  
  public boolean n(long paramLong, boolean paramBoolean)
  {
    if (!this.cCa) {}
    do
    {
      return false;
      if (this.aip == 0L) {
        this.aip = paramLong;
      }
      this.aiq = paramLong;
    } while ((this.aiq - this.aip < 1500000L) || (!paramBoolean));
    this.aip = 0L;
    return true;
  }
  
  public void onError()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onError");
    }
    Bundle localBundle = p();
    this.c.a(206, -1, localBundle);
    bme();
    ((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambu
 * JD-Core Version:    0.7.0.1
 */