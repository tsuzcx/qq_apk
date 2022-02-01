package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import wkn;
import zng;

public class ChatItemAnimLayout
  extends RelativeLayout
  implements zng
{
  public long HN = -1L;
  public a a;
  int bOW;
  int bOX = 255;
  protected boolean bdJ;
  protected boolean bdK;
  public ChatMessage i;
  private Handler mHandler = new wkn(this);
  float pA = 0.0F;
  float pB = 0.0F;
  public float py = 1.0F;
  public float pz = 1.0F;
  
  public ChatItemAnimLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean j(ChatMessage paramChatMessage)
  {
    if (this.i == null) {}
    do
    {
      return false;
      if (paramChatMessage == null) {
        return true;
      }
    } while ((this.i != paramChatMessage) && ((paramChatMessage.msgseq == 0L) || (this.i.msgseq != paramChatMessage.msgseq)) && ((paramChatMessage.msgUid == 0L) || (this.i.msgUid != paramChatMessage.msgUid)) && ((paramChatMessage.uniseq == 0L) || (this.i.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  public void a(ChatMessage paramChatMessage, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, a parama)
  {
    if (j(paramChatMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "startAnim isTheSameMsg");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemAnimLayout", 2, "startAnim");
    }
    this.i = paramChatMessage;
    this.a = parama;
    this.HN = System.currentTimeMillis();
    this.pA = paramFloat1;
    this.pB = paramFloat2;
    this.bOW = ((int)(paramFloat3 * 255.0F));
    this.bOX = ((int)(paramFloat4 * 255.0F));
    this.py = 0.0F;
    this.pz = 0.0F;
    paramChatMessage = this.mHandler.obtainMessage(0);
    this.mHandler.sendMessageDelayed(paramChatMessage, 0L);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    float f1 = this.pB;
    float f2 = this.pA;
    float f3 = this.py;
    float f4 = this.pA;
    setAlpha(((this.bOX - this.bOW) * this.pz + this.bOW) / 255.0F);
    paramCanvas.translate((f1 - f2) * f3 + f4, 0.0F);
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  public void r(ChatMessage paramChatMessage)
  {
    if ((this.i != null) && (this.i != paramChatMessage))
    {
      this.pB = 0.0F;
      this.bOX = 255;
      Message localMessage = this.mHandler.obtainMessage(2);
      this.mHandler.sendMessage(localMessage);
      this.i = paramChatMessage;
    }
  }
  
  public void setFrom(boolean paramBoolean)
  {
    this.bdK = paramBoolean;
  }
  
  public void setIsShieldTouchForItem(boolean paramBoolean)
  {
    this.bdJ = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void o(ChatMessage paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemAnimLayout
 * JD-Core Version:    0.7.0.1
 */