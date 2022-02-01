import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aequ
  extends aeqp<aeqs>
{
  @NonNull
  public static aeqs d()
  {
    aeqs localaeqs2 = (aeqs)aeif.a().o(541);
    aeqs localaeqs1 = localaeqs2;
    if (localaeqs2 == null) {
      localaeqs1 = aeqs.a();
    }
    return localaeqs1;
  }
  
  @NonNull
  public aeqs a(@NonNull aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfaeic[0].content);
    }
    return aeqs.a(paramArrayOfaeic[0].content);
  }
  
  @NonNull
  public aeqs b()
  {
    return aeqs.a();
  }
  
  @NonNull
  public aeqs c()
  {
    return aeqs.a();
  }
  
  public Class<aeqs> clazz()
  {
    return aeqs.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aequ
 * JD-Core Version:    0.7.0.1
 */