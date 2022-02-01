import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMWebEffectCameraCaptureUnit.2;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class awtc
  extends QIMEffectCameraCaptureUnit
{
  public static String cSH = "key_is_from_bless";
  public static int eCM;
  public static int eCN = 1;
  private String UL;
  private String aYW;
  private String aae;
  private int bnM;
  private boolean bys;
  private boolean byt;
  public String cSA;
  public String cSB;
  public String cSE;
  private String cSF;
  private String cSG;
  private String cSn;
  private String cSu;
  private String cSv;
  private int cjc;
  protected int daY;
  public boolean des = true;
  private boolean drh;
  private boolean dsl;
  public boolean dsr = true;
  public boolean dss;
  public boolean dst;
  private boolean dsu;
  private boolean dsv;
  private boolean dsw;
  private boolean dsx;
  public int eCO;
  public int eCP;
  private BroadcastReceiver mReceiver = new awtd(this);
  public String musicId;
  
  public awtc(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(10007, 7, 6);
    this.byT = 5;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2, boolean paramBoolean6, boolean paramBoolean7, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, awtb paramawtb)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ARG_SUPPORT_VIDEO", paramBoolean1);
    localBundle.putBoolean("ARG_SUPPORT_PHOTO", paramBoolean2);
    localBundle.putInt("ARG_CAMERA_MODE", paramInt1);
    localBundle.putBoolean("ARG_BEAUTY", paramBoolean3);
    localBundle.putBoolean("ARG_SUPPORT_DD", paramBoolean4);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean5);
    localBundle.putString("ARG_DD_CATEGORY_NAME", paramString1);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    localBundle.putBoolean("ARG_SUPPORT_FILTER", paramBoolean6);
    localBundle.putBoolean("ARG_UNFOLD_FILTER", paramBoolean7);
    localBundle.putString("ARG_FILTER_CATEGORY_NAME", paramString3);
    localBundle.putString("ARG_FILTER_ITEM_ID", paramString4);
    localBundle.putInt("ARG_DEAL_TYPE", paramInt2);
    localBundle.putString("ARG_ACTIVITY_ID", paramString6);
    localBundle.putString("ARG_ACTIVITY_TYPE", paramString5);
    localBundle.putString("ARG_WEB_CALLBACK", paramString7);
    localBundle.putString("ARG_CALLER_TYPE", paramString8);
    localBundle.putString("arg_topic_id", paramString9);
    localBundle.putString("arg_topic_name", paramString10);
    localBundle.putString("arg_ad_tag", paramString11);
    localBundle.putString("arg_callback", paramString7);
    if (paramawtb != null)
    {
      localBundle.putBoolean("arg_support_combo", paramawtb.dsr);
      localBundle.putBoolean("arg_unfold_combo", paramawtb.dss);
      localBundle.putString("arg_combo_name", paramawtb.cSA);
      localBundle.putString("arg_combo_id", paramawtb.cSB);
      localBundle.putBoolean("arg_support_music", paramawtb.des);
      localBundle.putBoolean("arg_unfold_music", paramawtb.dst);
      localBundle.putString("arg_music_name", paramawtb.cSE);
      localBundle.putString("arg_music_id", paramawtb.musicId);
    }
    localBundle.putInt("edit_video_type", 10007);
    localBundle.putInt("entrance_type", 7);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  private Bundle c(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.TS(this.cjc);
    return locale;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool2 = true;
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    Object localObject = new ayby.a().b(3).b();
    if (this.bnM == eCM)
    {
      ((ayby)localObject).dyl = true;
      ((ayby)localObject).cWC = this.aYW;
    }
    ((ayby)localObject).eJz = this.eCO;
    ((ayby)localObject).eJA = this.eCP;
    ((ayby)localObject).cWD = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("succUrl");
    ((ayby)localObject).cWE = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("failedUrl");
    this.jdField_b_of_type_Aybv.a((ayby)localObject);
    j(paramLocalMediaInfo);
    localObject = new ayws();
    if (this.eCP == aaqh.ciy)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((ayzs)axov.a(3)).a();
      if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo.kind == 5) || (localPtvTemplateInfo.kind == 6) || (localPtvTemplateInfo.kind == 8) || (localPtvTemplateInfo.kind == 9) || (localPtvTemplateInfo.kind == 10)))
      {
        ((ayws)localObject).eCA = this.eCA;
        ((ayws)localObject).cYc = this.scoreRate;
        ((ayws)localObject).cSq = this.cSq;
        ((ayws)localObject).overPercent = this.overPercent;
        ((ayws)localObject).cYd = (localPtvTemplateInfo.categoryId + "");
        ((ayws)localObject).cYe = localPtvTemplateInfo.id;
        ((ayws)localObject).dBp = true;
        if (localPtvTemplateInfo.kind != 8) {
          break label387;
        }
        bool1 = true;
        ((ayws)localObject).dBq = bool1;
        if (localPtvTemplateInfo.kind != 9) {
          break label392;
        }
        bool1 = true;
        label324:
        ((ayws)localObject).dBr = bool1;
        if (localPtvTemplateInfo.kind != 10) {
          break label397;
        }
      }
    }
    label387:
    label392:
    label397:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ayws)localObject).dBs = bool1;
      ((ayws)localObject).shookHeadCount = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.getShookHeadCount();
      aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_b_of_type_Aybv, this.bO, 5, (ayws)localObject);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label324;
    }
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    super.a(paramh);
    aybw localaybw = new aybw.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is()).a(3).b();
    localaybw.eJv = this.bnM;
    localaybw.cWC = this.aYW;
    this.jdField_b_of_type_Aybv.a(localaybw);
    aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramh, this.jdField_b_of_type_Aybv, this.bO, this.byT);
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  public void eES()
  {
    eFS();
    this.cAi = this.dsu;
    this.cAj = this.dsv;
    this.cAk = this.dsw;
    this.drP = this.dsr;
    this.drQ = this.des;
  }
  
  public void eFS()
  {
    Bundle localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
    this.bys = localBundle.getBoolean("ARG_SUPPORT_VIDEO");
    this.byt = localBundle.getBoolean("ARG_SUPPORT_PHOTO");
    this.cjc = localBundle.getInt("ARG_CAMERA_MODE");
    this.dsu = localBundle.getBoolean("ARG_BEAUTY");
    this.dsw = localBundle.getBoolean("ARG_SUPPORT_DD");
    this.drh = localBundle.getBoolean("ARG_UNFOLD_DD");
    this.UL = localBundle.getString("ARG_DD_CATEGORY_NAME");
    this.cSn = localBundle.getString("ARG_DD_ITEM_ID");
    this.dsv = localBundle.getBoolean("ARG_SUPPORT_FILTER");
    this.dsl = localBundle.getBoolean("ARG_UNFOLD_FILTER");
    this.cSu = localBundle.getString("ARG_FILTER_CATEGORY_NAME");
    this.cSv = localBundle.getString("ARG_FILTER_ITEM_ID");
    this.bnM = localBundle.getInt("ARG_DEAL_TYPE");
    this.aYW = localBundle.getString("ARG_WEB_CALLBACK");
    this.aae = localBundle.getString("ARG_ACTIVITY_ID");
    this.cSF = localBundle.getString("ARG_ACTIVITY_TYPE");
    this.cSG = localBundle.getString("ARG_CALLER_TYPE");
    this.dsr = localBundle.getBoolean("arg_support_combo");
    this.dss = localBundle.getBoolean("arg_unfold_combo");
    this.cSA = localBundle.getString("arg_combo_name");
    this.cSB = localBundle.getString("arg_combo_id");
    this.des = localBundle.getBoolean("arg_support_music");
    this.dst = localBundle.getBoolean("arg_unfold_music");
    this.cSE = localBundle.getString("arg_music_name");
    this.musicId = localBundle.getString("arg_music_id");
    this.dsx = localBundle.getBoolean(cSH);
  }
  
  protected List<View> hE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.yh);
    return localArrayList;
  }
  
  public void initContainerView()
  {
    super.initContainerView();
    ThreadManager.getUIHandler().postDelayed(new QIMWebEffectCameraCaptureUnit.2(this), 300L);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PublishParam localPublishParam;
    Activity localActivity;
    Object localObject;
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (localPublishParam.bsZ == 1)
      {
        localActivity = this.jdField_a_of_type_Aycb.getActivity();
        localActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        localObject = localPublishParam.thumbPath;
        if (QLog.isColorLevel())
        {
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + localPublishParam.toString());
        }
        PtvFilterUtils.hs(new File(localPublishParam.videoFilePath).getParent(), localPublishParam.fakeVid);
        if (!this.dsx) {
          break label251;
        }
      }
    }
    label251:
    for (paramInt1 = 15;; paramInt1 = 32)
    {
      localActivity.getIntent().putExtra("param_entrance", paramInt1);
      localActivity.getIntent().putExtra("fake_id", localPublishParam.fakeVid);
      paramIntent = c(paramIntent);
      localObject = new SessionInfo();
      ((SessionInfo)localObject).aTl = "0";
      awtf.a(localActivity, (SessionInfo)localObject, localPublishParam, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramIntent, null);
      this.jdField_a_of_type_Axoo.apk();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eCO = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("type", 1);
    this.eCP = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("WebSceneType", aaqh.ciA);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    this.jdField_a_of_type_Aycb.getActivity().registerReceiver(this.mReceiver, paramBundle);
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    int j = 1;
    int i;
    if ((this.bys) && (!this.byt))
    {
      i = 3;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(i);
      this.daY = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("videoId", 0);
      if (this.daY == 0) {
        break label104;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(5000.0F);
    }
    for (;;)
    {
      this.yh.setOnClickListener(this);
      return localView;
      i = j;
      if (this.bys) {
        break;
      }
      i = j;
      if (!this.byt) {
        break;
      }
      i = 2;
      break;
      label104:
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(10000.0F);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.mReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtc
 * JD-Core Version:    0.7.0.1
 */