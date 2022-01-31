import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonGridViewAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

public class foc
  implements View.OnLongClickListener
{
  public foc(EmoticonGridViewAdapter paramEmoticonGridViewAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramView.getTag();
      if ((localEmoticonInfo != null) && (!EmoticonGridViewAdapter.a(this.a).a(localEmoticonInfo))) {
        EmoticonGridViewAdapter.a(this.a, paramView, localEmoticonInfo);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foc
 * JD-Core Version:    0.7.0.1
 */