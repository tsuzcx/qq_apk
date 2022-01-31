import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class pz
  implements QRCodeEncodeCallback
{
  pz(py parampy, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 2, "onReceive qrcode url: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Py.a.b) || (this.jdField_a_of_type_Py.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Py.a.d();
      return;
    }
    this.jdField_a_of_type_Py.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.jdField_a_of_type_Py.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramString;
      this.jdField_a_of_type_Py.a.c();
      return;
    }
    this.jdField_a_of_type_Py.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     pz
 * JD-Core Version:    0.7.0.1
 */