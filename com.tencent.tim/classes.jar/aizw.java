import android.text.TextUtils;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;

public class aizw
  extends acfd
{
  public aizw(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.nj(paramString))) {
      this.a.cWP();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, "onUpdateFriendInfo uin =" + paramString);
      }
      int i = 0;
      if (this.a.nj(paramString)) {
        i = 1;
      }
      if (i != 0) {
        this.a.cWP();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizw
 * JD-Core Version:    0.7.0.1
 */