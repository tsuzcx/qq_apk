package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment;
import com.tencent.qqmail.activity.webviewexplorer.PopularizeWebViewExplorer;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.nativepages.NativePagesActivity;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper.PopularizeActionDelegate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.schema.SchemaUtil;

class AggregateMailListFragment$17
  implements PopularizeUIHelper.PopularizeActionDelegate
{
  AggregateMailListFragment$17(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public boolean onAction(Popularize paramPopularize)
  {
    int i = paramPopularize.getAction();
    int j = PopularizeUIHelper.getAnimationTypeByPopularize(paramPopularize.getType());
    String str = paramPopularize.getOpenUrl();
    if (paramPopularize.getType() == 9)
    {
      DataCollector.logEvent("Event_AD_Mail_Click");
      NativeAdsHelper.getInstance().log(paramPopularize.getServerId(), "Event_AD_Mail_Click");
      if ((paramPopularize.getAdXml() != null) && (!paramPopularize.getAdXml().equals("")))
      {
        paramPopularize = NativePagesActivity.createIntent(paramPopularize.getAdXml(), "adxml", paramPopularize.getId());
        this.this$0.startActivity(paramPopularize);
      }
    }
    do
    {
      return true;
      paramPopularize = new ReadVirtualAdsMailFragment(paramPopularize);
      this.this$0.startFragment(paramPopularize);
      return true;
      if (i != 1) {
        break;
      }
      if ((str != null) && (str.startsWith("qqmail://")))
      {
        SchemaUtil.handleSchemaAction(this.this$0.getActivity(), str, j, 2);
        return true;
      }
    } while ((str == null) || ((!str.startsWith("http://")) && (!str.startsWith("https://"))));
    paramPopularize = PopularizeWebViewExplorer.createIntent(str, paramPopularize.getId(), j);
    this.this$0.startActivity(paramPopularize);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.17
 * JD-Core Version:    0.7.0.1
 */