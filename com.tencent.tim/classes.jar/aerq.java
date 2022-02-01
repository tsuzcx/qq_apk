import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aerq
{
  private int cOD = 1;
  
  @NonNull
  public static aerq a()
  {
    return new aerq();
  }
  
  @NonNull
  public static aerq a(@Nullable String paramString)
  {
    aerq localaerq = new aerq();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localaerq.cOD = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaerq.toString());
      }
      return localaerq;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public String toString()
  {
    return "QVipPerfLevelConfig{use_apm=" + this.cOD + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerq
 * JD-Core Version:    0.7.0.1
 */