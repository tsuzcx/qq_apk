import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

public class axvm
  extends DynamicTextItem
{
  private static float[] ef = { 62.0F, 35.5F, 8.0F, 13.0F, 117.0F, 35.0F, 22.0F, 14.0F, 181.0F, 40.0F, 25.0F, 13.0F };
  private float EC;
  List<Bitmap> Nq = new ArrayList(3);
  private InputFilter b;
  private RectF by = new RectF();
  private int eIn;
  private TextPaint mPaint;
  Resources mResources = BaseApplicationImpl.getContext().getResources();
  
  public axvm(int paramInt, Typeface paramTypeface, @NonNull List<String> paramList, @NonNull List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.Nq.clear();
    this.Nq.addAll(paramList1);
    this.mPaint = new TextPaint();
    if (paramTypeface != null) {
      this.mPaint.setTypeface(paramTypeface);
    }
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-16777216);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString, Point paramPoint)
  {
    int i = paramInt3;
    while (i >= 16)
    {
      this.mPaint.setTextSize(wja.dp2px(i, this.mResources));
      StaticLayout localStaticLayout = axvp.create(paramString, 0, paramString.length(), this.mPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
      this.jdField_b_of_type_AndroidTextStaticLayout = localStaticLayout;
      int j = 1;
      paramInt3 = j;
      if (localStaticLayout.getLineCount() > 1)
      {
        paramInt3 = j;
        if (localStaticLayout.getLineVisibleEnd(1) < paramString.length()) {
          paramInt3 = 0;
        }
      }
      if (localStaticLayout.getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        float f1 = super.a(localStaticLayout);
        float f2 = localStaticLayout.getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      i -= 2;
    }
    return false;
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
      this.jdField_b_of_type_AndroidTextInputFilter = new axvn(this, 20);
    }
    return this.jdField_b_of_type_AndroidTextInputFilter;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return ((Bitmap)this.Nq.get(this.eIn)).getHeight();
  }
  
  public float getWidth()
  {
    return ((Bitmap)this.Nq.get(this.eIn)).getWidth();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap((Bitmap)this.Nq.get(this.eIn), 0.0F, 0.0F, this.mPaint);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      float f1 = wja.dp2px(ef[(this.eIn * 4 + 2)], this.mResources);
      float f2 = wja.dp2px(ef[(this.eIn * 4 + 3)], this.mResources);
      float f3 = wja.dp2px(ef[(this.eIn * 4)], this.mResources);
      float f4 = wja.dp2px(ef[(this.eIn * 4 + 1)], this.mResources);
      float f5 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f6 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.EC = wja.dp2px(2.0F, this.mResources);
      paramCanvas.translate(f1 + (f3 - f5) * 0.5F, f2 + (f4 - f6) * 0.5F);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (ou(0))
      {
        this.by.left = (0.0F - this.EC);
        this.by.top = (0.0F - this.EC);
        this.by.right = (this.EC * 2.0F + f5);
        this.by.bottom = (this.EC * 2.0F + f6);
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
    }
    paramCanvas.restore();
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    Object localObject1 = gW(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = R(10, paramString);
    Point[] arrayOfPoint = new Point[3];
    paramString = new float[3];
    localObject1 = new boolean[3];
    StaticLayout[] arrayOfStaticLayout = new StaticLayout[3];
    int[] arrayOfInt = new int[3];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < 3)
    {
      arrayOfPoint[paramInt] = new Point(0, 0);
      localObject1[paramInt] = 0;
      f1 = wja.dp2px(ef[(paramInt * 4)], this.mResources);
      f2 = wja.dp2px(ef[(paramInt * 4 + 1)], this.mResources);
      localObject1[paramInt] = a((int)f1, (int)f2, 37, (String)localObject2, arrayOfPoint[paramInt]);
      arrayOfStaticLayout[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout;
      paramString[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[3];
    paramInt = 0;
    if (paramInt < 3)
    {
      this.mPaint.setTextSize(paramString[paramInt]);
      arrayOfInt[paramInt] = arrayOfStaticLayout[paramInt].getLineCount();
      if (localObject1[paramInt] != 0)
      {
        f1 = wja.dp2px(ef[(paramInt * 4)], this.mResources);
        f2 = wja.dp2px(ef[(paramInt * 4 + 1)], this.mResources);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout[paramInt]) * arrayOfStaticLayout[paramInt].getHeight() / (f1 * f2));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShadowBubbleTextItem", 2, "scale:" + localObject2[paramInt] + " index:" + paramInt);
        }
        paramInt += 1;
        break;
        localObject2[paramInt] = 0.0F;
      }
    }
    int j = 2;
    paramInt = 2;
    if (paramInt >= 0)
    {
      int i;
      if ((localObject1[paramInt] == 1) && (localObject1[j] == 1) && (arrayOfInt[paramInt] < arrayOfInt[j])) {
        i = paramInt;
      }
      do
      {
        paramInt -= 1;
        j = i;
        break;
        i = j;
      } while (localObject2[paramInt] <= localObject2[j]);
      if ((localObject1[paramInt] == 1) && (localObject1[j] == 1) && (arrayOfInt[paramInt] > arrayOfInt[j])) {}
      for (int k = 1;; k = 0)
      {
        i = j;
        if (k != 0) {
          break;
        }
        i = paramInt;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShadowBubbleTextItem", 2, "curIndex:" + j);
    }
    this.eIn = j;
    this.jdField_b_of_type_AndroidTextStaticLayout = arrayOfStaticLayout[j];
    this.mPaint.setTextSize(paramString[j]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvm
 * JD-Core Version:    0.7.0.1
 */