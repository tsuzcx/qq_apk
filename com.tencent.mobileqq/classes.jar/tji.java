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

public class tji
  extends tjh
  implements syt<tmg, toe>
{
  protected String a;
  protected tjl a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public tji(String paramString1, String paramString2)
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
    int i = vzo.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Tjl.jdField_a_of_type_Int != i)
    {
      veg.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Tjl.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (tcp)tdc.a(19);
      localMemoryInfoEntry = ((tcp)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Tjl.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Tjl.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new tmg();
      ((tmg)localObject).c = 10;
      ((tmg)localObject).d = 10;
      ((tmg)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((tmg)localObject).jdField_b_of_type_Long = l;
      ((tmg)localObject).e = this.jdField_a_of_type_Tjl.jdField_a_of_type_Int;
      ((tmg)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((tcp)tdc.a(19)).a(this.d);
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
      ((tmg)localObject).jdField_a_of_type_Boolean = bool;
      syr.a().a((syv)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((tcp)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new tjj(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull tmg paramtmg, @Nullable toe paramtoe, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtmg.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      veg.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramtmg.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    tcp localtcp = (tcp)tdc.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localtcp.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramtmg.jdField_a_of_type_JavaLangString);
      tjm localtjm = new tjm(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localtjm.jdField_b_of_type_JavaLangString = paramtmg.jdField_b_of_type_JavaLangString;
      localtjm.c = bool2;
      localtjm.jdField_b_of_type_Boolean = false;
      if ((paramtoe == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        ste.a().dispatch(localtjm);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramtoe.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramtoe.c;
        localtjm.jdField_a_of_type_Boolean = paramtoe.jdField_a_of_type_Boolean;
        localtjm.jdField_a_of_type_JavaUtilList = paramtoe.jdField_a_of_type_JavaUtilArrayList;
        localtjm.jdField_a_of_type_Int = paramtoe.b;
        if ((paramtoe.jdField_a_of_type_Long == paramtmg.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localtjm.e = bool1;
        if (!localtjm.e) {
          break label524;
        }
        localObject1 = paramtoe.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new uue());
          localtcp.a((List)localObject1, paramtmg.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramtoe.jdField_a_of_type_JavaLangString;
        if (!paramtoe.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Tjl.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Tjl.jdField_a_of_type_JavaLangString;
        if (!paramtoe.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramtmg = "true";; paramtmg = "false")
      {
        veg.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramtmg);
        paramtmg = (uwa)tdc.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramtoe = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramtmg.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramtoe.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramtoe.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramtmg.a(paramtoe);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramtmg = localtcp.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Tjl.a(paramtmg);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tjl.jdField_a_of_type_JavaLangString;
      ste.a().dispatch(localtjm);
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
    Bosses.get().postJob(new tjk(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tji
 * JD-Core Version:    0.7.0.1
 */