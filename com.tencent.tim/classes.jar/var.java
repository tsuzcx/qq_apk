import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class var
  implements OnCompositionLoadedListener
{
  public var(FriendProfileCardActivity.ColorScreenLoader paramColorScreenLoader) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null)) {
      QLog.d("ColorScreenManager", 1, "onCompositionLoaded: composition= " + paramLottieComposition);
    }
    if (paramLottieComposition == null)
    {
      aqri.a(this.b.this$0.app, "individual_v2_colorscreen_parse_fail", "0", "", Integer.toString(this.b.bHg), null, null, 0.0F, 0.0F);
      aqrh.is("individual_v2_colorscreen_parse_fail", "id:" + this.b.bHg);
      return;
    }
    this.b.b = paramLottieComposition;
    this.b.this$0.b.postDelayed(this.b, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     var
 * JD-Core Version:    0.7.0.1
 */