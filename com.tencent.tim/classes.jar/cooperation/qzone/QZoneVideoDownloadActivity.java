package cooperation.qzone;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import anfv;
import angp.a;
import ankq;
import anpc;
import aqiw;
import avpw;
import avpw.d;
import avqx;
import awed;
import axcd;
import axce;
import axce.a;
import axcj;
import axja;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import ilp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements angp.a, axce.a, ShortVideoResourceManager.c
{
  private int HL;
  public TextView agi;
  private long azR;
  private long azS;
  private long azT;
  private long azU;
  private Bundle bM;
  private boolean btj;
  private boolean bxC;
  private boolean bxD;
  private boolean bxF;
  private boolean bxG;
  private boolean bxH;
  private boolean bxI;
  private String cNc;
  private String cNd;
  public URLImageView cf;
  private int cii;
  private String className;
  private String confirmText;
  private LocalMediaInfo d;
  public boolean doe;
  public boolean dof;
  public boolean dog;
  public boolean doh;
  public boolean doi;
  public boolean doj;
  public boolean dok;
  public boolean dol;
  private boolean dom;
  private boolean don;
  private boolean doo;
  private boolean dop = true;
  private boolean doq = true;
  private boolean dor = true;
  private boolean dos = true;
  private long endTime;
  public int exX;
  private int exY;
  private String gifPath;
  public ProgressBar mDownloadingBar;
  Handler mHandler = new avqx(this);
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  private HashMap<Integer, String> qF;
  private long startTime;
  private String topicId;
  public String uin;
  public String videoPath;
  private String videoRefer;
  public long videoSize;
  private int videoType;
  
  public static Intent a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", acfp.m(2131713526));
    try
    {
      paramString = new EditLocalGifSource(paramString, paramArrayList, paramLocalMediaInfo, paramLong);
      paramString = new EditVideoParams(3, 4109, paramString, localBundle);
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra(EditVideoParams.class.getName(), paramString);
      localIntent.putExtra("op_type", "gif_edit");
      if (paramInt == 3) {
        localIntent.putExtra("op_department", "grp_qzone");
      }
      return localIntent;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneVideoDownloadActivity", 1, paramString, new Object[0]);
      QQToast.a(paramActivity, acfp.m(2131713530), 0).show();
    }
    return null;
  }
  
  private boolean aLq()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("checkIsOK()=");
    if ((this.dop) && (this.doq) && (this.dor) && (this.dos)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoEnvironment.k("QZoneVideoDownloadActivity", bool, null);
      if ((!this.dop) || (!this.doq) || (!this.dor) || (!this.dos)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void aaf(String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage(1002);
    localMessage.obj = paramString;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void al(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.startsWith("new_qq_android_native_short_video_")) && (paramInt != 0))
    {
      aaf(acfp.m(2131713507) + gG(paramInt) + "]");
      anfv.jx(2, paramInt);
    }
    if ((paramString1.startsWith("new_qq_android_native_short_filter_")) && (paramInt != 0))
    {
      aaf(acfp.m(2131713459) + gG(paramInt) + "]");
      anfv.jx(2, paramInt);
    }
    if ((!isFinishing()) && (cz(this.app)) && (aLq())) {
      eBG();
    }
    for (;;)
    {
      VideoEnvironment.k("QZoneVideoDownloadActivity", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      VideoEnvironment.k("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    }
  }
  
  private void cxJ()
  {
    if ((aqiw.isNetworkAvailable(null)) && (this.app != null))
    {
      this.azU = 0L;
      this.azT = 0L;
      this.azS = 0L;
      this.azR = 0L;
      ShortVideoResourceManager.b(this.app, this);
      axce.a().a(axcd.c, this, false);
      return;
    }
    this.mHandler.sendEmptyMessage(1002);
  }
  
  private boolean cz(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = VideoEnvironment.r(paramQQAppInterface);
    int i;
    if (ankq.aB(BaseApplicationImpl.getContext()) == 2)
    {
      i = 0;
      paramQQAppInterface = new StringBuilder().append("isAllReady()=");
      if ((!bool2) || (i == 0)) {
        break label73;
      }
    }
    label73:
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoEnvironment.k("QZoneVideoDownloadActivity", bool1, null);
      if ((!bool2) || (i == 0)) {
        break label78;
      }
      return true;
      i = 1;
      break;
    }
    label78:
    return false;
  }
  
  private void eBF()
  {
    if (this.qF == null) {
      this.qF = new HashMap();
    }
    this.qF.put(Integer.valueOf(-1), acfp.m(2131713514));
    this.qF.put(Integer.valueOf(-2), acfp.m(2131713464));
    this.qF.put(Integer.valueOf(-2), acfp.m(2131713500));
    this.qF.put(Integer.valueOf(-3), acfp.m(2131713527));
    this.qF.put(Integer.valueOf(-4), acfp.m(2131713508));
    this.qF.put(Integer.valueOf(-100), acfp.m(2131713511));
    this.qF.put(Integer.valueOf(-101), acfp.m(2131713497));
    this.qF.put(Integer.valueOf(-105), acfp.m(2131713516));
    this.qF.put(Integer.valueOf(-106), "MD5为空错误");
    this.qF.put(Integer.valueOf(-107), acfp.m(2131713522));
    this.qF.put(Integer.valueOf(-108), "MD5校验错误");
    this.qF.put(Integer.valueOf(-117), acfp.m(2131713473));
    this.qF.put(Integer.valueOf(-118), acfp.m(2131713456));
    this.qF.put(Integer.valueOf(-125), acfp.m(2131713513));
    this.qF.put(Integer.valueOf(-126), acfp.m(2131713496));
    this.qF.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.qF.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.qF.put(Integer.valueOf(-128), acfp.m(2131713457));
    this.qF.put(Integer.valueOf(-1000), acfp.m(2131713532));
    this.qF.put(Integer.valueOf(-1500), acfp.m(2131713521));
    this.qF.put(Integer.valueOf(-1501), acfp.m(2131713520));
  }
  
  private void eBG()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneVideoDownloadActivity", 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.a(this, acfp.m(2131713504), 0).show();
      awed.ad(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    Object localObject2 = avpw.d.a();
    Object localObject1;
    Bundle localBundle;
    if (TextUtils.isEmpty(this.uin))
    {
      localObject1 = getAppRuntime().getAccount();
      ((avpw.d)localObject2).cMP = ((String)localObject1);
      localObject1 = getIntent().getStringExtra("refer");
      QLog.i("QZoneVideoDownloadActivity", 1, "isSupportRecord=" + this.doe + ",isSupportTrim=" + this.dof + ",isPreviewVideo" + this.btj + ",refer=" + (String)localObject1 + ",videoRefer=" + this.videoRefer);
      localBundle = new Bundle();
      if ((!getIntent().hasExtra("support_pic")) || (getIntent().getBooleanExtra("support_pic", false))) {
        break label837;
      }
      localBundle.putBoolean("flow_camera_capture_mode", false);
      localBundle.putBoolean("flow_camera_capture_mode", false);
      label233:
      if (getIntent().hasExtra("enable_local_button")) {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_button", true));
      }
      localBundle.putBoolean("flow_camera_video_mode", getIntent().getBooleanExtra("flow_camera_video_mode", true));
      localBundle.putString("sv_config", getIntent().getStringExtra("sv_config"));
      localBundle.putInt("UseQQCameraCompression", getIntent().getIntExtra("UseQQCameraCompression", 0));
      localBundle.putBoolean("PeakConstants.ARG_BEAUTY", getIntent().getBooleanExtra("PeakConstants.ARG_BEAUTY", true));
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_FILTER", true));
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_DD", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_DD", true));
      localBundle.putBoolean("PeakConstants.ARG_UNFOLD_DD", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_DD", false));
      localBundle.putString("PeakConstants.ARG_DD_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_DD_CATEGORY_NAME"));
      localBundle.putString("PeakConstants.ARG_DD_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_DD_ITEM_ID"));
      localBundle.putBoolean("PeakConstants.ARG_UNFOLD_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_FILTER", false));
      localBundle.putString("PeakConstants.ARG_FILTER_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_FILTER_CATEGORY_NAME"));
      localBundle.putString("PeakConstants.ARG_FILTER_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_FILTER_ITEM_ID"));
      localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", getIntent().getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0));
      localBundle.putBoolean("extra_directly_back", getIntent().getBooleanExtra("extra_directly_back", false));
      localBundle.putDouble("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      localBundle.putDouble("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      localBundle.putParcelable("key_qzone_topic", getIntent().getParcelableExtra("key_qzone_topic"));
      if (this.cii != 3) {
        break label859;
      }
      localBundle.putString("qcamera_photo_filepath", getIntent().getStringExtra("qcamera_photo_filepath"));
      localBundle.putBoolean("support_pic", getIntent().getBooleanExtra("support_pic", false));
      localBundle.putBoolean("go_publish_activity", getIntent().getBooleanExtra("go_publish_activity", false));
      localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      localBundle.putString("qzone_plugin_activity_name", getIntent().getStringExtra("qzone_plugin_activity_name"));
      localBundle.putBoolean("extra_from_take_photo_using_qq_camera", getIntent().getBooleanExtra("extra_from_take_photo_using_qq_camera", false));
    }
    for (;;)
    {
      if (!this.doe) {
        break label889;
      }
      avpw.a(this.app, this, (avpw.d)localObject2, 10009, this.dof, this.doj, (String)localObject1, this.videoRefer, this.dok, this.dol, this.topicId, this.bxC, this.cNc, this.cNd, this.bxD, this.bxH, this.dom, this.bxF, this.confirmText, this.bxG, this.bxI, this.don, this.cii, this.doo, localBundle);
      awed.ad(((avpw.d)localObject2).cMP, "qzone_video_recordtrim", "0", "record");
      eBH();
      finish();
      return;
      localObject1 = this.uin;
      break;
      label837:
      localBundle.putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
      break label233;
      label859:
      if (this.cii == 5) {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      }
    }
    label889:
    if (this.dof)
    {
      avpw.a(this, (avpw.d)localObject2, this.videoPath, this.videoSize, 10009, this.exX, (String)localObject1, this.videoRefer);
      awed.ad(((avpw.d)localObject2).cMP, "qzone_video_recordtrim", "1", "trim");
      finish();
      return;
    }
    if (this.btj)
    {
      localObject1 = new Intent(getApplicationContext(), PreviewVideoActivity.class);
      ((Intent)localObject1).putExtra("video_source_path", this.videoPath);
      ((Intent)localObject1).putExtra("video_type", this.videoType);
      ((Intent)localObject1).putExtra("start_time", this.startTime);
      ((Intent)localObject1).putExtra("end_time", this.endTime);
      ((Intent)localObject1).putExtra("encode_video_params", this.bM);
      startActivity((Intent)localObject1);
      overridePendingTransition(2130772009, 2130772013);
      finish();
      return;
    }
    if (this.dog)
    {
      localObject1 = (ArrayList)getIntent().getSerializableExtra("PhotoConst.GIF_PHOTO_PATHS");
      int i = getIntent().getIntExtra("PhotoConst.GIF_DELAY", 150);
      localObject1 = a(this, this.gifPath, (ArrayList)localObject1, this.d, i, 3);
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getApplicationContext(), EditVideoActivity.class);
        ((Intent)localObject1).putExtras(getIntent());
        QzonePluginProxyActivity.x((Intent)localObject1, this.className);
        ((Intent)localObject1).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.className);
        ((Intent)localObject1).putExtra("cleartop", true);
        ((Intent)localObject1).putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
        ((Intent)localObject1).putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        ((Intent)localObject1).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        ((Intent)localObject1).putExtra("DirectBackToQzone", true);
        startActivity((Intent)localObject1);
      }
      finish();
      return;
    }
    if (this.doh)
    {
      localObject1 = getIntent();
      localObject2 = getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject1).setClassName(getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
      ((Intent)localObject1).addFlags(603979776);
      avpw.a(this, "", (Intent)localObject1, -1);
      finish();
      return;
    }
    finish();
  }
  
  private void eBH()
  {
    switch (this.cii)
    {
    }
    do
    {
      do
      {
        return;
        LpReportInfo_pf00064.allReport(612, 1, 1);
      } while (!QLog.isColorLevel());
      QLog.i("QZoneVideoDownloadActivity", 2, "entry source plus report");
      return;
      LpReportInfo_pf00064.allReport(612, 1, 2);
    } while (!QLog.isColorLevel());
    QLog.i("QZoneVideoDownloadActivity", 2, "entry source quick left slide report");
  }
  
  private String gG(int paramInt)
  {
    Object localObject;
    if (this.qF == null) {
      localObject = String.valueOf(paramInt);
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.qF.get(Integer.valueOf(paramInt));
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return String.valueOf(paramInt);
  }
  
  public void a(axcd paramaxcd, long paramLong1, long paramLong2)
  {
    if (paramaxcd == axcd.c)
    {
      this.azT = paramLong1;
      this.azU = paramLong2;
      if (this.azS + this.azU <= 0L) {
        break label147;
      }
    }
    label147:
    for (int i = (int)((float)(this.azR + this.azT) * 100.0F / (float)(this.azS + this.azU));; i = 0)
    {
      Message localMessage = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage(localMessage);
      VideoEnvironment.k("QZoneVideoDownloadActivity", "packageIdx=" + paramaxcd.index + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
    }
  }
  
  public void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramaxcd == axcd.c)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.doq = true;
      if ((!isFinishing()) && (cz(this.app)) && (aLq())) {
        eBG();
      }
    }
    else
    {
      return;
    }
    VideoEnvironment.k("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    return;
    label56:
    aaf(acfp.m(2131713484) + gG(paramInt) + "]");
    anfv.jx(2, paramInt);
  }
  
  public void aFW()
  {
    VideoEnvironment.k("QZoneVideoDownloadActivity", "onNetWorkNone...", null);
    this.mDownloadingBar.post(new QZoneVideoDownloadActivity.2(this));
    anfv.jx(3, -1500);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("QZoneVideoDownloadActivity", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        aaf(acfp.m(2131713460) + gG(paramInt2) + "]");
        anfv.jx(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("QZoneVideoDownloadActivity", "onConfigResult| check config success...", null);
        this.dop = false;
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        if (ankq.aB(VideoEnvironment.getContext()) == 2)
        {
          this.doq = false;
          ShortVideoResourceManager.b(this.app, localArrayList, this);
        }
        for (;;)
        {
          if (ankq.ayb())
          {
            this.dor = false;
            ShortVideoResourceManager.c(this.app, localArrayList, this);
          }
          if (!ankq.ayd()) {
            break;
          }
          this.dos = false;
          ShortVideoResourceManager.d(this.app, localArrayList, this);
          return;
          VideoEnvironment.k("QZoneVideoDownloadActivity", "onConfigResult| getFilterSoState != 2", null);
        }
      }
      aaf(acfp.m(2131713509) + gG(paramInt1) + "]");
      anfv.jx(1, paramInt1);
      return;
    }
    aaf(acfp.m(2131713478) + gG(paramInt2) + "]");
    anfv.jx(1, paramInt2);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      ShortVideoResourceManager.a(this.app, this);
      ShortVideoResourceManager.b(this.app, this);
    }
    axce.a().b(this);
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    this.azR = paramLong1;
    this.azS = paramLong2;
    int i;
    if (this.azS + this.azU > 0L)
    {
      i = (int)((float)(this.azR + this.azT) * 100.0F / (float)(this.azS + this.azU));
      if (!paramString.startsWith("new_qq_android_native_short_video_")) {
        break label152;
      }
      Message localMessage = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage(localMessage);
    }
    for (;;)
    {
      VideoEnvironment.k("QZoneVideoDownloadActivity", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      i = 0;
      break;
      label152:
      if (!paramString.startsWith("new_qq_android_native_short_filter_")) {}
    }
  }
  
  public void initUI()
  {
    setTitle(acfp.m(2131713498));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131373416));
    this.agi = ((TextView)findViewById(2131373415));
    this.cf = ((URLImageView)findViewById(2131373419));
    this.cf.setImageURL("https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.k("QZoneVideoDownloadActivity", "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.dop = true;
    }
    for (;;)
    {
      al(paramString1, paramInt, paramString2);
      return;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        this.dor = true;
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        this.dos = true;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(-16777216);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Toast.makeText(getApplicationContext(), acfp.m(2131713510), 1).show();
      awed.ad(null, "qzone_video_recordtrim", "1002", null);
      return;
    }
    this.doe = localIntent.getBooleanExtra("support_record", false);
    this.dof = localIntent.getBooleanExtra("support_trim", false);
    this.dog = localIntent.getBooleanExtra("support_edit_video", false);
    this.doh = localIntent.getBooleanExtra("support_jump_gif_chooser", false);
    this.doj = localIntent.getBooleanExtra("support_pic", false);
    this.doi = localIntent.getBooleanExtra("support_dynamic_video", false);
    this.cii = localIntent.getIntExtra("entry_source", 0);
    this.dok = localIntent.getBooleanExtra("is_qzone_vip", false);
    this.dol = localIntent.getBooleanExtra("enable_edit_video", false);
    this.uin = localIntent.getStringExtra("uin");
    this.videoPath = localIntent.getStringExtra("file_send_path");
    this.videoSize = localIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.exX = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    this.btj = localIntent.getBooleanExtra("preview_video", false);
    this.videoType = localIntent.getIntExtra("video_type", 0);
    this.startTime = localIntent.getLongExtra("start_time", 0L);
    this.endTime = localIntent.getLongExtra("end_time", 0L);
    this.videoRefer = localIntent.getStringExtra("video_refer");
    this.bM = localIntent.getBundleExtra("encode_video_params");
    this.topicId = localIntent.getStringExtra("topicId");
    this.bxC = localIntent.getBooleanExtra("enterPtu", false);
    this.cNc = localIntent.getStringExtra("callback");
    this.cNd = localIntent.getStringExtra("dongxiao_id");
    this.bxH = localIntent.getBooleanExtra("enable_priv_list", true);
    this.bxD = localIntent.getBooleanExtra("enable_input_text", true);
    this.dom = localIntent.getBooleanExtra("enable_sync_qzone", false);
    this.bxF = localIntent.getBooleanExtra("enable_origin_video", false);
    this.confirmText = localIntent.getStringExtra("confirm_text");
    this.bxG = localIntent.getBooleanExtra("enable_edit_button", true);
    this.bxI = localIntent.getBooleanExtra("enable_local_button", true);
    this.don = localIntent.getBooleanExtra("is_glance_video", false);
    this.d = ((LocalMediaInfo)localIntent.getSerializableExtra("gif_media_info"));
    this.HL = localIntent.getIntExtra("gif_photoplus_pos", -1);
    this.gifPath = localIntent.getStringExtra("gif_path");
    this.className = localIntent.getStringExtra("gif_class_name");
    this.doo = localIntent.getBooleanExtra("go_publish_activity", false);
    this.exY = localIntent.getIntExtra("isGoCreateAlbumShortcut", 0);
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      int i;
      long l;
      Object localObject;
      if (TextUtils.isEmpty(this.uin))
      {
        paramBundle = getAppRuntime().getAccount();
        this.uin = paramBundle;
        if (!localIntent.getBooleanExtra("from_qcircle", false)) {
          break label880;
        }
        i = localIntent.getIntExtra("key_qcircle_entrance_type", 0);
        paramBundle = new Bundle();
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.tencent.qcircle.QCirclePublishFeedActivity");
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
        paramBundle.putString("PhotoConst.UIN", this.uin);
        l = System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        if (l >= 0L)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("VideoDownloadTime", String.valueOf(l));
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(((QQAppInterface)localAppRuntime).getCurrentUin(), "call_pitu_camera", true, 0L, 0L, (HashMap)localObject, null, true);
          QZLog.d("QZoneVideoDownloadActivity", 1, new Object[] { "oncreate... qcircle qzone->videoDownload time cost:", Long.valueOf(System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis())) });
        }
        paramBundle.putString("qq_camera_from_qcircle_scheme", localIntent.getStringExtra("key_scheme"));
        paramBundle.putLong("PhotoConst.timestamp", localIntent.getLongExtra("PhotoConst.timestamp", System.currentTimeMillis()));
        paramBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        if (i != 1) {
          break label854;
        }
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        axja.B(this, localIntent);
      }
      for (;;)
      {
        finish();
        return;
        paramBundle = this.uin;
        break;
        label854:
        if (i == 2) {
          axcj.v(this, paramBundle);
        } else if (i == 3) {
          axcj.w(this, paramBundle);
        }
      }
      label880:
      if ((this.exY == 1) || (this.exY == 2) || (this.exY == 3))
      {
        paramBundle = localIntent.getStringExtra("UploadPhoto.key_album_id");
        localObject = localIntent.getStringExtra("UploadPhoto.key_album_name");
        Bitmap localBitmap = (Bitmap)localIntent.getParcelableExtra("UploadPhoto.key_album_cover");
        l = localIntent.getLongExtra("UploadPhoto.key_album_owner_uin", 0L);
        if (this.exY == 1) {
          avpw.a((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
        }
        for (;;)
        {
          finish();
          return;
          if ((this.exY == 2) || (this.exY == 3)) {
            avpw.b((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
          }
        }
      }
      if (((QQAppInterface)localAppRuntime).bF())
      {
        Toast.makeText(getApplicationContext(), acfp.m(2131713506), 1).show();
        awed.ad(this.uin, "qzone_video_recordtrim", "1003", null);
        finish();
        return;
      }
      if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext()))
      {
        awed.ad(this.uin, "qzone_video_recordtrim", "1004", null);
        finish();
        return;
      }
      if (!cz((QQAppInterface)localAppRuntime))
      {
        setContentView(2131563398);
        initUI();
        this.mIsUIInited.set(true);
        eBF();
        cxJ();
        return;
      }
      if (this.doi)
      {
        setContentView(2131563398);
        initUI();
      }
    }
    for (;;)
    {
      eBG();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoDownloadActivity", 2, "app is not QQAppInterface");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */