package com.tencent.qqmini.miniapp.core.page.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebEditText
  extends EditText
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final String TAG = "WebEditText";
  private boolean adjustPosition = false;
  private String backgroundColor = "#FFFFFFFF";
  private boolean confirmHold = false;
  private String fontWeight = "normal";
  private boolean hasMoveParent = false;
  private WebInputHandler mInputHandler;
  private int mInputId;
  private WeakReference<PageWebview> mPageWebviewRef;
  private int mWebInputHeight;
  private int mWebInputLeft;
  private int mWebInputTop;
  private int mWebInputWidth;
  private int marginBottom = 0;
  private String textAlign = "left";
  private String textColor = "#FFFFFFFF";
  
  public WebEditText(Context paramContext, WebInputHandler paramWebInputHandler)
  {
    super(paramContext);
    super.setBackgroundDrawable(null);
    super.setIncludeFontPadding(false);
    super.setSingleLine(true);
    super.setTextIsSelectable(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLineSpacing(0.0F, 1.0F);
    }
    super.setPadding(0, 0, 0, 0);
    this.mInputHandler = paramWebInputHandler;
  }
  
  @TargetApi(16)
  public void detach()
  {
    if (super.getParent() != null) {
      ((ViewGroup)super.getParent()).removeView(this);
    }
    super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.mPageWebviewRef.clear();
  }
  
  public int getInputHeight()
  {
    return this.mWebInputHeight;
  }
  
  public int getInputId()
  {
    return this.mInputId;
  }
  
  public int getMarginBottom()
  {
    return this.marginBottom;
  }
  
  public PageWebview getPageWebview()
  {
    if (this.mPageWebviewRef != null) {
      return (PageWebview)this.mPageWebviewRef.get();
    }
    return null;
  }
  
  public boolean hasMoveParent()
  {
    return this.hasMoveParent;
  }
  
  public boolean initWithWebParams(NativeViewContainer paramNativeViewContainer, String paramString)
    throws Exception
  {
    int j = 2;
    boolean bool1 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramNativeViewContainer == null))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject1 = super.getContext();
    paramNativeViewContainer = new JSONObject(paramString);
    paramString = paramNativeViewContainer.optString("type");
    boolean bool2 = paramNativeViewContainer.optBoolean("password");
    int i;
    if (("number".equals(paramString)) || ("digit".equals(paramString)) || ("idcard".equals(paramString))) {
      i = 2;
    }
    for (;;)
    {
      super.setInputType(i);
      Object localObject2 = paramNativeViewContainer.optString("confirmType");
      if ("send".equals(localObject2))
      {
        i = 4;
        label110:
        setImeOptions(i);
        i = paramNativeViewContainer.optInt("maxLength", -1);
        if (i != -1) {
          super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
        }
        localObject2 = paramNativeViewContainer.optJSONObject("style");
        if (localObject2 != null)
        {
          float f = DisplayUtil.getDensity((Context)localObject1);
          this.mWebInputWidth = ((int)(((JSONObject)localObject2).optInt("width") * f));
          this.mWebInputHeight = ((int)(((JSONObject)localObject2).optInt("height") * f));
          this.mWebInputLeft = ((int)(((JSONObject)localObject2).optInt("left") * f));
          this.mWebInputTop = ((int)(f * ((JSONObject)localObject2).optInt("top")));
          super.setTextSize(((JSONObject)localObject2).optInt("fontSize", 16));
          this.fontWeight = ((JSONObject)localObject2).optString("fontWeight", "normal");
          this.textColor = ((JSONObject)localObject2).optString("color", "#FFFFFFFF");
          this.backgroundColor = ((JSONObject)localObject2).optString("backgroundColor", "#FFFFFFFF");
          this.marginBottom = ((int)(DisplayUtil.getDensity(getContext()) * ((JSONObject)localObject2).optInt("marginBottom") + 0.5F));
          this.textAlign = ((JSONObject)localObject2).optString("textAlign", "left");
        }
        localObject1 = paramNativeViewContainer.optString("placeholder");
        localObject2 = paramNativeViewContainer.optJSONObject("placeholderStyle");
        if (localObject2 != null) {
          super.setHintTextColor(ColorUtils.parseColor(((JSONObject)localObject2).optString("color", "#FFFFFFFF")));
        }
        this.adjustPosition = paramNativeViewContainer.optBoolean("adjustPosition");
        this.confirmHold = paramNativeViewContainer.optBoolean("confirmHold", false);
        localObject2 = paramNativeViewContainer.optString("defaultValue");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label607;
        }
        super.setText((CharSequence)localObject2);
        label403:
        i = paramNativeViewContainer.optInt("selectionStart", -1);
        j = paramNativeViewContainer.optInt("selectionEnd", -1);
        if ((i != -1) && (j != -1) && (j > i)) {
          setSelection(i, j);
        }
        i = paramNativeViewContainer.optInt("cursor", -1);
        if (i > 0) {
          setSelection(i);
        }
        super.setTextColor(ColorUtils.parseColor(this.textColor));
        super.setBackgroundColor(ColorUtils.parseColor(this.backgroundColor));
        super.setHint((CharSequence)localObject1);
        if (!"left".equals(this.textAlign)) {
          break label617;
        }
        setGravity(19);
      }
      for (;;)
      {
        if (!"idcard".equals(paramString)) {
          break label661;
        }
        super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        return true;
        if (!bool2) {
          break label682;
        }
        i = 129;
        break;
        if ("search".equals(localObject2))
        {
          i = 3;
          break label110;
        }
        if ("next".equals(localObject2))
        {
          i = 5;
          break label110;
        }
        i = j;
        if ("go".equals(localObject2)) {
          break label110;
        }
        i = 6;
        break label110;
        label607:
        super.setText("");
        break label403;
        label617:
        if ("center".equals(this.textAlign)) {
          setGravity(17);
        } else if ("right".equals(this.textAlign)) {
          setGravity(21);
        }
      }
      label661:
      if (!"digit".equals(paramString)) {
        break;
      }
      super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
      return true;
      label682:
      i = 1;
    }
  }
  
  public boolean isAdjustPosition()
  {
    return this.adjustPosition;
  }
  
  public boolean isConfirmHold()
  {
    return this.confirmHold;
  }
  
  public FrameLayout.LayoutParams makeLayoutParams(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mWebInputWidth, this.mWebInputHeight);
    localLayoutParams.leftMargin = this.mWebInputLeft;
    localLayoutParams.topMargin = (this.mWebInputTop - paramInt);
    return localLayoutParams;
  }
  
  public void onGlobalLayout()
  {
    if ((this.mInputHandler != null) && (this.mInputHandler.isFocus(this.mInputId)))
    {
      super.requestFocus();
      QMLog.d("WebEditText", "showSoftInput for inputId=" + this.mInputId);
      InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this, 0);
      }
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (this.mInputHandler != null) && (this.mInputHandler.hasFocusInput()))
    {
      this.mInputHandler.hideCurrentInput(true);
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setHasMoveParent(boolean paramBoolean)
  {
    this.hasMoveParent = paramBoolean;
  }
  
  public void setInputHeight(int paramInt)
  {
    this.mWebInputHeight = paramInt;
  }
  
  public void setInputId(int paramInt)
  {
    this.mInputId = paramInt;
  }
  
  public void setPageWebview(PageWebview paramPageWebview)
  {
    this.mPageWebviewRef = new WeakReference(paramPageWebview);
  }
  
  @TargetApi(16)
  public void showSoftInput()
  {
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this, 0);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WebEditText{");
    localStringBuilder.append("mWebInputWidth=").append(this.mWebInputWidth);
    localStringBuilder.append(", mWebInputHeight=").append(this.mWebInputHeight);
    localStringBuilder.append(", mWebInputTop=").append(this.mWebInputTop);
    localStringBuilder.append(", mWebInputLeft=").append(this.mWebInputLeft);
    localStringBuilder.append(", mInputId=").append(this.mInputId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebEditText
 * JD-Core Version:    0.7.0.1
 */