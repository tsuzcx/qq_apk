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

public class utk
  extends uwq
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private utm jdField_a_of_type_Utm;
  private utn jdField_a_of_type_Utn;
  private uto jdField_a_of_type_Uto;
  private utp jdField_a_of_type_Utp;
  private utq jdField_a_of_type_Utq;
  private uwm jdField_a_of_type_Uwm;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public utk(int paramInt, @NonNull uwz paramuwz, @NonNull utm paramutm, boolean paramBoolean)
  {
    super(paramInt, paramuwz, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Utm = paramutm;
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
    ved.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    tms localtms = new tms();
    localtms.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    syo.a().a(localtms, new utl(this, paramBoolean));
  }
  
  private void f()
  {
    ved.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Uwm == null) || (this.jdField_a_of_type_Utn == null))
    {
      ved.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Uwm, this.jdField_a_of_type_Utn });
      return;
    }
    if ((this.jdField_a_of_type_Uwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Utn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      ved.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Uwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Utn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Utm.a(false);
      return;
    }
    ved.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Utn.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Uwm);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Utq = new utq(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Utq);
    this.jdField_a_of_type_Utp = new utp(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Utp);
    this.jdField_a_of_type_Uto = new uto(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Uto);
  }
  
  public void a(uwm paramuwm)
  {
    if (!paramuwm.d) {}
    for (boolean bool = true;; bool = false)
    {
      ved.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramuwm));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ved.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((tcm)tcz.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Uwm = null;
    this.jdField_a_of_type_Utn = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Utq);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Utp);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uto);
  }
  
  public void b(uwm paramuwm)
  {
    super.a(paramuwm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */