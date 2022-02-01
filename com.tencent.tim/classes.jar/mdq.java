import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.widget.AbsListView;

public class mdq
  extends StructingMsgItemBuilder
{
  public mdq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing)
  {
    int j = 2;
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {}
    do
    {
      return;
      paramMessageForStructing = paramMessageForStructing.structingMsg.mMsgUrl;
    } while (TextUtils.isEmpty(paramMessageForStructing));
    boolean bool = paramMessageForStructing.startsWith("https://post.mp.qq.com/kan/article/");
    paramMessageForStructing = Uri.parse(paramMessageForStructing).getQueryParameter("rowkey");
    kxm.b localb1;
    kxm.b localb2;
    if (bool)
    {
      i = 1;
      localb1 = new kxm.b();
      localb2 = localb1.a("content_type", Integer.valueOf(i));
      if (!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
        break label149;
      }
    }
    label149:
    for (int i = j;; i = 1)
    {
      localb2.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", kxm.iT());
      if (!TextUtils.isEmpty(paramMessageForStructing)) {
        localb1.a("rowkey", paramMessageForStructing);
      }
      kbp.bp(paramString, localb1.build());
      return;
      i = 2;
      break;
    }
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    a("0X800AD69", paramMessageForStructing);
  }
  
  private void cI(View paramView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { -30.0F, 0.0F });
    localValueAnimator.setInterpolator(new mds(this));
    localValueAnimator.setDuration(3000L);
    localValueAnimator.addUpdateListener(new mdt(this, paramView));
    localValueAnimator.start();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    if (paramView == null) {}
    for (int i = 1;; i = 0)
    {
      paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
      if (i != 0)
      {
        paramView.setTag(2131370590, "RIJRedPacketStruttingMsgItemBuilder");
        paramwlz = (mdq.a)paramView.getTag();
        PressEffectImageView localPressEffectImageView = new PressEffectImageView(this.mContext);
        localPressEffectImageView.setId(2131376670);
        localPressEffectImageView.setImageResource(2130850294);
        localPressEffectImageView.setPivotX(riw.dip2px(this.mContext, 10.0F));
        localPressEffectImageView.setPivotY(0.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(riw.dip2px(this.mContext, 20.0F), riw.dip2px(this.mContext, 23.5F));
        localLayoutParams.addRule(7, 2131364503);
        localLayoutParams.addRule(6, 2131364503);
        localLayoutParams.rightMargin = riw.dip2px(this.mContext, 20.0F);
        localLayoutParams.topMargin = riw.dip2px(this.mContext, 17.0F);
        ((ViewGroup)paramView).addView(localPressEffectImageView, localLayoutParams);
        paramwlz.a = localPressEffectImageView;
        cI(localPressEffectImageView);
      }
      paramViewGroup = (AbsListView)paramViewGroup;
      paramChatMessage = new mdr(this, paramViewGroup, paramChatMessage);
      if (paramViewGroup.getTag(2131370592) == null)
      {
        paramViewGroup.setTag(2131370592, paramChatMessage);
        paramViewGroup.addOnScrollListener(paramChatMessage);
      }
      return paramView;
    }
  }
  
  protected mdq.a a()
  {
    return new mdq.a(null);
  }
  
  public void c(MessageForStructing paramMessageForStructing)
  {
    a("0X800AD6A", paramMessageForStructing);
  }
  
  class a
    extends StructingMsgItemBuilder.a
  {
    PressEffectImageView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdq
 * JD-Core Version:    0.7.0.1
 */