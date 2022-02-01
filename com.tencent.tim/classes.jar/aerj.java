import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aerj
  extends aeqp<aeri>
{
  @NonNull
  public aeri a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new aeri();
  }
  
  @NonNull
  public aeri a(@NonNull aeic[] paramArrayOfaeic)
  {
    aeri localaeri = new aeri();
    try
    {
      localaeri.bVX = new JSONObject(paramArrayOfaeic[0].content).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localaeri.bVX);
      }
      return localaeri;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaeic);
    }
    return localaeri;
  }
  
  @NonNull
  public aeri b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new aeri();
  }
  
  public Class<aeri> clazz()
  {
    return aeri.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerj
 * JD-Core Version:    0.7.0.1
 */