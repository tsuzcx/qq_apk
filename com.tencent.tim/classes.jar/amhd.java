import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class amhd
  extends Observable
{
  private static amhd a;
  private EIPCResultCallback e = new amhe(this);
  public EIPCResultCallback f = new amhf(this);
  private ConcurrentHashMap<Integer, aqqs> gN = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, String> gO = new ConcurrentHashMap();
  public RichStatus j;
  public RichStatus k;
  
  public static String J(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static amhd a()
  {
    try
    {
      if (a == null) {
        a = new amhd();
      }
      amhd localamhd = a;
      return localamhd;
    }
    finally {}
  }
  
  public aqqs a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public aqqs a(int paramInt, boolean paramBoolean)
  {
    aqqs localaqqs2 = (aqqs)this.gN.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localaqqs2 != null) && (!localaqqs2.er.get()))
    {
      localObject = localaqqs2;
      if (!paramBoolean) {}
    }
    else
    {
      aqqs localaqqs1 = localaqqs2;
      if (localaqqs2 == null)
      {
        localaqqs1 = new aqqs(Integer.toString(paramInt));
        this.gN.put(Integer.valueOf(paramInt), localaqqs1);
      }
      localObject = localaqqs1;
      if (paramInt != 0)
      {
        localaqqs1.er.set(true);
        if (QLog.isColorLevel()) {
          QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
        }
        ThreadManager.excute(new SignatureManagerForTool.1(this, paramInt), 128, null, true);
        localObject = localaqqs1;
      }
    }
    return localObject;
  }
  
  public String eU(int paramInt)
  {
    String str = (String)this.gO.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", ld.eB, localBundle, this.e);
    }
    return str;
  }
  
  public void g(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.j == null) {
      this.j = new RichStatus(null);
    }
    this.j.copyFrom(paramRichStatus);
    QLog.d("Signature.TOOL", 2, "updateHandleStatus: tpdId=" + this.j.tplId + " fontId=" + this.j.fontId);
  }
  
  public void h(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.k == null) {
      this.k = new RichStatus(null);
    }
    this.k.copyFrom(paramRichStatus);
    QLog.d("Signature.TOOL", 2, "updateSaveStatus: tpdId=" + this.k.tplId + " fontId=" + this.k.fontId);
    g(paramRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhd
 * JD-Core Version:    0.7.0.1
 */