import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import mqq.os.MqqHandler;

public class awxu
  implements axcc.b
{
  awxu(awxq paramawxq) {}
  
  public void a(axbu paramaxbu, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.3(this, paramaxbu, paramInt));
  }
  
  public void a(axbu paramaxbu, boolean paramBoolean)
  {
    if ((!paramBoolean) || (awxq.a(this.this$0) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.1(this, paramaxbu));
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      sqn.n("record_decoration_download", sqn.a(i, System.currentTimeMillis() - paramaxbu.startDownloadTime, paramaxbu.resurl, paramaxbu.totalLen, paramaxbu.id));
      return;
      if (this.this$0.a(awxq.a(this.this$0).getCurrentItem()) == awxq.a(this.this$0)) {
        awxq.a(this.this$0, awxq.a(this.this$0));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.2(this, paramaxbu));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxu
 * JD-Core Version:    0.7.0.1
 */