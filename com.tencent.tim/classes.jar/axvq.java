import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axvq
  extends DynamicTextItem
{
  public static final int MAX_WIDTH;
  public static final int TEXT_SIZE;
  public static final int eIb;
  axvr a;
  private RectF by = new RectF();
  private boolean dwL = true;
  private int eIf;
  private float mHeight;
  private TextPaint mPaint = new TextPaint();
  private float mWidth;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    TEXT_SIZE = wja.dp2px(36.0F, localResources);
    eIb = wja.dp2px(6.0F, localResources);
    int i = ayom.tw();
    MAX_WIDTH = localResources.getDisplayMetrics().widthPixels - rgb.PADDING - i * 2;
  }
  
  public axvq(int paramInt, List<String> paramList, Typeface paramTypeface)
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
      this.mPaint.setTextSize(TEXT_SIZE);
      this.mPaint.setColor(-1);
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      if (!paramList.isEmpty()) {
        setText(0, (String)paramList.get(0));
      }
      return;
      this.mPaint.setTypeface(paramTypeface);
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
    this.a.l(paramCanvas, 0, 0);
    if (super.ou(0))
    {
      this.by.set(this.a.a(1, this.a.getLine()));
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
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
    this.eIf = wja.dp2px(18.0F, BaseApplicationImpl.getContext().getResources());
    this.a = new axvr(0);
    this.a.b(new axvd(-65536, eIb));
    this.a.a(paramString, MAX_WIDTH, TEXT_SIZE, this.mPaint);
    this.a.a(new axuz(this.eIf));
    this.mWidth = this.a.a(1, this.a.getLine()).width();
    this.mHeight = this.a.a(1, this.a.getLine()).height();
    this.a.a(new axuf(this.mWidth, this.mHeight));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvq
 * JD-Core Version:    0.7.0.1
 */