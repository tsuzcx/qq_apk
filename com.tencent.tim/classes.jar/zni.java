import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zni
  extends wki
{
  public final String TAG = "MiniPie.MiniChatAdapter";
  
  public zni(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_Xeh = new znj(paramContext, paramQQAppInterface, paramSessionInfo, null, null);
    this.jdField_a_of_type_Wki$a = null;
  }
  
  protected boolean Rq()
  {
    return false;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = 0L;
    paramInt = 0;
    paramCharSequence = null;
    ChatMessage localChatMessage;
    boolean bool1;
    if (paramInt < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(paramInt);
      boolean bool2 = anbk.lt(localChatMessage.msgtype);
      if ((bool2) && ((paramInt == 0) || ((localChatMessage.time < this.createTime) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.createTime) && (localChatMessage.time - l1 > 300L) && ((paramCharSequence == null) || (localChatMessage.time - paramCharSequence.time > 60L))) || ((this.b.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        label165:
        localChatMessage.mNeedTimeStamp = bool1;
        if (localChatMessage.mNeedTimeStamp)
        {
          long l2 = localChatMessage.time;
          l1 = l2;
          if (localChatMessage.time < this.createTime)
          {
            wmy.I(localChatMessage);
            l1 = l2;
          }
        }
        if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.dbK == 1))) {
          break label362;
        }
        paramCharSequence = localChatMessage;
      }
    }
    label362:
    for (;;)
    {
      if (paramInt != paramList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      paramInt += 1;
      break;
      bool1 = false;
      break label165;
      if (paramList.size() > 0) {
        this.b.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
      }
      this.list = paramList;
      QLog.d("MiniPie.MiniChatAdapter", 1, "list addr = " + paramList.hashCode() + ",size = " + paramList.size());
      super.notifyDataSetChanged();
      return;
    }
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    if ((localView != null) && ((localView instanceof zng)))
    {
      zng localzng = (zng)localView;
      localzng.setIsShieldTouchForItem(true);
      localzng.setFrom(((znj)this.jdField_a_of_type_Xeh).brF);
      if ((localView instanceof BaseChatItemLayout)) {
        ((BaseChatItemLayout)localView).bYT();
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void setFrom(boolean paramBoolean)
  {
    ((znj)this.jdField_a_of_type_Xeh).BN(paramBoolean);
  }
  
  public String toString()
  {
    return "list.addr = " + this.list.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zni
 * JD-Core Version:    0.7.0.1
 */