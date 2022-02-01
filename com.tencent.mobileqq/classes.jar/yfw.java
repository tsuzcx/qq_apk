import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class yfw
  extends yjc
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private yfy jdField_a_of_type_Yfy;
  private yfz jdField_a_of_type_Yfz;
  private yga jdField_a_of_type_Yga;
  private ygb jdField_a_of_type_Ygb;
  private ygc jdField_a_of_type_Ygc;
  private yiy jdField_a_of_type_Yiy;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public yfw(int paramInt, @NonNull yjl paramyjl, @NonNull yfy paramyfy, boolean paramBoolean)
  {
    super(paramInt, paramyjl, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yfy = paramyfy;
  }
  
  private void a(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void b(boolean paramBoolean)
  {
    yqp.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    wzf localwzf = new wzf();
    localwzf.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    wlb.a().a(localwzf, new yfx(this, paramBoolean));
  }
  
  private void f()
  {
    yqp.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Yiy == null) || (this.jdField_a_of_type_Yfz == null))
    {
      yqp.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Yiy, this.jdField_a_of_type_Yfz });
      return;
    }
    if ((this.jdField_a_of_type_Yiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Yfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      yqp.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Yiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Yfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Yfy.a(false);
      return;
    }
    yqp.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Yfz.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Yiy);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Ygc = new ygc(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ygc);
    this.jdField_a_of_type_Ygb = new ygb(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ygb);
    this.jdField_a_of_type_Yga = new yga(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yga);
  }
  
  public void a(yiy paramyiy)
  {
    if (!paramyiy.d) {}
    for (boolean bool = true;; bool = false)
    {
      yqp.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramyiy));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    yqp.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((woz)wpm.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Yiy = null;
    this.jdField_a_of_type_Yfz = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ygc);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ygb);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yga);
  }
  
  public void b(yiy paramyiy)
  {
    super.a(paramyiy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfw
 * JD-Core Version:    0.7.0.1
 */