import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;

public abstract class aghl
{
  protected ausj B;
  protected View.OnClickListener fa = new aghm(this);
  protected QQAppInterface mApp;
  protected Context mContext;
  
  public aghl(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private void b(BaseBubbleBuilder.e parame, boolean paramBoolean)
  {
    parame = a(parame);
    if (paramBoolean) {
      if (parame != null)
      {
        parame.setVisibility(0);
        parame.setOnClickListener(this.fa);
      }
    }
    while (parame == null) {
      return;
    }
    parame.setVisibility(8);
    parame.setOnClickListener(null);
  }
  
  protected boolean J(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean K(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected abstract ImageView a(BaseBubbleBuilder.e parame);
  
  protected abstract void a(BaseBubbleBuilder.e parame, ImageView paramImageView);
  
  protected void b(View paramView, BaseBubbleBuilder.e parame, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void b(ausj.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ausi(0, auss.n(this.mContext, 2131718845), 0, 0, 2));
    this.B = auss.a(this.mContext, localArrayList, parama);
    this.B.addCancelButton(2131721058);
    auss.a((Activity)this.mContext, this.B);
  }
  
  public void b(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (J(paramChatMessage))
    {
      paramChatMessage = a(parame);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.mContext);
        paramChatMessage.setImageResource(2130838370);
        paramChatMessage.setId(2131364522);
        a(parame, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = wja.dp2px(16.0F, this.mContext.getResources());
        localLayoutParams.addRule(8, 2131364503);
        localLayoutParams.addRule(0, 2131364503);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        b(parame, true);
        return;
        paramChatMessage.setImageResource(2130838370);
      }
    }
    if (K(paramChatMessage))
    {
      paramChatMessage = a(parame);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.mContext);
        paramChatMessage.setImageResource(2130838365);
        paramChatMessage.setId(2131364522);
        a(parame, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = wja.dp2px(16.0F, this.mContext.getResources());
        localLayoutParams.addRule(8, 2131364503);
        localLayoutParams.addRule(0, 2131364503);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        b(parame, true);
        return;
        paramChatMessage.setImageResource(2130838365);
      }
    }
    b(parame, false);
  }
  
  protected void bJq()
  {
    if ((this.B != null) && (this.B.isShowing())) {
      auss.b((Activity)this.mContext, this.B);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghl
 * JD-Core Version:    0.7.0.1
 */