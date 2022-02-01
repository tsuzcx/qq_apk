import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class nsz
{
  private final nta jdField_a_of_type_Nta;
  private nsx[] jdField_a_of_type_ArrayOfNsx;
  private Set<Character> ar;
  boolean auw = false;
  boolean aux = false;
  final ArrayList<nsy> lR = new ArrayList();
  
  public nsz(nta paramnta)
  {
    this.jdField_a_of_type_Nta = paramnta;
  }
  
  public nsx[] a()
  {
    return this.jdField_a_of_type_ArrayOfNsx;
  }
  
  public float aq()
  {
    int j = this.lR.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((nsy)this.lR.get(i)).aq();
      i += 1;
    }
    return f;
  }
  
  public float ar()
  {
    int j = this.lR.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((nsy)this.lR.get(i)).ar();
      i += 1;
    }
    return f;
  }
  
  public void c(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfNsx == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.lR.size())
    {
      if (((nsy)this.lR.get(i)).aq() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.lR.remove(i);
      }
    }
    int[] arrayOfInt = nsw.a(c(), paramArrayOfChar, this.ar);
    int m = 0;
    int i1 = 1;
    int i2 = 1;
    int n = 0;
    i = 0;
    if (m < arrayOfInt.length)
    {
      int i4;
      int j;
      int k;
      int i3;
      switch (arrayOfInt[m])
      {
      default: 
        throw new IllegalArgumentException("Unknown action: " + arrayOfInt[m]);
      case 1: 
        this.lR.add(i, new nsy(this.jdField_a_of_type_ArrayOfNsx, this.jdField_a_of_type_Nta));
      case 0: 
        nsy localnsy = (nsy)this.lR.get(i);
        localnsy.a(i2, paramArrayOfChar[n], this.aux);
        i4 = i + 1;
        n += 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.auw) {
          if (localnsy.a() == localnsy.d())
          {
            j = i1;
            k = i2;
            i3 = n;
            i = i4;
            if (i2 <= 1) {
              break;
            }
          }
          else
          {
            k = i2 + i1;
            j = i1 + 1;
            i = i4;
            i3 = n;
          }
        }
        break;
      }
      for (;;)
      {
        m += 1;
        i1 = j;
        i2 = k;
        n = i3;
        break;
        ((nsy)this.lR.get(i)).a(i2, '\000', this.aux);
        i4 = i + 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.auw)
        {
          k = i2 + i1;
          j = i1 + 1;
          i3 = n;
          i = i4;
        }
      }
    }
  }
  
  char[] c()
  {
    int j = this.lR.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((nsy)this.lR.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.lR.size();
    int i = 0;
    while (i < j)
    {
      nsy localnsy = (nsy)this.lR.get(i);
      localnsy.draw(paramCanvas, paramPaint);
      paramCanvas.translate(localnsy.aq(), 0.0F);
      i += 1;
    }
  }
  
  public void onAnimationEnd()
  {
    int j = this.lR.size();
    int i = 0;
    while (i < j)
    {
      ((nsy)this.lR.get(i)).onAnimationEnd();
      i += 1;
    }
  }
  
  public void setAnimationProgress(float paramFloat)
  {
    int j = this.lR.size();
    int i = 0;
    while (i < j)
    {
      ((nsy)this.lR.get(i)).c(paramFloat, this.aux);
      i += 1;
    }
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    int j = 0;
    this.jdField_a_of_type_ArrayOfNsx = new nsx[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfNsx[i] = new nsx(paramVarArgs[i]);
      i += 1;
    }
    this.ar = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.ar.addAll(this.jdField_a_of_type_ArrayOfNsx[i].s());
      i += 1;
    }
  }
  
  public void setDigitalAnimWidthSpeedIncrement(boolean paramBoolean)
  {
    this.auw = paramBoolean;
  }
  
  public void setIgnoreWidthAnim(boolean paramBoolean)
  {
    this.aux = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsz
 * JD-Core Version:    0.7.0.1
 */