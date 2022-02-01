import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public abstract class orc<T>
  extends auwn<T>
{
  public ogn<T> a;
  public T be;
  public WSVerticalPageFragment c;
  
  public orc(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1);
    this.c = paramWSVerticalPageFragment;
    this.a = a(paramInt2);
  }
  
  public void P(T paramT)
  {
    super.P(paramT);
    this.be = paramT;
  }
  
  public abstract ogn<T> a(int paramInt);
  
  public abstract FrameLayout c();
  
  public abstract void onPageSelected(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orc
 * JD-Core Version:    0.7.0.1
 */