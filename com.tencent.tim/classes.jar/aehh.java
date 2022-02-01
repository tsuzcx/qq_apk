import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.confess.data.TroopConfessMsgItem;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aehh
  extends BaseBubbleBuilder
{
  private int bOS;
  
  public aehh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.bOS = (BaseChatItemLayout.bOj + wja.dp2px(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aehh.a locala = (aehh.a)parame;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.mContext).inflate(2131558929, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.bOS, -2));
      aehh.a.a(locala, (TextView)paramChatMessage.findViewById(2131381146));
      aehh.a.b(locala, (TextView)paramChatMessage.findViewById(2131381137));
      aehh.a.c(locala, (TextView)paramChatMessage.findViewById(2131381161));
      aehh.a.a(locala, (ConfessNewsBgView)paramChatMessage.findViewById(2131381450));
      aehh.a.a(locala).setPressMask(true);
      aehh.a.a(locala, paramChatMessage.findViewById(2131370708));
    }
    aehh.a.a(locala).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aehh.a.a(locala).setOnLongClickListener(paramwlz);
    aehh.a.a(locala).setOnTouchListener(paramwlz);
    locala.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aehi(this, paramBaseChatItemLayout));
    if (aTl)
    {
      ((aehh.a)parame).E.append(aehh.a.b(locala).getText()).append(aehh.a.a(locala).getText());
      if (aehh.a.c(locala).getVisibility() == 0) {
        ((aehh.a)parame).E.append(aehh.a.c(locala).getText());
      }
      paramChatMessage.setContentDescription(((aehh.a)parame).E.toString());
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new aehh.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopConfess))) {
      return;
    }
    MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    super.e(paramView, this.mContext);
    return paramView.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void ej(View paramView)
  {
    super.ej(paramView);
  }
  
  static class a
    extends BaseBubbleBuilder.e
  {
    private View Bz;
    private TextView Re;
    private TextView Rf;
    private TextView Rg;
    private ConfessNewsBgView b;
    
    public void a(TroopConfessMsg paramTroopConfessMsg)
    {
      if (paramTroopConfessMsg == null) {
        if (QLog.isColorLevel()) {
          QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData null is troopConfessMsgItem.");
        }
      }
      do
      {
        return;
        if ((paramTroopConfessMsg.items != null) && (!paramTroopConfessMsg.items.isEmpty())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData items is null or empty.");
      return;
      this.Re.setText(paramTroopConfessMsg.getConfessToNick());
      this.Rf.setText(((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic);
      String str2 = ((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic;
      float f = aehc.d(str2);
      int i;
      if (f > 8.0F)
      {
        this.Rf.setTextSize(1, 24.0F);
        this.Re.setTextSize(1, 18.0F);
        this.Rf.setLineSpacing(0.0F, 1.1F);
        str1 = str2;
        if (f <= 12.0F)
        {
          str1 = str2;
          if (aehc.lC(str2)) {
            i = (int)(f * 0.7D);
          }
        }
      }
      for (String str1 = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; str1 = str2)
      {
        this.Rf.setText(str1);
        if (paramTroopConfessMsg.totalCount > 1) {
          break;
        }
        this.Rg.setVisibility(8);
        return;
        this.Rf.setTextSize(1, 24.0F);
        this.Re.setTextSize(1, 18.0F);
        this.Rf.setLineSpacing(0.0F, 1.0F);
      }
      this.Rg.setVisibility(0);
      this.Rg.setText(String.format(acfp.m(2131715633), new Object[] { Integer.valueOf(paramTroopConfessMsg.totalCount - 1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aehh
 * JD-Core Version:    0.7.0.1
 */