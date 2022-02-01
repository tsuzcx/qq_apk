package com.tencent.open.agent;

import arpb;
import com.tencent.qphone.base.util.QLog;

public class AuthorityActivity$8$7
  implements Runnable
{
  public AuthorityActivity$8$7(arpb paramarpb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--> handler message UPDATE_DROP_DOWN_VIEWS");
    }
    this.a.this$0.a.a.ekK();
    this.a.this$0.runOnUiThread(new AuthorityActivity.8.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.7
 * JD-Core Version:    0.7.0.1
 */