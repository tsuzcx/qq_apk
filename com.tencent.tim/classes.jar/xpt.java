import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;

public class xpt
  extends BaseBubbleBuilder
  implements View.OnClickListener, wla.a
{
  protected static SparseArray<xpt.a> bx = new SparseArray(3);
  
  static
  {
    bx.put(40000, new xpt.a(40000, acfp.m(2131715660), Color.parseColor("#F2836DE1")));
    bx.put(40001, new xpt.a(40001, acfp.m(2131715658), Color.parseColor("#F2EF7AEE")));
    bx.put(40002, new xpt.a(40002, acfp.m(2131715659), Color.parseColor("#F23FCCDF")));
    bx.put(40003, new xpt.a(40003, acfp.m(2131715656), Color.parseColor("#F2FFA02D")));
    bx.put(40004, new xpt.a(40004, acfp.m(2131715653), Color.parseColor("#F21CD28C")));
    bx.put(40005, new xpt.a(40005, acfp.m(2131715652), Color.parseColor("#F2FF6EA2")));
  }
  
  public xpt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    xpt.b localb = (xpt.b)parame;
    if (paramView == null)
    {
      parame = LayoutInflater.from(this.mContext).inflate(2131563247, null);
      localb.layout = ((RelativeLayout)parame);
      localb.c = ((BubbleImageView)parame.findViewById(2131380261));
      localb.c.setRadius(12.0F);
      localb.c.TE(false);
      localb.JZ = ((TextView)parame.findViewById(2131378587));
      localb.nameText = ((TextView)parame.findViewById(2131380373));
      localb.au = ((URLImageView)parame.findViewById(2131380260));
      localb.JZ.setOnClickListener(this);
      localb.c.setOnClickListener(this);
      localb.c.setOnTouchListener(paramwlz);
      localb.c.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
    }
    for (;;)
    {
      paramView = localb.c;
      int i = aoop.G(false);
      int j = aoop.H(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (aTl) {
        paramView.setContentDescription(acfp.m(2131715651));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramwlz = aoop.a(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localb.u == null) || (!localb.u.getURL().equals(paramwlz)))
        {
          if (localb.u != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localb.u.getURL() + "==url=" + paramwlz);
          }
          paramBaseChatItemLayout = xkl.a(this.mContext, localMessageForTroopEffectPic, localb.c, paramBaseChatItemLayout);
          localb.c.setImageDrawable(paramBaseChatItemLayout);
          localb.u = paramBaseChatItemLayout;
          this.app.a().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramwlz);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localb.u.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (xpt.a)bx.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label776;
        }
        localb.nameText.setVisibility(0);
        localb.nameText.setText(paramView.aVQ);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = aqcx.dip2px(this.mContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.bWa);
        localb.nameText.setBackgroundDrawable(paramBaseChatItemLayout);
        label595:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label789;
        }
        localb.au.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(aqbn.d(190, 270, aqcx.dip2px(this.mContext, 12.0F)));
        paramView.setDecodeHandler(aqbn.a);
        localb.au.setImageDrawable(paramView);
      }
      for (;;)
      {
        localb.c.setTag(paramChatMessage);
        localb.JZ.setTag(paramChatMessage);
        return parame;
        paramView = localb.u;
        paramBaseChatItemLayout[0] = localb.c.getWidth();
        paramBaseChatItemLayout[1] = localb.c.getHeight();
        break;
        label776:
        localb.nameText.setVisibility(8);
        break label595;
        label789:
        localb.au.setVisibility(8);
      }
      parame = paramView;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xpt.b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2) {}
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = ((wko.a)wja.a(paramView)).mMessage;
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131715657);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131380261: 
      localObject = ((FragmentActivity)this.mContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if (!((TroopChatPie)localObject).a().aBG())
          {
            apqk localapqk = (apqk)this.app.getManager(223);
            MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramView.getTag();
            localapqk.Ty(localMessageForTroopEffectPic.frienduin);
            localapqk.ebr();
            localapqk.a(localMessageForTroopEffectPic, false);
            localapqk.B((BaseChatPie)localObject);
            localapqk.ebq();
          }
        }
      }
      for (;;)
      {
        apyu.ih("obj_msg", "clk_play");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "[EffectPic] curPie is null.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "[EffectPic] chatFragment is null.");
          }
        }
      }
    }
    if (aqmj.aF(this.mContext, this.app.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.f((Activity)this.mContext, this.sessionInfo.aTl, this.sessionInfo.troopUin);
    }
    for (;;)
    {
      apyu.ih("obj_msg", "clk_tail    ");
      break;
      aqmj.cN(this.mContext, this.app.getCurrentAccountUin());
      localObject = new Intent(this.mContext, TroopPicEffectGuidePicActivity.class);
      ((Intent)localObject).putExtra("friendUin", this.sessionInfo.aTl);
      ((Intent)localObject).putExtra("troopUin", this.sessionInfo.troopUin);
      this.mContext.startActivity((Intent)localObject);
    }
  }
  
  public static class a
  {
    public String aVQ;
    public int bVZ;
    public int bWa;
    
    public a(int paramInt1, String paramString, int paramInt2)
    {
      this.bVZ = paramInt1;
      this.aVQ = paramString;
      this.bWa = paramInt2;
    }
  }
  
  public static class b
    extends BaseBubbleBuilder.e
  {
    public TextView JZ;
    public URLImageView au;
    public BubbleImageView c;
    public RelativeLayout layout;
    public TextView nameText;
    public URLDrawable u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpt
 * JD-Core Version:    0.7.0.1
 */