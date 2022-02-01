import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.1;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.2;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.3;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.4;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class awsu
  extends QIMEffectCameraCaptureUnit
{
  public static long Mp = -1L;
  private static final String TAG = awsu.class.getSimpleName();
  private String UL;
  private aaqj a;
  private CameraCaptureView.VideoCaptureResult b;
  private Bundle bP;
  private String bdO;
  private String bdz;
  private boolean bwI;
  private boolean bxA;
  private boolean bxD;
  private boolean bxH;
  private boolean bxz;
  private String cSn;
  private String cSu;
  private String cSv;
  private int ciS = 10001;
  private int cif = -1;
  private int cig;
  private int cih;
  private boolean drh;
  public boolean drj;
  private boolean dsl;
  private boolean dsm;
  private int eCK;
  private ProgressDialog f;
  private LocalMediaInfo i;
  private String mFontUrl;
  private String mRefer;
  private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  private String topicId;
  
  public awsu(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(this.ciS, 122, 3);
    this.byT = 12;
  }
  
  private void AJ(String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    Intent localIntent = new Intent(getActivity(), EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", acfp.m(2131711250));
    paramString = new EditVideoParams(3, 536903689L, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    this.jdField_a_of_type_Aycb.getActivity().startActivityForResult(localIntent, 1014);
  }
  
  private void L(int paramInt, Intent paramIntent)
  {
    boolean bool1;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    if ((paramInt == -1) && (paramIntent != null))
    {
      bool1 = paramIntent.getBooleanExtra("go_publish_activity", false);
      bool2 = paramIntent.getBooleanExtra("extra_directly_back", false);
      if (!bool1) {
        break label225;
      }
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramInt = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label247;
      }
      localObject2 = new ArrayList();
    }
    label225:
    label247:
    for (;;)
    {
      int j = paramIntent.getIntExtra("key_font_id", -1);
      this.cig = paramIntent.getIntExtra("key_font_format_type", 0);
      this.mFontUrl = paramIntent.getStringExtra("key_font_url");
      this.cih = paramIntent.getIntExtra("key_super_font_id", -1);
      this.bdz = paramIntent.getStringExtra("key_super_font_info");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
      bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      QLog.i(TAG, 2, "get mSetTimerDelete: " + bool1);
      avpw.a((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, j, this.cig, this.mFontUrl, bool1, bool2, j, this.bdz);
      getActivity().finish();
      do
      {
        return;
      } while (!bool2);
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
  }
  
  private void M(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0) {
      deleteOldFile();
    }
    while ((paramInt != -1) || (paramIntent == null)) {
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("key_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int j = paramIntent.getIntExtra("key_priv", 1);
    localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
    if (localObject2 == null) {
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      int k = paramIntent.getIntExtra("key_font_id", -1);
      this.cig = paramIntent.getIntExtra("key_font_format_type", 0);
      this.mFontUrl = paramIntent.getStringExtra("key_font_url");
      this.cih = paramIntent.getIntExtra("key_super_font_id", -1);
      this.bdz = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (localPublishParam.saveMode <= 5) {}
      for (paramInt = localPublishParam.saveMode;; paramInt = 0)
      {
        int m = (int)localPublishParam.videoDuration;
        boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
        a(localPublishParam.audioFilePath, paramInt, localPublishParam.videoFilePath, localPublishParam.thumbPath, localPublishParam.fakeVid, m, this.jdField_a_of_type_Aaqj, (String)localObject1, j, (ArrayList)localObject2, false, k, this.cig, this.mFontUrl, this.cih, this.bdz, bool1, bool2, false, bool3);
        this.dsm = true;
        return;
      }
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, aaqj paramaaqj, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.hs(str, paramString4);
    }
    aaqq.a locala = new aaqq.a();
    locala.E = getActivity();
    locala.bdL = str;
    locala.mAudioFilePath = paramString1;
    locala.ciH = paramInt1;
    locala.aAu = paramString2;
    locala.mThumbFilePath = paramString3;
    locala.mThumbWidth = 0;
    locala.gP = 0;
    locala.fakeVid = paramString4;
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult == null)
    {
      ambe.j(new RuntimeException("videoCaptureResult == null"));
      QLog.e(TAG, 2, "videoCaptureResult == null");
    }
    for (locala.ciI = 0;; locala.ciI = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount)
    {
      locala.ciC = paramInt2;
      locala.jdField_a_of_type_Aaqj = paramaaqj;
      locala.mContent = paramString5;
      locala.mPriv = paramInt3;
      locala.eo = paramArrayList;
      locala.bxk = this.bxz;
      locala.topicId = this.topicId;
      locala.topicSyncQzone = paramBoolean1;
      locala.fontId = paramInt4;
      locala.fontFormatType = paramInt5;
      locala.fontUrl = paramString6;
      locala.superFontId = paramInt6;
      locala.bdK = paramString7;
      locala.bxp = paramBoolean2;
      locala.bxq = paramBoolean3;
      locala.isSyncToQQStory = paramBoolean4;
      locala.qzoneVerticalVideoTopicInfo = this.qzoneVerticalVideoTopicInfo;
      locala.bxr = paramBoolean5;
      locala.cii = this.bP.getInt("entry_source", 0);
      locala.mUin = "";
      locala.mUinType = 0;
      locala.mTroopUin = "";
      new aaqq(locala).execute(new Void[0]);
      return;
    }
  }
  
  private void adf(int paramInt)
  {
    deleteOldFile();
    if (paramInt == 0) {}
    while (paramInt != -1) {
      return;
    }
    QLog.i(TAG, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
    getActivity().finish();
  }
  
  private void adg(int paramInt)
  {
    if ((paramInt != -1) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    getActivity().finish();
  }
  
  private void adh(int paramInt)
  {
    if (paramInt == 0) {
      deleteOldFile();
    }
    while (paramInt != -1) {
      return;
    }
    bqc();
  }
  
  private void bg(boolean paramBoolean, String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    getActivity().runOnUiThread(new QIMQzoneEffectsCameraCaptureUnit.4(this, paramBoolean, paramString));
  }
  
  private void bqc()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult != null) && (this.i != null)) {
      a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath, 0, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, this.i.thumbnailPath, null, (int)this.i.mDuration, this.jdField_a_of_type_Aaqj, null, -1, null, false, this.cif, this.cig, this.mFontUrl, this.cih, this.bdz, false, false, false, false);
    }
  }
  
  private void c(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    eFM();
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramVideoCaptureResult.audioDataFilePath);
      this.jdField_a_of_type_Aycb.getActivity().startActivityForResult(localIntent, 1016);
    }
  }
  
  private void c(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("entrance_type", th());
        localBundle.putString("extra_publish_text", this.bdO);
        localBundle.putBoolean("enable_hw_encode", true);
        k = 538968427;
        localBundle.putBoolean("extra_enable_revert", true);
        localBundle.putBoolean("extra_enable_slow", true);
        int j = k;
        if (this.qzoneVerticalVideoTopicInfo != null)
        {
          j = k;
          if (this.qzoneVerticalVideoTopicInfo.ags()) {
            j = 538968425;
          }
        }
        int m = this.bP.getInt("entry_source", 0);
        if (paramLocalMediaInfo.mDuration > QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7) * 1000 + 500) {
          break label620;
        }
        k = 1;
        if ((!TextUtils.isEmpty(this.topicId)) || ("ref_h5_record_video".equals(this.mRefer)) || (m == 3) || (m == 5) || (k == 0) || (awdu.aMt()) || (this.qzoneVerticalVideoTopicInfo != null)) {
          break label616;
        }
        j |= 0x10000;
        bool = this.bP.getBoolean("enable_edit_button", true);
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        if (!bool) {
          break label626;
        }
        l = j;
        paramVideoCaptureResult = new EditVideoParams(3, l, paramVideoCaptureResult, localBundle);
        paramVideoCaptureResult.mExtra.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + paramVideoCaptureResult.toString() + ", recordFinish---startEdit");
        }
        if (getActivity() == null) {
          break label619;
        }
        if (getActivity().isFinishing()) {
          return;
        }
        paramLocalMediaInfo = new Intent(getActivity(), QzoneEditVideoActivity.class);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
        paramLocalMediaInfo.putExtra("key_font_id", this.cif);
        paramLocalMediaInfo.putExtra("op_department", "grp_qzone");
        paramLocalMediaInfo.putExtra("op_type", "video_edit");
        paramLocalMediaInfo.putExtra("topic_id", this.topicId);
        paramLocalMediaInfo.putExtra("enable_priv_list", this.bxH);
        paramLocalMediaInfo.putExtra("enable_input_text", this.bxD);
        paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
        paramLocalMediaInfo.putExtra("state", this.bO);
        paramLocalMediaInfo.putExtra("mIsQzoneVip", this.bwI);
        paramLocalMediaInfo.putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
        paramLocalMediaInfo.putExtra("entry_source", this.bP.getInt("entry_source", 0));
        if (k == 0)
        {
          bool = true;
          paramLocalMediaInfo.putExtra("TAKE_DANCING_VIDEO", bool);
          paramLocalMediaInfo.putExtra("key_qzone_topic", this.qzoneVerticalVideoTopicInfo);
          this.jdField_a_of_type_Aycb.getActivity().startActivityForResult(paramLocalMediaInfo, 1011);
          this.jdField_a_of_type_Aycb.getActivity().overridePendingTransition(0, 0);
          if (!QLog.isColorLevel()) {
            break label619;
          }
          QLog.d(TAG, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
          return;
        }
      }
      catch (Exception paramVideoCaptureResult)
      {
        QLog.e(TAG, 1, "intentToEditVideoActivityFromQzone exception:" + paramVideoCaptureResult);
        return;
      }
      boolean bool = false;
      continue;
      label616:
      continue;
      label619:
      return;
      label620:
      int k = 0;
      continue;
      label626:
      long l = 0L;
    }
  }
  
  private void c(CameraCaptureView.h paramh)
  {
    try
    {
      if (getActivity() == null) {
        break label643;
      }
      if (getActivity().isFinishing()) {
        return;
      }
      if ((paramh == null) || (TextUtils.isEmpty(paramh.filePath)))
      {
        arxa.a().showToast(acfp.m(2131711249));
        getActivity().finish();
        return;
      }
    }
    catch (Exception paramh)
    {
      QLog.d(TAG, 2, "handlePic exception", paramh);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "finishShotPhoto " + paramh.filePath);
    }
    if (this.bP.getInt("edit_video_type", 0) != 10002) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int j = this.bP.getInt("extra.busi_type", 2);
      boolean bool2 = this.bP.getBoolean("go_publish_activity", false);
      if (getActivity() != null)
      {
        if (j == 3)
        {
          double d1 = this.bP.getDouble("key_longtitude", 4.9E-324D);
          double d2 = this.bP.getDouble("key_latitude", 4.9E-324D);
          awci.c(paramh.filePath, d1, d2);
        }
        Intent localIntent;
        label334:
        String str;
        if (bool2)
        {
          localIntent = QzoneEditPictureActivity.a(getActivity(), paramh.filePath, bool1, j, th(), 0);
          localIntent.putExtra("TEMP_PARAM", localIntent.getLongExtra("TEMP_PARAM", 0L) & 0xFFFFFFBF & 0xFFFFFEFF & 0xFFFFFF7F);
          localIntent.putExtra("go_publish_activity", bool2);
          localIntent.putExtra("extra_directly_back", this.bP.getBoolean("extra_directly_back", false));
          localIntent.putExtra("qcamera_photo_filepath", paramh.filePath);
          localIntent.putExtra("qcamera_rotate", paramh.orientation);
          localIntent.putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
          if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is() != 2) {
            break label634;
          }
          j = 0;
          localIntent.putExtra("camera_type", 103);
          localIntent.putExtra("camera_front_back", j);
          localIntent.putExtra("camera_capture_method", paramh.type);
          localIntent.putExtra("state", this.bO);
          localIntent.putExtra("babyq_ability", this.bP.getLong("babyq_ability", 0L));
          if (this.bP.getInt("entry_source", 0) == 5) {
            localIntent.putExtra("pic_entrance_type", 13);
          }
          aaqi.a(this.bP.getInt("edit_video_type", -1), "", "0X8007818", null);
          paramh = SplashActivity.class.getName();
          str = this.bP.getString("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label640;
          }
          paramh = str;
        }
        label640:
        for (;;)
        {
          aarz.AK("finish");
          aarz.cW(localIntent);
          str = localIntent.getStringExtra("pic_confirm_text");
          if (!TextUtils.isEmpty(str)) {
            localIntent.putExtra("extra_publish_text", str);
          }
          if (bool2) {
            localIntent.putExtra("extra_publish_text", this.jdField_a_of_type_Aycb.getActivity().getString(2131721085));
          }
          localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramh);
          localIntent.putExtra("key_activity_code", this.bP.getString("key_activity_code"));
          this.jdField_a_of_type_Aycb.getActivity().startActivityForResult(localIntent, 1012);
          aaqi.h("", "0X80075C1", "", "", "", "");
          return;
          localIntent = QzoneEditPictureActivity.d(getActivity(), paramh.filePath);
          break;
          label634:
          j = 1;
          break label334;
        }
      }
      label643:
      return;
    }
  }
  
  private void d(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if (getActivity() != null) {
      getActivity().runOnUiThread(new QIMQzoneEffectsCameraCaptureUnit.2(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new QIMQzoneEffectsCameraCaptureUnit.3(this, paramVideoCaptureResult, paramLocalMediaInfo));
  }
  
  private void deleteOldFile()
  {
    try
    {
      aqhq.cn(yI());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(TAG, 2, "Delete file error", localException);
    }
  }
  
  private void eFM()
  {
    String str = yI() + File.separator + "videoThumb.jpg";
    ambd.hh(this.c.videoMp4FilePath, str);
    this.i.thumbnailPath = str;
  }
  
  private void ew(Bundle paramBundle)
  {
    int k = 3;
    boolean bool2 = paramBundle.getBoolean("flow_camera_video_mode", true);
    boolean bool1 = paramBundle.getBoolean("flow_camera_capture_mode", true);
    if (this.qzoneVerticalVideoTopicInfo != null) {
      bool1 = false;
    }
    int j;
    if ((bool2) && (bool1))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Aycb.getActivity().getResources().getString(2131701696));
      j = 1;
    }
    for (;;)
    {
      int m;
      if (this.bxA)
      {
        nX(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneGifMiniFrame", 5));
        m = QzoneConfig.getInstance().getConfig("MiniVideo", "GlanceVideoMaxTime", 1);
        j = k;
      }
      for (k = m;; k = QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(k * 1000 + 100);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(j);
        return;
        if ((bool2) && (!bool1))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Aycb.getActivity().getString(2131701705));
          j = 3;
          break;
        }
        if ((bool2) || (!bool1)) {
          break label250;
        }
        j = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Aycb.getActivity().getString(2131701695));
        break;
        nX(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMiniFrame", 6));
      }
      label250:
      j = 1;
    }
  }
  
  private String getGifPath()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
    File localFile = new File(str + File.separator + "gif");
    if ((localFile.exists()) && (!localFile.isDirectory())) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return str + File.separator + "gif" + File.separator + System.currentTimeMillis() + ".gif";
  }
  
  private void go()
  {
    try
    {
      if (this.f != null) {
        this.f.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e(TAG, 1, new Object[] { "cancelProgressDialog", localException });
    }
  }
  
  private void initData(Bundle paramBundle)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    do
    {
      return;
      this.drn = true;
      this.topicId = paramBundle.getString("topic_id");
      this.mRefer = paramBundle.getString("short_video_refer");
      this.jdField_a_of_type_Aaqj = new VideoComponentCallback();
      this.jdField_a_of_type_Aaqj.setRefer(this.mRefer);
      this.bxA = paramBundle.getBoolean("is_glance_video", false);
      this.bdO = paramBundle.getString("confirm_text");
      this.bxH = paramBundle.getBoolean("enable_priv_list", true);
      this.bxD = paramBundle.getBoolean("enable_input_text", true);
      this.bwI = paramBundle.getBoolean("is_qzone_vip", false);
      this.bxz = paramBundle.getBoolean("enable_edit_video", false);
      this.drm = paramBundle.getBoolean("enable_local_video", false);
      if (this.bxA)
      {
        this.drm = false;
        this.drQ = false;
        this.drP = false;
      }
      if ("cover_mall_record_video".equals(this.mRefer))
      {
        this.drQ = false;
        this.drP = false;
      }
      this.cAj = paramBundle.getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
      this.cAk = paramBundle.getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
      this.cAi = paramBundle.getBoolean("PeakConstants.ARG_BEAUTY", true);
      this.qzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)paramBundle.getParcelable("key_qzone_topic"));
      this.drh = paramBundle.getBoolean("PeakConstants.ARG_UNFOLD_DD", false);
      this.UL = paramBundle.getString("PeakConstants.ARG_DD_CATEGORY_NAME");
      this.cSn = paramBundle.getString("PeakConstants.ARG_DD_ITEM_ID");
      this.dsl = paramBundle.getBoolean("PeakConstants.ARG_UNFOLD_FILTER", false);
      this.cSu = paramBundle.getString("PeakConstants.ARG_FILTER_CATEGORY_NAME");
      this.cSv = paramBundle.getString("PeakConstants.ARG_FILTER_ITEM_ID");
      this.eCK = paramBundle.getInt("PeakConstants.ARG_FORCE_CAMERA", 0);
    } while ((this.qzoneVerticalVideoTopicInfo == null) || (!this.qzoneVerticalVideoTopicInfo.ags()));
    this.drQ = false;
  }
  
  private void nX(long paramLong)
  {
    this.aBx = paramLong;
  }
  
  private void sq(String paramString)
  {
    for (;;)
    {
      try
      {
        TextView localTextView;
        if (this.f != null)
        {
          go();
          localTextView = (TextView)this.f.findViewById(2131373180);
          if (aqmr.isEmpty(paramString))
          {
            localTextView.setText(2131717151);
            if (this.f.isShowing()) {
              break;
            }
            this.f.show();
          }
        }
        else
        {
          this.f = new ReportProgressDialog(getActivity(), 2131756467);
          this.f.setCancelable(false);
          this.f.show();
          this.f.setContentView(2131559761);
          continue;
        }
        localTextView.setText(paramString);
      }
      catch (Throwable paramString)
      {
        QZLog.e(TAG, 1, new Object[] { "showProgressDialog", paramString });
        return;
      }
    }
  }
  
  private int th()
  {
    int k = this.bP.getInt("entrance_type", 99);
    int j = k;
    SessionInfo localSessionInfo;
    if (k == 100)
    {
      localSessionInfo = (SessionInfo)this.bP.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo == null) {
        break label51;
      }
    }
    label51:
    for (j = localSessionInfo.cZ;; j = 0)
    {
      j = anfe.hS(j);
      return j;
    }
  }
  
  public int Qv()
  {
    return 4;
  }
  
  protected CameraCaptureView.e a()
  {
    if ((!this.bxA) && (this.bxz)) {}
    for (int j = QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2);; j = 1)
    {
      if (this.eCK != 0) {}
      for (;;)
      {
        aasq localaasq = alxh.a().a(this.eCK);
        CameraCaptureView.e locale = new CameraCaptureView.e();
        locale.TN(localaasq.getWidth());
        locale.TO(localaasq.getHeight());
        locale.bb(alxh.a().w(this.eCK));
        j *= alxh.a().iS(this.eCK) * 1000;
        locale.TT(j);
        aniq.dFI = j;
        locale.TU(1);
        locale.TS(this.eCK);
        return locale;
        if (this.drh) {
          this.eCK = 1;
        } else {
          this.eCK = alwt.Iq();
        }
      }
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
      this.i = paramLocalMediaInfo;
      if ((paramVideoCaptureResult == null) || (paramVideoCaptureResult.videoMp4FilePath == null) || (paramLocalMediaInfo == null))
      {
        arxa.a().showToast(acfp.m(2131711247));
        if (getActivity() == null) {
          return;
        }
        getActivity().finish();
        return;
      }
      if (this.bxA)
      {
        d(paramVideoCaptureResult, paramLocalMediaInfo);
        return;
      }
    }
    catch (Exception paramVideoCaptureResult)
    {
      QZLog.d(TAG, 2, "handleVideo exception!", paramVideoCaptureResult);
      return;
    }
    if (this.bxz)
    {
      c(paramVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    c(paramVideoCaptureResult);
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    super.a(paramh);
    c(paramh);
  }
  
  public void aG(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aaqj != null) {
      this.jdField_a_of_type_Aaqj.aG(paramActivity);
    }
  }
  
  public void coA()
  {
    super.coA();
    Mp = System.currentTimeMillis();
    if (!this.drj)
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label85;
      }
    }
    label85:
    for (int j = (int)(System.currentTimeMillis() - this.aBw);; j = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10001), j, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  public void dKK()
  {
    super.dKK();
    Mp = System.currentTimeMillis();
    if (!this.drj)
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label85;
      }
    }
    label85:
    for (int j = (int)(System.currentTimeMillis() - this.aBw);; j = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10001), j, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public ArrayList<Integer> eG()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  protected List<View> hE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.yh);
    return localArrayList;
  }
  
  public void nW(long paramLong)
  {
    int k = 0;
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    int m = th();
    String str;
    Object localObject2;
    int j;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      j = k;
      if (this.aBw != -1L)
      {
        j = k;
        if (str.equals("0")) {
          j = (int)(paramLong - this.aBw);
        }
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 23) {}
    }
    for (;;)
    {
      try
      {
        if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          continue;
        }
        bool1 = true;
        if (localActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          continue;
        }
        bool2 = true;
        if (localActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          continue;
        }
        bool3 = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e(TAG, 1, "checkSelfPermission error, ", localException);
        continue;
        if ((bool1) || (bool2)) {
          continue;
        }
        localObject1 = localException;
        if (!bool3) {
          continue;
        }
        continue;
      }
      localObject1 = "";
      if (bool1) {
        localObject1 = "".concat("1");
      }
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = ((String)localObject1).concat(",3");
      }
      localObject1 = localObject2;
      if (bool3) {
        localObject1 = ((String)localObject2).concat(",2");
      }
      rar.a("video_shoot_new", "time_openshoot", rar.ea(10001), j, new String[] { str, localObject1, "", String.valueOf(m) });
      return;
      str = "0";
      break;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      }
      while (this.jdField_a_of_type_Aaqj != null)
      {
        this.jdField_a_of_type_Aaqj.onActivityResult(getActivity(), paramInt1, paramInt2, paramIntent);
        return;
        L(paramInt2, paramIntent);
        continue;
        adf(paramInt2);
        continue;
        M(paramInt2, paramIntent);
        continue;
        adg(paramInt2);
        continue;
        adh(paramInt2);
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.dsm)
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.onPause();
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.onStop();
      this.dsm = false;
    }
  }
  
  public boolean onBackPressed()
  {
    boolean bool = super.onBackPressed();
    if ((!this.drj) && (bool))
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label85;
      }
    }
    label85:
    for (int j = (int)(System.currentTimeMillis() - this.aBw);; j = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10001), j, new String[] { "", "1", "", "" });
      return bool;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370835) {
      aG(this.jdField_a_of_type_Aycb.getActivity());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public View onCreateView()
  {
    if ((this.jdField_a_of_type_Aycb != null) && (this.jdField_a_of_type_Aycb.getActivity() != null) && (this.jdField_a_of_type_Aycb.getActivity().getIntent() != null))
    {
      localObject = this.jdField_a_of_type_Aycb.getActivity().getIntent();
      this.bP = ((Intent)localObject).getExtras();
      this.qzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)((Intent)localObject).getParcelableExtra("key_qzone_topic"));
      initData(this.bP);
    }
    Object localObject = super.onCreateView();
    if ("cover_mall_record_video".equals(this.mRefer)) {
      this.drm = false;
    }
    this.yh.setOnClickListener(this);
    ew(this.bP);
    return localObject;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("short_video_refer", getClass().getName());
      localIntent.putExtra("is_qzone_vip", this.bwI);
      localIntent.putExtra("param.topicId", this.topicId);
      localIntent.putExtra("param.topicSyncQzone", false);
      localIntent.putExtra("extra_key_font_id", this.cif);
      localIntent.putExtra("extra_key_font_format_type", this.cig);
      localIntent.putExtra("extra_key_font_url", this.mFontUrl);
      localIntent.putExtra("extra_key_super_font_id", this.cih);
      localIntent.putExtra("extra_key_super_font_info", this.bdz);
      localIntent.putExtra("short_video_refer", this.mRefer);
      localIntent.putExtra("set_user_callback", this.bP.getString("set_user_callback"));
      localIntent.putExtra("key_qzone_topic", this.qzoneVerticalVideoTopicInfo);
      ThreadManager.getUIHandler().postDelayed(new QIMQzoneEffectsCameraCaptureUnit.1(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(TAG, 2, "handleOnNewIntent error ", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsu
 * JD-Core Version:    0.7.0.1
 */