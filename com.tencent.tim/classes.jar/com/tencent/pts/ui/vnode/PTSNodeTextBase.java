package com.tencent.pts.ui.vnode;

import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;

public abstract class PTSNodeTextBase<T extends TextView>
  extends PTSNodeVirtual<T>
{
  private static final String STYLE_ITALIC = "italic";
  private static final String TAG = "PTSNodeTextBase";
  private static final String WEIGHT_BOLD = "bold";
  private static final String WEIGHT_LIGHTER = "lighter";
  private static final String WEIGHT_NORMAL = "normal";
  
  public PTSNodeTextBase(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public static float getHeightOffset(float paramFloat, int paramInt)
  {
    return PTSDeviceUtil.getTextHeightOffsetPerLine() * paramInt * paramFloat;
  }
  
  public static float getLineSpacing(float paramFloat1, float paramFloat2)
  {
    float f = 1.0F * paramFloat2 / 12.0F;
    if (PTSLog.isDebug()) {
      PTSLog.i("PTSNodeTextBase", "[getLineSpacing], lineHeight = " + paramFloat1 + ", fontSize = " + paramFloat2);
    }
    return paramFloat1 - paramFloat2 - f;
  }
  
  public void bindExtra(PTSNodeInfo paramPTSNodeInfo)
  {
    super.bindExtra(paramPTSNodeInfo);
    TextView localTextView = (TextView)getView();
    if (TextUtils.isEmpty(paramPTSNodeInfo.getContent())) {}
    for (paramPTSNodeInfo = "";; paramPTSNodeInfo = paramPTSNodeInfo.getContent().trim())
    {
      localTextView.setText(paramPTSNodeInfo);
      return;
    }
  }
  
  public void resetAll()
  {
    super.resetAll();
    TextView localTextView = (TextView)getView();
    localTextView.setText("");
    localTextView.setTextSize(16.0F);
    localTextView.setTypeface(null, 0);
    localTextView.setMaxLines(2147483647);
    localTextView.setLineSpacing(PTSValueConvertUtil.dp2px(3.2F), 1.0F);
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    if (super.setStyle(paramString, paramObject)) {}
    do
    {
      return true;
      if ("font-size".equalsIgnoreCase(paramString))
      {
        ((TextView)getView()).setTextSize(0, PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getFontSize()));
        return true;
      }
      if ("color".equalsIgnoreCase(paramString))
      {
        ((TextView)getView()).setTextColor(PTSValueConvertUtil.getColor(paramObject));
        return true;
      }
      if (!"font-style".equalsIgnoreCase(paramString)) {
        break;
      }
    } while (!"italic".equals(PTSValueConvertUtil.getString(paramObject)));
    ((TextView)getView()).setTypeface(null, 2);
    return true;
    if ("font-weight".equalsIgnoreCase(paramString))
    {
      paramString = PTSValueConvertUtil.getString(paramObject);
      paramObject = ((TextView)getView()).getPaint();
      paramObject.setStyle(Paint.Style.FILL_AND_STROKE);
      if ("bold".equalsIgnoreCase(paramString))
      {
        paramObject.setStrokeWidth(1.5F);
        return true;
      }
      if (("lighter".equalsIgnoreCase(paramString)) || ("normal".equalsIgnoreCase(paramString)))
      {
        paramObject.setStrokeWidth(0.0F);
        return true;
      }
      paramObject.setStrokeWidth(0.0F);
      return true;
    }
    int i;
    if ("-webkit-line-clamp".equalsIgnoreCase(paramString))
    {
      i = PTSValueConvertUtil.getInt(paramObject);
      if (i > 0) {
        break label276;
      }
      i = 1;
    }
    label276:
    for (;;)
    {
      ((TextView)getView()).setMaxLines(i);
      ((TextView)getView()).setEllipsize(TextUtils.TruncateAt.END);
      return true;
      if ("line-height".equalsIgnoreCase(paramString))
      {
        float f = PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getLineSpacing());
        ((TextView)getView()).setLineSpacing(f, 1.0F);
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeTextBase
 * JD-Core Version:    0.7.0.1
 */