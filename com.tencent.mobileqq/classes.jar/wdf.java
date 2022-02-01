import android.view.View;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class wdf
  implements wbl
{
  wdf(wdb paramwdb) {}
  
  public void a()
  {
    vtn.a("", this.a.a(), this.a.jdField_a_of_type_Int, 43, this.a.b());
    if ((this.a.jdField_a_of_type_Var != null) && ((this.a.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      vdq localvdq = new vdq();
      localvdq.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.a.jdField_a_of_type_JavaLangObject);
      localvdq.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localvdq.b = 1;
      this.a.jdField_a_of_type_Var.a(localvdq);
    }
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    vtn.a(paramStUser.id.get(), this.a.a(), this.a.jdField_a_of_type_Int, 41, this.a.b());
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(paramStUser);
    localQCircleInitBean.setFromReportBean(this.a.a().clone().setElementIdStr("portrait"));
    uyx.b(this.a.jdField_a_of_type_AndroidViewView.getContext(), localQCircleInitBean);
  }
  
  public void b()
  {
    vtn.a("", this.a.a(), this.a.jdField_a_of_type_Int, 42, this.a.b());
    if ((this.a.jdField_a_of_type_Var != null) && ((this.a.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      vdq localvdq = new vdq();
      localvdq.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.a.jdField_a_of_type_JavaLangObject);
      localvdq.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localvdq.b = 1;
      this.a.jdField_a_of_type_Var.a(localvdq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */