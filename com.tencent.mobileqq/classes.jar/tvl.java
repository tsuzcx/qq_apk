import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView;
import com.tencent.viola.ui.view.lottie.IVLottieViewProxy;
import com.tencent.viola.ui.view.lottie.IVlottieViewCreater;

public class tvl
  implements IVlottieViewCreater
{
  public IVLottieViewProxy createLottieView(Context paramContext)
  {
    return new KdLottieView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvl
 * JD-Core Version:    0.7.0.1
 */