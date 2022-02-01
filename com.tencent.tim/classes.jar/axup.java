import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.lang.reflect.Method;
import java.util.List;

public class axup
  extends DynamicTextItem
{
  public static final float ES;
  public static final float ET;
  public static final float EU;
  public static final float EV;
  public static final float EW;
  public static final float EX;
  public static final float EY;
  public static final float EZ;
  private static final String TAG = axup.class.getSimpleName();
  float Fa;
  float Fb;
  float Fc;
  DrawFilter jdField_b_of_type_AndroidGraphicsDrawFilter = new PaintFlagsDrawFilter(0, 3);
  private StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private RectF by = new RectF();
  private Bitmap hu;
  private Bitmap hv;
  private float mHeight;
  private Paint mLinePaint;
  private TextPaint mPaint = new TextPaint();
  float mTextWidth;
  private float mWidth;
  
  static
  {
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    ES = 2.0F * f;
    ET = 13.0F * f;
    EU = 1.0F * f;
    EV = 5.0F * f;
    EW = 15.0F * f;
    EX = 5.0F * f;
    EY = 5.0F * f;
    EZ = f * 6.0F;
  }
  
  public axup(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTypeface(paramTypeface);
    this.mPaint.setTextSize(wja.dp2px(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.mPaint.setTextSkewX(-0.25F);
    this.mPaint.setColor(-6741743);
    try
    {
      Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE }).invoke(this.mPaint, new Object[] { Float.valueOf(0.4F) });
      bool = true;
    }
    catch (Exception paramTypeface)
    {
      for (;;)
      {
        paramTypeface.printStackTrace();
        boolean bool = false;
      }
    }
    QLog.i(ayjw.TAG, 1, "setLetterSpacing" + bool);
    this.mLinePaint = new Paint();
    this.mLinePaint.setColor(-1);
    this.mLinePaint.setAntiAlias(true);
    this.mLinePaint.setStrokeWidth(2.0F);
    this.mLinePaint.setStyle(Paint.Style.STROKE);
    this.hv = paramBitmap1;
    this.hu = paramBitmap2;
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  private void bX(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.mWidth - this.hv.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.hv, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.hv.getHeight() + EW - (this.hu.getHeight() + EY));
    paramCanvas.drawBitmap(this.hu, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(ET - 0.5F * (this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() - this.mTextWidth), EW + this.hv.getHeight());
    paramCanvas.save();
    paramCanvas.translate(-ES, -ES);
    this.mPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(ES, ES);
    this.mPaint.setColor(-16776961);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    this.mPaint.setColor(-1);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.ou(0))
    {
      float f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      this.by.left = (f2 - this.mTextWidth / 2.0F);
      this.by.top = (-ES);
      this.by.right = (f2 + this.mTextWidth / 2.0F);
      this.by.bottom = (f1 + ES);
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.mHeight - EU);
    paramCanvas.drawLine(0.0F, 0.0F, this.mWidth, 0.0F, this.mLinePaint);
    paramCanvas.restore();
  }
  
  private void bY(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.mWidth - this.hv.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.hv, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.Fb, this.Fc);
    paramCanvas.drawBitmap(this.hu, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    if (this.Fb > 0.0F) {}
    for (float f1 = ET;; f1 = ET + (this.mWidth - this.Fa) * 0.5F)
    {
      paramCanvas.translate(f1 - (this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() - this.mTextWidth) * 0.5F, EX + this.hv.getHeight());
      paramCanvas.save();
      paramCanvas.translate(-ES, -ES);
      this.mPaint.setColor(-65536);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(ES, ES);
      this.mPaint.setColor(-16776961);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      this.mPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.ou(0))
      {
        f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
        float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
        this.by.left = (f2 - this.mTextWidth / 2.0F);
        this.by.top = (-ES);
        this.by.right = (f2 + this.mTextWidth / 2.0F);
        this.by.bottom = (f1 + ES);
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(0.0F, this.mHeight - EU);
      paramCanvas.drawLine(0.0F, 0.0F, this.mWidth, 0.0F, this.mLinePaint);
      paramCanvas.restore();
      return;
    }
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public int Rw()
  {
    return 0;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mHeight;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(this.jdField_b_of_type_AndroidGraphicsDrawFilter);
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      bX(paramCanvas);
      return;
    }
    bY(paramCanvas);
  }
  
  public void setText(int paramInt, String paramString)
  {
    int i = 0;
    float f1 = 0.0F;
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = (int)this.mPaint.measureText(acfp.m(2131706652));
    this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.mPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.2F, 0.0F, false);
    this.mTextWidth = 0.0F;
    int j = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    paramInt = i;
    while (paramInt < j)
    {
      this.mTextWidth = Math.max(this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt), this.mTextWidth);
      paramInt += 1;
    }
    this.Fa = (this.mTextWidth + ES * 2.0F + ET * 2.0F);
    if (j == 1)
    {
      this.mWidth = this.Fa;
      this.mHeight = (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + ES * 2.0F + EU + EV + EW + this.hv.getHeight());
      return;
    }
    float f2 = (this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(j - 2) * 0.5F + EZ + this.hu.getWidth()) * 2.0F;
    this.mWidth = Math.max(this.Fa, f2);
    this.mHeight = (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + ES * 2.0F + EU + EV + EX + this.hv.getHeight());
    if (f2 > this.Fa) {}
    for (;;)
    {
      this.Fb = f1;
      this.Fc = (this.jdField_b_of_type_AndroidTextStaticLayout.getLineBottom(j - 2) - this.mPaint.descent() - this.hu.getHeight() + this.hv.getHeight() + EX);
      return;
      f1 = (this.Fa - f2) * 0.5F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axup
 * JD-Core Version:    0.7.0.1
 */