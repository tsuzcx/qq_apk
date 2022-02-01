import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class alfx
  extends alfv
{
  public long batchId;
  public byte[] businessData;
  protected String businessId;
  public int businessType;
  public int dataType = 13;
  public int dsV;
  public int dsW;
  public String fileId;
  public int keepRaw = 1;
  public int uploadType = 3;
  public String zC;
  
  public alfx(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramLong, paramString1, paramArrayOfByte);
    this.businessId = paramString2;
  }
  
  public alfv a()
  {
    UpsImageUploadTask localUpsImageUploadTask = new UpsImageUploadTask(this.uploadFilePath);
    localUpsImageUploadTask.dataType = this.dataType;
    localUpsImageUploadTask.fileId = this.fileId;
    localUpsImageUploadTask.flowId = this.dsU;
    localUpsImageUploadTask.iBatchID = this.batchId;
    localUpsImageUploadTask.iBatchUploadCount = this.dsV;
    localUpsImageUploadTask.iBusiNessType = this.businessType;
    localUpsImageUploadTask.iCurrentUploadOrder = this.dsW;
    localUpsImageUploadTask.iSync = this.iSync;
    localUpsImageUploadTask.iUin = this.iUin;
    localUpsImageUploadTask.iUploadType = this.uploadType;
    localUpsImageUploadTask.keepRaw = this.keepRaw;
    localUpsImageUploadTask.md5 = this.md5;
    localUpsImageUploadTask.preupload = this.preupload;
    localUpsImageUploadTask.reportRefer = this.reportRefer;
    localUpsImageUploadTask.sBusinessId = this.businessId;
    localUpsImageUploadTask.sCommand = this.zC;
    localUpsImageUploadTask.sRefer = this.sRefer;
    localUpsImageUploadTask.transferData = this.transferData;
    localUpsImageUploadTask.uiRefer = this.uiRefer;
    localUpsImageUploadTask.uploadTaskCallback = this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
    localUpsImageUploadTask.vBusiNessData = this.businessData;
    localUpsImageUploadTask.vLoginData = this.fe;
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask = localUpsImageUploadTask;
    return this;
  }
  
  protected void g(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfx
 * JD-Core Version:    0.7.0.1
 */