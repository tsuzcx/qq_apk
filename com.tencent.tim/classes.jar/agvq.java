import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class agvq
{
  boolean cfk = false;
  boolean cfl = true;
  boolean mIsMute = false;
  SessionInfo mSessionInfo = null;
  ChatMessage u = null;
  
  public void JD(boolean paramBoolean) {}
  
  public void JG(boolean paramBoolean)
  {
    this.cfl = paramBoolean;
  }
  
  public boolean SG()
  {
    return true;
  }
  
  public void T(ChatMessage paramChatMessage) {}
  
  public SessionInfo a()
  {
    return this.mSessionInfo;
  }
  
  public boolean amA()
  {
    return this.cfl;
  }
  
  boolean amw()
  {
    return false;
  }
  
  boolean amx()
  {
    return false;
  }
  
  public boolean amz()
  {
    return this.cfk;
  }
  
  public void cC(Bundle paramBundle) {}
  
  public ChatMessage e()
  {
    return null;
  }
  
  public boolean isMute()
  {
    return this.mIsMute;
  }
  
  public void setMute(boolean paramBoolean) {}
  
  public void setSessionInfo(SessionInfo paramSessionInfo) {}
  
  public abstract Intent x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvq
 * JD-Core Version:    0.7.0.1
 */