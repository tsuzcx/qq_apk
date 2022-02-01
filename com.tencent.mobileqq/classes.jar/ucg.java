import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.21.1;
import com.tencent.nativevue.NativeVueEngine.DomResult;

public class ucg
  implements NativeVueEngine.DomResult
{
  public ucg(ViolaBaseView paramViolaBaseView) {}
  
  public void onResult(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ViolaBaseView.b(this.a, paramString);
      return;
    }
    this.a.post(new ViolaBaseView.21.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucg
 * JD-Core Version:    0.7.0.1
 */