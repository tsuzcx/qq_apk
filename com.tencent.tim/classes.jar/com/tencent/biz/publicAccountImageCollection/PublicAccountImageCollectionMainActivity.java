package com.tencent.biz.publicAccountImageCollection;

import acbn;
import acfp;
import ahgq;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anqv;
import anrd;
import aqhq;
import arwv;
import ausj;
import auss;
import aviz;
import com.tencent.biz.pubaccount.PublicAccountBrowser.a;
import com.tencent.biz.pubaccount.PublicAccountBrowser.b;
import com.tencent.biz.pubaccount.PublicAccountBrowser.c;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jld;
import jzu;
import jzv;
import kbp;
import mqq.app.MobileQQ;
import noy;
import otc;
import otd;
import otd.b;
import otq;
import otr;
import ots;
import ott;
import otu;
import otv;
import otw;
import otx;
import oub;
import oub.a;
import oub.c;
import oub.d;
import rwt;

public class PublicAccountImageCollectionMainActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static boolean ayr;
  public static int bfZ = 2;
  public static int bga = 3;
  public static int bgb = 4;
  public String Wz = "";
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private jzu jdField_a_of_type_Jzu;
  public float[] aA = new float[9];
  public float[] aB = new float[9];
  private String abY;
  private boolean ahe;
  private String ard = "";
  private String are = "";
  private String arf = "";
  private String arh = "";
  private boolean ayq;
  private PublicAccountImageView jdField_b_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView;
  private jzv jdField_b_of_type_Jzv;
  private otd jdField_b_of_type_Otd;
  private oub.a jdField_b_of_type_Oub$a;
  private int bfR;
  private int bfV;
  private int bfW;
  private int bfX;
  int bfY = 1;
  int bgc;
  int bgd;
  int bge;
  ElasticHorScrView c;
  ViewGroup cl;
  ViewGroup cm;
  public Bitmap cn;
  private int commentCount;
  ElasticHorScrView d;
  private Drawable drawable;
  public ausj e;
  public LinearLayout ee;
  private RelativeLayout fl;
  private boolean flag;
  private boolean hasReport;
  private boolean isFollowed;
  private boolean isLiked;
  ImageView lA;
  ImageView lB;
  ImageView lC;
  ImageView lD;
  ImageView lE;
  ImageView lF;
  private int likeCount;
  private AppInterface mApp;
  Context mContext;
  float mDensity;
  protected Handler mHandler = new ott(this);
  public ScaleGestureDetector mScaleGestureDetector;
  private Handler mUIHandler;
  Matrix matrix = new Matrix();
  private ArrayList<oub.d> mk;
  public String puin = "";
  private TranslateAnimation r;
  private TranslateAnimation s;
  float scale;
  private long startTime;
  private String uin = "";
  TextView vL;
  TextView vM;
  TextView vO;
  public String webUrl = "";
  Matrix x = new Matrix();
  private AnimatorSet y;
  public Matrix y;
  
  private void Z(boolean paramBoolean, int paramInt)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756117);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localReportDialog.setContentView(2131559818);
    if (!paramBoolean) {
      if (paramInt == 6) {
        ((TextView)localReportDialog.findViewById(2131382303)).setText(2131697415);
      }
    }
    for (;;)
    {
      localReportDialog.show();
      this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivity.10(this, localReportDialog), 1000L);
      return;
      if (paramInt == 10)
      {
        ((TextView)localReportDialog.findViewById(2131382303)).setText(2131697414);
      }
      else
      {
        ((TextView)localReportDialog.findViewById(2131382303)).setText(2131697413);
        continue;
        this.ahe = false;
      }
    }
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.y == null) {
        this.y = new AnimatorSet();
      }
      this.y.playTogether(new Animator[] { paramView1, paramView2 });
      this.y.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private List<PublicAccountBrowser.a>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = super.getString(2131698630);
    ((PublicAccountBrowser.a)localObject).icon = 2130839252;
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).action = 2;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = super.getString(2131698643);
    ((PublicAccountBrowser.a)localObject).icon = 2130839253;
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).action = 3;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = super.getString(2131698652);
    ((PublicAccountBrowser.a)localObject).icon = 2130839256;
    ((PublicAccountBrowser.a)localObject).action = 9;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = super.getString(2131698633);
    ((PublicAccountBrowser.a)localObject).icon = 2130839249;
    ((PublicAccountBrowser.a)localObject).action = 10;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = super.getString(2131698627);
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).icon = 2130843489;
    ((PublicAccountBrowser.a)localObject).action = 4;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.a locala = new PublicAccountBrowser.a();
    locala.label = super.getString(2131698616);
    locala.iconNeedBg = true;
    locala.icon = 2130845044;
    locala.action = 6;
    locala.argus = "";
    ((ArrayList)localObject).add(locala);
    locala = new PublicAccountBrowser.a();
    locala.label = super.getString(2131698622);
    locala.icon = 2130839246;
    locala.iconNeedBg = true;
    locala.action = 1;
    locala.argus = "";
    ((ArrayList)localObject).add(locala);
    locala = new PublicAccountBrowser.a();
    locala.label = super.getString(2131698628);
    locala.icon = 2130843479;
    locala.iconNeedBg = true;
    locala.action = 11;
    locala.argus = "";
    ((ArrayList)localObject).add(locala);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  @TargetApi(11)
  private void aUN()
  {
    if (this.ee.getAnimation() != null)
    {
      this.ee.getAnimation().setAnimationListener(null);
      this.ee.getAnimation().cancel();
      this.ee.clearAnimation();
    }
    if (this.r != null)
    {
      this.r.setAnimationListener(null);
      this.r.cancel();
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.setAnimationListener(null);
      this.s.cancel();
      this.s = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.y != null)
      {
        Iterator localIterator = this.y.getChildAnimations().iterator();
        while (localIterator.hasNext())
        {
          Animator localAnimator = (Animator)localIterator.next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.y.end();
        this.y.cancel();
      }
      this.y = null;
    }
  }
  
  private void bhl()
  {
    this.jdField_a_of_type_Jzu = ((jzu)this.mApp.getBusinessHandler(93));
    this.jdField_b_of_type_Jzv = new otv(this);
    this.jdField_a_of_type_Jzu.a(this.jdField_b_of_type_Jzv);
  }
  
  private void bhm()
  {
    if (!TextUtils.isEmpty(this.Wz))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "fetchAllArticleInfo");
      }
      bho();
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.4(this));
    }
  }
  
  private void bhn()
  {
    if (this.jdField_b_of_type_Oub$a == null) {
      return;
    }
    this.webUrl = this.jdField_b_of_type_Oub$a.articleUrl;
    this.are = this.jdField_b_of_type_Oub$a.title;
    this.arh = this.jdField_b_of_type_Oub$a.imgUrl;
    this.puin = this.jdField_b_of_type_Oub$a.puin;
    if (TextUtils.isEmpty(this.arf)) {
      this.arf = "来自QQ看点的分享";
    }
    this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivity.5(this), 0L);
    updateFollowState();
    pZ(this.arh);
    this.jdField_a_of_type_Jzu.lB(this.webUrl);
  }
  
  private void bho()
  {
    this.jdField_b_of_type_Oub$a = PublicAccountImageCollectionPreloadManager.a().a(this.Wz);
    if (this.jdField_b_of_type_Oub$a != null)
    {
      PublicAccountImageCollectionPreloadManager.a().rd(true);
      bhn();
      PublicAccountImageCollectionPreloadManager.a().b(this.jdField_b_of_type_Jzv);
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(acbn.bnD + this.Wz))
    {
      PublicAccountImageCollectionPreloadManager.a().a(this.Wz, this.jdField_b_of_type_Jzv);
      PublicAccountImageCollectionPreloadManager.a().rd(true);
      return;
    }
    PublicAccountImageCollectionPreloadManager.a().rd(false);
    this.ayq = true;
  }
  
  private void bhp()
  {
    Intent localIntent = new Intent(this, PublicAccountImageCollectionCommentActivity.class);
    if (!TextUtils.isEmpty(this.abY)) {
      localIntent.putExtra("comment", this.abY);
    }
    localIntent.putExtra("anonymous", this.ahe);
    startActivityForResult(localIntent, 100);
    kbp.a(null, this.puin, "0X8007B9A", "0X8007B9A", 0, 0, this.Wz, this.webUrl, "", "", false);
  }
  
  private void bhq()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.Wz;
    localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(79).a("web", this.webUrl, (String)localObject1, "", "").a(acfp.m(2131710232) + this.are).a();
    Object localObject2 = this.arh;
    anqv localanqv = anrd.a(2);
    localanqv.aU((String)localObject2, this.are, this.arf);
    ((AbsShareMsg)localObject1).addItem(localanqv);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_thumb", this.arh);
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ahgq.f(this, (Intent)localObject2, 21);
  }
  
  private void bhr()
  {
    this.cl.removeView(this.jdField_b_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    this.flag = false;
  }
  
  private int dK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 16;
    case 0: 
      return bfZ;
    case 1: 
      return bga;
    }
    return bgb;
  }
  
  private void initData()
  {
    this.Wz = getIntent().getStringExtra("articleid");
    this.ard = getIntent().getStringExtra("recommend_source");
    if (this.ard == null) {
      this.ard = "";
    }
    this.bfV = getIntent().getIntExtra("recommend_position", 0);
    this.bfW = getIntent().getIntExtra("click_source", 1);
    this.bfX = getIntent().getIntExtra("source_for_report", 16);
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.uin = this.mApp.getCurrentAccountUin();
    this.jdField_b_of_type_Otd.b(this.jdField_b_of_type_Oub$a);
    this.jdField_b_of_type_Otd.cf(this.mk);
    this.jdField_b_of_type_Otd.pW(this.Wz);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setAdapter(this.jdField_b_of_type_Otd);
  }
  
  @TargetApi(11)
  private void initUI()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    bck();
    this.mUIHandler = new Handler();
    this.lA = ((ImageView)super.findViewById(2131368890));
    this.lA.setOnClickListener(this);
    this.lB = ((ImageView)super.findViewById(2131368891));
    this.lB.setOnClickListener(this);
    this.fl = ((RelativeLayout)super.findViewById(2131377557));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = ((PublicAccountImageCollectionListView)super.findViewById(2131368883));
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setDividerHeight(0);
    this.cl = ((ViewGroup)getWindow().getDecorView());
    this.jdField_b_of_type_Otd = new otd(this, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView, (QQAppInterface)super.getAppInterface());
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setOnTouchListener(new otq(this));
    this.ee = ((LinearLayout)super.findViewById(2131381396));
    this.lC = ((ImageView)super.findViewById(2131368892));
    this.lD = ((ImageView)super.findViewById(2131368875));
    this.vL = ((TextView)super.findViewById(2131368874));
    this.lE = ((ImageView)super.findViewById(2131368894));
    this.vM = ((TextView)super.findViewById(2131368893));
    this.lF = ((ImageView)super.findViewById(2131368888));
    this.vO = ((TextView)super.findViewById(2131368876));
    this.lC.setOnClickListener(this);
    this.lD.setOnClickListener(this);
    this.lE.setOnClickListener(this);
    this.lF.setOnClickListener(this);
    this.vO.setOnClickListener(this);
    this.vM.setOnClickListener(this);
    this.vL.setOnClickListener(this);
  }
  
  private void pY(String paramString)
  {
    if ((this.vO == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.vO.setText(paramString);
  }
  
  private void pZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        paramString = URLDrawable.getDrawable(paramString, null, null);
        if ((paramString.getStatus() != 1) || (!(paramString.getCurrDrawable() instanceof RegionDrawable))) {
          break;
        }
        this.cn = ((RegionDrawable)paramString.getCurrDrawable()).getBitmap();
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("qqBaseActivity", 2, "initData", paramString);
    return;
    paramString.setURLDrawableListener(new ots(this, paramString));
    paramString.startDownload();
  }
  
  private void vb(int paramInt)
  {
    kbp.a(null, this.puin, "0X8007A7A", "0X8007A7A", 0, 0, this.Wz, this.webUrl, "" + dK(this.bfX), "" + paramInt, false);
  }
  
  private void vc(int paramInt)
  {
    kbp.a(null, this.puin, "0X8007C18", "0X8007C18", 0, 0, this.Wz, this.webUrl, "" + paramInt, "", false);
  }
  
  @TargetApi(9)
  private View x(int paramInt)
  {
    View localView = super.getLayoutInflater().inflate(2131559311, null);
    this.c = ((ElasticHorScrView)localView.findViewById(2131377768));
    this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
    if (paramInt == 1) {
      this.d.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131368140);
    GridView localGridView1 = (GridView)localView.findViewById(2131368141);
    Object localObject1 = (TextView)localView.findViewById(2131362018);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.mDensity));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131721058);
    ((TextView)localObject1).setOnClickListener(new otr(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.c.setOverScrollMode(2);
      this.d.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label426;
      }
    }
    label426:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      paramInt = ((List)localObject1).size();
      localGridView2.setNumColumns(paramInt);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((paramInt - 1) * 10 + paramInt * 75 + 3) * this.mDensity));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.b(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.bgd = paramInt;
      int i = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((i * 75 + (i - 1) * 10 + 3) * this.mDensity));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i);
      localGridView1.setAdapter(new PublicAccountBrowser.b(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      i = ((ViewGroup.LayoutParams)localObject1).width;
      this.bgc = i;
      localView.post(new PublicAccountImageCollectionMainActivity.12(this, paramInt, i));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  @TargetApi(11)
  public void aTb()
  {
    if (this.ee.getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "hide user guide");
    }
    aUN();
    this.mUIHandler.post(new PublicAccountImageCollectionMainActivity.6(this));
  }
  
  protected void ar(String paramString, boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    String str = this.mApp.getCurrentAccountUin();
    aviz.a(paramString).c(str).b(this, str, 101, null);
  }
  
  @TargetApi(11)
  public void asF()
  {
    if (this.ee.getVisibility() == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "show user guide");
    }
    if (this.r != null) {
      this.r.cancel();
    }
    if (this.s != null) {
      this.s.cancel();
    }
    this.r = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.r.setDuration(200L);
    this.r.setFillAfter(true);
    this.s = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.s.setDuration(300L);
    this.s.setFillAfter(true);
    this.r.setAnimationListener(new otw(this));
    this.s.setAnimationListener(new otx(this));
    this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivity.9(this), 300L);
  }
  
  void azD()
  {
    showActionSheet(1);
  }
  
  void bck()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131167595);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    if ((VersionUtils.isJellyBean()) && (VersionUtils.isHoneycomb())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (VersionUtils.isHoneycomb()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new otu(this));
    }
  }
  
  void bhh()
  {
    showActionSheet(2);
  }
  
  void bhi()
  {
    bhp();
  }
  
  void bhj()
  {
    if ((this.jdField_b_of_type_Oub$a != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Oub$a.articleUrl)))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_b_of_type_Oub$a.ari);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
  }
  
  void bhk()
  {
    boolean bool;
    if (!this.isLiked)
    {
      bool = true;
      this.isLiked = bool;
      if (!this.isLiked) {
        break label121;
      }
      this.likeCount += 1;
      this.lE.setImageResource(2130842458);
      kbp.a(null, this.puin, "0X8007B95", "0X8007B95", 0, 0, this.Wz, this.webUrl, "", "", false);
    }
    for (;;)
    {
      this.vM.setText("" + this.likeCount);
      this.jdField_a_of_type_Jzu.b(this.Wz, this.isLiked, false);
      return;
      bool = false;
      break;
      label121:
      this.likeCount -= 1;
      this.lE.setImageResource(2130842457);
      kbp.a(null, this.puin, "0X8007B96", "0X8007B96", 0, 0, this.Wz, this.webUrl, "", "", false);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        aviz.A(this, paramIntent);
        return;
        switch (paramInt2)
        {
        default: 
          return;
        }
        ForwardUtils.a((QQAppInterface)this.mApp, this, getApplicationContext(), paramIntent, null);
        return;
      } while (paramIntent == null);
      this.abY = paramIntent.getStringExtra("comment");
      this.ahe = paramIntent.getBooleanExtra("anonymous", false);
      if (paramInt2 == 0)
      {
        pY(this.abY);
        return;
      }
    } while (paramInt2 != -1);
    pY(getString(2131697411));
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivity.13(this));
  }
  
  public void doOnBackPressed()
  {
    n(1, 0, "");
    super.doOnBackPressed();
    kbp.a(null, this.puin, "0X8007B8F", "0X8007B8F", 0, 0, this.Wz, this.webUrl, "", "", false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.startTime = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559821);
    initUI();
    initData();
    bhl();
    bhm();
    this.mScaleGestureDetector = new ScaleGestureDetector(this, new a(null));
    this.mContext = getBaseContext();
    if (VersionUtils.isIceScreamSandwich()) {
      getWindow().setFlags(16777216, 16777216);
    }
    otc.a().ba(this);
    otc.a().bgX();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.doOnDestory();
    }
    if (this.jdField_b_of_type_Otd != null) {
      this.jdField_b_of_type_Otd.doOnDestory();
    }
    if (this.mContext != null) {
      this.mContext = null;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.jdField_a_of_type_Jzu != null)
    {
      if (otc.a().rS() == 1) {
        this.jdField_a_of_type_Jzu.aBx();
      }
      this.jdField_a_of_type_Jzu = null;
    }
    aUN();
    noy.a().clean();
    otc.a().bb(this);
    PublicAccountImageCollectionPreloadManager.a().removeObserver();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    updateFollowState();
    if (this.jdField_b_of_type_Otd != null) {
      this.jdField_b_of_type_Otd.doOnResume();
    }
  }
  
  public void n(int paramInt1, int paramInt2, String paramString)
  {
    int i;
    if (!this.hasReport)
    {
      this.hasReport = true;
      if (this.jdField_b_of_type_Oub$a != null)
      {
        i = (int)(System.currentTimeMillis() - this.startTime);
        this.jdField_a_of_type_Jzu.a(this.Wz, this.puin, this.jdField_b_of_type_Oub$a.articleUrl, paramInt1, paramInt2, paramString, i, this.mk);
        if (this.jdField_b_of_type_Oub$a.infos == null) {
          break label183;
        }
        paramString = this.jdField_b_of_type_Oub$a.infos.iterator();
        paramInt1 = 0;
        while (paramString.hasNext())
        {
          if (!((oub.c)paramString.next()).hasRead) {
            break label180;
          }
          paramInt1 += 1;
        }
      }
    }
    for (;;)
    {
      kbp.a(null, this.puin, "0X8007B8B", "0X8007B8B", 0, 0, this.Wz, this.webUrl, "" + i, "" + paramInt1, false);
      return;
      label180:
      break;
      label183:
      paramInt1 = 0;
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
      doOnBackPressed();
      bhh();
      continue;
      bhi();
      continue;
      bhk();
      continue;
      bhk();
      continue;
      bhj();
      continue;
      bhj();
      continue;
      azD();
      continue;
      bhi();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    int i;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (this.e.isShowing()) {
          this.e.dismiss();
        }
        i = ((PublicAccountBrowser.c)localObject1).a.action;
        localObject1 = this.webUrl;
        if (i == 1)
        {
          ((ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject1);
          rwt.ez(2, 2131692332);
          vc(1011);
        }
        else
        {
          Object localObject2;
          if (i == 11)
          {
            Object localObject3 = null;
            try
            {
              localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
              localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
              String str = arwv.encodeHexStr((String)localObject1 + 200 + (String)localObject3 + "jubao@article@123").toLowerCase();
              localObject1 = "https://jubao.mp.qq.com/mobile/report?qq=" + this.uin + "&mp_uin=" + this.puin + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject3 + "&sign=" + str + "&article_url=" + (String)localObject1;
              localObject3 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", (String)localObject1);
              ((Intent)localObject3).putExtra("hide_more_button", true);
              startActivity((Intent)localObject3);
              vc(1008);
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d("qqBaseActivity", 2, "encode url failed, because UTF-8 is unknown");
                  localObject2 = localObject3;
                }
              }
            }
          }
          else if (i == 2)
          {
            bhq();
            vb(1001);
            if (this.bge == 2) {
              vc(1001);
            }
          }
          else if (i == 4)
          {
            localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
            ((Intent)localObject2).putExtra("normal", true);
            try
            {
              startActivity((Intent)localObject2);
              vc(1006);
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              rwt.ez(1, 2131697436);
            }
          }
          else if (i == 3)
          {
            jld.a(this.mApp, this, this.arh, this.are, this.arf, this.webUrl);
            vb(1002);
            if (this.bge == 2) {
              vc(1002);
            }
          }
          else
          {
            if (i != 6) {
              break;
            }
            ar(localActivityNotFoundException, true);
            vc(1007);
          }
        }
      }
    } while ((i != 9) && (i != 10));
    if (i == 9)
    {
      vb(1003);
      if (this.bge == 2) {
        vc(1003);
      }
    }
    for (;;)
    {
      oub.a(this, this.are, this.arf, localActivityNotFoundException, this.cn, i);
      break;
      vb(1004);
      if (this.bge == 2) {
        vc(1004);
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public void showActionSheet(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_b_of_type_Otd == null)) {
      return;
    }
    if (this.e == null)
    {
      this.e = ((ausj)auss.a(this, null));
      View localView1 = x(paramInt);
      this.e.setActionContentView(localView1, null);
    }
    for (;;)
    {
      try
      {
        if (this.e.isShowing()) {
          break;
        }
        this.e.show();
        if (paramInt != 2) {
          break label126;
        }
        this.bge = 2;
        kbp.a(null, this.puin, "0X8007A79", "0X8007A79", 0, 0, this.Wz, this.webUrl, "", "", false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = x(paramInt);
      this.e.setActionContentView(localView2, null);
    }
    label126:
    this.bge = 1;
    kbp.a(null, this.puin, "0X8007A80", "0X8007A80", 0, 0, this.Wz, this.webUrl, "", "", false);
  }
  
  void updateFollowState()
  {
    ThreadManager.post(new PublicAccountImageCollectionMainActivity.16(this), 5, null, true);
  }
  
  class a
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    private a() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      PublicAccountImageCollectionMainActivity.this.scale = paramScaleGestureDetector.getScaleFactor();
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "缩放比例是" + PublicAccountImageCollectionMainActivity.this.scale);
      }
      QLog.d("qqBaseActivity", 2, "catch zoom");
      if (PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this))
      {
        if (PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).getScaleType() != ImageView.ScaleType.MATRIX) {
          PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).setScaleType(ImageView.ScaleType.MATRIX);
        }
        PublicAccountImageCollectionMainActivity.this.x.set(PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).getImageMatrix());
        PublicAccountImageCollectionMainActivity.this.x.getValues(PublicAccountImageCollectionMainActivity.this.aB);
        if (PublicAccountImageCollectionMainActivity.this.aB[0] > PublicAccountImageCollectionMainActivity.this.aA[0] * 3.0F)
        {
          PublicAccountImageCollectionMainActivity.this.scale = (PublicAccountImageCollectionMainActivity.this.aA[0] * 3.0F / PublicAccountImageCollectionMainActivity.this.aB[0]);
          if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "the last scale is" + PublicAccountImageCollectionMainActivity.this.scale);
          }
        }
        PublicAccountImageCollectionMainActivity.this.matrix.set(PublicAccountImageCollectionMainActivity.this.x);
        PublicAccountImageCollectionMainActivity.this.matrix.postScale(PublicAccountImageCollectionMainActivity.this.scale, PublicAccountImageCollectionMainActivity.this.scale, PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).getWidth() / 2, PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).getHeight() / 2);
        PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).setImageMatrix(PublicAccountImageCollectionMainActivity.this.matrix);
        return true;
      }
      PublicAccountImageCollectionMainActivity.this.cm = PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).q();
      if ((PublicAccountImageCollectionMainActivity.this.cm != null) && ((PublicAccountImageCollectionMainActivity.this.cm.getTag() instanceof otd.b)))
      {
        paramScaleGestureDetector = (ZImageView)PublicAccountImageCollectionMainActivity.this.cm.getChildAt(0);
        if ((paramScaleGestureDetector != null) && ((paramScaleGestureDetector instanceof ZImageView)))
        {
          PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this, paramScaleGestureDetector.getDrawable());
          int i = paramScaleGestureDetector.getWidth();
          int j = paramScaleGestureDetector.getHeight();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.addRule(15);
          PublicAccountImageCollectionMainActivity.this.y = paramScaleGestureDetector.getImageMatrix();
          PublicAccountImageCollectionMainActivity.this.y.getValues(PublicAccountImageCollectionMainActivity.this.aA);
          PublicAccountImageCollectionMainActivity.this.matrix.set(PublicAccountImageCollectionMainActivity.this.y);
          PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this, new PublicAccountImageView(PublicAccountImageCollectionMainActivity.this.mContext, PublicAccountImageCollectionMainActivity.this.mHandler, PublicAccountImageCollectionMainActivity.this.y, PublicAccountImageCollectionMainActivity.this.bfY, i, j));
          PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).setImageDrawable(PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this));
          PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).setImageMatrix(PublicAccountImageCollectionMainActivity.this.matrix);
          PublicAccountImageCollectionMainActivity.this.cl.addView(PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this), localLayoutParams);
          PublicAccountImageCollectionMainActivity.b(PublicAccountImageCollectionMainActivity.this, true);
          i = ((otd.b)PublicAccountImageCollectionMainActivity.this.cm.getTag()).position;
          if (PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).mj != null)
          {
            paramScaleGestureDetector = ((oub.c)PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).mj.get(i - 1)).url;
            kbp.a(null, PublicAccountImageCollectionMainActivity.this.puin, "0X8007B91", "0X8007B91", 0, 0, PublicAccountImageCollectionMainActivity.this.Wz, PublicAccountImageCollectionMainActivity.this.webUrl, paramScaleGestureDetector, "1", false);
          }
        }
      }
      PublicAccountImageCollectionMainActivity.a(PublicAccountImageCollectionMainActivity.this).bhe();
      return true;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */