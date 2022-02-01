import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class xlr
  implements wch
{
  private xls a;
  
  public String a(long paramLong)
  {
    return ((vvj)vux.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      xvv.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    xvv.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new vwe("", paramString);
    new wcg(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(wci paramwci)
  {
    if (!TextUtils.equals(paramwci.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      xvv.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramwci = paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramwci = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramwci));
      return;
    }
  }
  
  public void a(xls paramxls)
  {
    this.a = paramxls;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      xvv.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    xvv.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    vwe localvwe = new vwe(String.valueOf(paramLong), "");
    new wcg(this).a(0, localvwe, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlr
 * JD-Core Version:    0.7.0.1
 */