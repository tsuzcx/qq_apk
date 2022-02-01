import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class upk
  extends MqqHandler
{
  public upk(ChatSettingActivity paramChatSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    }
    Object localObject;
    boolean bool1;
    label308:
    label461:
    label757:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramMessage = (String)paramMessage.obj;
                ChatSettingActivity.a(this.this$0, paramMessage);
                return;
              } while (ChatSettingActivity.a(this.this$0) != 0);
              paramMessage = (String)paramMessage.obj;
            } while ((ChatSettingActivity.b(this.this$0) == null) || (paramMessage == null) || (!ChatSettingActivity.b(this.this$0).equals(paramMessage)));
            this.this$0.finish();
            return;
            StringBuilder localStringBuilder;
            if ((ChatSettingActivity.a(this.this$0) != 1001) && (ChatSettingActivity.a(this.this$0) != 10002)) {
              if (ChatSettingActivity.a(this.this$0) == 1006)
              {
                if (TextUtils.isEmpty(ChatSettingActivity.c(this.this$0))) {
                  ChatSettingActivity.b(this.this$0, false);
                }
              }
              else
              {
                paramMessage = (aizg)this.this$0.app.getManager(16);
                if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.this$0)))) {
                  ChatSettingActivity.a(this.this$0, paramMessage.nf(ChatSettingActivity.d(this.this$0)));
                }
                if (QLog.isColorLevel())
                {
                  localObject = this.this$0.aLY;
                  localStringBuilder = new StringBuilder().append("handleMessage, shieldMsgManger=");
                  if (paramMessage != null) {
                    break label461;
                  }
                  bool1 = true;
                  QLog.d((String)localObject, 2, bool1);
                }
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.this$0.aLY, 2, "handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=" + ChatSettingActivity.a(this.this$0) + ", mIsFollowed=" + this.this$0.mIsFollowed + ", mShieldEnable=" + ChatSettingActivity.b(this.this$0));
              }
              ChatSettingActivity.b(this.this$0);
              return;
              paramMessage = aqgv.x(this.this$0.app, ChatSettingActivity.c(this.this$0));
              if (TextUtils.isEmpty(paramMessage))
              {
                ChatSettingActivity.b(this.this$0, false);
                break;
              }
              ChatSettingActivity.b(this.this$0, true);
              ChatSettingActivity.a(this.this$0, paramMessage);
              break;
              bool1 = false;
              break label308;
              paramMessage = (acff)this.this$0.app.getManager(51);
              if (paramMessage != null)
              {
                paramMessage = paramMessage.e(ChatSettingActivity.d(this.this$0));
                if (QLog.isColorLevel())
                {
                  localObject = this.this$0.aLY;
                  localStringBuilder = new StringBuilder().append("handleMessage, f=");
                  if (paramMessage != null) {
                    break label574;
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d((String)localObject, 2, bool1);
                  if ((paramMessage == null) || (paramMessage.groupid != -1002)) {
                    break label579;
                  }
                  ChatSettingActivity.a(this.this$0, true);
                  break;
                }
                ChatSettingActivity.a(this.this$0, false);
              }
            }
            ChatSettingActivity.e(this.this$0);
            return;
            ChatSettingActivity.f(this.this$0);
            return;
          } while (!((String)paramMessage.obj).equals(ChatSettingActivity.b(this.this$0)));
          bool1 = FriendsStatusUtil.k(this.this$0.app, ChatSettingActivity.b(this.this$0), ChatSettingActivity.a(this.this$0));
        } while ((this.this$0.A == null) || (bool1 == this.this$0.A.isChecked()));
        this.this$0.A.setOnCheckedChangeListener(null);
        this.this$0.A.setChecked(bool1);
        this.this$0.A.setOnCheckedChangeListener(this.this$0);
        return;
        localObject = (String)paramMessage.obj;
      } while ((this.this$0.w == null) || (!((String)localObject).equals(ChatSettingActivity.b(this.this$0))));
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if (bool1 == this.this$0.w.isChecked()) {
          break label833;
        }
        this.this$0.w.setOnCheckedChangeListener(null);
        localObject = this.this$0.w;
        if (paramMessage.arg1 != 1) {
          break label835;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.this$0.bKL();
        this.this$0.w.setOnCheckedChangeListener(this.this$0);
        return;
        bool1 = false;
        break label757;
        break;
      }
      localObject = (String)paramMessage.obj;
    } while ((this.this$0.x == null) || (!((String)localObject).equals(ChatSettingActivity.b(this.this$0))));
    label574:
    label579:
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      label884:
      if (bool1 == this.this$0.x.isChecked()) {
        break label999;
      }
      this.this$0.x.setOnCheckedChangeListener(null);
      localObject = this.this$0.x;
      if (paramMessage.arg1 != 1) {
        break label1001;
      }
      bool1 = bool3;
      ((FormSwitchItem)localObject).setChecked(bool1);
      this.this$0.bKL();
      paramMessage = this.this$0.w;
      if ((this.this$0.x.isChecked()) || (this.this$0.y.isChecked())) {
        break label1006;
      }
    }
    for (;;)
    {
      label833:
      label835:
      paramMessage.setVisibility(i);
      label929:
      this.this$0.x.setOnCheckedChangeListener(this.this$0);
      return;
      bool1 = false;
      break label884;
      label999:
      break;
      label1001:
      bool1 = false;
      break label929;
      label1006:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upk
 * JD-Core Version:    0.7.0.1
 */