import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeqr
  extends aeqp<aeqq>
{
  @NonNull
  public aeqq a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new aeqq();
  }
  
  @NonNull
  public aeqq a(@NonNull aeic[] paramArrayOfaeic)
  {
    boolean bool = false;
    aeqq localaeqq = new aeqq();
    try
    {
      if (paramArrayOfaeic[0].content != null)
      {
        if (new JSONObject(paramArrayOfaeic[0].content).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localaeqq.bVU = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localaeqq.bVU);
        }
      }
      return localaeqq;
    }
    catch (Exception paramArrayOfaeic)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaeic);
    }
    return localaeqq;
  }
  
  @NonNull
  public aeqq b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new aeqq();
  }
  
  public Class<aeqq> clazz()
  {
    return aeqq.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqr
 * JD-Core Version:    0.7.0.1
 */