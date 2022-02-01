import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class uef
  extends acfd
{
  public uef(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      if (paramArrayList == null) {
        break label199;
      }
    }
    label199:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.d("AddFriendVerifyActivity", 2, "onAddBatchPhoneFriend success=" + paramBoolean + ", added count=" + i);
      if (paramBoolean)
      {
        if (this.this$0.u != null) {
          this.this$0.u.dismiss();
        }
        QQToast.a(this.this$0, 2, 2131719496, 0).show(this.this$0.getTitleBarHeight());
        Intent localIntent = new Intent();
        localIntent.putExtra("result", paramArrayList);
        this.this$0.setResult(-1, localIntent);
        this.this$0.finish();
        return;
      }
      if (this.this$0.u != null) {
        this.this$0.u.dismiss();
      }
      AddFriendVerifyActivity.b(this.this$0).clear();
      QQToast.a(this.this$0, 1, 2131718832, 0).show(this.this$0.getTitleBarHeight());
      this.this$0.setResult(0);
      this.this$0.finish();
      return;
    }
  }
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle)
  {
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (paramBoolean)
    {
      str2 = str4;
      str1 = str3;
      if (paramBundle != null)
      {
        AddFriendVerifyActivity.a(this.this$0, paramBundle);
        str1 = paramBundle.getString("security_check_url", "");
        str2 = paramBundle.getString("security_check_buffer", "");
        ymv.a(this.this$0.app, this.this$0, 1004, str1, str2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "onAddFriendSecCheck, isSuccess=" + paramBoolean + "," + TextUtils.isEmpty(str1) + "," + TextUtils.isEmpty(str2));
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(AddFriendVerifyActivity.a(this.this$0), paramString1)) {
      return;
    }
    if (paramBoolean)
    {
      if ((!AutoRemarkActivity.fU(AddFriendVerifyActivity.b(this.this$0))) && (this.this$0.a == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.this$0.as.setText(paramString2);
      }
      try
      {
        this.this$0.as.setSelection(this.this$0.as.getText().length());
        if (AppSetting.enableTalkBack) {
          AddFriendVerifyActivity.a(this.this$0).setContentDescription(this.this$0.getResources().getString(2131694937) + this.this$0.as.getText().toString());
        }
        AddFriendVerifyActivity.a(this.this$0, paramInt);
        this.this$0.BJ.setText(AutoRemarkActivity.e(this.this$0.app, AddFriendVerifyActivity.c(this.this$0)));
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
          }
        }
      }
    }
    AddFriendVerifyActivity.a(this.this$0, 0);
    this.this$0.BJ.setText(AutoRemarkActivity.e(this.this$0.app, AddFriendVerifyActivity.c(this.this$0)));
  }
  
  protected void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.a(this.this$0))) && (!TextUtils.isEmpty(paramString2)))
    {
      AddFriendVerifyActivity.a(this.this$0).setText(paramString2);
      if (AppSetting.enableTalkBack) {
        AddFriendVerifyActivity.a(this.this$0).setContentDescription(paramString2);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, AddFriendVerifyActivity.a(this.this$0))) {}
    do
    {
      return;
      if (paramBoolean1)
      {
        if (paramBundle.getInt("friend_setting") == 3)
        {
          if (paramBoolean2)
          {
            this.this$0.b(this.this$0.aq.getText().toString().trim(), paramBundle.getByteArray("sig"), paramBundle.getString("security_ticket", ""));
            return;
          }
          if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
          for (paramString = paramBundle.getString("ErrorString");; paramString = this.this$0.getString(2131690316))
          {
            QQToast.a(this.this$0, 1, paramString, 1).show(this.this$0.getTitleBarHeight());
            return;
          }
        }
        if (paramBundle.getInt("resultCode") == 0)
        {
          int i = paramBundle.getInt("friend_setting");
          if (paramBundle.getString("nick_name") == null) {}
          switch (i)
          {
          default: 
            if (this.this$0.u != null)
            {
              this.this$0.u.cancel();
              this.this$0.u = null;
            }
            QQToast.a(this.this$0, 2, 2131718829, 0).show(this.this$0.getTitleBarHeight());
            this.this$0.goBack();
            return;
          case 0: 
          case 100: 
            if (this.this$0.u != null)
            {
              this.this$0.u.cancel();
              this.this$0.u = null;
            }
            QQToast.a(this.this$0, 2, 2131689767, 0).show(this.this$0.getTitleBarHeight());
            if (aqft.rj(paramString))
            {
              paramBundle = this.this$0.as.getText().toString();
              Object localObject = AddFriendVerifyActivity.a(this.this$0).getText().toString();
              if (TextUtils.isEmpty(paramBundle)) {
                paramBundle = (Bundle)localObject;
              }
              for (;;)
              {
                localObject = wja.a(new Intent(this.this$0, SplashActivity.class), null);
                ((Intent)localObject).putExtra("uin", paramString);
                ((Intent)localObject).putExtra("uintype", 0);
                ((Intent)localObject).putExtra("uinname", paramBundle);
                this.this$0.startActivity((Intent)localObject);
                ((acbs)this.this$0.app.getBusinessHandler(53)).de(this.this$0.getIntent());
                return;
              }
            }
            this.this$0.goBack();
            return;
          }
          if (this.this$0.u != null)
          {
            this.this$0.u.cancel();
            this.this$0.u = null;
          }
          QQToast.a(this.this$0, 2, 2131718829, 0).show(this.this$0.getTitleBarHeight());
          this.this$0.goBack();
          return;
        }
        if (this.this$0.u != null)
        {
          this.this$0.u.cancel();
          this.this$0.u = null;
        }
        paramBundle = paramBundle.getString("ErrorString");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "add friend response error and ErroString = " + paramBundle);
        }
        paramString = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramString = this.this$0.getString(2131718832);
        }
        AddFriendVerifyActivity.a(this.this$0, paramString);
        return;
      }
      if (this.this$0.u != null)
      {
        this.this$0.u.cancel();
        this.this$0.u = null;
      }
      AddFriendVerifyActivity.a(this.this$0, this.this$0.getString(2131718832));
    } while (!QLog.isColorLevel());
    QLog.d("AddFriendVerifyActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uef
 * JD-Core Version:    0.7.0.1
 */