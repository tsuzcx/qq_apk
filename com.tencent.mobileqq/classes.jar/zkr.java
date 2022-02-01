import android.widget.TextView;
import java.util.Map;

class zkr
  extends zaz
{
  zkr(zkp paramzkp, afxp paramafxp) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)zkp.b(this.jdField_a_of_type_Zkp).get(Integer.valueOf(this.jdField_a_of_type_Afxp.b));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.jdField_a_of_type_Afxp.a.setText((CharSequence)zkp.c(this.jdField_a_of_type_Zkp).get(Integer.valueOf(this.jdField_a_of_type_Afxp.b)));
      return;
    }
    zkp.b(this.jdField_a_of_type_Zkp).put(Integer.valueOf(this.jdField_a_of_type_Afxp.b), Integer.valueOf(paramInt2));
    zkp.c(this.jdField_a_of_type_Zkp).put(Integer.valueOf(this.jdField_a_of_type_Afxp.b), paramString);
    this.jdField_a_of_type_Afxp.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkr
 * JD-Core Version:    0.7.0.1
 */