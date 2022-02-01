package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import org.json.JSONObject;

public class ReadInJoyAdLocationView
  extends ViewBase
{
  private JSONObject ar;
  private LinearLayout dK;
  private TextView mLocationText;
  private int maxWidth = Utils.dp2px(233.0D);
  private TextView pV;
  
  public ReadInJoyAdLocationView(VafContext paramVafContext)
  {
    super(paramVafContext);
    e(paramVafContext);
  }
  
  private void a(String paramString, TextView paramTextView, int paramInt)
  {
    paramTextView.setTextSize(0, s(paramString, paramInt));
    refreshUI();
  }
  
  private void b(String paramString, TextView paramTextView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.ar.optString(paramString)))
    {
      paramTextView.setTextColor(Utils.parseColor(this.ar.optString(paramString)));
      return;
    }
    paramTextView.setTextColor(paramInt);
  }
  
  private void bindData()
  {
    b("setLocationTextColorString:", this.mLocationText, Color.parseColor("#4D7CAF"));
    a("setLocationTextSizeString:", this.mLocationText, 12);
    b("setDistanceTextColorString:", this.pV, Color.parseColor("#737373"));
    a("setDistanceTextSizeString:", this.pV, 12);
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(this.ar.optString("setMidMarginString:")))
    {
      i = Utils.dp2px(3.0D);
      localObject = Utils.toInteger(this.ar.optString("setMidMarginString:"));
      if (localObject == null) {
        break label186;
      }
      i = Utils.dp2px(((Integer)localObject).intValue());
    }
    label186:
    for (;;)
    {
      localObject = (LinearLayout.LayoutParams)this.mLocationText.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      this.mLocationText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = s("setTopPaddingString:", 6);
      int j = s("setBottomPaddingString:", 6);
      int k = s("setLeftPaddingString:", 7);
      int m = s("setRightPaddingString:", 7);
      this.dK.setPadding(k, i, m, j);
      refreshUI();
      return;
    }
  }
  
  private void e(VafContext paramVafContext)
  {
    BoringViewImpl localBoringViewImpl = new BoringViewImpl(paramVafContext.getContext());
    localBoringViewImpl.setBorderBottomLeftRadius(10);
    localBoringViewImpl.setBorderBottomRightRadius(10);
    localBoringViewImpl.setBorderTopLeftRadius(10);
    localBoringViewImpl.setBorderTopRightRadius(10);
    this.dK = localBoringViewImpl;
    this.mLocationText = new TextView(paramVafContext.getContext());
    this.pV = new TextView(paramVafContext.getContext());
    this.mLocationText.setMaxLines(1);
    this.mLocationText.setEllipsize(TextUtils.TruncateAt.END);
    this.pV.setMaxLines(1);
    this.mLocationText.setIncludeFontPadding(false);
    this.pV.setIncludeFontPadding(false);
    this.dK.setOrientation(0);
    paramVafContext = new LinearLayout.LayoutParams(Utils.dp2px(20.0D), Utils.dp2px(20.0D));
    this.dK.setGravity(16);
    this.dK.setLayoutParams(paramVafContext);
    this.dK.addView(this.mLocationText);
    this.dK.addView(this.pV);
  }
  
  private int s(String paramString, int paramInt)
  {
    int i = Utils.dp2px(paramInt);
    paramInt = i;
    if (!TextUtils.isEmpty(this.ar.optString(paramString)))
    {
      paramString = Utils.toDouble(this.ar.optString(paramString));
      paramInt = i;
      if (paramString != null) {
        paramInt = Utils.dp2px(paramString.doubleValue());
      }
    }
    return paramInt;
  }
  
  public int getComMeasuredHeight()
  {
    return this.dK.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.dK.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.dK;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dK.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.dK.measure(paramInt1, paramInt2);
  }
  
  public void refreshUI()
  {
    float f1 = this.pV.getPaint().measureText(this.pV.getText().toString());
    int i = this.dK.getPaddingLeft();
    int j = this.dK.getPaddingRight();
    int k = ((LinearLayout.LayoutParams)this.mLocationText.getLayoutParams()).rightMargin;
    float f2 = this.maxWidth;
    float f3 = i;
    float f4 = j;
    float f5 = k;
    this.mLocationText.setMaxWidth((int)(f2 - f1 - f3 - f4 - f5));
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (!(paramObject instanceof JSONObject));
          this.ar = ((JSONObject)paramObject);
          bool1 = bool2;
        } while (this.ar == null);
        bindData();
        return true;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    paramObject = (JSONObject)paramObject;
    String str = paramObject.optString("ad_Location_content");
    if (!TextUtils.isEmpty(str))
    {
      this.mLocationText.setText(str);
      this.mLocationText.setVisibility(0);
    }
    for (;;)
    {
      paramObject = paramObject.optString("ad_Location");
      if (TextUtils.isEmpty(paramObject)) {
        break;
      }
      this.pV.setText(paramObject);
      this.pV.setVisibility(0);
      refreshUI();
      return true;
      this.mLocationText.setVisibility(8);
    }
    this.pV.setVisibility(8);
    return true;
  }
  
  static class BoringViewImpl
    extends LinearLayout
  {
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private int mBorderBottomLeftRadius;
    private int mBorderBottomRightRadius;
    private int mBorderColor = -16777216;
    private Paint mBorderPaint;
    private int mBorderTopLeftRadius;
    private int mBorderTopRightRadius;
    private int mBorderWidth;
    
    public BoringViewImpl(Context paramContext)
    {
      super();
      setWillNotDraw(false);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      if (this.mBackgroundColor != 0)
      {
        if (this.mBackgroundPaint == null)
        {
          this.mBackgroundPaint = new Paint();
          this.mBackgroundPaint.setAntiAlias(true);
        }
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        VirtualViewUtils.drawBackground(paramCanvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
      }
      super.onDraw(paramCanvas);
      if (this.mBorderWidth > 0)
      {
        if (this.mBorderPaint == null)
        {
          this.mBorderPaint = new Paint();
          this.mBorderPaint.setStyle(Paint.Style.STROKE);
          this.mBorderPaint.setAntiAlias(true);
        }
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setColor(this.mBorderColor);
        VirtualViewUtils.drawBorder(paramCanvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
      }
    }
    
    public void setBackgroundColor(int paramInt)
    {
      this.mBackgroundColor = paramInt;
    }
    
    public void setBorderBottomLeftRadius(int paramInt)
    {
      this.mBorderBottomLeftRadius = paramInt;
    }
    
    public void setBorderBottomRightRadius(int paramInt)
    {
      this.mBorderBottomRightRadius = paramInt;
    }
    
    public void setBorderTopLeftRadius(int paramInt)
    {
      this.mBorderTopLeftRadius = paramInt;
    }
    
    public void setBorderTopRightRadius(int paramInt)
    {
      this.mBorderTopRightRadius = paramInt;
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new ReadInJoyAdLocationView(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdLocationView
 * JD-Core Version:    0.7.0.1
 */