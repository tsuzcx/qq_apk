import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.f;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.common.app.BaseApplicationImpl;

public class owg
  implements TabLayoutCompat.f
{
  public owg(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void a(TabLayoutCompat.d paramd1, @Nullable TabLayoutCompat.d paramd2, int paramInt)
  {
    if (paramd1 != null) {
      QCircleFolderFragmentsPart.a(this.this$0, paramd1.getPosition(), 1);
    }
  }
  
  public View e(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131560911, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owg
 * JD-Core Version:    0.7.0.1
 */