import com.tencent.av.AVLog;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools.SkinColorFilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

public class xqz
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = (VideoFilterTools.SkinColorFilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    AVLog.c("VideoFilterTools", "download file call back. file = " + ((VideoFilterTools.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("VideoFilterTools", "download file faild. errcode = " + paramNetResp.b);
      return;
    }
    if (!((VideoFilterTools.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
    {
      AVLog.c("VideoFilterTools", "download file faild : md5 is not match.");
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    AVLog.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = VideoFilterTools.a();
      FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqz
 * JD-Core Version:    0.7.0.1
 */