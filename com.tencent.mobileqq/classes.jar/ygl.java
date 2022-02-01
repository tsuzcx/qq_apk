import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ygl
  implements www
{
  private ygm a;
  
  public String a(long paramLong)
  {
    return ((wpy)wpm.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      yqp.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    yqp.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new wqt("", paramString);
    new wwv(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(wwx paramwwx)
  {
    if (!TextUtils.equals(paramwwx.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      yqp.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramwwx = paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramwwx = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramwwx));
      return;
    }
  }
  
  public void a(ygm paramygm)
  {
    this.a = paramygm;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      yqp.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    yqp.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    wqt localwqt = new wqt(String.valueOf(paramLong), "");
    new wwv(this).a(0, localwqt, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */