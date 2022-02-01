import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.1.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg.b;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class anqt
  implements View.OnClickListener
{
  private long lastClickTime;
  
  public anqt(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.lastClickTime < 1000L) {}
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    QQAppInterface localQQAppInterface;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.lastClickTime = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (AbsShareMsg.class.isInstance(localObject1)))
      {
        localAbsShareMsg = (AbsShareMsg)localObject1;
        localContext = paramView.getContext();
        if ((SplashActivity.class.isInstance(localContext)) || (ChatActivity.class.isInstance(localContext))) {
          if (localContext == null)
          {
            QLog.e("StructMsg", 1, "context is null, never do click, return");
          }
          else
          {
            localObject1 = ((FragmentActivity)localContext).getChatFragment();
            if (localObject1 == null)
            {
              QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
            }
            else
            {
              localQQAppInterface = ((ChatFragment)localObject1).getApp();
              if (localQQAppInterface != null)
              {
                if ((this.e.mSourceActionData == null) || (!this.e.mSourceActionData.startsWith("mqqapi://qsubscribe"))) {
                  break;
                }
                QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
                try
                {
                  localObject1 = new Intent(localContext, JumpActivity.class);
                  ((Intent)localObject1).setData(Uri.parse(this.e.mSourceActionData));
                  ((Intent)localObject1).putExtra("from", "from_aio");
                  localContext.startActivity((Intent)localObject1);
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
    Object localObject5 = new AbsShareMsg.b(this.e, localQQAppInterface, paramView);
    Object localObject3 = this.e.mSourceAction;
    Object localObject2 = localObject3;
    if (this.e.mSourceAction.equals("web"))
    {
      localObject2 = localObject3;
      if (this.e.mSourceUrl.contains("webcard.mp.qq.com"))
      {
        localObject3 = this.e;
        localObject2 = "plugin";
        ((AbsShareMsg)localObject3).mSourceAction = "plugin";
        this.e.mSource_A_ActionData = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.e.source_puin });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + (String)localObject2);
    }
    if ("app".equals(localObject2)) {
      if ((this.e.mMsgActionData != null) && (this.e.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        localObject2 = new Intent(localContext, VipComicJumpActivity.class);
        ((Intent)localObject2).putExtra("options", "{\"from\":28}");
        localContext.startActivity((Intent)localObject2);
        localObject3 = xtj.i(this.e.mMsgActionData);
        if ((localObject3 != null) && (localObject3.length >= 8))
        {
          if (!localObject3[7].equals("link")) {
            break label1128;
          }
          localObject2 = localObject3[4];
        }
      }
    }
    for (;;)
    {
      avdb.a(null, this.e.uin, localContext, "3009", "2", "40059", localObject3[0], new String[] { localObject3[2], localObject3[4], localObject2 });
      localObject2 = "";
      label527:
      arts.a().a(localQQAppInterface.getAccount(), "", String.valueOf(this.e.mSourceAppid), "1000", "80", "0", false);
      label557:
      jqo.a(localQQAppInterface, this.e.uin, "sourceclick", this.e.mSourceAppid, this.e.mMsgServiceID, (String)localObject2);
      anot.a(localQQAppInterface, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.e.mMsgServiceID + "", "", "", "");
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, this.e.mMsgServiceID + "", "", "", "");
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, this.e.mMsgServiceID + "", "", this.e.mSourceName, "");
      if (this.e.adverSign == 1) {
        anot.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.e.uin, "0X800631F", "0X800631F", 0, 0, "" + this.e.msgId, "", "", "");
      }
      if (this.e.mMsgServiceID == 114) {
        ThreadManager.post(new AbsShareMsg.1.1(this, localQQAppInterface), 0, null, false);
      }
      label919:
      label1128:
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
      {
        localObject3 = (StructMsgForGeneralShare)localAbsShareMsg;
        localObject5 = ((StructMsgForGeneralShare)localObject3).iterator();
        label876:
        while (((Iterator)localObject5).hasNext())
        {
          localObject2 = (anqu)((Iterator)localObject5).next();
          if ((localObject2 instanceof antz))
          {
            Iterator localIterator = ((antz)localObject2).rz.iterator();
            anvf localanvf;
            String str2;
            String str3;
            while (localIterator.hasNext())
            {
              localObject2 = (anqu)localIterator.next();
              if ((localObject2 instanceof anvf))
              {
                localanvf = (anvf)localObject2;
                if (localanvf.aza())
                {
                  localObject2 = new nce.a(null, ((StructMsgForGeneralShare)localObject3).source_puin, localanvf.ciu, localanvf.Wz);
                  ((nce.a)localObject2).a("aio_app_id", Long.valueOf(((StructMsgForGeneralShare)localObject3).mSourceAppid));
                  str2 = ((nce.a)localObject2).a().toJsonString();
                  localObject2 = "";
                  if (((StructMsgForGeneralShare)localObject3).uinType != 1008) {
                    break label2149;
                  }
                  localObject2 = "1";
                  kbp.a(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, (String)localObject2, Integer.toString(kct.l(localanvf.type, ((StructMsgForGeneralShare)localObject3).mSourceName)), "", str2, false);
                  str3 = ((StructMsgForGeneralShare)localObject3).source_puin;
                  if (localanvf.Wz == null) {
                    break label2200;
                  }
                }
              }
            }
            for (localObject2 = localanvf.Wz;; localObject2 = "0")
            {
              kbp.a(localQQAppInterface, str3, "0x8007410", "0x8007410", 0, 0, "1", "", (String)localObject2, str2, false);
              break label919;
              break label876;
              if ((!localObject3[7].equals("scrawl_link")) || (localObject3.length < 9)) {
                break label2326;
              }
              localObject2 = localObject3[8];
              break;
              if (((AbsShareMsg.b)localObject5).j(this.e.mSourceUrl, this.e.mSourceActionData, this.e.mSource_A_ActionData))
              {
                localObject3 = "run";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (localObject2 = "";; localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  anot.a(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, (String)localObject2, "", "", "");
                  localObject2 = localObject3;
                  break;
                }
              }
              if (((AbsShareMsg.b)localObject5).click2YYB(((FragmentActivity)localContext).getActivity(), this.e.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
              {
                localObject3 = "setup";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (localObject2 = "";; localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  anot.a(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, (String)localObject2, "", "", "");
                  localObject2 = localObject3;
                  break;
                }
              }
              ((AbsShareMsg.b)localObject5).clickWebMsg(this.e.mSourceUrl);
              localObject2 = "setup";
              break label527;
              if ("web".equals(localObject2))
              {
                localObject3 = this.e.mSourceUrl;
                if (this.e.mMsgServiceID == 114)
                {
                  localObject2 = ((MedalWallMng)localQQAppInterface.getManager(250)).b(true, localQQAppInterface.getCurrentAccountUin(), MedalWallMng.dhv);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1"))) {
                    break label1661;
                  }
                  localObject3 = aqik.c(localQQAppInterface, localContext, (String)localObject2);
                  if (localObject3 == null) {
                    break label1634;
                  }
                  ((aqhv)localObject3).ace();
                  anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject2, "", "", "");
                }
                for (;;)
                {
                  localObject2 = "setup";
                  break;
                  localObject2 = localObject3;
                  if (localAbsShareMsg.uinType != 1) {
                    break label1440;
                  }
                  if (this.e.mMsgServiceID != 116)
                  {
                    localObject2 = localObject3;
                    if (this.e.mMsgServiceID != 123) {
                      break label1440;
                    }
                  }
                  localObject3 = String.format("%s&gc=%s", new Object[] { localObject3, ajri.encode(localAbsShareMsg.uin) });
                  localObject2 = localObject3;
                  if (!QLog.isColorLevel()) {
                    break label1440;
                  }
                  QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + localAbsShareMsg.uin);
                  localObject2 = localObject3;
                  break label1440;
                  localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject2)));
                  break label1481;
                  label1661:
                  ((AbsShareMsg.b)localObject5).clickWebMsg((String)localObject2);
                }
              }
              if ("plugin".equals(localObject2))
              {
                if ((localAbsShareMsg.uinType == 1) && (this.e.mMsgServiceID == 123))
                {
                  this.e.mSourceActionData = aehj.aR(this.e.mSourceActionData, localAbsShareMsg.uin);
                  boolean bool = aehj.E(localQQAppInterface, localAbsShareMsg.uin);
                  localObject2 = this.e.mMsgUrl;
                  if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject2)) && ((localContext instanceof FragmentActivity)))
                  {
                    localObject5 = ((FragmentActivity)localContext).getChatFragment();
                    if (localObject5 != null)
                    {
                      localObject2 = ((ChatFragment)localObject5).a();
                      if ((localObject2 != null) && ((localObject2 instanceof TroopChatPie)))
                      {
                        localObject3 = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", ajri.encode(localAbsShareMsg.uin));
                        if (QLog.isColorLevel()) {
                          QLog.i("StructMsg", 2, "AbsShareMsg clickWebMsg confess groupUin:" + localAbsShareMsg.uin + ",paramUrl=" + (String)localObject3);
                        }
                        localObject5 = ((ChatFragment)localObject5).getActivity().getIntent();
                        ((Intent)localObject5).putExtra("url", (String)localObject3);
                        ((Intent)localObject5).putExtra("confess_half_screen_web", true);
                        aehj.d((TroopChatPie)localObject2);
                      }
                    }
                  }
                  if (!bool) {
                    QQToast.a(BaseApplicationImpl.getContext(), aehj.bxu, 0).show();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + this.e.mSourceActionData);
                  }
                }
                for (;;)
                {
                  if (this.e.mSourceName.equals(this.e.readInjoy)) {
                    localObject2 = null;
                  }
                  try
                  {
                    localObject3 = Uri.parse(this.e.mMsgUrl).getQueryParameter("article_id");
                    localObject2 = localObject3;
                  }
                  catch (Exception localException2)
                  {
                    for (;;)
                    {
                      localException2.printStackTrace();
                      continue;
                      kbp.a(null, "", "0X8007756", "0X8007756", 0, 0, "", this.e.mMsgUrl, "", "", false);
                    }
                  }
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label2086;
                  }
                  kbp.a(null, "", "0X8007756", "0X8007756", 0, 0, (String)localObject2, this.e.mMsgUrl, "", "", false);
                  localObject2 = "plugin";
                  break;
                  ((AbsShareMsg.b)localObject5).clickPluginMsg(this.e.mSourceActionData, this.e.mSource_A_ActionData);
                }
              }
              ((AbsShareMsg.b)localObject5).i((String)localObject2, this.e.mSourceUrl, this.e.mSourceActionData, this.e.mSource_A_ActionData);
              break label557;
              if (localException2.uinType == 0)
              {
                localObject2 = "2";
                break label1036;
              }
              if (localException2.uinType == 1)
              {
                localObject2 = "3";
                break label1036;
              }
              if (localException2.uinType != 3000) {
                break label1036;
              }
              localObject2 = "4";
              break label1036;
            }
          }
        }
      }
      label1036:
      label1440:
      label1481:
      label1634:
      label2149:
      if ((localAbsShareMsg.mMsgServiceID != 81) || (localAbsShareMsg == null) || (TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData))) {
        break;
      }
      label2086:
      Object localObject4 = aqik.c(localQQAppInterface, localContext, localAbsShareMsg.mMsg_A_ActionData);
      label2200:
      if (localObject4 == null) {
        break;
      }
      localObject2 = ((aqhv)localObject4).getAttribute("usertype");
      localObject4 = ((aqhv)localObject4).getAttribute("unionid");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
        break;
      }
      int i = 0;
      try
      {
        int j = Integer.parseInt((String)localObject2);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label2298:
        break label2298;
      }
      rar.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject4 });
      break;
      label2326:
      String str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqt
 * JD-Core Version:    0.7.0.1
 */