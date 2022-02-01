package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import arrq;
import com.tencent.qphone.base.util.QLog;

public class OpenAuthorityFragment$8$6
  implements Runnable
{
  public OpenAuthorityFragment$8$6(arrq paramarrq) {}
  
  public void run()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "--> handler message UPDATE_DROP_DOWN_VIEWS");
    OpenAuthorityFragment.a(this.a.this$0).a.ekK();
    this.a.this$0.getActivity().runOnUiThread(new OpenAuthorityFragment.8.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.6
 * JD-Core Version:    0.7.0.1
 */