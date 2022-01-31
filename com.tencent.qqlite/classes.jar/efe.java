import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.qphone.base.util.QLog;

public final class efe
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StructMsg", 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label349:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.a = SystemClock.uptimeMillis();
                  localObject1 = paramView.findViewById(2131296292);
                } while (localObject1 == null);
                localObject1 = ((View)localObject1).getTag(2131296292);
              } while ((localObject1 == null) || (!StructMsgForGeneralShare.class.isInstance(localObject1)));
              localObject1 = (StructMsgForGeneralShare)localObject1;
              localObject2 = paramView.getTag();
            } while ((localObject2 == null) || (!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)));
            localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
            localObject2 = paramView.getContext();
          } while (!ChatActivity.class.isInstance(localObject2));
          localObject4 = ((ChatActivity)localObject2).a();
        } while (localObject4 == null);
        AbsShareMsg.doReport((QQAppInterface)localObject4, (AbsShareMsg)localObject1);
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "geneal struct msg onclick middle ........");
        }
        Util.a((QQAppInterface)localObject4, "", "click", ((StructMsgForGeneralShare)localObject1).mSourceAppid, ((StructMsgForGeneralShare)localObject1).mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.a));
        paramView = new StructMsgForGeneralShare.GeneralClickHandler((QQAppInterface)localObject4, paramView, (StructMsgForGeneralShare)localObject1);
        if (!"web".equals(((StructMsgForGeneralShare)localObject1).mMsgAction)) {
          break label349;
        }
        if ((TextUtils.isEmpty(((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData)) || (!((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData.startsWith("mqqapi://dating/"))) {
          break;
        }
      } while (paramView.c(((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData));
      paramView.a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
      return;
      if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.a == 1)
      {
        localObject3 = (TroopInfoManager)((QQAppInterface)localObject4).getManager(33);
        if ((localObject3 != null) && (((TroopInfoManager)localObject3).a(((StructMsgForGeneralShare)localObject1).mMsgUrl)) && (((TroopInfoManager)localObject3).b()) && (!MultiForwardActivity.class.isInstance(localObject2)))
        {
          paramView.a("playVideo", ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
          return;
        }
        paramView.a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
        return;
      }
      paramView.a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
      return;
      if (!"plugin".equals(((StructMsgForGeneralShare)localObject1).mMsgAction)) {
        break;
      }
    } while (localObject4 == null);
    paramView.c(((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
    return;
    if ("viewMultiMsg".equals(((StructMsgForGeneralShare)localObject1).mMsgAction))
    {
      localObject3 = (ChatActivity)localObject2;
      int i = ((ChatActivity)localObject3).a().a();
      paramView = ((ChatActivity)localObject3).a().a();
      localObject3 = ((ChatActivity)localObject3).a().c();
      localObject4 = new Intent((Context)localObject2, MultiForwardActivity.class);
      ((Intent)localObject4).putExtra("chat_subType", 3);
      ((Intent)localObject4).putExtra("uin", paramView);
      ((Intent)localObject4).putExtra("uintype", i);
      ((Intent)localObject4).putExtra("troop_code", (String)localObject3);
      ((Intent)localObject4).putExtra("multi_url", ((StructMsgForGeneralShare)localObject1).mResid);
      ((Intent)localObject4).putExtra("multi_uniseq", ((StructMsgForGeneralShare)localObject1).uniseq);
      ((Intent)localObject4).putExtra("multi_source", ((StructMsgForGeneralShare)localObject1).mSourceName);
      ((Context)localObject2).startActivity((Intent)localObject4);
      return;
    }
    paramView.a(((StructMsgForGeneralShare)localObject1).mMsgAction, ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     efe
 * JD-Core Version:    0.7.0.1
 */