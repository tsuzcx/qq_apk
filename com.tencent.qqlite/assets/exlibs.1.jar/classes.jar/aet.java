import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.Map;

public class aet
  extends FriendListObserver
{
  public aet(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.d(this.a);
    ChatSettingActivity.c(this.a);
    if (paramBoolean2) {
      if (!ChatSettingActivity.a(this.a).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.a, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.a(this.a).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.a, 2131363426, 1);
      return;
    }
    ChatSettingActivity.a(this.a, 2131363427, 1);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a) != null))
    {
      if (ChatSettingActivity.a(this.a) != 1001) {
        break label79;
      }
      paramString = FaceDrawable.a(this.a.app, 3000, ChatSettingActivity.a(this.a), true);
    }
    for (;;)
    {
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      return;
      label79:
      if (ChatSettingActivity.a(this.a) == 1006) {
        paramString = this.a.app.a(ChatSettingActivity.a(this.a), (byte)3);
      } else {
        paramString = FaceDrawable.a(this.a.app, 1, ChatSettingActivity.a(this.a));
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.d(this.a).equals(paramString2)))
      {
        ChatSettingActivity.a(this.a, 2131363899, 2);
        if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
          ChatSettingActivity.a(this.a).dismiss();
        }
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.c(this.a, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.a) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
    ChatSettingActivity.b(this.a, ChatSettingActivity.d(this.a));
  }
  
  protected void a(boolean paramBoolean, Map paramMap) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Map paramMap)
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.a(this.a)))) {
      ChatSettingActivity.a(this.a, (RichStatus)paramMap.get(ChatSettingActivity.a(this.a)), this.a.a);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.b(this.a) != null) && (paramString.equals(ChatSettingActivity.b(this.a))))
    {
      paramString = this.a.app.a(paramString, (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((this.a.a != null) && (ChatSettingActivity.a(this.a) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.a(this.a).equals(str)) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.a);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aet
 * JD-Core Version:    0.7.0.1
 */