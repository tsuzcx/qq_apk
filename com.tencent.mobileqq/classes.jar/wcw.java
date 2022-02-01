import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;

public abstract class wcw<T>
  implements aabg<QCircleReportBean>
{
  protected int a;
  protected View a;
  protected QCircleReportBean a;
  public ReportExtraTypeInfo a;
  private QCircleInsFeedItemView a;
  protected ExtraTypeInfo a;
  public T a;
  protected var a;
  
  public wcw()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public QCircleInsFeedItemView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleInsFeedItemView;
  }
  
  public FeedCloudMeta.StFeed a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) {
      return (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  protected abstract String a();
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(QCircleInsFeedItemView paramQCircleInsFeedItemView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleInsFeedItemView = paramQCircleInsFeedItemView;
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(var paramvar)
  {
    this.jdField_a_of_type_Var = paramvar;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      String str = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("qcircle_fakeid_"))) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, 2131697318, 0).a();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcw
 * JD-Core Version:    0.7.0.1
 */