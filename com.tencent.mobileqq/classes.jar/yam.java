import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class yam
  implements wrc
{
  private yan a;
  
  public String a(long paramLong)
  {
    return ((wke)wjs.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ykq.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    ykq.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new wkz("", paramString);
    new wrb(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(wrd paramwrd)
  {
    if (!TextUtils.equals(paramwrd.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      ykq.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramwrd = paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramwrd = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramwrd));
      return;
    }
  }
  
  public void a(yan paramyan)
  {
    this.a = paramyan;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ykq.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    ykq.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    wkz localwkz = new wkz(String.valueOf(paramLong), "");
    new wrb(this).a(0, localwkz, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yam
 * JD-Core Version:    0.7.0.1
 */