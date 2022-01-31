import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uuc
  implements tkm
{
  private uud a;
  
  public String a(long paramLong)
  {
    return ((tdo)tdc.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      veg.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    veg.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new tej("", paramString);
    new tkl(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public void a(tkn paramtkn)
  {
    if (!TextUtils.equals(paramtkn.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      veg.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
    }
    for (paramtkn = paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramtkn = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramtkn));
      return;
    }
  }
  
  public void a(uud paramuud)
  {
    this.a = paramuud;
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L)
    {
      veg.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    veg.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    tej localtej = new tej(String.valueOf(paramLong), "");
    new tkl(this).a(0, localtej, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */