import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class abgr
{
  private String TAG = "antiphishingConfig";
  private boolean bInit;
  private String bfD;
  private Context context;
  private int cos;
  private int cot;
  private int cou = 1;
  private int cov = 2;
  private Handler handler = new abgs(this, Looper.getMainLooper());
  private long lastUpdateTime;
  private ArrayList<String> urlList;
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  private String qR()
  {
    new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Tencent/com/tencent/mobileqq/antiphishingconfig.xml").toString();
    return this.bfD;
  }
  
  public boolean XW()
  {
    QLog.d(this.TAG, 2, "Parase Config!");
    Object localObject = qR();
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    abgv localabgv = new abgv();
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream((File)localObject), "UTF-8")), localabgv);
      this.cos = localabgv.zx();
      this.urlList = localabgv.cl();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Context paramContext)
  {
    if (paramInt <= this.cos)
    {
      QLog.d(this.TAG, 4, "nNewVersion:" + paramInt + "nLocalConfigVer:" + this.cos + "Do not Need Update!");
      return;
    }
    if ((this.lastUpdateTime != 0L) && (this.cot == paramInt) && (System.currentTimeMillis() - this.lastUpdateTime < 7200000L))
    {
      QLog.d(this.TAG, 1, "Config Updata, Frequence limited!");
      return;
    }
    this.lastUpdateTime = System.currentTimeMillis();
    this.cot = paramInt;
    QLog.d(this.TAG, 1, "filehash:" + paramString2 + "downloadurl:" + paramString1);
    ThreadManager.post(new AntiphishingUrlConfig.2(this, paramContext, paramString1, paramString2), 5, null, true);
  }
  
  public ArrayList<String> ck()
  {
    if ((this.urlList == null) && (!this.bInit)) {
      XW();
    }
    return this.urlList;
  }
  
  public void j(String paramString, Context paramContext)
  {
    this.bfD = paramString;
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgr
 * JD-Core Version:    0.7.0.1
 */