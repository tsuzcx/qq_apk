import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxm
  implements View.OnClickListener
{
  private ValueAnimator E;
  private klw jdField_a_of_type_Klw;
  private mtg.l jdField_a_of_type_Mtg$l;
  private mxm.b jdField_a_of_type_Mxm$b;
  private mxs jdField_a_of_type_Mxs;
  private final int aUB;
  private int aVD;
  private boolean apU;
  private VideoInfo c;
  private Activity mActivity;
  private boolean mIsShowing;
  
  public mxm(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.aUB = wja.dp2px(2.0F, paramActivity.getResources());
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Klw = new klw();
    this.jdField_a_of_type_Klw.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Mxs = new mxs();
    this.jdField_a_of_type_Mxs.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private mxm.b a()
  {
    if (this.jdField_a_of_type_Mxm$b != null) {
      return this.jdField_a_of_type_Mxm$b;
    }
    if ((this.c.a != null) && (this.jdField_a_of_type_Mxs.b(this.c))) {}
    for (this.jdField_a_of_type_Mxm$b = this.jdField_a_of_type_Mxs;; this.jdField_a_of_type_Mxm$b = this.jdField_a_of_type_Klw) {
      do
      {
        if (this.jdField_a_of_type_Mxm$b != null) {
          this.jdField_a_of_type_Mxm$b.b(this.c);
        }
        return this.jdField_a_of_type_Mxm$b;
      } while ((this.c.advertisementInfo == null) || (this.c.advertisementInfo.mAdvertisementSoftInfo == null) || (this.c.advertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
          localURLDrawableOptions.mRequestWidth = wja.dp2px(paramInt2, this.mActivity.getResources());
          localURLDrawableOptions.mRequestHeight = wja.dp2px(paramInt2, this.mActivity.getResources());
          localURLDrawable.setTag(aqbn.d(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(aqbn.j);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(aqbn.a);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(aqbn.j);
      }
    }
  }
  
  private void aTv()
  {
    if (this.jdField_a_of_type_Mtg$l.by == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Mtg$l.by.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = wja.dp2px(26.0F, this.mActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Mtg$l.by.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Mtg$l.sd.setVisibility(8);
    this.jdField_a_of_type_Mtg$l.lT.setVisibility(8);
    this.jdField_a_of_type_Mtg$l.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Mtg$l.lU.setVisibility(8);
    localObject = this.jdField_a_of_type_Mtg$l.D.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = wja.dp2px(18.0F, this.mActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = wja.dp2px(18.0F, this.mActivity.getResources());
    this.jdField_a_of_type_Mtg$l.D.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Mtg$l.lS.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Mtg$l.lS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Mtg$l.sd.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = wja.dp2px(1.0F, this.mActivity.getResources());
    this.jdField_a_of_type_Mtg$l.sd.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void aTw()
  {
    if ((this.jdField_a_of_type_Mtg$l.by == null) || (this.jdField_a_of_type_Mtg$l.bA == null) || (this.jdField_a_of_type_Mtg$l.bz == null) || (this.jdField_a_of_type_Mtg$l.E == null)) {
      return;
    }
    this.jdField_a_of_type_Mtg$l.bA.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().ir();
    }
    this.jdField_a_of_type_Mtg$l.F.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(wja.dp2px(8.0F, this.mActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Mtg$l.bz.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Mtg$l.bz.setVisibility(0);
    localObject = this.jdField_a_of_type_Mtg$l.by.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = wja.dp2px(4.0F, this.mActivity.getResources());
    this.jdField_a_of_type_Mtg$l.by.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Mtg$l.by.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Mtg$l.E, str, wja.dp2px(3.0F, this.mActivity.getResources()), 72, 0);
    b(this.jdField_a_of_type_Mtg$l, true);
  }
  
  private void aTx()
  {
    if (this.apU) {}
    while ((this.jdField_a_of_type_Mtg$l.by == null) || (a().zM())) {
      return;
    }
    this.apU = true;
    ab(true, true);
  }
  
  private void aTy()
  {
    if (this.apU) {}
    while ((this.jdField_a_of_type_Mtg$l.by == null) || (this.jdField_a_of_type_Mtg$l.by.getVisibility() != 0)) {
      return;
    }
    this.apU = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Mtg$l.by.getLayoutParams();
    int j = this.jdField_a_of_type_Mtg$l.by.getMeasuredWidth();
    int k = this.jdField_a_of_type_Mtg$l.by.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Mtg$l.D.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.E = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = wja.dp2px(41.0F, this.mActivity.getResources());
    int i2 = wja.dp2px(197.0F, this.mActivity.getResources());
    int i3 = wja.dp2px(33.0F, this.mActivity.getResources());
    int i4 = this.jdField_a_of_type_Mtg$l.lS.getMeasuredWidth();
    if (getStyle() == 1) {}
    for (int i = wja.dp2px(123.0F, this.mActivity.getResources()) - i4;; i = wja.dp2px(140.0F, this.mActivity.getResources()) - i4)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Mtg$l.lS.getLayoutParams();
      this.E.addUpdateListener(new mxq(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.E.addListener(new mxr(this));
      this.jdField_a_of_type_Mtg$l.by.setTag(2131362727, this.E);
      this.E.setDuration(500L);
      this.E.start();
      return;
    }
  }
  
  private void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Mtg$l == null) || (this.jdField_a_of_type_Mtg$l.bA == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Mtg$l.by.getLayoutParams();
        i = this.jdField_a_of_type_Mtg$l.by.getMeasuredHeight();
        if (!paramBoolean1) {
          continue;
        }
        this.E = ValueAnimator.ofInt(new int[] { 0, -i });
        if (paramBoolean2) {
          this.aVD = localLayoutParams.bottomMargin;
        }
      }
      catch (Exception localException)
      {
        LinearLayout.LayoutParams localLayoutParams;
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VideoFeedsSoftAdBarController", 2, "animateNewStyle error：" + localException.getMessage());
        return;
        this.E = ValueAnimator.ofInt(new int[] { -i, this.aVD });
        continue;
      }
      this.E.removeAllUpdateListeners();
      this.E.addUpdateListener(new mxo(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.E.removeAllListeners();
      this.E.addListener(new mxp(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Mtg$l.bA.setTag(2131362727, this.E);
      this.E.setDuration(200L);
      this.E.start();
      return;
      if (!paramBoolean2) {
        continue;
      }
      this.E = ValueAnimator.ofInt(new int[] { -i, 0 });
    }
  }
  
  private void b(mtg.l paraml, boolean paramBoolean)
  {
    int k = 0;
    int j;
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
    {
      i = 1;
      Object localObject;
      if ((i == 0) && (paraml.bp != null))
      {
        localObject = paraml.bp;
        if (!paramBoolean) {
          break label158;
        }
        j = 0;
        label46:
        ((ViewGroup)localObject).setVisibility(j);
      }
      if (paraml.titleTextView != null)
      {
        localObject = paraml.titleTextView;
        if (!paramBoolean) {
          break label165;
        }
        j = 0;
        label73:
        ((TextView)localObject).setVisibility(j);
      }
      if ((i != 0) && (paraml.rootView != null) && (paraml.rootView.findViewById(2131368440) != null))
      {
        localObject = paraml.rootView.findViewById(2131368440);
        if (!paramBoolean) {
          break label172;
        }
        i = 0;
        label122:
        ((View)localObject).setVisibility(i);
      }
      if (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paraml = paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
        if (!paramBoolean) {
          break label178;
        }
      }
    }
    label158:
    label165:
    label172:
    label178:
    for (int i = k;; i = 8)
    {
      paraml.setVisibility(i);
      return;
      i = 0;
      break;
      j = 8;
      break label46;
      j = 8;
      break label73;
      i = 8;
      break label122;
    }
  }
  
  private void c(VideoInfo paramVideoInfo, mtg.l paraml)
  {
    this.mIsShowing = true;
    this.jdField_a_of_type_Mtg$l = paraml;
    Object localObject;
    if ((paraml.by == null) && ((paraml instanceof mtg.k)))
    {
      paraml.by = ((ViewGroup)((ViewStub)((mtg.k)paraml).bt.findViewById(2131381671)).inflate());
      int i = wja.dp2px(4.0F, this.mActivity.getResources());
      paraml.by.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(wja.dp2px(3.0F, this.mActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paraml.by.setBackgroundDrawable((Drawable)localObject);
      paraml.D = ((URLImageView)paraml.by.findViewById(2131368489));
      paraml.sc = ((TextView)paraml.by.findViewById(2131368496));
      paraml.sd = ((TextView)paraml.by.findViewById(2131368495));
      paraml.lS = paraml.by.findViewById(2131370683);
      paraml.lT = paraml.by.findViewById(2131368494);
      paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paraml.by.findViewById(2131368486));
      paraml.lU = paraml.by.findViewById(2131368488);
    }
    if (paraml.by != null)
    {
      paraml.by.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().ir();
      }
      a(paraml.D, (String)localObject, this.aUB, 18, -1);
      localObject = "";
      if (a() != null) {
        localObject = a().getTitle();
      }
      paraml.sc.setText((CharSequence)localObject);
      paraml.sc.setVisibility(0);
      paraml.D.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paraml.sd.setText((CharSequence)localObject);
      paraml.by.setTag(paraml);
      paraml.by.setOnClickListener(this);
      paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paraml);
      paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paraml.lT.setTag(paraml);
      paraml.lT.setOnClickListener(this);
      muj.a(paraml.by, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paraml);
      }
    }
  }
  
  private void d(VideoInfo paramVideoInfo, mtg.l paraml)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.mIsShowing = true;
    this.jdField_a_of_type_Mtg$l = paraml;
    for (;;)
    {
      try
      {
        if ((paraml.by == null) && ((paraml instanceof mtg.k)))
        {
          paraml.by = ((ViewGroup)((ViewStub)paraml.bt.findViewById(2131381671)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(wja.dp2px(8.0F, this.mActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paraml.bz = ((LinearLayout)paraml.by.findViewById(2131381673));
          paraml.bz.setBackgroundDrawable((Drawable)localObject1);
          paraml.bz.setVisibility(0);
          paraml.E = ((URLImageView)paraml.by.findViewById(2131368492));
          paraml.F = ((URLImageView)paraml.by.findViewById(2131368491));
          paraml.se = ((TextView)paraml.by.findViewById(2131368490));
          paraml.sf = ((TextView)paraml.by.findViewById(2131362061));
          paraml.sg = ((TextView)paraml.by.findViewById(2131362058));
          paraml.sh = ((TextView)paraml.by.findViewById(2131362060));
          paraml.jX = ((ImageView)paraml.by.findViewById(2131362057));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(wja.dp2px(12.0F, this.mActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paraml.bT = ((Button)paraml.by.findViewById(2131362056));
          paraml.bT.setBackgroundDrawable((Drawable)localObject2);
          paraml.b = ((ReadInjoyHeaderAdDownloadView)paraml.by.findViewById(2131368487));
          paraml.bA = ((ViewGroup)paraml.by.findViewById(2131362059));
          paraml.bA.setBackgroundDrawable((Drawable)localObject1);
          paraml.lV = paraml.by.findViewById(2131368493);
        }
        if (paraml.by == null) {
          break;
        }
        paraml.by.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().ir();
        }
        aTw();
        if (getStyle() == 0)
        {
          a(paraml.E, (String)localObject1, wja.dp2px(6.0F, this.mActivity.getResources()), 72, 0);
          a(paraml.F, (String)localObject1, wja.dp2px(5.2F, this.mActivity.getResources()), 75, 1);
          paraml.lV.setVisibility(4);
          a(getStyle(), paraml);
          if (a() == null) {
            break label859;
          }
          str = a().getTitle();
          i = a().getStyle();
          localObject3 = a().a();
          localObject2 = a().getBtnText();
          localObject1 = a().is();
          paraml.bT.setText((CharSequence)localObject2);
          paraml.sg.setText((CharSequence)localObject1);
          if (i == 0)
          {
            paraml.sg.setVisibility(0);
            paraml.se.setText(str);
            paraml.sf.setText(str);
            paraml.sh.setText((CharSequence)localObject3);
            paraml.by.setTag(paraml);
            paraml.by.setOnClickListener(this);
            paraml.b.setTag(paraml);
            paraml.b.setOnClickListener(this);
            paraml.jX.setTag(paraml);
            paraml.jX.setOnClickListener(this);
            paraml.bT.setTag(paraml);
            paraml.bT.setOnClickListener(this);
            paraml.bz.setTag(paraml);
            paraml.bz.setOnClickListener(this);
            paraml.bA.setTag(paraml);
            paraml.bA.setOnClickListener(this);
            muj.a(paraml.by, 200);
            if (a() == null) {
              break;
            }
            a().a(paramVideoInfo, paraml);
            a().a(new mxn(this));
          }
        }
        else
        {
          a(paraml.E, (String)localObject1, wja.dp2px(6.0F, this.mActivity.getResources()), 72, -1);
          a(paraml.F, (String)localObject1, wja.dp2px(6.0F, this.mActivity.getResources()), 72, -1);
          paraml.lV.setVisibility(0);
          continue;
        }
        paraml.sg.setVisibility(4);
      }
      catch (Exception paramVideoInfo)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
        return;
      }
      continue;
      label859:
      String str = "";
      Object localObject3 = "";
      Object localObject2 = "";
      Object localObject1 = "";
      int i = -1;
    }
  }
  
  public boolean EM()
  {
    if (a() != null) {
      return a().zN();
    }
    return false;
  }
  
  public void a(int paramInt, mtg.l paraml)
  {
    ViewGroup.LayoutParams localLayoutParams = paraml.bA.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paraml.se.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paraml.F.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paraml.sf.getLayoutParams();
    if (paramInt == 0)
    {
      paraml.E.setPadding(0, 0, 0, 0);
      paraml.F.setPadding(0, 0, 0, 0);
      localLayoutParams.height = wja.dp2px(75.0F, this.mActivity.getResources());
      localLayoutParams.width = wja.dp2px(246.0F, this.mActivity.getResources());
      localLayoutParams1.bottomMargin = wja.dp2px(3.0F, this.mActivity.getResources());
      localLayoutParams1.topMargin = wja.dp2px(1.0F, this.mActivity.getResources());
      localLayoutParams2.rightMargin = wja.dp2px(6.0F, this.mActivity.getResources());
      localLayoutParams2.leftMargin = wja.dp2px(0.0F, this.mActivity.getResources());
    }
    for (localLayoutParams3.topMargin = wja.dp2px(7.0F, this.mActivity.getResources());; localLayoutParams3.topMargin = wja.dp2px(6.0F, this.mActivity.getResources()))
    {
      paraml.sf.setLayoutParams(localLayoutParams3);
      paraml.F.setLayoutParams(localLayoutParams2);
      paraml.bA.setLayoutParams(localLayoutParams);
      paraml.se.setLayoutParams(localLayoutParams1);
      return;
      paramInt = wja.dp2px(6.0F, this.mActivity.getResources());
      paraml.E.setPadding(paramInt, paramInt, paramInt, paramInt);
      paraml.F.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = wja.dp2px(68.0F, this.mActivity.getResources());
      localLayoutParams.width = wja.dp2px(225.0F, this.mActivity.getResources());
      localLayoutParams1.topMargin = wja.dp2px(1.0F, this.mActivity.getResources());
      localLayoutParams1.bottomMargin = wja.dp2px(3.0F, this.mActivity.getResources());
      localLayoutParams2.rightMargin = wja.dp2px(-2.0F, this.mActivity.getResources());
      localLayoutParams2.leftMargin = wja.dp2px(-3.0F, this.mActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, mtg.l paraml, double paramDouble, long paramLong)
  {
    if (paraml.be.getVisibility() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if ((paraml.by == null) || (paraml.by.getVisibility() != 0)) {
            break;
          }
        } while ((!this.mIsShowing) || (a() == null) || (!a().a(paramVideoInfo, paraml, paramDouble, paramLong)));
        if (!EM())
        {
          aTy();
          return;
        }
        aTx();
        return;
      } while (((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.vid))) || (a() == null) || (!a().zL()) || (!a().b(paramVideoInfo)) || (paramVideoInfo == null));
      if (!EM())
      {
        c(paramVideoInfo, paraml);
        return;
      }
      paramDouble = paramLong / 1000L * paramDouble / 100.0D;
      int j = 0;
      i = j;
      if (paramVideoInfo != null)
      {
        i = j;
        if (paramVideoInfo.advertisementInfo != null)
        {
          i = j;
          if (paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo != null) {
            i = Integer.valueOf(paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaQ).intValue();
          }
        }
      }
    } while ((paramDouble == 0.0D) || (paramDouble <= i));
    d(paramVideoInfo, paraml);
  }
  
  public void a(mtg.l paraml1, mtg.l paraml2)
  {
    this.mIsShowing = false;
    this.apU = false;
    if (this.E != null)
    {
      this.E.removeAllUpdateListeners();
      this.E.cancel();
      this.E = null;
    }
    i(paraml1);
    this.c = paraml2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
    this.jdField_a_of_type_Mxm$b = null;
  }
  
  public void a(mtg.l paraml, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paraml == null)) {
      return;
    }
    a(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, paraml, paramDouble, paramLong);
  }
  
  public void ck(int paramInt1, int paramInt2)
  {
    if (a() != null) {
      a().ck(paramInt1, paramInt2);
    }
  }
  
  public void doOnDestory()
  {
    if (this.jdField_a_of_type_Klw != null) {
      this.jdField_a_of_type_Klw.onDestroy();
    }
    if (this.jdField_a_of_type_Mxs != null) {
      this.jdField_a_of_type_Mxs.onDestroy();
    }
  }
  
  public int getStyle()
  {
    if (a() != null) {
      return a().getStyle();
    }
    return 0;
  }
  
  public void i(mtg.l paraml)
  {
    if ((paraml != null) && (paraml.by != null))
    {
      paraml.by.setVisibility(8);
      try
      {
        if (!EM())
        {
          aTv();
          return;
        }
        aTw();
        return;
      }
      catch (Exception paraml)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paraml.getMessage());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (a() != null) {
      a().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void aTz();
  }
  
  public static abstract interface b
  {
    public abstract CharSequence a();
    
    public abstract void a(VideoInfo paramVideoInfo, mtg.l paraml);
    
    public abstract void a(mtg.l paraml);
    
    public abstract void a(mxm.a parama);
    
    public abstract boolean a(VideoInfo paramVideoInfo, mtg.l paraml, double paramDouble, long paramLong);
    
    public abstract void b(VideoInfo paramVideoInfo);
    
    public abstract void b(mtg.l paraml);
    
    public abstract boolean b(VideoInfo paramVideoInfo);
    
    public abstract void c(mtg.l paraml);
    
    public abstract void ck(int paramInt1, int paramInt2);
    
    public abstract String getBtnText();
    
    public abstract int getStyle();
    
    public abstract String getTitle();
    
    public abstract String ir();
    
    public abstract String is();
    
    public abstract void onClick(View paramView);
    
    public abstract boolean zL();
    
    public abstract boolean zM();
    
    public abstract boolean zN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxm
 * JD-Core Version:    0.7.0.1
 */