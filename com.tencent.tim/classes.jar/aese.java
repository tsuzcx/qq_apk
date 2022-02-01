import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aese
  extends aeqp<aesd>
{
  @NonNull
  public static aesd d()
  {
    aesd localaesd2 = (aesd)aeif.a().o(562);
    aesd localaesd1 = localaesd2;
    if (localaesd2 == null) {
      localaesd1 = aesd.a();
    }
    return localaesd1;
  }
  
  @NonNull
  public aesd a(@NonNull aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.ConfigProcessor", 1, paramArrayOfaeic[0].content);
    }
    return aesd.a(paramArrayOfaeic[0].content);
  }
  
  @NonNull
  public aesd b()
  {
    return aesd.a();
  }
  
  @NonNull
  public aesd c()
  {
    return aesd.a();
  }
  
  public Class<aesd> clazz()
  {
    return aesd.class;
  }
  
  public int type()
  {
    return 562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aese
 * JD-Core Version:    0.7.0.1
 */