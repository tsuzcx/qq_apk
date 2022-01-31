import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class vdl
  implements FileManagerUtil.TipsClickedInterface
{
  public vdl(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = DialogUtil.a(this.a.a, 230);
    paramView.setTitle(2131437847);
    paramView.setMessage(2131437865);
    paramView.setNegativeButton(2131433029, new vdm(this, paramView));
    paramView.setPositiveButton(2131433030, new vdn(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdl
 * JD-Core Version:    0.7.0.1
 */