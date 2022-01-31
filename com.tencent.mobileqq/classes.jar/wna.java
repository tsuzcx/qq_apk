import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wna
  implements vdk
{
  private wnb a;
  
  public String a(long paramLong)
  {
    return ((uwm)uwa.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    wxe.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new uxh("", paramString);
    new vdj(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(vdl paramvdl)
  {
    if (!TextUtils.equals(paramvdl.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      wxe.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramvdl = paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramvdl = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramvdl));
      return;
    }
  }
  
  public void a(wnb paramwnb)
  {
    this.a = paramwnb;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      wxe.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    wxe.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    uxh localuxh = new uxh(String.valueOf(paramLong), "");
    new vdj(this).a(0, localuxh, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wna
 * JD-Core Version:    0.7.0.1
 */