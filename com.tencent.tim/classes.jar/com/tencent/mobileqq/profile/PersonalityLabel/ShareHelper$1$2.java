package com.tencent.mobileqq.profile.PersonalityLabel;

import alcf;
import alcg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ShareHelper$1$2
  implements Runnable
{
  public ShareHelper$1$2(alcg paramalcg) {}
  
  public void run()
  {
    String str = alcf.a(this.a.b);
    ThreadManager.getUIHandler().post(new ShareHelper.1.2.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2
 * JD-Core Version:    0.7.0.1
 */