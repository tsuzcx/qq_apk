import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class gli
  extends DefaultHandler
{
  private static final String jdField_b_of_type_JavaLangString = "dict";
  private static final String jdField_c_of_type_JavaLangString = "key";
  private static final String jdField_d_of_type_JavaLangString = "integer";
  private static final String jdField_e_of_type_JavaLangString = "string";
  private static final String jdField_f_of_type_JavaLangString = "width";
  private static final String g = "height";
  private static final String h = "url";
  private int jdField_a_of_type_Int;
  public String a;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private int jdField_f_of_type_Int;
  private String i;
  private String j = null;
  
  public gli(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuffer.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = false;
    if ("key".equals(paramString2)) {
      this.j = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    }
    do
    {
      do
      {
        int k;
        do
        {
          return;
          if (!"integer".equals(paramString2)) {
            break;
          }
          int m = -1;
          try
          {
            k = Integer.parseInt(this.jdField_a_of_type_JavaLangStringBuffer.toString());
            if ("width".equals(this.j))
            {
              this.e = k;
              return;
            }
          }
          catch (Throwable paramString1)
          {
            for (;;)
            {
              k = m;
              if (QLog.isColorLevel())
              {
                QLog.e("Q.stt", 2, "", paramString1);
                k = m;
              }
            }
          }
        } while (!"height".equals(this.j));
        this.f = k;
        return;
        if (!"string".equals(paramString2)) {
          break;
        }
      } while (!"url".equals(this.j));
      this.i = this.jdField_a_of_type_JavaLangStringBuffer.toString();
      return;
    } while (!"dict".equals(paramString2));
    if ((!TextUtils.isEmpty(this.i)) && (this.e <= this.jdField_a_of_type_Int) && (this.f <= this.b) && ((this.e > this.c) || ((this.e == this.c) && (this.f > this.d))))
    {
      this.d = this.f;
      this.c = this.e;
      this.jdField_a_of_type_JavaLangString = this.i;
    }
    this.j = null;
    this.e = 0;
    this.f = 0;
    this.i = null;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gli
 * JD-Core Version:    0.7.0.1
 */