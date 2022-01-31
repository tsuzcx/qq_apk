import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class wuq
  implements Runnable
{
  public wuq(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    EmoticonGroupStoreFragment.a(this.a).setVisibility(8);
    EmoticonGroupStoreFragment.c(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */