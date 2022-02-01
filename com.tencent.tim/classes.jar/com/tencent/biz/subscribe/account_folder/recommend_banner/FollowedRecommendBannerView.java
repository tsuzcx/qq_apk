package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM.StCommonExt;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import mqq.app.AppRuntime;
import ryy;
import rzd;
import rzi;
import rzi.a;
import rzk;
import rzl;
import rzm;
import rzn;
import rzo;
import rzq;
import rzv;
import sad;
import sam;
import sqn;

public class FollowedRecommendBannerView
  extends LinearLayout
  implements rzi.a
{
  private rzq a;
  private rzi b;
  private String mUin;
  private ImageView nQ;
  private RecyclerView p;
  private TextView vq;
  
  public FollowedRecommendBannerView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public FollowedRecommendBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private COMM.StCommonExt b()
  {
    if (this.b != null) {
      return this.b.d();
    }
    return null;
  }
  
  private void bxA()
  {
    setVisibility(0);
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, getMeasuredHeight() });
    ((ValueAnimator)localObject).addUpdateListener(new a(this, null));
    ((ValueAnimator)localObject).addListener(new rzn(this));
    ((ValueAnimator)localObject).start();
    sqn.b(this.mUin, "auth_person", "reco_exp", 0, 0, new String[0]);
  }
  
  private void bxz()
  {
    StringBuilder localStringBuilder = new StringBuilder(ryy.gv(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (b() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(b().attachInfo.get(), "UTF-8"));
        sqn.c(this.mUin, "auth_person", "reco_more", 0, 0, new String[0]);
        rzd.sW(localStringBuilder.toString());
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d("FollowedRecommendBanner", 0, "jump more recommend H5 page with no attach info!");
    }
  }
  
  public boolean Mq()
  {
    return getVisibility() == 0;
  }
  
  public void bxB()
  {
    if (getVisibility() == 8)
    {
      clearAnimation();
      return;
    }
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { getMeasuredHeight(), 0 });
    ((ValueAnimator)localObject).addUpdateListener(new a(this, null));
    ((ValueAnimator)localObject).addListener(new rzo(this));
    ((ValueAnimator)localObject).start();
    sqn.b(this.mUin, "auth_person", "reco_pack_up", 0, 0, new String[0]);
  }
  
  protected void initView(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131558844, this);
    this.p = ((RecyclerView)findViewById(2131363284));
    this.vq = ((TextView)findViewById(2131371965));
    this.nQ = ((ImageView)findViewById(2131369926));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.b = new rzi();
    this.b.a(this);
    this.p.setLayoutManager(paramContext);
    this.p.addItemDecoration(new rzv());
    this.p.setItemAnimator(new DefaultItemAnimator());
    this.a = new sad(this.p);
    this.a.us(true);
    this.p.setAdapter(this.a);
    this.a.a(new rzk(this));
    this.vq.setOnClickListener(new rzl(this));
    this.nQ.setOnClickListener(new rzm(this));
  }
  
  protected void onDetachedFromWindow()
  {
    clearAnimation();
    super.onDetachedFromWindow();
  }
  
  public void p(List<sam> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.a != null) {
      this.a.a(null, paramList);
    }
    bxA();
  }
  
  public void sY(String paramString)
  {
    this.mUin = paramString;
    if (this.b != null) {
      this.b.sX(this.mUin);
    }
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    private View mView;
    
    private a(View paramView)
    {
      this.mView = paramView;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mView.getLayoutParams();
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.mView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView
 * JD-Core Version:    0.7.0.1
 */