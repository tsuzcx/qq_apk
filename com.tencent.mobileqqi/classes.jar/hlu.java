import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.HashMap;
import org.json.JSONObject;

public class hlu
  implements Runnable
{
  public hlu(HttpCgiAsyncTask paramHttpCgiAsyncTask, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a != null)
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get("ResultType")).intValue() == 1) {
        this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a.a((JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get("ResultValue"));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a.a((Exception)this.jdField_a_of_type_JavaUtilHashMap.get("ResultValue"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hlu
 * JD-Core Version:    0.7.0.1
 */