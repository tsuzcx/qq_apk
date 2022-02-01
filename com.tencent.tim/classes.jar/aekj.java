import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekj
{
  public boolean bUB;
  
  public static aekj a(aeic[] paramArrayOfaeic)
  {
    boolean bool = false;
    aekj localaekj = new aekj();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaeic.length > 0) {
        localObject1 = paramArrayOfaeic[0].content;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localaekj;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localaekj.bUB = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localaekj.bUB);
      return localaekj;
    }
    catch (Exception paramArrayOfaeic)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaeic);
    }
    return localaekj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekj
 * JD-Core Version:    0.7.0.1
 */