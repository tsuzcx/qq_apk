import android.os.Handler;
import android.text.TextUtils;

class vcu
  implements uzu<uzb>
{
  vcu(vcp paramvcp, String paramString) {}
  
  public void a(uzb paramuzb)
  {
    if ((paramuzb.a != null) && (TextUtils.equals(paramuzb.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)))
    {
      vcp.a(this.jdField_a_of_type_Vcp).a = paramuzb.a;
      vcp.a(this.jdField_a_of_type_Vcp).sendMessage(vcp.a(this.jdField_a_of_type_Vcp).obtainMessage(0, vcp.a(this.jdField_a_of_type_Vcp)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */