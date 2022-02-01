import com.tencent.biz.qqcircle.report.QCircleReportBean;

public abstract class vbm
  extends aabe
  implements aabg<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  protected int a()
  {
    return QCircleReportBean.getParentPageId(a(), this.a);
  }
  
  public QCircleReportBean a()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.a.setModuleIdStr(b()));
  }
  
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
 * Qualified Name:     vbm
 * JD-Core Version:    0.7.0.1
 */