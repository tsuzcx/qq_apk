import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.10;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.8;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.9;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewWrapper;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class jtg
  extends BaseAdapter
  implements View.OnClickListener, jue.a
{
  private static int aDk = 10;
  private static int aDl = 20;
  final int TYPE_FEEDS = 1;
  final int TYPE_NULL = -1;
  String Um;
  private AccountDetailTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout;
  AccountDetailXListView jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView;
  jtg.c jdField_a_of_type_Jtg$c = null;
  private jtg.g jdField_a_of_type_Jtg$g;
  jtw jdField_a_of_type_Jtw;
  jue jdField_a_of_type_Jue;
  juk jdField_a_of_type_Juk;
  final int aCY = 0;
  final int aCZ = 2;
  final int aDa = 3;
  final int aDb = 4;
  final int aDc = 5;
  final int aDd = 6;
  final int aDe = 7;
  final int aDf = 8;
  final int aDg = 9;
  final int aDh = 10;
  final int aDi = 11;
  final int aDj = 13;
  int aDm = 0;
  private int aDn = 1;
  boolean abF = false;
  boolean abG = false;
  public boolean abH;
  private boolean abI = true;
  boolean abJ = false;
  boolean abK = false;
  QQAppInterface app;
  AccountDetail jdField_b_of_type_ComTencentMobileqqDataAccountDetail;
  EqqDetail jdField_b_of_type_ComTencentMobileqqDataEqqDetail;
  public Button bD;
  public Button bE;
  Drawable cn;
  Drawable co;
  Drawable cp;
  float density;
  private int errorStatus = AccountDetailActivity.aDJ;
  private MqqHandler f = new MqqHandler(Looper.getMainLooper());
  private AbsListView.e h = new jtp(this);
  public ImageView ho;
  public ImageView hp;
  public ImageView hq;
  View iM;
  View iN;
  private LayoutInflater inflater;
  boolean isFullScreen = false;
  boolean isVideoReady = false;
  private ArrayList<jts> jo = new ArrayList();
  private ArrayList<jts> jp = new ArrayList();
  private ArrayList<jzs> jq = new ArrayList();
  private ArrayList<jzs> jr = new ArrayList();
  Context mContext;
  private Handler mUIHandler;
  private URLDrawableDownListener.Adapter mUrlAdapter = new jtk(this);
  private long qC;
  protected TranslateAnimation r;
  Activity s;
  protected TranslateAnimation s;
  int screenHeight = 0;
  int screenWidth;
  String uin;
  private boolean xM = true;
  protected AnimatorSet y;
  
  public jtg(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail, String paramString, boolean paramBoolean, AccountDetailXListView paramAccountDetailXListView, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.app = paramQQAppInterface;
    this.inflater = LayoutInflater.from(paramContext);
    this.mContext = paramContext;
    this.jdField_s_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.aDn = kbp.a(paramQQAppInterface, paramString, paramAccountDetail);
    }
    this.abG = paramBoolean;
    this.uin = paramString;
    this.Um = paramQQAppInterface.getCurrentUin();
    this.mUIHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.density = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    this.screenHeight = ((AccountDetailActivity)this.jdField_s_of_type_AndroidAppActivity).t()[1];
    this.screenWidth = ((AccountDetailActivity)this.jdField_s_of_type_AndroidAppActivity).t()[0];
    azH();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Jtw = new jtw(paramQQAppInterface, paramContext, paramAccountDetail);
      paramQQAppInterface = jub.a(paramQQAppInterface).a(paramString);
      if (paramQQAppInterface != null)
      {
        n(paramQQAppInterface.aZ(), paramQQAppInterface.isFirstEnter);
        bJ(paramQQAppInterface.ba());
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.cardStyle == 1))
      {
        this.isFullScreen = true;
        azG();
      }
      azF();
      this.abH = ys();
      paramQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView;
      if (this.abH) {
        break label489;
      }
    }
    label489:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.lz(paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
      return;
    }
  }
  
  public jtg(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetailXListView paramAccountDetailXListView, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ImageView paramImageView3, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.app = paramQQAppInterface;
    this.inflater = LayoutInflater.from(paramContext);
    this.mContext = paramContext;
    this.uin = paramString;
    this.abF = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.ho = paramImageView1;
    this.hp = paramImageView2;
    this.iM = paramRelativeLayout;
    this.hq = paramImageView3;
    this.density = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    azH();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "runShowAnimation");
    }
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
  
  protected static boolean a(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while (ocp.getAccountType(paramAccountDetail.accountFlag) != -2) {
      return false;
    }
    return true;
  }
  
  private boolean a(jzs paramjzs)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramjzs != null) && (paramjzs.fR != null))
    {
      Iterator localIterator = paramjzs.fR.iterator();
      while (localIterator.hasNext())
      {
        jzs.a locala = (jzs.a)localIterator.next();
        switch (paramjzs.type)
        {
        default: 
          break;
        case 5: 
        case 6: 
          if (!TextUtils.isEmpty(locala.pic_url)) {
            localArrayList.add(locala);
          }
          break;
        case 7: 
          if ((!TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(locala.vid))) {
            localArrayList.add(locala);
          }
          break;
        }
      }
    }
    return localArrayList.size() != 0;
  }
  
  private void azF()
  {
    this.jq.clear();
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs.size() > 0))
    {
      Iterator localIterator = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs.iterator();
      while (localIterator.hasNext())
      {
        jzs localjzs = (jzs)localIterator.next();
        switch (localjzs.type)
        {
        default: 
          break;
        case 2: 
        case 3: 
        case 4: 
          if (b(localjzs)) {
            this.jq.add(localjzs);
          }
          break;
        }
      }
    }
  }
  
  private void azG()
  {
    this.jr.clear();
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs.size() > 0))
    {
      Iterator localIterator = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs.iterator();
      while (localIterator.hasNext())
      {
        jzs localjzs = (jzs)localIterator.next();
        switch (localjzs.type)
        {
        default: 
          break;
        case 5: 
        case 6: 
        case 7: 
          if (a(localjzs)) {
            this.jr.add(localjzs);
          }
          break;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void azL()
  {
    if ((this.jdField_a_of_type_Jtg$c == null) || (this.jdField_a_of_type_Jtg$c.iO.getVisibility() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "startShowArrowAnimation");
    }
    if (this.r != null) {
      this.r.cancel();
    }
    if (this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.r = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.r.setDuration(200L);
    this.r.setFillAfter(true);
    this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.r.setAnimationListener(new jti(this));
    this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new jtj(this));
    this.jdField_a_of_type_Jtg$c.iO.startAnimation(this.r);
  }
  
  @TargetApi(11)
  private void azM()
  {
    if (this.jdField_a_of_type_Jtg$c == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Jtg$c.iO.getAnimation() != null)
      {
        this.jdField_a_of_type_Jtg$c.iO.getAnimation().setAnimationListener(null);
        this.jdField_a_of_type_Jtg$c.iO.getAnimation().cancel();
        this.jdField_a_of_type_Jtg$c.iO.clearAnimation();
      }
      if (this.r != null)
      {
        this.r.setAnimationListener(null);
        this.r.cancel();
        this.r = null;
      }
      if (this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation != null)
      {
        this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
        this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation.cancel();
        this.jdField_s_of_type_AndroidViewAnimationTranslateAnimation = null;
      }
    } while (Build.VERSION.SDK_INT < 11);
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
  
  private void azO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Jtg$g != null) {
      this.jdField_a_of_type_Jtg$g.azP();
    }
  }
  
  private boolean b(jzs paramjzs)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) {}
    for (int i = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType;; i = -1)
    {
      if ((paramjzs != null) && (paramjzs.fR != null))
      {
        Iterator localIterator = paramjzs.fR.iterator();
        while (localIterator.hasNext())
        {
          jzs.a locala = (jzs.a)localIterator.next();
          if ((locala.aGG == 0) || ((locala.aGG == 1) && (i == 1))) {}
          for (int j = 1; j != 0; j = 0) {
            switch (paramjzs.type)
            {
            default: 
              break;
            case 2: 
              if (locala.aGH != 23) {
                break label179;
              }
              if ((TextUtils.isEmpty(locala.pic_url)) || (TextUtils.isEmpty(locala.content))) {
                break;
              }
              localArrayList.add(locala);
              break;
            }
          }
          label179:
          if (!TextUtils.isEmpty(locala.pic_url))
          {
            localArrayList.add(locala);
            continue;
            if (locala.aGH == 23)
            {
              if ((!TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(locala.title)) && (!TextUtils.isEmpty(locala.content))) {
                localArrayList.add(locala);
              }
            }
            else if ((!TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(locala.title))) {
              localArrayList.add(locala);
            }
          }
        }
      }
      if ((paramjzs != null) && (paramjzs.type == 4) && (localArrayList.size() % 2 != 0)) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      return localArrayList.size() != 0;
    }
  }
  
  private void cj(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l = System.currentTimeMillis();
    if (!aqiw.isWifiConnected(this.mContext)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jo);
    ThreadManager.post(new AccountDetailBaseAdapter.14(this, this.qC, localArrayList, paramInt1, paramInt2, l), 5, null, true);
  }
  
  private int getStatusBarHeight()
  {
    Resources localResources = this.jdField_s_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private String replaceBlank(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
      return str;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private boolean yt()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  public void B(Drawable paramDrawable)
  {
    this.cn = paramDrawable;
  }
  
  public void C(Drawable paramDrawable)
  {
    this.co = paramDrawable;
  }
  
  public void D(Drawable paramDrawable)
  {
    this.cp = paramDrawable;
  }
  
  public AccountDetail a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail;
  }
  
  public EqqDetail a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail;
  }
  
  public jue a()
  {
    if (this.jdField_a_of_type_Jue != null) {
      return this.jdField_a_of_type_Jue;
    }
    return null;
  }
  
  public void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, ImageView paramImageView3, Button paramButton)
  {
    this.ho = paramImageView1;
    this.hp = paramImageView2;
    this.iM = paramView;
    this.hq = paramImageView3;
    this.bE = paramButton;
  }
  
  public void a(AccountDetail paramAccountDetail)
  {
    this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    if (this.abG)
    {
      this.jdField_a_of_type_Jtw = new jtw(this.app, this.mContext, paramAccountDetail);
      azF();
      if (paramAccountDetail.cardStyle == 1) {
        lx(true);
      }
    }
    else
    {
      return;
    }
    lx(false);
  }
  
  void a(jtg.a parama, View paramView, int paramInt, boolean paramBoolean)
  {
    if (parama == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
      }
    }
    for (;;)
    {
      return;
      jts localjts = (jts)getItem(paramInt);
      if (localjts == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.uin + "动态消息为空");
        return;
      }
      if (localjts.jdField_a_of_type_Jtt == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.uin + "动态消息的消息属性为空");
        return;
      }
      Object localObject2;
      if (!localjts.isExposured)
      {
        localjts.isExposured = true;
        localObject2 = new JSONObject();
        if (this.abF) {}
      }
      try
      {
        ((JSONObject)localObject2).put("cha_1", localjts.jdField_a_of_type_Jtt.rowkey);
        ((JSONObject)localObject2).put("cha_2", this.aDn);
        localObject3 = this.app;
        str2 = this.uin;
        if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
        for (String str1 = "02";; str1 = "01")
        {
          anot.a((QQAppInterface)localObject3, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA2", "0X8007CA2", 0, 0, str1, String.valueOf(localjts.jdField_a_of_type_Jtt.msgtype), String.valueOf(localjts.jdField_a_of_type_Jtt.qJ), ((JSONObject)localObject2).toString());
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: item:= " + paramInt + "report msg: artical id=" + localjts.jdField_a_of_type_Jtt.qJ + "   artical name=" + localjts.title + " json=" + ((JSONObject)localObject2).toString());
          }
          paramInt = localjts.jdField_a_of_type_Jtt.msgtype;
          if (paramInt != 2) {
            break label895;
          }
          bool = true;
          localObject2 = localjts.title;
          localObject3 = Long.valueOf(localjts.jdField_a_of_type_Jtt.time);
          str2 = localjts.jdField_a_of_type_Jtt.jumpurl;
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:title =" + (String)localObject2 + "--coverUrl=" + "" + "--jumpUrl=" + str2 + "--isVideoMsg =" + bool);
          }
          if (!bool) {
            break label666;
          }
          parama.fZ.setVisibility(0);
          parama.hr.setVisibility(0);
          parama.cF.setVisibility(0);
          if (localjts.jdField_a_of_type_Jtv == null) {
            break label887;
          }
          if (!paramBoolean) {
            break label653;
          }
          str1 = localjts.jdField_a_of_type_Jtv.Un;
          parama.fZ.setText(jll.formatTime(localjts.jdField_a_of_type_Jtv.aDt));
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "当前的url是" + str1);
          }
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((Long)localObject3).longValue() > 0L)) {
            break label729;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.uin + "动态消息内容不合法");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject3;
          String str2;
          localJSONException.printStackTrace();
          continue;
          label653:
          Object localObject1 = localjts.jdField_a_of_type_Jtv.cover;
          continue;
          label666:
          parama.fZ.setVisibility(4);
          parama.hr.setVisibility(4);
          parama.cF.setVisibility(4);
          if (localjts.jdField_a_of_type_Jtu != null)
          {
            if (paramBoolean)
            {
              localObject1 = localjts.jdField_a_of_type_Jtu.Un;
              continue;
            }
            localObject1 = localjts.jdField_a_of_type_Jtu.cover;
            continue;
            label729:
            Resources localResources = this.mContext.getResources();
            ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
            if (paramBoolean) {}
            for (;;)
            {
              try
              {
                localObject1 = URLDrawable.getDrawable((String)localObject1, localColorDrawable, localColorDrawable, true);
                parama.d.setImageDrawable((Drawable)localObject1);
                parama.title.setText((CharSequence)localObject2);
                parama.time.setText(kxl.ap(((Long)localObject3).longValue()));
                paramView.setOnClickListener(new jto(this, paramInt, str2, localjts));
                return;
              }
              catch (Exception parama) {}
              localObject1 = URLDrawable.getDrawable((String)localObject1, wja.dp2px(124.0F, localResources), wja.dp2px(95.0F, localResources), localColorDrawable, localColorDrawable, true);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + parama);
            return;
          }
          label887:
          localObject1 = "";
          continue;
          label895:
          boolean bool = false;
        }
      }
    }
  }
  
  void a(jtg.b paramb, View paramView)
  {
    float f1 = this.mContext.getResources().getDisplayMetrics().density;
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    if (this.abI)
    {
      if (this.errorStatus != AccountDetailActivity.aDJ) {
        break label92;
      }
      paramb.errorTips.setText(2131689615);
      paramb.errorTips.setVisibility(0);
      paramb.nu.setVisibility(4);
      paramb.hs.setVisibility(4);
    }
    for (;;)
    {
      paramb.nu.setOnClickListener(new jtn(this, paramb));
      return;
      label92:
      if (this.errorStatus == AccountDetailActivity.NETWORK_ERROR)
      {
        paramb.errorTips.setText(2131697432);
        paramb.errorTips.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramb.hs.setImageResource(2130839516);
        paramb.nu.setVisibility(0);
      }
      else if (this.errorStatus == AccountDetailActivity.aDK)
      {
        paramb.errorTips.setText(2131689618);
        paramb.hs.setImageResource(2130842526);
        paramb.errorTips.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramb.nu.setVisibility(4);
      }
    }
  }
  
  void a(jtg.c paramc)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    label79:
    jzs localjzs;
    label166:
    label176:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Jtg$c = paramc;
        int i = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name.length();
        if ((i > 8) && (i < 13)) {
          paramc.nv.setTextSize(2, 20.0F);
        }
        paramc.nv.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name);
        if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break;
        }
        paramc.hu.setVisibility(0);
        if (this.abG)
        {
          paramc.nw.setVisibility(0);
          paramc.nw.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.summary.trim());
        }
        paramc.ht.setImageDrawable(this.cp);
        if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
          break label419;
        }
        if (!this.abK) {
          break label407;
        }
        paramc.bF.setVisibility(0);
        paramc.bF.setText(null);
        paramc.bF.setBackgroundResource(2130837597);
        this.bE.setText(2131697478);
        localjzs = (jzs)getItem(0);
      } while ((localjzs == null) || (localjzs.fR == null) || (localjzs.fR.size() == 0));
      localObject = ((jzs.a)localjzs.fR.get(0)).pic_url;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    if (localjzs.type == 6) {
      localURLDrawableOptions.mPlayGifImage = true;
    }
    Object localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
      ((URLDrawable)localObject).restartDownload();
    }
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1)) {
      hideLoadingView();
    }
    for (;;)
    {
      paramc.d.setImageDrawable((Drawable)localObject);
      azL();
      if (localjzs.type != 7) {
        break;
      }
      if (this.jdField_a_of_type_Jue == null) {
        this.jdField_a_of_type_Jue = new jue(this.jdField_s_of_type_AndroidAppActivity, this);
      }
      paramc.V.setVisibility(0);
      this.jdField_a_of_type_Jue.a(localjzs, paramc.V);
      return;
      paramc.hu.setVisibility(8);
      break label79;
      label407:
      paramc.bF.setVisibility(8);
      break label166;
      label419:
      paramc.bF.setVisibility(0);
      paramc.bF.setText(this.mContext.getResources().getString(2131697406));
      this.bE.setText(2131697479);
      break label176;
      paramc.d.setURLDrawableDownListener(this.mUrlAdapter);
      if ((this.jdField_a_of_type_Jue == null) || (!this.isVideoReady)) {
        showLoadingView();
      }
    }
  }
  
  void a(jtg.e parame, View paramView)
  {
    paramView = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.getButtonInfo();
    if (paramView != null)
    {
      parame.a.a(this.app, this.uin, this.f);
      parame.a.setData(paramView);
    }
  }
  
  void a(jtg.f paramf)
  {
    int i;
    if (this.abF)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
        return;
      }
      paramf.hy.setBackgroundColor(Color.parseColor("#3d7fe3"));
      i = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      if ((i > 8) && (i < 13)) {
        paramf.nA.setTextSize(2, 20.0F);
      }
      paramf.nA.setText(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.displayNumber))
      {
        paramf.nB.setText(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.displayNumber);
        label103:
        if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade == 0) {
          break label145;
        }
        paramf.hB.setVisibility(0);
      }
    }
    for (;;)
    {
      paramf.hz.setImageDrawable(this.cp);
      return;
      paramf.nB.setVisibility(8);
      break label103;
      label145:
      paramf.hB.setVisibility(8);
      continue;
      if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) {
        break;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0)
      {
        paramf.hy.setBackgroundDrawable(this.cn);
        paramf.hy.setImageDrawable(this.co);
        paramf.hy.setVisibility(0);
        paramf.hC.setVisibility(8);
        paramf.nC.setVisibility(8);
        paramf.nD.setVisibility(8);
        paramf.rootContainer.setBackgroundColor(0);
        label239:
        i = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name.length();
        if ((i > 8) && (i < 13)) {
          paramf.nA.setTextSize(2, 20.0F);
        }
        paramf.nA.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name);
        if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription)) {
          break label448;
        }
        paramf.nB.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      }
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break label460;
        }
        paramf.hB.setVisibility(0);
        break;
        paramf.hy.setVisibility(8);
        paramf.nC.setVisibility(0);
        paramf.nC.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.summary);
        paramf.nC.setMaxWidth((int)(this.screenWidth - this.density * 105.0F));
        paramf.hC.setVisibility(0);
        paramf.nD.setVisibility(0);
        paramf.nD.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.sharedFollowerCount + "位好友关注");
        paramf.rootContainer.setBackgroundColor(-1);
        break label239;
        label448:
        paramf.nB.setVisibility(8);
      }
      label460:
      paramf.hB.setVisibility(8);
    }
  }
  
  public void a(jtg.g paramg)
  {
    this.jdField_a_of_type_Jtg$g = paramg;
  }
  
  void a(jtg.i parami)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    parami.hD.setBackgroundDrawable(this.cn);
    parami.hD.setImageDrawable(this.co);
    int i = this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name.length();
    if ((i > 8) && (i < 13)) {
      parami.nE.setTextSize(2, 20.0F);
    }
    parami.nE.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.name);
    if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade != 0)
    {
      parami.hG.setVisibility(0);
      if ((!a(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription))) {
        break label231;
      }
      parami.nG.setText(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      label133:
      String str = replaceBlank(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.summary);
      parami.nF.setText(str);
      parami.hE.setImageDrawable(this.cp);
      if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
        break label255;
      }
      if (!this.abK) {
        break label243;
      }
      parami.bG.setVisibility(0);
      parami.bG.setBackgroundResource(2130837597);
      parami.bG.setText(null);
    }
    for (;;)
    {
      this.bE.setText(2131697478);
      return;
      parami.hG.setVisibility(8);
      break;
      label231:
      parami.nG.setVisibility(8);
      break label133;
      label243:
      parami.bG.setVisibility(8);
    }
    label255:
    parami.bG.setVisibility(0);
    parami.bG.setBackgroundResource(2130839524);
    parami.bG.setText(this.mContext.getResources().getString(2131697406));
    parami.bG.setTextColor(-1);
    this.bE.setText(2131697479);
  }
  
  boolean a(int paramInt1, View paramView, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramView == null) {
      bool1 = false;
    }
    label97:
    label124:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (paramInt1 == 1)
                  {
                    bool1 = cV(paramInt2);
                    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof jtg.a)) && (bool1 == ((jtg.a)paramView.getTag()).abL)) {}
                    for (bool1 = true;; bool1 = false) {
                      return bool1;
                    }
                  }
                  if (paramInt1 != 2) {
                    break label97;
                  }
                  if (paramView.getTag() == null) {
                    break;
                  }
                  bool1 = bool2;
                } while ((paramView.getTag() instanceof jtg.b));
                return false;
                if (paramInt1 != 0) {
                  break label124;
                }
                if (paramView.getTag() == null) {
                  break;
                }
                bool1 = bool2;
              } while ((paramView.getTag() instanceof jtg.f));
              return false;
              if (paramInt1 != 8) {
                break label153;
              }
              if (paramView.getTag() == null) {
                break;
              }
              bool1 = bool2;
            } while ((paramView.getTag() instanceof jtg.i));
            return false;
            if (paramInt1 != 9) {
              break label182;
            }
            if (paramView.getTag() == null) {
              break;
            }
            bool1 = bool2;
          } while ((paramView.getTag() instanceof jtg.d));
          return false;
          if (paramInt1 != 10) {
            break label211;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof jtg.c));
        return false;
        bool1 = bool2;
      } while (paramInt1 != 11);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof jtg.e));
    label153:
    label182:
    label211:
    return false;
  }
  
  public void azH()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnScrollListener(this.h);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnEndScrollListener(new jtq(this));
  }
  
  void azI()
  {
    this.iM.setBackgroundColor(mY());
    this.ho.setVisibility(0);
    this.ho.setBackgroundDrawable(aqdj.a(this.app, 1, this.uin));
    this.hp.setVisibility(0);
    this.hq.setVisibility(8);
  }
  
  void azJ()
  {
    this.iM.setBackgroundColor(0);
    this.ho.setVisibility(8);
    this.hp.setVisibility(8);
    this.hq.setVisibility(8);
    if (this.abG) {
      this.bE.setVisibility(8);
    }
  }
  
  void azK()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.smoothScrollToPosition(0);
    azJ();
  }
  
  void azN()
  {
    if ((this.bE != null) && (this.bE.getAnimation() != null))
    {
      this.bE.getAnimation().cancel();
      this.bE.clearAnimation();
    }
  }
  
  public void bJ(ArrayList<jts> paramArrayList)
  {
    this.jp.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jp.addAll(paramArrayList);
    }
  }
  
  void bQ(View paramView)
  {
    if (this.isFullScreen) {
      paramView.findViewById(2131373765).setVisibility(8);
    }
    do
    {
      return;
      paramView = (TextView)paramView.findViewById(2131373764);
    } while (paramView == null);
    if (this.jq.size() > 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void bR(View paramView)
  {
    this.iN = paramView;
  }
  
  public boolean cV(int paramInt)
  {
    jts localjts = (jts)this.jo.get(paramInt - this.jq.size() - 2);
    if (localjts != null)
    {
      if ((localjts.jdField_a_of_type_Jtu != null) && (localjts.jdField_a_of_type_Jtu.large == 1)) {
        return true;
      }
      if ((localjts.jdField_a_of_type_Jtv != null) && (localjts.jdField_a_of_type_Jtv.large == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public void d(EqqDetail paramEqqDetail)
  {
    this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Juk != null) {
      this.jdField_a_of_type_Juk.destroy();
    }
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    azM();
    azN();
    noy.a().clean();
  }
  
  void f(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (jtg.f)paramView.getTag();
    float f1;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    int i;
    if (yt())
    {
      f1 = 76.0F * this.density;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.hz.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.hA.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.hB.getLayoutParams();
      if (paramInt >= f1) {
        break label342;
      }
      i = (int)((100.0F - paramInt * 70 / f1) * this.density);
      localLayoutParams1.width = i;
      localLayoutParams1.height = i;
      localLayoutParams1.topMargin = ((int)(90.0F * this.density));
      i = localLayoutParams1.height + (int)(4.0F * this.density);
      localLayoutParams2.width = i;
      localLayoutParams2.height = i;
      localLayoutParams1.topMargin -= (int)(2.0F * this.density);
      i = (int)((20.0F - paramInt * 20 / f1) * this.density);
      localLayoutParams3.width = i;
      localLayoutParams3.height = i;
      if (paramInt != 0) {
        break label275;
      }
      localLayoutParams3.topMargin = ((int)(165.0F * this.density));
      localLayoutParams3.leftMargin = ((int)(72.0F * this.density));
    }
    for (;;)
    {
      paramView.hz.post(new AccountDetailBaseAdapter.8(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
      g(paramInt, f1);
      return;
      f1 = 65.0F * this.density;
      break;
      label275:
      localLayoutParams3.topMargin = (localLayoutParams1.topMargin + (int)(localLayoutParams1.height * 0.72D) + (int)(paramInt * 2 / f1 * this.density));
      localLayoutParams3.leftMargin = ((int)(localLayoutParams1.height * 0.72D) + (int)(paramInt * 2 / f1 * this.density));
      continue;
      label342:
      i = (int)(30.0F * this.density);
      localLayoutParams1.width = i;
      localLayoutParams1.height = i;
      localLayoutParams1.topMargin = ((int)(22.0F * this.density));
      i = (int)(32.0F * this.density);
      localLayoutParams2.width = i;
      localLayoutParams2.height = i;
      localLayoutParams2.topMargin = ((int)(this.density * 20.0F));
      i = (int)(8.0F * this.density);
      localLayoutParams3.height = i;
      localLayoutParams3.width = i;
    }
  }
  
  void g(int paramInt, float paramFloat)
  {
    if (paramInt >= paramFloat)
    {
      azI();
      if ((this.abG) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
        oj(paramInt);
      }
      return;
    }
    azJ();
  }
  
  void g(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (jtg.c)paramView.getTag();
    float f1 = 170.0F * this.density;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    label99:
    int i;
    if (yt())
    {
      f1 -= 64.0F * this.density / 2.0F;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.ht.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.hu.getLayoutParams();
      if (paramInt >= f1) {
        break label364;
      }
      paramView.ht.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
        break label225;
      }
      paramView.hu.setVisibility(0);
      if (paramInt > 0) {
        break label237;
      }
      i = (int)(this.density * 90.0F);
      localLayoutParams1.width = i;
      localLayoutParams1.height = i;
      i = (int)(this.density * 20.0F);
      localLayoutParams2.width = i;
      localLayoutParams2.height = i;
      localLayoutParams2.topMargin = ((int)(this.density * 58.0F));
      localLayoutParams2.leftMargin = ((int)(this.density * 58.0F));
      label181:
      paramView.ht.post(new AccountDetailBaseAdapter.9(this, paramView, localLayoutParams1, localLayoutParams2));
    }
    for (;;)
    {
      g(paramInt, f1);
      return;
      f1 -= 75.0F * this.density / 2.0F;
      break;
      label225:
      paramView.hu.setVisibility(8);
      break label99;
      label237:
      i = (int)((90.0F - paramInt * 50 / f1) * this.density);
      localLayoutParams1.width = i;
      localLayoutParams1.height = i;
      i = (int)((20.0F - paramInt * 20 / f1) * this.density);
      localLayoutParams2.width = i;
      localLayoutParams2.height = i;
      localLayoutParams2.topMargin = ((int)(localLayoutParams1.height * 0.64D) + (int)(paramInt * 2 / f1 * this.density));
      localLayoutParams2.leftMargin = ((int)(localLayoutParams1.height * 0.64D) + (int)(paramInt * 2 / f1 * this.density));
      break label181;
      label364:
      if (paramInt >= f1)
      {
        paramView.ht.setVisibility(4);
        paramView.hu.setVisibility(4);
      }
    }
  }
  
  public int getCount()
  {
    int i = 1;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null)) {}
    do
    {
      return 1;
      if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion != 1)) {
        break;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.getButtonInfo() == null);
    return 2;
    if (this.abG)
    {
      int j = this.jq.size();
      if (this.jo.size() > 0) {
        i = this.jo.size() + 1;
      }
      for (;;)
      {
        return i + (j + 1);
        if (!this.abH) {
          i = 0;
        }
      }
    }
    return 2;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null)) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 1)) || (!this.abG));
        if (paramInt != 0) {
          break;
        }
      } while ((!this.isFullScreen) || (this.jr == null) || (this.jr.size() == 0));
      return this.jr.get(paramInt);
      if (paramInt <= this.jq.size()) {
        return this.jq.get(paramInt - 1);
      }
    } while ((this.abH) || (paramInt == this.jq.size() + 1));
    return this.jo.get(paramInt - this.jq.size() - 2);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      i = 9;
    }
    do
    {
      return i;
      if (!this.abG) {
        break;
      }
      if (paramInt == 0)
      {
        if (this.isFullScreen) {
          return 10;
        }
        return 8;
      }
      if (paramInt <= this.jq.size())
      {
        switch (((jzs)this.jq.get(paramInt - 1)).type)
        {
        default: 
          return -1;
        case 2: 
          return 3;
        case 3: 
          return 4;
        }
        return 5;
      }
      if (this.abH) {
        return 2;
      }
    } while (paramInt != this.jq.size() + 1);
    return 6;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 1))
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 0: 
        return 0;
      }
      return 11;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 7;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject13 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    boolean bool2 = false;
    Object localObject1 = null;
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "getView->pos:" + paramInt + ", type:" + i);
    }
    Object localObject7;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (a(i, paramView, paramInt)) {
      switch (i)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
      }
    }
    for (;;)
    {
      localObject8 = localObject7;
      localObject7 = localObject6;
      localObject6 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject8;
      if (i == 0) {
        a((jtg.f)localObject4);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject3 = (jtg.f)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject4 = (jtg.i)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject7 = (jtg.c)paramView.getTag();
        if (this.jdField_a_of_type_Jue == null) {
          break label2595;
        }
        this.jdField_a_of_type_Jue.abN = false;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject6 = (jtg.a)paramView.getTag();
        bool1 = cV(paramInt);
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject5 = null;
        break;
        localObject5 = (jtg.b)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject6 = null;
        localObject7 = null;
        break;
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject2 = (jtg.d)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject1 = (jtg.e)paramView.getTag();
        bool1 = false;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        float f1;
        switch (i)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 0: 
          paramView = this.inflater.inflate(2131558436, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject4 = new jtg.f();
          ((jtg.f)localObject4).rootContainer = paramView.findViewById(2131380008);
          ((jtg.f)localObject4).hy = ((ImageView)paramView.findViewById(2131371098));
          ((jtg.f)localObject4).hz = ((ImageView)paramView.findViewById(2131368698));
          ((jtg.f)localObject4).hA = ((ImageView)paramView.findViewById(2131368710));
          ((jtg.f)localObject4).hB = ((ImageView)paramView.findViewById(2131364412));
          ((jtg.f)localObject4).nA = ((TextView)paramView.findViewById(2131361902));
          ((jtg.f)localObject4).nB = ((TextView)paramView.findViewById(2131361901));
          ((jtg.f)localObject4).nC = ((TextView)paramView.findViewById(2131361904));
          ((jtg.f)localObject4).hC = ((ImageView)paramView.findViewById(2131361905));
          ((jtg.f)localObject4).nD = ((TextView)paramView.findViewById(2131378213));
          ((jtg.f)localObject4).nC.setOnClickListener(this);
          paramView.setTag(localObject4);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 8: 
          paramView = this.inflater.inflate(2131558438, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject5 = new jtg.i();
          ((jtg.i)localObject5).hD = ((ImageView)paramView.findViewById(2131371098));
          ((jtg.i)localObject5).hE = ((ImageView)paramView.findViewById(2131368698));
          ((jtg.i)localObject5).hF = ((ImageView)paramView.findViewById(2131368710));
          ((jtg.i)localObject5).hG = ((ImageView)paramView.findViewById(2131364412));
          ((jtg.i)localObject5).nE = ((TextView)paramView.findViewById(2131361902));
          ((jtg.i)localObject5).nF = ((TextView)paramView.findViewById(2131361904));
          ((jtg.i)localObject5).nG = ((TextView)paramView.findViewById(2131361901));
          ((jtg.i)localObject5).bG = ((Button)paramView.findViewById(2131361900));
          this.bD = ((jtg.i)localObject5).bG;
          this.bD.setOnClickListener(this);
          paramView.findViewById(2131361906).setOnClickListener(new jth(this));
          f1 = acej.aV() / 16.0F;
          if (f1 > 1.0F) {
            ((jtg.i)localObject5).nF.setTextSize(14 / f1);
          }
          for (;;)
          {
            paramView.setTag(localObject5);
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            ((jtg.i)localObject5).nF.setTextSize(14);
          }
        case 10: 
          View localView = this.inflater.inflate(2131558437, paramViewGroup, false);
          paramView = localView.getLayoutParams();
          paramView.height = this.screenHeight;
          if (yt()) {
            paramView.height -= getStatusBarHeight();
          }
          localView.setLayoutParams(paramView);
          localView.setOnClickListener(null);
          jtg.c localc = new jtg.c();
          localc.d = ((URLImageView)localView.findViewById(2131381646));
          localc.ht = ((ImageView)localView.findViewById(2131368698));
          localc.hu = ((ImageView)localView.findViewById(2131364412));
          localc.nv = ((TextView)localView.findViewById(2131361902));
          localc.nw = ((TextView)localView.findViewById(2131361904));
          localc.V = ((FrameLayout)localView.findViewById(2131381763));
          localc.bF = ((Button)localView.findViewById(2131361900));
          localc.iO = localView.findViewById(2131361898);
          localc.hv = ((ImageView)localView.findViewById(2131361896));
          localc.hw = ((ImageView)localView.findViewById(2131361897));
          localc.hx = ((ImageView)localView.findViewById(2131370787));
          localc.nx = ((TextView)localView.findViewById(2131379724));
          f1 = acej.aV() / 16.0F;
          if (f1 > 1.0F) {
            localc.nw.setTextSize(14 / f1);
          }
          for (;;)
          {
            this.bD = localc.bF;
            this.bD.setOnClickListener(this);
            localc.iO.setOnClickListener(new jtl(this));
            localView.findViewById(2131361906).setOnClickListener(new jtm(this));
            localView.setTag(localc);
            paramView = localView;
            localObject1 = localc;
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            if (this.jdField_a_of_type_Jue == null) {
              break;
            }
            this.jdField_a_of_type_Jue.abN = true;
            paramView = localView;
            localObject1 = localc;
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            localc.nw.setTextSize(14);
          }
        case 1: 
          bool1 = cV(paramInt);
          if (bool1) {}
          for (paramView = this.inflater.inflate(2131559822, paramViewGroup, false);; paramView = this.inflater.inflate(2131559813, paramViewGroup, false))
          {
            localObject7 = new jtg.a();
            ((jtg.a)localObject7).d = ((URLImageView)paramView.findViewById(2131366165));
            ((jtg.a)localObject7).title = ((TextView)paramView.findViewById(2131366168));
            ((jtg.a)localObject7).time = ((TextView)paramView.findViewById(2131366167));
            ((jtg.a)localObject7).fZ = ((TextView)paramView.findViewById(2131366179));
            ((jtg.a)localObject7).cF = ((ImageView)paramView.findViewById(2131366178));
            ((jtg.a)localObject7).hr = ((ImageView)paramView.findViewById(2131366166));
            ((jtg.a)localObject7).abL = bool1;
            paramView.setTag(localObject7);
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            break;
          }
        case 6: 
          paramView = this.inflater.inflate(2131558431, paramViewGroup, false);
          paramView.setOnClickListener(null);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 7: 
          if (this.abF) {}
          for (paramView = this.iN;; paramView = this.jdField_a_of_type_Juk.X())
          {
            paramView.setPadding(0, wja.dp2px(7.0F, this.mContext.getResources()), 0, 0);
            paramView.setMinimumHeight(this.aDm);
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            if (this.jdField_a_of_type_Juk == null) {
              this.jdField_a_of_type_Juk = new juk(this.app, this.mContext, this.uin, this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail, false);
            }
          }
        case 2: 
          paramView = this.inflater.inflate(2131559812, paramViewGroup, false);
          localObject6 = new jtg.b();
          ((jtg.b)localObject6).errorTips = ((TextView)paramView.findViewById(2131361899));
          ((jtg.b)localObject6).hs = ((ImageView)paramView.findViewById(2131373763));
          ((jtg.b)localObject6).nu = ((TextView)paramView.findViewById(2131373779));
          paramView.setTag(localObject6);
          paramView.setMinimumHeight(this.screenHeight);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject7 = localObject13;
          break;
        case 9: 
          paramView = this.inflater.inflate(2131558432, paramViewGroup, false);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels));
          paramView.setOnClickListener(null);
          localObject3 = new jtg.d();
          ((jtg.d)localObject3).ny = ((TextView)paramView.findViewById(2131370815));
          ((jtg.d)localObject3).bZ = ((ImageView)paramView.findViewById(2131370803));
          ((jtg.d)localObject3).nz = ((TextView)paramView.findViewById(2131377215));
          paramView.setTag(localObject3);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 11: 
          paramView = this.inflater.inflate(2131558433, paramViewGroup, false);
          localObject2 = new jtg.e();
          ((jtg.e)localObject2).a = ((PublicAccountMenuBar)paramView.findViewById(2131371309));
          paramView.setTag(localObject2);
          bool1 = bool2;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
          if (i == 8)
          {
            a((jtg.i)localObject5);
          }
          else if (i == 10)
          {
            a((jtg.c)localObject1);
          }
          else if (i == 1)
          {
            a((jtg.a)localObject7, paramView, paramInt, bool1);
          }
          else if (i == 6)
          {
            bQ(paramView);
          }
          else if (i == 2)
          {
            a((jtg.b)localObject6, paramView);
          }
          else if (i == 9)
          {
            if (this.xM)
            {
              ((jtg.d)localObject3).ny.setVisibility(0);
              ((jtg.d)localObject3).bZ.setVisibility(0);
              ((jtg.d)localObject3).nz.setVisibility(8);
            }
            else
            {
              ((jtg.d)localObject3).ny.setVisibility(8);
              ((jtg.d)localObject3).bZ.setVisibility(8);
              ((jtg.d)localObject3).nz.setVisibility(0);
            }
          }
          else if (i == 11)
          {
            a((jtg.e)localObject2, paramView);
          }
          else
          {
            localObject1 = (jzs)getItem(paramInt);
            switch (i)
            {
            default: 
            case 3: 
            case 4: 
              do
              {
                do
                {
                  break;
                  localObject1 = AccountDetailBannerViewWrapper.a(this.mContext, paramView, paramViewGroup, (jzs)localObject1, this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Jtw, this.uin, this.Um);
                  paramView = (View)localObject1;
                } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.bS((View)localObject1);
                paramView = (View)localObject1;
                break;
                localObject1 = jvq.a(this.mContext, paramView, paramViewGroup, (jzs)localObject1, this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Jtw, this.uin, this.Um);
                paramView = (View)localObject1;
              } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.bS((View)localObject1);
              paramView = (View)localObject1;
              break;
            case 5: 
              paramView = jvp.a(this.mContext, paramView, paramViewGroup, (jzs)localObject1, this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Jtw, this.uin, this.Um);
            }
          }
          break;
        }
      }
      label2595:
      bool1 = false;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      localObject5 = null;
      localObject6 = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 13;
  }
  
  void h(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (jtg.i)paramView.getTag();
    float f1;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams3;
    label106:
    int i;
    if (yt())
    {
      f1 = 41.0F * this.density;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.hE.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.hF.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.hG.getLayoutParams();
      if (paramInt >= f1) {
        break label357;
      }
      paramView.hE.setVisibility(0);
      paramView.hF.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
        break label302;
      }
      paramView.hG.setVisibility(0);
      i = (int)((90.0F - paramInt * 50 / f1) * this.density);
      localLayoutParams1.width = i;
      localLayoutParams1.height = i;
      localLayoutParams1.topMargin = ((int)(60.0F * this.density));
      i = localLayoutParams1.height + (int)(4.0F * this.density);
      localLayoutParams2.width = i;
      localLayoutParams2.height = i;
      localLayoutParams2.topMargin = ((int)(58.0F * this.density));
      i = (int)((20.0F - paramInt * 20 / f1) * this.density);
      localLayoutParams3.width = i;
      localLayoutParams3.height = i;
      if (paramInt != 0) {
        break label314;
      }
      i = (int)(65.0F * this.density);
      localLayoutParams3.leftMargin = i;
      localLayoutParams3.topMargin = i;
      label260:
      paramView.hE.post(new AccountDetailBaseAdapter.10(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    }
    for (;;)
    {
      g(paramInt, f1);
      return;
      f1 = 30.0F * this.density;
      break;
      label302:
      paramView.hG.setVisibility(8);
      break label106;
      label314:
      i = (int)(0.72D * localLayoutParams1.height) + (int)(paramInt * 2 / f1 * this.density);
      localLayoutParams3.leftMargin = i;
      localLayoutParams3.topMargin = i;
      break label260;
      label357:
      paramView.hE.setVisibility(4);
      paramView.hF.setVisibility(4);
      paramView.hG.setVisibility(4);
    }
  }
  
  void hideLoadingView()
  {
    if (this.jdField_a_of_type_Jtg$c == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
    }
    this.jdField_a_of_type_Jtg$c.hx.clearAnimation();
    this.jdField_a_of_type_Jtg$c.hx.setVisibility(8);
    this.jdField_a_of_type_Jtg$c.nx.setVisibility(8);
  }
  
  public void hq(boolean paramBoolean)
  {
    this.xM = paramBoolean;
  }
  
  public void lw(boolean paramBoolean)
  {
    this.abG = paramBoolean;
  }
  
  void lx(boolean paramBoolean)
  {
    this.isFullScreen = paramBoolean;
    if (paramBoolean)
    {
      azG();
      return;
    }
    this.jr.clear();
  }
  
  public int mW()
  {
    return this.jp.size();
  }
  
  public int mX()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  protected int mY()
  {
    if ((this.abF) || (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return Color.parseColor("#3d7fe3");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor == null) || (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.equals(""))) {
      this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
    }
    return Color.parseColor("#" + this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6));
  }
  
  public void n(ArrayList<jts> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jo.clear();
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jo.addAll(paramArrayList);
      this.qC = System.nanoTime();
    }
    paramArrayList = new ArrayList();
    Iterator localIterator = this.jo.iterator();
    while (localIterator.hasNext())
    {
      jts localjts = (jts)localIterator.next();
      if ((localjts.jdField_a_of_type_Jtv != null) && (localjts.jdField_a_of_type_Jtv.aDs != 1) && (localjts.jdField_a_of_type_Jtv.aDs != 2)) {
        paramArrayList.add(localjts);
      } else if ((localjts.jdField_a_of_type_Jtt != null) && (localjts.jdField_a_of_type_Jtt.msgtype != 1) && (localjts.jdField_a_of_type_Jtt.msgtype != 2)) {
        paramArrayList.add(localjts);
      }
    }
    this.jo.removeAll(paramArrayList);
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.abH) && (!ys()))
    {
      this.abH = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.lz(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this);
    }
    super.notifyDataSetChanged();
  }
  
  public void oi(int paramInt)
  {
    this.aDm = paramInt;
  }
  
  void oj(int paramInt)
  {
    int i;
    if (this.isFullScreen) {
      if (a(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail))
      {
        i = (int)(258.0F * this.density);
        if ((this.bE.getVisibility() != 8) || (paramInt < i)) {
          break label132;
        }
        this.bE.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(100L);
        localAlphaAnimation.setFillBefore(true);
        this.bE.startAnimation(localAlphaAnimation);
      }
    }
    label132:
    while ((paramInt >= i) || (this.bE.getVisibility() != 0))
    {
      return;
      i = (int)(234.0F * this.density);
      break;
      if (a(this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail))
      {
        i = (int)(217.0F * this.density);
        break;
      }
      i = (int)(173.0F * this.density);
      break;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(100L);
    this.bE.startAnimation(localAlphaAnimation);
    this.bE.setVisibility(8);
  }
  
  void ok(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.smoothScrollBy(this.screenHeight - paramInt - this.iM.getHeight(), 500);
    azI();
    if ((this.abG) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
      oj(paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_s_of_type_AndroidAppActivity != null) && ((this.jdField_s_of_type_AndroidAppActivity instanceof View.OnClickListener)))
    {
      if (paramView == this.bD) {
        this.abK = true;
      }
      ((View.OnClickListener)this.jdField_s_of_type_AndroidAppActivity).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setErrorStatus(int paramInt)
  {
    this.errorStatus = paramInt;
  }
  
  void showErrorView()
  {
    if (this.jdField_a_of_type_Jtg$c == null) {
      return;
    }
    this.jdField_a_of_type_Jtg$c.hx.clearAnimation();
    this.jdField_a_of_type_Jtg$c.hx.setVisibility(0);
    this.jdField_a_of_type_Jtg$c.hx.setImageDrawable(this.mContext.getResources().getDrawable(2130837601));
    this.jdField_a_of_type_Jtg$c.nx.setVisibility(0);
  }
  
  void showLoadingView()
  {
    if (this.jdField_a_of_type_Jtg$c == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
    }
    this.jdField_a_of_type_Jtg$c.hx.setVisibility(0);
    this.jdField_a_of_type_Jtg$c.hx.setImageDrawable(this.mContext.getResources().getDrawable(2130844047));
    this.jdField_a_of_type_Jtg$c.hx.clearAnimation();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Jtg$c.hx.startAnimation(localRotateAnimation);
    this.jdField_a_of_type_Jtg$c.nx.setVisibility(8);
  }
  
  public boolean ys()
  {
    if (this.jo.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.abI = bool;
      if ((!this.abI) || ((this.errorStatus != AccountDetailActivity.aDJ) && (this.errorStatus != AccountDetailActivity.NETWORK_ERROR) && (this.errorStatus != AccountDetailActivity.aDK))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  class a
  {
    boolean abL;
    ImageView cF;
    URLImageView d;
    TextView fZ;
    ImageView hr;
    TextView time;
    TextView title;
    
    a() {}
  }
  
  class b
  {
    TextView errorTips;
    ImageView hs;
    TextView nu;
    
    b() {}
  }
  
  public class c
  {
    FrameLayout V;
    Button bF;
    URLImageView d;
    public ImageView ht;
    public ImageView hu;
    ImageView hv;
    ImageView hw;
    ImageView hx;
    View iO;
    TextView nv;
    TextView nw;
    TextView nx;
    
    public c() {}
  }
  
  class d
  {
    ImageView bZ;
    TextView ny;
    TextView nz;
    
    d() {}
  }
  
  class e
  {
    PublicAccountMenuBar a;
    
    e() {}
  }
  
  public class f
  {
    public ImageView hA;
    public ImageView hB;
    ImageView hC;
    ImageView hy;
    public ImageView hz;
    TextView nA;
    TextView nB;
    TextView nC;
    TextView nD;
    View rootContainer;
    
    f() {}
  }
  
  public static abstract interface g
  {
    public abstract void azP();
  }
  
  public static class h
  {
    public Pair<Integer, Integer> c;
    public URL url;
    
    public static h a(URL paramURL, Pair<Integer, Integer> paramPair)
    {
      h localh = new h();
      localh.url = paramURL;
      localh.c = paramPair;
      return localh;
    }
  }
  
  public class i
  {
    Button bG;
    ImageView hD;
    public ImageView hE;
    public ImageView hF;
    public ImageView hG;
    TextView nE;
    TextView nF;
    TextView nG;
    
    i() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtg
 * JD-Core Version:    0.7.0.1
 */