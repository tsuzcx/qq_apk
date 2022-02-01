package com.tencent.qqmail.activity.webviewexplorer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMWebView;

class BasicWebViewExplorer$4
  extends QMListPopupWindow
{
  BasicWebViewExplorer$4(BasicWebViewExplorer paramBasicWebViewExplorer, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = paramView.getId();
    if (paramInt == 2131378190) {}
    while (paramInt != 2131378188) {
      try
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(this.this$0.webView.getUrl()));
        this.this$0.startActivity(paramAdapterView);
        return;
      }
      catch (Exception paramAdapterView)
      {
        QMUIHelper.showToast(this.this$0, 2131696372, "");
        return;
      }
    }
    CommUtils.copyText(this.this$0.url);
    QMUIHelper.showToast(this.this$0, 2131692337, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.BasicWebViewExplorer.4
 * JD-Core Version:    0.7.0.1
 */