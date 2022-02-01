import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class alvl
  implements View.OnClickListener
{
  private BaseBubbleBuilder a;
  private QQAppInterface app;
  private final int dyh = 1000;
  private long lastClickTime;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public alvl(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.app = paramBaseBubbleBuilder.app;
    this.mContext = paramBaseBubbleBuilder.mContext;
    this.sessionInfo = paramBaseBubbleBuilder.sessionInfo;
    this.a = paramBaseBubbleBuilder;
  }
  
  private void Tr(int paramInt)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A36C", "0X800A36C", paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MessageForReplyText paramMessageForReplyText)
  {
    Object localObject1 = xmb.a(this.app, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      localObject3 = this.app.b().b(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject3).next();
      } while (((MessageRecord)localObject2).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if (QLog.isColorLevel())
    {
      if (localObject2 == null)
      {
        localObject1 = "null";
        QLog.d("ReplyItemClickListener", 2, new Object[] { "clicked sourceMsg Class=", localObject1 });
      }
    }
    else if (paramMessageForReplyText.isBarrageMsg)
    {
      if (!(localObject2 instanceof MessageForPic)) {
        break label351;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
    }
    boolean bool1;
    label351:
    int i;
    for (;;)
    {
      boolean bool2 = true;
      localObject3 = null;
      localObject1 = localObject3;
      bool1 = bool2;
      if (this.app.b() != null)
      {
        localObject1 = localObject3;
        bool1 = bool2;
        if (localObject2 != null)
        {
          localObject3 = this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, ((MessageRecord)localObject2).shmsgseq);
          localObject1 = localObject3;
          bool1 = bool2;
          if (localObject3 == null)
          {
            bool1 = false;
            localObject1 = localObject3;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "check source msg, isReplySrcMsgExist = " + bool1);
      }
      if (!(localObject2 instanceof MessageForShortVideo)) {
        break label784;
      }
      if ((paramView.getId() == 2131364531) || (paramView.getId() == 2131379641)) {
        break label635;
      }
      return false;
      localObject1 = localObject2.getClass().getName();
      break;
      if ((localObject2 instanceof MessageForShortVideo))
      {
        anot.a(this.app, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
      }
      else if (ahav.ax((MessageRecord)localObject2))
      {
        localObject1 = xmb.a(this.app, (MessageRecord)localObject2);
        if ((localObject1 instanceof MessageForFile))
        {
          localObject1 = this.app.a().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if (localObject1 != null)
          {
            i = ahav.getFileType(((FileManagerEntity)localObject1).fileName);
            if (i == 0) {
              anot.a(this.app, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              anot.a(this.app, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
        else if ((localObject1 instanceof MessageForTroopFile))
        {
          localObject1 = (MessageForTroopFile)localObject1;
          localObject1 = apsv.a(this.app, (MessageForTroopFile)localObject1);
          if (localObject1 != null)
          {
            i = ahav.getFileType(((apcy)localObject1).FileName);
            if (i == 0) {
              anot.a(this.app, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              anot.a(this.app, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    label635:
    if (paramView.getId() == 2131364531)
    {
      localObject1 = (ImageView)paramView.findViewById(2131379641);
      if (((MessageForShortVideo)localObject2).busiType != 0)
      {
        localObject3 = this.app;
        Context localContext = this.mContext;
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localObject2;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (ImageView)paramView;
        }
        ShortVideoRealItemBuilder.a((QQAppInterface)localObject3, localContext, localMessageForShortVideo, (View)localObject2, this.sessionInfo, false, true, xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), bool1, paramMessageForReplyText);
      }
      for (;;)
      {
        Tr(5);
        return true;
        ShortVideoItemBuilder.a((MessageForShortVideo)localObject2, 0L, this.mContext, this.app, this.sessionInfo, xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), bool1, paramMessageForReplyText);
      }
      if ((localObject2 instanceof MessageForText))
      {
        if ((paramView.getId() != 2131364531) && (paramView.getId() != 2131371989)) {
          return false;
        }
        if (paramView.getId() != 2131364531) {
          break label2609;
        }
        paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371989);
        localObject1 = (FragmentActivity)this.mContext;
        if (localObject1 != null)
        {
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.app;
            if (paramMessageForReplyText == null) {}
            for (;;)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext);
              Tr(1);
              return true;
              paramView = paramMessageForReplyText;
            }
          }
          localObject1 = this.app;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext, this.sessionInfo.cZ);
            break;
            paramView = paramMessageForReplyText;
          }
        }
      }
      else if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForPic)))
      {
        if ((paramView.getId() != 2131364531) && (paramView.getId() != 2131371989) && (paramView.getId() != 2131379641)) {
          return false;
        }
        if (((localObject2 instanceof MessageForMixedMsg)) && ((paramView.getId() == 2131364531) || (paramView.getId() == 2131371989)))
        {
          if (paramView.getId() != 2131364531) {
            break label2598;
          }
          paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371989);
          localObject1 = (FragmentActivity)this.mContext;
          if (localObject1 == null) {
            break label2592;
          }
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.app;
            if (paramMessageForReplyText == null)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext);
              Tr(3);
            }
          }
        }
        for (;;)
        {
          return true;
          paramView = paramMessageForReplyText;
          break;
          localObject1 = this.app;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext, this.sessionInfo.cZ);
            break;
            paramView = paramMessageForReplyText;
          }
          if (((localObject2 instanceof MessageForPic)) && (!(paramView instanceof URLImageView)))
          {
            localObject1 = (MessageForPic)localObject2;
            if (xkl.a((MessageForPic)localObject1)) {
              AIOEmotionFragment.a(this.mContext, (MessageRecord)localObject1, this.sessionInfo, sxx.getViewRect(paramView), xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), false);
            }
            for (;;)
            {
              return true;
              xkl.a(this.app, this.mContext, null, (MessageForPic)localObject2, this.sessionInfo, true, xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), bool1, paramMessageForReplyText);
            }
          }
          paramView = (URLImageView)paramView;
          localObject1 = (MessageForPic)paramView.getTag(2131364517);
          localObject3 = (URLDrawable)paramView.getDrawable();
          if (localObject3 == null) {
            return false;
          }
          switch (((URLDrawable)localObject3).getStatus())
          {
          }
          for (;;)
          {
            if (!(localObject2 instanceof MessageForMixedMsg)) {
              break label1430;
            }
            Tr(4);
            break;
            if (aqhq.bP(this.mContext))
            {
              ((URLDrawable)localObject3).restartDownload();
              continue;
              if (!((URLDrawable)localObject3).isDownloadStarted())
              {
                ((URLDrawable)localObject3).startDownload();
                continue;
                if (xkl.a((MessageForPic)localObject1)) {
                  AIOEmotionFragment.a(this.mContext, (MessageRecord)localObject1, this.sessionInfo, sxx.getViewRect(paramView), xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), false);
                } else {
                  xkl.a(this.app, this.mContext, paramView, (ChatMessage)localObject1, this.sessionInfo, true, xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), bool1, paramMessageForReplyText);
                }
              }
            }
          }
          Tr(2);
        }
      }
      else if (ahav.ax((MessageRecord)localObject2))
      {
        paramView = xmb.a(this.app, (MessageRecord)localObject2);
        if ((bool1) && (localObject1 != null)) {
          paramView.uniseq = ((MessageRecord)localObject1).uniseq;
        }
        paramView.isMultiMsg = paramMessageForReplyText.isMultiMsg;
        if ((paramView instanceof MessageForFile))
        {
          localObject1 = this.app.a().a(paramView.uniseq, paramView.frienduin, paramView.istroop);
          if (localObject1 != null)
          {
            if (((FileManagerEntity)localObject1).status == 16) {
              return false;
            }
            i = ahav.getFileType(((FileManagerEntity)localObject1).fileName);
            if (((FileManagerEntity)localObject1).cloudType == 0) {
              i = 11;
            }
            if (i == 0)
            {
              ahbr.a(this.mContext, null, (MessageForFile)paramView, this.sessionInfo, false, true, true, paramMessageForReplyText);
              Tr(6);
              return true;
            }
            if (i == 2)
            {
              if (((FileManagerEntity)localObject1).status == 16) {
                return true;
              }
              if (!ahbr.v((FileManagerEntity)localObject1)) {
                return true;
              }
              i = 0;
              if (((FileManagerEntity)localObject1).peerType == 0) {
                i = 1;
              }
              for (;;)
              {
                ahbr.a(this.app, this.mContext, this.sessionInfo, (MessageForFile)paramView, null, i, 10004, (FileManagerEntity)localObject1, false, true);
                break;
                if (((FileManagerEntity)localObject1).peerType == 3000) {
                  i = 5;
                }
              }
            }
            i = 0;
            if (((FileManagerEntity)localObject1).peerType == 0) {
              i = 1;
            }
            for (;;)
            {
              paramView = new agvl(this.app, this.mContext, (FileManagerEntity)localObject1, 10004);
              paramMessageForReplyText = new Bundle();
              paramMessageForReplyText.putString("file_browser_extra_params_uin", this.sessionInfo.aTl);
              paramView.cB(paramMessageForReplyText);
              paramView = new agvn(this.mContext, paramView);
              paramView.Oy(i);
              paramView.djN();
              break;
              if (((FileManagerEntity)localObject1).peerType == 3000) {
                i = 5;
              }
            }
          }
        }
        else if ((paramView instanceof MessageForTroopFile))
        {
          long l = Long.parseLong(paramView.frienduin);
          paramView = (MessageForTroopFile)paramView;
          localObject1 = apsv.a(this.app, paramView);
          if (localObject1 != null)
          {
            if (((apcy)localObject1).Status == 12)
            {
              QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
              return false;
            }
            i = ahav.getFileType(((apcy)localObject1).FileName);
            if (i == 2)
            {
              if ((paramView.lastTime != 0L) && (paramView.lastTime <= NetConnInfoCenter.getServerTime()))
              {
                QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
                return false;
              }
              ahbr.a(this.app, this.mContext, this.sessionInfo, paramView, l, (apcy)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true, true);
            }
            for (;;)
            {
              Tr(6);
              return true;
              if (i == 0) {
                switch (((apcy)localObject1).Status)
                {
                case 4: 
                case 5: 
                default: 
                  xkl.a(this.app, this.mContext, null, paramView, this.sessionInfo, true, xmb.a(paramMessageForReplyText.mSourceMsgInfo, this.sessionInfo, this.app), bool1, paramMessageForReplyText);
                  break;
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                  paramMessageForReplyText = new Intent();
                  paramMessageForReplyText.putExtra(TroopFileProxyActivity.cjr, paramView.frienduin);
                  TroopFileProxyActivity.b((Activity)this.mContext, paramMessageForReplyText, this.app.getCurrentAccountUin());
                  break;
                }
              } else {
                ahbr.a(this.app, this.mContext, this.sessionInfo, paramMessageForReplyText, l, (apcy)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true);
              }
            }
          }
        }
      }
      else if ((localObject2 instanceof MessageForStructing))
      {
        if (!abdy.U((MessageRecord)localObject2)) {
          return false;
        }
        if (xmb.L((MessageRecord)localObject2)) {
          return false;
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          paramMessageForReplyText = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          if ((paramMessageForReplyText instanceof StructMsgForGeneralShare))
          {
            paramView.setTag(localObject2);
            localObject1 = (StructMsgForGeneralShare)paramMessageForReplyText;
            localObject2 = new StructMsgForGeneralShare.a(this.app, paramView, (StructMsgForGeneralShare)localObject1);
            StructMsgForGeneralShare.onClickEvent(this.app, this.mContext, (StructMsgForGeneralShare)localObject1, paramView, (StructMsgForGeneralShare.a)localObject2);
            paramMessageForReplyText.getOnClickListener().onClick(paramView);
            switch (paramMessageForReplyText.mMsgServiceID)
            {
            default: 
              Tr(9);
            }
          }
          for (;;)
          {
            return true;
            if (!(paramMessageForReplyText instanceof StructMsgForAudioShare)) {
              break;
            }
            localObject1 = (StructMsgForAudioShare)paramMessageForReplyText;
            StructMsgForAudioShare.onClickEvent(this.mContext, (StructMsgForAudioShare)localObject1);
            break;
            Tr(7);
            continue;
            Tr(8);
          }
        }
      }
      else if (!(localObject2 instanceof MessageForArkApp)) {}
    }
    for (;;)
    {
      try
      {
        label784:
        label833:
        label854:
        paramMessageForReplyText = ((MessageForArkApp)localObject2).ark_app_message;
        label1025:
        label1046:
        if ((paramMessageForReplyText != null) && (aejg.a().aS(paramMessageForReplyText.appName, paramMessageForReplyText.appView)))
        {
          Tr(aejg.F(paramMessageForReplyText.appName, paramMessageForReplyText.appView));
          localObject2 = aejg.a().a(new JSONObject(paramMessageForReplyText.toAppXml()));
          localObject1 = (String)((Map)localObject2).get("kArkMsgReplyAction");
          localObject2 = (String)((Map)localObject2).get("kArkMsgReplyJumpUrl");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2573;
          }
          if ("showLargeText".equals(localObject1))
          {
            if ((paramView.getId() != 2131364531) && (paramView.getId() != 2131371989)) {
              return false;
            }
            paramMessageForReplyText = null;
            if (paramView.getId() == 2131364531) {
              paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371989);
            }
            localObject1 = (FragmentActivity)this.mContext;
            if (localObject1 == null) {
              break label2586;
            }
            localObject1 = ((FragmentActivity)localObject1).getChatFragment();
            if (localObject1 == null)
            {
              localObject1 = this.app;
              if (paramMessageForReplyText != null) {
                break label2622;
              }
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext);
            }
            else
            {
              localObject1 = this.app;
              if (paramMessageForReplyText == null) {
                ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.mContext, this.sessionInfo.cZ);
              }
            }
          }
        }
      }
      catch (Exception paramView)
      {
        label1430:
        QLog.e("ReplyItemClickListener", 1, "handle sourceMsg of MessageForArkApp error: " + paramView.getMessage());
      }
      return false;
      paramView = paramMessageForReplyText;
      continue;
      label2573:
      adnq.h((String)localObject2, 0, paramMessageForReplyText.appName);
      return true;
      label2586:
      localObject1 = null;
      continue;
      label2592:
      localObject1 = null;
      break label1046;
      label2598:
      paramMessageForReplyText = null;
      break label1025;
      localObject1 = null;
      break label854;
      label2609:
      paramMessageForReplyText = null;
      break label833;
      localObject1 = null;
      break;
      return true;
      label2622:
      paramView = paramMessageForReplyText;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a.Rk()) {}
    do
    {
      long l;
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        l = System.currentTimeMillis();
      } while (l - this.lastClickTime < 1000L);
      this.lastClickTime = l;
      localObject1 = wja.a(paramView);
      if (!(localObject1 instanceof MessageForMixedMsg)) {
        break;
      }
      localObject1 = (MessageForMixedMsg)localObject1;
    } while (((MessageForMixedMsg)localObject1).getReplyMessage(this.app) == null);
    Object localObject1 = ((MessageForMixedMsg)localObject1).getReplyMessage(this.app);
    for (;;)
    {
      Object localObject2;
      if (!(localObject1 instanceof MessageForReplyText))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText, it's");
          if (localObject1 == null) {
            break label156;
          }
        }
        label156:
        for (localObject1 = localObject1.getClass().getSimpleName();; localObject1 = "null")
        {
          QLog.w("ReplyItemClickListener", 2, (String)localObject1);
          break;
        }
      }
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)localObject1;
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = localMessageForReplyText.mSourceMsgInfo;
      if (localMessageForReplyText.msgtype == -1003)
      {
        wja.bcO = true;
        localObject1 = aqoj.pL(localMessageForReplyText.action);
        localObject1 = aqik.c(this.app, paramView.getContext(), (String)localObject1);
        if (localObject1 != null) {
          ((aqhv)localObject1).ace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "ReplyTextItemBuilder OnClickListener original sourceMsgInfo msgUid= " + localSourceMsgInfo.origUid + ", time = " + localSourceMsgInfo.mSourceMsgTime);
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364531: 
      case 2131371989: 
      case 2131379641: 
        if (a(paramView, localMessageForReplyText))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick success");
        }
        break;
      case 2131369803: 
        if (!(this.mContext instanceof FragmentActivity)) {
          break;
        }
        ChatFragment localChatFragment = ((FragmentActivity)this.mContext).getChatFragment();
        if (localChatFragment != null)
        {
          localObject2 = xmb.a(this.app, localMessageForReplyText.frienduin, localMessageForReplyText.istroop, localMessageForReplyText, localMessageForReplyText.mSourceMsgInfo);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
            }
            Iterator localIterator = this.app.b().b(localMessageForReplyText.frienduin, localMessageForReplyText.istroop, null).iterator();
            do
            {
              localObject1 = localObject2;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (MessageRecord)localIterator.next();
            } while (((MessageRecord)localObject1).shmsgseq != localMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
          }
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && ((((MessageForUniteGrayTip)localObject1).tipParam.dbK == 1) || (((MessageForUniteGrayTip)localObject1).tipParam.dbK == 131073)))
          {
            label570:
            int i;
            if (((MessageForUniteGrayTip)localObject1).tipParam.dbK == 1)
            {
              j = 1;
              localObject1 = this.mContext;
              if (j == 0) {
                break label631;
              }
              i = 0;
              label582:
              if (j == 0) {
                break label636;
              }
            }
            label631:
            label636:
            for (int j = 2131699910;; j = 2131700005)
            {
              QQToast.a((Context)localObject1, i, j, 0).show(((FragmentActivity)this.mContext).getTitleBarHeight());
              xmb.a(this.app, null, "0X800A36B");
              break;
              j = 0;
              break label570;
              i = 1;
              break label582;
            }
          }
          localObject2 = localChatFragment.a();
          if ((this.sessionInfo.cZ == 0) && ((localObject2 instanceof xys))) {
            ((xys)localObject2).a(22, localSourceMsgInfo.origUid, localSourceMsgInfo.mSourceMsgTime, null, 1, 1);
          }
          for (;;)
          {
            xmb.a(this.app, (MessageRecord)localObject1, "0X800A36A");
            break;
            if (((BaseChatPie)localObject2).OP())
            {
              ((BaseChatPie)localObject2).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo.mSourceMsgSeq), localMessageForReplyText, 1, 1);
              MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", localMessageForReplyText.frienduin, localMessageForReplyText);
              if (QLog.isColorLevel()) {
                QLog.w("ReplyItemClickListener", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
              }
            }
            else if ((localObject2 instanceof ybl))
            {
              ((BaseChatPie)localObject2).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo.mSourceMsgSeq), localMessageForReplyText, 1, 1);
              if (QLog.isColorLevel()) {
                QLog.d("ReplyItemClickListener", 2, "MultiForwardChatPie onClickListener: isReplyMsg = true");
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "getChatFragment() is null");
        }
        QQToast.a(this.mContext, 2131699909, 0).show(((FragmentActivity)this.mContext).getTitleBarHeight());
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick fail");
        }
        localObject1 = (FragmentActivity)this.mContext;
        if (localObject1 != null) {}
        for (localObject1 = ((FragmentActivity)localObject1).getChatFragment();; localObject1 = null)
        {
          if (localObject1 == null) {
            ChatActivityUtils.a(this.app, paramView, (FragmentActivity)this.mContext);
          }
          for (;;)
          {
            Tr(9);
            break;
            ChatActivityUtils.a(this.app, paramView, (FragmentActivity)this.mContext, this.sessionInfo.cZ);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvl
 * JD-Core Version:    0.7.0.1
 */