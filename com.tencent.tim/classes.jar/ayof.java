import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ayof
  extends ayob
{
  ayog a;
  ayog b;
  private RectF bQ;
  private RectF bR;
  private Paint bc = new Paint();
  private String cXA;
  private String cXB;
  private String cXt = acfp.m(2131707991);
  private String cXu = acfp.m(2131707994);
  private String cXx = acfp.m(2131707992);
  private String cXy = acfp.m(2131707993);
  private String cXz;
  private Rect jdField_do;
  private Rect dp;
  private Rect dq;
  private Rect dr;
  int eLS = 0;
  int eLT = 0;
  private int eLU;
  private int eLV;
  private int eLn;
  private PorterDuffXfermode h = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Bitmap hR;
  private Bitmap hS;
  private PorterDuffXfermode i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private float mLineWidth;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  private int offsetX;
  private int offsetY;
  private Typeface u;
  
  public ayof(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("third_line", paramString3);
      localJSONObject.put("fourth_line", paramString4);
      localJSONObject.put("font_file_name", paramString5);
      localJSONObject.put("out_side_border", paramString6);
      localJSONObject.put("in_side_border", paramString7);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("LunaInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LunaInfoStickerDrawable", 2, paramString1, new Object[0]);
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
        this.cXx = paramString.optString("third_line", "");
        this.cXy = paramString.optString("fourth_line", "");
        this.cXz = paramString.optString("font_file_name", "");
        this.cXA = paramString.optString("out_side_border", "");
        this.cXB = paramString.optString("in_side_border", "");
      }
      return new String[] { this.cXt, this.cXu, this.cXx, this.cXy, this.cXz, this.cXA, this.cXB };
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
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      try
      {
        j = 0 + dp2px(8.5F, this.mContext.getResources());
        this.mTextPaint.setTypeface(this.u);
        this.mTextPaint.setTextSize(dp2px(45.0F, this.mContext.getResources()));
        f1 = Math.abs(this.mTextPaint.getFontMetrics().ascent);
        this.mLineWidth = this.mTextPaint.measureText(this.cXt, 0, this.cXt.length());
        this.mTextPaint.setAlpha(((Integer)paramArrayList.get(this.eLn)).intValue());
        ayog.a(((Integer)paramArrayList.get(this.eLn)).intValue(), this.mTextPaint);
        paramCanvas.drawText(this.cXt, 0, this.cXt.length(), (this.bQ.width() - this.mLineWidth) / 2.0F, f1 + j, this.mTextPaint);
        j = dp2px(45.0F, this.mContext.getResources()) + j + dp2px(8.5F, this.mContext.getResources());
        this.mTextPaint.setTypeface(this.u);
        this.mTextPaint.setTextSize(dp2px(45.0F, this.mContext.getResources()));
        if (Build.VERSION.SDK_INT >= 21) {
          this.mTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
        }
        f1 = Math.abs(this.mTextPaint.getFontMetrics().ascent);
        this.mLineWidth = this.mTextPaint.measureText(this.cXu, 0, this.cXu.length());
        this.mTextPaint.setAlpha(((Integer)paramArrayList.get(this.eLU)).intValue());
        ayog.a(((Integer)paramArrayList.get(this.eLU)).intValue(), this.mTextPaint);
        paramCanvas.drawText(this.cXu, 0, this.cXu.length(), (this.bQ.width() - this.mLineWidth) / 2.0F, f1 + j, this.mTextPaint);
        j = dp2px(45.0F, this.mContext.getResources()) + j + dp2px(8.5F, this.mContext.getResources());
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(dp2px(2.0F, this.mContext.getResources()));
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        k = (int)((this.bQ.width() - this.mLineWidth) / 2.0F);
        ayog.a(((Integer)paramArrayList.get(this.eLV)).intValue(), this.mPaint);
        if (((Integer)paramArrayList.get(this.eLV)).intValue() == dp2px(45.0F, this.mContext.getResources()))
        {
          this.mPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
          paramCanvas.drawLine(k, j, ((Integer)paramArrayList.get(this.eLV)).intValue() + k, j, this.mPaint);
          j += dp2px(8.5F, this.mContext.getResources());
          localObject = this.jdField_a_of_type_Ayog.Gw.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localayoa = (ayoa)((Iterator)localObject).next();
            localBitmap = localayoa.mBitmap;
            localTextPaint = this.jdField_a_of_type_Ayog.mPaint;
            localTextPaint.setAlpha(((Integer)paramArrayList.get(localayoa.eLM)).intValue());
            this.mLineWidth = localTextPaint.measureText(this.cXx, 0, this.cXx.length());
            f1 = (this.bQ.width() - this.mLineWidth) / 2.0F;
            f2 = this.jdField_a_of_type_Ayog.mStartX;
            paramCanvas.drawBitmap(localBitmap, localayoa.eLL + (f1 + f2), this.jdField_a_of_type_Ayog.mStartY + j, localTextPaint);
          }
        }
      }
      catch (Exception paramCanvas)
      {
        int j;
        float f1;
        ayoa localayoa;
        Bitmap localBitmap;
        TextPaint localTextPaint;
        float f2;
        for (;;)
        {
          localObject = new StringBuilder(128);
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext()) {
            ((StringBuilder)localObject).append((Integer)paramArrayList.next()).append(" ");
          }
          this.mPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
        }
        int k = dp2px(14.0F, this.mContext.getResources());
        int m = dp2px(8.5F, this.mContext.getResources());
        Object localObject = this.b.Gw.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localayoa = (ayoa)((Iterator)localObject).next();
          localBitmap = localayoa.mBitmap;
          localTextPaint = this.b.mPaint;
          localTextPaint.setAlpha(((Integer)paramArrayList.get(localayoa.eLM)).intValue());
          this.mLineWidth = localTextPaint.measureText(this.cXy, 0, this.cXy.length());
          f1 = (this.bQ.width() - this.mLineWidth) / 2.0F;
          f2 = this.b.mStartX;
          paramCanvas.drawBitmap(localBitmap, localayoa.eLL + (f1 + f2), this.b.mStartY + (k + j + m), localTextPaint);
        }
        if (paramArrayList != null)
        {
          j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.mPaint, 31);
          if (this.hR != null) {
            paramCanvas.drawBitmap(this.hR, this.jdField_do, this.bQ, this.mPaint);
          }
          this.mPaint.setXfermode(this.h);
          this.mPaint.setColor(-65536);
          this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
          this.dp.set(0, ((Integer)paramArrayList.get(this.eLS)).intValue(), dp2px(88.0F, this.mContext.getResources()), dp2px(180.0F, this.mContext.getResources()));
          paramCanvas.drawRect(this.dp, this.mPaint);
          this.mPaint.setXfermode(null);
          paramCanvas.restoreToCount(j);
          j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.bc, 31);
          if (this.hS != null) {
            paramCanvas.drawBitmap(this.hS, this.dq, this.bR, this.bc);
          }
          this.bc.setXfermode(this.i);
          this.bc.setColor(-65536);
          this.bc.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = this.dr;
          k = this.offsetX;
          m = this.offsetY;
          int n = this.offsetX;
          int i1 = dp2px(77.5F, this.mContext.getResources());
          int i2 = this.offsetY;
          ((Rect)localObject).set(k, m, i1 + n, ((Integer)paramArrayList.get(this.eLT)).intValue() + i2);
          paramCanvas.drawRect(this.dr, this.bc);
          this.bc.setXfermode(null);
          paramCanvas.restoreToCount(j);
          return;
          QLog.e("LunaInfoStickerDrawable", 1, "mFourthLineInfo draw fail, " + ((StringBuilder)localObject).toString(), paramCanvas);
        }
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return dp2px(180.0F, this.mContext.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return dp2px(88.0F, this.mContext.getResources());
  }
  
  protected void init()
  {
    if (new File(this.cXA).exists()) {
      this.hR = BitmapFactory.decodeFile(this.cXA);
    }
    if (this.hR != null) {
      this.jdField_do = new Rect(0, 0, this.hR.getWidth(), this.hR.getHeight());
    }
    this.bQ = new RectF(0.0F, 0.0F, dp2px(88.0F, this.mContext.getResources()), dp2px(180.0F, this.mContext.getResources()));
    if (new File(this.cXB).exists()) {
      this.hS = BitmapFactory.decodeFile(this.cXB);
    }
    if (this.hS != null) {
      this.dq = new Rect(0, 0, this.hS.getWidth(), this.hS.getHeight());
    }
    this.bR = new RectF(0.0F, 0.0F, dp2px(77.5F, this.mContext.getResources()), dp2px(169.0F, this.mContext.getResources()));
    this.dp = new Rect(0, 0, dp2px(88.0F, this.mContext.getResources()), dp2px(180.0F, this.mContext.getResources()));
    this.eLS = this.jdField_a_of_type_Aynr.a("out", 0L, 500L, 0, dp2px(180.0F, this.mContext.getResources()), new LinearInterpolator());
    this.offsetX = ((int)((this.bQ.width() - this.bR.width()) / 2.0F));
    this.offsetY = ((int)((this.bQ.height() - this.bR.height()) / 2.0F));
    this.bR = new RectF(this.offsetX, this.offsetY, this.offsetX + dp2px(77.5F, this.mContext.getResources()), this.offsetY + dp2px(169.0F, this.mContext.getResources()));
    this.dr = new Rect(this.offsetX, this.offsetY, this.offsetX + dp2px(77.5F, this.mContext.getResources()), this.offsetY + dp2px(169.0F, this.mContext.getResources()));
    this.eLT = this.jdField_a_of_type_Aynr.a("in", 150L, 700L, dp2px(180.0F, this.mContext.getResources()), 0, new LinearInterpolator());
    this.eLn = this.jdField_a_of_type_Aynr.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
    this.eLU = this.jdField_a_of_type_Aynr.a("SecondFont", 600L, 200L, 0, 255, new LinearInterpolator());
    this.eLV = this.jdField_a_of_type_Aynr.a("thirdLine", 700L, 200L, 0, dp2px(45.0F, this.mContext.getResources()), new LinearInterpolator());
    if (new File(this.cXz).exists()) {}
    for (;;)
    {
      try
      {
        this.u = Typeface.createFromFile(this.cXz);
        this.mTextPaint.setTypeface(this.u);
        Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
        if ((int)(localFontMetrics.bottom - localFontMetrics.top) <= 0) {
          this.u = Typeface.DEFAULT;
        }
        this.mTextPaint.setTypeface(Typeface.DEFAULT);
      }
      catch (Exception localException)
      {
        this.u = Typeface.DEFAULT;
        continue;
      }
      this.jdField_a_of_type_Ayog = ayog.a(this.cXx, dp2px(15.0F, this.mContext.getResources()), -1, 0, 0, 700, 500, this.u, this.jdField_a_of_type_Aynr);
      this.b = ayog.a(this.cXy, dp2px(15.0F, this.mContext.getResources()), -1, 0, 0, 1100, 300, this.u, this.jdField_a_of_type_Aynr);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setDither(true);
      this.mPaint.setColor(-1);
      this.bc = new Paint();
      this.bc.setAntiAlias(true);
      this.bc.setDither(true);
      this.bc.setColor(-1);
      this.mTextPaint = new TextPaint();
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setDither(true);
      this.mTextPaint.setColor(-1);
      return;
      this.u = Typeface.DEFAULT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayof
 * JD-Core Version:    0.7.0.1
 */