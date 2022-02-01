import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qdq
  implements AdapterView.OnItemClickListener
{
  qdq(qdp paramqdp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (qdp.a(this.a).getActionSheet().isShowing()) {
      qdp.a(this.a).getActionSheet().dismiss();
    }
    int j = ((ShareActionSheetBuilder.b)paramView.getTag()).b.action;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
    }
    for (;;)
    {
      if (i != -1) {
        rwt.ez(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().isWXsupportApi()) {
          break label123;
        }
        i = 2131721936;
        break;
        this.a.vU(j);
      }
      label123:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdq
 * JD-Core Version:    0.7.0.1
 */