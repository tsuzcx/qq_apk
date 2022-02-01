package com.tencent.mobileqq.structmsg.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import anun;
import anun.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import wja;
import wko.a;

public class StructMsgItemPAAudio$3
  implements Runnable
{
  public StructMsgItemPAAudio$3(anun paramanun, View paramView, anun.a parama) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = this.val$v.getParent();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (((ViewGroup)localObject2).getId() != 2131378856) {
          break label64;
        }
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131378856);
      }
    }
    if (localObject2 == null) {}
    label64:
    do
    {
      do
      {
        return;
        localObject1 = ((ViewGroup)localObject2).getParent();
        break;
        this.this$0.ez = ((ViewGroup)localObject1);
      } while (this.this$0.ez == null);
      localObject1 = (wko.a)wja.a(this.this$0.ez);
    } while (localObject1 == null);
    long l = ((wko.a)localObject1).mMessage.uniseq;
    this.this$0.mPeerUin = ((StructMsgForGeneralShare)localObject2).uin;
    this.this$0.isPlaying = this.this$0.cK(l);
    if (!this.this$0.isPlaying)
    {
      this.a.Hy.setBackgroundResource(2130842633);
      return;
    }
    this.a.Hy.setBackgroundResource(2130772190);
    ((AnimationDrawable)this.a.Hy.getBackground()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3
 * JD-Core Version:    0.7.0.1
 */