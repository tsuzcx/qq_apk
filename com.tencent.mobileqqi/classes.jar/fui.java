import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter.ViewHolder;
import com.tencent.mobileqq.filemanager.data.OfflineFileAdapter.CloudFileItemHolder;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileAdapter.WeiYunFileItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class fui
  implements View.OnLongClickListener
{
  public fui(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    String str;
    if (this.a.a == 9L) {
      str = ((OfflineFileAdapter.CloudFileItemHolder)paramView.getTag()).a.b;
    }
    for (;;)
    {
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      localQQCustomMenu.a(2131230986, paramView.getContext().getString(2131561917));
      CloudFileBrowserActivity.a(this.a, BubbleContextMenu.a(paramView, localQQCustomMenu, new fuj(this, paramView), str));
      return true;
      if (this.a.a == 10L) {
        str = ((ImageFileAdapter.ViewHolder)paramView.getTag()).a.b;
      } else {
        str = ((WeiYunFileAdapter.WeiYunFileItemHolder)paramView.getTag()).a.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fui
 * JD-Core Version:    0.7.0.1
 */