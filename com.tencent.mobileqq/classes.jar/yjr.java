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

public class yjr
  extends ymx
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private yjt jdField_a_of_type_Yjt;
  private yju jdField_a_of_type_Yju;
  private yjv jdField_a_of_type_Yjv;
  private yjw jdField_a_of_type_Yjw;
  private yjx jdField_a_of_type_Yjx;
  private ymt jdField_a_of_type_Ymt;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public yjr(int paramInt, @NonNull yng paramyng, @NonNull yjt paramyjt, boolean paramBoolean)
  {
    super(paramInt, paramyng, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yjt = paramyjt;
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
    yuk.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    xda localxda = new xda();
    localxda.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    wow.a().a(localxda, new yjs(this, paramBoolean));
  }
  
  private void f()
  {
    yuk.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Ymt == null) || (this.jdField_a_of_type_Yju == null))
    {
      yuk.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Ymt, this.jdField_a_of_type_Yju });
      return;
    }
    if ((this.jdField_a_of_type_Ymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Yju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      yuk.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Ymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Yju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Yjt.a(false);
      return;
    }
    yuk.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Yju.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Ymt);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Yjx = new yjx(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjx);
    this.jdField_a_of_type_Yjw = new yjw(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjw);
    this.jdField_a_of_type_Yjv = new yjv(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjv);
  }
  
  public void a(ymt paramymt)
  {
    if (!paramymt.d) {}
    for (boolean bool = true;; bool = false)
    {
      yuk.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramymt));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    yuk.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((wsu)wth.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ymt = null;
    this.jdField_a_of_type_Yju = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjx);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjw);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjv);
  }
  
  public void b(ymt paramymt)
  {
    super.a(paramymt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */