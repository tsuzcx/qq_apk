import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.PicDownLoadTask;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.c;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class oul
  implements aolm.b
{
  public oul(QCircleFeedPicLoader.PicDownLoadTask paramPicDownLoadTask) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 0)
    {
      QCircleFeedPicLoader.a(this.a.this$0).remove(this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getCacheKey());
      if (this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
        this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.bgi, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
      }
      if (this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.Hy()) {
        QCircleFeedPicLoader.a(this.a.this$0, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c);
      }
      QLog.d(QCircleFeedPicLoader.TAG, 4, "download success ");
    }
    while ((paramaomh.mResult != 1) && (paramaomh.mResult != 2)) {
      return;
    }
    QCircleFeedPicLoader.a(this.a.this$0).remove(this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getCacheKey());
    QCircleFeedPicLoader.a(this.a.this$0, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.ar());
    if (this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
      this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.bgk, this.a.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
    }
    QLog.d(QCircleFeedPicLoader.TAG, 4, "download failed return");
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oul
 * JD-Core Version:    0.7.0.1
 */