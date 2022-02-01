package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import aqnm;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew;
import java.util.List;
import rze;
import sae.a;
import sae.b;
import sah;
import sam;

public class TopPanelViewNew
  extends RelativeLayout
  implements sae.b
{
  private sae.a a;
  private boolean avA;
  private RecommendBannerViewNew b;
  private View pE;
  
  public TopPanelViewNew(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public TopPanelViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public TopPanelViewNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public void b(CertifiedAccountMeta.StEntry paramStEntry, List<sam> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null)) {
      bxG();
    }
    do
    {
      return;
      if (this.b != null) {
        this.b.a(paramStEntry, paramList, paramBoolean);
      }
      aqnm.setViewVisibility(this.b, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.b.bxD();
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
    ((ValueAnimator)localObject).addListener(new sah(this));
    ((ValueAnimator)localObject).start();
  }
  
  public void bxF() {}
  
  public void bxG()
  {
    aqnm.setViewVisibility(this.b, 8);
  }
  
  protected void initView(Context paramContext)
  {
    this.avA = rze.Mp();
    inflate(paramContext, 2131558842, this);
    if (this.avA) {
      setBackgroundColor(-16777216);
    }
    this.b = ((RecommendBannerViewNew)findViewById(2131376890));
    this.pE = findViewById(2131369706);
  }
  
  public void setOnHideBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.pE != null) {
      this.pE.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPresenter(sae.a parama)
  {
    this.a = parama;
    if (this.b != null) {
      this.b.setPresenter(parama);
    }
  }
  
  public void yj(int paramInt) {}
  
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
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew
 * JD-Core Version:    0.7.0.1
 */