import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afyt
  implements OnCompositionLoadedListener
{
  public afyt(ExtendFriendVoiceView.1 param1, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int m = this.cVu;
    int k = this.cVv;
    int j = k;
    int i = m;
    if (ExtendFriendVoiceView.b(this.a.this$0) == 2)
    {
      i = (int)(m * 0.8F);
      j = (int)(k * 0.8F);
    }
    if (paramLottieComposition == null)
    {
      QLog.e("ExtendFriendVoiceView", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(true);
    ExtendFriendVoiceView.a(this.a.this$0, (LottieDrawable)localObject);
    ThreadManager.getUIHandler().post(new ExtendFriendVoiceView.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyt
 * JD-Core Version:    0.7.0.1
 */