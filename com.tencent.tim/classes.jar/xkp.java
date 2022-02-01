import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder.1;
import com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class xkp
  extends BaseBubbleBuilder
{
  protected long IX;
  private StickerBubbleReceiverAnimationRunnable a;
  private Drawable mDefaultDrawable;
  
  public xkp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(xkp.a parama, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    parama.mMessage = paramMessageForPokeEmo;
    xks.B(this.app);
    boolean bool = xks.bhj;
    if (bool)
    {
      Drawable localDrawable = yfx.p(i);
      parama.a.setImageDrawable(localDrawable);
      parama.a.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      parama.a.setIsSend(paramMessageForPokeEmo.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(wja.bcL), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(wja.bNH), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.aXo);
      }
      if (!wja.bcL) {
        break label269;
      }
    }
    label269:
    label397:
    do
    {
      do
      {
        return;
        if (this.mDefaultDrawable == null) {
          this.mDefaultDrawable = this.mContext.getResources().getDrawable(2130842311);
        }
        parama.a.setImageDrawable(this.mDefaultDrawable);
        parama.a.setText("x" + paramMessageForPokeEmo.pokeemoPressCount * 1000);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.mContext instanceof ChatHistoryActivity)) || (GesturePWDUnlockActivity.aXo)) {
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        wja.bNH += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        parama = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332);
      } while (parama == null);
      paramMessageForPokeEmo = yfx.cK(i);
      this.a = new StickerBubbleReceiverAnimationRunnable(this.app, j, parama, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.a);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject = this.mContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    xkp.a locala = (xkp.a)parame;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    parame = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      parame = new RelativeLayout((Context)localObject);
      parame.setId(2131377546);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131373478);
      parame.addView(paramView, new ViewGroup.LayoutParams(-1, wja.dp2px(80.0F, ((Context)localObject).getResources())));
      locala.a = paramView;
      localObject = yfx.mTypeface;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
        paramView.setText("x3");
        aqcl.Q(paramView, false);
      }
    }
    else
    {
      if ((!locala.a.Tx()) && (yfx.mTypeface != null)) {
        locala.a.setTypeFace(yfx.mTypeface);
      }
      if ("PEPanelHelper.mTypeface != null :" + yfx.mTypeface == null) {
        break label359;
      }
    }
    label359:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
      parame.setTag(locala);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
      a(locala, paramBaseChatItemLayout);
      if (aTl)
      {
        if ((locala.E != null) && (locala.E.length() > 0)) {
          locala.E.setLength(0);
        }
        parame.setContentDescription(b(paramChatMessage));
      }
      return parame;
      if ((!xks.bhj) || (yfx.bmo)) {
        break;
      }
      yfx.bmo = true;
      ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      break;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xkp.a();
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
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if ((paramView != null) && (paramView.mMessage != null) && ((paramView.mMessage instanceof MessageForPokeEmo)) && (paramView.mMessage.istroop == 0)) {
      a(paramView.mMessage, localaqoa);
    }
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(aqmu.a(this.mContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    MessageForPokeEmo localMessageForPokeEmo = (MessageForPokeEmo)paramChatMessage;
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我向" + this.sessionInfo.aTn + String.format("发出%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.sessionInfo.aTn + String.format("发来%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
  }
  
  public void destroy()
  {
    super.destroy();
    wja.bNH = 0;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)wja.a(paramView);
    } while (!paramView.isSendFromLocal());
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xkq(this, paramView, localausj));
    localausj.show();
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    PokeEmoItemView a;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkp
 * JD-Core Version:    0.7.0.1
 */