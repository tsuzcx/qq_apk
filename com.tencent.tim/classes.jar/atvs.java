import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atvs
  extends atgg
{
  atvs(atvp paramatvp, String paramString1, String paramString2) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    if ((paramCloudBase == null) || (!(paramCloudBase instanceof CloudFile)))
    {
      QLog.e("WpsFileEditStore", 1, "[WPSEDIT] onFetchedDefaultDirListFor getcloudItem err:");
      this.this$0.a(this.val$filePath, true, false, null);
      return;
    }
    paramCloudBase = (CloudFile)paramCloudBase;
    Object localObject = aqhs.bytes2HexStr(paramCloudBase.cloudId);
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] onGetCloudItem dirkey:" + aqhs.bytes2HexStr(paramCloudBase.pLogicDirKey) + " cloudId:" + (String)localObject + " cloudname:" + paramCloudBase.showName);
    if ((this.cIe.equalsIgnoreCase((String)localObject)) && (Arrays.equals(paramCloudBase.pLogicDirKey, atvp.a(this.this$0))))
    {
      localObject = new atvp.b();
      ((atvp.b)localObject).hN = paramCloudBase.pLogicDirKey;
      ((atvp.b)localObject).cloudId = paramCloudBase.cloudId;
      ((atvp.b)localObject).cHU = paramCloudBase.showName;
      this.this$0.a(this.val$filePath, true, true, (atvp.b)localObject);
      return;
    }
    atvp.a(this.this$0, this.val$filePath);
    this.this$0.a(this.val$filePath, true, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvs
 * JD-Core Version:    0.7.0.1
 */