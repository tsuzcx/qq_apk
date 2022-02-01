import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ahih
  extends ahgq
{
  protected MessageForMixedMsg b;
  
  public ahih(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean anj()
  {
    super.anj();
    long l = this.bf.getLong("FORWARD_MSG_UNISEQ", -1L);
    Object localObject;
    if (l != -1L)
    {
      localObject = (ChatMessage)((ajcy)this.app.getManager(174)).fO.get(Long.valueOf(l));
      if (localObject == null) {
        break label175;
      }
      if (!(localObject instanceof MessageForMixedMsg)) {
        break label88;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForMixedMsg");
      }
      this.b = ((MessageForMixedMsg)localObject);
    }
    label175:
    for (;;)
    {
      return true;
      label88:
      if ((localObject instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForLongMsg");
        }
        localObject = (MessageForLongMsg)localObject;
        try
        {
          localObject = ((MessageForLongMsg)localObject).rebuildLongMsg();
          if (!(localObject instanceof MessageForMixedMsg)) {
            continue;
          }
          this.b = ((MessageForMixedMsg)localObject);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "rebuildLongMsg error :" + localException.toString());
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg: " + l);
          }
        }
      }
    }
  }
  
  public boolean ann()
  {
    return true;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
    localLinearLayout.setOrientation(0);
    Object localObject2 = new AnimationTextView(this.mActivity);
    ((AnimationTextView)localObject2).setText(new aofk(wn(), 5, 16));
    ((AnimationTextView)localObject2).setMaxLines(2);
    ((AnimationTextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject2).setTextColor(this.mActivity.getResources().getColorStateList(2131165857));
    ((AnimationTextView)localObject2).setTextSize(14.0F);
    Object localObject1 = new ImageView(this.mActivity);
    ((ImageView)localObject1).setImageResource(2130840498);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    localLinearLayout.addView((View)localObject2, localLayoutParams);
    localObject2 = new LinearLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(aqnm.dip2px(3.0F), 0, 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.mActivity);
    ((View)localObject1).setBackgroundResource(2130840508);
    ((View)localObject1).setOnClickListener(new ahii(this));
    localObject2 = new FrameLayout(this.mActivity);
    int i = aqnm.dip2px(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
  }
  
  public String wn()
  {
    if (this.b != null)
    {
      MessageForMixedMsg localMessageForMixedMsg = this.b;
      return MessageForMixedMsg.getTextFromMixedMsgForForwardPreview(this.b);
    }
    return super.wn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahih
 * JD-Core Version:    0.7.0.1
 */