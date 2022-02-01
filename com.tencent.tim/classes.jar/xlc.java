import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class xlc
  extends BaseBubbleBuilder
  implements aghj.a, BaseChatItemLayout.a
{
  protected aghj a;
  protected aghl a;
  protected agjs a;
  
  public xlc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return paramaqoa;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramaqoa.Z(2131366079, this.mContext.getString(2131693838), 2130839082);
          break;
        case 3: 
          paramaqoa.Z(2131364231, this.mContext.getString(2131699553), 2130839082);
          break;
        case 4: 
          paramaqoa.Z(2131372908, this.mContext.getString(2131693840), 2130839089);
          break;
        case 5: 
          paramaqoa.Z(2131377218, this.mContext.getString(2131694114), 2130839091);
          break;
        case 7: 
          paramaqoa.Z(2131372910, this.mContext.getString(2131693840), 2130839089);
          break;
        case 8: 
          paramaqoa.Z(2131377219, this.mContext.getString(2131694144), 2130839091);
          break;
        case 6: 
          paramaqoa.Z(2131364237, this.mContext.getString(2131691403), 2130839075);
          break;
        case 9: 
          paramaqoa.Z(2131367523, this.mContext.getString(2131693530), 2130839086);
          break;
        case 10: 
          a(paramChatMessage, paramaqoa);
          break;
        case 11: 
          b(paramChatMessage, paramaqoa);
          break;
        case 14: 
          a(paramaqoa, this.sessionInfo.cZ, paramChatMessage);
          break;
        case 19: 
          paramaqoa.Z(2131367550, this.mContext.getString(2131693586), 2130839086);
          break;
        case 16: 
          a(paramaqoa, paramChatMessage);
          break;
        case 17: 
          paramaqoa.Z(2131366733, this.mContext.getString(2131693526), 2130839085);
          break;
        case 18: 
          e(paramaqoa, this.mContext);
          break;
        case 20: 
          paramaqoa.Z(2131377634, this.mContext.getString(2131693585), 2130839086);
          break;
        case 15: 
          super.c(paramaqoa, this.mContext);
          break;
        case 12: 
          b(paramaqoa, this.mContext);
          break;
        case 13: 
          paramaqoa.Z(2131377629, this.mContext.getString(2131699561), 2130839082);
          break;
        case 21: 
          paramaqoa.Z(2131379277, this.mContext.getString(2131720920), 2130839097);
          break;
        case 22: 
          paramaqoa.Z(2131378005, "StructMsg", 2130839086);
          break;
        case 23: 
          ApolloUtil.a(paramaqoa, this.jdField_a_of_type_Agjs.getFileName());
          break;
        case 24: 
          paramaqoa.Z(2131364851, acfp.m(2131706232), 2130839085);
          break;
        case 25: 
          paramaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
        }
      }
    }
  }
  
  public void I(ChatMessage paramChatMessage)
  {
    this.adapter.notifyDataSetChanged();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramViewGroup = (BaseBubbleBuilder.e)wja.a(paramView);
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    if (this.jdField_a_of_type_Aghl != null) {
      this.jdField_a_of_type_Aghl.b(paramViewGroup, paramView, this.jdField_a_of_type_Agjs.d());
    }
    if (this.jdField_a_of_type_Aghj != null)
    {
      this.jdField_a_of_type_Aghj.a(this);
      this.jdField_a_of_type_Aghj.a(paramViewGroup, paramView, this.jdField_a_of_type_Agjs.d());
    }
    return paramView;
  }
  
  protected abstract View a(BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz);
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    this.jdField_a_of_type_Agjs.dgY();
    paramChatMessage = a(parame, paramView, paramBaseChatItemLayout, paramwlz);
    if ((parame instanceof xlc.a)) {
      a((xlc.a)parame, paramBaseChatItemLayout, this.jdField_a_of_type_Agjs.alq());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Agjs.alp(), this);
    return paramChatMessage;
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    return a(paramaqoa, paramChatMessage, b(paramaqoa, parama));
  }
  
  public BaseBubbleBuilder.e a()
  {
    return b();
  }
  
  protected abstract List<Integer> a(aqoa paramaqoa, wko.a parama);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    b(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(agjs paramagjs)
  {
    this.jdField_a_of_type_Agjs = paramagjs;
    this.jdField_a_of_type_Aghl = this.jdField_a_of_type_Agjs.a();
    this.jdField_a_of_type_Aghj = this.jdField_a_of_type_Agjs.a();
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    a(paramChatMessage, parame);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame) {}
  
  protected void a(xlc.a parama, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (parama.Jq != null) {
        parama.Jq.setVisibility(8);
      }
      return;
    }
    if (parama.Jq == null)
    {
      parama.Jq = new TextView(this.mContext);
      parama.Jq.setBackgroundResource(2130843454);
      parama.Jq.setTextSize(1, 12.0F);
      parama.Jq.setTextColor(this.mContext.getResources().getColor(2131167654));
      parama.Jq.setText(this.jdField_a_of_type_Agjs.va());
      parama.Jq.setSingleLine();
      parama.Jq.setGravity(16);
      parama.Jq.setPadding(aqcx.dip2px(this.mContext, 8.0F), 0, aqcx.dip2px(this.mContext, 8.0F), 0);
      parama.Jq.setOnClickListener(new xld(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364503);
      paramViewGroup.addView(parama.Jq, localLayoutParams);
    }
    parama.Jq.setVisibility(0);
    if (this.jdField_a_of_type_Agjs.alo())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)parama.Jq.getLayoutParams();
      paramViewGroup.addRule(7, 2131364503);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.mContext.getResources().getDimensionPixelSize(2131296407) + aqcx.dip2px(this.mContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      parama.Jq.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)parama.Jq.getLayoutParams();
    paramViewGroup.addRule(5, 2131364503);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.mContext.getResources().getDimensionPixelSize(2131296407) + aqcx.dip2px(this.mContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    parama.Jq.setLayoutParams(paramViewGroup);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = b(paramView);
    aqoa localaqoa = new aqoa();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      a(localaqoa, paramView, null);
    }
    for (;;)
    {
      return localaqoa.a();
      label38:
      b(localaqoa, paramView, null);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    paramaqoa = a(paramaqoa, paramChatMessage, a(paramaqoa, parama));
    super.a(paramaqoa, this.mContext, paramChatMessage, true);
    return paramaqoa;
  }
  
  protected abstract BaseBubbleBuilder.e b();
  
  protected ChatMessage b(View paramView)
  {
    return ((wko.a)wja.a(paramView)).mMessage;
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Agjs.S(paramChatMessage);
    return e(paramChatMessage);
  }
  
  protected abstract List<Integer> b(aqoa paramaqoa, wko.a parama);
  
  protected abstract void b(int paramInt, ChatMessage paramChatMessage);
  
  protected abstract String e(ChatMessage paramChatMessage);
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = b(paramView);
    this.jdField_a_of_type_Agjs.S(paramView);
    this.jdField_a_of_type_Agjs.dha();
  }
  
  protected abstract void fu(View paramView);
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ChatMessage localChatMessage = b(paramView);
      this.jdField_a_of_type_Agjs.S(localChatMessage);
      fu(paramView);
      super.onClick(paramView);
    }
  }
  
  public void p(ChatMessage paramChatMessage) {}
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jq;
    public CircleFileStateView a;
    public ImageView tn;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlc
 * JD-Core Version:    0.7.0.1
 */