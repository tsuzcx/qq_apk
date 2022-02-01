import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ybj
  extends afsr
{
  ybj(ybb paramybb) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, aftr paramaftr, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramaftr != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.7.1(this, paramInt2, paramaftr));
    }
  }
  
  protected void a(boolean paramBoolean, afua paramafua, int paramInt)
  {
    if ((paramBoolean) && (paramafua != null))
    {
      ybb.a(this.this$0, paramafua.mNickName);
      this.this$0.mTitleText.setText(paramafua.mNickName);
      if ((!TextUtils.isEmpty(paramafua.mNickName)) && (this.this$0.sessionInfo != null)) {
        this.this$0.sessionInfo.aTn = paramafua.mNickName;
      }
    }
  }
  
  protected void f(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ybb.a(this.this$0, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybj
 * JD-Core Version:    0.7.0.1
 */