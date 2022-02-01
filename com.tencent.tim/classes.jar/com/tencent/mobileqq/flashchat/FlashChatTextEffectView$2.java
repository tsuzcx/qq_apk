package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;

final class FlashChatTextEffectView$2
  implements Runnable
{
  FlashChatTextEffectView$2(FlashChatTextEffectView.b paramb) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.h != null))
    {
      this.a.h.stopAnim();
      this.a.h.playAnim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.2
 * JD-Core Version:    0.7.0.1
 */