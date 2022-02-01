package com.tencent.qqmail.attachment.activity;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import org.apache.commons.lang3.StringUtils;

class AttachImagePagerActivity$4
  extends QMListPopupWindow
{
  AttachImagePagerActivity$4(AttachImagePagerActivity paramAttachImagePagerActivity, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (StringUtils.equalsIgnoreCase(((TextView)paramView.findViewById(2131373495)).getText().toString(), this.this$0.getString(2131690567))) {
      AttachImagePagerActivity.access$200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.4
 * JD-Core Version:    0.7.0.1
 */