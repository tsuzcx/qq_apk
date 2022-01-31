import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

@TargetApi(14)
public class ujv
{
  public static final String a;
  protected static ujv a;
  public static final String[] a;
  public static final String b;
  public static final String[] b;
  public static final String[] c = { ugx.i };
  public static final String[] d = { ugx.e };
  
  static
  {
    jdField_a_of_type_JavaLangString = aljq.bo + "qqstory/";
    jdField_b_of_type_JavaLangString = aljq.bo + "qqstory_watermark/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { ugx.h, ugx.k, ugx.u };
  }
  
  public static ujv a()
  {
    if (jdField_a_of_type_Ujv == null) {
      jdField_a_of_type_Ujv = new ujv();
    }
    return jdField_a_of_type_Ujv;
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.post(new CacheCleaner.2(this, paramBoolean), 2, null, false);
  }
  
  public void a()
  {
    Bosses.get().postJob(new ujw(this, "Q.qqstory.cleaner:CacheCleaner"));
  }
  
  protected boolean a(boolean paramBoolean)
  {
    long l1 = 3600L;
    label185:
    for (;;)
    {
      try
      {
        urk localurk = (urk)urr.a(10);
        long l2 = System.currentTimeMillis();
        long l3 = ((Long)localurk.b("cache_clean_latest_time", Long.valueOf(0L))).longValue();
        String str1;
        if (paramBoolean)
        {
          l3 = Math.abs(l2 - l3);
          if (l3 < l1 * 1000L)
          {
            l1 = l3 / 1000L / 60L / 60L;
            if (!paramBoolean) {
              break label185;
            }
            str1 = "low";
            wsv.a("Q.qqstory.cleaner:CacheCleaner", "clean before %d h , no need to clean again , capacity state :%s", Long.valueOf(l1), str1);
            paramBoolean = false;
            return paramBoolean;
          }
        }
        else
        {
          l1 = ((Long)localurk.b("StoryClearRate", Long.valueOf(3600L))).longValue();
          continue;
        }
        if (paramBoolean)
        {
          str1 = "low";
          wsv.d("Q.qqstory.cleaner:CacheCleaner", "clean cache , capacity state :%s", new Object[] { str1 });
          localurk.b("cache_clean_latest_time", Long.valueOf(l2));
          paramBoolean = true;
        }
        else
        {
          str1 = "healthy";
          continue;
          String str2 = "healthy";
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujv
 * JD-Core Version:    0.7.0.1
 */