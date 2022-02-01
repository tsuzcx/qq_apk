import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class axum
  extends DynamicTextItem
{
  private float EQ = 0.73F;
  private float ER = 0.31F;
  private ArrayList<String> Gf = new ArrayList();
  private InputFilter b;
  private RectF bA = new RectF();
  private String cWm = "#ffffff";
  private Bitmap dw;
  private int eHA;
  private int eHB;
  private int eHC;
  private int eHD;
  private int eHE;
  private int eHF;
  private int eHG;
  private int eHH;
  private int eHI;
  private int eHz;
  private RectF mBgRect = new RectF();
  private Resources mRes;
  private int mTextSize;
  private int mTextWidth;
  private TextPaint q;
  
  public axum(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    this.mRes = BaseApplicationImpl.getContext().getResources();
    this.dw = paramBitmap;
    e(paramTypeface);
    this.eHC = dp2px(48.75F);
    this.q.setTextSize(this.eHC);
    this.eHz = ((int)this.q.measureText(acfp.m(2131706415)));
    this.eHD = dp2px(27.0F);
    this.q.setTextSize(this.eHD);
    this.eHA = ((int)this.q.measureText(acfp.m(2131706414)));
    this.eHE = dp2px(18.0F);
    this.q.setTextSize(this.eHE);
    this.eHB = ((int)this.q.measureText(acfp.m(2131706416)));
    this.eHH = dp2px(0.0F);
    this.eHI = dp2px(0.0F);
    this.eHF = ((int)(this.dw.getWidth() * 0.98D));
    this.eHG = ((int)(this.dw.getHeight() * 0.98D));
  }
  
  private int dp2px(float paramFloat)
  {
    return (int)(this.mRes.getDisplayMetrics().density * paramFloat);
  }
  
  private void e(Typeface paramTypeface)
  {
    this.q = new TextPaint();
    this.q.setAntiAlias(true);
    this.q.setColor(Color.parseColor(this.cWm));
    this.q.setTypeface(paramTypeface);
    this.q.setStyle(Paint.Style.FILL_AND_STROKE);
    this.q.setTextAlign(Paint.Align.CENTER);
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.b == null) {
      this.b = new axuo(this, 20);
    }
    return this.b;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mBgRect.bottom - Math.min(this.bA.top, this.mBgRect.top);
  }
  
  public float getWidth()
  {
    return this.eHF;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject = new Rect();
    ((Rect)localObject).set(0, 0, this.dw.getWidth(), this.dw.getHeight());
    paramCanvas.drawBitmap(this.dw, (Rect)localObject, this.mBgRect, null);
    if (super.ou(0)) {
      paramCanvas.drawRoundRect(new RectF(this.bA.left, this.bA.top, this.bA.right, this.bA.bottom + this.mTextWidth * 0.1F), 6.0F, 6.0F, k());
    }
    int j = (int)(this.bA.left + 0.5D * this.mTextWidth);
    int i = (int)(this.bA.top + this.mTextWidth);
    int k = this.Gf.size() - 1;
    while (k >= 0)
    {
      localObject = (String)this.Gf.get(k);
      int i1 = ((String)localObject).length();
      int n = 0;
      int m = i;
      i = n;
      while (i < i1)
      {
        paramCanvas.drawText(((String)localObject).substring(i, i + 1), j, m, this.q);
        m += this.mTextWidth + this.eHI;
        i += 1;
      }
      m = this.mTextWidth;
      n = this.eHH;
      i = (int)(this.bA.top + this.mTextWidth);
      k -= 1;
      j += m + n;
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    paramString = super.a(paramInt, new axun(this));
    this.Gf.clear();
    int j = paramString.length();
    int i;
    if (j > 10)
    {
      this.Gf.add(paramString.substring(0, 10));
      this.Gf.add(paramString.substring(10, Math.min(j, 20)));
      this.mTextSize = this.eHE;
      this.q.setTextSize(this.mTextSize);
      this.mTextWidth = this.eHB;
      paramInt = this.mTextWidth;
      i = this.eHH + paramInt * 2;
      paramInt = this.mTextWidth * 10 + this.eHI * 9;
    }
    while (paramInt > this.eHG * this.EQ)
    {
      this.mBgRect.set(0.0F, paramInt - this.EQ * this.eHG, this.eHF, this.eHG * (1.0F - this.EQ) + paramInt);
      paramString = this.bA;
      f1 = this.eHF - i;
      f2 = this.ER;
      f3 = this.eHF;
      f4 = this.ER;
      paramString.set(f1 * f2, 0.0F, i * (1.0F - this.ER) + f3 * f4, paramInt);
      return;
      int k;
      if (j > 5)
      {
        this.Gf.add(paramString);
        this.mTextSize = this.eHD;
        this.q.setTextSize(this.mTextSize);
        this.mTextWidth = this.eHA;
        i = this.mTextWidth * 1;
        paramInt = this.mTextWidth;
        k = this.eHI;
        paramInt = Math.max(j - 1, 0) * k + paramInt * j;
      }
      else
      {
        this.Gf.add(paramString);
        this.mTextSize = this.eHC;
        this.q.setTextSize(this.mTextSize);
        this.mTextWidth = this.eHz;
        i = this.mTextWidth * 1;
        paramInt = j;
        if (j == 0) {
          paramInt = 2;
        }
        j = this.mTextWidth;
        k = this.eHI;
        paramInt = Math.max(paramInt - 1, 0) * k + j * paramInt;
      }
    }
    this.mBgRect.set(0.0F, 0.0F, this.eHF, this.eHG);
    paramString = this.bA;
    float f1 = this.eHF - i;
    float f2 = this.ER;
    float f3 = (this.eHG * this.EQ - paramInt) / 2.0F;
    float f4 = this.eHF;
    float f5 = this.ER;
    float f6 = i;
    float f7 = this.ER;
    float f8 = this.eHG;
    float f9 = this.EQ;
    paramString.set(f1 * f2, f3, f6 * (1.0F - f7) + f4 * f5, (paramInt + f8 * f9) / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axum
 * JD-Core Version:    0.7.0.1
 */