import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class uow
  extends acfd
{
  public uow(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.this$0) == 0) && (ChatSettingActivity.b(this.this$0) != null) && (ChatSettingActivity.b(this.this$0).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.e(this.this$0).equals(paramString2)))
      {
        if ((ChatSettingActivity.a(this.this$0) != null) && (ChatSettingActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
        {
          ChatSettingActivity.a(this.this$0, 2131694915, 2);
          ChatSettingActivity.a(this.this$0).dismiss();
        }
        ChatSettingActivity.b(this.this$0, paramString2);
        ChatSettingActivity.b(this.this$0, paramString2);
        ChatSettingActivity.c(this.this$0, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.this$0) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.this$0) != null) && (ChatSettingActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing())) {
      ChatSettingActivity.a(this.this$0).dismiss();
    }
    ChatSettingActivity.b(this.this$0, ChatSettingActivity.e(this.this$0));
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      QLog.e("tag_hidden_chat", 1, "data not right");
    }
    label270:
    for (;;)
    {
      return;
      Object localObject = (String[])paramArrayOfObject[0];
      boolean[] arrayOfBoolean = (boolean[])paramArrayOfObject[1];
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "res:", Boolean.valueOf(paramBoolean), " len1:", Integer.valueOf(localObject.length), " len2:", Integer.valueOf(arrayOfBoolean.length) });
      }
      if (paramBoolean)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localObject.length) {
            break label270;
          }
          paramArrayOfObject = localObject[i];
          paramBoolean = arrayOfBoolean[i];
          if (paramArrayOfObject.equals(ChatSettingActivity.b(this.this$0)))
          {
            this.this$0.x.setOnCheckedChangeListener(null);
            this.this$0.x.setChecked(paramBoolean);
            this.this$0.bKL();
            localObject = this.this$0.w;
            if ((!this.this$0.x.isChecked()) && (!this.this$0.y.isChecked())) {}
            for (i = 0;; i = 8)
            {
              ((FormSwitchItem)localObject).setVisibility(i);
              this.this$0.x.setOnCheckedChangeListener(this.this$0);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("tag_hidden_chat", 2, new Object[] { "uin:", paramArrayOfObject, " switch:", Boolean.valueOf(paramBoolean) });
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.b(this.this$0))) && (ChatSettingActivity.a(this.this$0) != null))
    {
      if ((ChatSettingActivity.a(this.this$0) == 1010) || (ChatSettingActivity.a(this.this$0) == 1001) || (ChatSettingActivity.a(this.this$0) == 10002))
      {
        paramString = aqdj.a(this.this$0.app, 200, ChatSettingActivity.b(this.this$0), true);
        ChatSettingActivity.a(this.this$0, new WeakReference(paramString));
        ChatSettingActivity.a(this.this$0).setImageDrawable(paramString);
      }
    }
    else {
      return;
    }
    if (ChatSettingActivity.a(this.this$0) == 1006)
    {
      paramString = aqdj.b(this.this$0.app, ChatSettingActivity.b(this.this$0), (byte)1);
      ChatSettingActivity.a(this.this$0).setImageDrawable(paramString);
      return;
    }
    paramString = aqdj.a(this.this$0.app, 1, ChatSettingActivity.b(this.this$0));
    ChatSettingActivity.a(this.this$0, new WeakReference(paramString));
    ChatSettingActivity.a(this.this$0).setImageDrawable(paramString);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i(ChatSettingActivity.a(this.this$0), 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (String.valueOf(paramObject).equals(ChatSettingActivity.b(this.this$0))) && (this.this$0.s != null) && (this.this$0.s.getVisibility() == 0)) {
      this.this$0.s.setVisibility(8);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, ChatSettingActivity.b(this.this$0))))
    {
      ChatSettingActivity.b(this.this$0, ChatSettingActivity.d(this.this$0, ChatSettingActivity.b(this.this$0)));
      if (ChatSettingActivity.e(this.this$0) == null) {
        ChatSettingActivity.b(this.this$0, "");
      }
      ChatSettingActivity.b(this.this$0, ChatSettingActivity.e(this.this$0));
      ChatSettingActivity.f(this.this$0);
    }
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.g(this.this$0);
    ChatSettingActivity.e(this.this$0);
    if (paramBoolean2) {
      if (!ChatSettingActivity.b(this.this$0).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.this$0, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.b(this.this$0).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.this$0, 2131720207, 1);
      return;
    }
    ChatSettingActivity.a(this.this$0, 2131720205, 1);
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((ChatSettingActivity.a(this.this$0) == 0) && (paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(ChatSettingActivity.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.a(this.this$0), 2, "onUpdateHotFriendLevel");
      }
      ChatSettingActivity.f(this.this$0);
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.a(this.this$0) != null) && (ChatSettingActivity.c(this.this$0) != null) && (paramString.equals(ChatSettingActivity.c(this.this$0))))
    {
      paramString = aqdj.b(this.this$0.app, paramString, (byte)1);
      ChatSettingActivity.a(this.this$0).setImageDrawable(paramString);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (this.this$0.CM != null) && (ChatSettingActivity.a(this.this$0) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.this$0))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.b(this.this$0).equals(str)) {
          ChatSettingActivity.a(this.this$0, ChatSettingActivity.a(this.this$0, ChatSettingActivity.b(this.this$0)), this.this$0.CM);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap)
  {
    if ((this.this$0.CM != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.this$0))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.b(this.this$0)))) {
      ChatSettingActivity.a(this.this$0, (RichStatus)paramMap.get(ChatSettingActivity.b(this.this$0)), this.this$0.CM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */