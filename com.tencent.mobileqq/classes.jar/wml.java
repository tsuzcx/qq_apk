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

public class wml
  extends wpr
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private wmn jdField_a_of_type_Wmn;
  private wmo jdField_a_of_type_Wmo;
  private wmp jdField_a_of_type_Wmp;
  private wmq jdField_a_of_type_Wmq;
  private wmr jdField_a_of_type_Wmr;
  private wpn jdField_a_of_type_Wpn;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public wml(int paramInt, @NonNull wqa paramwqa, @NonNull wmn paramwmn, boolean paramBoolean)
  {
    super(paramInt, paramwqa, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wmn = paramwmn;
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
    wxe.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    vft localvft = new vft();
    localvft.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    urp.a().a(localvft, new wmm(this, paramBoolean));
  }
  
  private void f()
  {
    wxe.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Wpn == null) || (this.jdField_a_of_type_Wmo == null))
    {
      wxe.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Wpn, this.jdField_a_of_type_Wmo });
      return;
    }
    if ((this.jdField_a_of_type_Wpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Wmo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      wxe.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Wpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Wmo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Wmn.a(false);
      return;
    }
    wxe.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Wmo.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Wpn);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Wmr = new wmr(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wmr);
    this.jdField_a_of_type_Wmq = new wmq(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wmq);
    this.jdField_a_of_type_Wmp = new wmp(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wmp);
  }
  
  public void a(wpn paramwpn)
  {
    if (!paramwpn.d) {}
    for (boolean bool = true;; bool = false)
    {
      wxe.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramwpn));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    wxe.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((uvn)uwa.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Wpn = null;
    this.jdField_a_of_type_Wmo = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wmr);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wmq);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wmp);
  }
  
  public void b(wpn paramwpn)
  {
    super.a(paramwpn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wml
 * JD-Core Version:    0.7.0.1
 */