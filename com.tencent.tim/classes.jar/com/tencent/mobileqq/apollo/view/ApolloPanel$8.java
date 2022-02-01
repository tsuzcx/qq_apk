package com.tencent.mobileqq.apollo.view;

import acbf;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$8
  implements Runnable
{
  ApolloPanel$8(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.il != null) && (this.this$0.r != null))
    {
      this.this$0.a.iB(this.xb);
      if (this.this$0.g == null) {
        break label148;
      }
      if (this.this$0.g.cZ != 1036) {
        break label143;
      }
      i = 1;
      if ((!ApolloPanel.a(this.this$0)) && (i == 0)) {
        break label153;
      }
      this.this$0.il.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.r.setVisibility(0);
      this.this$0.a.notifyDataSetChanged();
      if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.sessionInfo != null)) {
        break label167;
      }
      return;
      label143:
      i = 0;
      break;
      label148:
      i = 0;
      break;
      label153:
      this.this$0.il.setVisibility(0);
    }
    label167:
    Iterator localIterator = this.xb.iterator();
    label177:
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate)) {
        if (this.this$0.mBaseChatPie.sessionInfo.cZ != 3000) {
          break label257;
        }
      }
    }
    label257:
    for (int i = 2;; i = this.this$0.mBaseChatPie.sessionInfo.cZ)
    {
      VipUtils.a(null, "cmshow", "Apollo", "tabreddot", i, 0, new String[] { String.valueOf(localApolloActionPackage.packageId) });
      break label177;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.8
 * JD-Core Version:    0.7.0.1
 */