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

public class xlc
  extends xoi
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private xle jdField_a_of_type_Xle;
  private xlf jdField_a_of_type_Xlf;
  private xlg jdField_a_of_type_Xlg;
  private xlh jdField_a_of_type_Xlh;
  private xli jdField_a_of_type_Xli;
  private xoe jdField_a_of_type_Xoe;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public xlc(int paramInt, @NonNull xor paramxor, @NonNull xle paramxle, boolean paramBoolean)
  {
    super(paramInt, paramxor, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Xle = paramxle;
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
    xvv.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    weq localweq = new weq();
    localweq.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    vqn.a().a(localweq, new xld(this, paramBoolean));
  }
  
  private void f()
  {
    xvv.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Xoe == null) || (this.jdField_a_of_type_Xlf == null))
    {
      xvv.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Xoe, this.jdField_a_of_type_Xlf });
      return;
    }
    if ((this.jdField_a_of_type_Xoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Xlf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      xvv.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Xoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Xlf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Xle.a(false);
      return;
    }
    xvv.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Xlf.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Xoe);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Xli = new xli(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xli);
    this.jdField_a_of_type_Xlh = new xlh(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xlh);
    this.jdField_a_of_type_Xlg = new xlg(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xlg);
  }
  
  public void a(xoe paramxoe)
  {
    if (!paramxoe.d) {}
    for (boolean bool = true;; bool = false)
    {
      xvv.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramxoe));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    xvv.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((vuk)vux.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Xoe = null;
    this.jdField_a_of_type_Xlf = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xli);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xlh);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xlg);
  }
  
  public void b(xoe paramxoe)
  {
    super.a(paramxoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlc
 * JD-Core Version:    0.7.0.1
 */