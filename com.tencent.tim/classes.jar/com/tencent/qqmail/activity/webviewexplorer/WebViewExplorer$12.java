package com.tencent.qqmail.activity.webviewexplorer;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMWebView;
import org.apache.commons.lang3.StringUtils;

class WebViewExplorer$12
  extends QMListPopupWindow
{
  WebViewExplorer$12(WebViewExplorer paramWebViewExplorer, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = paramView.getId();
    if (paramInt == 2131378189) {
      this.this$0.forward();
    }
    do
    {
      return;
      if (paramInt == 2131378187)
      {
        this.this$0.saveToNote();
        return;
      }
      if (paramInt == 2131378190) {
        try
        {
          this.this$0.openBrowser();
          DataCollector.logEvent("Event_Open_Browser_By_Click_Actionsheet");
          return;
        }
        catch (Exception paramAdapterView)
        {
          QMUIHelper.showToast(this.this$0, 2131696372, "");
          return;
        }
      }
      if (paramInt == 2131378188)
      {
        paramAdapterView = this.this$0.mWebView.getUrl();
        if (!StringUtils.isEmpty(paramAdapterView))
        {
          if (paramAdapterView.endsWith(this.this$0.webViewSafeJmpUrlPath)) {}
          for (paramAdapterView = WebViewExplorer.access$800(this.this$0, paramAdapterView);; paramAdapterView = this.this$0.mWebView.getUrl())
          {
            WebViewExplorer.access$900(this.this$0, paramAdapterView);
            WebViewExplorer.access$1000(this.this$0, this.this$0.getString(2131692337));
            return;
          }
        }
        WebViewExplorer.access$1000(this.this$0, this.this$0.getString(2131692336));
        return;
      }
    } while (paramInt != 2131378192);
    this.this$0.showShareToDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.12
 * JD-Core Version:    0.7.0.1
 */