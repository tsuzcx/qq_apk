import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class anso
  implements View.OnClickListener
{
  anso(ansl paramansl) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.time < 1000L) {}
    label136:
    label986:
    label989:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.time = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (ansl.class.isInstance(localObject1)))
      {
        Object localObject2 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131378856);
        if ((localObject2 != null) && (StructMsgForGeneralShare.class.isInstance(localObject2)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject2;
          ansl localansl = (ansl)localObject1;
          Context localContext = paramView.getContext();
          if ((localContext instanceof FragmentActivity))
          {
            localObject1 = ((FragmentActivity)localContext).getChatFragment();
            if (localObject1 != null) {
              localObject1 = ((ChatFragment)localObject1).getApp();
            }
            for (;;)
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label989;
                }
                localObject2 = "0";
                if (localStructMsgForGeneralShare.message != null) {
                  localObject2 = localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg");
                }
                if ("1".equals(localObject2)) {}
                try
                {
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject2).put("type", localansl.index_type);
                  ((JSONObject)localObject2).put("index", localansl.index);
                  ((JSONObject)localObject2).put("name", localansl.index_name);
                  ((JSONObject)localObject2).put("net", String.valueOf(jqc.getNetWorkType()));
                  ((JSONObject)localObject2).put("mobile_imei", aqgz.getIMEI());
                  ((JSONObject)localObject2).put("obj", "");
                  ((JSONObject)localObject2).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject2).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  obl.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject2).toString(), "" + localStructMsgForGeneralShare.msgId);
                  localObject2 = new anra((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare.message);
                  bool = ((kdm)((QQAppInterface)localObject1).getManager(88)).a(this.a, (Activity)localContext);
                  if (!bool) {
                    if (localansl.ayZ()) {
                      if (localansl.ayY())
                      {
                        anot.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                        anot.a(null, "P_CliOper", "Vip_pay_mywallet", ((QQAppInterface)localObject1).getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, localStructMsgForGeneralShare.uin, "", String.valueOf(localStructMsgForGeneralShare.msgId), "");
                        if (TextUtils.isEmpty(this.a.cgZ)) {
                          localObject2 = this.a.cgY;
                        }
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    boolean bool;
                    try
                    {
                      localObject2 = new JSONObject((String)localObject2);
                      VACDReportUtil.a("orderId=" + ((JSONObject)localObject2).optString("orderId"), "qqwallet", "publicpaymsg.pay.click", null, null, 0, null);
                      zxx localzxx = (zxx)((QQAppInterface)localObject1).getManager(135);
                      localzxx.mContext = localContext;
                      localzxx.a(localStructMsgForGeneralShare.message.frienduin, (JSONObject)localObject2, new ansp(this, localStructMsgForGeneralShare, localContext));
                      if ((bool) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
                        kaw.f((QQAppInterface)localObject1, localStructMsgForGeneralShare.uin);
                      }
                      localObject2 = (asgx)((QQAppInterface)localObject1).getManager(165);
                      if (asgx.E(localansl.cgZ, localansl.cgY, localansl.ku)) {
                        ((asgx)localObject2).c(localansl.cgX, localansl.cgZ, localansl.cgY, localansl.ku, 2, "");
                      }
                      if ((localStructMsgForGeneralShare.message != null) && (asgx.j((QQAppInterface)localObject1, localStructMsgForGeneralShare.message))) {
                        ((asgx)localObject2).XK(localansl.cgY);
                      }
                      if (localStructMsgForGeneralShare.msgId <= 0L) {
                        break;
                      }
                      ThreadManager.getSubThreadHandler().postDelayed(new StructMsgItemButton.3.2(this, localansl, localStructMsgForGeneralShare, (QQAppInterface)localObject1, bool), 0L);
                      break;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if (!(localObject1 instanceof QQAppInterface)) {
                        break label986;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break label136;
                      localJSONException = localJSONException;
                      localJSONException.printStackTrace();
                      continue;
                      String str = this.a.cgZ;
                      continue;
                    }
                    catch (Exception localException)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("StructMsgItemButton", 2, "pay error:" + localException.getMessage());
                      continue;
                    }
                    paramView.setClickable(false);
                    paramView.setOnClickListener(null);
                    paramView.setOnTouchListener(null);
                    paramView.setOnLongClickListener(null);
                    continue;
                    if (localStructMsgForGeneralShare.message != null)
                    {
                      localansl.ku = kdm.a(localStructMsgForGeneralShare.message.frienduin, localansl.ku, (QQAppInterface)localObject1);
                      if ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                        bool = localException.a(localansl.cgX, localansl.ku, localansl.cgY, localansl.cgZ, localansl.msgId, new Object[] { Boolean.valueOf(true) });
                      } else {
                        bool = localException.a(localansl.cgX, localansl.ku, localansl.cgY, localansl.cgZ, localStructMsgForGeneralShare.msgId, new Object[0]);
                      }
                    }
                  }
                  localObject1 = null;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anso
 * JD-Core Version:    0.7.0.1
 */