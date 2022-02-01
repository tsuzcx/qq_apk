import android.text.TextUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class alfv
{
  protected byte[] A2;
  protected AbstractUploadTask a;
  protected IUploadTaskCallback a;
  protected IUploadTaskCallback b = new alfw(this);
  public int dsT = 6;
  protected int dsU = -1;
  public byte[] fe;
  public int iSync = 0;
  public long iUin;
  protected int mErrorCode;
  protected String mErrorMsg = "";
  protected Object mResult;
  protected volatile int mState = -10001;
  protected String mTaskState;
  protected String md5;
  public int preupload;
  public String reportRefer;
  public String sRefer = "mqq";
  public Map<String, String> transferData;
  public String uiRefer;
  protected String uploadFilePath;
  
  public alfv(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.iUin = paramLong;
    this.uploadFilePath = paramString;
    this.md5 = alft.createFileMD5(paramString);
    this.dsU = Hw();
    this.A2 = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = this.b;
  }
  
  protected int Hw()
  {
    if (this.uploadFilePath == null) {}
    for (String str = "";; str = this.uploadFilePath) {
      return (str + System.currentTimeMillis()).hashCode();
    }
  }
  
  protected boolean atw()
  {
    if ((this.A2 == null) || (this.fe == null) || (this.fe.length == 0))
    {
      this.b.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -3, "invalid login data");
      return false;
    }
    return true;
  }
  
  protected boolean atx()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath))
    {
      this.b.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -1, "no file path!");
      return false;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath);
    if ((localFile == null) || (!localFile.exists()) || (localFile.length() == 0L) || (localFile.isDirectory()))
    {
      this.b.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -2, "file is not exist or empty!");
      return false;
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData.put("task_state", "running_task");
    return UploadServiceBuilder.getInstance().upload(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask);
  }
  
  protected abstract void g(int paramInt, Object... paramVarArgs);
  
  public final String getErrorMsg()
  {
    return this.mErrorMsg;
  }
  
  public final Object getResult()
  {
    return this.mResult;
  }
  
  protected void updateTask()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(this.mTaskState)) {
      localHashMap.put("task_state", this.mTaskState);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer)) {
      localHashMap.put("business_refer", this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer);
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData = localHashMap;
  }
  
  protected void upload()
  {
    if (this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask == null) {
      throw new NullPointerException("Are you forget call buildTask()?");
    }
    if (!atw()) {
      return;
    }
    updateTask();
    atx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfv
 * JD-Core Version:    0.7.0.1
 */