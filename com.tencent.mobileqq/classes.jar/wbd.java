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

public class wbd
  extends wbc
  implements vqp<web, wfz>
{
  protected String a;
  protected wbg a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public wbd(String paramString1, String paramString2)
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
    if (this.jdField_a_of_type_Wbg.jdField_a_of_type_Int != i)
    {
      xvv.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wbg.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (vuk)vux.a(19);
      localMemoryInfoEntry = ((vuk)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wbg.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Wbg.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new web();
      ((web)localObject).c = 10;
      ((web)localObject).d = 10;
      ((web)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((web)localObject).jdField_b_of_type_Long = l;
      ((web)localObject).e = this.jdField_a_of_type_Wbg.jdField_a_of_type_Int;
      ((web)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((vuk)vux.a(19)).a(this.d);
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
      ((web)localObject).jdField_a_of_type_Boolean = bool;
      vqn.a().a((vqr)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((vuk)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new wbe(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull web paramweb, @Nullable wfz paramwfz, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramweb.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      xvv.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramweb.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    vuk localvuk = (vuk)vux.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localvuk.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramweb.jdField_a_of_type_JavaLangString);
      wbh localwbh = new wbh(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localwbh.jdField_b_of_type_JavaLangString = paramweb.jdField_b_of_type_JavaLangString;
      localwbh.c = bool2;
      localwbh.jdField_b_of_type_Boolean = false;
      if ((paramwfz == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        vli.a().dispatch(localwbh);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramwfz.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramwfz.c;
        localwbh.jdField_a_of_type_Boolean = paramwfz.jdField_a_of_type_Boolean;
        localwbh.jdField_a_of_type_JavaUtilList = paramwfz.jdField_a_of_type_JavaUtilArrayList;
        localwbh.jdField_a_of_type_Int = paramwfz.b;
        if ((paramwfz.jdField_a_of_type_Long == paramweb.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localwbh.e = bool1;
        if (!localwbh.e) {
          break label524;
        }
        localObject1 = paramwfz.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new xlt());
          localvuk.a((List)localObject1, paramweb.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramwfz.jdField_a_of_type_JavaLangString;
        if (!paramwfz.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Wbg.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Wbg.jdField_a_of_type_JavaLangString;
        if (!paramwfz.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramweb = "true";; paramweb = "false")
      {
        xvv.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramweb);
        paramweb = (xnp)vux.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramwfz = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramweb.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramwfz.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramwfz.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramweb.a(paramwfz);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramweb = localvuk.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Wbg.a(paramweb);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wbg.jdField_a_of_type_JavaLangString;
      vli.a().dispatch(localwbh);
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
    Bosses.get().postJob(new wbf(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbd
 * JD-Core Version:    0.7.0.1
 */