package com.tencent.qqmail.attachment.activity;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import org.apache.commons.lang3.StringUtils;

class WebViewPreviewActivity$4
  extends QMListPopupWindow
{
  WebViewPreviewActivity$4(WebViewPreviewActivity paramWebViewPreviewActivity, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690558)))
    {
      WebViewPreviewActivity.access$100(this.this$0);
      DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
    }
    do
    {
      return;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690550)))
      {
        WebViewPreviewActivity.access$200(this.this$0);
        DataCollector.logEvent("Event_Attach_Send_Email_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690532)))
      {
        WebViewPreviewActivity.access$300(this.this$0, true);
        DataCollector.logEvent("Event_Attach_Preview_AddFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690535)))
      {
        WebViewPreviewActivity.access$300(this.this$0, false);
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690586)))
      {
        WebViewPreviewActivity.access$400(this.this$0);
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690582)));
    WebViewPreviewActivity.access$500(this.this$0);
    DataCollector.logEvent("Event_Click_SaveAs_From_AttachDetail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.WebViewPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */