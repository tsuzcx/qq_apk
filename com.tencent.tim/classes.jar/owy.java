import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.a;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;

class owy
  implements QCircleSlidBottomView.a
{
  owy(oww paramoww) {}
  
  public void onDismiss()
  {
    oww.a(this.a).a().scrollToPosition(0);
    oww.a(this.a).getBlockMerger().bxn();
    oww.a(this.a).clearData();
    pcl.a(75, 2, oww.a(this.a));
    QLog.d("QCirclePolyListPart", 3, "dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owy
 * JD-Core Version:    0.7.0.1
 */