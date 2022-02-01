import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.20.1;
import com.tencent.nativevue.NativeVueEngine.DomResult;

public class tjh
  implements NativeVueEngine.DomResult
{
  public tjh(ViolaBaseView paramViolaBaseView) {}
  
  public void onResult(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ViolaBaseView.b(this.a, paramString);
      return;
    }
    this.a.post(new ViolaBaseView.20.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjh
 * JD-Core Version:    0.7.0.1
 */