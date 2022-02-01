import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class axtz
  extends DynamicTextItem
{
  private float EC;
  float ED = 0.0F;
  float EE = 0.0F;
  float EF = 0.0F;
  ArrayList<axty> Gc = new ArrayList();
  axty a = null;
  private InputFilter b;
  private RectF by = new RectF();
  boolean dwy = false;
  boolean dwz = false;
  StaticLayout e;
  private int eHo;
  private int eHp;
  private int eHq;
  private int eHr;
  private int eHs;
  private Paint mBackgroundPaint;
  private TextPaint mPaint = new TextPaint();
  Resources mResources = BaseApplicationImpl.getContext().getResources();
  private int mShadowColor;
  private TextPaint o;
  float textWidth = 0.0F;
  
  public axtz(int paramInt, @NonNull List<String> paramList)
  {
    super(paramInt, paramList);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-16777216);
    this.mBackgroundPaint = new Paint();
    this.mBackgroundPaint.setAntiAlias(true);
    this.o = new TextPaint();
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setStrokeJoin(Paint.Join.ROUND);
    this.o.setColor(-16777216);
    this.o.setStrokeWidth(wja.dp2px(3.0F, BaseApplicationImpl.getContext().getResources()));
  }
  
  private void a(boolean paramBoolean, float paramFloat, int paramInt)
  {
    this.dwy = paramBoolean;
    if (this.dwy)
    {
      this.eHo = wja.dp2px(paramFloat, BaseApplicationImpl.getContext().getResources());
      this.eHp = paramInt;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, Point paramPoint)
  {
    int j = paramInt3;
    while (j >= paramInt4)
    {
      this.mPaint.setTextSize(j);
      this.o.setTextSize(j);
      StaticLayout localStaticLayout1 = axvp.create(paramString, 0, paramString.length(), this.mPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      StaticLayout localStaticLayout2 = axvp.create(paramString, 0, paramString.length(), this.o, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      this.jdField_b_of_type_AndroidTextStaticLayout = localStaticLayout1;
      this.e = localStaticLayout2;
      paramInt3 = 1;
      int i = 1;
      if (localStaticLayout1.getLineCount() > 1)
      {
        if (localStaticLayout1.getLineVisibleEnd(1) < paramString.length()) {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BasicTextRegionTextItem", 2, "[" + paramString.length() + "," + paramInt5 + "," + localStaticLayout1.getLineEnd(0));
        }
        paramInt3 = i;
        if (paramString.length() >= paramInt5)
        {
          paramInt3 = i;
          if (localStaticLayout1.getLineEnd(0) < paramInt5) {
            paramInt3 = 0;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BasicTextRegionTextItem", 2, "==>" + localStaticLayout1.getHeight() + " ==>" + paramInt2 + " ==>" + j + " ==>" + paramInt4);
      }
      if (localStaticLayout1.getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        float f1 = super.a(localStaticLayout1);
        float f2 = localStaticLayout1.getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      j -= 1;
    }
    return false;
  }
  
  private void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.dwz = true;
    if (this.dwz)
    {
      this.mShadowColor = paramInt;
      this.eHq = wja.dp2px(paramFloat1, BaseApplicationImpl.getApplication().getResources());
      this.eHr = wja.dp2px(paramFloat2, BaseApplicationImpl.getApplication().getResources());
      this.eHs = wja.dp2px(paramFloat3, BaseApplicationImpl.getApplication().getResources());
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
  
  public InputFilter a()
  {
    if (this.jdField_b_of_type_AndroidTextInputFilter == null) {
      this.jdField_b_of_type_AndroidTextInputFilter = new axua(this, 20);
    }
    return this.jdField_b_of_type_AndroidTextInputFilter;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public void aer(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
  
  public float getHeight()
  {
    return this.a.mBackground.getHeight();
  }
  
  public float getWidth()
  {
    return this.a.mBackground.getWidth();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.a.mBackground, 0.0F, 0.0F, this.mBackgroundPaint);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      this.textWidth = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      this.EF = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.ED = (this.a.eHj + (this.a.mWidth - this.textWidth) / 2.0F);
      this.EE = (this.a.eHk + (this.a.mHeight - this.EF) / 2.0F);
      paramCanvas.translate(this.ED, this.EE);
      if (this.dwy)
      {
        this.o.setStrokeWidth(this.eHo);
        this.o.setColor(this.eHp);
        this.e.draw(paramCanvas);
      }
      if (this.dwz)
      {
        this.o.setStrokeWidth(this.eHq);
        this.o.setColor(this.mShadowColor);
        paramCanvas.translate(this.eHr, this.eHs);
        this.e.draw(paramCanvas);
        paramCanvas.translate(-this.eHr, -this.eHs);
      }
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.ou(0))
      {
        this.by.left = (0.0F - this.EC);
        this.by.top = (0.0F - this.EC);
        this.by.right = (this.textWidth + this.EC * 2.0F);
        this.by.bottom = (this.EF + this.EC * 2.0F);
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
    }
    paramCanvas.restore();
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    Object localObject1 = super.gW(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = R(10, paramString);
    Object localObject3 = new Point[this.Gc.size()];
    paramString = new float[this.Gc.size()];
    localObject1 = new boolean[this.Gc.size()];
    StaticLayout[] arrayOfStaticLayout1 = new StaticLayout[this.Gc.size()];
    StaticLayout[] arrayOfStaticLayout2 = new StaticLayout[this.Gc.size()];
    int[] arrayOfInt = new int[this.Gc.size()];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < this.Gc.size())
    {
      localObject3[paramInt] = new Point(0, 0);
      axty localaxty = (axty)this.Gc.get(paramInt);
      localObject1[paramInt] = 0;
      f1 = localaxty.mWidth;
      f2 = localaxty.mHeight;
      localObject1[paramInt] = a((int)f1, (int)f2, localaxty.eHm, localaxty.eHl, (String)localObject2, localaxty.eHh, localaxty.eHn, localObject3[paramInt]);
      arrayOfStaticLayout1[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout;
      arrayOfStaticLayout2[paramInt] = this.e;
      paramString[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[this.Gc.size()];
    paramInt = 0;
    if (paramInt < this.Gc.size())
    {
      localObject3 = (axty)this.Gc.get(paramInt);
      this.mPaint.setTextSize(paramString[paramInt]);
      this.o.setTextSize(paramString[paramInt]);
      arrayOfInt[paramInt] = arrayOfStaticLayout1[paramInt].getLineCount();
      if (localObject1[paramInt] != 0)
      {
        f1 = wja.dp2px(((axty)localObject3).mWidth, this.mResources);
        f2 = wja.dp2px(((axty)localObject3).mHeight, this.mResources);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout1[paramInt]) * arrayOfStaticLayout1[paramInt].getHeight() / (f2 * f1));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BasicTextRegionTextItem", 2, "scale:" + localObject2[paramInt] + " index:" + paramInt);
        }
        paramInt += 1;
        break;
        localObject2[paramInt] = 0.0F;
      }
    }
    int i = this.Gc.size() - 1;
    paramInt = this.Gc.size() - 1;
    if (paramInt >= 0) {
      if ((localObject1[paramInt] == 1) && (localObject1[i] == 1)) {
        i = paramInt;
      }
    }
    for (;;)
    {
      paramInt -= 1;
      break;
      if (localObject2[paramInt] > localObject2[i])
      {
        int j;
        if ((localObject1[paramInt] == 1) && (localObject1[i] == 1) && (arrayOfInt[paramInt] > arrayOfInt[i])) {
          j = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            i = paramInt;
            break;
            j = 0;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("BasicTextRegionTextItem", 2, "curIndex:" + i);
            }
            this.a = ((axty)this.Gc.get(i));
            this.jdField_b_of_type_AndroidTextStaticLayout = arrayOfStaticLayout1[i];
            this.e = arrayOfStaticLayout2[i];
            this.mPaint.setTextSize(paramString[i]);
            this.o.setTextSize(paramString[i]);
            return;
          }
        }
      }
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.mPaint.setTypeface(paramTypeface);
    this.o.setTypeface(paramTypeface);
  }
  
  public static class a
  {
    float EG = 0.0F;
    float EH = 0.0F;
    float EI = 0.0F;
    float EJ = 0.0F;
    ArrayList<axty> Gd = new ArrayList();
    boolean dwA = false;
    boolean dwy = false;
    int eHp = 0;
    int eHt = 0;
    int mFontColor;
    Typeface mTypeface = null;
    
    public a()
    {
      this.Gd.clear();
    }
    
    public axtz a(int paramInt, List<String> paramList)
    {
      axtz localaxtz = new axtz(paramInt, paramList);
      localaxtz.Gc.clear();
      localaxtz.Gc.addAll(this.Gd);
      if (this.mTypeface != null) {
        localaxtz.setTypeface(this.mTypeface);
      }
      localaxtz.aer(this.mFontColor);
      if (this.dwA) {
        axtz.a(localaxtz, this.EG, this.EH, this.EI, this.eHt);
      }
      axtz.a(localaxtz, this.dwy, this.EJ, this.eHp);
      if (!paramList.isEmpty()) {
        localaxtz.setText(0, (String)paramList.get(0));
      }
      return localaxtz;
    }
    
    public void aer(int paramInt)
    {
      this.mFontColor = paramInt;
    }
    
    public void b(axty paramaxty)
    {
      this.Gd.add(paramaxty);
    }
    
    public void setTypeface(Typeface paramTypeface)
    {
      this.mTypeface = paramTypeface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtz
 * JD-Core Version:    0.7.0.1
 */