import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atvr
  extends atgg
{
  atvr(atvp paramatvp, String paramString1, String paramString2) {}
  
  public void a(byte[] paramArrayOfByte, List<Object> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0)
    {
      if (this.this$0.diG)
      {
        this.this$0.ji(this.val$filePath, this.cIe);
        return;
      }
      this.this$0.diG = true;
      paramArrayOfByte = paramList.iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramList = paramArrayOfByte.next();
        if ((paramList instanceof FileManagerEntity))
        {
          paramList = ((FileManagerEntity)paramList).cloudFile;
          if (paramList != null)
          {
            paramString1 = aqhs.bytes2HexStr(paramList.cloudId);
            QLog.i("WpsFileEditStore", 1, "[WPSEDIT] onFetchDirFileList dirkey:" + aqhs.bytes2HexStr(paramList.pLogicDirKey) + " cloudId:" + paramString1 + " cloudname:" + paramList.showName);
            if (this.cIe.equalsIgnoreCase(paramString1))
            {
              paramArrayOfByte = new atvp.b();
              paramArrayOfByte.hN = paramList.pLogicDirKey;
              paramArrayOfByte.cloudId = paramList.cloudId;
              paramArrayOfByte.cHU = paramList.showName;
              this.this$0.a(this.val$filePath, true, true, paramArrayOfByte);
              return;
            }
          }
        }
      }
      this.this$0.ji(this.val$filePath, this.cIe);
      return;
    }
    this.this$0.ji(this.val$filePath, this.cIe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvr
 * JD-Core Version:    0.7.0.1
 */