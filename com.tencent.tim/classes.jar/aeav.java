import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeav
{
  int mMaxCount = -1;
  
  public static aeav a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aeav localaeav = new aeav();
        localaeav.mMaxCount = new JSONObject(paramString).getInt("maxcount");
        aebo.MAX_COUNT = localaeav.mMaxCount;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localaeav.mMaxCount);
        }
        return localaeav;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed erro " + paramString.toString());
    return null;
  }
  
  public int getMaxCount()
  {
    return this.mMaxCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeav
 * JD-Core Version:    0.7.0.1
 */