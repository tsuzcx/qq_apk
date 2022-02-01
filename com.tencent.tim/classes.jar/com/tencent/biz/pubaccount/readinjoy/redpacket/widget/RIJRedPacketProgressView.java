package com.tencent.biz.pubaccount.readinjoy.redpacket.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.presseffect.PressEffectRelativeLayout;
import kbp;
import kxm;
import kxm.b;
import meg.b;
import men;
import mep;
import mer;
import met;

public class RIJRedPacketProgressView
  extends PressEffectRelativeLayout
  implements meg.b
{
  private RIJRedPacketProgressBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar;
  private mer jdField_a_of_type_Mer;
  private int aQI = 5;
  private int aQJ = 1;
  private int aQK = 2;
  private int currentState = 0;
  private Handler handler = new Handler(Looper.getMainLooper());
  private ImageView jw;
  private ImageView jx;
  private ImageView jy;
  private TextView qK;
  private Paint y = new Paint();
  
  public RIJRedPacketProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"SetTextI18n"})
  public RIJRedPacketProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.y.setXfermode(null);
    this.jx = new ImageView(paramContext);
    this.jx.setImageResource(2130850287);
    this.jx.setScaleX(0.0F);
    this.jx.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(aqcx.dip2px(paramContext, 27.0F), aqcx.dip2px(paramContext, 27.0F));
    paramAttributeSet.addRule(14);
    addView(this.jx, paramAttributeSet);
    this.jy = new ImageView(paramContext);
    this.jy.setImageResource(2130850286);
    this.jy.setScaleX(0.0F);
    this.jy.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(aqcx.dip2px(paramContext, 27.0F), aqcx.dip2px(paramContext, 27.0F));
    paramAttributeSet.addRule(13);
    paramAttributeSet.bottomMargin = 1;
    addView(this.jy, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar = new RIJRedPacketProgressBar(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setScaleX(0.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(13);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar, paramAttributeSet);
    startViewTransition(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    this.jw = new ImageView(paramContext);
    this.jw.setImageResource(2130850290);
    this.jw.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(13);
    addView(this.jw, paramAttributeSet);
    this.qK = new TextView(paramContext);
    this.qK.setScaleX(0.0F);
    this.qK.setScaleY(0.0F);
    this.qK.setText(this.aQJ + "/" + this.aQI);
    this.qK.setBackgroundResource(2130850289);
    this.qK.setTextColor(-1);
    this.qK.setGravity(17);
    this.qK.setTextSize(1, 9.0F);
    paramContext = new RelativeLayout.LayoutParams(aqcx.dip2px(paramContext, 21.0F), aqcx.dip2px(paramContext, 21.0F));
    paramContext.addRule(13);
    addView(this.qK, paramContext);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_Mer = new mer(new men());
      return;
    }
    this.jdField_a_of_type_Mer = new mer(new mep());
  }
  
  private void a(View paramView, float... paramVarArgs)
  {
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setDuration(200L);
    paramVarArgs.addUpdateListener(new met(this, paramView));
    paramVarArgs.start();
  }
  
  private void a(String paramString1, int paramInt, boolean paramBoolean, @Nullable String paramString2)
  {
    int j = 2;
    int i;
    kxm.b localb1;
    kxm.b localb2;
    if (paramBoolean)
    {
      i = 3;
      localb1 = new kxm.b();
      localb2 = localb1.a("icon_position", Integer.valueOf(paramInt)).a("icon_status", Integer.valueOf(i));
      if (!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
        break label137;
      }
    }
    label137:
    for (paramInt = j;; paramInt = 1)
    {
      localb2.a("network_type", Integer.valueOf(paramInt)).a("os", Integer.valueOf(1)).a("imei", kxm.iT());
      if (!TextUtils.isEmpty(paramString2)) {
        localb1.a("rowkey", paramString2);
      }
      kbp.bp(paramString1, localb1.build());
      return;
      if (getCurrentState() == 1)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
    }
  }
  
  private void cJ(View paramView)
  {
    a(paramView, new float[] { paramView.getScaleX(), 1.0F });
  }
  
  private void cK(View paramView)
  {
    a(paramView, new float[] { paramView.getScaleX(), 0.0F });
  }
  
  public void a(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    a("0X800ABBB", paramInt, paramBoolean, paramString);
  }
  
  public void aOP()
  {
    this.jdField_a_of_type_Mer.aOM();
    stopTiming();
  }
  
  public void b(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    a("0X800ABBC", paramInt, paramBoolean, paramString);
  }
  
  public void d(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aQK == 1) {
      return;
    }
    this.aQK = 1;
    this.jdField_a_of_type_Mer.r(paramString, paramInt1, paramInt2);
    if (paramInt3 == 1)
    {
      this.jx.setImageResource(2130850287);
      return;
    }
    this.jx.setImageResource(2130850288);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.y, 31);
    super.dispatchDraw(paramCanvas);
    new Path().addCircle(paramCanvas.getWidth() / 2, paramCanvas.getWidth() / 2, paramCanvas.getWidth() / 2, Path.Direction.CCW);
    paramCanvas.restore();
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Mer.a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Mer.detachView();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(aqcx.dip2px(getContext(), 27.0F), aqcx.dip2px(getContext(), 27.0F));
  }
  
  public void refresh()
  {
    this.jdField_a_of_type_Mer.refresh();
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setFinishRound(int paramInt)
  {
    this.aQJ = paramInt;
    this.aQI = paramInt;
    this.qK.setText(paramInt + "/" + paramInt);
    cJ(this.qK);
    cJ(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    cJ(this.jx);
    cK(this.jy);
    cK(this.jw);
    this.handler.removeCallbacksAndMessages(null);
    this.handler.postDelayed(new RIJRedPacketProgressView.2(this), 2000L);
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setProgress(paramFloat);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setRound(int paramInt1, int paramInt2)
  {
    this.aQJ = paramInt1;
    this.aQI = paramInt2;
    this.qK.setText(paramInt1 + "/" + this.aQI);
    cJ(this.qK);
    cJ(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    cJ(this.jx);
    cK(this.jy);
    cK(this.jw);
    this.handler.removeCallbacksAndMessages(null);
    this.handler.postDelayed(new RIJRedPacketProgressView.1(this), 2000L);
  }
  
  public void setState(int paramInt)
  {
    if (this.currentState != paramInt)
    {
      this.currentState = paramInt;
      if (paramInt != 0) {
        break label58;
      }
      cJ(this.jw);
      cK(this.jy);
      cK(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
      cK(this.qK);
      cK(this.jx);
    }
    label58:
    while (paramInt != 1) {
      return;
    }
    cJ(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    cJ(this.jy);
    cJ(this.jx);
    cK(this.jw);
    cK(this.qK);
  }
  
  public void stopTiming()
  {
    if (this.aQK == 2) {
      return;
    }
    this.aQK = 2;
    this.jdField_a_of_type_Mer.stopTiming();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView
 * JD-Core Version:    0.7.0.1
 */