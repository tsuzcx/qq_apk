import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.StoryChatVideoView;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.b;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.a;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class xqp
  extends QQStoryItemBuilder
{
  public xqp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    case 2131367523: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      rnw.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.bOY);
      paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ahgq.f((Activity)this.mContext, paramChatMessage, 21);
      return;
    case 2131372030: 
      super.j(paramChatMessage);
      return;
    }
    super.k(paramChatMessage);
  }
  
  public void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    QQStoryItemBuilder.b localb = (QQStoryItemBuilder.b)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localb.be != null) {
        localb.be.setVisibility(8);
      }
      localb.Jv.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (ShortVideoUtils.a.bhO)) {
        break label233;
      }
      localb.isPlaying = false;
      localb.b.setDrawStatus(2);
      localb.b.setVisibility(0);
      a(localb.a, paramChatMessage.thumbUrl, this.bUz, this.bUA, this.dR);
      localb.e.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localb.be == null) {
        a(localb, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localb.Jw.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.bNY;; paramViewGroup.leftMargin = (aqcx.dip2px(this.mContext, localb.a.AO) + BaseChatItemLayout.bNX))
      {
        localb.Jw.setLayoutParams(paramViewGroup);
        localb.Jw.setText(paramChatMessage.sourceName);
        localb.be.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localb.a.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localb.isPlaying = false;
    localb.e.setImageDrawable(null);
    a(localb.a, paramChatMessage.thumbUrl, this.bUz, this.bUA, this.dR);
    a(localb, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localb.a.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  public void a(QQStoryItemBuilder.b paramb)
  {
    if ((paramb != null) && ((paramb.mMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramb.mMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramb.isPlaying) && (ShortVideoUtils.a.bhO))
      {
        a(paramb, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (rpq.isFastDoubleClick());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).b();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      qgg.a(this.mContext, (OpenPlayerBuilder.Data)localObject, paramb.a);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    qgg.a(this.mContext, ((OpenPlayerBuilder)localObject).b(), paramb.a);
  }
  
  public void a(QQStoryItemBuilder.b paramb, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramb, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramb.mMessage.istroop == 1) && ((paramb.mMessage instanceof MessageForTroopStory)) && (!aqfv.a().b(paramb.mMessage, "aio_msg|play_msg_obj")))
    {
      aqfv.a().g(paramb.mMessage, "aio_msg|play_msg_obj");
      rar.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramb.mMessage).storyId });
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.app.a().aR(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (QQStoryItemBuilder.b)wja.a(paramView);
    boolean bool = "1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.mMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      }
      if (!this.app.a().aR(paramView)) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
    }
    a(localaqoa, paramView);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public void b(QQStoryItemBuilder.b paramb)
  {
    try
    {
      paramb = (MessageForTroopStory)paramb.mMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramb.toString() + ", sourceType = " + paramb.sourceActionData + ", sourceActionData = " + paramb.sourceActionData);
      }
      if ("plugin".equals(paramb.sourceActionType))
      {
        paramb = aqik.c(this.app, this.mContext, paramb.sourceActionData);
        if (paramb != null) {
          paramb.ace();
        }
      }
      return;
    }
    catch (Exception paramb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramb);
    }
  }
  
  public void ei(View paramView)
  {
    paramView = (MessageForTroopStory)((QQStoryItemBuilder.b)wja.a(paramView)).mMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xqq(this, paramView, localausj));
    localausj.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqp
 * JD-Core Version:    0.7.0.1
 */