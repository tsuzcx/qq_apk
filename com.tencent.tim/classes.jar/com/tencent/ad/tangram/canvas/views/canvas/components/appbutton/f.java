package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

public class f
  extends TextView
{
  private static final String TAG = "AdCanvasAppBtnUIAdapter";
  private int baseline;
  private int borderCornerRadius;
  private Path borderPath = new Path();
  private int borderWidth;
  private Rect bounds = new Rect();
  private int fontColor;
  private boolean isProgressing = false;
  protected Paint mBluePaint;
  protected int mMaxProgress = 100;
  protected volatile float mProgress = 0.0F;
  protected float mUnitlength;
  protected Paint mWhitePaint;
  private int progressBgColor;
  private Path progressPath = new Path();
  private RectF rectf = new RectF();
  private String textContent = " ";
  private int textSize;
  private int width;
  private int xCoordinateText;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public f(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void drawBackground(Integer paramInteger)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(this.borderCornerRadius);
    localGradientDrawable.setColor(paramInteger.intValue());
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(localGradientDrawable);
      return;
    }
    setBackgroundDrawable(localGradientDrawable);
  }
  
  public float getProgress()
  {
    return this.mProgress;
  }
  
  @TargetApi(16)
  void init(Context paramContext, c paramc)
  {
    if ((paramc == null) || (!paramc.isValid()))
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "init error");
      return;
    }
    try
    {
      this.textContent = paramc.button.text.text;
      this.textSize = paramc.button.text.size;
      this.progressBgColor = paramc.button.backgroundColor;
      this.fontColor = paramc.button.text.color;
      this.width = paramc.width;
      this.borderCornerRadius = AdUIUtils.dp2px(paramc.button.borderCornerRadius, paramContext.getResources());
      this.borderWidth = paramc.button.borderWidth;
      int i = paramc.height;
      setSingleLine(false);
      setLines(1);
      setGravity(17);
      setEllipsize(TextUtils.TruncateAt.END);
      int j = AdUIUtils.dp2px(5.0F, paramContext.getResources());
      setPadding(j, 0, j, 0);
      if (!TextUtils.isEmpty(this.textContent)) {
        setText(this.textContent);
      }
      if (this.textSize > 0) {
        setTextSize(0, this.textSize);
      }
      resetUI();
      this.mWhitePaint = new Paint();
      this.mWhitePaint.setTextSize(this.textSize);
      this.mWhitePaint.setStrokeWidth(2.0F);
      this.mWhitePaint.setColor(this.fontColor);
      this.mWhitePaint.setTextAlign(Paint.Align.LEFT);
      this.mWhitePaint.setStyle(Paint.Style.FILL);
      this.mWhitePaint.setAntiAlias(true);
      this.mBluePaint = new Paint();
      this.mBluePaint.setStrokeWidth(2.0F);
      this.mBluePaint.setColor(this.progressBgColor);
      this.mBluePaint.setTextSize(this.textSize);
      this.mBluePaint.setTextAlign(Paint.Align.LEFT);
      this.mBluePaint.setStyle(Paint.Style.FILL);
      this.mBluePaint.setAntiAlias(true);
      paramContext = this.mBluePaint.getFontMetricsInt();
      this.baseline = ((i - paramContext.bottom + paramContext.top) / 2 - paramContext.top);
      return;
    }
    catch (Exception paramContext)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "init error:", paramContext);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.isProgressing)
    {
      if (this.mUnitlength == 0.0F) {
        this.mUnitlength = (getWidth() / this.mMaxProgress);
      }
      paramCanvas.drawColor(0);
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      if (this.borderWidth >= 0)
      {
        this.rectf.set(0.0F, 0.0F, getWidth(), getHeight());
        this.borderPath.reset();
        this.borderPath.addRoundRect(this.rectf, this.borderCornerRadius, this.borderCornerRadius, Path.Direction.CW);
        paramCanvas.drawPath(this.borderPath, this.mWhitePaint);
        this.rectf.set(this.borderWidth, this.borderWidth, getWidth() - this.borderWidth, getHeight() - this.borderWidth);
        this.mBluePaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawRoundRect(this.rectf, this.borderCornerRadius, this.borderCornerRadius, this.mBluePaint);
      }
      this.progressPath.reset();
      this.rectf.set(0.0F, 0.0F, this.mUnitlength * this.mProgress, getHeight());
      this.progressPath.addRect(this.rectf, Path.Direction.CW);
      if (Build.VERSION.SDK_INT < 19) {
        break label344;
      }
      this.progressPath.op(this.borderPath, Path.Op.INTERSECT);
      this.mBluePaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.progressPath, this.mBluePaint);
    }
    for (;;)
    {
      paramCanvas.drawText(this.textContent, this.xCoordinateText, this.baseline, this.mBluePaint);
      paramCanvas.save();
      paramCanvas.clipRect(this.rectf);
      paramCanvas.drawText(this.textContent, this.xCoordinateText, this.baseline, this.mWhitePaint);
      paramCanvas.restore();
      super.onDraw(paramCanvas);
      return;
      label344:
      paramCanvas.clipPath(this.borderPath);
      this.mBluePaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.rectf, this.mBluePaint);
    }
  }
  
  public void resetUI()
  {
    this.isProgressing = false;
    setTextColor(this.fontColor);
    drawBackground(Integer.valueOf(this.progressBgColor));
  }
  
  public void setDownloadingUI(String paramString)
  {
    this.isProgressing = true;
    setText("");
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.textContent = paramString;
      drawBackground(Integer.valueOf(this.fontColor));
      this.mBluePaint.getTextBounds(paramString, 0, paramString.length(), this.bounds);
      this.xCoordinateText = (this.width / 2 - this.bounds.width() / 2);
      if (this.xCoordinateText < 0) {
        this.xCoordinateText = 0;
      }
      float f = this.bounds.width();
      if ((this.width > 0) && (f > this.width))
      {
        int i = this.mBluePaint.breakText(paramString, 0, paramString.length(), true, this.width, null);
        if (i >= 3)
        {
          this.textContent = (paramString.substring(0, i - 3) + "...");
          this.mBluePaint.getTextBounds(this.textContent, 0, this.textContent.length(), this.bounds);
          this.xCoordinateText = (this.width / 2 - this.bounds.width() / 2);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "setDownloadingUI error", paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.f
 * JD-Core Version:    0.7.0.1
 */