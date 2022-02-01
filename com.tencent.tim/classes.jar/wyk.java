import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMessageProgressView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class wyk
  extends wzb
{
  private long IK;
  private abhc a;
  private aqju e;
  private boolean mClickable = true;
  protected View.OnClickListener onClickListener = new wyl(this);
  
  public wyk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = ((abhe)paramQQAppInterface.getManager(211)).a();
    abmt.cc(paramQQAppInterface);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    Object localObject;
    if (this.sessionInfo.cZ == 1036)
    {
      localObject = ApolloUtil.c(paramMessageForApollo);
      if ((NetConnInfoCenter.getServerTimeMillis() / 1000L < paramMessageForApollo.time + 60L) && (paramMessageForApollo.gameStatus == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP start robot game");
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, true, "message", paramMessageForApollo.roomId, 7, 0, this.sessionInfo.cZ, ApolloGameUtil.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl), this.sessionInfo.aTl, 318001, paramMessageForApollo.gameName);
        localStartCheckParam.extendJson = paramMessageForApollo.extendJson;
        localStartCheckParam.disableMinGame = true;
        localStartCheckParam.mRobotOpenId = ((String)localObject);
        localStartCheckParam.mTempAIOUin = this.sessionInfo.aTl;
        localStartCheckParam.mTempAIONickName = this.sessionInfo.aTn;
        ApolloGameUtil.a(this.mContext, localStartCheckParam);
        abmh.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, paramMessageForApollo.gameId, paramMessageForApollo.roomId);
        return;
      }
      QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP onClickGameView but dispatch to ark");
      return;
    }
    int i;
    if (paramMessageForApollo.msgType == 4)
    {
      i = 201;
      int j = paramMessageForApollo.mGameMode;
      localObject = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, paramMessageForApollo.isSend(), "message", paramMessageForApollo.roomId, 1, j, this.sessionInfo.cZ, ApolloGameUtil.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl), this.sessionInfo.aTl, i, paramMessageForApollo.gameName);
      if (paramMessageForApollo.msgType != 4) {
        break label360;
      }
      ((CmGameStartChecker.StartCheckParam)localObject).launchNewGame = true;
    }
    for (;;)
    {
      ((CmGameStartChecker.StartCheckParam)localObject).mSendMsgUin = paramMessageForApollo.senderuin;
      ((CmGameStartChecker.StartCheckParam)localObject).msgGameStatus = paramMessageForApollo.gameStatus;
      ((CmGameStartChecker.StartCheckParam)localObject).extendJson = paramMessageForApollo.gameExtendJson;
      ApolloGameUtil.a(this.mContext, (CmGameStartChecker.StartCheckParam)localObject);
      return;
      i = 200;
      break;
      label360:
      ((CmGameStartChecker.StartCheckParam)localObject).showAlertTips = true;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView)
  {
    if ((paramMessageForApollo == null) || (paramView == null)) {}
    while (TextUtils.isEmpty(ApolloUtil.c(paramMessageForApollo))) {
      return;
    }
    fh(paramView);
  }
  
  protected static void a(wyk.a parama, int paramInt)
  {
    if (paramInt < 100)
    {
      parama.a.setDrawStatus(1);
      parama.a.setAnimProgress(paramInt, parama.mMessage.frienduin + parama.mMessage.uniseq);
      return;
    }
    parama.a.setAnimProgress(paramInt, parama.mMessage.frienduin + parama.mMessage.uniseq);
  }
  
  private void a(wyk.a parama, MessageForApollo paramMessageForApollo, View paramView)
  {
    if (parama.a == null)
    {
      parama.a = new ApolloMessageProgressView(this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(242.66667F, this.mContext.getResources()), wja.dp2px(173.0F, this.mContext.getResources()));
      localLayoutParams.addRule(13);
      parama.a.setRadius(15.0F, true);
      parama.a.setShowCorner(false);
      parama.a.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      parama.a.setCornerDirection(false);
      ((RelativeLayout)paramView).addView(parama.a, localLayoutParams);
    }
    paramMessageForApollo = ((abhe)this.app.getManager(211)).a(paramMessageForApollo.gameId);
    if ((paramMessageForApollo != null) && (paramMessageForApollo.uniseq == parama.mMessage.uniseq))
    {
      parama.a.setVisibility(8);
      return;
    }
    parama.a.setVisibility(4);
  }
  
  public static void a(wyk.a parama, MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((parama == null) || (paramQQAppInterface == null) || (paramMessageForApollo == null)) {}
    for (;;)
    {
      return;
      if (paramMessageForApollo.uniseq == parama.mMessage.uniseq)
      {
        parama.a.setVisibility(0);
        a(parama, paramInt2);
        if (paramInt2 == 100) {
          parama.a.setVisibility(8);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloGameItemBuilder", 2, new Object[] { "gameId = ", Integer.valueOf(paramInt1), ":", Integer.valueOf(paramInt2) });
        return;
        parama.a.setVisibility(8);
      }
    }
  }
  
  private void fh(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int k = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = ((ViewGroup)paramView).getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(j);
            if ((localView2 instanceof ArkAppView))
            {
              localView2.setOnTouchListener(null);
              localView2.setClickable(false);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean Rk()
  {
    return BaseChatItemLayout.bdx;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if (!(paramChatMessage.getTag() instanceof wyk.a))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getView], NOT GameHolder.");
      return paramChatMessage;
    }
    paramView = (wyk.a)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.E.getLayoutParams();
    paramwlz = paramChatMessage.J();
    if ((paramwlz != null) && (paramwlz.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364521);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.bNV;; paramViewGroup.topMargin = 0)
    {
      paramView.E.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364512);
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if ((paramChatMessage == null) || (parame == null) || (paramBaseChatItemLayout == null) || (this.a == null)) {
      return paramView;
    }
    if (!(parame instanceof wyk.a))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getBubbleView], NOT GameHolder.");
      return paramView;
    }
    paramChatMessage = (MessageForApollo)paramChatMessage;
    parame = (wyk.a)parame;
    MessageForArkApp localMessageForArkApp = this.a.a(paramChatMessage, paramChatMessage.mApolloGameArkMsg);
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new wyv();
    }
    localMessageForArkApp.arkContainer.zo(true);
    paramChatMessage.mApolloGameArkMsg = localMessageForArkApp;
    paramView = super.a(localMessageForArkApp, parame, paramView, paramBaseChatItemLayout, paramwlz);
    a(parame, paramChatMessage, paramView);
    parame.d.setOnClickListener(this.onClickListener);
    a(paramChatMessage, paramView);
    return paramView;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wyk.a();
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    if (!(parame instanceof wyk.a)) {
      QLog.w("ApolloGameItemBuilder", 1, "[handleBubbleBg], NOT GameHolder.");
    }
    do
    {
      return;
      paramChatMessage = (wyk.a)parame;
    } while (paramChatMessage.d == null);
    paramChatMessage.E.setBackgroundResource(0);
    paramChatMessage.E.setPadding(0, 0, 0, 0);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    if (ApolloUtil.V(paramView))
    {
      e(localaqoa, this.mContext);
      return localaqoa.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.app, "cmshow", "Apollo", "long_press_msg", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131702520) + paramChatMessage.msg;
  }
  
  public void b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.app, this.sessionInfo.aTl, this.sessionInfo.cZ);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void ei(View paramView)
  {
    paramView = (wzb.a)wja.a(paramView);
    try
    {
      if (paramView.mMessage.isSend())
      {
        QLog.w("ApolloGameItemBuilder", 1, "onErrorIconClick err code: " + paramView.mMessage.sendFailCode + ", extraflag: " + paramView.mMessage.extraflag);
        ausj localausj = (ausj)auss.a(this.mContext, null);
        if ((paramView.mMessage.sendFailCode != 0) || (super.a(paramView.mMessage, paramView.a)))
        {
          localausj.addButton(this.mContext.getResources().getString(2131690343), 1);
          localausj.addCancelButton(2131721058);
          localausj.a(new wym(this, paramView, localausj));
          localausj.show();
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("ApolloGameItemBuilder", 1, paramView, new Object[0]);
    }
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public static class a
    extends wzb.a
  {
    public ApolloMessageProgressView a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */