import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class fqn
  implements View.OnLongClickListener
{
  public fqn(FMActivity paramFMActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = ((RecentFileAdapter.ItemHolder)paramView.getTag()).a;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131230986, paramView.getContext().getString(2131561917));
    FMActivity.a(this.a, BubbleContextMenu.a(paramView, localQQCustomMenu, new fqo(this, paramView), localFileManagerEntity.fileName));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqn
 * JD-Core Version:    0.7.0.1
 */