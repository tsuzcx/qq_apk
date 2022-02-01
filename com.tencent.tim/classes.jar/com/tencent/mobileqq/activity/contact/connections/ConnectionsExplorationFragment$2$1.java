package com.tencent.mobileqq.activity.contact.connections;

import achg;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

class ConnectionsExplorationFragment$2$1
  implements Runnable
{
  ConnectionsExplorationFragment$2$1(ConnectionsExplorationFragment.2 param2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.rg != null) && (this.rg.size() > 0))
    {
      ConnectionsExplorationFragment.a(this.a.this$0).clear();
      ConnectionsExplorationFragment.a(this.a.this$0).addAll(this.rg);
      ConnectionsExplorationFragment.a(this.a.this$0);
      if (!this.a.boo)
      {
        if (ConnectionsExplorationFragment.a(this.a.this$0) != null) {
          ConnectionsExplorationFragment.a(this.a.this$0).dd(ConnectionsExplorationFragment.a(this.a.this$0));
        }
        ConnectionsExplorationFragment.a(this.a.this$0).setVisibility(0);
        ConnectionsExplorationFragment.a(this.a.this$0).setVisibility(8);
      }
    }
    do
    {
      return;
      ConnectionsExplorationFragment.a(this.a.this$0).setVisibility(8);
      ConnectionsExplorationFragment.a(this.a.this$0).setVisibility(0);
    } while (!this.a.bop);
    ConnectionsExplorationFragment.a(this.a.this$0).Jo(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.2.1
 * JD-Core Version:    0.7.0.1
 */