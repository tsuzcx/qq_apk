import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

public class agmv
{
  private final awqd.c jdField_a_of_type_Awqd$c;
  private final UploadManager.IUploadStatusListener jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener;
  private final boolean cem;
  private final Object context;
  private String fileId;
  private final String flowId;
  
  public agmv(String paramString, Object paramObject, boolean paramBoolean, UploadManager.IUploadStatusListener paramIUploadStatusListener, awqd.c paramc)
  {
    this.flowId = paramString;
    this.context = paramObject;
    this.cem = paramBoolean;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener = paramIUploadStatusListener;
    this.jdField_a_of_type_Awqd$c = paramc;
  }
  
  public void cancel()
  {
    if (this.cem)
    {
      WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.flowId);
      return;
    }
    awqd.a().removeJob(this.flowId);
  }
  
  public void setFileId(String paramString)
  {
    this.fileId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */