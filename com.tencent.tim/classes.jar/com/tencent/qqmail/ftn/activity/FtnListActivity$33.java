package com.tencent.qqmail.ftn.activity;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqmail.attachment.util.QQBrowserUtil;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import org.apache.commons.lang3.StringUtils;

class FtnListActivity$33
  extends QMListPopupWindow
{
  FtnListActivity$33(FtnListActivity paramFtnListActivity, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691239))) {
      FtnListActivity.access$5800(this.this$0);
    }
    do
    {
      return;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691491)))
      {
        QMAlbumManager.shareInstance().startAlbum(this.this$0, QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN);
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131693505)));
    if (QQBrowserUtil.isQqBrowserSupport(this.this$0.getActivity()))
    {
      paramAdapterView = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
      paramAdapterView.addItem(2130840923, this.this$0.getString(2131720712), this.this$0.getString(2131720712));
      paramAdapterView.addItem(2130845839, this.this$0.getString(2131701863), this.this$0.getString(2131701863));
      paramAdapterView.setOnSheetItemClickListener(new FtnListActivity.33.1(this));
      paramAdapterView.build().show();
      return;
    }
    FtnListActivity.access$6000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.33
 * JD-Core Version:    0.7.0.1
 */