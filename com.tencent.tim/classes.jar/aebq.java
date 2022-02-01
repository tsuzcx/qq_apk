import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aebq
{
  private int cqe = 1;
  
  public static aebq a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteRecentConfBean", 2, String.format("parse content=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aebq localaebq = new aebq();
        localaebq.cqe = new JSONObject(paramString).getInt("ifrecent");
        return localaebq;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteRecentConfBean", 2, "ColorNoteRecentConfBean parse err: ", paramString);
    return null;
  }
  
  public boolean agp()
  {
    return this.cqe == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebq
 * JD-Core Version:    0.7.0.1
 */