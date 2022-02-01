import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axur
  extends DynamicTextItem
{
  public static final float Fe = ankt.dip2px(45.0F);
  public static final int TEXT_SIZE = wja.dp2px(24.0F, BaseApplicationImpl.getContext().getResources());
  axvr a;
  private RectF bB = new RectF();
  private RectF bC = new RectF();
  private RectF by = new RectF();
  private Bitmap hw;
  private Bitmap hx;
  private float mHeight;
  private int mMaxWidth;
  private TextPaint mPaint = new TextPaint();
  private int mTextSize;
  private float mWidth;
  
  public axur(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.mPaint.setTypeface(Typeface.DEFAULT);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.mPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setColor(-16777216);
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      this.mMaxWidth = (TEXT_SIZE * 9);
      new axty.a().a(0.0F, 0.0F).a(this.mMaxWidth, TEXT_SIZE, 5, 9).a();
      this.mTextSize = TEXT_SIZE;
      this.mPaint.setTextSize(this.mTextSize);
      this.hw = paramBitmap1;
      this.hx = paramBitmap2;
      if (!paramList.isEmpty()) {
        setText(0, (String)paramList.get(0));
      }
      return;
      this.mPaint.setTypeface(paramTypeface);
    }
  }
  
  private void a(int paramInt, RectF paramRectF, Canvas paramCanvas, Paint paramPaint)
  {
    if ((paramInt < 0) || (paramRectF == null) || (paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    if (paramInt < 4)
    {
      paramCanvas.drawBitmap(this.hw, paramRectF.left + (paramRectF.width() - this.hw.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.hw.getHeight()) / 2.0F, paramPaint);
      return;
    }
    paramCanvas.drawBitmap(this.hx, paramRectF.left + (paramRectF.width() - this.hx.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.hx.getHeight()) / 2.0F, paramPaint);
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
    return this.mHeight;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.a == null) {
      return;
    }
    paramCanvas.save();
    this.mPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    int i = 0;
    while (i < this.a.getLine())
    {
      this.bC.set(this.a.b(i));
      this.bB.set(this.bC);
      a(this.a.lQ(i), this.bB, paramCanvas, this.mPaint);
      RectF localRectF = this.bC;
      localRectF.bottom -= Fe;
      this.bB.set(this.bC);
      i += 1;
    }
    paramCanvas.restore();
    paramCanvas.rotate(-10.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
    paramCanvas.translate(0.0F, -ankt.dip2px(5.0F));
    this.mPaint.setColor(-16777216);
    this.a.l(paramCanvas, 0, 0);
    if (super.ou(0))
    {
      this.by.set(this.a.a(1, this.a.getLine()));
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
    paramCanvas.restore();
  }
  
  public void setText(int paramInt, String paramString)
  {
    int i = 0;
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.a = new axvr(0);
    this.a.a(paramString, this.mMaxWidth, TEXT_SIZE, this.mPaint);
    this.a.a(new axuz((int)Fe));
    this.mWidth = this.a.a(1, this.a.getLine()).width();
    this.mHeight = this.a.a(1, this.a.getLine()).height();
    paramInt = 0;
    if (paramInt < this.a.getLine())
    {
      int j = this.a.lQ(paramInt);
      if (i > j) {}
      for (;;)
      {
        paramInt += 1;
        break;
        i = j;
      }
    }
    if (i <= 4) {}
    for (this.mWidth = this.hw.getWidth();; this.mWidth = this.hx.getWidth())
    {
      this.a.a(new axuf(this.mWidth, this.mHeight));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axur
 * JD-Core Version:    0.7.0.1
 */