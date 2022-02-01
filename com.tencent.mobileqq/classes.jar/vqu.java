import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.manager.Manager;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vqu
  implements Manager, vqt
{
  private static boolean jdField_a_of_type_Boolean;
  private final vqr jdField_a_of_type_Vqr;
  private vqt jdField_a_of_type_Vqt;
  private final vqx jdField_a_of_type_Vqx;
  
  public vqu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Vqr = new vqr(paramQQAppInterface);
    this.jdField_a_of_type_Vqx = new vqx(paramQQAppInterface);
    boolean bool1 = QzoneConfig.isEeveeSysTemPolling();
    boolean bool2 = QzoneConfig.isQQCircleUseEeveeRedPoint();
    if ((bool1) && (bool2)) {
      this.jdField_a_of_type_Vqt = this.jdField_a_of_type_Vqr;
    }
    for (jdField_a_of_type_Boolean = true;; jdField_a_of_type_Boolean = false)
    {
      QLog.e("QCircleRedPointManager", 1, "isQQCircleCurrentUseEeveeRedPoint: " + jdField_a_of_type_Boolean + ", ( isEeveeSysTemPolling: " + bool1 + ", isQQCircleUseEeveeRedPoint: " + bool2 + " )");
      return;
      this.jdField_a_of_type_Vqt = this.jdField_a_of_type_Vqx;
    }
  }
  
  private vqt a()
  {
    return this.jdField_a_of_type_Vqt;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public QQCircleCounter.RedPointInfo a(String paramString)
  {
    return a().a(paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Vqr.b(paramString);
    this.jdField_a_of_type_Vqx.b(paramString);
  }
  
  public void a(String paramString, vqv paramvqv, boolean paramBoolean)
  {
    a().a(paramString, paramvqv, paramBoolean);
  }
  
  public void a(String paramString, vqw paramvqw)
  {
    this.jdField_a_of_type_Vqr.a(paramString, paramvqw);
    this.jdField_a_of_type_Vqx.a(paramString, paramvqw);
  }
  
  public QQCircleCounter.RedPointInfo b(String paramString)
  {
    return a().b(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Vqr.onDestroy();
    this.jdField_a_of_type_Vqx.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */