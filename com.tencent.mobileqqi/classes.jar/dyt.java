import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class dyt
  implements FileManagerUtil.TipsClickedInterface
{
  public dyt(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    FileManagerUtil.b((Activity)GrayTipsItemBuilder.b(this.a), GrayTipsItemBuilder.c(this.a).a(), GrayTipsItemBuilder.c(this.a).a, GrayTipsItemBuilder.d(this.a).d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyt
 * JD-Core Version:    0.7.0.1
 */