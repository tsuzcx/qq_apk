import android.os.Bundle;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public abstract class uzx
  extends zyu
  implements zxl<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  public uzx(Bundle paramBundle)
  {
    super(paramBundle);
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
    return QCircleReportBean.getPageId(a(), this.a);
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
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */