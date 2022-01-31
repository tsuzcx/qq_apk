import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wir
  implements uzb
{
  private wis a;
  
  public String a(long paramLong)
  {
    return ((usd)urr.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wsv.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    wsv.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new usy("", paramString);
    new uza(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(uzc paramuzc)
  {
    if (!TextUtils.equals(paramuzc.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      wsv.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramuzc = paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramuzc = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramuzc));
      return;
    }
  }
  
  public void a(wis paramwis)
  {
    this.a = paramwis;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      wsv.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    wsv.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    usy localusy = new usy(String.valueOf(paramLong), "");
    new uza(this).a(0, localusy, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wir
 * JD-Core Version:    0.7.0.1
 */