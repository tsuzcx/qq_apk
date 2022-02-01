import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajan
  implements AdapterView.OnItemClickListener
{
  ajan(ajam paramajam) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.b.mShareActionSheet.getActionSheet().isShowing()) {
      this.b.mShareActionSheet.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
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
          break label175;
        }
        i = 2131721936;
        break;
        switch ((int)paramLong)
        {
        default: 
          break;
        case 0: 
          ajam.a(this.b);
          break;
        case 1: 
          ajam.b(this.b);
          break;
        case 2: 
          ajam.c(this.b);
          break;
        case 3: 
          ajam.d(this.b);
        }
      }
      label175:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajan
 * JD-Core Version:    0.7.0.1
 */