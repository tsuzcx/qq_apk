import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wyu
  extends BaseBubbleBuilder
  implements wla.a
{
  Handler uiHandler = new Handler();
  
  public wyu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(MessageForApproval paramMessageForApproval, wyu.a parama)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        parama.IR.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          parama.IP.setText(paramMessageForApproval.title.substring(3));
          parama.IQ.setVisibility(8);
          return;
        }
        localObject1 = acfp.m(2131702763);
        int j = arrayOfString.length;
        String str1 = "";
        paramMessageForApproval = "";
        localObject2 = "";
        i = 0;
        if (i < j)
        {
          String str2 = arrayOfString[i];
          if (str2.startsWith("000"))
          {
            localObject5 = (String)localObject1 + str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
          }
          else if (str2.startsWith("001"))
          {
            localObject4 = str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject5 = localObject1;
          }
          else if (str2.startsWith("002"))
          {
            localObject3 = str2.substring(3);
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
          else
          {
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
            localObject5 = localObject1;
            if (str2.startsWith("003"))
            {
              str1 = str2.substring(3);
              localObject3 = paramMessageForApproval;
              localObject4 = localObject2;
              localObject5 = localObject1;
            }
          }
        }
        else
        {
          localObject3 = paramMessageForApproval;
          if ("1".equalsIgnoreCase(str1) == true) {
            localObject3 = paramMessageForApproval + acfp.m(2131702760);
          }
          parama.IP.setText((CharSequence)localObject1);
          parama.IQ.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          parama.IP.setText(acfp.m(2131702764));
          parama.IQ.setText(acfp.m(2131702761));
        }
        QLog.e("ApprovalMsgBuilder", 1, paramMessageForApproval.toString());
        return;
      }
      i += 1;
      paramMessageForApproval = (MessageForApproval)localObject3;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
    }
  }
  
  private void a(wyu.a parama, MessageForApproval paramMessageForApproval, View paramView, wlz paramwlz)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)parama.hd.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)parama.IO.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.mDensity * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.mDensity));; localLayoutParams1.leftMargin = ((int)(24.0F * this.mDensity)))
    {
      parama.hd.setLayoutParams(localLayoutParams);
      parama.IO.setLayoutParams(localLayoutParams1);
      parama.hd.invalidate();
      parama.IO.invalidate();
      paramView.setOnLongClickListener(paramwlz);
      paramView.setOnTouchListener(paramwlz);
      paramView.setOnClickListener(this);
      return;
      localLayoutParams.leftMargin = ((int)(this.mDensity * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void onItemClick(View paramView)
  {
    paramView = (MessageForApproval)wja.a(paramView);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = (wyu.a)paramChatMessage.getTag();
    paramView.jdField_E_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.bNS;
    if (aTl) {}
    try
    {
      paramView.jdField_E_of_type_JavaLangStringBuilder.append(paramView.IP.getText());
      paramView.jdField_E_of_type_JavaLangStringBuilder.append(paramView.IQ.getText());
      paramView.jdField_E_of_type_JavaLangStringBuilder.append("审批");
      paramChatMessage.setContentDescription(paramView.jdField_E_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView) {}
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    parame = (wyu.a)parame;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.mContext).inflate(2131558895, null);
      parame.IP = ((TextView)paramChatMessage.findViewById(2131371108));
      parame.IQ = ((TextView)paramChatMessage.findViewById(2131379000));
      parame.IR = ((TextView)paramChatMessage.findViewById(2131379009));
      parame.hd = ((LinearLayout)paramChatMessage.findViewById(2131372049));
      parame.IO = ((TextView)paramChatMessage.findViewById(2131369553));
    }
    a(parame, paramBaseChatItemLayout, paramChatMessage, paramwlz);
    a(paramBaseChatItemLayout, parame);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wyu.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = (wyu.a)wja.a(paramView);
    a((MessageForApproval)paramView.mMessage, paramView);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    super.c(paramView, this.mContext);
    super.e(paramView, this.mContext);
    return paramView.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131702762);
    }
    return acfp.m(2131702765);
  }
  
  public void ei(View paramView) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      case 2131364511: 
      default: 
        break;
      case 2131364503: 
        onItemClick(paramView);
      }
    }
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public TextView IO;
    public TextView IP;
    public TextView IQ;
    public TextView IR;
    public LinearLayout hd;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */