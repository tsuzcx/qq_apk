package com.tencent.mobileqq.activity.contact.connections;

import achg;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yri;

class ConnectsExplorationFriendAdapter$7$1
  implements Runnable
{
  ConnectsExplorationFriendAdapter$7$1(ConnectsExplorationFriendAdapter.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.rh != null) && (this.rh.size() > 0))
    {
      this.a.this$0.gJ(this.rh);
      yri.a(this.a.this$0).setVisibility(8);
      yri.b(this.a.this$0).setVisibility(8);
    }
    do
    {
      return;
      if ((this.a.bos) && (!yri.a(this.a.this$0)))
      {
        yri.a(this.a.this$0, true);
        yri.b(this.a.this$0).setVisibility(0);
        yri.a(this.a.this$0).setVisibility(8);
        Bundle localBundle = new Bundle();
        localBundle.putString("from", "4");
        yri.a(this.a.this$0).a(5, yri.a(this.a.this$0), localBundle);
        return;
      }
      yri.a(this.a.this$0).setVisibility(0);
      yri.a(this.a.this$0).setText(2131701424);
      yri.c(this.a.this$0).setVisibility(8);
      yri.b(this.a.this$0).setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData empty " + yri.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7.1
 * JD-Core Version:    0.7.0.1
 */