import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class uxx
  extends uxw
  implements uni<vav, vct>
{
  protected String a;
  protected uya a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public uxx(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = a(this.jdField_b_of_type_JavaLangString);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  private void d()
  {
    int i = xod.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Uya.jdField_a_of_type_Int != i)
    {
      wsv.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Uya.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (ure)urr.a(19);
      localMemoryInfoEntry = ((ure)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Uya.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Uya.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new vav();
      ((vav)localObject).c = 10;
      ((vav)localObject).d = 10;
      ((vav)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((vav)localObject).jdField_b_of_type_Long = l;
      ((vav)localObject).e = this.jdField_a_of_type_Uya.jdField_a_of_type_Int;
      ((vav)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((ure)urr.a(19)).a(this.d);
      if (localMemoryInfoEntry != null) {
        if (localMemoryInfoEntry.isFriend != 1) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((vav)localObject).jdField_a_of_type_Boolean = bool;
      ung.a().a((unk)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((ure)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new uxy(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull vav paramvav, @Nullable vct paramvct, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvav.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      wsv.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramvav.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    ure localure = (ure)urr.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localure.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramvav.jdField_a_of_type_JavaLangString);
      uyb localuyb = new uyb(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localuyb.jdField_b_of_type_JavaLangString = paramvav.jdField_b_of_type_JavaLangString;
      localuyb.c = bool2;
      localuyb.jdField_b_of_type_Boolean = false;
      if ((paramvct == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        uht.a().dispatch(localuyb);
        return;
      }
      int i;
      boolean bool1;
      label231:
      Object localObject1;
      label293:
      label312:
      long l;
      Object localObject2;
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramvct.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramvct.c;
        localuyb.jdField_a_of_type_Boolean = paramvct.jdField_a_of_type_Boolean;
        localuyb.jdField_a_of_type_JavaUtilList = paramvct.jdField_a_of_type_JavaUtilArrayList;
        localuyb.jdField_a_of_type_Int = paramvct.b;
        if ((paramvct.jdField_a_of_type_Long == paramvav.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localuyb.e = bool1;
        if (!localuyb.e) {
          break label524;
        }
        localObject1 = paramvct.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new wit());
          localure.a((List)localObject1, paramvav.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramvct.jdField_a_of_type_JavaLangString;
        if (!paramvct.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Uya.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Uya.jdField_a_of_type_JavaLangString;
        if (!paramvct.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramvav = "true";; paramvav = "false")
      {
        wsv.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramvav);
        paramvav = (wkp)urr.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramvct = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramvav.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramvct.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramvct.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramvav.a(paramvct);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramvav = localure.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Uya.a(paramvav);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Uya.jdField_a_of_type_JavaLangString;
      uht.a().dispatch(localuyb);
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new uxz(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */