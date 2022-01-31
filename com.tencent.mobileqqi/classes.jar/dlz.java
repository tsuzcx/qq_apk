import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public class dlz
  extends MessageObserver
{
  public dlz(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i(SubAccountMessageActivity.a(this.a), 2, "onPushSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i(SubAccountMessageActivity.a(this.a), 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    paramString = this.a.getString(2131562520);
    if (paramSubAccountBackProtocData == null) {
      return;
    }
    if (paramSubAccountBackProtocData.p == 0) {}
    for (int i = 2131563288;; i = 2131563291)
    {
      paramSubAccountBackProtocData = this.a.getString(i);
      this.a.a(paramString, paramSubAccountBackProtocData, this.a.getString(2131562543), new dma(this));
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = SubAccountMessageActivity.a(this.a);
      paramString1 = new StringBuilder().append("onSubAccountMsgNumConfirm isSucc=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (!paramBoolean)
      {
        bool1 = true;
        QLog.d(str, 2, bool1 + " nextAction=" + paramString2);
      }
    }
    else
    {
      paramString1 = this.a;
      if (paramBoolean) {
        break label137;
      }
      paramBoolean = bool2;
      label92:
      SubAccountMessageActivity.a(paramString1, paramBoolean);
      if (!"sub.account.unbind".equals(paramString2)) {
        break label142;
      }
      SubAccountAssistantManager.a().a(this.a.b, SubAccountMessageActivity.a(this.a).subuin);
    }
    label137:
    label142:
    while (!"sub.account.switchAccount".equals(paramString2))
    {
      return;
      bool1 = false;
      break;
      paramBoolean = false;
      break label92;
    }
    SubAccountMessageActivity.b(this.a);
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    int i = 2;
    if (QLog.isColorLevel())
    {
      QLog.i(SubAccountMessageActivity.a(this.a), 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i(SubAccountMessageActivity.a(this.a), 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    Object localObject = SubAccountMessageActivity.a(this.a);
    if (paramBoolean) {
      i = 0;
    }
    ((PullRefreshHeader)localObject).a(i);
    SubAccountMessageActivity.a(this.a, 800L);
    if (paramBoolean)
    {
      SubAccountMessageActivity.c(this.a);
      SubAccountMessageActivity.d(this.a);
    }
    for (;;)
    {
      SubAccountMessageActivity.b(this.a, false);
      return;
      if ((!paramBoolean) && (paramSubAccountBackProtocData != null))
      {
        localObject = this.a.getString(2131562517);
        switch (paramSubAccountBackProtocData.p)
        {
        case 1001: 
        case 1006: 
        case 1007: 
        case 1003: 
        case 1005: 
        case 1009: 
        default: 
          break;
        case 1002: 
          paramString = this.a.getString(2131563038);
          SubAccountMessageActivity.a(this.a, (String)localObject, paramString);
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            switch (paramSubAccountBackProtocData.q)
            {
            default: 
              localObject = this.a.getString(2131561673);
            }
          }
          for (;;)
          {
            SubAccountMessageActivity.a(this.a, 0, (String)localObject, paramString);
            break;
            localObject = this.a.getString(2131561673);
            continue;
            localObject = this.a.getString(2131561672);
            continue;
            localObject = this.a.getString(2131562586);
          }
        case 1008: 
          paramString = this.a.getString(2131563039);
          SubAccountMessageActivity.a(this.a, (String)localObject, paramString);
          break;
        case 1010: 
          if (SubAccountMessageActivity.b(this.a))
          {
            localObject = this.a.getString(2131561673);
            paramString = null;
            if (paramSubAccountBackProtocData != null) {
              paramString = paramSubAccountBackProtocData.c;
            }
            SubAccountMessageActivity.a(this.a, 1, (String)localObject, paramString);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlz
 * JD-Core Version:    0.7.0.1
 */