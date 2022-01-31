import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class fqa
  implements View.OnClickListener
{
  public fqa(FMActivity paramFMActivity) {}
  
  public void onClick(View paramView)
  {
    RecentFileAdapter.ItemHolder localItemHolder = (RecentFileAdapter.ItemHolder)paramView.getTag();
    if (localItemHolder.a.cloudType == 5)
    {
      FileManagerUtil.a(this.a.b, this.a, localItemHolder.a);
      return;
    }
    String str;
    if ((localItemHolder.a.nOpType == 1) || (localItemHolder.a.nOpType == 5) || (localItemHolder.a.nOpType == 8)) {
      str = this.a.getString(2131558690);
    }
    for (paramView = this.a.getString(2131558688);; paramView = this.a.getString(2131558687))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
      localActionSheet.c(str);
      localActionSheet.d(this.a.getString(2131561746));
      localActionSheet.a(paramView);
      localActionSheet.a(new fqb(this, localItemHolder, localActionSheet));
      localActionSheet.show();
      return;
      str = this.a.getString(2131558689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqa
 * JD-Core Version:    0.7.0.1
 */