import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class agvk
  extends agvq
{
  private QQAppInterface mApp;
  private Context mContext;
  
  public agvk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  public void JD(boolean paramBoolean)
  {
    this.cfk = paramBoolean;
  }
  
  public boolean SG()
  {
    String str = getFileName();
    long l = getFileSize();
    if (aqhq.fileExistsAndNotEmpty(getFilePath())) {
      return false;
    }
    int i = bF();
    if ((i == 2) || ((this.mSessionInfo != null) && (this.mSessionInfo.cZ == 1) && (i == 8))) {
      return false;
    }
    if (ahav.getFileType(str) != 2) {
      return false;
    }
    if (!ahav.amK()) {
      return false;
    }
    if ((!TextUtils.isEmpty(str)) && (l > 0L) && (l > ((agiq)this.mApp.getManager(317)).a(apqz.lb(str)).cOv)) {
      return true;
    }
    return l > 1048576L;
  }
  
  public void T(ChatMessage paramChatMessage)
  {
    this.u = paramChatMessage;
  }
  
  public SessionInfo a()
  {
    return this.mSessionInfo;
  }
  
  protected abstract int bF();
  
  public ChatMessage e()
  {
    return this.u;
  }
  
  protected abstract String getFileName();
  
  protected abstract String getFilePath();
  
  protected abstract long getFileSize();
  
  public boolean isMute()
  {
    return this.mIsMute;
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.mSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvk
 * JD-Core Version:    0.7.0.1
 */