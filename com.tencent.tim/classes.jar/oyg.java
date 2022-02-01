import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.a;
import java.util.ArrayList;
import java.util.List;

public class oyg
  implements QCircleRecommendImageView.a
{
  public oyg(QCircleCommentBottomBar paramQCircleCommentBottomBar) {}
  
  public void onClick(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(pcr.a("ext2", String.valueOf(paramInt)));
    pcl.a(34, 2, QCircleCommentBottomBar.a(this.a), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyg
 * JD-Core Version:    0.7.0.1
 */