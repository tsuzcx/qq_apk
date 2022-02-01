import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.ManageColumnPresenter.1.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.ManageColumnPresenter.1.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;

public class mnk
  implements mqk
{
  mnk(mnj parammnj, String paramString) {}
  
  public void N(float paramFloat) {}
  
  public void onFailed(int paramInt, @NotNull String paramString)
  {
    if (mnj.a(this.a) != null) {
      ThreadManagerV2.getUIHandlerV2().post(new ManageColumnPresenter.1.2(this));
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (mnj.a(this.a) != null) {
      ThreadManagerV2.getUIHandlerV2().post(new ManageColumnPresenter.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnk
 * JD-Core Version:    0.7.0.1
 */