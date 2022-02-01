import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

class ryd
  implements Observer<Object>
{
  ryd(ryc paramryc) {}
  
  public void onChanged(@Nullable Object paramObject)
  {
    if (ryc.a(this.a) != null) {
      ryc.a(this.a).setData(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryd
 * JD-Core Version:    0.7.0.1
 */