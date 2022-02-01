package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebview.OnWebviewScrollListener;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebInputHandler
{
  private static final int DEFAULT_SPACING = 5;
  private static final String TAG = "WebInputHandler";
  private boolean adjustPosition = false;
  private int inputId;
  private boolean isKeyboardShow = false;
  private WebEditText mCurrentFocusInput;
  private AtomicInteger mInputIdGenerator = new AtomicInteger(0);
  private Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> mInputKeyboardListner = new ConcurrentHashMap();
  private Object mInputLock = new Object();
  private NativeViewContainer mNativeContainer;
  private Map<Integer, String> mSetValue = new HashMap();
  private Map<Integer, WebEditText> mShowingInput = new ConcurrentHashMap();
  private int navbarHeight;
  private int offset = 0;
  private int screenHeight;
  public PageWebview.OnWebviewScrollListener scrollListener;
  private int showKeyboardHeight = 0;
  
  public WebInputHandler(NativeViewContainer paramNativeViewContainer)
  {
    this.mNativeContainer = paramNativeViewContainer;
  }
  
  private void AnimatorTranslateY(float... paramVarArgs)
  {
    paramVarArgs = ObjectAnimator.ofFloat(this.mNativeContainer.getPageWebviewContainer(), "translationY", paramVarArgs);
    paramVarArgs.setDuration(200L);
    paramVarArgs.setInterpolator(new AccelerateDecelerateInterpolator());
    paramVarArgs.start();
  }
  
  private boolean parseParams(NativeViewRequestEvent paramNativeViewRequestEvent, WebEditText paramWebEditText)
  {
    try
    {
      boolean bool = paramWebEditText.initWithWebParams(this.mNativeContainer, paramNativeViewRequestEvent.jsonParams);
      return bool;
    }
    catch (Exception paramNativeViewRequestEvent)
    {
      QMLog.e("WebInputHandler", "[showKeyboard] initWithWebParams exception:", paramNativeViewRequestEvent);
    }
    return false;
  }
  
  public Map<Integer, WebEditText> getShowingInput()
  {
    return this.mShowingInput;
  }
  
  public boolean hasFocusInput()
  {
    return this.mCurrentFocusInput != null;
  }
  
  public void hideCurrentInput(boolean paramBoolean)
  {
    if ((this.mCurrentFocusInput == null) || (this.mNativeContainer == null) || (this.mNativeContainer.getPageWebviewContainer() == null))
    {
      QMLog.e("WebInputHandler", "mCurrentFocusInput is null, return.");
      return;
    }
    if (this.mShowingInput.size() > 0)
    {
      Iterator localIterator = this.mShowingInput.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (WebEditText)((Map.Entry)localIterator.next()).getValue();
          QMLog.d("WebInputHandler", "[hideCurrentInput] webEditText=" + localObject);
          int i = ((WebEditText)localObject).getInputId();
          String str = ((WebEditText)localObject).getText().toString();
          PageWebview localPageWebview = ((WebEditText)localObject).getPageWebview();
          if ((this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == ((WebEditText)localObject).getInputId()) && (paramBoolean)) {
            ((InputMethodManager)((WebEditText)localObject).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject).getWindowToken(), 0);
          }
          ((WebEditText)localObject).clearFocus();
          ((WebEditText)localObject).detach();
          ((WebEditText)localObject).setHasMoveParent(false);
          this.mShowingInput.remove(Integer.valueOf(i));
          if (this.mNativeContainer != null)
          {
            localObject = (SoftKeyboardStateHelper.SoftKeyboardStateListener)this.mInputKeyboardListner.remove(Integer.valueOf(i));
            this.mNativeContainer.removeSoftKeyboardStateListener((SoftKeyboardStateHelper.SoftKeyboardStateListener)localObject);
          }
          if (localPageWebview == null) {
            continue;
          }
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("inputId", i);
            ((JSONObject)localObject).put("value", str);
            ((JSONObject)localObject).put("cursor", str.length());
            this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardComplete", ((JSONObject)localObject).toString());
            if (this.scrollListener != null) {
              localPageWebview.removeWebviewScrollListener(this.scrollListener);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("WebInputHandler", "[hideCurrentInput] exception:", localException);
            }
          }
        }
      }
    }
    this.mCurrentFocusInput = null;
  }
  
  /* Error */
  public void hideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 26
    //   4: new 209	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 332
    //   14: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: getfield 148	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsonParams	Ljava/lang/String;
    //   21: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 334
    //   27: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 337	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:callbackId	I
    //   34: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 226	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 65	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mInputLock	Ljava/lang/Object;
    //   47: astore_3
    //   48: aload_3
    //   49: monitorenter
    //   50: aload_1
    //   51: getfield 148	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsonParams	Ljava/lang/String;
    //   54: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifeq +21 -> 78
    //   60: ldc 26
    //   62: ldc_w 348
    //   65: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 351	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   72: pop
    //   73: aload_3
    //   74: monitorexit
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: new 287	org/json/JSONObject
    //   81: dup
    //   82: aload_1
    //   83: getfield 148	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsonParams	Ljava/lang/String;
    //   86: invokespecial 354	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: ldc_w 289
    //   92: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   95: istore_2
    //   96: aload_0
    //   97: getfield 70	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   100: iload_2
    //   101: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: invokeinterface 362 2 0
    //   109: ifne +23 -> 132
    //   112: aload_1
    //   113: invokevirtual 365	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	()Ljava/lang/String;
    //   116: pop
    //   117: aload_3
    //   118: monitorexit
    //   119: goto -44 -> 75
    //   122: astore_1
    //   123: aload_3
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: aload_0
    //   133: getfield 70	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   136: iload_2
    //   137: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokeinterface 368 2 0
    //   145: checkcast 150	com/tencent/qqmini/miniapp/core/page/widget/WebEditText
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 77	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mSetValue	Ljava/util/Map;
    //   154: iload_2
    //   155: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: invokeinterface 279 2 0
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 365	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	()Ljava/lang/String;
    //   168: pop
    //   169: new 287	org/json/JSONObject
    //   172: dup
    //   173: invokespecial 288	org/json/JSONObject:<init>	()V
    //   176: astore 5
    //   178: aload 5
    //   180: ldc_w 289
    //   183: iload_2
    //   184: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload 5
    //   190: ldc_w 295
    //   193: aload 4
    //   195: invokevirtual 233	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getText	()Landroid/text/Editable;
    //   198: invokevirtual 234	java/lang/Object:toString	()Ljava/lang/String;
    //   201: invokevirtual 298	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   204: pop
    //   205: aload 5
    //   207: ldc_w 300
    //   210: aload 4
    //   212: invokevirtual 233	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getText	()Landroid/text/Editable;
    //   215: invokevirtual 234	java/lang/Object:toString	()Ljava/lang/String;
    //   218: invokevirtual 305	java/lang/String:length	()I
    //   221: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload_0
    //   226: iconst_1
    //   227: invokevirtual 370	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:hideCurrentInput	(Z)V
    //   230: aload_1
    //   231: getfield 374	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   234: ldc_w 307
    //   237: aload 5
    //   239: invokevirtual 308	org/json/JSONObject:toString	()Ljava/lang/String;
    //   242: iconst_0
    //   243: invokeinterface 379 4 0
    //   248: aload_3
    //   249: monitorexit
    //   250: goto -175 -> 75
    //   253: astore_1
    //   254: ldc 26
    //   256: ldc_w 381
    //   259: aload_1
    //   260: invokestatic 162	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -15 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	WebInputHandler
    //   0	266	1	paramNativeViewRequestEvent	NativeViewRequestEvent
    //   95	89	2	i	int
    //   148	63	4	localWebEditText	WebEditText
    //   176	62	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   50	75	122	finally
    //   78	117	122	finally
    //   117	119	122	finally
    //   123	125	122	finally
    //   132	248	122	finally
    //   248	250	122	finally
    //   254	263	122	finally
    //   2	50	127	finally
    //   125	127	127	finally
    //   78	117	253	java/lang/Exception
    //   132	248	253	java/lang/Exception
  }
  
  public boolean isFocus(int paramInt)
  {
    return (this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == paramInt);
  }
  
  public void setKeyboardValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    label96:
    try
    {
      QMLog.d("WebInputHandler", ", webParams=" + paramNativeViewRequestEvent.jsonParams + ", callbackId=" + paramNativeViewRequestEvent.callbackId);
      try
      {
        localObject2 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
        j = ((JSONObject)localObject2).optInt("inputId");
        localObject1 = (WebEditText)this.mShowingInput.get(Integer.valueOf(j));
        if (localObject1 != null) {
          break label96;
        }
        paramNativeViewRequestEvent.fail();
      }
      catch (Exception paramNativeViewRequestEvent)
      {
        for (;;)
        {
          Object localObject2;
          int j;
          Object localObject1;
          QMLog.e("WebInputHandler", "setKeyboardValue error.", paramNativeViewRequestEvent);
        }
      }
      return;
    }
    finally {}
    localObject2 = ((JSONObject)localObject2).optString("value");
    this.mSetValue.put(Integer.valueOf(j), localObject2);
    ((WebEditText)localObject1).setText((CharSequence)localObject2);
    if (localObject2 != null) {}
    for (int i = ((String)localObject2).length();; i = 0)
    {
      ((WebEditText)localObject1).setSelection(i);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("inputId", j);
      paramNativeViewRequestEvent.ok((JSONObject)localObject1);
      break;
    }
  }
  
  public void showKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("WebInputHandler", "showKeyboard , webParams=" + paramNativeViewRequestEvent.jsonParams + ", callbackId=" + paramNativeViewRequestEvent.callbackId);
    synchronized (this.mInputLock)
    {
      QMLog.d("WebInputHandler", "[showKeyboard] mCurrentFocusInput=" + this.mCurrentFocusInput);
      if (TextUtils.isEmpty(paramNativeViewRequestEvent.jsonParams))
      {
        QMLog.e("WebInputHandler", "[showKeyboard] no web input params");
        paramNativeViewRequestEvent.fail();
        return;
      }
      if (this.mNativeContainer == null)
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
    }
    this.screenHeight = DisplayUtil.getRealHeight(this.mNativeContainer.getContext());
    this.navbarHeight = this.mNativeContainer.getNaviBarHeight();
    Object localObject2 = new WebEditText(this.mNativeContainer.getContext(), this);
    this.inputId = this.mInputIdGenerator.incrementAndGet();
    this.mNativeContainer.setCurInputId(this.inputId);
    PageWebview localPageWebview = this.mNativeContainer.getCurrentPageWebview();
    this.scrollListener = new MyOnWebviewScrollListener(localPageWebview);
    if (this.mNativeContainer != null)
    {
      KeyboardHiddenObserver localKeyboardHiddenObserver = new KeyboardHiddenObserver();
      this.mNativeContainer.setSoftKeyboardStateListener(localKeyboardHiddenObserver);
      this.mInputKeyboardListner.put(Integer.valueOf(this.inputId), localKeyboardHiddenObserver);
    }
    if (localPageWebview != null) {
      localPageWebview.setOnWebviewScrollListener(this.scrollListener);
    }
    for (;;)
    {
      try
      {
        if (!parseParams(paramNativeViewRequestEvent, (WebEditText)localObject2)) {
          continue;
        }
        if ((this.mNativeContainer != null) && (this.mNativeContainer.getPageWebviewContainer() != null)) {
          this.mNativeContainer.getPageWebviewContainer().addView((View)localObject2, ((WebEditText)localObject2).makeLayoutParams(this.mNativeContainer.getCurrentPageWebview().scrollY));
        }
        this.mCurrentFocusInput = ((WebEditText)localObject2);
        ((WebEditText)localObject2).setInputId(this.inputId);
        ((WebEditText)localObject2).setPageWebview(localPageWebview);
        this.mShowingInput.put(Integer.valueOf(this.inputId), localObject2);
        ((WebEditText)localObject2).showSoftInput();
        ((WebEditText)localObject2).addTextChangedListener(new MyTextWatcher(paramNativeViewRequestEvent));
        ((WebEditText)localObject2).setOnEditorActionListener(new MyOnEditorActionListener((WebEditText)localObject2, paramNativeViewRequestEvent));
        ((WebEditText)localObject2).getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener((WebEditText)localObject2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inputId", this.inputId);
        paramNativeViewRequestEvent.ok((JSONObject)localObject2);
      }
      catch (Exception paramNativeViewRequestEvent)
      {
        QMLog.e("WebInputHandler", "[showKeyboard] exception:", paramNativeViewRequestEvent);
        continue;
      }
      return;
      paramNativeViewRequestEvent.fail();
    }
  }
  
  /* Error */
  public boolean updateInput(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   6: astore 10
    //   8: aload 10
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 9
    //   20: ireturn
    //   21: new 287	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 354	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 70	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   35: aload 10
    //   37: ldc_w 289
    //   40: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 368 2 0
    //   51: checkcast 150	com/tencent/qqmini/miniapp/core/page/widget/WebEditText
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +9 -> 65
    //   59: iconst_0
    //   60: istore 9
    //   62: goto -46 -> 16
    //   65: aload 10
    //   67: ldc_w 295
    //   70: invokevirtual 504	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +28 -> 101
    //   76: aload 10
    //   78: ldc_w 295
    //   81: invokevirtual 388	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_1
    //   87: aload 11
    //   89: invokevirtual 395	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   92: aload_1
    //   93: aload 11
    //   95: invokevirtual 305	java/lang/String:length	()I
    //   98: invokevirtual 398	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   101: aload 10
    //   103: ldc_w 506
    //   106: iconst_m1
    //   107: invokevirtual 509	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   110: istore_3
    //   111: aload 10
    //   113: ldc_w 511
    //   116: iconst_m1
    //   117: invokevirtual 509	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   120: istore 4
    //   122: iload_3
    //   123: iconst_m1
    //   124: if_icmpeq +22 -> 146
    //   127: iload 4
    //   129: iconst_m1
    //   130: if_icmpeq +16 -> 146
    //   133: iload 4
    //   135: iload_3
    //   136: if_icmple +10 -> 146
    //   139: aload_1
    //   140: iload_3
    //   141: iload 4
    //   143: invokevirtual 514	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(II)V
    //   146: aload 10
    //   148: ldc_w 300
    //   151: iconst_m1
    //   152: invokevirtual 509	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 398	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   165: aload 10
    //   167: ldc_w 516
    //   170: invokevirtual 520	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +173 -> 350
    //   180: aload 10
    //   182: ldc_w 522
    //   185: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 6
    //   190: aload 10
    //   192: ldc_w 524
    //   195: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   198: istore 5
    //   200: aload 10
    //   202: ldc_w 526
    //   205: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 528
    //   214: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   217: istore 4
    //   219: aload_1
    //   220: invokevirtual 242	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getContext	()Landroid/content/Context;
    //   223: invokestatic 532	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   226: fstore_2
    //   227: iload_3
    //   228: i2f
    //   229: fload_2
    //   230: fmul
    //   231: ldc_w 533
    //   234: fadd
    //   235: fconst_0
    //   236: invokestatic 539	java/lang/Math:max	(FF)F
    //   239: f2i
    //   240: istore_3
    //   241: iload 4
    //   243: i2f
    //   244: fload_2
    //   245: fmul
    //   246: ldc_w 533
    //   249: fadd
    //   250: fconst_0
    //   251: invokestatic 539	java/lang/Math:max	(FF)F
    //   254: f2i
    //   255: istore 4
    //   257: iload 6
    //   259: i2f
    //   260: fload_2
    //   261: fmul
    //   262: ldc_w 533
    //   265: fadd
    //   266: f2i
    //   267: istore 6
    //   269: aload_0
    //   270: iconst_0
    //   271: putfield 424	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   274: iload 5
    //   276: i2f
    //   277: fload_2
    //   278: fmul
    //   279: ldc_w 533
    //   282: fadd
    //   283: f2i
    //   284: istore 5
    //   286: aload_0
    //   287: getfield 87	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mNativeContainer	Lcom/tencent/qqmini/miniapp/core/page/NativeViewContainer;
    //   290: invokevirtual 436	com/tencent/qqmini/miniapp/core/page/NativeViewContainer:getCurrentPageWebview	()Lcom/tencent/qqmini/miniapp/core/page/PageWebview;
    //   293: getfield 453	com/tencent/qqmini/miniapp/core/page/PageWebview:scrollY	I
    //   296: istore 7
    //   298: aload_0
    //   299: getfield 424	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   302: istore 8
    //   304: aload_1
    //   305: invokevirtual 543	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   308: checkcast 545	android/widget/FrameLayout$LayoutParams
    //   311: astore 10
    //   313: aload 10
    //   315: iload_3
    //   316: putfield 547	android/widget/FrameLayout$LayoutParams:width	I
    //   319: aload 10
    //   321: iload 4
    //   323: putfield 549	android/widget/FrameLayout$LayoutParams:height	I
    //   326: aload 10
    //   328: iload 6
    //   330: putfield 552	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   333: aload 10
    //   335: iload 8
    //   337: iload 5
    //   339: iload 7
    //   341: isub
    //   342: iadd
    //   343: putfield 555	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   346: aload_1
    //   347: invokevirtual 558	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:requestLayout	()V
    //   350: iconst_1
    //   351: istore 9
    //   353: goto -337 -> 16
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual 561	java/lang/Exception:printStackTrace	()V
    //   361: iconst_0
    //   362: istore 9
    //   364: goto -348 -> 16
    //   367: astore_1
    //   368: aload_0
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	WebInputHandler
    //   0	372	1	paramString	String
    //   226	52	2	f	float
    //   110	206	3	i	int
    //   120	202	4	j	int
    //   198	144	5	k	int
    //   188	141	6	m	int
    //   296	46	7	n	int
    //   302	41	8	i1	int
    //   14	349	9	bool	boolean
    //   6	328	10	localObject	Object
    //   84	10	11	str	String
    // Exception table:
    //   from	to	target	type
    //   21	55	356	java/lang/Exception
    //   65	101	356	java/lang/Exception
    //   101	122	356	java/lang/Exception
    //   139	146	356	java/lang/Exception
    //   146	156	356	java/lang/Exception
    //   160	165	356	java/lang/Exception
    //   165	175	356	java/lang/Exception
    //   180	257	356	java/lang/Exception
    //   269	274	356	java/lang/Exception
    //   286	350	356	java/lang/Exception
    //   2	8	367	finally
    //   21	55	367	finally
    //   65	101	367	finally
    //   101	122	367	finally
    //   139	146	367	finally
    //   146	156	367	finally
    //   160	165	367	finally
    //   165	175	367	finally
    //   180	257	367	finally
    //   269	274	367	finally
    //   286	350	367	finally
    //   357	361	367	finally
  }
  
  public class KeyboardHiddenObserver
    implements SoftKeyboardStateHelper.SoftKeyboardStateListener
  {
    public KeyboardHiddenObserver() {}
    
    public void onSoftKeyboardClosed()
    {
      WebInputHandler.access$002(WebInputHandler.this, false);
      QMLog.i("WebInputHandler", "onSoftKeyboardClosed");
      InputMethodManager localInputMethodManager = (InputMethodManager)WebInputHandler.this.mNativeContainer.getContext().getSystemService("input_method");
      if (localInputMethodManager == null) {
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(WebInputHandler.this.mNativeContainer.getWindowToken(), 0);
      WebInputHandler.this.hideCurrentInput(true);
    }
    
    public void onSoftKeyboardOpened(int paramInt)
    {
      boolean bool2 = true;
      for (;;)
      {
        try
        {
          WebInputHandler.access$002(WebInputHandler.this, true);
          QMLog.i("WebInputHandler", "onSoftKeyboardOpened");
          WebInputHandler.access$102(WebInputHandler.this, paramInt);
          if ((WebInputHandler.this.mNativeContainer != null) && (WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null))
          {
            Object localObject1 = WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getAttachActivity();
            boolean bool1;
            if (localObject1 != null)
            {
              if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                continue;
              }
              bool1 = DisplayUtil.checkNavigationBarShow((Context)localObject1);
              QMLog.d("WebInputHandler", " hasNavBar : " + bool1 + "; " + Build.BRAND);
              if (bool1) {
                WebInputHandler.access$102(WebInputHandler.this, WebInputHandler.this.showKeyboardHeight + DisplayUtil.getNavigationBarHeight(WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getAttachActivity()));
              }
            }
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("inputId", WebInputHandler.this.inputId);
            ((JSONObject)localObject1).put("height", (int)(paramInt / DisplayUtil.getDensity(WebInputHandler.this.mNativeContainer.getContext())));
            if ((WebInputHandler.this.mNativeContainer != null) && (WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null))
            {
              WebInputHandler.this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardShow", ((JSONObject)localObject1).toString());
              return;
              if (DisplayUtil.hasNavBar((Context)localObject1))
              {
                bool1 = bool2;
                if (DisplayUtil.isNavigationBarExist((Activity)localObject1)) {
                  continue;
                }
              }
              boolean bool3 = DisplayUtil.isFlymeOS7NavBarShow();
              bool1 = bool2;
              if (bool3) {
                continue;
              }
              bool1 = false;
              continue;
            }
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        Object localObject2 = null;
      }
    }
  }
  
  class MyOnEditorActionListener
    implements TextView.OnEditorActionListener
  {
    private final NativeViewRequestEvent req;
    private final WebEditText webEditText;
    
    public MyOnEditorActionListener(WebEditText paramWebEditText, NativeViewRequestEvent paramNativeViewRequestEvent)
    {
      this.webEditText = paramWebEditText;
      this.req = paramNativeViewRequestEvent;
    }
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      boolean bool2 = true;
      boolean bool1;
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        return bool1;
        try
        {
          paramTextView = new JSONObject();
          paramTextView.put("inputId", WebInputHandler.this.inputId);
          paramTextView.put("value", this.webEditText.getText().toString());
          this.req.jsService.evaluateSubscribeJS("onKeyboardConfirm", paramTextView.toString(), 0);
          if (!this.webEditText.isConfirmHold()) {
            WebInputHandler.this.hideCurrentInput(true);
          }
          bool1 = bool2;
          if (WebInputHandler.this.mNativeContainer == null) {
            continue;
          }
          bool1 = bool2;
          if (WebInputHandler.this.mNativeContainer.getPageWebviewContainer() == null) {
            continue;
          }
          WebInputHandler.this.AnimatorTranslateY(new float[] { WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0F });
          return true;
        }
        catch (JSONException paramTextView)
        {
          for (;;)
          {
            paramTextView.printStackTrace();
          }
        }
      }
    }
  }
  
  class MyOnGlobalLayoutListener
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private final WebEditText webEditText;
    
    public MyOnGlobalLayoutListener(WebEditText paramWebEditText)
    {
      this.webEditText = paramWebEditText;
    }
    
    public void onGlobalLayout()
    {
      if ((this.webEditText.isFocused()) && (WebInputHandler.this.isKeyboardShow))
      {
        arrayOfInt = new int[2];
        this.webEditText.getLocationOnScreen(arrayOfInt);
        i = arrayOfInt[1];
        i = DisplayUtil.getRealHeight(this.webEditText.getContext()) - (i + this.webEditText.getHeight()) - this.webEditText.getMarginBottom();
        if ((WebInputHandler.this.showKeyboardHeight > i) && (this.webEditText.isAdjustPosition()) && (WebInputHandler.this.isKeyboardShow) && (WebInputHandler.this.mNativeContainer != null) && (WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null)) {
          WebInputHandler.this.AnimatorTranslateY(new float[] { 0.0F, -(WebInputHandler.this.showKeyboardHeight - i) });
        }
      }
      while ((WebInputHandler.this.isKeyboardShow) || (WebInputHandler.this.mNativeContainer == null) || (WebInputHandler.this.mNativeContainer.getPageWebviewContainer() == null))
      {
        int[] arrayOfInt;
        int i;
        return;
      }
      WebInputHandler.this.AnimatorTranslateY(new float[] { WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0F });
    }
  }
  
  static class MyOnWebviewScrollListener
    implements PageWebview.OnWebviewScrollListener
  {
    private final PageWebview pageWebview;
    
    public MyOnWebviewScrollListener(PageWebview paramPageWebview)
    {
      this.pageWebview = paramPageWebview;
    }
    
    public void onVerticalScroll(int paramInt)
    {
      this.pageWebview.scrollY = paramInt;
    }
  }
  
  class MyTextWatcher
    implements TextWatcher
  {
    private final NativeViewRequestEvent req;
    
    public MyTextWatcher(NativeViewRequestEvent paramNativeViewRequestEvent)
    {
      this.req = paramNativeViewRequestEvent;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((WebInputHandler.this.mSetValue.containsKey(Integer.valueOf(WebInputHandler.this.inputId))) && (paramCharSequence.toString().equals(WebInputHandler.this.mSetValue.get(Integer.valueOf(WebInputHandler.this.inputId))))) {
        return;
      }
      WebInputHandler.this.mSetValue.remove(Integer.valueOf(WebInputHandler.this.inputId));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("inputId", WebInputHandler.this.inputId);
        if (paramInt3 == 0)
        {
          localJSONObject.put("cursor", paramInt1);
          localJSONObject.put("value", paramCharSequence.toString());
          if ((paramInt2 == 0) || (paramInt3 != 0)) {
            break label241;
          }
          localJSONObject.put("keyCode", 8);
          label154:
          localJSONObject.put("data", new JSONObject(this.req.jsonParams).optString("data"));
          this.req.sendSubscribeJs("onKeyboardValueChange", localJSONObject.toString(), WebInputHandler.this.mNativeContainer.getWebviewId());
          return;
        }
      }
      catch (Exception paramCharSequence)
      {
        QMLog.e("WebInputHandler", "onTextChanged error", paramCharSequence);
        return;
      }
      if (paramInt2 != 0) {
        paramInt2 -= 1;
      }
      for (;;)
      {
        localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
        break;
        label241:
        localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
        break label154;
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */