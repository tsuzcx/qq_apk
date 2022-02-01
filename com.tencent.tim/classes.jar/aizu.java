import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aizu
  extends afsr
{
  public aizu(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void aB(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((this.a.mContext != null) && (this.a.mContext.isResume()) && (!MatchChatMsgListFragment.a(this.a))) {
      MatchChatMsgListFragment.a(this.a, afwz.a(this.a.mContext, this.a.mContext.app, MatchChatMsgListFragment.a(this.a)));
    }
  }
  
  protected void f(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    MatchChatMsgListFragment.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizu
 * JD-Core Version:    0.7.0.1
 */