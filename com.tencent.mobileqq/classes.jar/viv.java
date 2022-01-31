import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;

public class viv
  extends vkh
{
  private HashMap<String, String> a;
  private boolean c;
  
  public viv()
  {
    this(null, false);
  }
  
  public viv(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a(false, true);
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.c = paramBoolean;
  }
  
  public void a()
  {
    Object localObject2 = vls.a();
    Object localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    String str = ((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1);
    localObject2 = new Bundle();
    localObject1 = ndd.a(BaseApplication.getContext(), (String)localObject1, str, 1, this.jdField_a_of_type_JavaUtilHashMap, (Bundle)localObject2);
    if ((!((Bundle)localObject2).getBoolean("isSuccess", false)) && (this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.b, 2, "shortenUrl failed size:" + ((HashMap)localObject1).size());
      }
      b(false);
      return;
    }
    a("ShortenUrlJob_shortenedUrls", localObject1);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (paramMap.containsKey("ShortenUrlJob_shortenedUrls"))) {
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)vky.a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, "ShortenUrlJob_shortenedUrls", this.jdField_a_of_type_JavaUtilHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     viv
 * JD-Core Version:    0.7.0.1
 */