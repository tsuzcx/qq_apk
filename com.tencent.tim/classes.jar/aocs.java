import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.StringTokenizer;

public abstract class aocs
{
  public aocw a;
  public int dNX;
  public QQAppInterface mApp;
  public String mUin;
  public ChatMessage q;
  
  public aocs(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, aocw paramaocw)
  {
    this.mApp = paramQQAppInterface;
    this.q = paramChatMessage;
    this.mUin = paramChatMessage.frienduin;
    this.dNX = paramChatMessage.istroop;
    this.a = paramaocw;
  }
  
  public abstract String AB();
  
  public abstract void a(aocs.a parama);
  
  public boolean isSupport()
  {
    Object localObject = aeus.a().tW();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null, or maybe has not recv");
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
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null");
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
 * Qualified Name:     aocs
 * JD-Core Version:    0.7.0.1
 */