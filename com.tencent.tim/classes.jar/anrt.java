import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import java.io.File;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class anrt
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject3 = paramView.findViewById(2131378856);
    if (localObject3 == null) {}
    StructMsgForImageShare localStructMsgForImageShare;
    Context localContext;
    int i;
    Intent localIntent;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = ((View)localObject3).getTag(2131378856);
      if ((localObject1 instanceof StructMsgForImageShare))
      {
        localStructMsgForImageShare = (StructMsgForImageShare)localObject1;
        localContext = ((View)localObject3).getContext();
        try
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localStructMsgForImageShare.currentAccountUin);
          AbsShareMsg.doReport((QQAppInterface)localObject1, localStructMsgForImageShare);
          if (localStructMsgForImageShare.msgId > 0L)
          {
            anot.a((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForImageShare.msgId), "");
            ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForImageShare.1.1(this, localStructMsgForImageShare, (QQAppInterface)localObject1), 0L);
          }
          if ((localStructMsgForImageShare.getFirstImageElement() != null) && (localStructMsgForImageShare.getFirstImageElement().useCustomSize()))
          {
            anot.a(null, "dc00898", "", "", "0X800A28", "0X800A28", 0, 0, "", "4", Long.toString(localStructMsgForImageShare.mSourceAppid), ForwardUtils.cy(localStructMsgForImageShare.uinType));
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, "大图点击=0X800A28, appid=" + localStructMsgForImageShare.mSourceAppid + ", fileType=4");
            }
          }
          anot.a(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForImageShare.mMsgServiceID + "", "", "", "");
          anot.a(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
          i = 0;
          localObject4 = localStructMsgForImageShare.getFirstImageElement();
          if (localObject4 == null) {
            break label1217;
          }
          if ((!aqiu.mt(localStructMsgForImageShare.mIsSend)) && (((ansu)localObject4).j != null))
          {
            localObject1 = xkl.b(localContext, ((ansu)localObject4).j);
            if (localObject1 != null) {
              if (((URLDrawable)localObject1).getStatus() == 2) {
                ((URLDrawable)localObject1).restartDownload();
              }
            }
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, localAccountNotMatchException.getStackTrace().toString());
            }
          }
          if ((localAccountNotMatchException.getStatus() == 0) && (!localAccountNotMatchException.isDownloadStarted()))
          {
            localAccountNotMatchException.startDownload();
          }
          else
          {
            localIntent = new Intent(localContext, AIOGalleryActivity.class);
            localIntent.putExtra("curType", localStructMsgForImageShare.uinType);
            localIntent.putExtra("_id", localStructMsgForImageShare.uniseq);
            localIntent.putExtra("appid", localStructMsgForImageShare.mSourceAppid);
            localIntent.putExtra("image_share_by_server", ((ansu)localObject4).useCustomSize());
            localIntent.putExtra("urlAtServer", ((ansu)localObject4).mUuid);
            localIntent.putExtra("KEY_FILE_ID", ((ansu)localObject4).anV);
            localIntent.putExtra("picMD5", ((ansu)localObject4).mMd5);
            localIntent.putExtra("url", ((ansu)localObject4).cij);
            localIntent.putExtra("friendUin", localStructMsgForImageShare.uin);
            localIntent.putExtra("KEY_MSG_VERSION_CODE", localStructMsgForImageShare.messageVersion);
            localIntent.putExtra("isSend", localStructMsgForImageShare.mIsSend);
            localIntent.putExtra("KEY_BUSI_TYPE", 1030);
            localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", aqiu.mu(localStructMsgForImageShare.mIsSend));
            localIntent.putExtra("uin", localStructMsgForImageShare.uin);
            if (localStructMsgForImageShare.mIsSend != 1) {
              break label1402;
            }
          }
        }
      }
    }
    Object localObject2 = localStructMsgForImageShare.currentAccountUin;
    label640:
    localIntent.putExtra("KEY_TROOP_CODE", (String)localObject2);
    localIntent.putExtra("fileSize", ((ansu)localObject4).filesize);
    localIntent.putExtra("KEY_TIME", ((ansu)localObject4).time);
    localIntent.putExtra("KEY_SUB_VERSION", 5);
    localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
    localIntent.putExtra("uniSeq", localStructMsgForImageShare.uniseq);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", sxx.getViewRect((View)localObject3));
    Object localObject4 = ((ansu)localObject4).j;
    if (localObject4 != null)
    {
      localIntent.addFlags(603979776);
      localObject2 = ((MessageForPic)localObject4).selfuin;
      if (!((MessageForPic)localObject4).isMultiMsg) {
        break label1681;
      }
    }
    label1681:
    for (;;)
    {
      try
      {
        localObject5 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject3 = localObject2;
        if ((localObject5 instanceof QQAppInterface)) {
          localObject3 = ((AppRuntime)localObject5).getAccount();
        }
        localObject2 = localObject3;
      }
      catch (Exception localException)
      {
        Object localObject5;
        AIOImageData localAIOImageData;
        label1217:
        int j;
        label1402:
        continue;
        if ((!localObject4[7].equals("scrawl_link")) || (localObject4.length < 9)) {
          continue;
        }
        String str = localObject4[8];
        continue;
        if ((localStructMsgForImageShare.mMsgActionData == null) || (!localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare"))) {
          continue;
        }
        localAIOImageData.EP = 2;
        localAIOImageData.bQ = localStructMsgForImageShare.getBytes();
        if ((!aqiu.mt(((MessageForPic)localObject4).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject4).path)) || (!new File(((MessageForPic)localObject4).path).exists())) {
          continue;
        }
        localAIOImageData.aVX = ((MessageForPic)localObject4).path;
        continue;
        if (localStructMsgForImageShare.mImageBizType != 2) {
          continue;
        }
        if ((!aqiu.mt(((MessageForPic)localObject4).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject4).path)) || (!TextUtils.isEmpty(((MessageForPic)localObject4).md5)) || (!new File(((MessageForPic)localObject4).path).exists())) {
          continue;
        }
        localAIOImageData.aVX = ((MessageForPic)localObject4).path;
        localAIOImageData.EP = 4;
        continue;
        if (!ahtr.c(localStructMsgForImageShare)) {
          continue;
        }
        localAIOImageData.EP = 5;
        ahtr.b(localAIOImageData, localStructMsgForImageShare);
        continue;
        ((Bundle)localObject2).putBoolean("extra.FROM_AIO", true);
        ((Bundle)localObject2).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)localContext).getClass().getName());
        continue;
        str = "";
        continue;
      }
      localObject5 = new AIOImageProviderService((String)localObject2, ((MessageForPic)localObject4).frienduin, ((MessageForPic)localObject4).istroop, (ChatMessage)localObject4);
      localAIOImageData = xtm.a((MessageForPic)localObject4);
      if (localStructMsgForImageShare.message != null)
      {
        localAIOImageData.time = localStructMsgForImageShare.message.time;
        localAIOImageData.shmsgseq = localStructMsgForImageShare.message.shmsgseq;
      }
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        localAIOImageData.EP = 1;
        localAIOImageData.bQ = localStructMsgForImageShare.getBytes();
        localObject4 = xtj.a(localStructMsgForImageShare);
        localAIOImageData.bWU = xtj.a((String[])localObject4);
        if ((localObject4 != null) && (localObject4.length >= 8))
        {
          if (localObject4[7].equals("link"))
          {
            localObject3 = localObject4[4];
            avdb.a(null, (String)localObject2, localContext, "3009", "2", "40054", localObject4[0], new String[] { localObject4[2], localObject4[4], localObject3 });
          }
        }
        else
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject5).asBinder()));
          ((Bundle)localObject2).putParcelable("extra.EXTRA_CURRENT_IMAGE", localAIOImageData);
          ((Bundle)localObject2).putInt("forward_source_uin_type", localStructMsgForImageShare.uinType);
          if (((localContext instanceof SplashActivity)) || ((localContext instanceof ChatActivity)) || ((localContext instanceof ChatHistoryActivity)) || ((localContext instanceof PublicFragmentActivity)) || ((localContext instanceof ChatHistory)))
          {
            if (!(localContext instanceof MultiForwardActivity)) {
              continue;
            }
            localObject3 = ((BaseActivity)localContext).getAppInterface();
            if ((localObject3 instanceof QQAppInterface))
            {
              ((Bundle)localObject2).putBoolean("extra.FROM_AIO", true);
              ((Bundle)localObject2).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
              ((Bundle)localObject2).putString("uin", ((MultiForwardActivity)localContext).getChatFragment().a().a().aTl);
              localObject4 = ((Bundle)localObject2).getString("extra.GROUP_UIN");
              if ((localObject4 != null) && (((QQAppInterface)localObject3).cs((String)localObject4) == 2)) {
                ((Bundle)localObject2).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
              }
            }
          }
          localIntent.putExtras((Bundle)localObject2);
          localContext.startActivity(localIntent);
          i = 1;
          j = 0;
          if (i != 0) {
            j = 1;
          }
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, j, "" + localStructMsgForImageShare.msgId, "" + localStructMsgForImageShare.templateIDForPortal, "", localStructMsgForImageShare.mMsgUrl);
          localObject2 = new StringBuilder().append("MSGID=").append(Long.toString(localStructMsgForImageShare.msgId)).append(";TEPLATEID=").append(localStructMsgForImageShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(localStructMsgForImageShare.mMsgUrl));
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, j, ((StringBuilder)localObject2).toString(), "", "", "");
          break;
          localObject2 = localStructMsgForImageShare.uin;
          break label640;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrt
 * JD-Core Version:    0.7.0.1
 */