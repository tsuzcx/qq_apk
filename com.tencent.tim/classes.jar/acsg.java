import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class acsg
{
  private acsj a;
  private ConcurrentHashMap<String, acsi> aL;
  private volatile boolean bJY;
  private volatile boolean bJZ;
  private String bqD;
  private int czP;
  private int czQ;
  private int czR;
  private String picPath;
  private String videoPath;
  
  public acsg(acsj paramacsj)
  {
    this.a = paramacsj;
  }
  
  private void cOl()
  {
    if ((this.a != null) && (abZ()))
    {
      this.a.cOq();
      if (QLog.isColorLevel()) {
        QLog.e("FileCleanManager", 2, "fileScanNotify onScanFinish");
      }
    }
  }
  
  private void cOm()
  {
    this.picPath = getPicPath();
    this.videoPath = getVideoPath();
    this.bqD = rT();
    this.czP = this.picPath.length();
    this.czQ = this.videoPath.length();
    this.czR = this.bqD.length();
  }
  
  private void cOn()
  {
    dY(this.picPath, 1);
  }
  
  private void cOo()
  {
    dY(this.videoPath, 2);
  }
  
  private void cOp()
  {
    dY(this.bqD, 3);
  }
  
  private void clearData()
  {
    this.bJY = false;
    this.bJZ = false;
    if (this.aL != null)
    {
      this.aL.clear();
      this.aL = null;
    }
  }
  
  private String dD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return this.picPath;
    case 2: 
      return this.videoPath;
    }
    return this.bqD;
  }
  
  private void dY(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    File[] arrayOfFile;
    if (paramString.exists())
    {
      arrayOfFile = paramString.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label34;
      }
    }
    label34:
    File localFile;
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if (!localFile.isDirectory()) {
          break label78;
        }
        dY(localFile.getAbsolutePath(), paramInt);
        label71:
        i += 1;
      }
    }
    label78:
    int k = gI(paramInt);
    paramString = localFile.getAbsolutePath();
    int m = paramString.length();
    acsi localacsi = new acsi();
    if (m > k) {}
    for (paramString = paramString.substring(k, m);; paramString = "")
    {
      localacsi.bqE = paramString;
      localacsi.fileSize = localFile.length();
      localacsi.fileType = paramInt;
      localacsi.czS = 0;
      if (this.aL == null) {
        break;
      }
      this.aL.put(localFile.getName(), localacsi);
      break label71;
    }
  }
  
  private int gI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return this.czP;
    case 2: 
      return this.czQ;
    }
    return this.czR;
  }
  
  private String getPicPath()
  {
    return aoqr.oz(aoiz.ckP);
  }
  
  private String getVideoPath()
  {
    return ShortVideoUtils.zK();
  }
  
  private String rT()
  {
    return acbn.bmg;
  }
  
  public void Gb(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.aL != null)) {
      this.aL.remove(paramString);
    }
  }
  
  public String a(acsi paramacsi)
  {
    if (paramacsi == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(dD(paramacsi.fileType));
    localStringBuffer.append(paramacsi.bqE);
    return localStringBuffer.toString();
  }
  
  public void a(String paramString, acsi paramacsi)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramacsi != null) && (this.aL != null)) {
      this.aL.put(paramString, paramacsi);
    }
  }
  
  public boolean abZ()
  {
    return (this.bJY) && (this.bJZ);
  }
  
  public void cOk()
  {
    clearData();
    this.aL = new ConcurrentHashMap();
    cOm();
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.1(this));
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.2(this));
  }
  
  public void deleteFiles(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        aqhq.deleteFile((String)paramList.next());
      }
    }
  }
  
  public void onDestroy()
  {
    clearData();
    this.a = null;
  }
  
  public ConcurrentHashMap<String, acsi> s()
  {
    return this.aL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsg
 * JD-Core Version:    0.7.0.1
 */