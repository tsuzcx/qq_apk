import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.StringTokenizer;

public abstract class aoct
{
  protected aocx a;
  public int dNX;
  public DataLineMsgRecord g;
  public QQAppInterface mApp;
  public String mUin;
  
  public aoct(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord, aocx paramaocx)
  {
    this.mApp = paramQQAppInterface;
    this.g = paramDataLineMsgRecord;
    this.mUin = paramDataLineMsgRecord.frienduin;
    this.dNX = paramDataLineMsgRecord.istroop;
    this.a = paramaocx;
  }
  
  public abstract String AB();
  
  public boolean isSupport()
  {
    Object localObject = aets.a().tW();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null, or maybe has not recv");
      }
    }
    String str;
    do
    {
      while (!((StringTokenizer)localObject).hasMoreTokens())
      {
        do
        {
          return false;
          str = ahbj.getExtension(AB());
          localObject = new StringTokenizer((String)localObject, "|");
          if (((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null");
        return false;
      }
    } while (!str.equalsIgnoreCase(((StringTokenizer)localObject).nextToken()));
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void mv(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoct
 * JD-Core Version:    0.7.0.1
 */