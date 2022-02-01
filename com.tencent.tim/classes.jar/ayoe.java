import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ayoe
  extends ayob
{
  private String cXt = "15:29";
  private String cXu = acfp.m(2131707658);
  private String cXv;
  int eLI = 0;
  int eLJ = 0;
  int eLO = 0;
  int eLP = 0;
  int eLQ = 0;
  int eLR = 0;
  int mHeight = 0;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  int mWidth = 0;
  private Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Typeface s;
  private Typeface t;
  
  public ayoe(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("font_path", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Left2RightInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Left2RightInfoStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  public String[] G(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.mType = paramString.optInt("type", 0);
        this.cXt = paramString.optString("first_line", "");
        this.cXu = paramString.optString("second_line", "");
        this.cXv = paramString.optString("font_path", "");
      }
      return new String[] { this.cXt, this.cXu, this.cXv };
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public String Gz()
  {
    return this.cXv;
  }
  
  public String IA()
  {
    return this.cXt;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.mPaint, 31);
    int k = dp2px(2.0F, this.mContext.getResources());
    this.mTextPaint.setColor(-1);
    this.mTextPaint.setTextSize(dp2px(30.0F, this.mContext.getResources()));
    this.mTextPaint.setTypeface(this.s);
    float f1 = Math.abs(this.mTextPaint.getFontMetrics().ascent);
    int i = 0;
    if (this.Gv.size() > this.eLR) {
      i = ((Integer)this.Gv.get(this.eLR)).intValue();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (i != 0) {
        break label438;
      }
      this.mTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    for (;;)
    {
      paramCanvas.drawText(this.cXt, dp2px(7.0F, this.mContext.getResources()) + i, k + f1, this.mTextPaint);
      int m = dp2px(6.0F, this.mContext.getResources());
      this.mTextPaint.setTypeface(this.t);
      this.mTextPaint.setTextSize(dp2px(12.0F, this.mContext.getResources()));
      float f2 = Math.abs(this.mTextPaint.getFontMetrics().ascent);
      paramCanvas.drawText(this.cXu, dp2px(7.0F, this.mContext.getResources()) + i, k + m + (f1 + f2), this.mTextPaint);
      this.mTextPaint.setXfermode(this.mXfermode);
      this.mTextPaint.setColor(-1);
      this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawRect(i, 0.0F, dp2px(5.0F, this.mContext.getResources()), this.mHeight, this.mTextPaint);
      this.mTextPaint.setXfermode(null);
      this.mPaint.setColor(-15322);
      paramCanvas.drawLine(dp2px(2.0F, this.mContext.getResources()), dp2px(8.0F, this.mContext.getResources()), dp2px(2.0F, this.mContext.getResources()), ((Integer)this.Gv.get(this.eLQ)).intValue(), this.mPaint);
      paramCanvas.restoreToCount(j);
      return;
      label438:
      this.mTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  protected void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setStrokeWidth(dp2px(2.0F, this.mContext.getResources()));
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setColor(-15322);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.t = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.cXv).exists()) {}
    for (;;)
    {
      try
      {
        this.s = Typeface.createFromFile(this.cXv);
        this.mTextPaint.setTextSize(dp2px(30.0F, this.mContext.getResources()));
        Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
        this.eLJ = ((int)(localFontMetrics.bottom - localFontMetrics.top));
        this.eLI = ((int)this.mTextPaint.measureText(this.cXt, 0, this.cXt.length()));
        this.mTextPaint.setTextSize(dp2px(12.0F, this.mContext.getResources()));
        localFontMetrics = this.mTextPaint.getFontMetrics();
        this.eLP = ((int)(localFontMetrics.bottom - localFontMetrics.top));
        this.eLP = ((int)this.mTextPaint.measureText(this.cXu, 0, this.cXu.length()));
        this.mWidth = (Math.max(this.eLI, this.eLP) + dp2px(7.0F, this.mContext.getResources()));
        this.mHeight = (dp2px(30.0F, this.mContext.getResources()) + dp2px(12.0F, this.mContext.getResources()) + dp2px(10.0F, this.mContext.getResources()));
        this.eLQ = this.a.a("lineHeight", 20L, 200L, 0, this.mHeight - dp2px(5.0F, this.mContext.getResources()), new LinearInterpolator());
        this.eLR = this.a.a("offsetX", 180L, 330L, -this.mWidth, 0, new LinearInterpolator());
        return;
      }
      catch (Exception localException)
      {
        this.s = Typeface.DEFAULT_BOLD;
        continue;
      }
      this.s = Typeface.DEFAULT_BOLD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoe
 * JD-Core Version:    0.7.0.1
 */