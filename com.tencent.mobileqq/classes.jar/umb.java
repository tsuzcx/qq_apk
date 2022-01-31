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

public class umb
  extends tjh
  implements syt<tmx, ton>
{
  protected int a;
  protected final String a;
  protected ume a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public umb(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = vzo.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Ume.jdField_a_of_type_Int != i)
    {
      veg.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ume.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (tcp)tdc.a(19);
      localMemoryInfoEntry = ((tcp)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Ume.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Ume.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new tmx();
      ((tmx)localObject).c = 10;
      ((tmx)localObject).d = 10;
      ((tmx)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((tmx)localObject).jdField_b_of_type_Long = l;
      ((tmx)localObject).f = this.jdField_a_of_type_Ume.jdField_a_of_type_Int;
      ((tmx)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((tmx)localObject).e = this.jdField_a_of_type_Int;
      syr.a().a((syv)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((tcp)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new umc(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull tmx paramtmx, @Nullable ton paramton, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramtmx.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      veg.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramtmx.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    tcp localtcp = (tcp)tdc.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localtcp.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramtmx.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new tjm(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramton == null)
      {
        ste.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramton.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramton.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramton.jdField_a_of_type_Long != paramtmx.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramton.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new uue());
            localtcp.a(localArrayList, paramtmx.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramton.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramton.jdField_a_of_type_JavaLangString;
          if (!paramton.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Ume.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Ume.jdField_a_of_type_JavaLangString;
          if (!paramton.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramtmx = "true";; paramtmx = "false")
      {
        veg.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramtmx, localArrayList);
        paramtmx = localtcp.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Ume.a(paramtmx);
        this.d = this.jdField_a_of_type_Ume.jdField_a_of_type_JavaLangString;
        ste.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new umd(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umb
 * JD-Core Version:    0.7.0.1
 */