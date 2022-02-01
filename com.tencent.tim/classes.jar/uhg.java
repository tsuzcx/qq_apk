import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;

public class uhg
  extends acfd
{
  public uhg(AuthDevActivity paramAuthDevActivity) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onDelAuthDevResult.isSuccess=", Boolean.valueOf(paramBoolean), " errorMsg=", paramString, " index=", Integer.valueOf(paramInt) });
    AuthDevActivity.c(this.this$0);
    Object localObject;
    if (AuthDevActivity.a(this.this$0)) {
      localObject = AuthDevActivity.b(this.this$0);
    }
    while (paramBoolean)
    {
      if ((paramInt > -1) && (paramInt < ((List)localObject).size()))
      {
        paramString = (SvcDevLoginInfo)((List)localObject).get(paramInt);
        if (Arrays.equals(NetConnInfoCenter.GUID, paramString.vecGuid))
        {
          this.this$0.app.updateSubAccountLogin(this.this$0.app.getAccount(), false);
          this.this$0.app.getApplication().refreAccountList();
          aqeu.a(this.this$0, this.this$0.app, true);
          paramString = this.this$0.app.getManager(1);
          if (paramString != null)
          {
            paramString = (WtloginManager)paramString;
            localObject = this.this$0.app.getAccount();
            paramString.ClearUserFastLoginData((String)localObject, 16L);
            paramString.ClearUserFastLoginData((String)localObject, 1600001540L);
            paramString.RefreshMemorySig();
          }
          return;
          localObject = AuthDevActivity.a(this.this$0);
          continue;
        }
        if (paramInt < ((List)localObject).size())
        {
          ((List)localObject).remove(paramInt);
          AuthDevActivity.a(this.this$0, (List)localObject);
        }
      }
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getString(2131693197), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getString(2131693196), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    AuthDevActivity.c(this.this$0);
    if (paramBoolean)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (AuthDevActivity.a(this.this$0) != null) && (paramInt < AuthDevActivity.a(this.this$0).size()))
      {
        AuthDevActivity.a(this.this$0).remove(paramInt);
        AuthDevActivity.a(this.this$0, AuthDevActivity.a(this.this$0));
      }
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getString(2131693197), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getString(2131696145), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.this$0).setVisibility(8);
    if (!AuthDevActivity.a(this.this$0)) {
      return;
    }
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.success");
      AuthDevActivity.b(this.this$0, paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = AuthDevActivity.b(this.this$0).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.AuthDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
      }
      AuthDevActivity.a(this.this$0, AuthDevActivity.b(this.this$0));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.isSuccess=" + paramBoolean);
    if (paramSvcRspGetDevLoginInfo == null) {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data is null");
    }
    for (;;)
    {
      AuthDevActivity.a(this.this$0).setVisibility(4);
      QQToast.a(this.this$0, 1, this.this$0.getString(2131693213), 0).show(this.this$0.getTitleBarHeight());
      return;
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.this$0).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetHistoryDevResult success");
      AuthDevActivity.a(this.this$0).addAll(paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      AuthDevActivity.a(this.this$0, AuthDevActivity.a(this.this$0));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetHistoryDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131693213), 0).show(this.this$0.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.this$0).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetLoginDevResult success");
      AuthDevActivity.a(this.this$0, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      AuthDevActivity.a(this.this$0).addAll(0, AuthDevActivity.c(this.this$0));
      AuthDevActivity.a(this.this$0, AuthDevActivity.a(this.this$0));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetLoginDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131693213), 0).show(this.this$0.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhg
 * JD-Core Version:    0.7.0.1
 */