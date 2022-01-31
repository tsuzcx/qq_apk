import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class uyk
  implements FileManagerUtil.TipsClickedInterface
{
  public uyk(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = DialogUtil.a(this.a.a, 230);
    paramView.setTitle(2131437827);
    paramView.setMessage(2131437845);
    paramView.setNegativeButton(2131433015, new uyl(this, paramView));
    paramView.setPositiveButton(2131433016, new uym(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyk
 * JD-Core Version:    0.7.0.1
 */