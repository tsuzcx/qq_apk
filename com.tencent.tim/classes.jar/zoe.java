import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zoe
  implements wvs
{
  private QQAppInterface app;
  public boolean blg;
  private zof c;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public zoe(zof paramzof)
  {
    this.app = paramzof.mApp;
    this.mContext = paramzof.mContext;
    this.c = paramzof;
    this.sessionInfo = paramzof.mSessionInfo;
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 9, 13 };
  }
  
  public void Ck(int paramInt)
  {
    QLog.i("MiniMultiForwardHelper", 2, "RESUME onMoveToState：=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      this.blg = BaseChatItemLayout.bdx;
      BaseChatItemLayout.bdx = false;
      QLog.i("MiniMultiForwardHelper", 2, "RESUME mPreCheckBoxVisibleStat：=" + this.blg + "  BaseChatItemLayout.CheckBoxVisible :" + BaseChatItemLayout.bdx);
      return;
    }
    BaseChatItemLayout.bdx = this.blg;
    QLog.i("MiniMultiForwardHelper", 2, "RESUME mPreCheckBoxVisibleStat：=" + this.blg + "  BaseChatItemLayout.CheckBoxVisible :" + BaseChatItemLayout.bdx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoe
 * JD-Core Version:    0.7.0.1
 */