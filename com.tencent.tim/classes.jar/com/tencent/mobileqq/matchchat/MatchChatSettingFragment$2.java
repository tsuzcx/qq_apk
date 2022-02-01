package com.tencent.mobileqq.matchchat;

import afsi;
import afwy;
import aizy;
import alur;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    anot.a(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    aizy.dq(MatchChatSettingFragment.a(this.this$0));
    afwy.cR(MatchChatSettingFragment.a(this.this$0));
    ((afsi)MatchChatSettingFragment.a(this.this$0).getManager(264)).dbR();
    ((alur)MatchChatSettingFragment.a(this.this$0).getManager(285)).dJO();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */