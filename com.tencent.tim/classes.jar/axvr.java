import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

public class axvr
{
  private float Fj = 0.0F;
  private float Fk = 0.0F;
  private ArrayList<axvf> Gj = new ArrayList();
  private axtv jdField_a_of_type_Axtv;
  private axvs jdField_a_of_type_Axvs;
  private int eIo;
  
  public axvr(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_Axvs = new axve();
    }
    while (paramInt == 0) {
      return;
    }
    throw new IllegalArgumentException("TextDrawImplement init failed");
  }
  
  public RectF a(int paramInt1, int paramInt2)
  {
    paramInt1 -= 1;
    paramInt2 -= 1;
    if ((paramInt1 >= 0) && (paramInt1 < this.Gj.size()) && (paramInt2 >= 0) && (paramInt2 < this.Gj.size()) && (paramInt2 >= paramInt1))
    {
      RectF localRectF = new RectF();
      localRectF.left = 3.4028235E+38F;
      localRectF.top = 3.4028235E+38F;
      localRectF.right = 1.4E-45F;
      localRectF.bottom = 1.4E-45F;
      while (paramInt1 <= paramInt2)
      {
        axvf localaxvf = (axvf)this.Gj.get(paramInt1);
        if (localRectF.left > localaxvf.bx.left) {
          localRectF.left = localaxvf.bx.left;
        }
        if (localRectF.right < localaxvf.bx.right) {
          localRectF.right = localaxvf.bx.right;
        }
        if (localRectF.top > localaxvf.bx.top) {
          localRectF.top = localaxvf.bx.top;
        }
        if (localRectF.bottom < localaxvf.bx.bottom) {
          localRectF.bottom = localaxvf.bx.bottom;
        }
        paramInt1 += 1;
      }
      return localRectF;
    }
    return null;
  }
  
  public void a(axtv paramaxtv)
  {
    this.eIo = 2;
    this.jdField_a_of_type_Axtv = paramaxtv;
  }
  
  public void a(axtw paramaxtw)
  {
    int i = 0;
    while (i < this.Gj.size())
    {
      paramaxtw.a(i, (axvf)this.Gj.get(i));
      i += 1;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    if (paramTextPaint == null) {
      paramTextPaint = new TextPaint();
    }
    for (;;)
    {
      paramTextPaint.setTextSize(paramInt2);
      StaticLayout localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      this.Gj.clear();
      paramInt1 = 0;
      float f3;
      for (float f1 = 0.0F; paramInt1 < localStaticLayout.getLineCount(); f1 += f3)
      {
        Object localObject = new RectF();
        String str = paramCharSequence.subSequence(localStaticLayout.getLineStart(paramInt1), localStaticLayout.getLineEnd(paramInt1)).toString();
        Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
        float f2 = paramTextPaint.measureText(str, 0, str.length());
        f3 = Math.abs(localFontMetrics.bottom - localFontMetrics.top);
        float f4 = Math.abs(localFontMetrics.ascent);
        ((RectF)localObject).left = 0.0F;
        ((RectF)localObject).right = (0.0F + f2);
        ((RectF)localObject).top = f1;
        ((RectF)localObject).bottom = (f1 + f3);
        localObject = new axvf(0, 0, paramTextPaint, str, (RectF)localObject, f4);
        this.Gj.add(localObject);
        if (this.Fj < f2) {
          this.Fj = f2;
        }
        this.Fk += f3;
        paramInt1 += 1;
      }
      return;
    }
  }
  
  public RectF b(int paramInt)
  {
    return ((axvf)this.Gj.get(paramInt)).bx;
  }
  
  public void b(axtv paramaxtv)
  {
    this.eIo = 1;
    this.jdField_a_of_type_Axtv = paramaxtv;
  }
  
  public float cd()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.Gj.size())
    {
      axvf localaxvf = (axvf)this.Gj.get(i);
      if (localRectF.left > localaxvf.bx.left) {
        localRectF.left = localaxvf.bx.left;
      }
      if (localRectF.right < localaxvf.bx.right) {
        localRectF.right = localaxvf.bx.right;
      }
      if (localRectF.top > localaxvf.bx.top) {
        localRectF.top = localaxvf.bx.top;
      }
      if (localRectF.bottom < localaxvf.bx.bottom) {
        localRectF.bottom = localaxvf.bx.bottom;
      }
      i += 1;
    }
    return localRectF.width();
  }
  
  public float ce()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.Gj.size())
    {
      axvf localaxvf = (axvf)this.Gj.get(i);
      if (localRectF.left > localaxvf.bx.left) {
        localRectF.left = localaxvf.bx.left;
      }
      if (localRectF.right < localaxvf.bx.right) {
        localRectF.right = localaxvf.bx.right;
      }
      if (localRectF.top > localaxvf.bx.top) {
        localRectF.top = localaxvf.bx.top;
      }
      if (localRectF.bottom < localaxvf.bx.bottom) {
        localRectF.bottom = localaxvf.bx.bottom;
      }
      i += 1;
    }
    return localRectF.height();
  }
  
  public int getLine()
  {
    return this.Gj.size();
  }
  
  public void l(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if ((this.eIo == 2) && (this.jdField_a_of_type_Axtv != null)) {
      this.jdField_a_of_type_Axtv.a(paramCanvas, this.Gj, paramInt1, paramInt2);
    }
    Iterator localIterator = this.Gj.iterator();
    while (localIterator.hasNext())
    {
      axvf localaxvf = (axvf)localIterator.next();
      if ((this.eIo == 1) && (this.jdField_a_of_type_Axtv != null)) {
        localaxvf.a(paramCanvas, this.jdField_a_of_type_Axtv, paramInt1, paramInt2);
      }
      localaxvf.f(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public int lQ(int paramInt)
  {
    return ((axvf)this.Gj.get(paramInt)).mText.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvr
 * JD-Core Version:    0.7.0.1
 */