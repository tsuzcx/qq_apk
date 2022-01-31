import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;

public final class gph
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    Object localObject1;
    Object localObject3;
    do
    {
      Object localObject2;
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
                localObject1 = paramView.findViewById(2131230767);
              } while (localObject1 == null);
              localObject1 = ((View)localObject1).getTag(2131230767);
            } while ((localObject1 == null) || (!StructMsgForGeneralShare.class.isInstance(localObject1)));
            localObject1 = (StructMsgForGeneralShare)localObject1;
            if ((((StructMsgForGeneralShare)localObject1).mMsgUrl.contains("com.tencent.mobileqq")) && (!((StructMsgForGeneralShare)localObject1).mMsgUrl.contains("com.tencent.mobileqqi"))) {
              ((StructMsgForGeneralShare)localObject1).mMsgUrl = ((StructMsgForGeneralShare)localObject1).mMsgUrl.replace("com.tencent.mobileqq", "com.tencent.mobileqqi");
            }
            if ((((StructMsgForGeneralShare)localObject1).mMsgActionData.contains("com.tencent.mobileqq")) && (!((StructMsgForGeneralShare)localObject1).mMsgActionData.contains("com.tencent.mobileqqi"))) {
              ((StructMsgForGeneralShare)localObject1).mMsgActionData = ((StructMsgForGeneralShare)localObject1).mMsgActionData.replace("com.tencent.mobileqq", "com.tencent.mobileqqi");
            }
            if ((((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData.contains("com.tencent.mobileqq")) && (!((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData.contains("com.tencent.mobileqqi"))) {
              ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData = ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData.replace("com.tencent.mobileqq", "com.tencent.mobileqqi");
            }
            localObject2 = paramView.getTag();
          } while ((localObject2 == null) || (!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)));
          localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          localObject3 = paramView.getContext();
        } while (!ChatActivity.class.isInstance(localObject3));
        localObject3 = ((ChatActivity)localObject3).a();
      } while (localObject3 == null);
      AbsShareMsg.doReport((QQAppInterface)localObject3, (AbsShareMsg)localObject1);
      Util.a((QQAppInterface)localObject3, "", "click", ((StructMsgForGeneralShare)localObject1).mSourceAppid, ((StructMsgForGeneralShare)localObject1).mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.a));
      paramView = new StructMsgForGeneralShare.GeneralClickHandler((QQAppInterface)localObject3, paramView, (StructMsgForGeneralShare)localObject1);
      if ("web".equals(((StructMsgForGeneralShare)localObject1).mMsgAction))
      {
        if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.a == 1)
        {
          localObject2 = (TroopInfoManager)((QQAppInterface)localObject3).getManager(35);
          if ((localObject2 != null) && (((TroopInfoManager)localObject2).a(((StructMsgForGeneralShare)localObject1).mMsgUrl)) && (((TroopInfoManager)localObject2).b()))
          {
            paramView.a("playVideo", ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
            return;
          }
          paramView.a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
          return;
        }
        paramView.a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
        return;
      }
      if (!"plugin".equals(((StructMsgForGeneralShare)localObject1).mMsgAction)) {
        break;
      }
    } while (localObject3 == null);
    paramView.c(((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
    return;
    paramView.a(((StructMsgForGeneralShare)localObject1).mMsgAction, ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gph
 * JD-Core Version:    0.7.0.1
 */