import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.MobileQQ;

public class xbl
  extends BaseBubbleBuilder
{
  public xbl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String cE(int paramInt)
  {
    String str1 = "";
    String str2 = str1;
    if (paramInt > 1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      str2 = str1 + "重复";
      return str2;
      str1 = "" + this.app.getApplication().getString(2131719111);
      continue;
      str1 = "" + this.app.getApplication().getString(2131719105);
      continue;
      str1 = "" + this.app.getApplication().getString(2131719103);
      continue;
      str1 = "" + this.app.getApplication().getString(2131719101);
      continue;
      str1 = "" + this.app.getApplication().getString(2131719109);
      continue;
      str1 = "" + this.app.getApplication().getString(2131719107);
    }
  }
  
  private void onItemClick(View paramView)
  {
    atni.gN("0X800652B", 1);
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)wja.a(paramView);
    Intent localIntent;
    if (localMessageForDingdongSchedule != null)
    {
      localIntent = new Intent();
      localIntent.putExtra("schedule_feed_id", localMessageForDingdongSchedule.getSummaryData().id);
      localIntent.putExtra("schedule_begin_time", localMessageForDingdongSchedule.getSummaryData().beginTime);
      localIntent.putExtra("schedule_end_time", localMessageForDingdongSchedule.getSummaryData().endTime);
      localIntent.putExtra("param_uin_type", this.sessionInfo.cZ);
      localIntent.putExtra("param_entrance", 3);
      localIntent.putExtra("schedule_msg_frienduin", localMessageForDingdongSchedule.frienduin);
      localIntent.putExtra("schedule_msg_istroop", localMessageForDingdongSchedule.istroop);
      localIntent.putExtra("schedule_msg_uniseq", localMessageForDingdongSchedule.uniseq);
      if (localMessageForDingdongSchedule.extStr != null) {
        break label186;
      }
    }
    label186:
    for (String str = "";; str = localMessageForDingdongSchedule.extStr)
    {
      localIntent.putExtra("schedule_msg_extstring", str);
      localIntent.putExtra("schedule_msg_extlong", localMessageForDingdongSchedule.extLong);
      atni.startPluginActivityForResult((Activity)paramView.getContext(), "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
      atni.aU("0X8007E3E", 0, 1);
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = (xbl.a)paramChatMessage.getTag();
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
      QLog.e("DingdongScheduleItemBuilder", 1, "getView. error:" + paramView.toString() + ".");
    }
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)paramChatMessage;
    xbl.a locala = (xbl.a)parame;
    paramBaseChatItemLayout = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = LayoutInflater.from(this.mContext).inflate(2131558903, null);
      locala.title = ((TextView)paramBaseChatItemLayout.findViewById(2131380976));
      locala.Jd = ((TextView)paramBaseChatItemLayout.findViewById(2131380765));
      locala.Je = ((TextView)paramBaseChatItemLayout.findViewById(2131380792));
      locala.hA = ((RelativeLayout)paramBaseChatItemLayout.findViewById(2131365382));
      locala.name = ((TextView)paramBaseChatItemLayout.findViewById(2131380814));
      locala.Jc = ((TextView)paramBaseChatItemLayout.findViewById(2131380940));
      locala.hB = ((RelativeLayout)paramBaseChatItemLayout.findViewById(2131377475));
      locala.Jf = ((TextView)paramBaseChatItemLayout.findViewById(2131380907));
      locala.hC = ((RelativeLayout)paramBaseChatItemLayout.findViewById(2131377474));
      locala.bd = paramBaseChatItemLayout.findViewById(2131377702);
      paramBaseChatItemLayout.setOnLongClickListener(paramwlz);
      paramBaseChatItemLayout.setOnTouchListener(paramwlz);
      paramBaseChatItemLayout.setOnClickListener(this);
      locala.Jf.setOnClickListener(this);
    }
    locala.title.setText(localMessageForDingdongSchedule.getSummaryData().title);
    if (TextUtils.isEmpty(localMessageForDingdongSchedule.getSummaryData().location))
    {
      locala.Je.setVisibility(8);
      paramView = atni.f(localMessageForDingdongSchedule.getSummaryData().beginTime, localMessageForDingdongSchedule.getSummaryData().endTime, false);
      parame = paramView;
      if (localMessageForDingdongSchedule.getSummaryData().repeatType > 1)
      {
        if (localMessageForDingdongSchedule.notificationType == 4)
        {
          paramChatMessage = paramView;
          if (localMessageForDingdongSchedule.changedEndTime != -1L) {}
        }
        else
        {
          paramChatMessage = paramView + "\n" + cE(localMessageForDingdongSchedule.getSummaryData().repeatType);
        }
        parame = paramChatMessage;
        if (localMessageForDingdongSchedule.isPartRecall)
        {
          parame = new SimpleDateFormat(" M月d日截止", Locale.getDefault());
          parame = paramChatMessage + parame.format(new Date(localMessageForDingdongSchedule.changedBeginTime - 1L));
        }
      }
      locala.Jd.setText(parame);
      switch (localMessageForDingdongSchedule.notificationType)
      {
      default: 
        label460:
        long l = NetConnInfoCenter.getServerTimeMillis();
        if (((localMessageForDingdongSchedule.notificationType != 2) && (localMessageForDingdongSchedule.notificationType != 5) && (localMessageForDingdongSchedule.notificationType != 6) && (localMessageForDingdongSchedule.notificationType != 7)) || (localMessageForDingdongSchedule.getSummaryData().authorUin.equals(this.app.getCurrentAccountUin())) || (localMessageForDingdongSchedule.getSummaryData().endTime <= l)) {
          break label1011;
        }
        locala.hB.setVisibility(0);
        paramChatMessage = localMessageForDingdongSchedule.getExtInfoFromExtStr("schedule_msg_accept_status");
        if (!TextUtils.isEmpty(paramChatMessage)) {
          if (paramChatMessage.equals("2"))
          {
            locala.Jc.setVisibility(8);
            locala.hB.setVisibility(0);
            locala.hC.setVisibility(8);
            locala.bd.setVisibility(8);
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramChatMessage = localMessageForDingdongSchedule.getExtInfoFromExtStr("schedule_msg_has_fetch_detail");
      if ((localMessageForDingdongSchedule.getSummaryData().hasFetchedDetail != 1) && ((TextUtils.isEmpty(paramChatMessage)) || (paramChatMessage.equals("0"))))
      {
        localMessageForDingdongSchedule.getSummaryData().hasFetchedDetail = 1;
        if (this.app != null)
        {
          paramChatMessage = (atnf)this.app.getBusinessHandler(75);
          if (paramChatMessage != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DingdongScheduleMessage", 2, "start updateScheduleMsg after recieved a schedule message " + localMessageForDingdongSchedule.getSummaryData().id);
            }
            paramChatMessage.ba(localMessageForDingdongSchedule.uniseq, localMessageForDingdongSchedule.getSummaryData().id);
          }
        }
      }
      return paramBaseChatItemLayout;
      locala.Je.setVisibility(0);
      locala.Je.setText(String.format(this.app.getApplication().getString(2131692780), new Object[] { localMessageForDingdongSchedule.getSummaryData().location }));
      break;
      locala.Jc.setVisibility(8);
      break label460;
      locala.Jc.setVisibility(0);
      locala.Jc.setText(this.app.getApplication().getString(2131692787));
      break label460;
      locala.Jc.setVisibility(0);
      locala.Jc.setText(this.app.getApplication().getString(2131692785));
      break label460;
      locala.Jc.setVisibility(0);
      locala.Jc.setText(this.app.getApplication().getString(2131692785));
      break label460;
      if (paramChatMessage.equals("4"))
      {
        locala.hB.setVisibility(8);
        locala.hC.setVisibility(8);
        locala.bd.setVisibility(8);
      }
      else
      {
        locala.hB.setVisibility(8);
        locala.hC.setVisibility(0);
        locala.bd.setVisibility(0);
        continue;
        locala.hB.setVisibility(8);
        locala.hC.setVisibility(0);
        locala.bd.setVisibility(0);
      }
    }
    label1011:
    locala.hB.setVisibility(8);
    locala.hC.setVisibility(8);
    locala.bd.setVisibility(8);
    return paramBaseChatItemLayout;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xbl.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
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
      return this.app.getApplication().getString(2131692784);
    }
    return this.app.getApplication().getString(2131692783);
  }
  
  public void ei(View paramView) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)wja.a(paramView);
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
      case 2131365382: 
        onItemClick(paramView);
        break;
      case 2131380907: 
        if (localMessageForDingdongSchedule != null)
        {
          ((auga)this.app.getBusinessHandler(182)).a(localMessageForDingdongSchedule);
          anpc.report("tim_msg_tab_agenda_rec");
        }
        break;
      }
    }
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jc;
    public TextView Jd;
    public TextView Je;
    public TextView Jf;
    public View bd;
    public RelativeLayout hA;
    public RelativeLayout hB;
    public RelativeLayout hC;
    public TextView name;
    public TextView title;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbl
 * JD-Core Version:    0.7.0.1
 */