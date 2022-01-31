import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class bsi
  implements QRCodeEncodeCallback
{
  bsi(bsh parambsh, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 2, "onReceive qrcode url: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Bsh.a.b) || (this.jdField_a_of_type_Bsh.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Bsh.a.e();
      return;
    }
    this.jdField_a_of_type_Bsh.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.jdField_a_of_type_Bsh.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramString;
      this.jdField_a_of_type_Bsh.a.d();
      return;
    }
    this.jdField_a_of_type_Bsh.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bsi
 * JD-Core Version:    0.7.0.1
 */