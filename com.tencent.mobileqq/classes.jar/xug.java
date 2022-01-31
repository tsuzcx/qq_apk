import com.tencent.av.AVLog;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.concurrent.atomic.AtomicInteger;

public class xug
  implements INetEngine.INetEngineListener
{
  public xug(VideoFilterTools paramVideoFilterTools) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("VideoFilterTools", "download IconFile failed. errorCode: " + paramNetResp.b + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.c);
      return;
    }
    if ((VideoFilterTools.a(this.a).decrementAndGet() == 0) && (VideoFilterTools.a(this.a) != null)) {
      VideoFilterTools.a(this.a).a(true);
    }
    AVLog.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xug
 * JD-Core Version:    0.7.0.1
 */