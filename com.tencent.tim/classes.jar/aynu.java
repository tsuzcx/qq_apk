import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aynu
  extends ayob
{
  private float FQ;
  private Path Y = new Path();
  private String cXq = "27";
  private String cXr = "OCT";
  private String cXs = "2017";
  private Rect dm = new Rect();
  private int eLn;
  private int eLo;
  private int eLp;
  private int eLq;
  private int eLr;
  private int eLs;
  private PorterDuffXfermode g = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private int mHeight;
  private float mLineWidth;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  private int mWidth;
  private Typeface o;
  private Typeface p;
  
  public aynu(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(this.mData);
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
      localJSONObject.put("third_line", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EaseInInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EaseInInfoStickerDrawable", 2, paramString1, new Object[0]);
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
        this.cXq = paramString.optString("first_line", "");
        this.cXr = paramString.optString("second_line", "");
        this.cXs = paramString.optString("third_line", "");
      }
      return new String[] { this.cXq, this.cXr, this.cXs };
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
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = 0 + dp2px(8.5F, this.mContext.getResources());
    this.mTextPaint.setTypeface(this.o);
    this.mTextPaint.setTextSize(dp2px(49.0F, this.mContext.getResources()));
    float f = Math.abs(this.mTextPaint.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mTextPaint.setLetterSpacing(0.0F);
    }
    this.mLineWidth = this.mTextPaint.measureText(this.cXq, 0, this.cXq.length());
    this.mTextPaint.setAlpha(((Integer)paramArrayList.get(this.eLn)).intValue());
    ayog.a(((Integer)paramArrayList.get(this.eLn)).intValue(), this.mTextPaint);
    paramCanvas.drawText(this.cXq, 0, this.cXq.length(), (this.dm.width() - this.mLineWidth) / 2.0F, f + i, this.mTextPaint);
    int j = dp2px(49.0F, this.mContext.getResources());
    i = dp2px(12.5F, this.mContext.getResources()) + (j + i);
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(dp2px(2.0F, this.mContext.getResources()));
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramCanvas.drawLine(this.FQ, i, this.FQ + ((Integer)paramArrayList.get(this.eLo)).intValue(), i, this.mPaint);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (((Integer)paramArrayList.get(this.eLo)).intValue() == (int)(this.dm.width() - this.FQ * 2.0F)) {
        this.mPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
    }
    else
    {
      i += dp2px(10.0F, this.mContext.getResources());
      this.mTextPaint.setTextSize(dp2px(19.0F, this.mContext.getResources()));
      f = Math.abs(this.mTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.mTextPaint.setLetterSpacing(0.1F);
      }
      this.mLineWidth = this.mTextPaint.measureText(this.cXr, 0, this.cXr.length());
      this.mTextPaint.setTypeface(this.p);
      this.mTextPaint.setTextSize(dp2px(19.0F, this.mContext.getResources()));
      this.mTextPaint.setAlpha(((Integer)paramArrayList.get(this.eLp)).intValue());
      ayog.a(((Integer)paramArrayList.get(this.eLp)).intValue(), this.mTextPaint);
      paramCanvas.drawText(this.cXr, 0, this.cXr.length(), (this.dm.width() - this.mLineWidth) / 2.0F, f + i, this.mTextPaint);
      j = dp2px(10.0F, this.mContext.getResources());
      int k = dp2px(9.0F, this.mContext.getResources());
      this.mTextPaint.setTypeface(this.p);
      this.mTextPaint.setTextSize(dp2px(19.0F, this.mContext.getResources()));
      f = Math.abs(this.mTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.mTextPaint.setLetterSpacing(0.0F);
      }
      this.mLineWidth = this.mTextPaint.measureText(this.cXs, 0, this.cXs.length());
      this.mTextPaint.setAlpha(((Integer)paramArrayList.get(this.eLq)).intValue());
      ayog.a(((Integer)paramArrayList.get(this.eLq)).intValue(), this.mTextPaint);
      paramCanvas.drawText(this.cXs, 0, this.cXs.length(), (this.dm.width() - this.mLineWidth) / 2.0F, j + i + k + f, this.mTextPaint);
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.dm.width(), this.dm.height(), this.mPaint, 31);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(dp2px(3.0F, this.mContext.getResources()));
      paramCanvas.drawRect(this.dm, this.mPaint);
      this.mPaint.setXfermode(this.g);
      this.mPaint.setColor(-65536);
      this.mPaint.setStrokeWidth(dp2px(3.0F, this.mContext.getResources()));
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.Y.reset();
      this.Y.moveTo(this.dm.width(), this.dm.height());
      this.Y.lineTo(this.dm.width(), ((Integer)paramArrayList.get(this.eLs)).intValue());
      this.Y.lineTo(((Integer)paramArrayList.get(this.eLr)).intValue(), this.dm.height());
      this.Y.close();
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((this.dm.width() != this.eLr) || (this.dm.height() != this.eLs)) {
          break label1073;
        }
        this.mPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
    }
    for (;;)
    {
      paramCanvas.drawPath(this.Y, this.mPaint);
      this.mPaint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      return;
      this.mPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      break;
      label1073:
      this.mPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
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
    this.mPaint.setColor(-1);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.mWidth = dp2px(70.0F, this.mContext.getResources());
    this.mHeight = dp2px(130.0F, this.mContext.getResources());
    this.dm = new Rect(0, 0, this.mWidth, this.mHeight);
    try
    {
      this.o = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.p = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
          this.eLr = this.a.a("X", 0L, 700L, -this.dm.width(), this.dm.width(), new LinearInterpolator());
          this.eLs = this.a.a("Y", 0L, 700L, -this.dm.height(), this.dm.height(), new LinearInterpolator());
          this.eLn = this.a.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
          this.FQ = dp2px(10.0F, this.mContext.getResources());
          this.eLo = this.a.a("secondLine", 600L, 400L, 0, (int)(this.dm.width() - 2.0F * this.FQ), new LinearInterpolator());
          this.eLp = this.a.a("thirdFont", 800L, 500L, 0, 255, new LinearInterpolator());
          this.eLq = this.a.a("fourthFont", 900L, 500L, 0, 255, new LinearInterpolator());
          return;
          localException1 = localException1;
          this.o = Typeface.DEFAULT;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.p = Typeface.DEFAULT;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynu
 * JD-Core Version:    0.7.0.1
 */