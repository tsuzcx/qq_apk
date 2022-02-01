import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

class zyo
  implements Observer<Object>
{
  zyo(zyn paramzyn) {}
  
  public void onChanged(@Nullable Object paramObject)
  {
    if (zyn.a(this.a) != null) {
      zyn.a(this.a).setData(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyo
 * JD-Core Version:    0.7.0.1
 */