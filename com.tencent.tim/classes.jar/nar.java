import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class nar
{
  private naf a;
  private oep b;
  private mvn c;
  private Activity mActivity;
  
  nar(Activity paramActivity, naf paramnaf)
  {
    this.mActivity = paramActivity;
    this.a = paramnaf;
    this.b = ((oep)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(126));
    this.c = new mvn(paramActivity, 1);
  }
  
  void V(VideoInfo paramVideoInfo)
  {
    int i = 0;
    boolean bool;
    if (!paramVideoInfo.adM)
    {
      bool = true;
      paramVideoInfo.adM = bool;
      if (!paramVideoInfo.adM) {
        break label53;
      }
      i = paramVideoInfo.aHi + 1;
    }
    for (;;)
    {
      paramVideoInfo.aHi = i;
      this.b.g(paramVideoInfo, paramVideoInfo.adM);
      return;
      bool = false;
      break;
      label53:
      if (paramVideoInfo.aHi > 0) {
        i = paramVideoInfo.aHi - 1;
      }
    }
  }
  
  void b(VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    if (!paramVideoInfo.adM) {
      V(paramVideoInfo);
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
      this.c.y(paramInt1, paramInt2);
    }
  }
  
  void onDestory()
  {
    this.c.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nar
 * JD-Core Version:    0.7.0.1
 */