package com.tencent.qqmail.calendar.fragment;

import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.uitableview.UITableItemTextView;
import java.util.HashMap;
import java.util.List;

class ModifyScheduleFragment$8
  implements AdapterView.OnItemClickListener
{
  ModifyScheduleFragment$8(ModifyScheduleFragment paramModifyScheduleFragment, ModifyScheduleFragment.MyAdapter paramMyAdapter, QMBottomDialog paramQMBottomDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((HashMap)ModifyScheduleFragment.access$1200(this.this$0).get(paramInt)).get("folder");
    if ((ModifyScheduleFragment.access$100(this.this$0) != null) && (localQMCalendarFolder != null))
    {
      ModifyScheduleFragment.access$100(this.this$0).setAccountId(localQMCalendarFolder.getAccountId());
      ModifyScheduleFragment.access$100(this.this$0).setCalderFolderId(localQMCalendarFolder.getId());
      ModifyScheduleFragment.access$100(this.this$0).setCategory(localQMCalendarFolder.getCategory());
    }
    if (localQMCalendarFolder != null)
    {
      Drawable localDrawable = DrawBitmapUtil.drawCircle(this.this$0.getActivity(), QMUIHelper.getCalendarColor(this.this$0.getActivity(), localQMCalendarFolder), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
      ModifyScheduleFragment.access$1400(this.this$0).setTextWithGrayStyle(ModifyScheduleFragment.access$1300(this.this$0, localQMCalendarFolder));
      ModifyScheduleFragment.access$1400(this.this$0).getDetailView().setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ModifyScheduleFragment.access$1400(this.this$0).getDetailView().setCompoundDrawables(localDrawable, null, null, null);
      ModifyScheduleFragment.access$1400(this.this$0).getDetailView().setCompoundDrawablePadding(10);
      this.val$adapter.notifyDataSetChanged();
    }
    this.val$dialog.dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.8
 * JD-Core Version:    0.7.0.1
 */