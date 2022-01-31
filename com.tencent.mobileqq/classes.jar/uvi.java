import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class uvi
  implements FileManagerUtil.TipsClickedInterface
{
  public uvi(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = DialogUtil.a(this.a.a, 230);
    paramView.setTitle(2131437810);
    paramView.setMessage(2131437828);
    paramView.setNegativeButton(2131432998, new uvj(this, paramView));
    paramView.setPositiveButton(2131432999, new uvk(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvi
 * JD-Core Version:    0.7.0.1
 */