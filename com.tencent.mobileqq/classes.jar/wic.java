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

public class wic
  extends wli
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private wie jdField_a_of_type_Wie;
  private wif jdField_a_of_type_Wif;
  private wig jdField_a_of_type_Wig;
  private wih jdField_a_of_type_Wih;
  private wii jdField_a_of_type_Wii;
  private wle jdField_a_of_type_Wle;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public wic(int paramInt, @NonNull wlr paramwlr, @NonNull wie paramwie, boolean paramBoolean)
  {
    super(paramInt, paramwlr, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wie = paramwie;
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
    wsv.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    vbk localvbk = new vbk();
    localvbk.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    ung.a().a(localvbk, new wid(this, paramBoolean));
  }
  
  private void f()
  {
    wsv.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Wle == null) || (this.jdField_a_of_type_Wif == null))
    {
      wsv.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Wle, this.jdField_a_of_type_Wif });
      return;
    }
    if ((this.jdField_a_of_type_Wle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      wsv.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Wle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Wie.a(false);
      return;
    }
    wsv.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Wif.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Wle);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Wii = new wii(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wii);
    this.jdField_a_of_type_Wih = new wih(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wih);
    this.jdField_a_of_type_Wig = new wig(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wig);
  }
  
  public void a(wle paramwle)
  {
    if (!paramwle.d) {}
    for (boolean bool = true;; bool = false)
    {
      wsv.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramwle));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    wsv.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((ure)urr.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Wle = null;
    this.jdField_a_of_type_Wif = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wii);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wih);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wig);
  }
  
  public void b(wle paramwle)
  {
    super.a(paramwle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wic
 * JD-Core Version:    0.7.0.1
 */