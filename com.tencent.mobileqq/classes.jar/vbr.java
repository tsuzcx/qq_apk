import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.qphone.base.util.QLog;

public class vbr
  implements CustomAccessibilityDelegate.CallBack
{
  public vbr(FileItemBuilder paramFileItemBuilder, vbs paramvbs) {}
  
  public void a()
  {
    QLog.e("ACCESS_SILAS", 1, "onViewFocus");
    this.jdField_a_of_type_Vbs.e = 0;
  }
  
  public void b()
  {
    QLog.e("ACCESS_SILAS", 1, "onViewFocusClear");
    this.jdField_a_of_type_Vbs.e = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbr
 * JD-Core Version:    0.7.0.1
 */