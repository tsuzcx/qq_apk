import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aerr
  extends aeqp<aerq>
{
  @NonNull
  public aerq a(@NonNull aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.PERF.ConfigProcessor", 1, paramArrayOfaeic[0].content);
    }
    return aerq.a(paramArrayOfaeic[0].content);
  }
  
  @NonNull
  public aerq b()
  {
    return aerq.a();
  }
  
  @NonNull
  public aerq c()
  {
    return aerq.a();
  }
  
  public Class<aerq> clazz()
  {
    return aerq.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public int type()
  {
    return 580;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerr
 * JD-Core Version:    0.7.0.1
 */