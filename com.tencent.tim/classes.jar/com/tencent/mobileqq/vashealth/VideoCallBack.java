package com.tencent.mobileqq.vashealth;

import aaqj;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import aqfy;
import aquf;
import arhz;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class VideoCallBack
  implements aaqj
{
  private String mRefer;
  
  static void dQ(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      aniq.dFI = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      aniq.dFJ = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      aniq.dFK = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      aniq.dFL = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      aniq.dFM = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      aniq.dFN = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      aniq.dFO = i;
    }
    aniq.dHo = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    aniq.dHp = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    aniq.dHq = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    aniq.dHr = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    aniq.dHs = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    aniq.dHk = paramIntent.getIntExtra("sv_total_frame_count", 0);
    aniq.bQi = paramIntent.getIntExtra("sv_total_record_time", 0);
  }
  
  public void aG(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    String str2 = ((BaseActivity)paramActivity).getAppRuntime().getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localIntent.putExtra("PhotoConst.MY_UIN", str1);
    localIntent.putExtras(paramActivity.getIntent().getExtras());
    paramActivity.startActivityForResult(localIntent, 4097);
    aqfy.anim(paramActivity, false, true);
  }
  
  public String getRefer()
  {
    return this.mRefer;
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramActivity.setResult(1, paramIntent);
      paramActivity.finish();
    }
    while (!(paramActivity instanceof NewFlowCameraActivity)) {
      return;
    }
    ((NewFlowCameraActivity)paramActivity).bxU = true;
  }
  
  public void r(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity == null) {
      return;
    }
    String str = paramIntent.getStringExtra("file_video_source_dir");
    Object localObject = paramIntent.getStringExtra("thumbfile_send_path");
    arhz localarhz = new arhz(paramActivity);
    localObject = new aquf(this, localarhz, (String)localObject, paramActivity);
    paramActivity.runOnUiThread(new VideoCallBack.2(this, localarhz));
    dQ(paramIntent);
    paramActivity = new EncodeThread(paramActivity, (Handler)localObject, str, null, null);
    paramActivity.PW(false);
    ThreadManager.post(paramActivity, 5, null, false);
  }
  
  public void setRefer(String paramString)
  {
    this.mRefer = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VideoCallBack
 * JD-Core Version:    0.7.0.1
 */