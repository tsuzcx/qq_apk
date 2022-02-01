import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ykg
  implements xar
{
  private ykh a;
  
  public String a(long paramLong)
  {
    return ((wtt)wth.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      yuk.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    yuk.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new wuo("", paramString);
    new xaq(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(xas paramxas)
  {
    if (!TextUtils.equals(paramxas.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      yuk.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramxas = paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramxas = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramxas));
      return;
    }
  }
  
  public void a(ykh paramykh)
  {
    this.a = paramykh;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      yuk.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    yuk.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    wuo localwuo = new wuo(String.valueOf(paramLong), "");
    new xaq(this).a(0, localwuo, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykg
 * JD-Core Version:    0.7.0.1
 */