package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.ChangeViewSizeAnimation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import hdj;
import hdk;
import hdl;
import hdm;
import hdn;
import java.util.ArrayList;

public class NearbyTroopsMapView
  extends MapView
  implements View.OnClickListener, Animation.AnimationListener, NearbyTroopsMapViewItemOverlay.Callback
{
  static final int jdField_e_of_type_Int = 0;
  static final int f = 1;
  static final int g = 2;
  static final int h = 3;
  int jdField_a_of_type_Int = 0;
  public Context a;
  public Handler a;
  public View a;
  public Animation a;
  public ImageView a;
  public TextView a;
  public NearbyTroopsActivity.UIHandler a;
  public NearbyTroopsMapView.NearbyTroopsMapViewObserver a;
  public NearbyTroopsMapViewItemOverlay a;
  public NearbyTroopsMapViewOverlayItem a;
  public GeoPoint a;
  public Thread a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public TextView c;
  public boolean c;
  int d;
  public TextView d;
  public boolean d;
  boolean jdField_e_of_type_Boolean;
  public int i = 0;
  public int j = 0;
  
  public NearbyTroopsMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_AndroidOsHandler = new hdj(this);
    this.jdField_a_of_type_JavaLangThread = new hdk(this, "qqmapview_calculate_position");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838397);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    addView(this.jdField_b_of_type_AndroidWidgetImageView);
    paramAttributeSet = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838398);
    paramContext = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((paramContext.getAppRuntime() instanceof QQAppInterface)) {}
    for (paramContext = ((QQAppInterface)paramContext.getAppRuntime()).a();; paramContext = "")
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay = new NearbyTroopsMapViewItemOverlay(paramAttributeSet, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setShadowEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setOnFocusChangeListener(new hdl(this));
      addOverlay(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay);
      this.j = getZoomLevel();
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903388, this, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232410));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232411));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232412));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232413));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232408));
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968644);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232414));
      this.jdField_a_of_type_JavaLangThread.setPriority(10);
      this.jdField_a_of_type_JavaLangThread.start();
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public Message a(int paramInt, Point paramPoint)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramPoint;
    return localMessage;
  }
  
  public Message a(int paramInt, GeoPoint paramGeoPoint)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramGeoPoint;
    return localMessage;
  }
  
  public void a(NearbyTroopsMapViewOverlayItem paramNearbyTroopsMapViewOverlayItem)
  {
    if (!this.e) {
      b(false);
    }
    int k;
    label68:
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView.getWidth() != 0) {
        break;
      }
      k = Util.a(this.jdField_a_of_type_AndroidContentContext, 250.0F);
      this.jdField_b_of_type_Int = k;
      this.jdField_c_of_type_Int = getWidth();
      if (this.jdField_c_of_type_AndroidWidgetImageView.getWidth() != 0) {
        break label377;
      }
      k = Util.a(this.jdField_a_of_type_AndroidContentContext, 44.0F);
      this.jdField_d_of_type_Int = k;
      localObject = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    } while (!(((NearbyTroopsActivity)localObject).getAppRuntime() instanceof QQAppInterface));
    Object localObject = (QQAppInterface)((NearbyTroopsActivity)localObject).getAppRuntime();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((QQAppInterface)localObject).a(String.valueOf(paramNearbyTroopsMapViewOverlayItem.jdField_b_of_type_Long), (byte)3, false, false));
    localObject = getProjection().toPixels(paramNearbyTroopsMapViewOverlayItem.getPoint().Copy(), null);
    if (((Point)localObject).x < this.jdField_b_of_type_Int / 2) {
      if (((Point)localObject).x - 60 > 0)
      {
        k = ((Point)localObject).x - 60;
        label178:
        k += 30;
        label183:
        localObject = new MapView.LayoutParams(-2, -2, null, this.jdField_b_of_type_Int / 2 - k - this.jdField_d_of_type_Int / 2, -(this.jdField_a_of_type_Int * 43), 81);
        ((MapView.LayoutParams)localObject).point = paramNearbyTroopsMapViewOverlayItem.getPoint().Copy();
        updateViewLayout(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = k;
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_b_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_Long + "");
        if (paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_Long != 1L) {
          break label497;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setTag(paramNearbyTroopsMapViewOverlayItem);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setFocus(paramNearbyTroopsMapViewOverlayItem);
      refreshMap();
      b(true);
      return;
      k = this.jdField_a_of_type_AndroidViewView.getWidth();
      break;
      label377:
      k = this.jdField_c_of_type_AndroidWidgetImageView.getWidth();
      break label68;
      k = 60;
      break label178;
      if (this.jdField_c_of_type_Int - ((Point)localObject).x < this.jdField_b_of_type_Int / 2)
      {
        int m;
        if (this.jdField_c_of_type_Int - ((Point)localObject).x > 60)
        {
          k = this.jdField_b_of_type_Int;
          m = this.jdField_c_of_type_Int;
        }
        for (k = ((Point)localObject).x + (k - m) + 60 - this.jdField_d_of_type_Int;; k = this.jdField_b_of_type_Int - 60 - this.jdField_d_of_type_Int)
        {
          k -= 30;
          break;
        }
      }
      k = this.jdField_b_of_type_Int / 2 - this.jdField_d_of_type_Int / 2;
      break label183;
      label497:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    do
    {
      do
      {
        return;
        localObject = (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_AndroidViewView.getTag();
      } while ((localObject == null) || (!String.valueOf(((NearbyTroopsMapViewOverlayItem)localObject).jdField_b_of_type_Long).equals(paramString)));
      localObject = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    } while (!(((NearbyTroopsActivity)localObject).getAppRuntime() instanceof QQAppInterface));
    Object localObject = (QQAppInterface)((NearbyTroopsActivity)localObject).getAppRuntime();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((QQAppInterface)localObject).a(paramString, (byte)3, false, false));
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 5))
    {
      ArrayList localArrayList = new ArrayList(5);
      int k = 0;
      while (k < 5)
      {
        localArrayList.add(paramArrayList.get(k));
        k += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(localArrayList, Boolean.valueOf(true), true);
    }
    for (;;)
    {
      refreshMap();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(paramArrayList, Boolean.valueOf(true), true);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(paramArrayList, Boolean.valueOf(false), paramBoolean);
    refreshMap();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    View localView;
    do
    {
      return;
      this.e = paramBoolean;
      localView = ((NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext).findViewById(16908290);
    } while (localView == null);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new ChangeViewSizeAnimation(this, getWidth(), getWidth(), getHeight(), localView.getHeight() - Utils.a(this.jdField_a_of_type_AndroidContentContext, 55.0F));
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new hdm(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(250L);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
      b(false);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new ChangeViewSizeAnimation(this, getWidth(), getWidth(), getHeight(), Utils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F));
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new hdn(this));
    }
  }
  
  public void b(NearbyTroopsMapViewOverlayItem paramNearbyTroopsMapViewOverlayItem)
  {
    Object localObject = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((((NearbyTroopsActivity)localObject).getAppRuntime() instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)((NearbyTroopsActivity)localObject).getAppRuntime(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_label", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
    {
      localObject = (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_AndroidViewView.getTag();
      if (localObject == null) {}
      while ((((NearbyTroopsMapViewOverlayItem)localObject).getPoint().equals(paramNearbyTroopsMapViewOverlayItem.getPoint())) || (!((NearbyTroopsMapViewOverlayItem)localObject).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    a(paramNearbyTroopsMapViewOverlayItem);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.i += 1;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver != null) && (this.jdField_a_of_type_JavaLangThread != null)) {
      synchronized (this.jdField_a_of_type_JavaLangThread)
      {
        this.jdField_a_of_type_JavaLangThread.notify();
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Boolean = true;
      continue;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.e)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    while (!(paramView instanceof NearbyTroopsMapViewOverlayItem)) {
      return;
    }
    Object localObject = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((((NearbyTroopsActivity)localObject).getAppRuntime() instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)((NearbyTroopsActivity)localObject).getAppRuntime(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_bubble", 0, 0, "", "", "", "");
    }
    paramView = (NearbyTroopsMapViewOverlayItem)paramView;
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsLocationActivity.class);
    ((Intent)localObject).putExtra("lat", paramView.getPoint().getLatitudeE6());
    ((Intent)localObject).putExtra("lon", paramView.getPoint().getLongitudeE6());
    ((Intent)localObject).putExtra("location_name", paramView.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("from", 10);
    ((Intent)localObject).putExtra("mode", 1);
    ((Intent)localObject).putExtra("leftViewText", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131561692));
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = null;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    super.onDestroy();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setMyLocation(GeoPoint paramGeoPoint)
  {
    MapView.LayoutParams localLayoutParams = new MapView.LayoutParams(-2, -2, null, 81);
    localLayoutParams.point = paramGeoPoint.Copy();
    updateViewLayout(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void setObserver(NearbyTroopsMapView.NearbyTroopsMapViewObserver paramNearbyTroopsMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver = paramNearbyTroopsMapViewObserver;
  }
  
  public void setUIHandler(NearbyTroopsActivity.UIHandler paramUIHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = paramUIHandler;
  }
  
  public void showNearestPopView()
  {
    if (!this.e) {}
    NearbyTroopsMapViewOverlayItem localNearbyTroopsMapViewOverlayItem;
    do
    {
      return;
      localNearbyTroopsMapViewOverlayItem = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(this);
    } while ((localNearbyTroopsMapViewOverlayItem == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem == localNearbyTroopsMapViewOverlayItem) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem = localNearbyTroopsMapViewOverlayItem;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.NearbyTroopsMapView
 * JD-Core Version:    0.7.0.1
 */