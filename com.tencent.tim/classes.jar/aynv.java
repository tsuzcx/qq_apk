import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aynv
  extends ayob
{
  private int ahe;
  private RectF bP;
  Bitmap bitmap = null;
  private String cXt = acfp.m(2131705388);
  private String cXu = "DEC 06 15:39";
  private String cXv;
  private String cdp;
  private Rect di;
  private int eLA;
  private int eLt;
  private int eLu;
  private int eLv;
  private int eLw;
  private int eLx;
  private int eLy;
  private int eLz;
  private int mHeight;
  Paint mPaint = null;
  TextPaint mTextPaint = null;
  private int mWidth;
  private Typeface q;
  private Typeface r;
  
  public aynv(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("icon_path", paramString3);
      localJSONObject.put("font_path", paramString4);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EaseInLocationStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EaseInLocationStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  private int md(int paramInt)
  {
    return (this.mWidth - paramInt) / 2;
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
        this.cdp = paramString.optString("icon_path", "");
      }
      return new String[] { this.cXt, this.cXu, this.cXv, this.cdp };
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
  
  public String Iy()
  {
    return this.cdp;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = b(this.Gv, this.eLx, 255);
    this.mPaint.setAlpha(i);
    int j = md((int)this.bP.width());
    this.bP.set(j, 0.0F, j + dp2px(8.5F, this.mContext.getResources()), dp2px(11.5F, this.mContext.getResources()));
    ayog.a(i, this.mPaint);
    paramCanvas.drawBitmap(this.bitmap, this.di, this.bP, this.mPaint);
    i = this.bitmap.getHeight() + dp2px(6.0F, this.mContext.getResources());
    this.mTextPaint.setTypeface(this.q);
    j = b(this.Gv, this.eLy, 255);
    this.mTextPaint.setAlpha(j);
    this.mTextPaint.setTextSize(dp2px(16.0F, this.mContext.getResources()));
    float f = Math.abs(this.mTextPaint.getFontMetrics().ascent);
    ayog.a(j, this.mTextPaint);
    paramCanvas.drawText(this.cXt, md(this.eLt), f + i, this.mTextPaint);
    int k = dp2px(16.0F, this.mContext.getResources());
    j = b(this.Gv, this.eLA, 255);
    i = i + k + dp2px(6.0F, this.mContext.getResources());
    this.mPaint.setAlpha(j);
    ayog.a(j, this.mTextPaint);
    paramCanvas.drawLine(md(this.ahe), i, md(this.ahe) + this.ahe, i, this.mPaint);
    j = b(this.Gv, this.eLz, 255);
    k = dp2px(6.0F, this.mContext.getResources());
    this.mTextPaint.setTypeface(this.r);
    this.mTextPaint.setAlpha(j);
    this.mTextPaint.setTextSize(dp2px(9.0F, this.mContext.getResources()));
    f = Math.abs(this.mTextPaint.getFontMetrics().ascent);
    ayog.a(j, this.mTextPaint);
    paramCanvas.drawText(this.cXu, md(this.eLv), k + i + f, this.mTextPaint);
  }
  
  public String getFontPath()
  {
    return this.cXv;
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
    this.mPaint.setColor(-1);
    if (new File(this.cdp).exists()) {
      this.bitmap = BitmapFactory.decodeFile(this.cdp);
    }
    if (this.bitmap == null) {
      this.bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2130840887);
    }
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.ahe = dp2px(36.0F, this.mContext.getResources());
    this.mTextPaint.setTextSize(dp2px(16.0F, this.mContext.getResources()));
    this.eLt = ((int)this.mTextPaint.measureText(this.cXt, 0, this.cXt.length()));
    this.eLu = dp2px(36.0F, this.mContext.getResources());
    this.mTextPaint.setTextSize(dp2px(9.0F, this.mContext.getResources()));
    this.eLv = ((int)this.mTextPaint.measureText(this.cXu, 0, this.cXu.length()));
    this.eLw = dp2px(9.0F, this.mContext.getResources());
    this.di = new Rect(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
    this.bP = new RectF(0.0F, 0.0F, dp2px(8.5F, this.mContext.getResources()), dp2px(11.5F, this.mContext.getResources()));
    this.mWidth = Math.max(Math.max(this.ahe, this.eLt), this.eLv);
    this.mHeight = ((int)(this.bP.height() + this.eLu + this.eLw + dp2px(19.0F, this.mContext.getResources())));
    this.r = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.cXv).exists()) {}
    for (;;)
    {
      try
      {
        this.q = Typeface.createFromFile(this.cXv);
        this.eLx = this.a.a("iconAlpha", 20L, 230L, 0, 255, new LinearInterpolator());
        this.eLy = this.a.a("firstLineAlpha", 120L, 230L, 0, 255, new LinearInterpolator());
        this.eLA = this.a.a("lineAlpha", 220L, 230L, 0, 255, new LinearInterpolator());
        this.eLz = this.a.a("secondLineAlpha", 330L, 230L, 0, 255, new LinearInterpolator());
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("EaseInLocationStickerDrawable", 1, "createFromFile fail, ", localRuntimeException);
        this.q = Typeface.DEFAULT_BOLD;
        continue;
      }
      this.q = Typeface.DEFAULT_BOLD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynv
 * JD-Core Version:    0.7.0.1
 */