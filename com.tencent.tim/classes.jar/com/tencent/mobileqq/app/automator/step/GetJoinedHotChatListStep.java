package com.tencent.mobileqq.app.automator.step;

import acfv;
import acgf;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private acgf c;
  
  public int od()
  {
    if (!HotChatManager.ae(this.a.app)) {
      return 7;
    }
    acfv localacfv = (acfv)this.a.app.getBusinessHandler(35);
    this.c = new a(null);
    this.a.app.addObserver(this.c);
    localacfv.cJk();
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.c != null)
    {
      this.a.app.removeObserver(this.c);
      this.c = null;
    }
  }
  
  class a
    extends acgf
  {
    private a() {}
    
    public void Jg(int paramInt)
    {
      if (GetJoinedHotChatListStep.a(GetJoinedHotChatListStep.this) != null)
      {
        GetJoinedHotChatListStep.this.a.app.removeObserver(GetJoinedHotChatListStep.a(GetJoinedHotChatListStep.this));
        GetJoinedHotChatListStep.a(GetJoinedHotChatListStep.this, null);
      }
      if (paramInt == 0)
      {
        GetJoinedHotChatListStep.this.setResult(7);
        return;
      }
      GetJoinedHotChatListStep.this.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */