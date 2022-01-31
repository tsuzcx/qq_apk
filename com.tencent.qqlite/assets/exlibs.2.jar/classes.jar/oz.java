import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.AddFriendScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

public class oz
  implements QRCodeEncodeCallback
{
  public oz(AddFriendScannerActivity paramAddFriendScannerActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "onReceive qrcode url: " + paramBoolean);
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      return;
    }
    ScannerUtils.a(this.a.jdField_a_of_type_AndroidContentSharedPreferences, this.a.jdField_a_of_type_JavaLangString, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramString;
      this.a.b();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     oz
 * JD-Core Version:    0.7.0.1
 */