import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class agpz
  extends agpy
  implements aglc
{
  private static SparseIntArray X;
  protected Timer G;
  protected agkv.b a;
  protected String bIS = "";
  protected boolean ceK;
  protected ExcitingTransferUploadResultRp e;
  
  private agpz(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, agpz.a parama, agqc paramagqc)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 0, parama, paramagqc);
    djf();
  }
  
  public static aglc a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, agpz.a parama, agqc paramagqc)
  {
    if (parama == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is null");
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
        QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (parama.isVaild()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramagqc.isVaild()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new agpz(paramQQAppInterface, paramLong1, paramLong2, parama, paramagqc);
  }
  
  private void c(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.e = paramExcitingTransferUploadResultRp;
  }
  
  private void djd()
  {
    try
    {
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] need to wait sha calc done");
      dje();
      this.ceK = true;
      this.G = new Timer();
      this.G.schedule(new ExtfC2CFileUploader.1(this), 120000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dje()
  {
    try
    {
      this.ceK = false;
      if (this.G != null)
      {
        QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] cancel wait sha calc");
        this.G.cancel();
        this.G = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void djf()
  {
    if (X == null) {
      X = new SparseIntArray();
    }
    X.put(0, 0);
    X.put(1, 9004);
    X.put(2, 9004);
    X.put(3, 9045);
    X.put(4, 9052);
    X.put(5, 9032);
    X.put(6, 9052);
    X.put(7, 9005);
    X.put(8, 9003);
    X.put(9, 4606);
    X.put(10, 4606);
    X.put(11, 9001);
    X.put(12, 9052);
    X.put(13, 9009);
    X.put(16, 9009);
    X.put(14, 9032);
    X.put(15, 9032);
    X.put(17, 9001);
    X.put(18, 9052);
    X.put(19, 9001);
    X.put(20, 9001);
    X.put(30, 9043);
    X.put(31, 9006);
    X.put(32, 9042);
    X.put(33, 9037);
  }
  
  public static int hI(int paramInt)
  {
    return X.get(paramInt, 9001);
  }
  
  protected int ED()
  {
    return 69;
  }
  
  public int Ep()
  {
    if (this.e != null) {
      return (int)this.e.m_uIpChangeCount;
    }
    return EE();
  }
  
  public void a(agkv.b paramb)
  {
    this.jdField_a_of_type_Agkv$b = paramb;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Agqa instanceof agpz.a))
    {
      agpz.a locala = (agpz.a)this.jdField_a_of_type_Agqa;
      paramExcitingTransferUploadBizInfo.bufUuid = locala.ec;
      paramExcitingTransferUploadBizInfo.bufUploadKey = locala.ed;
      paramExcitingTransferUploadBizInfo.bUseMediaPlatform = locala.ceL;
      return;
    }
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] onGetOtherSendBusInfo. no other info");
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
      if (this.jdField_a_of_type_Agkv$b != null) {
        this.jdField_a_of_type_Agkv$b.dgA();
      }
      return;
    }
  }
  
  public void bb(byte[] paramArrayOfByte)
  {
    if ((this.mIsStop) || (!this.ceK)) {
      return;
    }
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] onFullShaCalcDone...");
    dje();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      b(-2, null);
      return;
    }
    this.jdField_a_of_type_Agqa.bh(paramArrayOfByte);
    amd();
  }
  
  public void bme()
  {
    if (this.mIsStop) {
      return;
    }
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] cancelTask");
    dje();
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
      paramInt = hI(paramInt);
      if (this.jdField_a_of_type_Agkv$b != null) {
        this.jdField_a_of_type_Agkv$b.a(true, this.bz, paramInt, "", "");
      }
      return;
    }
  }
  
  public boolean cd(long paramLong)
  {
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] sendFile pos:" + paramLong);
    this.mIsStop = false;
    aTU();
    dje();
    c(null);
    if ((this.jdField_a_of_type_Agqa.af() == null) || (this.jdField_a_of_type_Agqa.af().length == 0))
    {
      if (this.jdField_a_of_type_Agkv$b != null)
      {
        Bundle localBundle = new Bundle();
        byte[] arrayOfByte = this.jdField_a_of_type_Agkv$b.a(localBundle);
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          int i = localBundle.getInt("_shaCalcProgress_", 0);
          if (i == 1)
          {
            djd();
            return true;
          }
          this.mIsStop = true;
          QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] sendFile fail. fullsha calc fail or none. " + i);
          return false;
        }
        this.jdField_a_of_type_Agqa.bh(arrayOfByte);
      }
    }
    else {
      return amd();
    }
    this.mIsStop = true;
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] sendFile fail. fullsha can not get");
    return false;
  }
  
  protected ExcitingTransferUploadChnConfigInfo d()
  {
    return agpf.a().b();
  }
  
  protected List<ExcitingTransferHostInfo> eZ()
  {
    Object localObject;
    List localList;
    if (agke.a().l(this.mApp, 1))
    {
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. is config enable IPv6.");
      localObject = agpf.a().t(false);
      localList = agke.a().c(this.mApp, 1);
      if (localList != null)
      {
        if (localObject != null) {
          break label165;
        }
        localObject = new ArrayList();
      }
    }
    label165:
    for (;;)
    {
      if (agke.alt())
      {
        QLog.d("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. debugIsDisableIPv4OnDoubleStack");
        ((List)localObject).clear();
      }
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((List)localObject).add(0, (ExcitingTransferHostInfo)localList.get(i));
        i -= 1;
      }
      this.cXp = 2;
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. use IPv6. iplist:" + localObject.toString());
      return localObject;
      this.cXp = 1;
      return localObject;
      return super.eZ();
    }
  }
  
  public long fF()
  {
    return fY();
  }
  
  public long fG()
  {
    if (this.e != null) {
      return this.e.m_u64StartSize;
    }
    return 0L;
  }
  
  public int getRetryCount()
  {
    if (this.e != null) {
      return (int)this.e.m_uRetryCount;
    }
    return 0;
  }
  
  public String getUrl()
  {
    return this.bIS;
  }
  
  protected int kw()
  {
    return 0;
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
    if (this.jdField_a_of_type_Agkv$b != null) {
      this.jdField_a_of_type_Agkv$b.jm(paramLong1);
    }
  }
  
  protected int wJ()
  {
    return 3;
  }
  
  public static class a
    extends agqa
  {
    final boolean ceL;
    final byte[] ec;
    final byte[] ed;
    
    public a(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean)
    {
      super(paramString2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
      this.ec = paramArrayOfByte5;
      this.ed = paramArrayOfByte6;
      this.ceL = paramBoolean;
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
            if ((ad() != null) && (ad().length != 0)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBuf10MMdd5 is err");
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
      StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append(" uuid:");
      if (this.ec != null)
      {
        str = HexUtil.bytes2HexStr(this.ec);
        localStringBuilder = localStringBuilder.append(str).append(" mBufUploadKey:");
        if (this.ed == null) {
          break label76;
        }
      }
      label76:
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
 * Qualified Name:     agpz
 * JD-Core Version:    0.7.0.1
 */