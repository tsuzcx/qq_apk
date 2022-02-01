import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallback;

class auec
  extends CloudFileCallback
{
  auec(aueb paramaueb) {}
  
  public void onCopyTMCFileCallBack(int paramInt, String paramString, CloudFile paramCloudFile)
  {
    super.onCopyTMCFileCallBack(paramInt, paramString, paramCloudFile);
    if ((paramInt == 0) && (paramCloudFile != null)) {
      this.a.b.a(paramCloudFile.showName, paramCloudFile.finalPath, paramCloudFile.pLogicDirKey, paramCloudFile.cloudId, paramCloudFile.fileSha, paramCloudFile.fileSize, paramCloudFile.fileType, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auec
 * JD-Core Version:    0.7.0.1
 */