import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare.1.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;

public final class anrf
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.findViewById(2131378856);
    if (localObject2 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = ((View)localObject2).getTag(2131378856);
      Object localObject3;
      if ((localObject1 != null) && ((localObject1 instanceof StructMsgForAudioShare)))
      {
        localObject1 = (StructMsgForAudioShare)localObject1;
        localObject3 = paramView.getTag();
        if ((localObject3 != null) && ((localObject3 instanceof StructingMsgItemBuilder.a)))
        {
          localObject3 = (StructingMsgItemBuilder.a)localObject3;
          localObject2 = ((View)localObject2).getContext();
        }
      }
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(((StructMsgForAudioShare)localObject1).currentAccountUin);
        if (((StructMsgForAudioShare)localObject1).msgId > 0L)
        {
          anot.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForAudioShare)localObject1).uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(((StructMsgForAudioShare)localObject1).msgId), "");
          ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForAudioShare.1.1(this, (StructMsgForAudioShare)localObject1, localQQAppInterface), 0L);
          AbsShareMsg.doReport(localQQAppInterface, (AbsShareMsg)localObject1);
          if (localQQAppInterface == null) {
            continue;
          }
          jqo.a(localQQAppInterface, "", "click", ((StructMsgForAudioShare)localObject1).mSourceAppid, ((StructMsgForAudioShare)localObject1).mMsgServiceID, jqo.aW(((StructingMsgItemBuilder.a)localObject3).sessionInfo.cZ));
          MediaPlayerManager.a(localQQAppInterface).stop(true);
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, localAccountNotMatchException.getStackTrace().toString());
          }
        }
      }
      anot.a(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, ((StructMsgForAudioShare)localObject1).mMsgServiceID + "", "", "", "");
      anot.a(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, "2", ForwardUtils.cy(((StructMsgForAudioShare)localObject1).uinType), ((StructMsgForAudioShare)localObject1).mContentTitle, "");
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new Object[] { "音乐分享内容点击=", "0X800A630", ", mContentTitle=" + ((StructMsgForAudioShare)localObject1).mContentTitle, ", uinType=", ForwardUtils.cy(((StructMsgForAudioShare)localObject1).uinType) });
      }
      StructMsgForAudioShare.onClickEvent((Context)localObject2, (StructMsgForAudioShare)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrf
 * JD-Core Version:    0.7.0.1
 */