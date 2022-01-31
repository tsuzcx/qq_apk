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

public class vcg
  extends vcf
  implements urr<vfe, vhc>
{
  protected String a;
  protected vcj a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public vcg(String paramString1, String paramString2)
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
    int i = xsm.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Vcj.jdField_a_of_type_Int != i)
    {
      wxe.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Vcj.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (uvn)uwa.a(19);
      localMemoryInfoEntry = ((uvn)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Vcj.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Vcj.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new vfe();
      ((vfe)localObject).c = 10;
      ((vfe)localObject).d = 10;
      ((vfe)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((vfe)localObject).jdField_b_of_type_Long = l;
      ((vfe)localObject).e = this.jdField_a_of_type_Vcj.jdField_a_of_type_Int;
      ((vfe)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((uvn)uwa.a(19)).a(this.d);
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
      ((vfe)localObject).jdField_a_of_type_Boolean = bool;
      urp.a().a((urt)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((uvn)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new vch(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull vfe paramvfe, @Nullable vhc paramvhc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvfe.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      wxe.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramvfe.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    uvn localuvn = (uvn)uwa.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localuvn.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramvfe.jdField_a_of_type_JavaLangString);
      vck localvck = new vck(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localvck.jdField_b_of_type_JavaLangString = paramvfe.jdField_b_of_type_JavaLangString;
      localvck.c = bool2;
      localvck.jdField_b_of_type_Boolean = false;
      if ((paramvhc == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        umc.a().dispatch(localvck);
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
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramvhc.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramvhc.c;
        localvck.jdField_a_of_type_Boolean = paramvhc.jdField_a_of_type_Boolean;
        localvck.jdField_a_of_type_JavaUtilList = paramvhc.jdField_a_of_type_JavaUtilArrayList;
        localvck.jdField_a_of_type_Int = paramvhc.b;
        if ((paramvhc.jdField_a_of_type_Long == paramvfe.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localvck.e = bool1;
        if (!localvck.e) {
          break label524;
        }
        localObject1 = paramvhc.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new wnc());
          localuvn.a((List)localObject1, paramvfe.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramvhc.jdField_a_of_type_JavaLangString;
        if (!paramvhc.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Vcj.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Vcj.jdField_a_of_type_JavaLangString;
        if (!paramvhc.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramvfe = "true";; paramvfe = "false")
      {
        wxe.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramvfe);
        paramvfe = (woy)uwa.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramvhc = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramvfe.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramvhc.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramvhc.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramvfe.a(paramvhc);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramvfe = localuvn.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Vcj.a(paramvfe);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vcj.jdField_a_of_type_JavaLangString;
      umc.a().dispatch(localvck);
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
    Bosses.get().postJob(new vci(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcg
 * JD-Core Version:    0.7.0.1
 */