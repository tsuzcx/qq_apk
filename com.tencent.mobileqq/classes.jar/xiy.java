import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class xiy
  extends alko
{
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private ConcurrentHashMap<String, LocalMediaInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public xiy(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public MediaFormat a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaFormat;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCatcheMediaInfo");
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "setCatcheMediaInfo path : " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramLocalMediaInfo);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */