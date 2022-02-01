import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class jmc
{
  private jmc.a a;
  private int aBv;
  private int aBw;
  private boolean aaq = true;
  private boolean aar;
  private LinearGradient g;
  private float jdField_if;
  private Paint paint;
  private Matrix r;
  private View view;
  
  public jmc(View paramView, Paint paramPaint, AttributeSet paramAttributeSet)
  {
    this.view = paramView;
    this.paint = paramPaint;
    init(paramAttributeSet);
  }
  
  private void axT()
  {
    float f = -this.view.getWidth();
    int i = this.aBv;
    int j = this.aBw;
    int k = this.aBv;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.g = new LinearGradient(f, 0.0F, 0.0F, 0.0F, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
    this.paint.setShader(this.g);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.aBw = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.view.getContext().obtainStyledAttributes(paramAttributeSet, atau.a.sb, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.aBw = paramAttributeSet.getColor(0, -1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShimmerTextView", 2, "Error while creating the view:", localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    this.r = new Matrix();
  }
  
  public void onDraw()
  {
    if (this.aaq)
    {
      if (this.paint.getShader() == null) {
        this.paint.setShader(this.g);
      }
      this.r.setTranslate(2.0F * this.jdField_if, 0.0F);
      this.g.setLocalMatrix(this.r);
      return;
    }
    this.paint.setShader(null);
  }
  
  public void onSizeChanged()
  {
    axT();
    if (!this.aar)
    {
      this.aar = true;
      if (this.a != null) {
        this.a.bP(this.view);
      }
    }
  }
  
  public void setAnimationSetupCallback(jmc.a parama)
  {
    this.a = parama;
  }
  
  public void setGradientX(float paramFloat)
  {
    this.jdField_if = paramFloat;
    this.view.invalidate();
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.aBv = paramInt;
    if (this.aar) {
      axT();
    }
  }
  
  public void setReflectionColor(int paramInt)
  {
    this.aBw = paramInt;
    if (this.aar) {
      axT();
    }
  }
  
  public void setShimmering(boolean paramBoolean)
  {
    this.aaq = paramBoolean;
  }
  
  public boolean xU()
  {
    return this.aaq;
  }
  
  public static abstract interface a
  {
    public abstract void bP(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmc
 * JD-Core Version:    0.7.0.1
 */