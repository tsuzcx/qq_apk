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

public class ugr
  extends ujx
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private ugt jdField_a_of_type_Ugt;
  private ugu jdField_a_of_type_Ugu;
  private ugv jdField_a_of_type_Ugv;
  private ugw jdField_a_of_type_Ugw;
  private ugx jdField_a_of_type_Ugx;
  private ujt jdField_a_of_type_Ujt;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public ugr(int paramInt, @NonNull ukg paramukg, @NonNull ugt paramugt, boolean paramBoolean)
  {
    super(paramInt, paramukg, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ugt = paramugt;
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
    urk.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    szz localszz = new szz();
    localszz.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    slv.a().a(localszz, new ugs(this, paramBoolean));
  }
  
  private void f()
  {
    urk.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Ujt == null) || (this.jdField_a_of_type_Ugu == null))
    {
      urk.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Ujt, this.jdField_a_of_type_Ugu });
      return;
    }
    if ((this.jdField_a_of_type_Ujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Ugu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      urk.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Ujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Ugu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Ugt.a(false);
      return;
    }
    urk.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Ugu.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Ujt);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Ugx = new ugx(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugx);
    this.jdField_a_of_type_Ugw = new ugw(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugw);
    this.jdField_a_of_type_Ugv = new ugv(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugv);
  }
  
  public void a(ujt paramujt)
  {
    if (!paramujt.d) {}
    for (boolean bool = true;; bool = false)
    {
      urk.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramujt));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    urk.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((spt)sqg.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ujt = null;
    this.jdField_a_of_type_Ugu = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugx);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugw);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugv);
  }
  
  public void b(ujt paramujt)
  {
    super.a(paramujt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugr
 * JD-Core Version:    0.7.0.1
 */