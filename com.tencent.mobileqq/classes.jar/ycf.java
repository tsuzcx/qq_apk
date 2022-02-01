import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;

public class ycf
  extends wzm
  implements woy<xdc, xes>
{
  protected int a;
  protected final String a;
  protected yci a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public ycf(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = zps.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Yci.jdField_a_of_type_Int != i)
    {
      yuk.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yci.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (wsu)wth.a(19);
      localMemoryInfoEntry = ((wsu)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Yci.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Yci.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new xdc();
      ((xdc)localObject).c = 10;
      ((xdc)localObject).d = 10;
      ((xdc)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((xdc)localObject).jdField_b_of_type_Long = l;
      ((xdc)localObject).f = this.jdField_a_of_type_Yci.jdField_a_of_type_Int;
      ((xdc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((xdc)localObject).e = this.jdField_a_of_type_Int;
      wow.a().a((wpa)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((wsu)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new ycg(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull xdc paramxdc, @Nullable xes paramxes, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramxdc.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      yuk.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramxdc.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    wsu localwsu = (wsu)wth.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwsu.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramxdc.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new wzr(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramxes == null)
      {
        wjj.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramxes.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramxes.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramxes.jdField_a_of_type_Long != paramxdc.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramxes.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new yki());
            localwsu.a(localArrayList, paramxdc.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramxes.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramxes.jdField_a_of_type_JavaLangString;
          if (!paramxes.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Yci.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Yci.jdField_a_of_type_JavaLangString;
          if (!paramxes.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramxdc = "true";; paramxdc = "false")
      {
        yuk.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramxdc, localArrayList);
        paramxdc = localwsu.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Yci.a(paramxdc);
        this.d = this.jdField_a_of_type_Yci.jdField_a_of_type_JavaLangString;
        wjj.a().dispatch(paramErrorMessage);
        return;
        bool1 = false;
        break;
        i = 0;
        break label236;
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new ych(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycf
 * JD-Core Version:    0.7.0.1
 */