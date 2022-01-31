import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class uzp
  implements FileManagerUtil.TipsClickedInterface
{
  public uzp(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = FMConfig.a();
    FileManagerUtil.a(this.a.a, paramView);
    FileManagerReporter.a("0X8007FA2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzp
 * JD-Core Version:    0.7.0.1
 */