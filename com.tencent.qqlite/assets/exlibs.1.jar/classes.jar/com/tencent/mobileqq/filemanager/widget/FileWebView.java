package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import dvw;
import dvx;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class FileWebView
  extends WebView
{
  private static final String jdField_a_of_type_JavaLangString = "FileWebView";
  float jdField_a_of_type_Float = 1.0F;
  final int jdField_a_of_type_Int = 80;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  public FileWebView.TitilebarEventInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean = false;
  float b;
  public boolean b;
  float c = 0.0F;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 0.0F;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
      setZoomControlGone(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilTimerTask = new dvx(this, new dvw(this));
      return;
      getSettings().setDisplayZoomControls(false);
    }
  }
  
  private boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private boolean c()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    float f = getScale();
    return Math.abs(this.jdField_a_of_type_Float - f) < 0.1D;
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.jdField_a_of_type_JavaUtilTimer + " this " + this + "is cancel");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.f();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.c = paramMotionEvent.getY();
      if (this.jdField_b_of_type_Float > this.c)
      {
        getContentHeight();
        getHeight();
        getWebScrollY();
        getScale();
        if (getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a();
      }
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
      } while (getScrollY() >= 1.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.e();
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {}
    do
    {
      return;
      getContentHeight();
      getView().getHeight();
      getWebScrollY();
      getScale();
      if (getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 2.5D) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setListenSroll()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 2000L, 300L);
      return;
    }
  }
  
  public void setOnCustomScroolChangeListener(FileWebView.TitilebarEventInterface paramTitilebarEventInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface = paramTitilebarEventInterface;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */