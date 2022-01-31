import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class utz
  implements tkj
{
  private uua a;
  
  public String a(long paramLong)
  {
    return ((tdl)tcz.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ved.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    ved.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new teg("", paramString);
    new tki(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(tkk paramtkk)
  {
    if (!TextUtils.equals(paramtkk.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      ved.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramtkk = paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramtkk = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramtkk));
      return;
    }
  }
  
  public void a(uua paramuua)
  {
    this.a = paramuua;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ved.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    ved.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    teg localteg = new teg(String.valueOf(paramLong), "");
    new tki(this).a(0, localteg, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utz
 * JD-Core Version:    0.7.0.1
 */