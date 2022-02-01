import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class tsv
{
  final ArrayList<tsu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  private final tsw jdField_a_of_type_Tsw;
  boolean jdField_a_of_type_Boolean = false;
  private tss[] jdField_a_of_type_ArrayOfTss;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  
  public tsv(tsw paramtsw)
  {
    this.jdField_a_of_type_Tsw = paramtsw;
  }
  
  public float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
    return f;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.jdField_b_of_type_Boolean);
      i += 1;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      tsu localtsu = (tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localtsu.a(paramCanvas, paramPaint);
      paramCanvas.translate(localtsu.a(), 0.0F);
      i += 1;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfTss == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    int[] arrayOfInt = tsr.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
    int i1 = 0;
    int j = 1;
    int k = 1;
    i = 0;
    int m = 0;
    tsu localtsu;
    char[] arrayOfChar1;
    int n;
    boolean bool;
    if (i1 < arrayOfInt.length) {
      switch (arrayOfInt[i1])
      {
      default: 
        throw new IllegalArgumentException("Unknown action: " + arrayOfInt[i1]);
      case 1: 
        this.jdField_a_of_type_JavaUtilArrayList.add(m, new tsu(this.jdField_a_of_type_ArrayOfTss, this.jdField_a_of_type_Tsw));
      case 0: 
        localtsu = (tsu)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        char[] arrayOfChar2 = null;
        arrayOfChar1 = arrayOfChar2;
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          arrayOfChar1 = arrayOfChar2;
          if (this.jdField_b_of_type_JavaUtilArrayList.size() > i1)
          {
            arrayOfChar2 = ((String)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).toCharArray();
            arrayOfChar1 = arrayOfChar2;
            if (arrayOfChar2 != null)
            {
              n = arrayOfChar2.length - 1;
              if (arrayOfChar2.length > 0)
              {
                bool = true;
                label277:
                arrayOfChar1 = arrayOfChar2;
              }
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      localtsu.a(k, paramArrayOfChar[i], this.jdField_b_of_type_Boolean, bool, arrayOfChar1, 0, n);
      int i2 = m + 1;
      i += 1;
      m = i2;
      n = i;
      if (this.jdField_a_of_type_Boolean) {
        if (localtsu.a() == localtsu.b())
        {
          m = i2;
          n = i;
          if (k <= 1) {}
        }
        else
        {
          n = k + j;
          j += 1;
          m = i2;
          k = i;
          i = n;
        }
      }
      for (;;)
      {
        i1 += 1;
        n = k;
        k = i;
        i = n;
        break;
        bool = false;
        break label277;
        ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(m)).a(k, '\000', this.jdField_b_of_type_Boolean);
        i2 = m + 1;
        m = i2;
        n = i;
        if (this.jdField_a_of_type_Boolean)
        {
          m = k + j;
          k = i;
          j += 1;
          i = m;
          m = i2;
        }
        else
        {
          i = k;
          k = n;
        }
      }
      n = 0;
      bool = false;
    }
  }
  
  public void a(String... paramVarArgs)
  {
    int j = 0;
    this.jdField_a_of_type_ArrayOfTss = new tss[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfTss[i] = new tss(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfTss[i].a());
      i += 1;
    }
  }
  
  char[] a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public tss[] a()
  {
    return this.jdField_a_of_type_ArrayOfTss;
  }
  
  public float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((tsu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsv
 * JD-Core Version:    0.7.0.1
 */