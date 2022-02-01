import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class auvm
{
  private TypedArray a;
  
  public auvm(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray;
  }
  
  public boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt >= 0) {
      bool = this.a.getBoolean(paramInt, paramBoolean);
    }
    return bool;
  }
  
  public int getColor(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getColor(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelSize(paramInt1, paramInt2);
    }
    return i;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getDrawable(paramInt);
    }
    return null;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInt(paramInt1, paramInt2);
    }
    return i;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getTextArray(paramInt);
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public void recycle()
  {
    this.a.recycle();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvm
 * JD-Core Version:    0.7.0.1
 */