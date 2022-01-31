import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class whs
  implements IEventReceiver
{
  public int a;
  public ErrorMessage a;
  public String a;
  public ArrayList<VideoCollectionItem> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wht jdField_a_of_type_Wht;
  private whu jdField_a_of_type_Whu;
  private whv jdField_a_of_type_Whv;
  private whw jdField_a_of_type_Whw;
  private wit jdField_a_of_type_Wit = new wit();
  public boolean a;
  public boolean b = true;
  
  public whs(String paramString, @NonNull whv paramwhv)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Whv = paramwhv;
  }
  
  private void a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramVideoCollectionItem) > 0) {
      wsv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    do
    {
      return;
      i = Collections.binarySearch(this.jdField_a_of_type_JavaUtilArrayList, paramVideoCollectionItem, this.jdField_a_of_type_Wit);
    } while (i >= 0);
    int i = -i;
    this.jdField_a_of_type_JavaUtilArrayList.add(i - 1, paramVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem2 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      VideoCollectionItem localVideoCollectionItem1;
      if (localVideoCollectionItem2.isEmptyFakeItem)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
        {
          localVideoCollectionItem1 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
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
  
  public void a()
  {
    this.jdField_a_of_type_Wht = new wht(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wht);
    this.jdField_a_of_type_Whu = new whu(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Whu);
  }
  
  public void a(String paramString)
  {
    wsv.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request video info list.");
    this.jdField_a_of_type_Whw.a(paramString);
  }
  
  public void a(List<String> paramList)
  {
    wsv.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request visit count.");
    this.jdField_a_of_type_Whw.b(paramList, true);
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((VideoCollectionItem)paramList.next());
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramBoolean2))
    {
      paramList = ((usd)urr.a(2)).b(this.jdField_a_of_type_JavaLangString);
      if ((paramList != null) && (!paramList.isMe()) && (!paramList.isFriend()) && (!paramList.isVip))
      {
        paramList = new VideoCollectionItem();
        paramList.collectionType = 8;
        paramList.collectionId = "";
        paramList.collectionTime = -1L;
        paramList.key = "local_desc_item";
        paramList.isEmptyFakeItem = true;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    wsv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request refresh video collection data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (this.jdField_a_of_type_Whw == null)
    {
      this.jdField_a_of_type_Whw = new whw(this.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()));
      this.jdField_a_of_type_Whw.a();
    }
    if (paramBoolean)
    {
      uyb localuyb = this.jdField_a_of_type_Whw.a();
      a(localuyb.jdField_a_of_type_JavaUtilList, localuyb.c, localuyb.jdField_a_of_type_Boolean);
      this.b = localuyb.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      wsv.a("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "get video collection data from cache: collectionList.size() = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      return;
    }
    this.jdField_a_of_type_Whw.d();
  }
  
  public void b()
  {
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wht);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Whu);
    if (this.jdField_a_of_type_Whw != null) {
      this.jdField_a_of_type_Whw.b();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void c()
  {
    wsv.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request load next page video collection.");
    this.jdField_a_of_type_Whw.a(a());
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whs
 * JD-Core Version:    0.7.0.1
 */