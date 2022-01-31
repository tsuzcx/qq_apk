import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class vkt
  implements AdapterView.OnItemClickListener
{
  vkt(vks paramvks) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (vks.a(this.a).getActionSheet().isShowing()) {
      vks.a(this.a).getActionSheet().dismiss();
    }
    int i = ((bdmy)paramView.getTag()).a.action;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131721491;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        ybk.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131721492;
        }
      }
      else
      {
        this.a.a(i);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */