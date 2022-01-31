import android.content.Context;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class xwl
  implements Manager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private xwn jdField_a_of_type_Xwn;
  
  public xwl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Xwn != null) {
      this.jdField_a_of_type_Xwn.a();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Xwn != null) {
      this.jdField_a_of_type_Xwn.b();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xwn != null)
    {
      this.jdField_a_of_type_Xwn.c();
      this.jdField_a_of_type_Xwn = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 2: 
      b();
      return;
    case 3: 
      c();
      return;
    }
    a();
  }
  
  public void a(Context paramContext, ScannerParams paramScannerParams)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramScannerParams.f) && (!paramScannerParams.d) && (this.jdField_a_of_type_Xwn == null)) {
      this.jdField_a_of_type_Xwn = new xwn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onDestroy()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwl
 * JD-Core Version:    0.7.0.1
 */