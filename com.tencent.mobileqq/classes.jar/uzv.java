import android.os.Bundle;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public abstract class uzv<E>
  extends zxu<E>
  implements zxl<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  public uzv(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected int a()
  {
    return QCircleReportBean.getPageId(a(), this.a);
  }
  
  public QCircleReportBean a()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.a.setModuleIdStr(b()));
  }
  
  protected abstract String a();
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  protected int b()
  {
    return QCircleReportBean.getParentPageId(a(), this.a);
  }
  
  protected String b()
  {
    if (this.a != null) {
      return this.a.getModuleIdStr();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzv
 * JD-Core Version:    0.7.0.1
 */