import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;

public class acyq
  implements ArkViewImplement.LoadCallback
{
  public acyq(QQDailyArkView paramQQDailyArkView) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (paramInt != 1) {
      QQDailyArkView.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyq
 * JD-Core Version:    0.7.0.1
 */