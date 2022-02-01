import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.b;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class axuq
  extends DynamicTextItem
{
  private float Fd;
  List<Bitmap> No = new ArrayList(2);
  private int bsM;
  private RectF by = new RectF();
  private boolean dwI;
  private boolean dwJ;
  private int eHJ;
  private int eHK;
  private int eHL;
  private int eHM;
  private int mHeight;
  private TextPaint mPaint;
  Resources mResources;
  private String mText;
  private int mWidth;
  
  public axuq(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.No.addAll(paramList1);
    this.mResources = BaseApplicationImpl.getContext().getResources();
    this.mPaint = new TextPaint();
    if (paramTypeface != null) {
      this.mPaint.setTypeface(paramTypeface);
    }
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-1);
    this.mPaint.setTextSize(wja.dp2px(9.0F, this.mResources));
    this.eHL = this.mPaint.getFontMetricsInt(null);
    if (this.eHJ <= 0)
    {
      this.eHJ += this.eHL;
      this.eHJ += wja.dp2px(3.0F, this.mResources);
      paramInt = this.eHJ;
      this.eHJ = (((Bitmap)this.No.get(0)).getHeight() + paramInt);
    }
    if (this.eHK <= 0)
    {
      this.eHK += this.eHL;
      this.eHK += wja.dp2px(3.0F, this.mResources);
      paramInt = this.eHK;
      this.eHK = (((Bitmap)this.No.get(1)).getHeight() + paramInt);
    }
    if (this.eHM <= 0) {
      this.eHM = wja.dp2px(2.0F, this.mResources);
    }
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mHeight + this.eHM * 2;
  }
  
  public float getWidth()
  {
    return this.mWidth + this.eHM * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.mText)) {
      return;
    }
    int j;
    label25:
    int k;
    label48:
    int m;
    label71:
    int i5;
    int i6;
    int i7;
    int n;
    label115:
    int i1;
    label131:
    float f1;
    int i8;
    if (axvo.gn(this.mText) < 5)
    {
      j = 1;
      if (j == 0) {
        break label284;
      }
      k = ((Bitmap)this.No.get(0)).getWidth();
      if (j == 0) {
        break label305;
      }
      m = ((Bitmap)this.No.get(0)).getHeight();
      i5 = wja.dp2px(9.0F, this.mResources);
      i6 = wja.dp2px(15.0F, this.mResources);
      i7 = wja.dp2px(3.0F, this.mResources);
      if (j == 0) {
        break label326;
      }
      n = this.eHJ;
      if (j == 0) {
        break label335;
      }
      i1 = wja.dp2px(40.0F, this.mResources);
      f1 = wja.dp2px(9.0F, this.mResources);
      this.mPaint.setTextSize(i1);
      i8 = this.mPaint.getFontMetricsInt(null);
      paramCanvas.save();
      paramCanvas.translate(this.eHM, this.eHM);
      if (!this.dwJ) {
        break label349;
      }
      paramCanvas.drawBitmap((Bitmap)this.No.get(0), 0.0F, 0.0F, this.mPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      if (!super.ou(0)) {
        break;
      }
      this.by.left = 0.0F;
      this.by.top = 0.0F;
      this.by.right = getWidth();
      this.by.bottom = getHeight();
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      return;
      j = 0;
      break label25;
      label284:
      k = ((Bitmap)this.No.get(1)).getWidth();
      break label48;
      label305:
      m = ((Bitmap)this.No.get(1)).getHeight();
      break label71;
      label326:
      n = this.eHK;
      break label115;
      label335:
      i1 = wja.dp2px(36.0F, this.mResources);
      break label131;
      label349:
      paramCanvas.save();
      int i2 = 0;
      int i = 0;
      while (i2 < this.bsM)
      {
        int i3;
        label416:
        int i4;
        label419:
        String str;
        label473:
        Object localObject;
        if ((this.dwI) && (i2 == this.bsM - 1))
        {
          i3 = 1;
          paramCanvas.save();
          if (i3 == 0) {
            break label690;
          }
          paramCanvas.scale(this.Fd, this.Fd);
          i3 = 6;
          i4 = 0;
          if ((i4 >= i3) || (i >= this.mText.length())) {
            break label755;
          }
          int i9 = axvo.f(this.mText.charAt(i));
          if (i9 != 2) {
            break label696;
          }
          str = this.mText.substring(i, i + 2);
          float f2 = 0.5F * k;
          if ((i9 == 0) || (i9 == 3))
          {
            if (i9 != 3) {
              break label714;
            }
            localObject = str;
            label501:
            this.mPaint.setTextSize(f1);
            float f3 = this.eHL;
            float f4 = this.mPaint.descent();
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            paramCanvas.drawText((String)localObject, f2, f3 - f4, this.mPaint);
          }
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.eHL + i7);
          if (j == 0) {
            break label728;
          }
          localObject = (Bitmap)this.No.get(0);
          label589:
          paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.mPaint);
          paramCanvas.restore();
          this.mPaint.setTextSize(i1);
          paramCanvas.drawText(str, f2, this.eHL + i7 + 0.5F * (m - i8) - this.mPaint.ascent(), this.mPaint);
          if (i9 != 2) {
            break label746;
          }
          i += 2;
        }
        for (;;)
        {
          paramCanvas.translate(k + i5, 0.0F);
          i4 += 1;
          break label419;
          i3 = 0;
          break;
          label690:
          i3 = 5;
          break label416;
          label696:
          str = this.mText.substring(i, i + 1);
          break label473;
          label714:
          localObject = ChnToSpell.a(str, 1).csX;
          break label501;
          label728:
          localObject = (Bitmap)this.No.get(1);
          break label589;
          label746:
          i += 1;
        }
        label755:
        paramCanvas.restore();
        paramCanvas.translate(0.0F, n + i6);
        i2 += 1;
      }
      paramCanvas.restore();
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    this.mText = super.gW(paramInt);
    this.mText = this.mText.replaceAll("\\n", "");
    this.mText = this.mText.replaceAll("\\r", "");
    if (TextUtils.isEmpty(this.mText))
    {
      this.dwJ = true;
      this.mText = " ";
      this.dwI = false;
      paramInt = axvo.gn(this.mText);
      if (paramInt >= 5) {
        break label189;
      }
      this.bsM = 1;
      this.mWidth = (((Bitmap)this.No.get(0)).getWidth() * paramInt);
      if (paramInt > 1) {
        this.mWidth += (paramInt - 1) * wja.dp2px(9.0F, this.mResources);
      }
      if (!this.dwJ) {
        break label181;
      }
    }
    label181:
    for (paramInt = ((Bitmap)this.No.get(0)).getHeight();; paramInt = this.eHJ)
    {
      this.mHeight = paramInt;
      return;
      this.dwJ = false;
      break;
    }
    label189:
    this.mWidth = (((Bitmap)this.No.get(1)).getWidth() * 5 + wja.dp2px(9.0F, this.mResources) * 4);
    this.bsM = (paramInt / 5);
    if (paramInt % 5 > 0) {
      this.bsM += 1;
    }
    this.mHeight = ((this.bsM - 1) * this.eHK + (this.bsM - 1) * wja.dp2px(15.0F, this.mResources));
    int i = this.mHeight;
    if (this.dwI) {}
    for (paramInt = (int)(this.Fd * this.eHK + 0.5F);; paramInt = this.eHK)
    {
      this.mHeight = (paramInt + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuq
 * JD-Core Version:    0.7.0.1
 */