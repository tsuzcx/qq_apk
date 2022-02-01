import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qud
  implements pxs.a
{
  private qud.a a;
  
  public void a(qud.a parama)
  {
    this.a = parama;
  }
  
  public String aE(long paramLong)
  {
    return ((ptf)psx.a(2)).i(String.valueOf(paramLong), false);
  }
  
  public void c(pxs.b paramb)
  {
    if (!TextUtils.equals(paramb.key, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramb.b.isSuccess()) && (paramb.c != null)) {
      ram.b("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramb.c.uid);
    }
    for (paramb = paramb.c.uid;; paramb = null)
    {
      ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramb));
      return;
    }
  }
  
  public void fm(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void fn(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ram.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    ram.b("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    QQUserUIItem.a locala = new QQUserUIItem.a(String.valueOf(paramLong), "");
    new pxs(this).a(0, locala, String.valueOf(hashCode()));
  }
  
  public void sb(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    ram.b("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new QQUserUIItem.a("", paramString);
    new pxs(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public static abstract interface a
  {
    public abstract void aB(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qud
 * JD-Core Version:    0.7.0.1
 */