import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uhg
  implements sxq
{
  private uhh a;
  
  public String a(long paramLong)
  {
    return ((sqs)sqg.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      urk.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    urk.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new srn("", paramString);
    new sxp(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(sxr paramsxr)
  {
    if (!TextUtils.equals(paramsxr.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      urk.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramsxr = paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramsxr = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramsxr));
      return;
    }
  }
  
  public void a(uhh paramuhh)
  {
    this.a = paramuhh;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      urk.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    urk.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    srn localsrn = new srn(String.valueOf(paramLong), "");
    new sxp(this).a(0, localsrn, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhg
 * JD-Core Version:    0.7.0.1
 */