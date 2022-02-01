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

public class wzn
  extends wzm
  implements woy<xcl, xej>
{
  protected String a;
  protected wzq a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public wzn(String paramString1, String paramString2)
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
    int i = zps.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Wzq.jdField_a_of_type_Int != i)
    {
      yuk.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wzq.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (wsu)wth.a(19);
      localMemoryInfoEntry = ((wsu)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wzq.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Wzq.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new xcl();
      ((xcl)localObject).c = 10;
      ((xcl)localObject).d = 10;
      ((xcl)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((xcl)localObject).jdField_b_of_type_Long = l;
      ((xcl)localObject).e = this.jdField_a_of_type_Wzq.jdField_a_of_type_Int;
      ((xcl)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((wsu)wth.a(19)).a(this.d);
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
      ((xcl)localObject).jdField_a_of_type_Boolean = bool;
      wow.a().a((wpa)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((wsu)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new wzo(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull xcl paramxcl, @Nullable xej paramxej, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramxcl.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      yuk.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramxcl.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    wsu localwsu = (wsu)wth.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwsu.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramxcl.jdField_a_of_type_JavaLangString);
      wzr localwzr = new wzr(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localwzr.jdField_b_of_type_JavaLangString = paramxcl.jdField_b_of_type_JavaLangString;
      localwzr.c = bool2;
      localwzr.jdField_b_of_type_Boolean = false;
      if ((paramxej == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        wjj.a().dispatch(localwzr);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramxej.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramxej.c;
        localwzr.jdField_a_of_type_Boolean = paramxej.jdField_a_of_type_Boolean;
        localwzr.jdField_a_of_type_JavaUtilList = paramxej.jdField_a_of_type_JavaUtilArrayList;
        localwzr.jdField_a_of_type_Int = paramxej.b;
        if ((paramxej.jdField_a_of_type_Long == paramxcl.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localwzr.e = bool1;
        if (!localwzr.e) {
          break label524;
        }
        localObject1 = paramxej.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new yki());
          localwsu.a((List)localObject1, paramxcl.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramxej.jdField_a_of_type_JavaLangString;
        if (!paramxej.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Wzq.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Wzq.jdField_a_of_type_JavaLangString;
        if (!paramxej.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramxcl = "true";; paramxcl = "false")
      {
        yuk.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramxcl);
        paramxcl = (yme)wth.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramxej = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramxcl.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramxej.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramxej.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramxcl.a(paramxej);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramxcl = localwsu.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Wzq.a(paramxcl);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wzq.jdField_a_of_type_JavaLangString;
      wjj.a().dispatch(localwzr);
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
    Bosses.get().postJob(new wzp(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */