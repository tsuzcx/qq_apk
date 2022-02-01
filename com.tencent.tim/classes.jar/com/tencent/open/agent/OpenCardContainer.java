package com.tencent.open.agent;

import acfp;
import afei;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import aqcx;
import arru;
import arrv;
import arrw;
import arrx;
import arry;
import arrz;
import arsa;
import arsb;
import auvd;
import auvd.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCardContainer
  extends RelativeLayout
{
  public static final int[] fA = { 2131371284 };
  public static final int[] fy = { 2131692505 };
  public static final int[] fz = { 2130839769 };
  private ImageView Gh;
  private ImageView Gm;
  private View Ka;
  public View Kb;
  private View Kc;
  public OpenAuthorityAccountView a;
  private d a;
  public e a;
  private TextView acT;
  private b b;
  private String cBP = "";
  public boolean dcP;
  private boolean dcQ;
  public AnyScaleTypeImageView f;
  private SwipListView j;
  private LinearLayout lG;
  private TextView mAppNameView;
  public Context mContext;
  protected RelativeLayout mD;
  public Drawable mDrawable;
  protected RelativeLayout mE;
  protected RelativeLayout mF;
  protected Handler mHandler = new arru(this, Looper.getMainLooper());
  protected LayoutInflater mInflater;
  protected int mMode = -1;
  protected final int mScreenHeight;
  protected final int mScreenWidth;
  protected URLDrawableDownListener.Adapter mUrlAdapter = new arrv(this);
  protected List<c> qf;
  
  public OpenCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.mScreenWidth = paramAttributeSet.widthPixels;
    this.mScreenHeight = paramAttributeSet.heightPixels;
    this.qf = new ArrayList();
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void Zm(int paramInt)
  {
    if (paramInt >= 3)
    {
      this.Kb.setVisibility(8);
      this.Kc.setVisibility(0);
      return;
    }
    this.Kb.setVisibility(0);
    this.Kc.setVisibility(8);
  }
  
  private void c(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SDK_LOGIN.OpenCardContainer", 2, "performAnim height =" + paramInt1 + ", topMargin =" + paramInt2);
    }
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 0, paramInt2 });
    localValueAnimator1.addUpdateListener(new arry(this, paramImageView));
    localValueAnimator1.addListener(new arrz(this, paramImageView));
    localValueAnimator1.setDuration(300L);
    localValueAnimator2.setDuration(300L);
    paramImageView = new AnimatorSet();
    paramImageView.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    paramImageView.setDuration(300L);
    paramImageView.start();
  }
  
  private void eld()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SDK_LOGIN.OpenCardContainer", 2, "displayCoverContainer ");
    }
    if (!this.dcQ)
    {
      this.dcQ = true;
      elr();
    }
  }
  
  private void elr()
  {
    this.Gh.setVisibility(0);
    if ((this.mContext instanceof BaseActivity)) {
      ImmersiveUtils.setStatusTextColor(false, ((BaseActivity)this.mContext).getWindow());
    }
    if (((this.mContext instanceof PublicFragmentActivityForOpenSDK)) && (this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$d != null)) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$d.elo();
    }
    for (;;)
    {
      int i = (int)(this.mScreenWidth / 1.307692F);
      int k = this.lG.getHeight();
      c(this.f, i, i - k);
      return;
      if ((this.mContext instanceof AuthorityActivity)) {
        ((AuthorityActivity)this.mContext).ekU();
      } else if ((this.mContext instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.mContext).ekU();
      }
    }
  }
  
  private URLDrawable f(String paramString)
  {
    localObject3 = null;
    try
    {
      Object localObject1 = new afei(0, this.mScreenWidth, 100);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      try
      {
        localObject1 = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString = (String)localObject1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "genGameUrlImg exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
          paramString = localObject3;
        }
      }
      if ((paramString != null) && (paramString.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDK_LOGIN.OpenCardContainer", 2, "-->-->genGameUrlImg: failed");
        }
        paramString.restartDownload();
      }
      if (((paramString == null) || (paramString.getStatus() != 1)) && (this.f != null))
      {
        this.f.setURLDrawableDownListener(this.mUrlAdapter);
        this.mHandler.post(new OpenCardContainer.8(this, paramString));
      }
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create empty drawable oom.", localOutOfMemoryError);
        }
        localObject2 = null;
      }
    }
  }
  
  private void n(ImageView paramImageView, String paramString)
  {
    Object localObject3 = null;
    if (paramImageView == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = this.mContext.getResources().getDrawable(2130840645);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          try
          {
            localObject1 = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
            paramString = (String)localObject1;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              Object localObject2;
              QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "setVirtualIcon exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
              paramString = localObject3;
            }
          }
          if (paramString != null)
          {
            paramString.setDecodeHandler(aqbn.b);
            if (paramString.getStatus() == 2) {
              paramString.restartDownload();
            }
            if (paramString.getStatus() != 2)
            {
              paramImageView.setImageDrawable(paramString);
              return;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create color drawable oom.", localOutOfMemoryError);
            }
            localObject2 = null;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getImageError: ");
  }
  
  protected String Dc()
  {
    String str = this.cBP;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int k = str.length();
    if (k >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(k - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int i = 2;
      k = 0;
      while (k < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(k, i));
        k += 2;
        i += 2;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - k)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
    }
    localStringBuilder.append("/").append(str).append("_").append("android").append("_").append("ad").append("_").append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public void F(String paramString, Bitmap paramBitmap)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(paramString)) {
      this.mAppNameView.setText(paramString);
    }
    if (paramBitmap != null) {
      this.Gm.setImageBitmap(paramBitmap);
    }
  }
  
  public void WR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OpenAuthorityActivity", 2, "showAdsInfo adsTxt = " + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int k;
    if (!TextUtils.isEmpty(paramString2))
    {
      k = 0;
      i = 0;
      if (k >= paramString2.length()) {
        break label130;
      }
      if (String.valueOf(paramString2.charAt(k)).getBytes().length <= 1) {
        break label112;
      }
      i += 2;
      label45:
      if (i <= 10) {
        break label121;
      }
    }
    label130:
    for (int i = 1;; i = 0)
    {
      paramString2 = paramString2.substring(0, k);
      if (i != 0) {
        new StringBuilder().append(paramString2).append("...").toString();
      }
      if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.WK(paramString1);
      }
      return;
      label112:
      i += 1;
      break label45;
      label121:
      k += 1;
      break;
    }
  }
  
  public void ak(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OpenAuthorityActivity", 2, "showAdsInfo adsPic = " + paramBitmap);
    }
  }
  
  public void ekI()
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.ekI();
  }
  
  public void ekJ()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.ekJ();
    }
  }
  
  public boolean i(List<CardContainer.a> paramList, String paramString)
  {
    int i = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.qf.clear();
    if (!TextUtils.isEmpty(paramString)) {
      this.acT.setText(paramString);
    }
    if (((List)localObject).isEmpty())
    {
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "authList isEmpty");
      if (this.qf.size() != 0) {
        break label336;
      }
    }
    label336:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label342;
      }
      paramList = this.f;
      xU(1);
      QLog.d("SDK_LOGIN.OpenCardContainer", 1, "--> has been authority.");
      setAdImageByURL(paramList, Dc());
      return bool;
      paramList = new StringBuilder(((List)localObject).size() * 128);
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (CardContainer.a)paramString.next();
        c localc = new c();
        localc.api = ((CardContainer.a)localObject).api;
        localc.flag = ((CardContainer.a)localObject).flag;
        localc.id = ((CardContainer.a)localObject).id;
        localc.isNew = ((CardContainer.a)localObject).isNew;
        localc.title = ((CardContainer.a)localObject).title;
        if (QLog.isColorLevel()) {
          paramList.append("--> Permission p, api: ").append(localc.api).append(" | flag: ").append(localc.flag).append(" | id: ").append(localc.id).append(" | isNew: ").append(localc.isNew).append(" | title: ").append(localc.title).append("\n");
        }
        this.qf.add(localc);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, paramList.toString());
      break;
    }
    label342:
    xU(0);
    QLog.d("SDK_LOGIN.OpenCardContainer", 1, "--> has not been authority.");
    paramList = acfp.m(2131709379);
    label363:
    if (i < this.qf.size())
    {
      paramString = (c)this.qf.get(i);
      if (i >= this.qf.size() - 1) {
        break label440;
      }
    }
    label440:
    for (paramList = paramList + paramString.title + "、";; paramList = paramList + paramString.title)
    {
      i += 1;
      break label363;
      break;
    }
  }
  
  public long ia()
  {
    if ((e.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e) != null) && (e.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e).size() > 0))
    {
      Iterator localIterator = e.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e).iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.dcU) {
          return localf.awp;
        }
      }
    }
    return 0L;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mD = ((RelativeLayout)super.findViewById(2131362348));
    this.mE = ((RelativeLayout)super.findViewById(2131362349));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView = ((OpenAuthorityAccountView)super.findViewById(2131361948));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setOnClickListener(new arrw(this));
    this.mF = ((RelativeLayout)super.findViewById(2131362351));
    this.f = ((AnyScaleTypeImageView)super.findViewById(2131367860));
    this.lG = ((LinearLayout)super.findViewById(2131379854));
    this.Gh = ((ImageView)super.findViewById(2131379855));
    this.Gm = ((ImageView)super.findViewById(2131362855));
    this.mAppNameView = ((TextView)super.findViewById(2131362857));
    this.acT = ((TextView)super.findViewById(2131362862));
    this.Ka = super.findViewById(2131362854);
    this.Ka.setFocusable(true);
    this.Ka.setFocusableInTouchMode(true);
    this.Ka.requestFocus();
    this.Kb = super.findViewById(2131365525);
    this.Kc = super.findViewById(2131382042);
    this.j = ((SwipListView)super.findViewById(2131382043));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e = new e(this.mContext);
    this.j.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e);
    this.j.setDragEnable(true);
    this.j.setOverScrollFlingMode(2);
    this.j.setOnItemClickListener(new arrx(this));
  }
  
  public void onResume()
  {
    if (!this.dcQ) {
      return;
    }
    try
    {
      elr();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenCardContainer", 1, "Exception", localException);
    }
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    Object localObject = null;
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.f;
    }
    try
    {
      paramAnyScaleTypeImageView = new afei(0, this.mScreenWidth, 100);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramAnyScaleTypeImageView;
      localURLDrawableOptions.mFailedDrawable = paramAnyScaleTypeImageView;
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 2)) {
          paramAnyScaleTypeImageView.restartDownload();
        }
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 1))
        {
          eld();
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getStatus SUCCESSED: ");
          }
          localAnyScaleTypeImageView.setVisibility(0);
          if (paramAnyScaleTypeImageView != null) {
            localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
          }
          return;
          paramAnyScaleTypeImageView = paramAnyScaleTypeImageView;
          if (QLog.isColorLevel()) {
            QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
          }
          paramAnyScaleTypeImageView = null;
        }
      }
      catch (IllegalArgumentException paramAnyScaleTypeImageView)
      {
        for (;;)
        {
          QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "setAdImageByURL exception url=", paramString, ",excption=", paramAnyScaleTypeImageView.toString() });
          paramAnyScaleTypeImageView = localObject;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getStatus OTHERS: ");
          }
          localAnyScaleTypeImageView.setURLDrawableDownListener(this.mUrlAdapter);
        }
      }
    }
  }
  
  public void setCreateVirtualListner(View.OnClickListener paramOnClickListener)
  {
    if (this.Kb != null) {
      this.Kb.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setCurrentAppid(String paramString)
  {
    this.cBP = paramString;
  }
  
  public void setOnAccountEventListener(a parama)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setAccountEventListener(parama);
  }
  
  public void setOnUpdateStatusBarListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$d = paramd;
  }
  
  public void setOndeleteVirtualListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void xU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "switchToMode -->mode: " + paramInt + ", mMode=" + this.mMode);
    }
    ThreadManager.executeOnSubThread(new OpenCardContainer.5(this));
    if (paramInt == this.mMode) {
      return;
    }
    this.mMode = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void dw(String paramString, boolean paramBoolean);
    
    public abstract void elp();
    
    public abstract void elq();
  }
  
  public static abstract interface b
  {
    public abstract void mq(long paramLong);
  }
  
  public static class c
  {
    public String api;
    public int flag;
    public int id;
    public boolean isNew;
    public String title;
  }
  
  public static abstract interface d
  {
    public abstract void elo();
  }
  
  public class e
    extends BaseAdapter
    implements View.OnClickListener, SwipListView.c
  {
    auvd a = a(paramContext);
    int bKH = -1;
    String currentUin;
    private List<OpenCardContainer.f> mData;
    
    e(Context paramContext) {}
    
    private void a(OpenCardContainer.g paramg, int paramInt, View paramView)
    {
      paramView = (OpenCardContainer.f)this.mData.get(paramInt);
      OpenCardContainer.g.a(paramg).setText(paramView.nickName);
      if (paramView.dcU)
      {
        OpenCardContainer.g.a(paramg).setVisibility(0);
        OpenCardContainer.this.a.setMainAccountSelect(false);
      }
      for (;;)
      {
        if (paramView.iconUrl != null) {
          OpenCardContainer.a(OpenCardContainer.this, OpenCardContainer.g.a(paramg), paramView.iconUrl);
        }
        return;
        OpenCardContainer.g.a(paramg).setVisibility(4);
      }
    }
    
    protected auvd a(Context paramContext)
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299263);
      int j = paramContext.getResources().getDimensionPixelSize(2131299264);
      paramContext = OpenCardContainer.fA;
      int[] arrayOfInt1 = OpenCardContainer.fy;
      int[] arrayOfInt2 = OpenCardContainer.fz;
      return new arsb(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
    }
    
    protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
    {
      if (this.a != null) {}
      for (int i = this.a.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
      {
        int j = paramView.getScrollX();
        if ((paramInt >= 0) && (this.bKH == paramInt)) {
          paramView.scrollTo(i, 0);
        }
        while (j == 0) {
          return;
        }
        paramView.scrollTo(0, 0);
        return;
      }
    }
    
    public void al(boolean paramBoolean) {}
    
    public void d(View paramView)
    {
      if (paramView != null)
      {
        paramView = paramView.getTag(-1);
        if (!(paramView instanceof Integer)) {}
      }
      for (int i = ((Integer)paramView).intValue();; i = -1)
      {
        this.bKH = i;
        return;
      }
    }
    
    public void els()
    {
      if ((this.mData != null) && (this.mData.size() > 0))
      {
        Iterator localIterator = this.mData.iterator();
        while (localIterator.hasNext()) {
          ((OpenCardContainer.f)localIterator.next()).dcU = false;
        }
        notifyDataSetChanged();
      }
    }
    
    public int getCount()
    {
      if (this.mData != null) {
        return this.mData.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.mData != null) && (paramInt < this.mData.size())) {
        return this.mData.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      OpenCardContainer.g localg;
      if (paramView == null)
      {
        localg = new OpenCardContainer.g(OpenCardContainer.this, null);
        paramView = OpenCardContainer.this.mInflater.inflate(2131559884, paramViewGroup, false);
        OpenCardContainer.g.a(localg, (URLImageView)paramView.findViewById(2131382041));
        OpenCardContainer.g.a(localg, (TextView)paramView.findViewById(2131382044));
        OpenCardContainer.g.a(localg, (ImageView)paramView.findViewById(2131377956));
        OpenCardContainer.g.a(localg, (Button)paramView.findViewById(2131365715));
        paramView.setTag(localg);
        paramView.setTag(-3, Integer.valueOf(aqcx.dip2px(OpenCardContainer.this.mContext, 66.0F)));
      }
      for (;;)
      {
        a(localg, paramInt, paramView);
        OpenCardContainer.g.a(localg).setOnClickListener(new arsa(this, paramInt));
        paramView.setTag(-1, Integer.valueOf(paramInt));
        a(OpenCardContainer.this.mContext, paramView, paramInt, this.mData.get(paramInt), localg, this);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localg = (OpenCardContainer.g)paramView.getTag();
      }
    }
    
    public void hi() {}
    
    void mr(long paramLong)
    {
      Iterator localIterator = this.mData.iterator();
      while (localIterator.hasNext())
      {
        OpenCardContainer.f localf = (OpenCardContainer.f)localIterator.next();
        if (localf.awp == paramLong) {
          localf.dcU = true;
        } else {
          localf.dcU = false;
        }
      }
      notifyDataSetChanged();
    }
    
    public void notifyDataSetChanged()
    {
      Object localObject = OpenCardContainer.this;
      int i;
      if (this.mData == null)
      {
        i = 0;
        OpenCardContainer.a((OpenCardContainer)localObject, i);
        if ((this.mData != null) && (this.mData.size() != 0)) {
          break label67;
        }
        OpenCardContainer.this.a.setMainAccountSelect(true);
      }
      label137:
      label138:
      for (;;)
      {
        super.notifyDataSetChanged();
        return;
        i = this.mData.size();
        break;
        label67:
        localObject = this.mData.iterator();
        i = 0;
        label79:
        if (((Iterator)localObject).hasNext())
        {
          if (!((OpenCardContainer.f)((Iterator)localObject).next()).dcU) {
            break label137;
          }
          OpenCardContainer.this.a.setMainAccountSelect(false);
          i = 1;
        }
        for (;;)
        {
          break label79;
          if (i != 0) {
            break label138;
          }
          OpenCardContainer.this.a.setMainAccountSelect(true);
          break;
        }
      }
    }
    
    public void onClick(View paramView) {}
    
    void setData(List<OpenCardContainer.f> paramList, String paramString)
    {
      if (this.mData != null)
      {
        if (paramString.equals(this.currentUin)) {
          break label33;
        }
        this.currentUin = paramString;
      }
      for (;;)
      {
        this.mData = paramList;
        notifyDataSetChanged();
        return;
        label33:
        if (paramList != null)
        {
          paramString = paramList.iterator();
          while (paramString.hasNext())
          {
            OpenCardContainer.f localf = (OpenCardContainer.f)paramString.next();
            if (localf.awp == OpenCardContainer.this.ia()) {
              localf.dcU = true;
            } else {
              localf.dcU = false;
            }
          }
        }
      }
    }
  }
  
  public static class f
  {
    public long awp;
    public boolean dcU = false;
    String iconUrl;
    String nickName;
    
    public f(long paramLong, String paramString1, String paramString2)
    {
      this.iconUrl = paramString2;
      this.nickName = paramString1;
      this.awp = paramLong;
    }
  }
  
  class g
    extends auvd.a
  {
    private ImageView Gn;
    private TextView acU;
    private URLImageView bM;
    private Button fP;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer
 * JD-Core Version:    0.7.0.1
 */