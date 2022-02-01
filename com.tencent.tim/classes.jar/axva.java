import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.List;

public class axva
  extends axvb
{
  private float Ff;
  private RectF bI;
  private int mColor = Color.parseColor("#FFFFFF");
  private Paint mRectPaint = new Paint();
  
  public axva(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(16777215);
    this.mRectPaint.setAlpha(230);
    this.mRectPaint.setAntiAlias(true);
    this.bI = new RectF();
  }
  
  public float getHeight()
  {
    return this.mHeight + 32.0F;
  }
  
  public int getTextColor()
  {
    return this.mColor;
  }
  
  public float getWidth()
  {
    return this.mWidth + this.Ff * 2.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      if (this.b.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(getWidth() / 2.0F, getHeight() / 2.0F);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        String str2 = super.gW(0);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "　　";
        }
        int i = (int)this.mPaint.measureText(str1);
        int j = (int)Math.ceil(this.mPaint.descent() - this.mPaint.ascent());
        f1 = (j + 32) / 2.0F;
        this.bI.left = (-(i + f1 * 2.0F) / 2.0F);
        this.bI.right = ((i + f1 * 2.0F) / 2.0F);
        this.bI.top = (-(j + 32) / 2.0F);
        this.bI.bottom = ((j + 32) / 2.0F);
        paramCanvas.drawRoundRect(this.bI, f1, f1, this.mRectPaint);
        paramCanvas.drawText(str1, 0.0F, -((this.mPaint.descent() + this.mPaint.ascent()) / 2.0F), this.mPaint);
        if (super.ou(0))
        {
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
    paramCanvas.translate(this.Ff, 16.0F);
    float f1 = super.a(this.b);
    float f2 = this.b.getHeight();
    float f3 = (32.0F + f2) / 2.0F;
    this.bI.left = (-f3);
    this.bI.right = (f1 + f3);
    this.bI.top = -16.0F;
    this.bI.bottom = (f2 + 16.0F);
    paramCanvas.drawRoundRect(this.bI, f3, f3, this.mRectPaint);
    this.b.draw(paramCanvas);
    if (super.ou(0))
    {
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
    super.setText(paramInt, paramString);
    this.Ff = (((int)Math.ceil(this.mHeight) + 32) / 2.0F);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mRectPaint.setColor(paramInt);
    this.mRectPaint.setAlpha(230);
    this.mColor = paramInt;
    if ((paramInt == Color.parseColor("#FFFFFF")) || (paramInt == Color.parseColor("#F7E368")) || (paramInt == Color.parseColor("#7ED5F8")))
    {
      this.mPaint.setColor(Color.parseColor("#000000"));
      return;
    }
    this.mPaint.setColor(Color.parseColor("#ffffff"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axva
 * JD-Core Version:    0.7.0.1
 */