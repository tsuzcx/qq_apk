import android.support.annotation.NonNull;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class agqc
{
  private final List<ExcitingTransferHostInfo> BC;
  private final List<ExcitingTransferHostInfo> BD;
  private final String bIT;
  private final boolean ceM;
  private final byte[] eg;
  
  public agqc(List<ExcitingTransferHostInfo> paramList1, List<ExcitingTransferHostInfo> paramList2, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    this.BC = paramList1;
    this.BD = paramList2;
    this.ceM = paramBoolean;
    this.bIT = paramString;
    this.eg = paramArrayOfByte;
  }
  
  public byte[] ag()
  {
    return this.eg;
  }
  
  public boolean amf()
  {
    return this.ceM;
  }
  
  public List<ExcitingTransferHostInfo> fa()
  {
    return this.BC;
  }
  
  public List<ExcitingTransferHostInfo> fb()
  {
    return this.BD;
  }
  
  public boolean isVaild()
  {
    if ((this.ceM) && (this.bIT == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.SvrInfo<FileAssistant>", 2, "support https but mstrSSLName is null");
      }
      return false;
    }
    return true;
  }
  
  @NonNull
  public String toString()
  {
    Iterator localIterator = this.BC.iterator();
    ExcitingTransferHostInfo localExcitingTransferHostInfo;
    for (Object localObject = "IPV4:"; localIterator.hasNext(); localObject = (String)localObject + "[" + localExcitingTransferHostInfo.mstrIp + ":" + localExcitingTransferHostInfo.mport + "] ") {
      localExcitingTransferHostInfo = (ExcitingTransferHostInfo)localIterator.next();
    }
    localObject = (String)localObject + " -- IPV6:";
    localIterator = this.BD.iterator();
    while (localIterator.hasNext())
    {
      localExcitingTransferHostInfo = (ExcitingTransferHostInfo)localIterator.next();
      localObject = (String)localObject + "[" + localExcitingTransferHostInfo.mstrIp + ":" + localExcitingTransferHostInfo.mport + "] ";
    }
    localObject = new StringBuilder().append((String)localObject).append(" strSSLCName:").append(this.bIT).append(" bSupportHttps:").append(this.ceM).append(" busniEx len:");
    if (this.eg != null) {}
    for (int i = this.eg.length;; i = 0) {
      return i;
    }
  }
  
  public String vD()
  {
    return this.bIT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqc
 * JD-Core Version:    0.7.0.1
 */