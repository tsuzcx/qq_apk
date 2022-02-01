import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axub
  extends DynamicTextItem
{
  private RectF by = new RectF();
  private StaticLayout f;
  private float mHeight;
  private TextPaint mPaint = new TextPaint();
  private float mWidth;
  private TextPaint p = new TextPaint();
  
  public axub(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    if (paramTypeface != null)
    {
      this.mPaint.setTypeface(paramTypeface);
      this.p.setTypeface(paramTypeface);
    }
    for (;;)
    {
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setTextSize(wja.dp2px(22.0F, BaseApplicationImpl.getContext().getResources()));
      this.mPaint.setColor(-1);
      this.p.setTextAlign(Paint.Align.LEFT);
      this.p.setAntiAlias(true);
      this.p.setStyle(Paint.Style.STROKE);
      this.p.setStrokeJoin(Paint.Join.ROUND);
      this.p.setTextSize(wja.dp2px(22.0F, BaseApplicationImpl.getContext().getResources()));
      this.p.setColor(-16777216);
      this.p.setStrokeWidth(wja.dp2px(6.0F, BaseApplicationImpl.getContext().getResources()));
      if (!paramList.isEmpty()) {
        setText(0, (String)paramList.get(0));
      }
      return;
      this.mPaint.setTypeface(Typeface.defaultFromStyle(1));
      this.p.setTypeface(Typeface.defaultFromStyle(1));
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
    return this.mHeight;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      paramCanvas.save();
      this.f.draw(paramCanvas);
      this.b.draw(paramCanvas);
      if (ou(0))
      {
        this.by.left = 0.0F;
        this.by.top = 0.0F;
        this.by.right = super.a(this.b);
        this.by.bottom = this.b.getHeight();
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
      paramCanvas.restore();
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = (int)this.mPaint.measureText(acfp.m(2131703245));
    this.b = axvp.create(paramString, 0, paramString.length(), this.mPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.f = axvp.create(paramString, 0, paramString.length(), this.p, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.mWidth = super.a(this.b);
    this.mHeight = this.b.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axub
 * JD-Core Version:    0.7.0.1
 */