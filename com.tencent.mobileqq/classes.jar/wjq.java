import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wjq
  implements AdapterView.OnItemClickListener
{
  wjq(wjp paramwjp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (wjp.a(this.a).getActionSheet().isShowing()) {
      wjp.a(this.a).getActionSheet().dismiss();
    }
    int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag()).sheetItem.action;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.getInstance().isWXinstalled()) {
        i = 2131719722;
      }
    }
    for (;;)
    {
      if (i != -1) {
        yyi.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.getInstance().isWXsupportApi()) {
          break label123;
        }
        i = 2131719723;
        break;
        this.a.a(j);
      }
      label123:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjq
 * JD-Core Version:    0.7.0.1
 */