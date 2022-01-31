import android.widget.TextView;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.FilterAdapter;
import java.util.List;

public class woy
  implements Runnable
{
  public woy(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    EmoticonGroupStoreFragment.a(this.a).a(EmoticonGroupStoreFragment.a(this.a));
    EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
    EmoticonGroupStoreFragment.b(this.a).setText("筛选（共" + EmoticonGroupStoreFragment.c(this.a).size() + "个表情）");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     woy
 * JD-Core Version:    0.7.0.1
 */