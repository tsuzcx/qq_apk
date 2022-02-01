import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axvb
  extends DynamicTextItem
{
  public static final int MAX_WIDTH;
  public static final int TEXT_SIZE;
  public static final int oX;
  private int Bj = 2147483647;
  protected RectF by = new RectF();
  protected float mHeight;
  protected TextPaint mPaint = new TextPaint();
  protected float mWidth;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    TEXT_SIZE = wja.dp2px(22.0F, localResources);
    oX = wja.dp2px(14.0F, localResources);
    MAX_WIDTH = Math.min(localResources.getDisplayMetrics().widthPixels - ayjw.PADDING, wja.dp2px(270.0F, localResources));
  }
  
  public axvb()
  {
    this(0, axug.at(0));
  }
  
  public axvb(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.mPaint.setTypeface(Typeface.DEFAULT);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setTextSize(TEXT_SIZE);
    this.mPaint.setColor(-1);
    this.mPaint.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
    this.textSize = TEXT_SIZE;
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public int Rw()
  {
    return 0;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int i = paramInt3 + 10;
    setTextSize(i);
    setText(paramInt1, paramString);
    if (this.b.getHeight() < paramInt2) {
      return i;
    }
    setTextSize(paramInt3);
    setText(paramInt1, paramString);
    return paramInt3;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramInt3 -= 10;
    if (paramInt3 > oX)
    {
      setTextSize(paramInt3);
      setText(paramInt1, paramString);
      if (this.b.getHeight() >= paramInt2) {}
    }
    for (paramInt3 = 0;; paramInt3 = 1)
    {
      if (paramInt3 == 0)
      {
        return false;
        paramInt3 -= 10;
        break;
      }
      double d = this.b.getHeight() / this.b.getLineCount();
      this.Bj = ((int)(paramInt2 / d));
      setText(paramInt1, paramString);
      return true;
    }
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mHeight;
  }
  
  public int getLineCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getLineCount();
  }
  
  public int getTextColor()
  {
    return this.mPaint.getColor();
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1;
    if (this.b != null)
    {
      if (this.b.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(getWidth() / 2.0F, getHeight() / 2.0F);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.mPaint.descent() + this.mPaint.ascent()) / 2.0F);
        String str2 = super.gW(0);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "　　";
        }
        paramCanvas.drawText(str1, 0.0F, f1, this.mPaint);
        if (super.ou(0))
        {
          int i = (int)this.mPaint.measureText(str1);
          int j = (int)Math.ceil(this.mPaint.descent() - this.mPaint.ascent());
          this.by.left = (-i / 2.0F);
          this.by.top = (-j / 2.0F);
          this.by.right = (i / 2.0F);
          this.by.bottom = (j / 2.0F);
          paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
        }
        paramCanvas.restore();
      }
    }
    else {
      return;
    }
    this.mPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    this.b.draw(paramCanvas);
    if (super.ou(0))
    {
      f1 = super.a(this.b);
      float f2 = this.b.getHeight();
      this.by.left = 0.0F;
      this.by.top = 0.0F;
      this.by.right = f1;
      this.by.bottom = f2;
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
    paramCanvas.restore();
  }
  
  public void setText(int paramInt, String paramString)
  {
    float f = 0.0F;
    int i = 0;
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    if (this.dwE) {
      this.mPaint.setTextSize(this.textSize);
    }
    this.b = axvp.create(paramString, 0, paramString.length(), this.mPaint, MAX_WIDTH, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.Bj);
    str = paramString;
    if (this.b.getLineCount() > this.Bj)
    {
      paramInt = this.b.getLineEnd(this.Bj - 1);
      str = paramString;
      if (paramInt < paramString.length()) {
        str = paramString.subSequence(0, paramInt) + "";
      }
      this.b = axvp.create(str, 0, str.length(), this.mPaint, MAX_WIDTH, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.Bj);
    }
    paramInt = i;
    if (this.b.getLineCount() == 1)
    {
      this.mWidth = this.mPaint.measureText(str);
      this.mHeight = (this.mPaint.descent() - this.mPaint.ascent());
      return;
    }
    while (paramInt < this.b.getLineCount())
    {
      f = Math.max(f, this.b.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.mWidth = f;
    this.mHeight = this.b.getHeight();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.mPaint.setTextSize(paramInt);
    this.textSize = paramInt;
    this.dwE = true;
  }
  
  public boolean uj(String paramString)
  {
    int i = this.b.getLineCount();
    i = this.b.getLineEnd(i - 1);
    return paramString.length() > i + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvb
 * JD-Core Version:    0.7.0.1
 */