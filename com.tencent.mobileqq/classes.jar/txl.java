import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class txl
  implements ViewTreeObserver.OnPreDrawListener
{
  txl(txj paramtxj, int paramInt) {}
  
  public boolean onPreDraw()
  {
    txj.a(this.jdField_a_of_type_Txj).getViewTreeObserver().removeOnPreDrawListener(this);
    txj.a(this.jdField_a_of_type_Txj).scrollToPosition(this.jdField_a_of_type_Int);
    if ((txj.a(this.jdField_a_of_type_Txj) != null) && (txj.a(this.jdField_a_of_type_Txj) != null))
    {
      txj.a(this.jdField_a_of_type_Txj).setCurPicPos(this.jdField_a_of_type_Int, txj.a(this.jdField_a_of_type_Txj).images.size());
      QCircleContentOperationView.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "adjustEnterImageShowPos:" + this.jdField_a_of_type_Int);
    txj.a(this.jdField_a_of_type_Txj, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txl
 * JD-Core Version:    0.7.0.1
 */