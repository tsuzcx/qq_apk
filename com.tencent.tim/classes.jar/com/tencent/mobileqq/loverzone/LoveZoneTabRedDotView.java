package com.tencent.mobileqq.loverzone;

import aiwj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import aqnm;
import awij;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

public class LoveZoneTabRedDotView
  extends View
{
  public static final String bPO = QzoneConfig.getInstance().getConfig("sweet_miniapp", "love_zone_red_dot_frame_ani", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip");
  private String bPN = "";
  private Rect cf;
  private final int dfu = 11;
  private Drawable.Callback e = new aiwj(this);
  private awij l;
  private float mBaseLine;
  public boolean mIsShow;
  private Paint mPaint;
  
  public LoveZoneTabRedDotView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoveZoneTabRedDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.buffer.has()))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      try
      {
        Object localObject = new JSONObject(paramAppInfo);
        paramAppInfo = ((JSONObject)localObject).optJSONObject("param");
        localObject = ((JSONObject)localObject).optString("_show_mission");
        if ((paramAppInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramAppInfo = (JSONObject)paramAppInfo.opt((String)localObject);
          if (paramAppInfo != null)
          {
            this.bPN = paramAppInfo.optString((String)localObject);
            boolean bool = TextUtils.isEmpty(this.bPN);
            if (!bool) {
              return true;
            }
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        QLog.e("LoveZoneTabRedDotView", 1, "buffer handle exception:" + paramAppInfo);
        paramAppInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public void hide()
  {
    if ((this.mIsShow) || (getVisibility() == 0))
    {
      this.mIsShow = false;
      setVisibility(8);
      if (this.l != null)
      {
        this.l.stop();
        this.l.release();
        this.l = null;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!this.mIsShow) || (this.cf == null) || (this.mPaint == null) || (TextUtils.isEmpty(this.bPN))) {
      return;
    }
    paramCanvas.save();
    Drawable localDrawable = getResources().getDrawable(2130846950);
    localDrawable.getBounds();
    localDrawable.setBounds(this.cf.left, this.cf.top, this.cf.right, this.cf.bottom);
    localDrawable.draw(paramCanvas);
    this.mPaint.setColor(-1);
    paramCanvas.drawText(this.bPN, this.cf.left + aqnm.dpToPx(25.0F), this.mBaseLine, this.mPaint);
    if (this.l == null)
    {
      this.l = new awij();
      this.l.hb(bPO, 18);
      this.l.Xb(false);
      this.l.Xc(true);
      this.l.eDH();
      this.l.setCallback(this.e);
      this.l.start();
    }
    this.l.setBounds(this.cf.left, this.cf.top - aqnm.dpToPx(2.0F) * 3, this.cf.left + aqnm.dpToPx(25.0F), this.cf.top + aqnm.dpToPx(25.0F) - aqnm.dpToPx(2.0F) * 3);
    this.l.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (TextUtils.isEmpty(this.bPN)) {
      return;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint(1);
      this.mPaint.setTextSize(aqnm.dpToPx(11.0F));
      this.mPaint.setTextAlign(Paint.Align.LEFT);
    }
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = (int)this.mPaint.measureText(this.bPN) + aqnm.dpToPx(6.0F) + aqnm.dpToPx(25.0F);
    Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();
    int i = (int)(localFontMetrics.bottom - localFontMetrics.top);
    j = j / 2 - i / 2 - aqnm.dpToPx(2.0F);
    int k = aqnm.dpToPx(2.0F);
    if (this.cf == null) {
      this.cf = new Rect();
    }
    this.cf.left = 0;
    this.cf.top = j;
    this.cf.right = (paramInt1 + 0);
    this.cf.bottom = (i + k * 2 + j);
    this.mBaseLine = (j + aqnm.dpToPx(2.0F) - localFontMetrics.top);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void replay()
  {
    if ((this.mIsShow) && (getVisibility() == 0))
    {
      if (this.l == null) {
        requestLayout();
      }
    }
    else {
      return;
    }
    this.l.restartAnimation();
  }
  
  public void setRedDotData(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.mIsShow = b(paramAppInfo);
    if (!this.mIsShow)
    {
      hide();
      setVisibility(8);
    }
    for (;;)
    {
      invalidate();
      return;
      setVisibility(0);
      requestLayout();
      replay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView
 * JD-Core Version:    0.7.0.1
 */