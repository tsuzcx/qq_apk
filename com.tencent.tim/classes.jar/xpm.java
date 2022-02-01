import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.MessageForToDo;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.data.TodoInfo;
import mqq.app.MobileQQ;

public class xpm
  extends BaseBubbleBuilder
{
  public xpm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = (xpm.a)paramChatMessage.getTag();
    paramView.jdField_E_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.bNS;
    if (aTl) {}
    try
    {
      paramView.jdField_E_of_type_JavaLangStringBuilder.append(paramView.title.getText());
      paramView.jdField_E_of_type_JavaLangStringBuilder.append(paramView.Jd.getText());
      paramView.jdField_E_of_type_JavaLangStringBuilder.append(this.app.getApplication().getString(2131692788));
      paramChatMessage.setContentDescription(paramView.jdField_E_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView)
    {
      QLog.e("ChatItemBuilder", 1, "getView. error:" + paramView.toString() + ".");
    }
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (MessageForToDo)paramChatMessage;
    parame = (xpm.a)parame;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.mContext).inflate(2131563185, null);
      parame.title = ((TextView)paramChatMessage.findViewById(2131380976));
      parame.Jd = ((TextView)paramChatMessage.findViewById(2131380765));
      parame.Je = ((TextView)paramChatMessage.findViewById(2131380792));
      parame.hA = ((RelativeLayout)paramChatMessage.findViewById(2131365382));
      parame.name = ((TextView)paramChatMessage.findViewById(2131380814));
      parame.Jc = ((TextView)paramChatMessage.findViewById(2131380940));
      ((ImageView)paramChatMessage.findViewById(2131368698)).setImageResource(2130851738);
      paramChatMessage.setOnLongClickListener(paramwlz);
      paramChatMessage.setOnTouchListener(paramwlz);
      paramChatMessage.setOnClickListener(this);
    }
    parame.Je.setVisibility(8);
    parame.title.setText(paramBaseChatItemLayout.title);
    parame.name.setText(this.mContext.getString(2131721205));
    if (paramBaseChatItemLayout.changedBeginTime > 0L)
    {
      parame.title.setMaxLines(1);
      parame.Jd.setText(aupe.cm(paramBaseChatItemLayout.changedBeginTime));
      return paramChatMessage;
    }
    parame.title.setMaxLines(2);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xpm.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    case 2131372073: 
      super.m(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      parame.jdField_E_of_type_AndroidViewView.setBackgroundResource(2130838462);
      return;
    }
    parame.jdField_E_of_type_AndroidViewView.setBackgroundResource(2130838116);
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
      return this.app.getApplication().getString(2131721212);
    }
    return this.app.getApplication().getString(2131721211);
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      MessageForToDo localMessageForToDo;
      switch (paramView.getId())
      {
      case 2131364511: 
      default: 
        break;
      case 2131364503: 
        localMessageForToDo = (MessageForToDo)wja.a(paramView);
        if (localMessageForToDo == null) {
          continue;
        }
      }
      try
      {
        TodoInfo localTodoInfo = new TodoInfo();
        localTodoInfo.content = localMessageForToDo.title;
        localTodoInfo.remindTime = localMessageForToDo.changedBeginTime;
        localTodoInfo.istroop = localMessageForToDo.istroop;
        localTodoInfo.uniseq = localMessageForToDo.uniseq;
        localTodoInfo.fromUin = Long.valueOf(localMessageForToDo.frienduin).longValue();
        Intent localIntent = new Intent(this.mContext, TodoNewActivity.class);
        localIntent.putExtra("param_mode", 2);
        if ((localMessageForToDo.senderuin != null) && (localMessageForToDo.senderuin.equals(this.app.getCurrentAccountUin()))) {
          localIntent.putExtra("is_from_self", true);
        }
        String str = localMessageForToDo.getExtInfoFromExtStr("message_ext_has_added_todo");
        localTodoInfo.todoId = localMessageForToDo.getExtInfoFromExtStr("message_ext_has_added_todo_id");
        localIntent.putExtra("has_added_todo", "flag_has_added_todo".equals(str));
        localIntent.putExtra("todoinfo", localTodoInfo);
        this.mContext.startActivity(localIntent);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      aupe.L(this.app, "0X80091D0", 1);
    }
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jc;
    public TextView Jd;
    public TextView Je;
    public RelativeLayout hA;
    public TextView name;
    public TextView title;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpm
 * JD-Core Version:    0.7.0.1
 */