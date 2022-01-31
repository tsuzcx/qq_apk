import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wgl
  implements wfi
{
  public int a;
  public String a;
  public WeakReference<QRDisplayActivity> a;
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    QRDisplayActivity localQRDisplayActivity;
    do
    {
      do
      {
        return;
        localQRDisplayActivity = (QRDisplayActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localQRDisplayActivity == null);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, String.format("onReceive qrcode url:%s suc:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      }
    } while ((localQRDisplayActivity.b) || (localQRDisplayActivity.isFinishing()));
    if (!paramBoolean)
    {
      localQRDisplayActivity.g();
      return;
    }
    localQRDisplayActivity.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = wij.a(paramString, -1);
    if (paramString != null)
    {
      localQRDisplayActivity.a = paramString;
      localQRDisplayActivity.f();
      return;
    }
    localQRDisplayActivity.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wgl
 * JD-Core Version:    0.7.0.1
 */