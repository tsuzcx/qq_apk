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

public class wez
  extends vcf
  implements urr<vfv, vhl>
{
  protected int a;
  protected final String a;
  protected wfc a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public wez(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = xsm.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Wfc.jdField_a_of_type_Int != i)
    {
      wxe.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wfc.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (uvn)uwa.a(19);
      localMemoryInfoEntry = ((uvn)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Wfc.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Wfc.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new vfv();
      ((vfv)localObject).c = 10;
      ((vfv)localObject).d = 10;
      ((vfv)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((vfv)localObject).jdField_b_of_type_Long = l;
      ((vfv)localObject).f = this.jdField_a_of_type_Wfc.jdField_a_of_type_Int;
      ((vfv)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((vfv)localObject).e = this.jdField_a_of_type_Int;
      urp.a().a((urt)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((uvn)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new wfa(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull vfv paramvfv, @Nullable vhl paramvhl, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramvfv.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      wxe.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramvfv.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    uvn localuvn = (uvn)uwa.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localuvn.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramvfv.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new vck(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramvhl == null)
      {
        umc.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramvhl.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramvhl.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramvhl.jdField_a_of_type_Long != paramvfv.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramvhl.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new wnc());
            localuvn.a(localArrayList, paramvfv.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramvhl.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramvhl.jdField_a_of_type_JavaLangString;
          if (!paramvhl.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Wfc.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Wfc.jdField_a_of_type_JavaLangString;
          if (!paramvhl.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramvfv = "true";; paramvfv = "false")
      {
        wxe.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramvfv, localArrayList);
        paramvfv = localuvn.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Wfc.a(paramvfv);
        this.d = this.jdField_a_of_type_Wfc.jdField_a_of_type_JavaLangString;
        umc.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new wfb(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wez
 * JD-Core Version:    0.7.0.1
 */