import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class xrg
{
  protected BaseChatPie c;
  public int id;
  public QQAppInterface mApp;
  public Context mContext;
  protected SessionInfo mSessionInfo;
  public int priority;
  
  public xrg(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    this.c = paramBaseChatPie;
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.id = paramInt1;
    this.priority = paramInt2;
  }
  
  public long getDuration()
  {
    return 0L;
  }
  
  public abstract View getView();
  
  public abstract boolean needShow();
  
  public abstract void onClick();
  
  public abstract void onDestroy();
  
  public abstract void onHide();
  
  public abstract void onShow();
  
  public String toString()
  {
    return "NavigateBar{id=" + this.id + ", priority=" + this.priority + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrg
 * JD-Core Version:    0.7.0.1
 */