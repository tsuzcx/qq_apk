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

public class utn
  extends uwt
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private utp jdField_a_of_type_Utp;
  private utq jdField_a_of_type_Utq;
  private utr jdField_a_of_type_Utr;
  private uts jdField_a_of_type_Uts;
  private utt jdField_a_of_type_Utt;
  private uwp jdField_a_of_type_Uwp;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public utn(int paramInt, @NonNull uxc paramuxc, @NonNull utp paramutp, boolean paramBoolean)
  {
    super(paramInt, paramuxc, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Utp = paramutp;
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
    veg.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    tmv localtmv = new tmv();
    localtmv.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    syr.a().a(localtmv, new uto(this, paramBoolean));
  }
  
  private void f()
  {
    veg.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Uwp == null) || (this.jdField_a_of_type_Utq == null))
    {
      veg.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Uwp, this.jdField_a_of_type_Utq });
      return;
    }
    if ((this.jdField_a_of_type_Uwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Utq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      veg.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Uwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Utq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Utp.a(false);
      return;
    }
    veg.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Utq.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Uwp);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Utt = new utt(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Utt);
    this.jdField_a_of_type_Uts = new uts(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Uts);
    this.jdField_a_of_type_Utr = new utr(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Utr);
  }
  
  public void a(uwp paramuwp)
  {
    if (!paramuwp.d) {}
    for (boolean bool = true;; bool = false)
    {
      veg.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramuwp));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    veg.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((tcp)tdc.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Uwp = null;
    this.jdField_a_of_type_Utq = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Utt);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uts);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Utr);
  }
  
  public void b(uwp paramuwp)
  {
    super.a(paramuwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utn
 * JD-Core Version:    0.7.0.1
 */