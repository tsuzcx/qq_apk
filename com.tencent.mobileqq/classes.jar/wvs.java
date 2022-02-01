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

public class wvs
  extends wvr
  implements wld<wyq, xao>
{
  protected String a;
  protected wvv a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public wvs(String paramString1, String paramString2)
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
    int i = zlx.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Wvv.jdField_a_of_type_Int != i)
    {
      yqp.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wvv.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (woz)wpm.a(19);
      localMemoryInfoEntry = ((woz)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wvv.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Wvv.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new wyq();
      ((wyq)localObject).c = 10;
      ((wyq)localObject).d = 10;
      ((wyq)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((wyq)localObject).jdField_b_of_type_Long = l;
      ((wyq)localObject).e = this.jdField_a_of_type_Wvv.jdField_a_of_type_Int;
      ((wyq)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((woz)wpm.a(19)).a(this.d);
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
      ((wyq)localObject).jdField_a_of_type_Boolean = bool;
      wlb.a().a((wlf)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((woz)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new wvt(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull wyq paramwyq, @Nullable xao paramxao, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwyq.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      yqp.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramwyq.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    woz localwoz = (woz)wpm.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwoz.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramwyq.jdField_a_of_type_JavaLangString);
      wvw localwvw = new wvw(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localwvw.jdField_b_of_type_JavaLangString = paramwyq.jdField_b_of_type_JavaLangString;
      localwvw.c = bool2;
      localwvw.jdField_b_of_type_Boolean = false;
      if ((paramxao == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        wfo.a().dispatch(localwvw);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramxao.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramxao.c;
        localwvw.jdField_a_of_type_Boolean = paramxao.jdField_a_of_type_Boolean;
        localwvw.jdField_a_of_type_JavaUtilList = paramxao.jdField_a_of_type_JavaUtilArrayList;
        localwvw.jdField_a_of_type_Int = paramxao.b;
        if ((paramxao.jdField_a_of_type_Long == paramwyq.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localwvw.e = bool1;
        if (!localwvw.e) {
          break label524;
        }
        localObject1 = paramxao.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new ygn());
          localwoz.a((List)localObject1, paramwyq.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramxao.jdField_a_of_type_JavaLangString;
        if (!paramxao.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Wvv.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Wvv.jdField_a_of_type_JavaLangString;
        if (!paramxao.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramwyq = "true";; paramwyq = "false")
      {
        yqp.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramwyq);
        paramwyq = (yij)wpm.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramxao = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramwyq.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramxao.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramxao.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramwyq.a(paramxao);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramwyq = localwoz.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Wvv.a(paramwyq);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wvv.jdField_a_of_type_JavaLangString;
      wfo.a().dispatch(localwvw);
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
    Bosses.get().postJob(new wvu(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvs
 * JD-Core Version:    0.7.0.1
 */