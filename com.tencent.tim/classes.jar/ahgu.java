import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.1;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.2;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.3;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ahgu
  implements DialogInterface.OnClickListener
{
  ahgu(ahgq paramahgq) {}
  
  private void Pd(int paramInt)
  {
    boolean bool;
    String str1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (this.this$0.bf != null)
    {
      bool = this.this$0.bf.getBoolean("from_web", false);
      if (bool)
      {
        str1 = this.this$0.bf.getString("struct_uin");
        if (str1 != null) {
          break label425;
        }
        str1 = "";
        localObject2 = this.this$0.bf.getString("struct_url");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = this.this$0.bf.getString("strurt_msgid");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = AccountDetailActivity.dX((String)localObject1);
        if (paramInt == ahgg.a.V.intValue())
        {
          paramInt = 1002;
          label123:
          String str2 = this.this$0.bf.getString("source_puin");
          if ((str2 == null) || ("".equals(str2))) {
            break label392;
          }
          str1 = this.this$0.bf.getString("uin");
          if ((str1 == null) || (paramInt == 1002)) {
            str1 = "";
          }
          kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", str1, "0X8005B07", "0X8005B07", paramInt, 0, str2, (String)localObject2, (String)localObject1, (String)localObject3, false);
        }
      }
    }
    for (;;)
    {
      if ((this.this$0.bf != null) && (!bool))
      {
        localObject2 = this.this$0.bf.getString("source_puin");
        if (localObject2 != null)
        {
          localObject1 = this.this$0.mIntent.getByteArrayExtra("stuctmsg_bytes");
          if (localObject1 != null)
          {
            localObject3 = anre.a((byte[])localObject1);
            if (localObject3 != null)
            {
              str1 = this.this$0.bf.getString("uin");
              localObject1 = str1;
              if (str1 == null) {
                localObject1 = "";
              }
              kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B06", "0X8005B06", 0, 0, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "", false);
              kbp.d("0X8005B06", (String)localObject1, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "");
            }
          }
        }
      }
      return;
      paramInt = 1001;
      break label123;
      label392:
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, str1, (String)localObject2, (String)localObject1, (String)localObject3, false);
      continue;
      label425:
      break;
      bool = false;
    }
  }
  
  private void Pe(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 10: 
      ahgq.a(this.this$0, "user_click", "more_about", "share", "success");
      return;
    case 11: 
      ahgq.a(this.this$0, "user_click", "custom_button", "share_QQ", "success");
      return;
    }
    ahgq.a(this.this$0, "user_click", "more_button", "share_QQ", "success");
  }
  
  private void dob()
  {
    if ((ahgq.a(this.this$0) != null) && (!ahgq.a(this.this$0).isEmpty()))
    {
      Iterator localIterator = ahgq.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.uinType == 6000) {
          this.this$0.Pa(ahgg.a.W.intValue());
        } else if (localResultRecord.uinType == 6003) {
          this.this$0.Pa(ahgg.a.ab.intValue());
        }
      }
      if ((ahgq.b(this.this$0) == null) || (ahgq.b(this.this$0).isEmpty()))
      {
        this.this$0.mIntent.putExtra("NOCANCEL4DATALIN", true);
        this.this$0.mActivity.setResult(0, this.this$0.mIntent);
        this.this$0.mActivity.finish();
      }
      this.this$0.bf.putParcelableArrayList("forward_multi_target", ahgq.b(this.this$0));
      this.this$0.mIntent.putParcelableArrayListExtra("forward_multi_target", ahgq.b(this.this$0));
    }
    this.this$0.dnv();
    if (this.this$0.isSdkShare) {}
    do
    {
      return;
      if (this.this$0.bf.getBoolean("system_share", false))
      {
        ForwardUtils.k(this.this$0.mActivity, this.this$0.bf);
        return;
      }
      if ((this.this$0.cgT) && (!this.this$0.aWf))
      {
        ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.2(this), 500L);
        return;
      }
      this.this$0.mActivity.finish();
    } while (!this.this$0.mIntent.getBooleanExtra("is_need_show_toast", true));
    ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.3(this), 500L);
  }
  
  private boolean mM(String paramString)
  {
    String str4 = this.this$0.bf.getString("uin");
    int i = this.this$0.bf.getInt("uintype", 0);
    if (((apsw)this.this$0.app.getManager(48)).a(str4, true).cSk)
    {
      QQToast.a(this.this$0.app.getApp(), 2131699615, 0).show(this.this$0.mActivity.getResources().getDimensionPixelSize(2131299627));
      return false;
    }
    boolean bool = false;
    if (this.this$0.bf != null) {
      bool = this.this$0.bf.getBoolean("from_card", false);
    }
    String str3;
    String str1;
    if (bool)
    {
      str3 = this.this$0.bf.getString("pubUin");
      str1 = str3;
      if (str3 == null) {
        str1 = "";
      }
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", str1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    }
    if (this.this$0.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false))
    {
      j = this.this$0.bf.getInt("forward_type");
      str1 = "";
      if (j == 21)
      {
        str1 = "0X800780B";
        anot.a(this.this$0.app, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (this.this$0.mIntent.getBooleanExtra("forward_source_from_pre_guide", false)) {}
      j = this.this$0.getExtras().getInt("key_forward_ability_type");
      QLog.d("ForwardOption.ForwardBaseOption", 1, "-->getConfirmListener--onClick--type = " + j);
    }
    for (;;)
    {
      try
      {
        if ((j != ahgg.a.W.intValue()) && (j != ahgg.a.ab.intValue())) {
          continue;
        }
        this.this$0.Pa(j);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", localThrowable);
        continue;
        if (j != ahgg.a.aa.intValue()) {
          continue;
        }
        this.this$0.dnU();
        continue;
        if (j != ahgg.a.ad.intValue()) {
          continue;
        }
        this.this$0.dnV();
        continue;
        if (j != ahgg.a.V.intValue()) {
          continue;
        }
        String str2 = null;
        if (!(this.this$0.e instanceof aqkk)) {
          continue;
        }
        str2 = ((aqkk)this.this$0.e).gi();
        this.this$0.Ka(str2);
        continue;
        this.this$0.dnv();
        continue;
      }
      if ((this.this$0.mIntent.getBooleanExtra("is_need_show_toast", true)) && (this.this$0.e(i, str4, j))) {
        ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.1(this), 300L);
      }
      if ((this.this$0.bf != null) && (this.this$0.bf.getBoolean("forward_report_confirm")))
      {
        str3 = this.this$0.bf.getString("forward_report_confirm_action_name");
        str4 = this.this$0.bf.getString("forward_report_confirm_reverse2");
        str1 = str3;
        if (str3 == null) {
          str1 = "";
        }
        str3 = str4;
        if (str4 == null) {
          str3 = "";
        }
        anot.a(this.this$0.app, "CliOper", "", "", str1, str1, 0, 0, str3, "", "", "");
      }
      Pd(j);
      if (this.this$0.isSdkShare) {
        arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(paramString), "1000", "50", "0", false, this.this$0.isSdkShare);
      }
      if ((this.this$0.bf != null) && (this.this$0.bf.getInt("extra_key_from_apollo") > 0)) {
        VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
      }
      if ((this.this$0.bf != null) && (this.this$0.bf.getBoolean("KEY_FROM_OCR", false))) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
      }
      if ((this.this$0.bf != null) && (this.this$0.bf.getBoolean("KEY_FROM_TRANSLATE", false))) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
      }
      return true;
      if (j != 1) {
        break;
      }
      str1 = "0X8007811";
      break;
      if (j != ahgg.a.X.intValue()) {
        continue;
      }
      this.this$0.dnS();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1 = this.this$0.bf.getBoolean("needShareCallBack");
    paramInt = this.this$0.bf.getInt("miniAppShareFrom");
    boolean bool2 = this.this$0.bf.getBoolean("miniAppNeedOnlyPreview", false);
    if (bool2) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_suc", null, null);
    }
    do
    {
      for (;;)
      {
        Pe(paramInt);
        paramDialogInterface = this.this$0.bf.getString("miniAppShareAppid");
        paramInt = this.this$0.bf.getInt("miniAppShareAppType");
        int i = this.this$0.bf.getInt("miniAppShareScene");
        int j = this.this$0.bf.getInt("miniAppShareType");
        int k = this.this$0.bf.getInt("uintype");
        String str = this.this$0.bf.getString("uin");
        MiniAppReportShareUtil.getInstance().reportShare(paramDialogInterface, paramInt, i, j, k, str);
        if (!bool2) {
          break;
        }
        return;
        if (bool1) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
        }
      }
      if (this.this$0.anq()) {
        dob();
      }
      while (mM(paramDialogInterface))
      {
        if ((this.this$0.bf != null) && (this.this$0.bf.getBoolean("k_forward_show_direct_share_tips", false))) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
        }
        ahgq.a(this.this$0);
        if (!"caller_aecamera".equals(this.this$0.aNa)) {
          break;
        }
        ahgq.b(this.this$0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "sendToSingleTarget return false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgu
 * JD-Core Version:    0.7.0.1
 */