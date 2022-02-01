import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;

public class awtf
{
  public static String TAG = "ShortVideoProcessUtil";
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, ayca paramayca, awtf.a parama)
  {
    a(paramActivity, paramIntent, paramVideoCaptureResult, paramayca, parama, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, ayca paramayca, awtf.a parama, aaqj paramaaqj, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramayca == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleVideofromEditVideoActivity params are wrong");
      }
    }
    do
    {
      PublishParam localPublishParam;
      do
      {
        return;
        paramActivity.getIntent().putExtra("forward_source_from_shoot_quick", true);
        localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      } while ((localPublishParam == null) || (localPublishParam.bsZ != 1));
      Object localObject = localPublishParam.thumbPath;
      paramActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        QLog.d(TAG, 2, "publishParam =" + localPublishParam.toString());
      }
      PtvFilterUtils.hs(new File(localPublishParam.videoFilePath).getParent(), localPublishParam.fakeVid);
      Bundle localBundle = d(paramIntent);
      localObject = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
      a(paramActivity, (SessionInfo)localObject, localPublishParam, paramVideoCaptureResult, localBundle, parama, paramaaqj, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
      if ((localObject != null) && (bool))
      {
        paramIntent = wja.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramIntent.putExtra("uin", ((SessionInfo)localObject).aTl);
        paramIntent.putExtra("uintype", ((SessionInfo)localObject).cZ);
        paramIntent.putExtra("troop_uin", ((SessionInfo)localObject).troopUin);
        paramActivity.startActivity(paramIntent);
        return;
      }
    } while (!paramIntent.getBooleanExtra("short_video_multi_share", false));
    aywz.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), paramayca);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, awtf.a parama)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramVideoCaptureResult, paramBundle, parama, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, awtf.a parama, aaqj paramaaqj, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    aytt.a locala = new aytt.a();
    locala.E = paramActivity;
    locala.bdL = new File(paramPublishParam.videoFilePath).getParent();
    locala.mAudioFilePath = paramPublishParam.audioFilePath;
    int i;
    boolean bool;
    if (paramPublishParam.saveMode <= 5)
    {
      i = paramPublishParam.saveMode;
      locala.ciH = i;
      locala.aAu = paramPublishParam.videoFilePath;
      locala.mThumbFilePath = paramPublishParam.thumbPath;
      locala.mThumbWidth = 0;
      locala.gP = 0;
      locala.fakeVid = paramPublishParam.fakeVid;
      locala.btb = paramPublishParam.btb;
      locala.specialVideoType = paramPublishParam.specialVideoType;
      if (paramPublishParam.syncToStory != 1) {
        break label365;
      }
      bool = true;
      label132:
      locala.syncToStory = bool;
      locala.saveMode = paramPublishParam.saveMode;
      locala.a = paramaaqj;
      locala.mContent = paramString1;
      locala.mPriv = paramInt;
      locala.eo = paramArrayList;
      locala.bxk = paramBoolean1;
      locala.topicId = paramString2;
      locala.topicSyncQzone = paramBoolean2;
      if (paramVideoCaptureResult != null) {
        break label371;
      }
      ambe.j(new RuntimeException("videoCaptureResult == null"));
      QLog.e(TAG, 2, "videoCaptureResult == null");
      locala.ciI = 0;
      label228:
      locala.ciC = ((int)paramPublishParam.videoDuration);
      locala.cXT = paramBundle.getString("dynamic_text");
      locala.templateId = paramBundle.getString("widgetinfo");
      locala.templateName = paramBundle.getString("key_camera_material_name");
      paramVideoCaptureResult = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramVideoCaptureResult = paramSessionInfo.aTl;
        paramInt = paramSessionInfo.cZ;
        paramActivity = paramSessionInfo.troopUin;
      }
      locala.mUin = paramVideoCaptureResult;
      locala.mUinType = paramInt;
      locala.mTroopUin = paramActivity;
      if (paramPublishParam.bsX != 1) {
        break label383;
      }
    }
    label365:
    label371:
    label383:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new aytt(locala, false, paramBoolean1, parama).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
      locala.ciI = paramVideoCaptureResult.videoFrameCount;
      break label228;
    }
  }
  
  private static Bundle d(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    String str = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str))
    {
      localBundle.putString("widgetinfo", str);
      if (!TextUtils.isEmpty(paramIntent)) {
        localBundle.putString("key_camera_material_name", paramIntent);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getBundele templateId:" + str + ", name:" + paramIntent);
    }
    return localBundle;
  }
  
  public static class a
  {
    public void onComplete() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtf
 * JD-Core Version:    0.7.0.1
 */