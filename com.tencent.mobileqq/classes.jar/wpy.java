import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wpy
  extends wpx
  implements wfk<wsw, wuu>
{
  protected String a;
  protected wqb a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public wpy(String paramString1, String paramString2)
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
    int i = UIUtils.getTimeZoneOffset();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Wqb.jdField_a_of_type_Int != i)
    {
      ykq.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wqb.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (wjf)wjs.a(19);
      localMemoryInfoEntry = ((wjf)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wqb.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Wqb.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new wsw();
      ((wsw)localObject).c = 10;
      ((wsw)localObject).d = 10;
      ((wsw)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((wsw)localObject).jdField_b_of_type_Long = l;
      ((wsw)localObject).e = this.jdField_a_of_type_Wqb.jdField_a_of_type_Int;
      ((wsw)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((wjf)wjs.a(19)).a(this.d);
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
      ((wsw)localObject).jdField_a_of_type_Boolean = bool;
      wfi.a().a((wfm)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((wjf)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new wpz(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull wsw paramwsw, @Nullable wuu paramwuu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwsw.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      ykq.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramwsw.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    wjf localwjf = (wjf)wjs.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwjf.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramwsw.jdField_a_of_type_JavaLangString);
      wqc localwqc = new wqc(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localwqc.jdField_b_of_type_JavaLangString = paramwsw.jdField_b_of_type_JavaLangString;
      localwqc.c = bool2;
      localwqc.jdField_b_of_type_Boolean = false;
      if ((paramwuu == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        wad.a().dispatch(localwqc);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramwuu.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramwuu.c;
        localwqc.jdField_a_of_type_Boolean = paramwuu.jdField_a_of_type_Boolean;
        localwqc.jdField_a_of_type_JavaUtilList = paramwuu.jdField_a_of_type_JavaUtilArrayList;
        localwqc.jdField_a_of_type_Int = paramwuu.b;
        if ((paramwuu.jdField_a_of_type_Long == paramwsw.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localwqc.e = bool1;
        if (!localwqc.e) {
          break label524;
        }
        localObject1 = paramwuu.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new yao());
          localwjf.a((List)localObject1, paramwsw.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramwuu.jdField_a_of_type_JavaLangString;
        if (!paramwuu.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Wqb.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Wqb.jdField_a_of_type_JavaLangString;
        if (!paramwuu.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramwsw = "true";; paramwsw = "false")
      {
        ykq.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramwsw);
        paramwsw = (yck)wjs.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramwuu = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramwsw.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramwuu.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramwuu.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramwsw.a(paramwuu);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramwsw = localwjf.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Wqb.a(paramwsw);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wqb.jdField_a_of_type_JavaLangString;
      wad.a().dispatch(localwqc);
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
    Bosses.get().postJob(new wqa(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpy
 * JD-Core Version:    0.7.0.1
 */