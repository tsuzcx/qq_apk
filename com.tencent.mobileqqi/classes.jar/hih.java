import android.content.Context;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.base.LogUtility;
import java.util.HashMap;

public final class hih
  implements Runnable
{
  public hih(Context paramContext, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      OpenAppClient.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    catch (Exception localException)
    {
      String str = "onPushMsg exception: " + this.jdField_a_of_type_JavaUtilHashMap;
      LogUtility.c(OpenAppClient.a, str, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hih
 * JD-Core Version:    0.7.0.1
 */