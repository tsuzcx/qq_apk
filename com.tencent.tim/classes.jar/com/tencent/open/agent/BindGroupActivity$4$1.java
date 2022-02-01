package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import aqha;
import aqju;
import arpr;
import arps;

public class BindGroupActivity$4$1
  implements Runnable
{
  public BindGroupActivity$4$1(arpr paramarpr) {}
  
  public void run()
  {
    if (this.a.this$0.x != null) {
      if (!this.a.this$0.x.isShowing()) {
        this.a.this$0.x.show();
      }
    }
    do
    {
      return;
      this.a.this$0.x = aqha.a(this.a.this$0, 230);
      this.a.this$0.x.setMessage(this.a.this$0.getActivity().getResources().getString(2131721368));
      arps localarps = new arps(this);
      this.a.this$0.x.setPositiveButton(2131691970, localarps);
    } while (this.a.this$0.x.isShowing());
    this.a.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */