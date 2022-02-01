import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class vrg
  extends vrk
{
  public vrg(QCircleFeedPicLoader.PicDownLoadTask paramPicDownLoadTask, vrd paramvrd, long paramLong)
  {
    super(paramvrd);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0).remove(this.jdField_a_of_type_Vrd.b());
      if (this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.a != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.a.a(QCircleFeedPicLoader.c, this.jdField_a_of_type_Vrd);
        QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0, this.jdField_a_of_type_Vrd, 0);
      }
      QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " download by ImageDownLoader success cost: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      if (this.jdField_a_of_type_Vrd.a()) {
        QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.a);
      }
      return;
    }
    QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0).remove(this.jdField_a_of_type_Vrd.b());
    QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrd.b());
    if (this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.a != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.a.a(QCircleFeedPicLoader.g, this.jdField_a_of_type_Vrd);
      QCircleFeedPicLoader.a(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0, this.jdField_a_of_type_Vrd, paramInt);
      QCircleFeedPicLoader.b(this.jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader$PicDownLoadTask.this$0, this.jdField_a_of_type_Vrd, 1);
    }
    QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " download failed " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */