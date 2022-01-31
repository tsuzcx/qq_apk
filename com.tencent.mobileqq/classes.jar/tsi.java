import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class tsi
  implements Observer<ubz<List<QQCircleFeedBase.StTabInfo>>>
{
  public tsi(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void a(@Nullable ubz<List<QQCircleFeedBase.StTabInfo>> paramubz)
  {
    QCircleFolderFragmentsPart.a(this.a, paramubz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsi
 * JD-Core Version:    0.7.0.1
 */