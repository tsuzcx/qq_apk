import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aesm
  extends aeqp<aesh>
{
  @NonNull
  public static aesh d()
  {
    aesh localaesh2 = (aesh)aeif.a().o(628);
    aesh localaesh1 = localaesh2;
    if (localaesh2 == null) {
      localaesh1 = aesh.a();
    }
    return localaesh1;
  }
  
  @NonNull
  public aesh a(@NonNull aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.TROOP_FILE.ConfigProcessor", 1, paramArrayOfaeic[0].content);
    }
    return aesh.a(paramArrayOfaeic[0].content);
  }
  
  @NonNull
  public aesh b()
  {
    return aesh.a();
  }
  
  @NonNull
  public aesh c()
  {
    return aesh.a();
  }
  
  public Class<aesh> clazz()
  {
    return aesh.class;
  }
  
  public int type()
  {
    return 628;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesm
 * JD-Core Version:    0.7.0.1
 */