import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import java.util.ArrayList;

public class etm
{
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  private int c;
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    int j = 0;
    int m = 0;
    if (i < this.jdField_a_of_type_JavaLangString.length())
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(i);
      float[] arrayOfFloat = new float[1];
      this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(String.valueOf(c1), arrayOfFloat);
      int k;
      int n;
      if (c1 == '\n')
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(m, i));
        k = i + 1;
        j = 0;
        n = i;
      }
      for (;;)
      {
        i = n + 1;
        m = k;
        break;
        int i1 = j + (int)Math.ceil(arrayOfFloat[0]);
        if (i1 > this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(m, i));
          k = i;
          n = i - 1;
          j = 0;
        }
        else
        {
          n = i;
          j = i1;
          k = m;
          if (i == this.jdField_a_of_type_JavaLangString.length() - 1)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(m, this.jdField_a_of_type_JavaLangString.length()));
            n = i;
            j = i1;
            k = m;
          }
        }
      }
    }
  }
  
  public float a()
  {
    return (this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText("...")) / 2.0F;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i <= paramInt)
    {
      j += ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).length();
      i += 1;
    }
    if (j <= 0) {
      return 0;
    }
    return j - 1;
  }
  
  public String a(int paramInt)
  {
    String str1 = "";
    String str2;
    if (paramInt < 0)
    {
      str2 = str1;
      return str2;
    }
    int j = (int)a();
    int k = this.jdField_a_of_type_JavaLangString.length();
    int i = paramInt;
    for (;;)
    {
      if ((i > k) || (this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1) > j))
      {
        str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        return str1.substring(0, str1.length() - 1);
      }
      str1 = this.jdField_a_of_type_JavaLangString.substring(paramInt, i);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
  {
    int i;
    int j;
    label29:
    String str2;
    int k;
    String str1;
    if ((this.c > 0) && (this.c <= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      i = this.c;
      j = 0;
      if (j >= i) {
        return;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramTruncateAt != TextUtils.TruncateAt.END) {
        break label225;
      }
      if ((i < 2) || (j != i - 1) || (j >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        break label167;
      }
      k = a(i - 2);
      str1 = c(k + 1) + "...";
    }
    for (;;)
    {
      paramCanvas.drawText(str1, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() + this.b * j, this.jdField_a_of_type_AndroidTextTextPaint);
      j += 1;
      break label29;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label167:
      str1 = str2;
      if (j == i - 1)
      {
        str1 = str2;
        if (j < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
        {
          str1 = c(0) + "...";
          continue;
          label225:
          str1 = str2;
          if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE) {
            if ((i >= 2) && (j == i - 1) && (j < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
            {
              k = a(i - 2);
              str1 = a(k + 1) + "..." + b(this.jdField_a_of_type_JavaLangString.length());
            }
            else
            {
              str1 = str2;
              if (j == i - 1)
              {
                str1 = str2;
                if (j < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
                  str1 = a(0) + "..." + b(this.jdField_a_of_type_JavaLangString.length());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, TextPaint paramTextPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    a();
  }
  
  public String b(int paramInt)
  {
    String str1 = "";
    String str2;
    if (paramInt > this.jdField_a_of_type_JavaLangString.length())
    {
      str2 = str1;
      return str2;
    }
    int j = (int)a();
    int i = paramInt;
    for (;;)
    {
      if ((i < 0) || (this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1) > j))
      {
        str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        return str1.substring(1, str1.length());
      }
      str1 = this.jdField_a_of_type_JavaLangString.substring(i, paramInt);
      i -= 1;
    }
  }
  
  public String c(int paramInt)
  {
    String str1 = "";
    String str2;
    if (paramInt < 0)
    {
      str2 = str1;
      return str2;
    }
    int j = this.jdField_a_of_type_JavaLangString.length();
    int k = (int)(this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText("..."));
    int i = paramInt;
    for (;;)
    {
      if ((i > j) || (this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1) > k))
      {
        str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        return str1.substring(0, str1.length() - 1);
      }
      str1 = this.jdField_a_of_type_JavaLangString.substring(paramInt, i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     etm
 * JD-Core Version:    0.7.0.1
 */