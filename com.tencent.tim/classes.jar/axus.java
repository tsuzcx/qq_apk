import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class axus
  extends DynamicTextItem
{
  private List<String> Np = new ArrayList();
  private int TEXT_COLOR = -1;
  private InputFilter b;
  private RectF bD = new RectF();
  private RectF bE = new RectF();
  private RectF bF = new RectF();
  private RectF bG = new RectF();
  private RectF bH = new RectF();
  private String cRw = acfp.m(2131707527);
  private int eHN = 16;
  private int eHO = 8;
  private int eHP = 12;
  private int eHQ = 10;
  private int eHR = 15;
  private int eHS = 25;
  private int eHT = 20;
  private int eHU = 5;
  private int eHV = 3;
  private int eHW = -5;
  private int eHX;
  private int eHY;
  private StaticLayout g;
  private NinePatch j;
  private NinePatch k;
  private Resources mRes = BaseApplicationImpl.getContext().getResources();
  private TextPaint r;
  private TextPaint s;
  private TextPaint t;
  
  public axus(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.j = new NinePatch(paramBitmap1, paramBitmap1.getNinePatchChunk(), null);
    this.k = new NinePatch(paramBitmap2, paramBitmap2.getNinePatchChunk(), null);
    initPaint();
    this.eHX = ((int)this.r.measureText(acfp.m(2131707528)));
    this.eHY = ((int)(this.s.measureText(acfp.m(2131707526)) * 10.0F));
    if (paramList == null) {}
    for (paramInt = 0;; paramInt = paramList.size())
    {
      int i = 0;
      while (i < paramInt)
      {
        setText(i, (String)paramList.get(i));
        QLog.i("JourneyTextItem", 2, "JourneyTextItem index: " + i + " text: " + (String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if ((paramRectF == null) || (paramPointF == null)) {}
    do
    {
      return false;
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
    } while ((paramFloat1 <= paramRectF.left) || (paramFloat1 >= paramRectF.right) || (paramFloat2 <= paramRectF.top) || (paramFloat2 >= paramRectF.bottom));
    return true;
  }
  
  private void initPaint()
  {
    this.r = new TextPaint();
    this.r.setTypeface(Typeface.DEFAULT);
    this.r.setTextAlign(Paint.Align.CENTER);
    this.r.setAntiAlias(true);
    this.r.setStyle(Paint.Style.FILL_AND_STROKE);
    this.r.setTextSize(this.eHN);
    this.r.setColor(this.TEXT_COLOR);
    this.t = new TextPaint();
    this.t.setTypeface(Typeface.DEFAULT);
    this.t.setAntiAlias(true);
    this.t.setTextSize(this.eHN * 0.8F);
    this.t.setColor(this.TEXT_COLOR);
    this.s = new TextPaint();
    this.s.setAntiAlias(true);
    this.s.setColor(this.TEXT_COLOR);
    this.s.setTextSize(this.eHO);
  }
  
  public int Rv()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / getWidth();
    RectF localRectF1 = new RectF(this.bD.left * f, this.bD.top * f, this.bD.right * f, this.bD.bottom * f);
    RectF localRectF2 = new RectF(this.bH.left * f, this.bH.top * f, this.bH.right * f, f * this.bH.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 0;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 1;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable ayjw.c paramc, ayoo paramayoo)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramc != null) {
      return paramayoo.a(paramc, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - getWidth()) / 2.0F, (paramFloat2 - getHeight()) / 2.0F);
    if (a(f1, f2, this.bD, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.bH, paramMotionEvent)) {
      return 1;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.b == null) {
      this.b = new axuv(this, 20);
    }
    return this.b;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.bE.bottom - this.bD.top;
  }
  
  public float getWidth()
  {
    return (int)Math.max(this.bD.width(), this.bE.width());
  }
  
  public boolean isEmpty()
  {
    boolean bool = false;
    String str1 = a(0, new axuu(this));
    String str2 = gW(1);
    if (((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) || (super.isEmpty())) {
      bool = true;
    }
    return bool;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (ou(0)) {
      paramCanvas.drawRoundRect(this.bF, 6.0F, 6.0F, k());
    }
    if (ou(1)) {
      paramCanvas.drawRoundRect(this.bH, 6.0F, 6.0F, k());
    }
    this.j.draw(paramCanvas, this.bD);
    this.k.draw(paramCanvas, this.bE);
    int m = (int)(this.bD.left + this.eHS * 1.3D);
    int i = (int)(this.eHT + this.eHX * 0.8D);
    int n = this.Np.size() - 1;
    while (n >= 0)
    {
      String str = (String)this.Np.get(n);
      int i3 = str.length();
      int i2 = 0;
      int i1 = i;
      i = i2;
      while (i < i3)
      {
        paramCanvas.drawText(str.substring(i, i + 1), m, i1, this.r);
        i1 += this.eHX + this.eHQ;
        i += 1;
      }
      i1 = this.eHX;
      i2 = this.eHR;
      i = (int)(this.eHT + this.eHX * 0.8D);
      n -= 1;
      m += i1 + i2;
    }
    paramCanvas.translate(this.bG.left, this.bG.top);
    if (this.g != null) {
      this.g.draw(paramCanvas);
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= Rv())) {
      return;
    }
    super.setText(paramInt, paramString);
    String str2 = a(paramInt, new axut(this));
    if (QLog.isColorLevel()) {
      QLog.i("JourneyTextItem", 2, "setText index: " + paramInt + " text: " + str2);
    }
    String str1 = "";
    float f5;
    float f4;
    float f1;
    float f2;
    float f6;
    int i;
    label173:
    float f3;
    if (paramInt == 0)
    {
      paramString = apsv.filterEmoji(str2);
      this.Np.clear();
      f5 = this.bD.width();
      f4 = this.bD.height();
      f1 = this.bE.width();
      this.bE.height();
      f2 = this.bG.width();
      f6 = this.bG.height();
      if (paramInt != 0) {
        break label967;
      }
      paramString = paramString.split("\n");
      int n = paramString.length;
      i = 0;
      paramInt = 0;
      int m = paramInt;
      if (i < n)
      {
        str1 = paramString[i];
        if (str1.length() < 20) {
          break label709;
        }
        this.Np.add(str1.substring(0, 5));
        this.Np.add(str1.substring(5, 10));
        this.Np.add(str1.substring(10, 15));
        this.Np.add(str1.substring(15, 20));
        paramInt = 5;
        label274:
        if (this.Np.size() <= 4) {
          break label958;
        }
        this.Np = this.Np.subList(0, 4);
        m = paramInt;
      }
      paramInt = this.Np.size();
      i = this.eHS;
      n = this.eHR;
      f5 = paramInt * this.eHN + (i * 2 + (paramInt - 1) * n);
      paramInt = this.eHT;
      i = this.eHQ;
      f4 = m * this.eHN + (paramInt * 2 + (m - 1) * i);
      f3 = f1;
      f1 = f6;
      label387:
      paramInt = this.eHP;
      if (f5 <= f3) {
        break label1033;
      }
      this.bD.set(0.0F, 0.0F, f5, f4);
      this.bG.set((f5 - f2) * 0.5F, paramInt + f4 + this.eHV, f2 + (f5 - f2) * 0.5F, f4 + paramInt + f1 + this.eHV);
    }
    for (;;)
    {
      this.bF.set(this.bD.left + this.eHS * 0.8F, this.bD.top + this.eHT * 0.7F, this.bD.right - this.eHS * 0.8F, this.bD.bottom - this.eHT * 0.7F);
      this.bH.set(this.bG.left - this.eHS * 0.3F, this.bG.top - this.eHT * 0.2F, this.bG.right + this.eHS * 0.3F, this.bG.bottom + this.eHT * 0.2F);
      this.bE.set(this.bH.left, this.bH.bottom + this.eHW, f3 + this.bH.left, f1 + this.bH.bottom + this.eHW);
      return;
      this.cRw = str2;
      paramString = str1;
      if (this.cRw.length() < 20) {
        break;
      }
      this.cRw = this.cRw.substring(0, 20);
      paramString = str1;
      break;
      label709:
      if (str1.length() > 15)
      {
        this.Np.add(str1.substring(0, 5));
        this.Np.add(str1.substring(5, 10));
        this.Np.add(str1.substring(10, 15));
        this.Np.add(str1.substring(15, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 10)
      {
        this.Np.add(str1.substring(0, 5));
        this.Np.add(str1.substring(5, 10));
        this.Np.add(str1.substring(10, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 5)
      {
        this.Np.add(str1.substring(0, 5));
        this.Np.add(str1.substring(5, str1.length()));
        paramInt = 5;
        break label274;
      }
      this.Np.add(str1.substring(0, str1.length()));
      paramInt = Math.max(paramInt, str1.length());
      break label274;
      label958:
      i += 1;
      break label173;
      label967:
      this.g = axvp.create(str2, 0, str2.length(), this.s, this.eHY, Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false, null, 0, 2);
      f2 = this.g.getLineWidth(0);
      f1 = this.g.getHeight();
      f3 = this.eHU + f2;
      break label387;
      label1033:
      f6 = (f3 - f5) * 0.5F;
      this.bD.set(f6, 0.0F, f5 + f6, f4);
      this.bG.set((f3 - f2) * 0.5F, paramInt + f4 + this.eHV, f2 + (f3 - f2) * 0.5F, f4 + paramInt + f1 + this.eHV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axus
 * JD-Core Version:    0.7.0.1
 */