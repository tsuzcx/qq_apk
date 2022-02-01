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

public class xsl
  extends wpx
  implements wfk<wtn, wvd>
{
  protected int a;
  protected final String a;
  protected xso a;
  protected final String b;
  protected long c;
  protected final String c;
  protected String d = "";
  
  public xsl(String paramString1, int paramInt, String paramString2)
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
    if (this.jdField_a_of_type_Xso.jdField_a_of_type_Int != i)
    {
      ykq.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xso.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (wjf)wjs.a(19);
      localMemoryInfoEntry = ((wjf)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Xso.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_Xso.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new wtn();
      ((wtn)localObject).c = 10;
      ((wtn)localObject).d = 10;
      ((wtn)localObject).jdField_b_of_type_JavaLangString = this.d;
      ((wtn)localObject).jdField_b_of_type_Long = l;
      ((wtn)localObject).f = this.jdField_a_of_type_Xso.jdField_a_of_type_Int;
      ((wtn)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((wtn)localObject).e = this.jdField_a_of_type_Int;
      wfi.a().a((wfm)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((wjf)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new xsm(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull wtn paramwtn, @Nullable wvd paramwvd, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramwtn.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      ykq.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramwtn.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    wjf localwjf = (wjf)wjs.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localwjf.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramwtn.jdField_b_of_type_JavaLangString);
      paramErrorMessage = new wqc(this.jdField_b_of_type_JavaLangString, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramwvd == null)
      {
        wad.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramwvd.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramwvd.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramwvd.jdField_a_of_type_Long != paramwtn.jdField_b_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramwvd.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new yao());
            localwjf.a(localArrayList, paramwtn.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramwvd.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramwvd.jdField_a_of_type_JavaLangString;
          if (!paramwvd.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_Xso.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_Xso.jdField_a_of_type_JavaLangString;
          if (!paramwvd.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramwtn = "true";; paramwtn = "false")
      {
        ykq.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramwtn, localArrayList);
        paramwtn = localwjf.a(localMemoryInfoEntry);
        this.jdField_a_of_type_Xso.a(paramwtn);
        this.d = this.jdField_a_of_type_Xso.jdField_a_of_type_JavaLangString;
        wad.a().dispatch(paramErrorMessage);
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
    Bosses.get().postJob(new xsn(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsl
 * JD-Core Version:    0.7.0.1
 */