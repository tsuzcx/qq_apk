import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekw
{
  public int cNI = 1;
  
  public static aekw a(aeic[] paramArrayOfaeic)
  {
    aekw localaekw = new aekw();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaeic.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[i].content);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localaekw.cNI = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localaekw.cNI);
          }
          return localaekw;
        }
      }
      catch (Throwable paramArrayOfaeic)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaeic);
        return localaekw;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekw
 * JD-Core Version:    0.7.0.1
 */