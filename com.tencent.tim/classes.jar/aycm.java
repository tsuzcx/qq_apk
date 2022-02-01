import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.b;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.g;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter.EjectaTextureCallBack;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qg.StoryQGSurfaceView;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qg.sdk.QGRenderer.QGEventListener;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.video.VideoPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.story.mode.StoryEffectTextMode.12;
import dov.com.qq.im.story.mode.StoryEffectTextMode.14;
import dov.com.qq.im.story.mode.StoryEffectTextMode.18;
import dov.com.qq.im.story.mode.StoryEffectTextMode.19;
import dov.com.qq.im.story.mode.StoryEffectTextMode.2;
import dov.com.qq.im.story.mode.StoryEffectTextMode.5;
import dov.com.qq.im.story.mode.StoryEffectTextMode.8;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aycm
  extends aycl
  implements asgl.a, DoodleEditView.b, IEventReceiver
{
  private HorizontalListView C;
  private AlphaAnimation I;
  private ImageView IL;
  private View Na;
  private View Nb;
  private View Nc;
  private asgl jdField_a_of_type_Asgl;
  private ayck jdField_a_of_type_Ayck;
  private aycm.a jdField_a_of_type_Aycm$a;
  private QQTextEjectaFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter;
  private prt.a jdField_a_of_type_Prt$a = new prt.a();
  private prt.c jdField_a_of_type_Prt$c;
  private ProgressBar aC;
  private TextView ahO;
  private TextView ahP;
  private TextView ahQ;
  private aqnt.a jdField_b_of_type_Aqnt$a = new aycv(this);
  private aqnt jdField_b_of_type_Aqnt;
  private asgp jdField_b_of_type_Asgp;
  private DoodleEditView jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
  private StoryQGSurfaceView jdField_b_of_type_ComTencentQgStoryQGSurfaceView;
  private rhf jdField_b_of_type_Rhf;
  private ObjectAnimator bS;
  private PressDarkImageButton c;
  private String cWG;
  private String cWH = "";
  private String cWI = "";
  private String cWJ = "";
  private JSONObject ct;
  private JSONObject cu;
  private JSONObject cw;
  private axpr jdField_d_of_type_Axpr = (axpr)axov.a(5);
  private DoodleView jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private PressDarkImageButton jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private Set<String> dC = new HashSet();
  private boolean dyA;
  private boolean dyp;
  private boolean dyq;
  private volatile boolean dyr;
  private boolean dys;
  private boolean dyt;
  private boolean dyu;
  private boolean dyv;
  private boolean dyw = true;
  private boolean dyx = true;
  private boolean dyy;
  private boolean dyz;
  private int eJD;
  private int eJE;
  private int eJF;
  private int eJG;
  private int eJH;
  private int eJI;
  private int eJJ = 1;
  private int eJK = 1;
  private int eJL;
  private int eJM;
  private Bitmap hA;
  private Runnable iR = new StoryEffectTextMode.2(this);
  private AdapterView.OnItemClickListener m = new aycu(this);
  private String mCurrentText = "";
  private QQTextEjectaFilter.EjectaTextureCallBack mEjectaTextureCallBack = new aycn(this);
  private View mRootView;
  private LinearLayout mv;
  private Animator p;
  private Animator q;
  private ScaleAnimation r;
  private ScaleAnimation s;
  
  public aycm(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.dwe = true;
    this.modeType = 5;
    this.jdField_d_of_type_Axpr.a = new prt(BaseApplicationImpl.getContext(), BaseApplicationImpl.sApplication.getRuntime().getAccount());
  }
  
  private String Im()
  {
    if (TextUtils.isEmpty(this.cWJ)) {
      return this.cWI;
    }
    return this.cWJ;
  }
  
  private String In()
  {
    return jpe.hP();
  }
  
  private void Zf(boolean paramBoolean)
  {
    this.dyv = paramBoolean;
    awrq localawrq = this.jdField_b_of_type_Awrq;
    if ((this.dyu) && (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localawrq.Xv(bool);
      if ((!this.dyu) || (!paramBoolean)) {
        break;
      }
      this.Nc.setVisibility(8);
      return;
    }
    this.Nc.setVisibility(0);
    if (paramBoolean)
    {
      this.ahP.setText(acfp.m(2131714852));
      this.Nc.setContentDescription(acfp.m(2131714831));
      this.IL.setVisibility(0);
      eQw();
      return;
    }
    this.ahP.setText(acfp.m(2131714843));
    this.Nc.setContentDescription(acfp.m(2131714841));
    this.IL.setVisibility(8);
    eQx();
  }
  
  private void Zg(boolean paramBoolean)
  {
    float f2 = 1.0F;
    this.dyw = paramBoolean;
    this.jdField_b_of_type_Awrq.Xw(paramBoolean);
    Object localObject = this.c;
    if (paramBoolean)
    {
      f1 = 1.0F;
      ((PressDarkImageButton)localObject).setAlpha(f1);
      localObject = this.Nc;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (float f1 = f2;; f1 = 0.5F)
    {
      ((View)localObject).setAlpha(f1);
      return;
      f1 = 0.5F;
      break;
    }
  }
  
  private void Zh(boolean paramBoolean)
  {
    if (this.Nb.getVisibility() == 0) {
      return;
    }
    this.C.setOnItemClickListener(this.m);
    if (this.I != null)
    {
      this.I.setAnimationListener(null);
      this.I.cancel();
    }
    this.Nb.setVisibility(0);
    this.I = new AlphaAnimation(0.0F, 1.0F);
    this.I.setDuration(330L);
    this.Nb.startAnimation(this.I);
    if (paramBoolean)
    {
      localObject = new TranslateAnimation(riw.getWindowScreenWidth(this.C.getContext()) / 2, 0.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      this.C.startAnimation((Animation)localObject);
    }
    this.ahQ.setContentDescription(acfp.m(2131714845));
    if (this.s != null) {
      this.s.cancel();
    }
    this.s = new ScaleAnimation(1.153846F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.s.setFillAfter(true);
    this.s.setDuration(330L);
    this.ahQ.startAnimation(this.s);
    int i = this.eJL;
    if (this.jdField_a_of_type_Prt$c != null) {}
    for (Object localObject = this.jdField_a_of_type_Prt$c.auD;; localObject = "")
    {
      rar.a("textEdit_patten", "exp_panel", i, 0, new String[] { "", localObject });
      return;
    }
  }
  
  private void Zi(boolean paramBoolean)
  {
    if ((this.Nb == null) || (this.Nb.getVisibility() == 8)) {
      return;
    }
    this.C.setOnItemClickListener(null);
    if (this.I != null)
    {
      this.I.setAnimationListener(null);
      this.I.cancel();
    }
    ScaleAnimation localScaleAnimation;
    if (paramBoolean)
    {
      this.I = new AlphaAnimation(1.0F, 0.0F);
      this.I.setDuration(250L);
      this.I.setAnimationListener(new aycp(this));
      this.Nb.startAnimation(this.I);
      this.ahQ.setContentDescription(acfp.m(2131714846));
      if (this.s != null) {
        this.s.cancel();
      }
      this.s = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      this.s.setFillAfter(true);
      localScaleAnimation = this.s;
      if (!paramBoolean) {
        break label209;
      }
    }
    label209:
    for (long l = 330L;; l = 0L)
    {
      localScaleAnimation.setDuration(l);
      this.ahQ.startAnimation(this.s);
      return;
      this.Nb.setVisibility(8);
      break;
    }
  }
  
  private StoryQGSurfaceView a()
  {
    if (this.mv.getChildCount() > 0)
    {
      View localView = this.mv.getChildAt(0);
      if ((!(localView instanceof StoryQGSurfaceView)) || (localView == null)) {
        break label43;
      }
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView = ((StoryQGSurfaceView)localView);
    }
    for (;;)
    {
      return this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView;
      label43:
      this.mv.removeAllViews();
    }
  }
  
  private String a(prt.c paramc)
  {
    if (paramc == null) {
      paramc = "";
    }
    String str2;
    String str1;
    do
    {
      return paramc;
      str2 = In() + paramc.bka + "/" + paramc.auL + "/" + paramc.auL;
      str1 = str2 + ".js";
      paramc = str1;
    } while (new File(str1).exists());
    return str2 + "_android.js";
  }
  
  private void a(prt.c paramc)
  {
    Object localObject1 = paramc.mName;
    this.ahQ.setText((CharSequence)localObject1);
    this.Nb.setContentDescription(acfp.m(2131714838) + (String)localObject1 + "’ ");
    this.eJJ = paramc.mId;
    int i = paramc.bjZ;
    if ((this.jdField_b_of_type_Asgp != null) && (this.jdField_b_of_type_Asgp.isPlaying())) {
      this.jdField_b_of_type_Asgp.stop();
    }
    if (this.jdField_b_of_type_Rhf != null) {
      this.jdField_b_of_type_Rhf.setMaxTextLength(i);
    }
    Object localObject2;
    if (paramc.aBp)
    {
      this.ahO.setVisibility(8);
      this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(8);
      if (!paramc.aBo) {
        break label382;
      }
      if (this.jdField_d_of_type_Axpr.a.aI != null)
      {
        localObject1 = (prt.a)this.jdField_d_of_type_Axpr.a.aI.get(this.eJK);
        this.jdField_a_of_type_Prt$a = ((prt.a)localObject1);
        if (localObject1 != null)
        {
          localObject2 = ((prt.a)localObject1).auH;
          Object localObject3 = ((prt.a)localObject1).auE;
          i = Color.parseColor((String)localObject2);
          int j = Color.parseColor((String)localObject3);
          this.ahO.setTextColor(i);
          localObject2 = (rgb)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
          localObject3 = ((rgb)localObject2).a();
          ((rgm)localObject3).color = i;
          ((rgb)localObject2).a((rgm)localObject3);
          this.eJE = ((prt.a)localObject1).mId;
          this.eJF = j;
          this.eJI = i;
        }
        if (this.jdField_d_of_type_Axpr.a.aI.size() > 1) {
          this.Na.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Prt$c = paramc;
      a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 11, null);
      return;
      this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      if (!TextUtils.isEmpty(this.mCurrentText))
      {
        this.ahO.setVisibility(8);
        break;
      }
      this.ahO.setVisibility(0);
      break;
      label382:
      localObject1 = paramc.auH;
      localObject2 = paramc.alg;
      i = Color.parseColor((String)localObject1);
      this.eJF = Color.parseColor((String)localObject2);
      this.eJE = paramc.bjY;
      this.eJG = 0;
      this.eJH = 0;
      this.eJI = i;
      this.ahO.setTextColor(i);
      this.mRootView.setBackgroundColor(0);
      this.Na.setVisibility(8);
    }
  }
  
  private void a(prt.c paramc, int paramInt)
  {
    if (!this.dyn) {
      return;
    }
    paramc.aBr = true;
    if ((this.jdField_a_of_type_Prt$c != null) && (this.jdField_a_of_type_Prt$c.bka == paramc.bka) && (this.dyr)) {
      eQB();
    }
    QLog.e("StoryEffectTextMode", 2, "onDownloadOfflinePkgFailed，" + paramc.bka);
  }
  
  private void a(prt.c paramc, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 0;
    ram.d("StoryEffectTextMode", "onTextFilterInfoChange");
    if (paramc == null) {}
    Object localObject;
    String str1;
    label282:
    boolean bool;
    label292:
    do
    {
      return;
      this.jdField_a_of_type_Prt$c = paramc;
      this.mCurrentText = paramString1;
      this.eJF = paramInt1;
      this.eJI = paramInt2;
      if ((!this.dyp) || (!asgf.isSoLoaded.get()))
      {
        if (!this.dyt)
        {
          this.mRootView.setBackgroundColor(this.eJF);
          this.dys = true;
        }
        this.dyr = true;
        return;
      }
      if (this.ct == null) {
        this.ct = new JSONObject();
      }
      this.jdField_a_of_type_Prt$c.aBq = oy(this.jdField_a_of_type_Prt$c.bka);
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Ayck.getCount())
      {
        paramc = this.jdField_a_of_type_Ayck.a(paramInt2);
        if (paramc.bka == this.jdField_a_of_type_Prt$c.bka) {
          paramc.aBq = this.jdField_a_of_type_Prt$c.aBq;
        }
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Ayck.notifyDataSetChanged();
      localObject = "";
      if (!this.jdField_a_of_type_Prt$c.aBq) {
        break;
      }
      this.dyr = false;
      eQz();
      Zg(true);
      if (!this.dyq) {
        eQA();
      }
      paramc = this.jdField_a_of_type_Prt$c.auL;
      str1 = a(this.jdField_a_of_type_Prt$c);
      localObject = paramc;
      if (QLog.isColorLevel())
      {
        QLog.d("StoryEffectTextMode", 2, "load " + str1);
        localObject = paramc;
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label854;
      }
      bool = true;
      Zf(bool);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if ((paramInt3 & 0x2) != 0) {
      cz("qg_TemplateChange", (String)localObject);
    }
    if ((paramInt3 & 0x10) != 0) {}
    for (;;)
    {
      try
      {
        if (this.cw == null) {
          this.cw = new JSONObject();
        }
        paramc = this.cw;
        if (this.dyu) {
          break label1159;
        }
        paramInt2 = i;
        if (this.dyt) {
          break label1159;
        }
        paramc.put("cameraStatus", paramInt2);
        cz("qg_onCameraSwitch", this.cw.toString());
      }
      catch (JSONException paramc)
      {
        String str2;
        String str3;
        label854:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "EVENT_NAME_QG_ON_CAMERA_SWITCH, JSONException:" + paramc.toString());
        continue;
      }
      if ((paramInt3 & 0x1) != 0)
      {
        paramc = b(paramInt1, 0.0F);
        str1 = b(this.eJG, 0.0F);
        str2 = b(this.eJH, 0.0F);
        str3 = b(this.eJI, 1.0F);
      }
      try
      {
        if (this.cu == null) {
          this.cu = new JSONObject();
        }
        this.cu.put("colorId", this.eJE);
        this.cu.put("backgroundColor", paramc);
        this.cu.put("backgroundColor2", str1);
        this.cu.put("backgroundColor3", str2);
        this.cu.put("textColor", str3);
        cz("qg_BackgroundChange", this.cu.toString());
      }
      catch (JSONException paramc)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "onInputTextComplete, JSONException:" + paramc.toString());
        continue;
        paramString1 = paramc;
        if (!aofk.containsEmoji(paramc)) {
          continue;
        }
        paramString1 = apri.A(paramc, "□");
        continue;
      }
      if ((paramInt3 & 0x8) != 0)
      {
        paramc = paramString1;
        if (paramString1 == null) {
          paramc = "";
        }
        if ((TextUtils.isEmpty(paramc)) && (!TextUtils.isEmpty(this.cWJ)))
        {
          paramString1 = this.cWJ;
          cz("qg_TextChange", paramString1);
        }
      }
      else
      {
        if ((paramInt3 & 0x4) == 0) {
          break label1024;
        }
      }
      try
      {
        paramc = new JSONObject();
        paramc.put("tmplName", localObject);
        if (!TextUtils.isEmpty(paramString2)) {
          paramc.put("scene", paramString2);
        }
        cz("qg_Restart", paramc.toString());
      }
      catch (JSONException paramc)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "QG_RESTART, JSONException:" + paramc.toString());
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Prt$c.auM))
      {
        paramc = In() + this.jdField_a_of_type_Prt$c.bka + "/" + this.jdField_a_of_type_Prt$c.auL + "/" + this.jdField_a_of_type_Prt$c.auM;
        if (new File(paramc).exists())
        {
          adw(paramc);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StoryEffectTextMode", 2, this.jdField_a_of_type_Prt$c.auL + " is not download！");
          }
          this.dyr = true;
          if (!this.dyt) {
            this.mRootView.setBackgroundColor(this.eJF);
          }
          this.dys = true;
          Zg(false);
          if (aqiw.isNetSupport(this.mRootView.getContext()))
          {
            a(this.jdField_a_of_type_Prt$c, false);
            break label282;
          }
          this.jdField_a_of_type_Prt$c.aBr = true;
          eQB();
          break label282;
          bool = false;
          break label292;
        }
        if (this.jdField_b_of_type_Aqnt == null) {
          break;
        }
        stopPlayAudio();
        return;
      }
      if (this.jdField_b_of_type_Aqnt == null) {
        break;
      }
      stopPlayAudio();
      return;
      label1024:
      if ((paramInt3 & 0x2) != 0) {
        stopPlayAudio();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Prt$c.auM))
      {
        paramc = In() + this.jdField_a_of_type_Prt$c.bka + "/" + this.jdField_a_of_type_Prt$c.auL + "/" + this.jdField_a_of_type_Prt$c.auM;
        if (new File(paramc).exists())
        {
          if (this.jdField_b_of_type_Aqnt != null) {
            break;
          }
          adv(paramc);
          return;
        }
        if (this.jdField_b_of_type_Aqnt == null) {
          break;
        }
        stopPlayAudio();
        return;
      }
      if (this.jdField_b_of_type_Aqnt == null) {
        break;
      }
      stopPlayAudio();
      return;
      label1159:
      paramInt2 = 1;
    }
  }
  
  private void a(prt.c paramc, boolean paramBoolean)
  {
    if ((paramc == null) || (paramc.bka == 0)) {}
    for (;;)
    {
      return;
      String str = String.valueOf(paramc.bka);
      paramc.aBr = false;
      if (!this.dC.contains(str))
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (jpa.dL(str) == null) {}
        for (boolean bool = true; (bool) || (paramBoolean); bool = false)
        {
          this.dC.add(str);
          jpa.b(str, localAppRuntime, new aycq(this, bool, paramc, str), true, 0, true);
          return;
        }
      }
    }
  }
  
  private boolean aQq()
  {
    if (this.jdField_d_of_type_Axpr.a.aH != null) {
      return ((prt.c)this.jdField_d_of_type_Axpr.a.aH.get(this.eJJ)).aBp;
    }
    return false;
  }
  
  private void adv(String paramString)
  {
    if (this.jdField_b_of_type_Aqnt != null) {
      stopPlayAudio();
    }
    this.jdField_b_of_type_Aqnt = new aqnt(paramString, new Handler());
    this.jdField_b_of_type_Aqnt.cf(this.mRootView.getContext());
    this.jdField_b_of_type_Aqnt.aFk();
    this.jdField_b_of_type_Aqnt.a(this.jdField_b_of_type_Aqnt$a);
    this.jdField_b_of_type_Aqnt.start();
  }
  
  private void adw(String paramString)
  {
    stopPlayAudio();
    adv(paramString);
  }
  
  private String b(int paramInt, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      float f = this.jdField_d_of_type_Axpr.a.bjX / 100.0F;
      paramFloat = f;
      if (!this.dyt)
      {
        if (!this.dyu) {
          break label88;
        }
        paramFloat = f;
      }
    }
    for (;;)
    {
      return String.format("rgba(%d,%d,%d,%.2f)", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Float.valueOf(paramFloat) });
      label88:
      paramFloat = 1.0F;
    }
  }
  
  private void b(prt.c paramc)
  {
    ram.d("StoryEffectTextMode", "onDownloadedResource");
    paramc.aBq = true;
    if ((!this.dyn) || (this.avm)) {}
    while ((!oy(this.jdField_d_of_type_Axpr.a.bjW)) || (this.jdField_a_of_type_Prt$c == null) || (this.jdField_a_of_type_Prt$c.bka != paramc.bka) || (!this.dyr)) {
      return;
    }
    this.dyr = false;
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectTextMode", 2, "download template resource success！ draw screen！");
    }
    a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 11, null);
  }
  
  private void bug()
  {
    if (this.jdField_a_of_type_Aycm$a == null) {
      this.jdField_a_of_type_Aycm$a = new aycm.a();
    }
    this.jdField_b_of_type_Rhf = new aycy(this, this.mRootView.getContext());
    this.jdField_b_of_type_Rhf.setContentView(2131561983);
    this.jdField_b_of_type_Rhf.a(this.jdField_a_of_type_Aycm$a);
    if (this.jdField_d_of_type_Axpr.a.aH != null)
    {
      prt.c localc = (prt.c)this.jdField_d_of_type_Axpr.a.aH.get(this.eJJ);
      if (localc != null)
      {
        int i = localc.bjZ;
        this.jdField_b_of_type_Rhf.setMaxTextLength(i);
      }
    }
    this.jdField_b_of_type_Rhf.setClipboardCallBack(new ayco(this));
    this.jdField_b_of_type_Rhf.show();
  }
  
  private void c(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    rfy localrfy = (rfy)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("GuideLineLayer");
    if (localrfy == null) {
      return;
    }
    localrfy.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  private boolean cz(String paramString1, String paramString2)
  {
    if (!ul(paramString1)) {}
    for (;;)
    {
      return false;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", paramString2);
        paramString2 = this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge();
        if (!paramString2.hasRegistered(paramString1)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StoryEffectTextMode", 2, "dispatchNormalEvent, key:" + paramString1 + ", value:" + localJSONObject.toString());
        }
        paramString2.dispatchJSEvent(paramString1, localJSONObject);
        return true;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  private void eQA()
  {
    Object localObject = In() + this.jdField_d_of_type_Axpr.a.bjW + "/qg.js";
    if (new File((String)localObject).exists())
    {
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
      localObject = In() + this.jdField_d_of_type_Axpr.a.bjW + "/" + this.jdField_d_of_type_Axpr.a.auC + "/" + this.jdField_d_of_type_Axpr.a.auC + ".js";
      if (QLog.isColorLevel()) {
        QLog.d("StoryEffectTextMode", 2, "load " + (String)localObject);
      }
      if (!new File((String)localObject).exists()) {
        break label308;
      }
      this.dyq = true;
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
    }
    label308:
    do
    {
      try
      {
        localObject = new JSONObject(this.jdField_d_of_type_Axpr.a.auB);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12(this, (JSONObject)localObject), 300L);
        do
        {
          return;
          eQB();
        } while (!QLog.isColorLevel());
        QLog.e("StoryEffectTextMode", 2, (String)localObject + " is not exists!");
        return;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("StoryEffectTextMode", 2, "EVENT_NAME_QG_INIT_CONFIG" + localJSONException.toString());
        return;
      }
      eQB();
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextMode", 2, localJSONException + " is not exists!");
  }
  
  private void eQB()
  {
    ThreadManager.getUIHandler().post(new StoryEffectTextMode.14(this));
  }
  
  private void eQC()
  {
    if (this.q == null)
    {
      this.q = ObjectAnimator.ofFloat(this.mRootView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(400L);
      this.q.addListener(new aycr(this));
    }
    if ((this.p != null) && (this.p.isRunning())) {
      this.p.cancel();
    }
    this.mRootView.setVisibility(0);
    this.q.start();
  }
  
  private void eQD()
  {
    if (this.p == null)
    {
      this.p = ObjectAnimator.ofFloat(this.mRootView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      this.p.addListener(new aycs(this));
    }
    if ((this.q != null) && (this.q.isRunning())) {
      this.q.cancel();
    }
    if (this.mRootView.getVisibility() != 8) {
      this.p.start();
    }
  }
  
  private void eQE()
  {
    if ((!this.dyn) || (this.avm)) {
      return;
    }
    ram.d("StoryEffectTextMode", "initQGEnvironment success!");
    eQz();
    eQF();
  }
  
  private void eQF()
  {
    if (this.dyp) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView == null) {
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView = a();
    }
    if (this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView != null) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.a();
        if (localObject != null)
        {
          this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView = ((ayce)localObject).a(this.jdField_a_of_type_Awsy);
          this.mv.addView(this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView);
        }
      }
      if (this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView == null) {
        break label269;
      }
      this.jdField_a_of_type_Asgl = new asgl();
      this.jdField_a_of_type_Asgl.a(this);
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().registerJsModule(this.jdField_a_of_type_Asgl);
      this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.setExtResPath(In() + this.jdField_d_of_type_Axpr.a.bjW + "/");
      if (this.jdField_b_of_type_Asgp == null)
      {
        this.jdField_b_of_type_Asgp = new asgp();
        VideoPlayer.activeMediaPlayer(this.jdField_b_of_type_Asgp);
      }
      this.jdField_b_of_type_Asgp.XJ(In() + this.jdField_d_of_type_Axpr.a.bjW + "/");
      localObject = new ayct(this);
      if (i == 0) {
        break;
      }
      this.jdField_b_of_type_Awrq.a().queueEvent(new StoryEffectTextMode.18(this, (QGRenderer.QGEventListener)localObject));
      return;
    }
    this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.setQGEventListener((QGRenderer.QGEventListener)localObject);
    return;
    label269:
    ram.e("StoryEffectTextMode", "QGEnvironment and mQGGLView is null!! ");
  }
  
  private void eQG()
  {
    QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
    if (localQQFilterRenderManager == null)
    {
      CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Awsy.a();
      if ((localCameraCaptureView instanceof EffectsCameraCaptureView)) {
        ((EffectsCameraCaptureView)localCameraCaptureView).dLh();
      }
    }
    if ((localQQFilterRenderManager != null) && (!localQQFilterRenderManager.hasQQFilter(181)))
    {
      this.cWG = localQQFilterRenderManager.pushChainBasedStackTopChain(181, this.mEjectaTextureCallBack);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter = ((QQTextEjectaFilter)localQQFilterRenderManager.getQQFilterByType(181));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setIsNeedCameraTexture(this.dyu);
    }
    if (oy(this.jdField_d_of_type_Axpr.a.bjW)) {
      eQA();
    }
  }
  
  private void eQk()
  {
    int j = 0;
    if (this.dyy) {
      return;
    }
    Object localObject1 = new rgb(this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject2 = new rfy(this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    localObject2 = new rgj.a().a(new DoodleLayout.g(new rgf[] { localObject1, localObject2 })).a(this.mRootView.getWidth()).b(this.mRootView.getHeight()).a();
    this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((rgj)localObject2);
    ((rgb)localObject1).a(new aycm.b());
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleView(this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnTextEditListener();
    this.dyy = true;
    this.cWJ = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getIntent().getStringExtra("text_filter_default_screen_touch_tips");
    if (this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getIntent().getStringExtra("share_url_target_url") == null) {}
    for (int i = 0;; i = 1)
    {
      this.eJL = i;
      this.cWI = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getString(2131699987);
      if (this.ahO != null) {
        this.ahO.setText(Im());
      }
      if (this.jdField_a_of_type_Ayck != null) {
        break label336;
      }
      localObject1 = this.jdField_d_of_type_Axpr.a.aH;
      localObject2 = new ArrayList(((SparseArray)localObject1).size());
      i = j;
      while (i < ((SparseArray)localObject1).size())
      {
        ((List)localObject2).add(((SparseArray)localObject1).valueAt(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_Ayck = new ayck((List)localObject2);
    this.C.setDividerWidth(rpq.dip2px(this.C.getContext(), 10.0F));
    this.C.setAdapter(this.jdField_a_of_type_Ayck);
    this.C.setOnItemClickListener(this.m);
    label336:
    localObject1 = this.jdField_a_of_type_Ayck.a(this.jdField_a_of_type_Ayck.OQ());
    this.Nb.setContentDescription(acfp.m(2131714839) + ((prt.c)localObject1).mName + "’ ");
    this.r = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    this.r.setFillAfter(true);
    this.r.setDuration(0L);
    this.ahQ.startAnimation(this.r);
  }
  
  private void eQl()
  {
    jpa.b(this.jdField_d_of_type_Axpr.a.bjW + "", BaseApplicationImpl.getApplication().getRuntime(), true, new aycw(this));
    int i = 0;
    while (i < this.jdField_d_of_type_Axpr.a.aH.size())
    {
      int j = this.jdField_d_of_type_Axpr.a.aH.keyAt(i);
      a((prt.c)this.jdField_d_of_type_Axpr.a.aH.get(j), true);
      i += 1;
    }
  }
  
  private void eQm()
  {
    this.jdField_b_of_type_Awrq.eFr();
    if (this.dyy) {
      if (TextUtils.isEmpty(((rgb)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().text)) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Zf(bool);
      this.c.setVisibility(0);
      if (this.dyu) {
        this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      return;
    }
  }
  
  private void eQn()
  {
    rgm localrgm = ((rgb)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a();
    if (this.dyu)
    {
      this.c.setContentDescription(acfp.m(2131714849));
      this.c.setImageResource(2130847041);
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (TextUtils.isEmpty(localrgm.text)) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      Zf(bool);
      return;
      this.c.setContentDescription(acfp.m(2131714850));
      this.c.setImageResource(2130847040);
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      break;
    }
  }
  
  private void eQo()
  {
    boolean bool;
    String str1;
    label129:
    int i;
    if ((!this.dyu) || (this.dyt))
    {
      bool = true;
      this.dyu = bool;
      eQn();
      if (this.dyu) {
        eQq();
      }
      a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 17, null);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null)
      {
        if (this.dyu)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setImagePath(null);
          this.dyt = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setIsNeedCameraTexture(this.dyu);
      }
      if ((this.dyu) && (TextUtils.isEmpty(this.mCurrentText))) {
        eQs();
      }
      if (!this.dyu) {
        break label178;
      }
      str1 = "open_cam";
      i = this.eJL;
      if (!TextUtils.isEmpty(this.mCurrentText)) {
        break label185;
      }
    }
    label178:
    label185:
    for (String str2 = "0";; str2 = "1")
    {
      rar.a("textEdit", str1, i, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      str1 = "close_cam";
      break label129;
    }
  }
  
  private void eQp()
  {
    int i = this.jdField_b_of_type_Awrq.Qx();
    boolean bool;
    label40:
    String str1;
    if (i == 2)
    {
      bool = true;
      this.dyx = bool;
      if (!this.dyx) {
        break label98;
      }
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(acfp.m(2131714835));
      if (i != 1) {
        break label114;
      }
      str1 = "use_frontCam";
      label49:
      i = this.eJL;
      if (!TextUtils.isEmpty(this.mCurrentText)) {
        break label121;
      }
    }
    label98:
    label114:
    label121:
    for (String str2 = "0";; str2 = "1")
    {
      rar.a("textEdit", str1, i, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(acfp.m(2131714848));
      break label40;
      str1 = "use_backCam";
      break label49;
    }
  }
  
  private void eQq()
  {
    if (((this.jdField_b_of_type_Awrq.Qy() == 1) && (this.dyx)) || ((this.jdField_b_of_type_Awrq.Qy() == 2) && (!this.dyx)))
    {
      this.jdField_b_of_type_Awrq.Qx();
      if (this.dyx) {
        this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(acfp.m(2131714840));
      }
    }
    else
    {
      return;
    }
    this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(acfp.m(2131714837));
  }
  
  private void eQr()
  {
    if (!this.dyv)
    {
      eQs();
      return;
    }
    Object localObject;
    if (aQq())
    {
      this.jdField_b_of_type_Awrq.eFp();
      this.c.setVisibility(8);
      localObject = new arib(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity(), 2131561628);
      this.dyz = false;
      ((arib)localObject).a(0, acfp.m(2131714851), 0, new aycx(this));
      ThreadManager.getUIHandler().postDelayed(new StoryEffectTextMode.8(this, (arib)localObject), 5000L);
      return;
    }
    this.jdField_b_of_type_Awrq.dKK();
    rar.a("textEdit", "takePhoto", this.eJL, 0, new String[0]);
    int i = this.eJL;
    String str2;
    if (this.dyt)
    {
      localObject = "3";
      str2 = this.jdField_a_of_type_Prt$c.auD;
      if (this.jdField_a_of_type_Prt$a == null) {
        break label254;
      }
      str1 = this.jdField_a_of_type_Prt$a.auD;
      label163:
      rar.a("textEdit", "done_textEdit", i, 0, new String[] { localObject, str2, str1 });
      i = this.eJL;
      if (!this.dyt) {
        break label260;
      }
      localObject = "3";
      label207:
      str2 = this.jdField_a_of_type_Prt$c.auD;
      if (this.jdField_a_of_type_Prt$a == null) {
        break label267;
      }
    }
    label260:
    label267:
    for (String str1 = this.jdField_a_of_type_Prt$a.auD;; str1 = "")
    {
      prt.a = new prt.b(i, (String)localObject, str2, str1);
      return;
      localObject = "0";
      break;
      label254:
      str1 = "";
      break label163;
      localObject = "0";
      break label207;
    }
  }
  
  private void eQs()
  {
    if (!this.dyn) {
      return;
    }
    bug();
    if (!TextUtils.isEmpty(this.mCurrentText)) {
      this.ahO.setVisibility(8);
    }
    Zi(true);
  }
  
  private void eQt()
  {
    int i;
    if (this.jdField_d_of_type_Axpr.a.aI != null) {
      i = 0;
    }
    for (;;)
    {
      prt.a locala;
      Object localObject1;
      Object localObject2;
      if (i < this.jdField_d_of_type_Axpr.a.aI.size())
      {
        int j = this.jdField_d_of_type_Axpr.a.aI.keyAt(i);
        if (((prt.a)this.jdField_d_of_type_Axpr.a.aI.get(j)).mId != this.eJK) {
          break label331;
        }
        if (i >= this.jdField_d_of_type_Axpr.a.aI.size() - 1) {
          break label297;
        }
        i = this.jdField_d_of_type_Axpr.a.aI.keyAt(i + 1);
        locala = (prt.a)this.jdField_d_of_type_Axpr.a.aI.get(i);
        this.jdField_a_of_type_Prt$a = locala;
        localObject1 = locala.auH;
        localObject2 = locala.auE;
        i = Color.parseColor((String)localObject1);
        j = Color.parseColor((String)localObject2);
        this.eJI = i;
        this.eJE = locala.mId;
        this.eJF = j;
        if (TextUtils.isEmpty(locala.auF)) {
          break label315;
        }
        this.eJG = Color.parseColor(locala.auF);
        label196:
        if (TextUtils.isEmpty(locala.auG)) {
          break label323;
        }
      }
      label297:
      label315:
      label323:
      for (this.eJH = Color.parseColor(locala.auG);; this.eJH = 0)
      {
        a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 1, null);
        this.ahO.setTextColor(i);
        this.eJK = locala.mId;
        localObject1 = (rgb)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        localObject2 = ((rgb)localObject1).a();
        ((rgm)localObject2).color = Color.parseColor(locala.auH);
        ((rgb)localObject1).a((rgm)localObject2);
        return;
        i = this.jdField_d_of_type_Axpr.a.aI.keyAt(0);
        break;
        this.eJG = 0;
        break label196;
      }
      label331:
      i += 1;
    }
  }
  
  private void eQu()
  {
    if (this.Nb.getVisibility() == 0)
    {
      Zi(true);
      i = this.eJL;
      if (this.jdField_a_of_type_Prt$c != null) {}
      for (str = this.jdField_a_of_type_Prt$c.auD;; str = "")
      {
        rar.a("textEdit_patten", "clk_close", i, 0, new String[] { "", str });
        return;
      }
    }
    Zh(false);
    int i = this.eJL;
    if (this.jdField_a_of_type_Prt$c != null) {}
    for (String str = this.jdField_a_of_type_Prt$c.auD;; str = "")
    {
      rar.a("textEdit_patten", "clk_open", i, 0, new String[] { "", str });
      return;
    }
  }
  
  private void eQv()
  {
    if ((this.jdField_a_of_type_Prt$c != null) && (!this.jdField_a_of_type_Prt$c.aBq))
    {
      if ((!aqiw.isNetSupport(this.mRootView.getContext())) || (this.jdField_a_of_type_Prt$c.aBr)) {
        eQB();
      }
    }
    else {
      return;
    }
    QQToast.a(this.mRootView.getContext(), acfp.m(2131714853), 0).show();
  }
  
  private void eQw()
  {
    if (this.bS == null)
    {
      int i = rpq.dip2px(this.mRootView.getContext(), 4.0F);
      this.bS = ObjectAnimator.ofFloat(this.IL, "translationX", new float[] { 0.0F, i, 0.0F });
      this.bS.setDuration(1000L);
      this.bS.setRepeatCount(-1);
    }
    this.bS.start();
  }
  
  private void eQx()
  {
    if ((this.bS != null) && (this.bS.isRunning())) {
      this.bS.cancel();
    }
  }
  
  private void eQy()
  {
    ram.d("StoryEffectTextMode", "showSoLoading");
    if (this.aC != null) {
      this.aC.setVisibility(0);
    }
    if (this.C != null) {
      this.C.setVisibility(8);
    }
  }
  
  private void eQz()
  {
    ram.d("StoryEffectTextMode", "dismissSoLoading");
    if (this.aC != null) {
      this.aC.setVisibility(8);
    }
    if (this.C != null) {
      this.C.setVisibility(0);
    }
  }
  
  private Bitmap g(boolean paramBoolean)
  {
    do
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.Lp()) {
          this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
        }
        localBitmap1 = Bitmap.createBitmap(this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas;
        int j;
        int i;
        Bitmap localBitmap2 = localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localCanvas = new Canvas(localBitmap1);
          if ((paramBoolean) && (this.jdField_d_of_type_Axpr.a.aI != null))
          {
            j = Color.parseColor(((prt.a)this.jdField_d_of_type_Axpr.a.aI.get(this.eJK)).auE);
            i = j;
            if (this.dyu) {
              i = j | 0x80000000;
            }
            localCanvas.drawColor(i);
          }
          this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.draw(localCanvas);
          localBitmap2 = localBitmap1;
          return localBitmap2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Bitmap localBitmap1;
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localBitmap1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, "getTextDrawBitmap exception:", localOutOfMemoryError1);
    return localBitmap1;
  }
  
  private void initData()
  {
    this.jdField_d_of_type_Axpr = ((axpr)axov.a(5));
    prt.c localc;
    String str;
    if (this.jdField_d_of_type_Axpr.a.aH != null)
    {
      localc = (prt.c)this.jdField_d_of_type_Axpr.a.aH.get(this.eJJ);
      if (localc != null) {
        str = localc.alg;
      }
    }
    try
    {
      this.eJF = Color.parseColor(str);
      this.eJE = localc.bjY;
      if (!TextUtils.isEmpty(localc.mName)) {
        this.cWH = localc.mName;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryEffectTextMode", 2, "initTextFilterBgColor, Exception:" + localException.toString());
        }
      }
    }
  }
  
  private boolean oy(int paramInt)
  {
    if (paramInt == 0) {}
    String str;
    do
    {
      return false;
      str = jpa.dL(String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("StoryEffectTextMode", 2, "bid = " + paramInt + ", version = " + str);
      }
    } while (str == null);
    return true;
  }
  
  private boolean ul(String paramString)
  {
    if ((!this.dyp) || (this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, " dispatcEvent, isEjectaInited: " + this.dyp);
      }
    }
    do
    {
      return false;
      if (this.dyq) {
        break;
      }
      this.dyr = true;
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, " dispatcEvent, mIsLoadTemplateManager: " + this.dyq);
    return false;
    return true;
  }
  
  public void E(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10014) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null) && (!TextUtils.isEmpty(paramIntent)))
      {
        this.dyt = true;
        a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 17, null);
        this.dyu = false;
        eQn();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setImagePath(paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d("StoryEffectTextMode", 2, "selectedPic, " + paramIntent);
        }
        paramInt1 = this.eJL;
        if (!TextUtils.isEmpty(this.mCurrentText)) {
          break label156;
        }
      }
    }
    label156:
    for (paramIntent = "0";; paramIntent = "1")
    {
      rar.a("textEdit", "done_upload", paramInt1, 0, new String[] { "", paramIntent });
      return;
    }
  }
  
  public String Io()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Prt$c.auM)) {
      return In() + this.jdField_a_of_type_Prt$c.bka + "/" + this.jdField_a_of_type_Prt$c.auL + "/" + this.jdField_a_of_type_Prt$c.auM;
    }
    return null;
  }
  
  public void Zj(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.c.setVisibility(0);
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    }
  }
  
  public boolean aQp()
  {
    int i = this.eJL;
    if (TextUtils.isEmpty(this.mCurrentText)) {}
    for (String str = "0";; str = "1")
    {
      rar.a("textEdit", "clk_upload", i, 0, new String[] { "", str });
      if (this.dyw) {
        break;
      }
      eQv();
      return true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    c(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public void eQH()
  {
    this.c.setVisibility(8);
    this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
  }
  
  public void eQg()
  {
    if (aQq()) {
      a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 4, "captureVideo");
    }
    for (;;)
    {
      this.Na.setVisibility(8);
      Zi(true);
      this.ahQ.clearAnimation();
      this.ahQ.setVisibility(8);
      if (this.dyu) {
        rar.a("textEdit", "takeVideo", this.eJL, 0, new String[0]);
      }
      return;
      this.eJD = 0;
      this.hA = g(false);
    }
  }
  
  public void eQh()
  {
    if (!aQq())
    {
      this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(0);
      this.hA.recycle();
      this.hA = null;
      this.Na.setVisibility(0);
      this.eJD = 0;
    }
    this.ahQ.setVisibility(0);
    if (this.r != null) {
      this.ahQ.startAnimation(this.r);
    }
    this.c.setVisibility(0);
    if (this.dyu) {
      this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    }
    String str1 = "2";
    if (this.dyA) {
      str1 = "0";
    }
    if ((!this.jdField_a_of_type_Prt$c.aBp) && (this.jdField_a_of_type_Prt$a != null)) {}
    for (String str2 = this.jdField_a_of_type_Prt$a.auD;; str2 = "")
    {
      rar.a("textEdit", "done_textEdit", this.eJL, 0, new String[] { str1, this.jdField_a_of_type_Prt$c.auD, str2 });
      prt.a = new prt.b(this.eJL, str1, this.jdField_a_of_type_Prt$c.auD, str2);
      return;
    }
  }
  
  public void eQi()
  {
    if (!aQq())
    {
      this.eJD = 0;
      this.hA = g(false);
    }
    int i;
    String str2;
    if ((this.jdField_a_of_type_Prt$c != null) && (this.jdField_a_of_type_Prt$a != null))
    {
      i = this.eJL;
      str2 = this.jdField_a_of_type_Prt$c.auD;
      if ((this.jdField_a_of_type_Prt$c.aBp) || (this.jdField_a_of_type_Prt$a == null)) {
        break label170;
      }
      str1 = this.jdField_a_of_type_Prt$a.auD;
      rar.a("textEdit", "done_textEdit", i, 0, new String[] { "1", str2, str1 });
      i = this.eJL;
      str2 = this.jdField_a_of_type_Prt$c.auD;
      if (!this.jdField_a_of_type_Prt$c.aBp) {
        break label176;
      }
    }
    label170:
    label176:
    for (String str1 = "";; str1 = this.jdField_a_of_type_Prt$a.auD)
    {
      prt.a = new prt.b(i, "1", str2, str1);
      if (this.dyu) {
        rar.a("textEdit", "takePhoto", this.eJL, 0, new String[0]);
      }
      return;
      str1 = "";
      break;
    }
  }
  
  public void eQj()
  {
    if (this.hA != null)
    {
      this.hA.recycle();
      this.hA = null;
      this.eJD = 0;
    }
  }
  
  public void enh()
  {
    ram.d("StoryEffectTextMode", "QG onMethodRequest getTextConfig");
    ThreadManager.getUIHandler().post(new StoryEffectTextMode.19(this));
  }
  
  public String getCurrentText()
  {
    return this.mCurrentText;
  }
  
  public void initView()
  {
    ram.d("StoryEffectTextMode", "initView");
    if (this.mRootView != null) {
      return;
    }
    initData();
    this.mRootView = LayoutInflater.from(this.mBaseView.getContext()).inflate(2131561106, (ViewGroup)this.mBaseView, false);
    if (this.mRootView.getParent() == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      ViewGroup localViewGroup = (ViewGroup)this.mBaseView.findViewById(2131367348);
      if (localViewGroup != null) {
        localViewGroup.addView(this.mRootView, 2, localLayoutParams);
      }
    }
    this.mRootView.setOnClickListener(this);
    this.mv = ((LinearLayout)this.mBaseView.findViewById(2131366300));
    this.ahP = ((TextView)this.mRootView.findViewById(2131372354));
    this.IL = ((ImageView)this.mRootView.findViewById(2131372353));
    this.Nb = this.mRootView.findViewById(2131379316);
    this.C = ((HorizontalListView)this.mRootView.findViewById(2131379315));
    this.aC = ((ProgressBar)this.mRootView.findViewById(2131379314));
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)this.mRootView.findViewById(2131379465));
    this.Nc = this.mRootView.findViewById(2131372352);
    this.Nc.setOnClickListener(this);
    this.c = ((PressDarkImageButton)this.mRootView.findViewById(2131372659));
    this.c.setOnClickListener(this);
    this.ahO = ((TextView)this.mRootView.findViewById(2131369293));
    this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)this.mRootView.findViewById(2131379466));
    this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.mRootView.findViewById(2131379054));
    this.jdField_d_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.ahQ = ((TextView)this.mRootView.findViewById(2131379318));
    this.ahQ.setOnClickListener(this);
    this.Na = this.mRootView.findViewById(2131364877);
    this.Na.setOnClickListener(this);
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setEditListener(this);
    }
    this.ahQ.setText(this.cWH);
    this.mRootView.setVisibility(0);
    this.ahO.setVisibility(8);
    Zf(false);
    this.mRootView.setBackgroundColor(this.eJF);
  }
  
  public boolean isSupport()
  {
    return this.jdField_d_of_type_Axpr.aPs();
  }
  
  public boolean isValidate()
  {
    return (this.dyn) && (!this.avm);
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    stopPlayAudio();
    if (this.jdField_b_of_type_Asgp != null)
    {
      VideoPlayer.unActiveMediaPlayer(this.jdField_b_of_type_Asgp);
      this.jdField_b_of_type_Asgp.destroy();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    eQm();
    a(this.jdField_a_of_type_Prt$c, this.mCurrentText, this.eJF, this.eJI, 4, "onResume");
    if (this.jdField_b_of_type_Asgp != null) {
      this.jdField_b_of_type_Asgp.onResume();
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    Zi(false);
    if (this.jdField_b_of_type_Asgp != null) {
      this.jdField_b_of_type_Asgp.onStop();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      eQu();
      continue;
      eQt();
      continue;
      if (!this.dyw)
      {
        eQv();
      }
      else
      {
        eQs();
        continue;
        if (!this.dyw)
        {
          eQv();
        }
        else
        {
          eQo();
          continue;
          eQp();
          continue;
          if (!this.dyw) {
            eQv();
          } else {
            eQr();
          }
        }
      }
    }
  }
  
  public void shutdown()
  {
    super.shutdown();
    stopPlayAudio();
    Object localObject = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.a();
    if (localObject != null) {
      ((ayce)localObject).aI(this.iR);
    }
    Zi(true);
    if (this.dyo) {
      eQD();
    }
    for (;;)
    {
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null)
      {
        CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Awsy.a();
        if ((localCameraCaptureView != null) && (!TextUtils.isEmpty(this.cWG)))
        {
          String str = this.cWG;
          this.cWG = null;
          localCameraCaptureView.queueEvent(new StoryEffectTextMode.5(this, (QQFilterRenderManager)localObject, str));
        }
      }
      if (this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView != null)
      {
        this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Asgl);
        this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge().clearRegisteredEvents();
        this.jdField_b_of_type_ComTencentQgStoryQGSurfaceView.reset();
      }
      this.dyp = false;
      this.dyq = false;
      this.eJM = 0;
      return;
      if (this.mRootView != null) {
        this.mRootView.setVisibility(8);
      }
    }
  }
  
  public void stopPlayAudio()
  {
    if (this.jdField_b_of_type_Aqnt != null)
    {
      this.jdField_b_of_type_Aqnt.release();
      this.jdField_b_of_type_Aqnt = null;
    }
  }
  
  public void uz(boolean paramBoolean)
  {
    super.uz(paramBoolean);
    initView();
    eQk();
    label51:
    Object localObject1;
    Object localObject2;
    String str1;
    int i;
    int j;
    if (this.dyo)
    {
      eQC();
      if (TextUtils.isEmpty(((rgb)this.jdField_d_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().text)) {
        break label572;
      }
      paramBoolean = true;
      Zf(paramBoolean);
      this.mRootView.setVisibility(0);
      if (this.jdField_d_of_type_Axpr.a.aH != null)
      {
        localObject1 = (prt.c)this.jdField_d_of_type_Axpr.a.aH.get(this.eJJ);
        if (localObject1 != null)
        {
          localObject2 = ((prt.c)localObject1).mName;
          this.ahQ.setText((CharSequence)localObject2);
          if (!((prt.c)localObject1).aBo) {
            break label593;
          }
          if (this.jdField_d_of_type_Axpr.a.aI != null)
          {
            localObject2 = (prt.a)this.jdField_d_of_type_Axpr.a.aI.get(this.eJK);
            if (localObject2 != null)
            {
              this.jdField_a_of_type_Prt$a = ((prt.a)localObject2);
              str1 = ((prt.a)localObject2).auH;
              String str2 = ((prt.a)localObject2).auE;
              String str3 = ((prt.a)localObject2).auF;
              String str4 = ((prt.a)localObject2).auG;
              i = Color.parseColor(str1);
              j = Color.parseColor(str2);
              this.ahO.setTextColor(i);
              this.eJE = ((prt.a)localObject2).mId;
              this.eJF = j;
              if (TextUtils.isEmpty(str3)) {
                break label577;
              }
              this.eJG = Color.parseColor(str3);
              label253:
              if (TextUtils.isEmpty(str4)) {
                break label585;
              }
              this.eJH = Color.parseColor(str4);
              label270:
              this.eJI = i;
            }
            if (this.jdField_d_of_type_Axpr.a.aI.size() > 1) {
              this.Na.setVisibility(0);
            }
          }
          label300:
          this.jdField_a_of_type_Prt$c = ((prt.c)localObject1);
          if (!this.dyt)
          {
            this.mRootView.setBackgroundColor(this.eJF);
            this.dys = true;
          }
        }
      }
      if (!this.jdField_a_of_type_Prt$c.aBp) {
        break label668;
      }
      this.ahO.setVisibility(8);
      label348:
      if (this.dyu) {
        eQq();
      }
      i = this.eJL;
      localObject2 = this.jdField_a_of_type_Prt$c.auD;
      if ((!this.jdField_a_of_type_Prt$c.aBp) && (this.jdField_a_of_type_Prt$a != null)) {
        break label689;
      }
      localObject1 = "";
      label394:
      rar.a("textEdit", "exp_textEdit", i, 0, new String[] { "", localObject2, localObject1 });
      eQy();
      Zg(false);
      localObject1 = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.a();
      if (localObject1 == null) {
        break label701;
      }
      ((ayce)localObject1).aH(this.iR);
    }
    for (;;)
    {
      eQl();
      if (QLog.isColorLevel()) {
        QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "initCaptureMode textFilter switch, mIsEnable: " + this.jdField_d_of_type_Axpr.a.mIsEnable + ", mIsDPCEnable:" + this.jdField_d_of_type_Axpr.a.aBn + ", ver:" + jpa.dL("1018") + ", QGLoader.soloaded:" + asgf.isSoLoaded.get() + ", Build.MODEL:" + Build.MODEL);
      }
      return;
      Zh(false);
      break;
      label572:
      paramBoolean = false;
      break label51;
      label577:
      this.eJG = 0;
      break label253;
      label585:
      this.eJH = 0;
      break label270;
      label593:
      localObject2 = ((prt.c)localObject1).auH;
      str1 = ((prt.c)localObject1).alg;
      i = Color.parseColor((String)localObject2);
      j = Color.parseColor(str1);
      this.eJE = ((prt.c)localObject1).bjY;
      this.eJF = j;
      this.eJG = 0;
      this.eJH = 0;
      this.eJI = i;
      this.ahO.setTextColor(i);
      this.Na.setVisibility(8);
      break label300;
      label668:
      if (!TextUtils.isEmpty(this.mCurrentText)) {
        break label348;
      }
      this.ahO.setVisibility(0);
      break label348;
      label689:
      localObject1 = this.jdField_a_of_type_Prt$a.auD;
      break label394;
      label701:
      ram.e("StoryEffectTextMode", "warning!!! warning!!! warning!!!, QGEnvironment is null!!!");
    }
  }
  
  public class a
    implements rhf.a
  {
    public rgm c;
    Runnable mRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
    
    a() {}
    
    public void a(boolean paramBoolean, rgm paramrgm)
    {
      rgb localrgb = (rgb)aycm.a(aycm.this).a("TextLayer");
      if (paramBoolean)
      {
        localrgb.tI(true);
        return;
      }
      paramrgm.color = aycm.d(aycm.this);
      localrgb.a(paramrgm);
      localrgb.tI(false);
      if (aycm.a(aycm.this))
      {
        aycm.a(aycm.this).setVisibility(8);
        aycm.a(aycm.this).setVisibility(8);
      }
      if (!TextUtils.equals(paramrgm.text, aycm.a(aycm.this)))
      {
        aycm.a(aycm.this, aycm.a(aycm.this), paramrgm.text, aycm.c(aycm.this), aycm.d(aycm.this), 12, "onKeyboardHide");
        aycm.this.a.eFO();
      }
      if ((!TextUtils.isEmpty(paramrgm.text)) || (aycm.a(aycm.this))) {
        aycm.b(aycm.this).setVisibility(8);
      }
      for (;;)
      {
        aycm.a(aycm.this).dismiss();
        return;
        aycm.b(aycm.this).setVisibility(0);
      }
    }
    
    public void buc()
    {
      ((rgb)aycm.a(aycm.this).a("TextLayer")).startAnimate();
    }
    
    public void c(rgm paramrgm)
    {
      this.c = paramrgm;
      ThreadManager.getUIHandler().removeCallbacks(this.mRunnable);
      ThreadManager.getUIHandler().postDelayed(this.mRunnable, 500L);
    }
    
    public void xj(int paramInt) {}
    
    public void xo(int paramInt)
    {
      ((rgb)aycm.a(aycm.this).a("TextLayer")).xm(paramInt);
    }
  }
  
  class b
    implements rgb.a
  {
    int eJN = wja.dp2px(18.0F, aycm.a(aycm.this).getResources());
    
    b() {}
    
    public boolean a(rgb.b paramb)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (aycm.a(aycm.this) != null)
      {
        bool1 = bool2;
        if (paramb != null)
        {
          aycm.a(aycm.this).setVisibility(0);
          if (aycm.a(aycm.this).a.Lp())
          {
            Object localObject = aycm.a(aycm.this).a.a();
            ((riy.a)localObject).aIp = false;
            if ((localObject instanceof rgb.b))
            {
              localObject = (rgb)aycm.a(aycm.this).a("TextLayer");
              if (localObject != null) {
                ((rgb)localObject).btV();
              }
            }
          }
          aycm.a(aycm.this).a.b(paramb);
          paramb.aIp = true;
          aycm.a(aycm.this).requestLayout();
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public void ad(float paramFloat)
    {
      if (paramFloat == 1.0F)
      {
        rgm localrgm = ((rgb)aycm.a(aycm.this).a("TextLayer")).a();
        localrgm.size = this.eJN;
        aycm.a(aycm.this).a(localrgm);
      }
    }
    
    public void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
    {
      rfy localrfy = (rfy)aycm.a(aycm.this).a("GuideLineLayer");
      if (localrfy != null) {
        localrfy.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
      }
    }
    
    public void btW()
    {
      aycm.e(aycm.this);
      aycm.a(aycm.this, true);
    }
    
    public void btX()
    {
      aycm.a(aycm.this, "");
      aycm.b(aycm.this).setVisibility(0);
      aycm.c(aycm.this, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycm
 * JD-Core Version:    0.7.0.1
 */