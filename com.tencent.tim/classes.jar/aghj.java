import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class aghj
{
  protected aghj.a a;
  protected View.OnClickListener eZ = new aghk(this);
  protected QQAppInterface mApp;
  protected Context mContext;
  
  public aghj(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private void a(BaseBubbleBuilder.e parame, boolean paramBoolean)
  {
    parame = a(parame);
    if (paramBoolean) {
      if (parame != null)
      {
        parame.setVisibility(0);
        parame.setOnClickListener(this.eZ);
      }
    }
    while (parame == null) {
      return;
    }
    parame.setVisibility(8);
    parame.setOnClickListener(null);
  }
  
  protected boolean I(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean J(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected abstract CircleFileStateView a(BaseBubbleBuilder.e parame);
  
  public void a(aghj.a parama)
  {
    this.a = parama;
  }
  
  protected void a(View paramView, BaseBubbleBuilder.e parame, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage)
  {
    a(parame, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (I(paramChatMessage))
    {
      localObject = a(parame);
      if (localObject == null)
      {
        localObject = this.mContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.mContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364507);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(parame, localCircleFileStateView);
        i = wja.dp2px(24.0F, this.mContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296405);
        localLayoutParams.addRule(8, 2131364503);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364503);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(parame, true);
        }
      }
    }
    while (!J(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364503);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = wja.dp2px(24.0F, this.mContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364503);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364503);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364503);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364503);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(parame);
    if (localObject == null)
    {
      localObject = this.mContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.mContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364507);
      localCircleFileStateView.setCenterBgColor(-1);
      a(parame, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = wja.dp2px(24.0F, this.mContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296405);
      localLayoutParams.addRule(8, 2131364503);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364503);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(parame, true);
        return;
        localLayoutParams.addRule(1, 2131364503);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = wja.dp2px(24.0F, this.mContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364503);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364503);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364503);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364503);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(BaseBubbleBuilder.e parame, CircleFileStateView paramCircleFileStateView);
  
  public static abstract interface a
  {
    public abstract void I(ChatMessage paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghj
 * JD-Core Version:    0.7.0.1
 */