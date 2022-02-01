import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class gnr
  implements Runnable
{
  public long a;
  public ProtoReqManager.ProtoResp a;
  public NewIntent a;
  public boolean a;
  long b;
  public boolean b;
  public long c;
  public boolean c = false;
  
  public gnr(ProtoReqManager paramProtoReqManager)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("key_timeout", this.jdField_a_of_type_Long);
    MessageObserver.StatictisInfo localStatictisInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp.a;
    localStatictisInfo.c += 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a.put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gnr
 * JD-Core Version:    0.7.0.1
 */