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

public class xzx
  extends ydd
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  public List<MomeriesYearNode> a;
  private xzz jdField_a_of_type_Xzz;
  private yaa jdField_a_of_type_Yaa;
  private yab jdField_a_of_type_Yab;
  private yac jdField_a_of_type_Yac;
  private yad jdField_a_of_type_Yad;
  private ycz jdField_a_of_type_Ycz;
  public boolean a;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public xzx(int paramInt, @NonNull ydm paramydm, @NonNull xzz paramxzz, boolean paramBoolean)
  {
    super(paramInt, paramydm, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Xzz = paramxzz;
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
    ykq.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    wtl localwtl = new wtl();
    localwtl.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    wfi.a().a(localwtl, new xzy(this, paramBoolean));
  }
  
  private void f()
  {
    ykq.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Ycz == null) || (this.jdField_a_of_type_Yaa == null))
    {
      ykq.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Ycz, this.jdField_a_of_type_Yaa });
      return;
    }
    if ((this.jdField_a_of_type_Ycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_Yaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      ykq.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Ycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_Yaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_Xzz.a(false);
      return;
    }
    ykq.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Yaa.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_Ycz);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Yad = new yad(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yad);
    this.jdField_a_of_type_Yac = new yac(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yac);
    this.jdField_a_of_type_Yab = new yab(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yab);
  }
  
  public void a(ycz paramycz)
  {
    if (!paramycz.d) {}
    for (boolean bool = true;; bool = false)
    {
      ykq.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramycz));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ykq.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((wjf)wjs.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ycz = null;
    this.jdField_a_of_type_Yaa = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yad);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yac);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yab);
  }
  
  public void b(ycz paramycz)
  {
    super.a(paramycz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzx
 * JD-Core Version:    0.7.0.1
 */