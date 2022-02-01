package com.tencent.mobileqq.filemanager.widget;

import ahav;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;

public class FileWebView
  extends WebView
{
  long JD = 0L;
  b a;
  private Object aS = new Object();
  final int cZq = 80;
  boolean cge = false;
  float downY = 0.0F;
  private Timer timer;
  float wx = 1.0F;
  float wy = 0.0F;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11)
    {
      setZoomControlGone(this);
      return;
    }
    getSettings().setDisplayZoomControls(false);
  }
  
  private Class a(ParameterizedType paramParameterizedType, int paramInt)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments()[paramInt];
    if ((paramParameterizedType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramParameterizedType).getRawType();
    }
    if ((paramParameterizedType instanceof GenericArrayType)) {
      return (Class)((GenericArrayType)paramParameterizedType).getGenericComponentType();
    }
    if ((paramParameterizedType instanceof TypeVariable)) {
      return a(((TypeVariable)paramParameterizedType).getBounds()[0], 0);
    }
    return (Class)paramParameterizedType;
  }
  
  private Class a(Type paramType, int paramInt)
  {
    if ((paramType instanceof ParameterizedType)) {
      return a((ParameterizedType)paramType, paramInt);
    }
    if ((paramType instanceof TypeVariable)) {
      return a(((TypeVariable)paramType).getBounds()[0], 0);
    }
    return (Class)paramType;
  }
  
  public boolean a(WebView paramWebView, String paramString, a parama)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    Object localObject1 = paramString.split("[?]");
    int i;
    Object localObject2;
    WebView localWebView;
    if ((paramString.length() > 1) && (localObject1.length > 1))
    {
      paramWebView = localObject1[0];
      paramString = localObject1[1].replaceFirst("p=", "");
      paramWebView = Arrays.asList((paramWebView + "/#").split("/"));
      if (paramWebView.size() < 5) {
        return false;
      }
      if (!((String)paramWebView.get(2)).equalsIgnoreCase("preview")) {
        return false;
      }
      String str = (String)paramWebView.get(3);
      localObject1 = null;
      try
      {
        paramWebView = ahav.a(paramString);
        localObject1 = paramWebView;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          Method[] arrayOfMethod;
          int j;
          if (QLog.isColorLevel()) {
            QLog.e("FileWebView", 1, "paramString parse fail!,paramString:" + paramString);
          }
          paramWebView.printStackTrace();
          continue;
          i += 1;
          paramWebView = localWebView;
        }
      }
      arrayOfMethod = parama.getClass().getMethods();
      j = arrayOfMethod.length;
      i = 0;
      paramWebView = null;
      if (i < j)
      {
        localObject2 = arrayOfMethod[i];
        localWebView = paramWebView;
        if (((Method)localObject2).getName().equals(str))
        {
          paramWebView = ((Method)localObject2).getParameterTypes();
          localWebView = paramWebView;
          if (paramWebView.length == ((LinkedHashMap)localObject1).size())
          {
            localWebView = paramWebView;
            paramWebView = (WebView)localObject2;
            label214:
            if (paramWebView != null) {
              break label278;
            }
            parama.webLog(paramString);
            return true;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label278:
        if (((LinkedHashMap)localObject1).size() == 0)
        {
          paramWebView.invoke(parama, new Object[0]);
          return true;
        }
        paramString = ((LinkedHashMap)localObject1).values().toArray();
        localObject1 = new Object[localWebView.length];
        i = 0;
        if (i < localWebView.length)
        {
          localObject2 = a(localWebView[i], i).toString().toLowerCase();
          if ((((String)localObject2).contains("int")) || (((String)localObject2).contains("integer"))) {
            localObject1[i] = Integer.valueOf(Integer.parseInt((String)paramString[i]));
          } else if (((String)localObject2).contains("long")) {
            localObject1[i] = Long.valueOf(Long.parseLong((String)paramString[i]));
          }
        }
      }
      catch (IllegalAccessException paramWebView)
      {
        QLog.e("FileWebView", 2, "invoke method exception!!! IllegalAccessException");
        return false;
        if (((String)localObject2).contains("string")) {
          localObject1[i] = ((String)paramString[i]);
        }
      }
      catch (IllegalArgumentException paramWebView)
      {
        QLog.e("FileWebView", 2, "invoke method exception!!! IllegalArgumentException");
        return false;
        if (!((String)localObject2).contains("boolean")) {
          break label555;
        }
        localObject1[i] = Boolean.valueOf(Boolean.parseBoolean((String)paramString[i]));
      }
      catch (InvocationTargetException paramWebView)
      {
        QLog.e("FileWebView", 1, "invoke method exception!!! InvocationTargetException");
        return false;
        paramWebView.invoke(parama, (Object[])localObject1);
        return true;
      }
      catch (Exception paramWebView)
      {
        QLog.e("FileWebView", 1, "invoke method exception!!! Exception");
        return false;
      }
      localWebView = paramWebView;
      paramWebView = null;
      break label214;
      paramWebView = "";
      paramString = "";
      break;
      label555:
      i += 1;
    }
  }
  
  public void destroy()
  {
    synchronized (this.aS)
    {
      if (this.timer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.timer + " this " + this + "is cancel");
        this.timer.cancel();
        this.timer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.JD = Calendar.getInstance().getTimeInMillis();
      this.downY = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.JD < 80L)
      {
        this.a.dfp();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.wy = paramMotionEvent.getY();
      if (this.downY > this.wy)
      {
        getContentHeight();
        getHeight();
        int i = getWebScrollY();
        getScale();
        if ((getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D) || (i == 0))
        {
          this.a.onGetMore();
          this.a.dfo();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.a.dfn();
      }
      do
      {
        this.a.dfo();
        break;
        this.a.dfq();
      } while (getScrollY() >= 1.0F);
      this.a.IR(false);
      this.a.dfo();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.a.hl();
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.cge) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a == null) {}
    do
    {
      return;
      paramInt1 = getContentHeight();
      paramInt3 = getView().getHeight();
      int i = getWebScrollY();
      float f = getScale();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileWebView", 4, "contentHeight[" + paramInt1 + "],height[" + paramInt3 + "],scroolY[" + i + "],scale[" + f + "]");
      }
      f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
      if ((f < paramInt3 * 2) && (!ahav.amK())) {
        this.a.dfr();
      }
      if (f < 2.5D) {
        this.a.onGetMore();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.a.IR(false);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(b paramb)
  {
    this.a = paramb;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.cge = paramBoolean;
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
  
  public static abstract interface a
  {
    public abstract void loadFinish(int paramInt1, int paramInt2, String paramString);
    
    public abstract void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString);
    
    public abstract void openFile(String paramString1, String paramString2, long paramLong, boolean paramBoolean);
    
    public abstract void updatePage(int paramInt1, int paramInt2);
    
    public abstract void webLog(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void IR(boolean paramBoolean);
    
    public abstract void dfn();
    
    public abstract void dfo();
    
    public abstract void dfp();
    
    public abstract void dfq();
    
    public abstract void dfr();
    
    public abstract void hl();
    
    public abstract void onGetMore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */