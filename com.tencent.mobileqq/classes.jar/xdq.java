import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;

public class xdq
  extends wbc
  implements vqp<wes, wgi>
{
  protected int a;
  protected final String a;
  protected xdt a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public xdq(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = UIUtils.getTimeZoneOffset();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Xdt.jdField_a_of_type_Int != i)
    {
      xvv.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xdt.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (vuk)vux.a(19);
      localMemoryInfoEntry = ((vuk)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Xdt.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Xdt.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new wes();
      ((wes)localObject).c = 10;
      ((wes)localObject).d = 10;
      ((wes)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((wes)localObject).jdField_b_of_type_Long = l;
      ((wes)localObject).f = this.jdField_a_of_type_Xdt.jdField_a_of_type_Int;
      ((wes)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((wes)localObject).e = this.jdField_a_of_type_Int;
      vqn.a().a((vqr)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((vuk)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new xdr(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull wes paramwes, @Nullable wgi paramwgi, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramwes.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      xvv.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramwes.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    vuk localvuk = (vuk)vux.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localvuk.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramwes.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new wbh(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramwgi == null)
      {
        vli.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramwgi.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramwgi.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramwgi.jdField_a_of_type_Long != paramwes.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramwgi.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new xlt());
            localvuk.a(localArrayList, paramwes.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramwgi.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramwgi.jdField_a_of_type_JavaLangString;
          if (!paramwgi.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Xdt.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Xdt.jdField_a_of_type_JavaLangString;
          if (!paramwgi.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramwes = "true";; paramwes = "false")
      {
        xvv.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramwes, localArrayList);
        paramwes = localvuk.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Xdt.a(paramwes);
        this.d = this.jdField_a_of_type_Xdt.jdField_a_of_type_JavaLangString;
        vli.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new xds(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdq
 * JD-Core Version:    0.7.0.1
 */