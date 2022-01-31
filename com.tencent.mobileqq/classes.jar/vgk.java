import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class vgk
  implements AdapterView.OnItemClickListener
{
  vgk(vgj paramvgj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (vgj.a(this.a).getActionSheet().isShowing()) {
      vgj.a(this.a).getActionSheet().dismiss();
    }
    int i = ((bdip)paramView.getTag()).a.action;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131721478;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        xxb.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131721479;
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
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */