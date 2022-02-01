package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.MotionEvent;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectText;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.view.VTextView;
import com.tencent.viola.utils.ViolaUtils;

public class VText
  extends VComponent<VTextView>
{
  public static final String RICH_TEXT_DETECT_ENABLE = "detectRichText";
  @VComponentField(nativeReturnMethod="getVisibility", propertyName="visibility")
  private String mVisibility;
  
  public VText(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void tryDetectRichTextClick(String paramString, MotionEvent paramMotionEvent)
  {
    if ((this.mDomObj.getAttributes().containsKey("detectRichText")) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("detectRichText")))) {}
    do
    {
      do
      {
        return;
      } while ((!(this.mDomObj instanceof DomObjectText)) || (!((DomObjectText)this.mDomObj).isRichText()) || (!"click".equals(paramString)));
      paramString = (VTextView)getHostView();
    } while (paramString == null);
    paramString.onTouchEvent(paramMotionEvent);
  }
  
  public void fireClickAction(String paramString, MotionEvent paramMotionEvent)
  {
    tryDetectRichTextClick(paramString, paramMotionEvent);
    super.fireClickAction(paramString, paramMotionEvent);
  }
  
  public VTextView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VTextView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public void resetComponent()
  {
    if ((getHostView() != null) && (((VTextView)getHostView()).mIsRich)) {
      ((VTextView)getHostView()).setText("");
    }
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
        if (paramString.equals("value"))
        {
          i = 0;
          continue;
          if (paramString.equals("values")) {
            i = 1;
          }
        }
        break;
      }
    }
    if (this.mHost != null) {
      ((VTextView)this.mHost).setText("");
    }
    return true;
  }
  
  public void updateExtra(Object paramObject)
  {
    if ((paramObject instanceof Layout))
    {
      Layout localLayout = (Layout)paramObject;
      if ((getHostView() != null) && (!paramObject.equals(((VTextView)getHostView()).getTextLayout())))
      {
        ((VTextView)getHostView()).setRichText(((DomObjectText)this.mDomObj).isRichText(), ((DomObjectText)this.mDomObj).getLineSpace());
        paramObject = this.mDomObj.getPadding();
        ((VTextView)getHostView()).setTextLayout(localLayout, paramObject.get(0), paramObject.get(1));
        ((VTextView)getHostView()).invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VText
 * JD-Core Version:    0.7.0.1
 */