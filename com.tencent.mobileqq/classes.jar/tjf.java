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

public class tjf
  extends tje
  implements syq<tmd, tob>
{
  protected String a;
  protected tji a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public tjf(String paramString1, String paramString2)
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
    int i = vzl.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Tji.jdField_a_of_type_Int != i)
    {
      ved.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Tji.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (tcm)tcz.a(19);
      localMemoryInfoEntry = ((tcm)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Tji.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Tji.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new tmd();
      ((tmd)localObject).c = 10;
      ((tmd)localObject).d = 10;
      ((tmd)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((tmd)localObject).jdField_b_of_type_Long = l;
      ((tmd)localObject).e = this.jdField_a_of_type_Tji.jdField_a_of_type_Int;
      ((tmd)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((tcm)tcz.a(19)).a(this.d);
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
      ((tmd)localObject).jdField_a_of_type_Boolean = bool;
      syo.a().a((sys)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((tcm)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new tjg(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull tmd paramtmd, @Nullable tob paramtob, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtmd.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      ved.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramtmd.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    tcm localtcm = (tcm)tcz.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localtcm.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramtmd.jdField_a_of_type_JavaLangString);
      tjj localtjj = new tjj(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localtjj.jdField_b_of_type_JavaLangString = paramtmd.jdField_b_of_type_JavaLangString;
      localtjj.c = bool2;
      localtjj.jdField_b_of_type_Boolean = false;
      if ((paramtob == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        stb.a().dispatch(localtjj);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramtob.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramtob.c;
        localtjj.jdField_a_of_type_Boolean = paramtob.jdField_a_of_type_Boolean;
        localtjj.jdField_a_of_type_JavaUtilList = paramtob.jdField_a_of_type_JavaUtilArrayList;
        localtjj.jdField_a_of_type_Int = paramtob.b;
        if ((paramtob.jdField_a_of_type_Long == paramtmd.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localtjj.e = bool1;
        if (!localtjj.e) {
          break label524;
        }
        localObject1 = paramtob.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new uub());
          localtcm.a((List)localObject1, paramtmd.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramtob.jdField_a_of_type_JavaLangString;
        if (!paramtob.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Tji.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Tji.jdField_a_of_type_JavaLangString;
        if (!paramtob.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramtmd = "true";; paramtmd = "false")
      {
        ved.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramtmd);
        paramtmd = (uvx)tcz.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramtob = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramtmd.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramtob.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramtob.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramtmd.a(paramtob);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramtmd = localtcm.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Tji.a(paramtmd);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tji.jdField_a_of_type_JavaLangString;
      stb.a().dispatch(localtjj);
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
    Bosses.get().postJob(new tjh(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjf
 * JD-Core Version:    0.7.0.1
 */