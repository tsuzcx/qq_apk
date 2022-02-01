import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vbi
  implements Observer<vup<List<QQCircleFeedBase.StTabInfo>>>
{
  public vbi(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void a(@Nullable vup<List<QQCircleFeedBase.StTabInfo>> paramvup)
  {
    QCircleFolderFragmentsPart.a(this.a, paramvup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbi
 * JD-Core Version:    0.7.0.1
 */