import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AddRequestActivity.8.1;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class ufj
  extends acfd
{
  public ufj(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (AddRequestActivity.a(this.this$0))
    {
      if (!paramBoolean) {
        this.this$0.aL(2130840095, this.this$0.getString(2131719483));
      }
    }
    else {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("base_uin", paramString);
    String str = this.this$0.strNickName;
    if (TextUtils.isEmpty(this.this$0.strNickName)) {
      str = this.this$0.aKN;
    }
    localBundle.putString("base_nick", str);
    localBundle.putInt("verfy_type", AddRequestActivity.b(this.this$0));
    localBundle.putString("verfy_msg", AddRequestActivity.a(this.this$0));
    if (AddRequestActivity.a(this.this$0) != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBundle.putBoolean("isFromWzry", paramBoolean);
      AutoRemarkActivity.a(this.this$0, 0, paramString, 0L, localBundle);
      return;
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.aKN != null) && (this.this$0.aKN.equals(paramString))) {
      ThreadManager.post(new AddRequestActivity.8.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufj
 * JD-Core Version:    0.7.0.1
 */