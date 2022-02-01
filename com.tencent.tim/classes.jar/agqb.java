import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agqb
  extends agpy
  implements apfr
{
  protected apfs a;
  protected String bIS = "";
  protected ExcitingTransferUploadResultRp e;
  
  private agqb(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, agqb.a parama, agqc paramagqc)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, parama, paramagqc);
  }
  
  public static apfr a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, agqb.a parama, agqc paramagqc)
  {
    if (parama == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramagqc != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (parama.isVaild()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramagqc.isVaild()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new agqb(paramQQAppInterface, paramLong1, paramLong2, parama, paramagqc);
  }
  
  private void c(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.e = paramExcitingTransferUploadResultRp;
  }
  
  protected int ED()
  {
    return 71;
  }
  
  public int EG()
  {
    if (this.e != null) {
      return (int)this.e.m_uRetryCount;
    }
    return 0;
  }
  
  public int EH()
  {
    return 0;
  }
  
  public void a(apfs paramapfs)
  {
    this.jdField_a_of_type_Apfs = paramapfs;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Agqa instanceof agqb.a))
    {
      agqb.a locala = (agqb.a)this.jdField_a_of_type_Agqa;
      paramExcitingTransferUploadBizInfo.groupCode = locala.Ff;
      paramExcitingTransferUploadBizInfo.bufUuid = locala.ec;
      paramExcitingTransferUploadBizInfo.bufUploadKey = locala.ed;
      return;
    }
    QLog.w("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] onGetOtherSendBusInfo. no other info");
  }
  
  public boolean alC()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.e != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Agqa != null)
      {
        bool1 = bool2;
        if (this.e.m_u64StartSize == this.jdField_a_of_type_Agqa.fZ()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean alZ()
  {
    return false;
  }
  
  public boolean ame()
  {
    this.mIsStop = false;
    c(null);
    return amd();
  }
  
  public ExcitingTransferUploadResultRp b()
  {
    return this.e;
  }
  
  protected void b(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.b(paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.bIS = str;
      c(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_Apfs != null) {
        this.jdField_a_of_type_Apfs.dgA();
      }
      return;
    }
  }
  
  public void bme()
  {
    if (this.mIsStop) {
      return;
    }
    QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] cancelTask");
    djc();
    c(null);
  }
  
  protected void c(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.c(paramInt, paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.bIS = str;
      c(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_Apfs != null) {
        this.jdField_a_of_type_Apfs.a(true, this.bz, paramInt, "", "");
      }
      return;
    }
  }
  
  protected ExcitingTransferUploadChnConfigInfo d()
  {
    return agpf.a().c();
  }
  
  protected List<ExcitingTransferHostInfo> eZ()
  {
    Object localObject;
    List localList;
    if (agke.a().l(this.mApp, 3))
    {
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. is config enable IPv6.");
      localObject = agpf.a().t(false);
      localList = agke.a().c(this.mApp, 3);
      if (localList != null)
      {
        if (localObject != null) {
          break label162;
        }
        localObject = new ArrayList();
      }
    }
    label162:
    for (;;)
    {
      if (agke.alt())
      {
        QLog.d("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. debugIsDisableIPv4OnDoubleStack");
        ((List)localObject).clear();
      }
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((List)localObject).add(0, (ExcitingTransferHostInfo)localList.get(i));
        i -= 1;
      }
      this.cXp = 2;
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. use IPv6. hostlist:" + localObject.toString());
      return localObject;
      this.cXp = 1;
      return localObject;
      return super.eZ();
    }
  }
  
  public long fG()
  {
    if (this.e != null) {
      return this.e.m_u64StartSize;
    }
    return 0L;
  }
  
  public int getProxyType()
  {
    return 0;
  }
  
  public String getUrl()
  {
    return this.bIS;
  }
  
  protected int kw()
  {
    return 1;
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.m_strFileUrl;; str = "")
    {
      this.bIS = str;
      super.onExcitingSubSenderResult(paramInt, paramExcitingTransferUploaderRp);
      return;
    }
  }
  
  protected void t(long paramLong1, long paramLong2, long paramLong3)
  {
    super.t(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Apfs != null) {
      this.jdField_a_of_type_Apfs.jm(paramLong1);
    }
  }
  
  public String vC()
  {
    return "";
  }
  
  protected int wJ()
  {
    return 102;
  }
  
  public static class a
    extends agqa
  {
    final long Ff;
    final byte[] ec;
    final byte[] ed;
    
    public a(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
    {
      super(paramString2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
      this.Ff = paramLong;
      this.ec = paramArrayOfByte5;
      this.ed = paramArrayOfByte6;
    }
    
    public boolean isVaild()
    {
      if (!super.isVaild()) {}
      do
      {
        do
        {
          do
          {
            return false;
            if (this.Ff != 0L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mGroupCode is err");
          return false;
          if ((this.ec != null) && (this.ec.length != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUuid is err");
        return false;
        if ((this.ed != null) && (this.ed.length != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUploadKey is err");
      return false;
      return true;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append(" mGroupCode:").append(this.Ff).append(" uuid:");
      if (this.ec != null)
      {
        str = HexUtil.bytes2HexStr(this.ec);
        localStringBuilder = localStringBuilder.append(str).append(" mBufUploadKey:");
        if (this.ed == null) {
          break label88;
        }
      }
      label88:
      for (String str = HexUtil.bytes2HexStr(this.ed);; str = "")
      {
        return str;
        str = "";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqb
 * JD-Core Version:    0.7.0.1
 */