import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.ISong;

public class ainq
  implements aipq
{
  public ainq(ListenTogetherManager paramListenTogetherManager) {}
  
  public void b(ISong paramISong)
  {
    if (paramISong != null)
    {
      ListenTogetherManager.a(this.this$0, paramISong);
      this.this$0.LO(paramISong.getId());
      String str = (String)ListenTogetherManager.a(this.this$0).get(paramISong.getId());
      if (!TextUtils.isEmpty(str)) {
        ListenTogetherManager.a(this.this$0, paramISong.getId(), str);
      }
    }
    else
    {
      return;
    }
    ListenTogetherManager.a(this.this$0, paramISong.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainq
 * JD-Core Version:    0.7.0.1
 */