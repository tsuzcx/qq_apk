import com.tencent.biz.qqcircle.report.QCircleReportBean;
import java.util.List;

public abstract class vbk
  extends aabd
  implements aabg<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  public vbk() {}
  
  public vbk(int paramInt1, List<aabp> paramList, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramList, paramInt2, paramInt3);
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
    return QCircleReportBean.getParentPageId(a(), this.a);
  }
  
  protected String b()
  {
    if (this.a != null) {
      return this.a.getModuleIdStr();
    }
    return null;
  }
  
  public int c()
  {
    return QCircleReportBean.getPageId(a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbk
 * JD-Core Version:    0.7.0.1
 */