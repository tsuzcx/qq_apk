package com.tencent.mobileqq.activity.contact.troop;

import ackn;
import aqfr;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import ywk;

class TroopNotifyAndRecommendView$17
  implements Runnable
{
  TroopNotifyAndRecommendView$17(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, List paramList) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      this.this$0.b.bpq = true;
      this.this$0.b.notifyDataSetChanged();
    }
    TroopNotifyAndRecommendView.b(this.this$0);
    Object localObject = (ackn)this.this$0.app.getManager(22);
    if ((this.in != null) && (this.in.size() > 0))
    {
      if (this.this$0.b != null)
      {
        this.this$0.b.gS(this.in);
        this.this$0.b.notifyDataSetChanged();
        this.this$0.tA = this.in;
      }
      if (!this.this$0.bpC)
      {
        aqfr.b("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
        this.this$0.bpC = true;
      }
    }
    for (;;)
    {
      this.this$0.cmK();
      if (!this.this$0.bix)
      {
        this.this$0.cmI();
        this.this$0.bix = true;
      }
      return;
      if (this.this$0.b != null)
      {
        localObject = new ArrayList();
        this.this$0.b.gS((List)localObject);
        this.this$0.b.notifyDataSetChanged();
        this.this$0.tA = ((List)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.17
 * JD-Core Version:    0.7.0.1
 */