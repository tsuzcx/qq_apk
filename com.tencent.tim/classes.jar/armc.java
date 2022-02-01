import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class armc
  implements AdapterView.OnItemClickListener
{
  public armc(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ShareActionSheetBuilder.b))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    localObject = ((ShareActionSheetBuilder.b)localObject).b;
    if (ShareActionSheetV2.a(this.this$0) != null) {
      ShareActionSheetV2.a(this.this$0).onItemClick((ShareActionSheetBuilder.ActionSheetItem)localObject, this.this$0);
    }
    ShareActionSheetV2 localShareActionSheetV2 = this.this$0;
    int i;
    if (paramAdapterView == this.this$0.p) {
      i = 0;
    }
    for (;;)
    {
      ShareActionSheetV2.a(localShareActionSheetV2, (ShareActionSheetBuilder.ActionSheetItem)localObject, i);
      break;
      if (paramAdapterView == this.this$0.n) {
        i = 1;
      } else if (paramAdapterView == this.this$0.o) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armc
 * JD-Core Version:    0.7.0.1
 */