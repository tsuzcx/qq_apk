import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class qtr
  implements IEventReceiver
{
  private VideoCollectionItem.a jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$a = new VideoCollectionItem.a();
  private qtr.a jdField_a_of_type_Qtr$a;
  private qtr.b jdField_a_of_type_Qtr$b;
  private qtr.c jdField_a_of_type_Qtr$c;
  private qts jdField_a_of_type_Qts;
  public boolean aFs;
  public boolean aFt = true;
  public int boa = -1;
  public ErrorMessage l;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public String mUid;
  public ArrayList<VideoCollectionItem> nh = new ArrayList();
  
  public qtr(String paramString, @NonNull qtr.c paramc)
  {
    this.mUid = paramString;
    this.jdField_a_of_type_Qtr$c = paramc;
  }
  
  private void b(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.nh.indexOf(paramVideoCollectionItem) > 0) {
      ram.d("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    do
    {
      return;
      i = Collections.binarySearch(this.nh, paramVideoCollectionItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$a);
    } while (i >= 0);
    int i = -i;
    this.nh.add(i - 1, paramVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (this.nh.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem2 = (VideoCollectionItem)this.nh.get(this.nh.size() - 1);
      VideoCollectionItem localVideoCollectionItem1;
      if (localVideoCollectionItem2.isEmptyFakeItem)
      {
        if (this.nh.size() >= 2)
        {
          localVideoCollectionItem1 = (VideoCollectionItem)this.nh.get(this.nh.size() - 2);
          if (TextUtils.isEmpty(localVideoCollectionItem1.collectionId)) {}
        }
      }
      else {
        do
        {
          return localVideoCollectionItem1;
          localVideoCollectionItem1 = localVideoCollectionItem2;
        } while (!TextUtils.isEmpty(localVideoCollectionItem2.collectionId));
      }
    }
    return null;
  }
  
  public void bqD()
  {
    ram.i("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request load next page video collection.");
    this.jdField_a_of_type_Qts.c(a());
  }
  
  public void create()
  {
    this.jdField_a_of_type_Qtr$a = new qtr.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtr$a);
    this.jdField_a_of_type_Qtr$b = new qtr.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtr$b);
  }
  
  public void destroy()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtr$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtr$b);
    if (this.jdField_a_of_type_Qts != null) {
      this.jdField_a_of_type_Qts.onStop();
    }
    this.mIsDestroy.set(true);
  }
  
  public void eA(List<String> paramList)
  {
    ram.i("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request visit count.");
    this.jdField_a_of_type_Qts.M(paramList, true);
  }
  
  public void f(List<VideoCollectionItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.nh.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((VideoCollectionItem)paramList.next());
    }
    if ((this.nh.size() > 0) && (paramBoolean2))
    {
      paramList = ((ptf)psx.a(2)).b(this.mUid);
      if ((paramList != null) && (!paramList.isMe()) && (!paramList.isFriend()) && (!paramList.isVip))
      {
        paramList = new VideoCollectionItem();
        paramList.collectionType = 8;
        paramList.collectionId = "";
        paramList.collectionTime = -1L;
        paramList.key = "local_desc_item";
        paramList.isEmptyFakeItem = true;
        this.nh.add(paramList);
      }
    }
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void rZ(String paramString)
  {
    ram.i("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request video info list.");
    this.jdField_a_of_type_Qts.rZ(paramString);
  }
  
  public void refreshData(boolean paramBoolean)
  {
    ram.d("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request refresh video collection data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (this.jdField_a_of_type_Qts == null)
    {
      this.jdField_a_of_type_Qts = new qts(this.mUid, String.valueOf(hashCode()));
      this.jdField_a_of_type_Qts.onStart();
    }
    if (paramBoolean)
    {
      pxg.b localb = this.jdField_a_of_type_Qts.a();
      f(localb.mL, localb.isFirstPage, localb.isEnd);
      this.aFt = localb.isEnd;
      if (this.nh.size() > 0) {
        this.aFs = true;
      }
      ram.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "get video collection data from cache: collectionList.size() = %d.", Integer.valueOf(this.nh.size()));
      return;
    }
    this.jdField_a_of_type_Qts.bqF();
  }
  
  static class a
    extends QQUIEventReceiver<qtr, pxg.b>
  {
    public a(@NonNull qtr paramqtr)
    {
      super();
    }
    
    public void a(@NonNull qtr paramqtr, @NonNull pxg.b paramb)
    {
      if (!TextUtils.equals(String.valueOf(paramqtr.hashCode()), paramb.context)) {
        return;
      }
      ram.d("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramb);
      if (paramb.b.isSuccess())
      {
        if (paramb.blh != -1) {
          paramqtr.boa = paramb.blh;
        }
        paramqtr.aFs = true;
        paramqtr.l = null;
        if (paramb.isUpdated)
        {
          paramqtr.f(paramb.mL, paramb.isFirstPage, paramb.isEnd);
          paramqtr.aFt = paramb.isEnd;
        }
      }
      for (;;)
      {
        qtr.a(paramqtr).tq(paramb.b.isSuccess());
        return;
        paramqtr.l = paramb.b;
      }
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
  }
  
  static class b
    extends QQUIEventReceiver<qtr, pye.a>
  {
    public b(@NonNull qtr paramqtr)
    {
      super();
    }
    
    public void a(@NonNull qtr paramqtr, @NonNull pye.a parama)
    {
      ram.d("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", parama.toString());
      if (parama.b.isSuccess()) {
        qtr.a(paramqtr).m(parama.collectionId, parama.nb);
      }
    }
    
    public Class acceptEventClass()
    {
      return pye.a.class;
    }
  }
  
  public static abstract interface c
  {
    public abstract void m(String paramString, List<VideoCollectionItem.b> paramList);
    
    public abstract void tq(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */