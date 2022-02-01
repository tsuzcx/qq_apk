import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher.1;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class afdb
  implements Handler.Callback
{
  public long Xk;
  public QQAppInterface app;
  public MqqHandler b;
  public boolean bXu;
  public Set<String> cn;
  protected ConcurrentHashMap<String, String> fb;
  protected EntityManager mEntityManager;
  private acfd q = new afdc(this);
  
  public afdb(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.fb = new ConcurrentHashMap(20);
    this.cn = new HashSet(20);
    this.bXu = false;
    this.b = new aqgw(ThreadManager.getSubThreadLooper(), this);
  }
  
  public static String a(int paramInt, String paramString, byte paramByte1, byte paramByte2)
  {
    return MsfSdkUtils.insertMtype("QQHeadIcon", paramString + String.valueOf(640));
  }
  
  public static String e(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    if (paramInt1 == 4) {
      localStringBuilder.append("troop_").append(paramString);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 32) {
        localStringBuilder.append("stranger_").append(paramInt2).append("_").append(paramString);
      } else if (paramInt1 == 16) {
        localStringBuilder.append("qcall_").append(paramInt2).append("_").append(paramString);
      } else {
        localStringBuilder.append(paramString);
      }
    }
  }
  
  private void removeKey(String paramString)
  {
    localSet = this.cn;
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.cn.clear();
        if (this.cn.isEmpty())
        {
          this.app.removeObserver(this.q);
          this.bXu = false;
        }
        return;
      }
      finally {}
      this.cn.remove(paramString);
    }
  }
  
  public String d(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || ((paramInt != 200) && (paramInt != 202) && (paramInt != 204)))
    {
      afck.l("StrangerHdHeadUrlFetcher", new Object[] { "uinOrMobileNum is null or empty" });
      return "";
    }
    String str2 = e(32, paramInt, paramString);
    String str1 = (String)this.fb.get(str2);
    if (TextUtils.isEmpty(str1))
    {
      ??? = (Setting)this.mEntityManager.find(Setting.class, str2);
      if ((??? != null) && (!TextUtils.isEmpty(((Setting)???).url)))
      {
        str1 = a(32, ((Setting)???).url, ((Setting)???).bHeadType, ((Setting)???).bFaceFlags);
        this.fb.put(str2, str1);
      }
    }
    for (;;)
    {
      synchronized (this.cn)
      {
        this.cn.remove(str2);
        ThreadManager.post(new StrangerHdHeadUrlFetcher.1(this, paramString, paramInt, paramBoolean, str2), 8, null, false);
        return str1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l = Math.abs(System.currentTimeMillis() - this.Xk);
      if ((l < 0L) || (l > 60000L)) {
        removeKey(null);
      } else if (!this.cn.isEmpty()) {
        this.b.sendEmptyMessageAtTime(1, 60000L);
      }
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.cn)
    {
      this.app.removeObserver(this.q);
      this.bXu = false;
      this.cn.clear();
      this.fb.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */