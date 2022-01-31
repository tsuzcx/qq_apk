import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class wpf
  implements Runnable
{
  public wpf(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    EmoticonGroupStoreFragment.a(this.a).setVisibility(8);
    EmoticonGroupStoreFragment.c(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpf
 * JD-Core Version:    0.7.0.1
 */