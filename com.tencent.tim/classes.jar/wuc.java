import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class wuc
  implements wvs
{
  private QQAppInterface app;
  private BaseChatPie c;
  private achq g = new wuj(this);
  private FragmentActivity mActivity;
  private Context mContext;
  private ChatMessage n;
  private SessionInfo sessionInfo;
  
  public wuc(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.c = paramBaseChatPie;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void CO(int paramInt)
  {
    this.c.getUIHandler().post(new AIORevokeMsgHelper.8(this, paramInt));
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!apuh.b(this.app, paramMessageForTroopFile, this.app.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = acfp.m(2131715620);
      aqha.a(this.mContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new wui(this)).show();
      return;
    }
    if (aqiw.isNetworkAvailable(this.mContext))
    {
      apcy localapcy = apsv.a(this.app, paramMessageForTroopFile);
      apsf localapsf = apsf.a(this.app, localapcy.TroopUin);
      localapsf.a(localapsf.a(localapcy.FilePath, localapcy.FileName, localapcy.ProgressTotal, localapcy.BusId), (int)paramMessageForTroopFile.shmsgseq, anbk.ab(paramMessageForTroopFile.msgUid));
      this.c.a = new arhz(this.mContext);
      this.c.a.setMessage(this.mContext.getString(2131696091));
      this.c.a.setBackAndSearchFilter(true);
      this.c.a.show();
      paramMessageForTroopFile = this.c.getUIHandler().obtainMessage(267387140, 1, 0);
      this.c.getUIHandler().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.a(this.mContext, 2131699442, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
  }
  
  private void a(List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPtt))
    {
      paramList = (MessageForPtt)paramList.get(0);
      paramChatMessage = MediaPlayerManager.a(this.app).a();
      if ((paramChatMessage == paramList) || (((paramChatMessage instanceof MessageForPtt)) && (paramChatMessage.frienduin != null) && (paramChatMessage.frienduin.equals(paramList.frienduin)) && (paramChatMessage.uniseq == paramList.uniseq))) {
        MediaPlayerManager.a(this.app).stop(true);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramChatMessage instanceof MessageForShortVideo))
            {
              this.c.refresh(131072);
              ShortVideoPTVItemBuilder.r(this.c.b);
              return;
            }
            if (!(paramChatMessage instanceof MessageForStructing)) {
              break;
            }
            paramList = ((MessageForStructing)paramList.get(0)).structingMsg;
          } while ((paramList == null) || (!(paramList instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)paramList)));
          QQPlayerService.eG(this.mContext);
          return;
          if (!(paramChatMessage instanceof MessageForApollo)) {
            break;
          }
          paramList = (MessageForApollo)paramList.get(0);
        } while (paramList == null);
        abrb.a(paramList.uniseq, this.app, "withdraw_msg");
      } while (paramList.mApolloMessage == null);
      VipUtils.a(this.app, "cmshow", "Apollo", "withdraw_success", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(paramList.mApolloMessage.id) });
      return;
      paramList = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramList + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
    } while (TextUtils.isEmpty(paramList));
    try
    {
      long l = Long.parseLong(paramList);
      this.app.b().d(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      QLog.e("AIORevokeMsgHelper", 1, paramList.toString());
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ChatMessage> paramList)
  {
    if (paramBoolean1)
    {
      this.c.getUIHandler().sendEmptyMessage(267387139);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        ajlc.a().lw(paramList);
        ujt.fD(paramList);
        ujt.fE(paramList);
        xsi.N((MessageRecord)paramList.get(0));
        ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
        this.app.a().ab(localChatMessage);
        a(paramList, localChatMessage);
      }
      if ((paramBoolean2) && (paramBoolean3)) {
        anot.a(this.app, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
      return;
    }
    this.c.getUIHandler().sendEmptyMessage(267387140);
  }
  
  private void ccf()
  {
    if (this.n != null) {}
    for (boolean bool = apuh.f(this.app, this.n.frienduin, this.app.getCurrentAccountUin());; bool = false)
    {
      ausj localausj = (ausj)auss.a(this.mContext, null);
      localausj.setMainTitle(this.mActivity.getString(2131696087));
      localausj.addButton(this.mActivity.getString(2131696085), 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new wud(this, bool, localausj));
      if (!localausj.isShowing())
      {
        localausj.show();
        x("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void v(ChatMessage paramChatMessage)
  {
    if (apuh.a(this.app, paramChatMessage, this.app.getCurrentAccountUin()))
    {
      Object localObject2 = new anov(this.app).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (apuh.f(this.app, paramChatMessage.frienduin, this.app.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((anov)localObject2).a(new String[] { str, localObject1 }).report();
        if (aqmj.rA(this.app.getCurrentAccountUin())) {
          break label234;
        }
        z(paramChatMessage);
        localObject1 = new anov(this.app).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!apuh.f(this.app, paramChatMessage.frienduin, this.app.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((anov)localObject1).a(new String[] { localObject2, paramChatMessage }).report();
        aqmj.dm(this.app.getCurrentAccountUin(), true);
        return;
        localObject1 = "2";
        break;
      }
      label234:
      z(paramChatMessage);
      return;
    }
    w(paramChatMessage);
  }
  
  private void x(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.app.addObserver(this.g);
      return;
    }
    this.app.removeObserver(this.g);
  }
  
  public void u(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (apuh.c(this.app, paramChatMessage, this.app.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
    {
      this.n = paramChatMessage;
      ccf();
      return;
    }
    v(paramChatMessage);
  }
  
  public void w(ChatMessage paramChatMessage)
  {
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!apuh.c(this.app, paramChatMessage, this.app.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.mContext.getString(2131696067);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.mContext.getString(2131696068);
      }
      aqha.a(this.mContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new wue(this, paramChatMessage)).show();
      return;
    }
    y(paramChatMessage);
  }
  
  protected void x(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = apuh.c(this.app, paramChatMessage, this.app.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (apuh.a(this.app, paramChatMessage, this.app.getCurrentAccountUin())))
    {
      this.n = paramChatMessage;
      this.c.a = new arhz(this.mContext);
      this.c.a.setMessage(this.mContext.getString(2131696091));
      this.c.a.setBackAndSearchFilter(true);
      this.c.a.show();
      QQMessageFacade localQQMessageFacade = this.app.b();
      this.app.a().PE(true);
      localQQMessageFacade.C(this.n);
      int i = 20000;
      if (paramChatMessage.msgtype == -2005) {
        i = 30000;
      }
      paramChatMessage = this.c.getUIHandler().obtainMessage(267387140, 1, 0);
      this.c.getUIHandler().sendMessageDelayed(paramChatMessage, i);
      return;
    }
    aqha.a(this.mContext, 230).setMessage(this.mContext.getString(2131696086)).setPositiveButton(17039370, new wuf(this)).show();
  }
  
  public void y(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      z(paramChatMessage);
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.setMainTitle(acfp.m(2131703084));
    localausj.setSecondaryTitle(acfp.m(2131703077));
    localausj.addButton(acfp.m(2131703074), 3);
    localausj.addCancelButton(acfp.m(2131703085));
    localausj.a(new wug(this, paramChatMessage, localausj));
    localausj.show();
  }
  
  protected void z(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      ausj localausj = (ausj)auss.a(this.mContext, null);
      localausj.setMainTitle(acfp.m(2131715631));
      localausj.setSecondaryTitle(acfp.m(2131715625));
      localausj.addButton(this.mActivity.getString(2131696085), 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new wuh(this, paramChatMessage, localausj));
      if (!localausj.isShowing()) {
        localausj.show();
      }
      anot.a(this.app, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
    x(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuc
 * JD-Core Version:    0.7.0.1
 */