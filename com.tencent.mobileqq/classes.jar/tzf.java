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

public class tzf
  extends swl
  implements slx<tab, tbr>
{
  protected int a;
  protected final String a;
  protected tzi a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public tzf(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = vms.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Tzi.jdField_a_of_type_Int != i)
    {
      urk.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Tzi.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (spt)sqg.a(19);
      localMemoryInfoEntry = ((spt)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Tzi.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Tzi.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new tab();
      ((tab)localObject).c = 10;
      ((tab)localObject).d = 10;
      ((tab)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((tab)localObject).jdField_b_of_type_Long = l;
      ((tab)localObject).f = this.jdField_a_of_type_Tzi.jdField_a_of_type_Int;
      ((tab)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((tab)localObject).e = this.jdField_a_of_type_Int;
      slv.a().a((slz)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((spt)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new tzg(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull tab paramtab, @Nullable tbr paramtbr, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramtab.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      urk.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramtab.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    spt localspt = (spt)sqg.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localspt.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramtab.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new swq(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramtbr == null)
      {
        sgi.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramtbr.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramtbr.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramtbr.jdField_a_of_type_Long != paramtab.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramtbr.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new uhi());
            localspt.a(localArrayList, paramtab.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramtbr.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramtbr.jdField_a_of_type_JavaLangString;
          if (!paramtbr.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Tzi.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Tzi.jdField_a_of_type_JavaLangString;
          if (!paramtbr.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramtab = "true";; paramtab = "false")
      {
        urk.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramtab, localArrayList);
        paramtab = localspt.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Tzi.a(paramtab);
        this.d = this.jdField_a_of_type_Tzi.jdField_a_of_type_JavaLangString;
        sgi.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new tzh(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzf
 * JD-Core Version:    0.7.0.1
 */