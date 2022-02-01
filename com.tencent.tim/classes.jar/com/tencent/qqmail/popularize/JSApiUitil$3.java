package com.tencent.qqmail.popularize;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.popularize.model.PopularizeMoreOperation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import java.util.ArrayList;

final class JSApiUitil$3
  extends QMListPopupWindow
{
  JSApiUitil$3(Context paramContext, View paramView, ListAdapter paramListAdapter, ArrayList paramArrayList, String paramString)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PopularizeMoreOperation localPopularizeMoreOperation = (PopularizeMoreOperation)this.val$popularizeMoreOperations.get(paramInt);
    if (localPopularizeMoreOperation != null)
    {
      if (localPopularizeMoreOperation.getOperation() == 1)
      {
        QMLog.log(2, "JSApiUitil", "WECAHT_TIMELINE: " + localPopularizeMoreOperation.getImageUrl());
        if ((localPopularizeMoreOperation.getImageUrl() != null) && (!localPopularizeMoreOperation.getImageUrl().equals(""))) {
          PopularizeThumbManager.sharedInstance().loadPopularizeThumbWithCallBack(localPopularizeMoreOperation.getImageUrl(), new JSApiUitil.3.1(this, localPopularizeMoreOperation));
        }
      }
      else if (localPopularizeMoreOperation.getOperation() == 2)
      {
        if ((localPopularizeMoreOperation.getImageUrl() == null) || (localPopularizeMoreOperation.getImageUrl().equals(""))) {
          break label340;
        }
        PopularizeThumbManager.sharedInstance().loadPopularizeThumbWithCallBack(localPopularizeMoreOperation.getImageUrl(), new JSApiUitil.3.2(this, localPopularizeMoreOperation));
      }
      for (;;)
      {
        if (localPopularizeMoreOperation.getOperation() == 5)
        {
          paramAdapterView = AccountManager.shareInstance().getAccountList().get(0);
          paramView = localPopularizeMoreOperation.getType();
          if ((paramAdapterView != null) && (paramView != null))
          {
            String str = localPopularizeMoreOperation.getContent();
            JSApiUitil.access$600(paramView, this.val$orginalUrl, str, new JSApiUitil.3.3(this, paramAdapterView));
          }
        }
        if (localPopularizeMoreOperation.getOperation() == 4)
        {
          paramView = localPopularizeMoreOperation.getUrl();
          if (paramView != null)
          {
            paramAdapterView = paramView;
            if (!paramView.equals("")) {}
          }
          else
          {
            paramAdapterView = this.val$orginalUrl;
          }
          JSApiUitil.access$700(this.context, paramAdapterView);
          DataCollector.logEvent("Event_Ad_Webview_ActionSheet_OpenLink");
        }
        if (localPopularizeMoreOperation.getOperation() == 3)
        {
          paramView = localPopularizeMoreOperation.getUrl();
          if (paramView != null)
          {
            paramAdapterView = paramView;
            if (!paramView.equals("")) {}
          }
          else
          {
            paramAdapterView = this.val$orginalUrl;
          }
          JSApiUitil.access$800(this.context, paramAdapterView);
          DataCollector.logEvent("Event_Ad_Webview_ActionSheet_CopyLink");
        }
        return;
        JSApiUitil.access$000(this.context, 1, localPopularizeMoreOperation.getUrl(), localPopularizeMoreOperation.getTitle(), localPopularizeMoreOperation.getAbstracts(), localPopularizeMoreOperation.getImageUrl(), 4);
        break;
        label340:
        JSApiUitil.access$000(this.context, 0, localPopularizeMoreOperation.getUrl(), localPopularizeMoreOperation.getTitle(), localPopularizeMoreOperation.getAbstracts(), localPopularizeMoreOperation.getImageUrl(), 4);
      }
    }
    QMLog.log(6, "JSApiUitil", "PopularizeMoreOperation null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.3
 * JD-Core Version:    0.7.0.1
 */