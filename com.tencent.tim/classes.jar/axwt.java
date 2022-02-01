import android.os.Message;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.a;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;

public class axwt
  implements GetSingleFullMusicInfoTask.a
{
  public axwt(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void m(boolean paramBoolean, Object paramObject)
  {
    Message localMessage;
    if (this.this$0.b != null)
    {
      localMessage = this.this$0.b.obtainMessage();
      if (!paramBoolean) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramObject;
      localMessage.what = 7;
      this.this$0.b.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwt
 * JD-Core Version:    0.7.0.1
 */