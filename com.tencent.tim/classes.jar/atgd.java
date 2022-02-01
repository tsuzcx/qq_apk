import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class atgd
  implements acci
{
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, List<atkw> paramList, int paramInt3, String paramString) {}
  
  public void a(int paramInt1, boolean paramBoolean, List<OfflineFileInfo> paramList, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, CloudUserInfo paramCloudUserInfo) {}
  
  public void a(boolean paramBoolean, MessageForTroopFile paramMessageForTroopFile, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<atiu> paramList, boolean paramBoolean2, String paramString, int paramInt2) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, atin paramatin, String paramString) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, List<BatchRequest> paramList, byte[] paramArrayOfByte2, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, long paramLong1, long paramLong2, byte[] paramArrayOfByte3, String paramString1, int paramInt2, String paramString2) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString) {}
  
  public void b(int paramInt1, boolean paramBoolean, List<OfflineFileInfo> paramList, int paramInt2, String paramString) {}
  
  public void b(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void bLQ() {}
  
  public void c(boolean paramBoolean1, int paramInt, List<atiu> paramList, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void d(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void g(boolean paramBoolean, int paramInt, List<Object> paramList) {}
  
  public void gM(String paramString, int paramInt) {}
  
  public void m(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2) {}
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2) {}
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileObserver", 2, new Object[] { "onUpdate|type=", Integer.valueOf(paramInt), ", success=", Boolean.valueOf(paramBoolean) });
    }
    paramObject = (Object[])paramObject;
    Object localObject;
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return;
    case 0: 
      m(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    case 1: 
      a(paramBoolean, (byte[])paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4], ((Integer)paramObject[5]).intValue());
      return;
    case 2: 
      a(paramBoolean, (CloudUserInfo)paramObject[0]);
      return;
    case 3: 
      a(paramBoolean, (byte[])paramObject[0], (atin)paramObject[1], (String)paramObject[2]);
      return;
    case 5: 
      localObject = (byte[])paramObject[0];
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramObject[1];
      paramInt = ((Integer)paramObject[2]).intValue();
      String str = (String)paramObject[3];
      a(paramBoolean, (byte[])localObject, ((Long)paramObject[4]).longValue(), localFileManagerEntity, paramInt, str);
      return;
    case 4: 
      c(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 17: 
      g(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
      return;
    case 11: 
      a(paramBoolean, (byte[])paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue());
      return;
    case 12: 
    case 13: 
      a(paramBoolean, (byte[])paramObject[0], (byte[])paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 14: 
      a(paramBoolean, (byte[])paramObject[0], (List)paramObject[1], (byte[])paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 15: 
      a(paramBoolean, (byte[])paramObject[0], (byte[])paramObject[1], (byte[])paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
      return;
    case 16: 
      a(paramBoolean, (byte[])paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), ((Long)paramObject[4]).longValue(), (byte[])paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
    case 18: 
      a(paramBoolean, (FileManagerEntity)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 19: 
      c(paramBoolean, (FileManagerEntity)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 28: 
      b(paramBoolean, (FileManagerEntity)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 29: 
      d(paramBoolean, (FileManagerEntity)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 20: 
      a(paramBoolean, (MessageForTroopFile)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 21: 
      onStartDownLoad((byte[])paramObject[0], (byte[])paramObject[1], ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 22: 
      onStopDownload((byte[])paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 23: 
      onDownloadProgress((byte[])paramObject[0], (byte[])paramObject[1], ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Long)paramObject[4]).longValue());
      return;
    case 24: 
      onDownloadComplete((byte[])paramObject[0], (byte[])paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 25: 
      a(((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue(), (List)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 26: 
      b(((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue(), (List)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 27: 
      paramInt = ((Integer)paramObject[0]).intValue();
      paramBoolean = ((Boolean)paramObject[1]).booleanValue();
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      localObject = (String)paramObject[4];
      a(paramInt, paramBoolean, i, (List)paramObject[5], j, (String)localObject);
      return;
    case 30: 
      gM((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    bLQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgd
 * JD-Core Version:    0.7.0.1
 */