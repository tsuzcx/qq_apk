package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import nrx;
import riw;
import wja;

public class ReadInJoyScrollViewSwitcher
  extends ViewSwitcher
{
  private a a;
  public b a;
  private int bbC = 400;
  private int bbD;
  private int bbE;
  private ArrayList<c> lP;
  
  public ReadInJoyScrollViewSwitcher(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyScrollViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initData();
    initAnimation();
  }
  
  private void a(c paramc, View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131379401);
    localTextView.setText(paramc.title);
    paramView = (CornerImageView)paramView.findViewById(2131368698);
    paramView.setRadius(wja.dp2px(2.0F, getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (TextUtils.isEmpty(paramc.imgUrl)) {
      if (paramc.drawableId > 0)
      {
        paramView.setImageDrawable(getResources().getDrawable(paramc.drawableId));
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.rightMargin = wja.dp2px(32.0F, getResources());
        localTextView.setLayoutParams(localLayoutParams);
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(new nrx(this, paramc));
      return;
      paramView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramView.rightMargin = wja.dp2px(5.0F, getResources());
      localTextView.setLayoutParams(paramView);
      continue;
      a(paramc.imgUrl, paramView);
      localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.rightMargin = wja.dp2px(32.0F, getResources());
      localTextView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
    }
  }
  
  private void initAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.bbC);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(this.bbC);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setInAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(this.bbC);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(false);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(this.bbC);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setOutAnimation(localAnimationSet);
  }
  
  private void initData()
  {
    this.lP = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$a = new a(this);
    setAnimateFirstView(false);
  }
  
  protected void a(String paramString, URLImageView paramURLImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = riw.dip2px(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = riw.dip2px(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = riw.dip2px(getContext(), 2.0F);
    try
    {
      localObject = URLDrawable.getDrawable(new URL("redtouchpicdownloadprotoc", null, paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(paramString);
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyScrollViewSwitcher", 2, "parse img exception : e = " + paramString);
    }
  }
  
  public void bat()
  {
    if (this.lP.size() < 1) {
      return;
    }
    if (this.bbD == this.lP.size() - 1) {}
    for (int i = 0;; i = this.bbD + 1)
    {
      this.bbD = i;
      a((c)this.lP.get(this.bbD), getNextView(), this.bbD);
      showNext();
      return;
    }
  }
  
  public void bau()
  {
    if ((this.lP == null) || (this.lP.size() < 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$a.removeMessages(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$a.sendEmptyMessageDelayed(0, this.bbE);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$a.removeCallbacksAndMessages(null);
  }
  
  public void setOnClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$b = paramb;
  }
  
  static class a
    extends Handler
  {
    private WeakReference mRef;
    
    public a(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher)
    {
      this.mRef = new WeakReference(paramReadInJoyScrollViewSwitcher);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      paramMessage = (ReadInJoyScrollViewSwitcher)this.mRef.get();
      if (paramMessage != null)
      {
        paramMessage.bat();
        paramMessage.bau();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ReadInJoyScrollViewSwitcher.c paramc);
  }
  
  public static class c
  {
    int drawableId;
    String imgUrl;
    String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher
 * JD-Core Version:    0.7.0.1
 */