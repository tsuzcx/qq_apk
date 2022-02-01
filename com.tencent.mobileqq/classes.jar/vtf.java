import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.List;
import mqq.manager.Manager;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vtf
  implements Manager, vte
{
  private static boolean jdField_a_of_type_Boolean;
  private final vtc jdField_a_of_type_Vtc;
  private vte jdField_a_of_type_Vte;
  private final vti jdField_a_of_type_Vti;
  
  public vtf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Vtc = new vtc(paramQQAppInterface);
    this.jdField_a_of_type_Vti = new vti(paramQQAppInterface);
    boolean bool1 = QzoneConfig.isEeveeSysTemPolling();
    boolean bool2 = QzoneConfig.isQQCircleUseEeveeRedPoint();
    this.jdField_a_of_type_Vte = this.jdField_a_of_type_Vtc;
    jdField_a_of_type_Boolean = true;
    QLog.e("QCircleRedPointManager", 1, "isQQCircleCurrentUseEeveeRedPoint: " + jdField_a_of_type_Boolean + ", ( isEeveeSysTemPolling: " + bool1 + ", isQQCircleUseEeveeRedPoint: " + bool2 + " )");
  }
  
  private vte a()
  {
    return this.jdField_a_of_type_Vte;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public QQCircleCounter.RedPointInfo a(String paramString)
  {
    return a().a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vtc.a();
    this.jdField_a_of_type_Vti.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Vtc.a(paramString);
    this.jdField_a_of_type_Vti.a(paramString);
  }
  
  public void a(String paramString, List<Integer> paramList)
  {
    this.jdField_a_of_type_Vtc.a(paramString, paramList);
    this.jdField_a_of_type_Vti.a(paramString, paramList);
  }
  
  public void a(String paramString, vtg paramvtg, boolean paramBoolean)
  {
    a().a(paramString, paramvtg, paramBoolean);
  }
  
  public void a(String paramString, vth paramvth)
  {
    this.jdField_a_of_type_Vtc.a(paramString, paramvth);
    this.jdField_a_of_type_Vti.a(paramString, paramvth);
  }
  
  public QQCircleCounter.RedPointInfo b(String paramString)
  {
    return a().b(paramString);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Vtc.b(paramString);
    this.jdField_a_of_type_Vti.b(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Vtc.onDestroy();
    this.jdField_a_of_type_Vti.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtf
 * JD-Core Version:    0.7.0.1
 */