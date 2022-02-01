package com.tencent.tim.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import audx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Calendar;
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
    removeJavascriptInterface("searchBoxJavaBridge_");
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    removeJavascriptInterface("searchBoxJavaBridge_");
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    removeJavascriptInterface("searchBoxJavaBridge_");
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
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
  
  /* Error */
  public boolean a(WebView paramWebView, String paramString, a parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_2
    //   7: ldc 133
    //   9: invokevirtual 139	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_2
    //   18: ldc 141
    //   20: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 6
    //   25: aload_2
    //   26: invokevirtual 148	java/lang/String:length	()I
    //   29: iconst_1
    //   30: if_icmple +541 -> 571
    //   33: aload 6
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmple +534 -> 571
    //   40: aload 6
    //   42: iconst_0
    //   43: aaload
    //   44: astore_1
    //   45: aload 6
    //   47: iconst_1
    //   48: aaload
    //   49: ldc 150
    //   51: ldc 152
    //   53: invokevirtual 156	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 158	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 165
    //   70: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc 171
    //   78: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: invokestatic 177	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface 182 1 0
    //   91: iconst_5
    //   92: if_icmpge +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_1
    //   98: iconst_2
    //   99: invokeinterface 186 2 0
    //   104: checkcast 135	java/lang/String
    //   107: ldc 188
    //   109: invokevirtual 191	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_1
    //   118: iconst_3
    //   119: invokeinterface 186 2 0
    //   124: checkcast 135	java/lang/String
    //   127: astore 9
    //   129: aconst_null
    //   130: astore 6
    //   132: aload_2
    //   133: invokestatic 196	audx:a	(Ljava/lang/String;)Ljava/util/LinkedHashMap;
    //   136: astore_1
    //   137: aload_1
    //   138: astore 6
    //   140: aload_3
    //   141: invokevirtual 200	java/lang/Object:getClass	()Ljava/lang/Class;
    //   144: invokevirtual 204	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   147: astore 10
    //   149: aload 10
    //   151: arraylength
    //   152: istore 5
    //   154: iconst_0
    //   155: istore 4
    //   157: aconst_null
    //   158: astore_1
    //   159: iload 4
    //   161: iload 5
    //   163: if_icmpge +400 -> 563
    //   166: aload 10
    //   168: iload 4
    //   170: aaload
    //   171: astore 8
    //   173: aload_1
    //   174: astore 7
    //   176: aload 8
    //   178: invokevirtual 209	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   181: aload 9
    //   183: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +91 -> 277
    //   189: aload 8
    //   191: invokevirtual 217	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 7
    //   198: aload_1
    //   199: arraylength
    //   200: aload 6
    //   202: invokevirtual 220	java/util/LinkedHashMap:size	()I
    //   205: if_icmpne +72 -> 277
    //   208: aload_1
    //   209: astore 7
    //   211: aload 8
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +338 -> 553
    //   218: aload 6
    //   220: invokevirtual 220	java/util/LinkedHashMap:size	()I
    //   223: ifne +66 -> 289
    //   226: aload_1
    //   227: aload_3
    //   228: iconst_0
    //   229: anewarray 49	java/lang/Object
    //   232: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_1
    //   239: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +28 -> 270
    //   245: ldc 232
    //   247: iconst_1
    //   248: new 158	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   255: ldc 234
    //   257: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_2
    //   261: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_1
    //   271: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   274: goto -134 -> 140
    //   277: iload 4
    //   279: iconst_1
    //   280: iadd
    //   281: istore 4
    //   283: aload 7
    //   285: astore_1
    //   286: goto -127 -> 159
    //   289: aload 6
    //   291: invokevirtual 245	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   294: invokeinterface 251 1 0
    //   299: astore_2
    //   300: aload 7
    //   302: arraylength
    //   303: anewarray 49	java/lang/Object
    //   306: astore 6
    //   308: iconst_0
    //   309: istore 4
    //   311: iload 4
    //   313: aload 7
    //   315: arraylength
    //   316: if_icmpge +209 -> 525
    //   319: aload_0
    //   320: aload 7
    //   322: iload 4
    //   324: aaload
    //   325: iload 4
    //   327: invokespecial 120	com/tencent/tim/filemanager/widget/FileWebView:a	(Ljava/lang/reflect/Type;I)Ljava/lang/Class;
    //   330: invokevirtual 252	java/lang/Class:toString	()Ljava/lang/String;
    //   333: invokevirtual 255	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   336: astore 8
    //   338: aload 8
    //   340: ldc_w 257
    //   343: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   346: ifne +14 -> 360
    //   349: aload 8
    //   351: ldc_w 263
    //   354: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   357: ifeq +24 -> 381
    //   360: aload 6
    //   362: iload 4
    //   364: aload_2
    //   365: iload 4
    //   367: aaload
    //   368: checkcast 135	java/lang/String
    //   371: invokestatic 267	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   374: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: goto +202 -> 580
    //   381: aload 8
    //   383: ldc_w 272
    //   386: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   389: ifeq +42 -> 431
    //   392: aload 6
    //   394: iload 4
    //   396: aload_2
    //   397: iload 4
    //   399: aaload
    //   400: checkcast 135	java/lang/String
    //   403: invokestatic 278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   406: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   409: aastore
    //   410: goto +170 -> 580
    //   413: astore_1
    //   414: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +12 -> 429
    //   420: ldc 232
    //   422: iconst_2
    //   423: ldc_w 283
    //   426: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iconst_0
    //   430: ireturn
    //   431: aload 8
    //   433: ldc_w 285
    //   436: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   439: ifeq +36 -> 475
    //   442: aload 6
    //   444: iload 4
    //   446: aload_2
    //   447: iload 4
    //   449: aaload
    //   450: checkcast 135	java/lang/String
    //   453: aastore
    //   454: goto +126 -> 580
    //   457: astore_1
    //   458: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq +12 -> 473
    //   464: ldc 232
    //   466: iconst_2
    //   467: ldc_w 287
    //   470: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iconst_0
    //   474: ireturn
    //   475: aload 8
    //   477: ldc_w 289
    //   480: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +97 -> 580
    //   486: aload 6
    //   488: iload 4
    //   490: aload_2
    //   491: iload 4
    //   493: aaload
    //   494: checkcast 135	java/lang/String
    //   497: invokestatic 294	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   500: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   503: aastore
    //   504: goto +76 -> 580
    //   507: astore_1
    //   508: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +12 -> 523
    //   514: ldc 232
    //   516: iconst_2
    //   517: ldc_w 299
    //   520: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: iconst_0
    //   524: ireturn
    //   525: aload_1
    //   526: aload_3
    //   527: aload 6
    //   529: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   532: pop
    //   533: iconst_1
    //   534: ireturn
    //   535: astore_1
    //   536: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +12 -> 551
    //   542: ldc 232
    //   544: iconst_2
    //   545: ldc_w 301
    //   548: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: iconst_0
    //   552: ireturn
    //   553: aload_3
    //   554: aload_2
    //   555: invokeinterface 304 2 0
    //   560: goto -324 -> 236
    //   563: aload_1
    //   564: astore 7
    //   566: aconst_null
    //   567: astore_1
    //   568: goto -354 -> 214
    //   571: ldc 152
    //   573: astore_1
    //   574: ldc 152
    //   576: astore_2
    //   577: goto -520 -> 57
    //   580: iload 4
    //   582: iconst_1
    //   583: iadd
    //   584: istore 4
    //   586: goto -275 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	FileWebView
    //   0	589	1	paramWebView	WebView
    //   0	589	2	paramString	String
    //   0	589	3	parama	a
    //   155	430	4	i	int
    //   152	12	5	j	int
    //   23	505	6	localObject1	Object
    //   174	391	7	localWebView	WebView
    //   171	305	8	localObject2	Object
    //   127	55	9	str	String
    //   147	20	10	arrayOfMethod	java.lang.reflect.Method[]
    // Exception table:
    //   from	to	target	type
    //   132	137	238	java/lang/Exception
    //   218	236	413	java/lang/IllegalAccessException
    //   289	308	413	java/lang/IllegalAccessException
    //   311	360	413	java/lang/IllegalAccessException
    //   360	378	413	java/lang/IllegalAccessException
    //   381	410	413	java/lang/IllegalAccessException
    //   431	454	413	java/lang/IllegalAccessException
    //   475	504	413	java/lang/IllegalAccessException
    //   525	533	413	java/lang/IllegalAccessException
    //   218	236	457	java/lang/IllegalArgumentException
    //   289	308	457	java/lang/IllegalArgumentException
    //   311	360	457	java/lang/IllegalArgumentException
    //   360	378	457	java/lang/IllegalArgumentException
    //   381	410	457	java/lang/IllegalArgumentException
    //   431	454	457	java/lang/IllegalArgumentException
    //   475	504	457	java/lang/IllegalArgumentException
    //   525	533	457	java/lang/IllegalArgumentException
    //   218	236	507	java/lang/reflect/InvocationTargetException
    //   289	308	507	java/lang/reflect/InvocationTargetException
    //   311	360	507	java/lang/reflect/InvocationTargetException
    //   360	378	507	java/lang/reflect/InvocationTargetException
    //   381	410	507	java/lang/reflect/InvocationTargetException
    //   431	454	507	java/lang/reflect/InvocationTargetException
    //   475	504	507	java/lang/reflect/InvocationTargetException
    //   525	533	507	java/lang/reflect/InvocationTargetException
    //   218	236	535	java/lang/Exception
    //   289	308	535	java/lang/Exception
    //   311	360	535	java/lang/Exception
    //   360	378	535	java/lang/Exception
    //   381	410	535	java/lang/Exception
    //   431	454	535	java/lang/Exception
    //   475	504	535	java/lang/Exception
    //   525	533	535	java/lang/Exception
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
      if ((f < paramInt3 * 2) && (!audx.amK())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */