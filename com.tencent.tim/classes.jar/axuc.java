import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axuc
  extends DynamicTextItem
{
  private static final int aZp = wja.dp2px(12.0F, BaseApplicationImpl.getContext().getResources());
  private static final int eHu = wja.dp2px(20.0F, BaseApplicationImpl.getContext().getResources());
  float EK;
  float EL;
  private StaticLayout b;
  private RectF by = new RectF();
  private RectF bz = new RectF();
  private NinePatch mNinePatch;
  private TextPaint mPaint = new TextPaint();
  
  public axuc(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTypeface(paramTypeface);
    this.mPaint.setTextSize(wja.dp2px(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.mPaint.setColor(-16777216);
    this.mNinePatch = new NinePatch(paramBitmap, paramBitmap.getNinePatchChunk(), null);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
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
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.bz.height() + 20.0F;
  }
  
  public float getWidth()
  {
    return this.bz.width() + 20.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(10.0F, 10.0F);
    this.mNinePatch.draw(paramCanvas, this.bz);
    paramCanvas.translate(eHu, this.mNinePatch.getHeight() * 0.4F);
    this.b.draw(paramCanvas);
    if (super.ou(0))
    {
      float f1 = this.b.getHeight();
      float f2 = super.a(this.b);
      this.by.left = 0.0F;
      this.by.top = 0.0F;
      this.by.right = f2;
      this.by.bottom = f1;
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
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
    int j = (int)this.mPaint.measureText(acfp.m(2131703271));
    this.b = axvp.create(paramString, 0, paramString.length(), this.mPaint, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
    int k = this.b.getLineCount();
    float f1 = 0.0F;
    paramInt = i;
    while (paramInt < k)
    {
      f1 = Math.max(f1, this.b.getLineWidth(paramInt));
      paramInt += 1;
    }
    float f2 = this.b.getHeight();
    float f3 = Math.max(this.mNinePatch.getWidth(), aZp + eHu + f1);
    float f4 = this.mNinePatch.getHeight();
    this.bz.set(0.0F, 0.0F, f3, f4 * 0.7F + f2);
    this.EK = f1;
    this.EL = f2;
    ram.d("BubbleTextItem", "set text " + paramString + " max " + j + " tw " + f1 + " th " + f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuc
 * JD-Core Version:    0.7.0.1
 */