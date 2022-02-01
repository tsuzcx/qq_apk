import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.cloudfile.PreviewInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

class atgf
  extends CloudFileCallback
{
  atgf(atge paramatge) {}
  
  public void onCheckPreviewFileCallback(PreviewInfo paramPreviewInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewCloudFile", 2, "onCheckPreviewFileCallback errorCode=" + paramInt + " errMsg=" + paramString);
    }
    if (this.a.a != null)
    {
      if (paramInt == 0) {
        this.a.a.a(true, paramPreviewInfo.strIP, String.valueOf(paramPreviewInfo.port), paramInt, paramString, aqhs.bytes2HexStr(paramPreviewInfo.downloadKey), paramPreviewInfo.cookies, "");
      }
    }
    else {
      return;
    }
    this.a.a.a(false, "", "", paramInt, paramString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgf
 * JD-Core Version:    0.7.0.1
 */