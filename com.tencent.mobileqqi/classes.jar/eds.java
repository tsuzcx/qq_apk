import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class eds
  implements FileManagerUtil.TipsClickedInterface
{
  public eds(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    FileManagerUtil.a(GrayTipsItemBuilder.a(this.a).a(), 3);
    FileManagerUtil.a((Activity)GrayTipsItemBuilder.a(this.a), GrayTipsItemBuilder.b(this.a).a(), GrayTipsItemBuilder.a(this.a).a, GrayTipsItemBuilder.b(this.a).d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eds
 * JD-Core Version:    0.7.0.1
 */