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

public class waq
  extends uxw
  implements uni<vbm, vdc>
{
  protected int a;
  protected final String a;
  protected wat a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public waq(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = xod.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Wat.jdField_a_of_type_Int != i)
    {
      wsv.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wat.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (ure)urr.a(19);
      localMemoryInfoEntry = ((ure)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wat.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Wat.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new vbm();
      ((vbm)localObject).c = 10;
      ((vbm)localObject).d = 10;
      ((vbm)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((vbm)localObject).jdField_b_of_type_Long = l;
      ((vbm)localObject).f = this.jdField_a_of_type_Wat.jdField_a_of_type_Int;
      ((vbm)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((vbm)localObject).e = this.jdField_a_of_type_Int;
      ung.a().a((unk)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((ure)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new war(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull vbm paramvbm, @Nullable vdc paramvdc, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramvbm.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      wsv.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramvbm.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    ure localure = (ure)urr.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localure.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramvbm.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new uyb(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramvdc == null)
      {
        uht.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramvdc.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramvdc.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramvdc.jdField_a_of_type_Long != paramvbm.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramvdc.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new wit());
            localure.a(localArrayList, paramvbm.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramvdc.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramvdc.jdField_a_of_type_JavaLangString;
          if (!paramvdc.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Wat.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Wat.jdField_a_of_type_JavaLangString;
          if (!paramvdc.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramvbm = "true";; paramvbm = "false")
      {
        wsv.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramvbm, localArrayList);
        paramvbm = localure.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Wat.a(paramvbm);
        this.d = this.jdField_a_of_type_Wat.jdField_a_of_type_JavaLangString;
        uht.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new was(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */