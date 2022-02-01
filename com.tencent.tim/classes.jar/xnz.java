import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.qphone.base.util.QLog;

public class xnz
  extends BaseBubbleBuilder
{
  View.OnClickListener dU = new xoa(this);
  
  public xnz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((parame instanceof xnz.a))
    {
      paramwlz = (xnz.a)parame;
      parame = paramView;
      paramView = paramwlz;
      if (parame != null) {
        break label498;
      }
      parame = LayoutInflater.from(localContext).inflate(2131560868, null);
      paramView.h = ((RoundCornerImageView)parame.findViewById(2131378683));
      paramView.ty = ((ImageView)parame.findViewById(2131378688));
      paramView.JT = ((TextView)parame.findViewById(2131378689));
      paramView.JS = ((TextView)parame.findViewById(2131378690));
      paramView.tz = ((ImageView)parame.findViewById(2131381292));
      paramView.wP = parame.findViewById(2131366060);
      paramView.wQ = parame.findViewById(2131365375);
      paramView.tA = ((ImageView)parame.findViewById(2131366032));
      paramView.wQ.getLayoutParams().width = BaseChatItemLayout.bNS;
    }
    label424:
    label498:
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.setHeadIconVisible(false);
        if (paramBaseChatItemLayout.HQ != null) {
          paramBaseChatItemLayout.HQ.setVisibility(8);
        }
        paramBaseChatItemLayout.J().setVisibility(4);
        if ((paramChatMessage instanceof MessageForStarLeague))
        {
          paramBaseChatItemLayout = (MessageForStarLeague)paramChatMessage;
          paramView.JS.setText(paramBaseChatItemLayout.starName);
          paramView.JT.setText(paramBaseChatItemLayout.subTitle);
          if (paramBaseChatItemLayout.levelStatus != 1) {
            break label424;
          }
          paramView.wQ.setBackgroundResource(2130844709);
          paramView.ty.setImageResource(2130844705);
          paramView.tz.setVisibility(0);
          paramView.tA.setVisibility(8);
          paramView.JS.setTextColor(-1);
          paramView.JT.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramwlz = URLDrawable.URLDrawableOptions.obtain();
          paramwlz.mRequestWidth = aqcx.dip2px(localContext, 64.0F);
          paramwlz.mRequestHeight = aqcx.dip2px(localContext, 64.0F);
          paramwlz.mFailedDrawable = null;
          paramwlz.mLoadingDrawable = null;
          paramwlz = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramwlz);
          paramView.h.setImageDrawable(paramwlz);
          paramView.h.setCorner(aqcx.dip2px(localContext, 32.0F));
          paramView.wQ.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.wQ.setOnClickListener(this.dU);
          paramView.mMessage = paramChatMessage;
          return parame;
          paramView = (xnz.a)a();
          paramView.a = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          parame = null;
          break;
          paramView.wQ.setBackgroundResource(2130844706);
          paramView.ty.setImageResource(2130844704);
          paramView.tz.setVisibility(8);
          paramView.tA.setVisibility(0);
          paramView.JS.setTextColor(-16777216);
          paramView.JT.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramwlz)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramwlz);
          }
        }
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xnz.a();
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    paramChatMessage = (xnz.a)parame;
    if (paramChatMessage.E != null)
    {
      paramContext = paramChatMessage.E.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.E.setLayoutParams(paramContext);
    }
  }
  
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
  
  class a
    extends BaseBubbleBuilder.e
  {
    TextView JS;
    TextView JT;
    RoundCornerImageView h;
    ImageView tA;
    ImageView ty;
    ImageView tz;
    View wP;
    View wQ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */