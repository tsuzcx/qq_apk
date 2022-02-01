import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class uhi
  extends aclm
{
  public uhi(AuthDevActivity paramAuthDevActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    if ((paramBoolean) && (AuthDevActivity.b(this.this$0) != null) && (paramInt >= 0) && (paramInt < AuthDevActivity.b(this.this$0).size()))
    {
      Object localObject = (SvcDevLoginInfo)AuthDevActivity.b(this.this$0).get(paramInt);
      if (Arrays.equals(((SvcDevLoginInfo)localObject).stDeviceItemDes.vecItemDes, paramArrayOfByte))
      {
        ((SvcDevLoginInfo)localObject).strDeviceName = paramString;
        AuthDevActivity.a(this.this$0, AuthDevActivity.b(this.this$0));
      }
      localObject = this.this$0.app.getHandler(LoginInfoActivity.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1);
        Bundle localBundle = new Bundle();
        localBundle.putString(AuthDevRenameActivity.aLp, paramString);
        localBundle.putByteArray(AuthDevRenameActivity.aLr, paramArrayOfByte);
        ((Message)localObject).setData(localBundle);
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  protected void m(int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBundle == null) {
      return;
    }
    paramInt = paramBundle.getInt("cmd", 1);
    int i = paramBundle.getInt("opt", 2);
    int j = paramBundle.getInt("ret", -1);
    paramBundle = (String)paramBundle.get("wording");
    FormSwitchItem localFormSwitchItem;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (j == 0)
      {
        AuthDevActivity.a(this.this$0).setVisibility(0);
        AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(null);
        localFormSwitchItem = AuthDevActivity.a(this.this$0);
        if (i == 1) {}
        for (;;)
        {
          localFormSwitchItem.setChecked(bool1);
          AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
          AuthDevActivity.b(this.this$0).setVisibility(0);
          AuthDevActivity.b(this.this$0).setText(paramBundle);
          return;
          bool1 = false;
        }
      }
      AuthDevActivity.a(this.this$0).setVisibility(8);
      AuthDevActivity.b(this.this$0).setVisibility(8);
      return;
    }
    if (j == 0)
    {
      AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(null);
      localFormSwitchItem = AuthDevActivity.a(this.this$0);
      if (i == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localFormSwitchItem.setChecked(bool1);
        AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
        AuthDevActivity.b(this.this$0).setText(paramBundle);
        return;
      }
    }
    AuthDevActivity.a(this.this$0).setVisibility(8);
    AuthDevActivity.b(this.this$0).setVisibility(8);
    QQToast.a(this.this$0, paramBundle, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */