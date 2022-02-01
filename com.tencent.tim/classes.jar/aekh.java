import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekh
{
  public int cNG = 0;
  public int style = 0;
  
  public static aekh a(aeic[] paramArrayOfaeic)
  {
    aekh localaekh = new aekh();
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
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localaekh;
      }
      paramArrayOfaeic = new JSONObject((String)localObject1);
      localaekh.style = paramArrayOfaeic.optInt("ifnewstyle", 0);
      localaekh.cNG = paramArrayOfaeic.optInt("sequenceadjust", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localaekh.style + ",sequenceAdjust=" + localaekh.cNG);
      return localaekh;
    }
    catch (Exception paramArrayOfaeic)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaeic);
    }
    return localaekh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekh
 * JD-Core Version:    0.7.0.1
 */