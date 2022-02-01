package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;
import kbp;
import kpn;
import kxm;
import lpz;
import ndi;
import odv;

public class ReadInJoyBiuButton
  extends ButtonBase
  implements View.OnLongClickListener
{
  private NativeBiuButton a;
  private ArticleInfo articleInfo;
  private LinearLayout dK;
  private TextView mTextView;
  
  public ReadInJoyBiuButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    b(paramVafContext);
  }
  
  private void b(VafContext paramVafContext)
  {
    this.dK = new LinearLayout(paramVafContext.getContext());
    this.a = new NativeBiuButton(paramVafContext.getContext());
    this.mTextView = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.dK.setOrientation(0);
    this.dK.setGravity(1);
    this.dK.addView(this.a, paramVafContext);
    this.dK.addView(this.mTextView, paramVafContext);
    this.dK.setOnLongClickListener(this);
  }
  
  public int getComMeasuredHeight()
  {
    return this.dK.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.dK.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.dK;
  }
  
  public void o(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (odv.aT(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009361";; str1 = "0X8007EE4")
    {
      str2 = kxm.a(paramArticleInfo, true);
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label154;
      }
      if (!ndi.Y(paramArticleInfo)) {
        kbp.a(null, String.valueOf(localSocializeFeedsInfo.a.cuin), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((kxm.r(paramArticleInfo)) || (kxm.s(paramArticleInfo))) {
        break;
      }
      ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      return;
    }
    label154:
    kbp.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dK.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.dK.measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    if ((this.articleInfo != null) && (this.articleInfo.mSocialFeedInfo != null) && (this.articleInfo.mSocialFeedInfo.DC())) {
      return false;
    }
    paramView = paramView.getContext();
    Intent localIntent;
    if (((paramView instanceof Activity)) && (this.articleInfo != null))
    {
      paramView = (Activity)paramView;
      localIntent = lpz.a(paramView, this.articleInfo);
      if (kpn.ny() != 1) {
        break label103;
      }
    }
    for (;;)
    {
      localIntent.putExtra("fast_biu_type", bool);
      paramView.startActivity(localIntent);
      paramView.overridePendingTransition(0, 0);
      o(this.articleInfo);
      return false;
      label103:
      bool = false;
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.dK.setClickable(true);
    this.mTextView.setIncludeFontPadding(false);
    this.mTextView.setTextSize(0, this.mTextSize);
    this.mTextView.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    this.dK.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.mTextView.setText(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      this.articleInfo = ((ArticleInfo)paramObject);
    }
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates()
  {
    Object localObject = this.dK.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.dK.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void setCompoundDrawableForStates()
  {
    Object localObject = this.dK.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.a.setImageDrawable((Drawable)localObject);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.mTextView.setText(paramCharSequence);
    }
  }
  
  public void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.mTextView.setTextColor(localColorStateList);
  }
  
  public static class NativeBiuButton
    extends ImageView
  {
    ReadInJoyBiuButton.b a;
    
    public NativeBiuButton(Context paramContext)
    {
      super();
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.a != null) {
        this.a.aNg();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      if (this.a != null) {
        this.a.onDetached();
      }
      super.onDetachedFromWindow();
    }
    
    public void setOnAttachedListener(ReadInJoyBiuButton.b paramb)
    {
      this.a = paramb;
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new ReadInJoyBiuButton(paramVafContext);
    }
  }
  
  static abstract interface b
  {
    public abstract void aNg();
    
    public abstract void onDetached();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton
 * JD-Core Version:    0.7.0.1
 */