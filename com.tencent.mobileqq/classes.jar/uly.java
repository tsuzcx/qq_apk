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

public class uly
  extends tje
  implements syq<tmu, tok>
{
  protected int a;
  protected final String a;
  protected umb a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public uly(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = vzl.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Umb.jdField_a_of_type_Int != i)
    {
      ved.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Umb.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (tcm)tcz.a(19);
      localMemoryInfoEntry = ((tcm)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Umb.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Umb.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new tmu();
      ((tmu)localObject).c = 10;
      ((tmu)localObject).d = 10;
      ((tmu)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((tmu)localObject).jdField_b_of_type_Long = l;
      ((tmu)localObject).f = this.jdField_a_of_type_Umb.jdField_a_of_type_Int;
      ((tmu)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((tmu)localObject).e = this.jdField_a_of_type_Int;
      syo.a().a((sys)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((tcm)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new ulz(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull tmu paramtmu, @Nullable tok paramtok, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramtmu.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      ved.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramtmu.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    tcm localtcm = (tcm)tcz.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localtcm.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramtmu.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new tjj(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramtok == null)
      {
        stb.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramtok.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramtok.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramtok.jdField_a_of_type_Long != paramtmu.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramtok.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new uub());
            localtcm.a(localArrayList, paramtmu.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramtok.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramtok.jdField_a_of_type_JavaLangString;
          if (!paramtok.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Umb.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Umb.jdField_a_of_type_JavaLangString;
          if (!paramtok.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramtmu = "true";; paramtmu = "false")
      {
        ved.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramtmu, localArrayList);
        paramtmu = localtcm.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Umb.a(paramtmu);
        this.d = this.jdField_a_of_type_Umb.jdField_a_of_type_JavaLangString;
        stb.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new uma(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uly
 * JD-Core Version:    0.7.0.1
 */