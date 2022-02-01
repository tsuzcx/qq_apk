import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class awmz
  extends Drawable
{
  private awmz.a a;
  private int mHeight = -1;
  private int mWidth = -1;
  
  public awmz()
  {
    this.a = new awmz.a();
  }
  
  public awmz(awmz.a parama)
  {
    this.a = parama;
    if (parama != null)
    {
      at(parama.ha);
      at(parama.gY);
      at(parama.gZ);
      at(parama.hb);
      at(parama.hc);
      at(parama.hd);
      at(parama.gX);
    }
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(paramDrawable.getBounds().left + paramInt1, paramDrawable.getBounds().top + paramInt2, paramDrawable.getBounds().right + paramInt1, paramDrawable.getBounds().bottom + paramInt2);
    }
  }
  
  private void at(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable = paramDrawable.getBounds();
      Rect localRect = getBounds();
      if ((localRect != null) && (paramDrawable != null))
      {
        localRect.left = Math.min(paramDrawable.left, localRect.left);
        localRect.right = Math.max(paramDrawable.right, localRect.right);
        localRect.top = Math.min(paramDrawable.top, localRect.top);
        localRect.bottom = Math.max(paramDrawable.bottom, localRect.bottom);
        setBounds(localRect);
        this.mWidth = Math.max(this.mWidth, localRect.right - localRect.left);
        this.mHeight = Math.max(this.mHeight, localRect.bottom - localRect.top);
      }
    }
  }
  
  public int Qq()
  {
    if ((this.a != null) && (this.a.gY != null)) {
      return Math.abs(this.a.gY.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public int Qr()
  {
    if ((this.a != null) && (this.a.gY != null)) {
      return Math.abs(this.a.gY.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.a;
  }
  
  public boolean aNi()
  {
    if ((this.a != null) && (this.a.gX != null)) {}
    while ((this.a != null) && ((this.a.ha != null) || (this.a.hc != null) || (this.a.hb != null) || (this.a.gZ != null))) {
      return false;
    }
    return true;
  }
  
  public void am(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.gY = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void an(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.gZ = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void ao(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.ha = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void ap(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.hb = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void aq(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.hc = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void ar(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.hd = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void as(Drawable paramDrawable)
  {
    if (this.a != null)
    {
      this.a.gX = paramDrawable;
      at(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    awmz.a locala = this.a;
    if (locala != null)
    {
      if (locala.ha != null) {
        locala.ha.draw(paramCanvas);
      }
      if (locala.hc != null) {
        locala.hc.draw(paramCanvas);
      }
      if (locala.hd != null) {
        locala.hd.draw(paramCanvas);
      }
      if (locala.hb != null) {
        locala.hb.draw(paramCanvas);
      }
      if (locala.gY != null) {
        locala.gY.draw(paramCanvas);
      }
      if (locala.gZ != null) {
        locala.gZ.draw(paramCanvas);
      }
      if (locala.gX != null) {
        locala.gX.draw(paramCanvas);
      }
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.a.mChangingConfigurations = getChangingConfigurations();
    return this.a;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getBounds() != null)
    {
      int i = getBounds().left;
      int j = getBounds().top;
      if ((i != paramInt1) || (j != paramInt2))
      {
        a(this.a.ha, paramInt1 - i, paramInt2 - j);
        a(this.a.hb, paramInt1 - i, paramInt2 - j);
        a(this.a.hc, paramInt1 - i, paramInt2 - j);
        a(this.a.gY, paramInt1 - i, paramInt2 - j);
        a(this.a.gZ, paramInt1 - i, paramInt2 - j);
        a(this.a.hd, paramInt1 - i, paramInt2 - j);
        a(this.a.gX, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  static final class a
    extends Drawable.ConstantState
  {
    Drawable gX = null;
    Drawable gY = null;
    Drawable gZ = null;
    Drawable ha = null;
    Drawable hb = null;
    Drawable hc = null;
    Drawable hd = null;
    int mChangingConfigurations;
    
    a() {}
    
    a(a parama)
    {
      if ((parama.gY != null) && (parama.gY.getConstantState() != null))
      {
        this.gY = parama.gY.getConstantState().newDrawable();
        this.gY.setBounds(parama.gY.getBounds());
      }
      if ((parama.gZ != null) && (parama.gZ.getConstantState() != null))
      {
        this.gZ = parama.gZ.getConstantState().newDrawable();
        this.gZ.setBounds(parama.gZ.getBounds());
      }
      if ((parama.ha != null) && (parama.ha.getConstantState() != null))
      {
        this.ha = parama.ha.getConstantState().newDrawable();
        this.ha.setBounds(parama.ha.getBounds());
      }
      if ((parama.hb != null) && (parama.hb.getConstantState() != null))
      {
        this.hb = parama.hb.getConstantState().newDrawable();
        this.hb.setBounds(parama.hb.getBounds());
      }
      if ((parama.hc != null) && (parama.hc.getConstantState() != null))
      {
        this.hc = parama.hc.getConstantState().newDrawable();
        this.hc.setBounds(parama.hc.getBounds());
      }
      if ((parama.hd != null) && (parama.hd.getConstantState() != null))
      {
        this.hd = parama.hd.getConstantState().newDrawable();
        this.hd.setBounds(parama.hd.getBounds());
      }
      if ((parama.gX != null) && (parama.gX.getConstantState() != null))
      {
        this.gX = parama.gX.getConstantState().newDrawable();
        this.gX.setBounds(parama.gX.getBounds());
      }
      this.mChangingConfigurations = parama.mChangingConfigurations;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new awmz(new a(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmz
 * JD-Core Version:    0.7.0.1
 */