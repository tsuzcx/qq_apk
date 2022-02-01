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

public class xyk
  extends wvr
  implements wld<wzh, xax>
{
  protected int a;
  protected final String a;
  protected xyn a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public xyk(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = zlx.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_Xyn.jdField_a_of_type_Int != i)
    {
      yqp.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xyn.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (woz)wpm.a(19);
      localMemoryInfoEntry = ((woz)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Xyn.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Xyn.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new wzh();
      ((wzh)localObject).c = 10;
      ((wzh)localObject).d = 10;
      ((wzh)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((wzh)localObject).jdField_b_of_type_Long = l;
      ((wzh)localObject).f = this.jdField_a_of_type_Xyn.jdField_a_of_type_Int;
      ((wzh)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((wzh)localObject).e = this.jdField_a_of_type_Int;
      wlb.a().a((wlf)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((woz)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new xyl(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull wzh paramwzh, @Nullable xax paramxax, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramwzh.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      yqp.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramwzh.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    woz localwoz = (woz)wpm.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwoz.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramwzh.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new wvw(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramxax == null)
      {
        wfo.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramxax.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramxax.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramxax.jdField_a_of_type_Long != paramwzh.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramxax.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new ygn());
            localwoz.a(localArrayList, paramwzh.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramxax.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramxax.jdField_a_of_type_JavaLangString;
          if (!paramxax.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Xyn.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Xyn.jdField_a_of_type_JavaLangString;
          if (!paramxax.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramwzh = "true";; paramwzh = "false")
      {
        yqp.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramwzh, localArrayList);
        paramwzh = localwoz.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Xyn.a(paramwzh);
        this.d = this.jdField_a_of_type_Xyn.jdField_a_of_type_JavaLangString;
        wfo.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new xym(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyk
 * JD-Core Version:    0.7.0.1
 */