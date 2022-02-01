import android.util.Log;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.a;

class aixe
  implements LyricViewScroll.a
{
  aixe(aixd paramaixd) {}
  
  public void Qn(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.this$0.Qn(paramInt);
  }
  
  public void Qo(int paramInt)
  {
    this.this$0.mIsScrolling = true;
    this.this$0.Qo(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixe
 * JD-Core Version:    0.7.0.1
 */