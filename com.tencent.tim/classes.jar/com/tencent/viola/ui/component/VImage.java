package com.tencent.viola.ui.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.ui.view.VImageView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class VImage
  extends VComponent<VImageView>
{
  public static String AUTOSIZE_HEIGHT = "height";
  public static String AUTOSIZE_NONE = "none";
  public static String AUTOSIZE_WIDTH = "width";
  private String autoSize = "none";
  public int imgReadHeight;
  public int imgRealWidth;
  private boolean mAutoRecycle = true;
  private boolean mDoAlphaAnim = true;
  private Handler mHandler;
  private Runnable mHolderRunnable;
  private AtomicBoolean mIsSetSrc;
  private long mLoadImageUrlEndTime;
  private long mLoadImageUrlStartTime;
  private boolean mNeedDoAlpha = false;
  private int mPlaceHolderCounter = 0;
  private String mPlaceHolderUrl = "";
  private Runnable mRunnable;
  private String mSrc;
  private int mSrcCounter = 0;
  private String mUrl = "";
  
  public VImage(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    initHandler();
  }
  
  public VImage(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
    initHandler();
  }
  
  private ImageView.ScaleType getResizeMode(String paramString)
  {
    ImageView.ScaleType localScaleType = ImageView.ScaleType.FIT_XY;
    if (TextUtils.isEmpty(paramString)) {
      return localScaleType;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return localScaleType;
      case 0: 
        return ImageView.ScaleType.CENTER_CROP;
        if (paramString.equals("cover"))
        {
          i = 0;
          continue;
          if (paramString.equals("contain"))
          {
            i = 1;
            continue;
            if (paramString.equals("stretch")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return ImageView.ScaleType.FIT_CENTER;
    return ImageView.ScaleType.FIT_XY;
  }
  
  private void initHandler()
  {
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mRunnable = new VImage.1(this);
    this.mHolderRunnable = new VImage.2(this);
    this.mIsSetSrc = new AtomicBoolean(false);
  }
  
  private void setImgAutoSize()
  {
    if (!getDomObject().getAttributes().containsKey("autosize")) {}
    for (;;)
    {
      return;
      if ((getDomObject().getStyle().containsKey("width")) && (getDomObject().getStyle().containsKey("height"))) {
        continue;
      }
      try
      {
        Object localObject1 = new JSONObject();
        this.autoSize = getDomObject().getAttributes().get("autosize").toString();
        if ((AUTOSIZE_NONE.equals(this.autoSize)) || (this.imgRealWidth <= 0)) {
          continue;
        }
        ViolaLogUtils.d("VComponent", "setImgAutoSize :" + this.autoSize);
        int k = (int)getDomObject().getLayoutWidth();
        int i = (int)getDomObject().getLayoutHeight();
        JSONObject localJSONObject = new JSONObject();
        int j;
        if (AUTOSIZE_WIDTH.equals(this.autoSize))
        {
          j = (int)getDomObject().flexStyle.maxHeight;
          if (Float.isNaN(j)) {
            break label770;
          }
          if (this.imgReadHeight <= j) {
            break label620;
          }
          this.imgRealWidth = ((int)(j / this.imgReadHeight * this.imgRealWidth));
          this.imgReadHeight = j;
          if (i != 0) {
            break label770;
          }
          i = j;
        }
        label770:
        for (;;)
        {
          label219:
          j = (int)(i / this.imgReadHeight * this.imgRealWidth);
          int m = (int)FlexConvertUtils.px2dip(j);
          localJSONObject.put("width", m + "dp");
          localJSONObject.put("height", (int)FlexConvertUtils.px2dip(i) + "dp");
          if ((j == getDomObject().getLayoutWidth()) && (i == getDomObject().getLayoutHeight())) {
            break;
          }
          if (AUTOSIZE_HEIGHT.equals(this.autoSize))
          {
            m = (int)getDomObject().flexStyle.maxWidth;
            i = k;
            if (!Float.isNaN(m))
            {
              if (this.imgRealWidth <= m) {
                break label632;
              }
              this.imgReadHeight = ((int)(m / this.imgRealWidth * this.imgReadHeight));
              this.imgRealWidth = m;
              i = k;
              if (k == 0) {
                i = m;
              }
            }
          }
          for (;;)
          {
            j = (int)(i / this.imgRealWidth * this.imgReadHeight);
            k = (int)FlexConvertUtils.px2dip(j);
            localJSONObject.put("width", (int)FlexConvertUtils.px2dip(i) + "dp");
            localJSONObject.put("height", k + "dp");
            if ((j == getDomObject().getLayoutHeight()) && (i == getDomObject().getLayoutWidth())) {
              break;
            }
            ((JSONObject)localObject1).put("style", localJSONObject);
            localObject1 = new MethodUpdateElement(getRef(), (JSONObject)localObject1);
            if ((localObject1 instanceof DOMAction)) {
              ViolaSDKManager.getInstance().getDomManager().postAction(getInstance().getInstanceId(), (DOMAction)localObject1, false);
            }
            ViolaLogUtils.d("VComponent", " for image width :" + this.imgRealWidth + ",height:" + this.imgReadHeight);
            return;
            label620:
            if (i != 0) {
              break label770;
            }
            i = this.imgReadHeight;
            break label219;
            label632:
            j = k;
            if (k == 0) {
              j = this.imgRealWidth;
            }
            i = j;
            if (getDomObject().getAttributes().containsKey("autoScaleWidth"))
            {
              Object localObject2 = getDomObject().getAttributes().get("autoScaleWidth");
              i = j;
              if (localObject2 != null)
              {
                boolean bool = TextUtils.isEmpty(localObject2.toString());
                i = j;
                if (!bool)
                {
                  i = j;
                  try
                  {
                    if (j >= Integer.parseInt(localObject2.toString())) {
                      i = Math.min((int)getDomObject().getParent().getLayoutWidth(), m);
                    }
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    ViolaLogUtils.e("VComponent", "AUTO_SCALE_WIDTH NumberFormatException" + localNumberFormatException.getMessage());
                    i = j;
                  }
                }
              }
            }
          }
        }
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  private boolean shouldSetSrc()
  {
    if (!isMounted()) {
      return false;
    }
    if ((getDomObject().getLayoutWidth() == 0.0F) || (getDomObject().getLayoutHeight() == 0.0F)) {
      return false;
    }
    if (getDomObject().getStyle().containsKey("borderRadius"))
    {
      if (getHostView() == null) {
        return false;
      }
      if ((((VImageView)getHostView()).getWidth() == 0) && (((VImageView)getHostView()).getHeight() == 0)) {
        return false;
      }
    }
    return true;
  }
  
  public void autoRecoverImage()
  {
    if (this.mAutoRecycle)
    {
      if (this.mIsSetSrc.get()) {
        setImageSrc(this.mSrc, true);
      }
    }
    else {
      return;
    }
    setRemoteSrc(this.mPlaceHolderUrl, false, false);
  }
  
  public void autoReleaseImage()
  {
    if ((this.mAutoRecycle) && (getHostView() != null))
    {
      VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
      if (localVComponentAdapter != null) {
        localVComponentAdapter.setImage(null, (VImageView)this.mHost, null, null, false);
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mHandler.removeCallbacks(this.mHolderRunnable);
  }
  
  protected VImageView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VImageView(paramContext);
    paramContext.bindComponent(this);
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setCropToPadding(true);
    }
    return paramContext;
  }
  
  public void initView() {}
  
  public boolean isNeedDoAlpha()
  {
    this.mLoadImageUrlEndTime = System.currentTimeMillis();
    if ((this.mLoadImageUrlStartTime != 0L) && (this.mLoadImageUrlEndTime - this.mLoadImageUrlStartTime > 250L))
    {
      this.mLoadImageUrlStartTime = 0L;
      this.mNeedDoAlpha = true;
    }
    return (this.mDoAlphaAnim) && (this.mNeedDoAlpha);
  }
  
  public boolean isVGif()
  {
    return false;
  }
  
  public void recycled()
  {
    super.recycled();
  }
  
  public void resetAlphaAnimState()
  {
    this.mNeedDoAlpha = false;
  }
  
  public boolean resetAttr(String paramString)
  {
    if ((!super.resetAttr(paramString)) && (paramString.equals("resize")))
    {
      setResize("cover");
      return true;
    }
    return false;
  }
  
  public void resetComponent()
  {
    if ((this.mDoAlphaAnim) && (this.mNeedDoAlpha))
    {
      ((VImageView)getHostView()).setAlpha(1.0F);
      if (((VImageView)getHostView()).getDrawable() != null) {
        ((VImageView)getHostView()).getDrawable().setAlpha(255);
      }
    }
    this.mAutoRecycle = true;
    this.mIsSetSrc.set(false);
    this.mNeedDoAlpha = false;
    this.mDoAlphaAnim = true;
    this.mLoadImageUrlEndTime = 0L;
    this.mLoadImageUrlStartTime = 0L;
    this.mSrc = null;
    this.mUrl = null;
    this.mPlaceHolderUrl = null;
    this.mPlaceHolderCounter = 0;
    this.mSrcCounter = 0;
    ((VImageView)getHostView()).reset();
  }
  
  public boolean resetStyle(String paramString)
  {
    int i;
    if (!super.resetStyle(paramString))
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("blur"))
        {
          i = 0;
          continue;
          if (paramString.equals("blurRadius")) {
            i = 1;
          }
        }
        break;
      }
    }
    if (this.mHost != null) {
      ((VImageView)this.mHost).setBlurRadius(0);
    }
    return true;
  }
  
  @VComponentProp(name="alphaAnim")
  public void setAlphaAnim(boolean paramBoolean)
  {
    this.mDoAlphaAnim = paramBoolean;
  }
  
  @VComponentProp(name="alphaAnimDuration")
  public void setAlphaAnimDuration(int paramInt)
  {
    if (getHostView() != null) {
      ((VImageView)getHostView()).setAlphaAnimDuration(paramInt);
    }
  }
  
  public void setBoderBottomLeftRadius(float paramFloat)
  {
    super.setBoderBottomLeftRadius(paramFloat);
    ((VImageView)getHostView()).setBottomLeftBorderRadius(paramFloat);
  }
  
  public void setBoderBottomRightRadius(float paramFloat)
  {
    super.setBoderBottomRightRadius(paramFloat);
    ((VImageView)getHostView()).setBottomRightBorderRadius(paramFloat);
  }
  
  public void setBoderTopLeftRadius(float paramFloat)
  {
    super.setBoderTopLeftRadius(paramFloat);
    ((VImageView)getHostView()).setTopLeftBorderRadius(paramFloat);
  }
  
  public void setBoderTopRightRadius(float paramFloat)
  {
    super.setBoderTopRightRadius(paramFloat);
    ((VImageView)getHostView()).setTopRightBorderRadius(paramFloat);
  }
  
  public void setBorderRadius(int paramInt, float paramFloat)
  {
    super.setBorderRadius(paramInt, paramFloat);
    ((VImageView)getHostView()).setBorderRadius(paramFloat);
  }
  
  public void setBorderWidth(int paramInt, float paramFloat)
  {
    super.setBorderWidth(paramInt, paramFloat);
    ((VImageView)getHostView()).setBorderWidth(paramFloat);
  }
  
  public void setImageResize(String paramString)
  {
    ((VImageView)getHostView()).setScaleType(getResizeMode(paramString));
  }
  
  public void setImageSrc(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (getDomObject().getLayoutWidth() == 0.0F) || (getDomObject().getLayoutHeight() == 0.0F)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)getHostView();
      if (("".equals(paramString)) && (localImageView != null))
      {
        localImageView.setImageDrawable(null);
        return;
      }
      if (paramBoolean)
      {
        if ((localImageView != null) && (localImageView.getDrawable() != null)) {
          localImageView.setImageDrawable(null);
        }
        this.mSrc = paramString;
        this.mIsSetSrc.set(true);
        setRemoteSrc(this.mSrc, false, false);
        return;
      }
    } while (paramString.equals(this.mSrc));
    if ((localImageView != null) && (localImageView.getDrawable() != null)) {
      localImageView.setImageDrawable(null);
    }
    this.mSrc = paramString;
    this.mIsSetSrc.set(true);
    this.mLoadImageUrlStartTime = System.currentTimeMillis();
    setRemoteSrc(this.mSrc, true, false);
  }
  
  @VComponentProp(name="placeholder")
  public void setPlaceholder(String paramString)
  {
    if ((!this.mIsSetSrc.get()) && (!TextUtils.isEmpty(paramString)))
    {
      this.mPlaceHolderUrl = paramString;
      if (shouldSetSrc()) {
        setRemoteSrc(paramString, false, false);
      }
    }
    else
    {
      return;
    }
    this.mHandler.post(this.mHolderRunnable);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    String str = ViolaUtils.getString(paramObject, null);
    if (!TextUtils.isEmpty(str))
    {
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return super.setProperty(paramString, paramObject);
          if (paramString.equals("blur"))
          {
            i = 0;
            continue;
            if (paramString.equals("blurRadius")) {
              i = 1;
            }
          }
          break;
        }
      }
      i = (int)FlexConvertUtils.converPxByViewportToRealPx(str, 750);
      ((VImageView)getHostView()).setBlurRadius((int)(i * 2.3D));
      return true;
      i = (int)FlexConvertUtils.converPxByViewportToRealPx(str, 750);
      ((VImageView)getHostView()).setBlurRadius((int)(i * 2.3D));
      return true;
    }
    return super.setProperty(paramString, paramObject);
  }
  
  public void setRemoteSrc(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ImageAdapterHolder localImageAdapterHolder = new ImageAdapterHolder();
    Object localObject = this.autoSize;
    localImageAdapterHolder.setImageListener(new VImage.3(this, paramBoolean1));
    localObject = ViolaSDKManager.getInstance().getComponentAdapter();
    if (localObject != null)
    {
      ((VImageView)getHostView()).setUrl(this.mUrl);
      ((VComponentAdapter)localObject).setImage(paramString, (VImageView)getHostView(), localImageAdapterHolder, getInstance(), paramBoolean2);
    }
  }
  
  @VComponentProp(name="resize")
  public void setResize(String paramString)
  {
    if (paramString != null) {
      setImageResize(paramString);
    }
  }
  
  @VComponentProp(name="src")
  public void setSrc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mUrl = paramString;
      if (shouldSetSrc()) {
        setImageSrc(paramString, false);
      }
    }
    else
    {
      return;
    }
    this.mHandler.post(this.mRunnable);
  }
  
  public static abstract interface Measurable
  {
    public abstract int getNaturalHeight();
    
    public abstract int getNaturalWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VImage
 * JD-Core Version:    0.7.0.1
 */