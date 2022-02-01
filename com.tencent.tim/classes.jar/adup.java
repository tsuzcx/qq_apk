import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adup
{
  public static final String TAG = aduq.class.getSimpleName() + "." + adup.class.getSimpleName();
  public adup.b[] a = new adup.b[6];
  
  public adup.b a(AppInterface paramAppInterface, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 6) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.a[i];
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null)
    {
      paramAppInterface = (AppInterface)localObject;
      switch (i)
      {
      default: 
        paramAppInterface = (AppInterface)localObject;
      }
    }
    for (;;)
    {
      localObject = paramAppInterface;
      if (paramAppInterface == null) {
        localObject = new adup.a();
      }
      this.a[i] = localObject;
      return localObject;
      paramAppInterface = new isa();
      continue;
      paramAppInterface = new adbq();
    }
  }
  
  public static class a
    implements adup.b
  {
    public final String TAG = adup.TAG + "." + getClass().getSimpleName();
    
    public static final String aQ(String paramString1, String paramString2)
    {
      return advk.sX() + File.separator + "_res/" + paramString1;
    }
    
    public String a(aduq.a parama)
    {
      return advk.sX() + File.separator + "_res/" + parama.md5 + File.separator;
    }
    
    public boolean a(aduq.a parama)
    {
      String str = b(parama);
      try
      {
        boolean bool = new File(str).exists();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "needDownload.file exist|" + bool + "|" + parama + "|" + str);
        }
        if (!bool) {
          return true;
        }
      }
      catch (Throwable parama)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "isNeedDownload.exception happen.e=" + parama.getMessage());
        }
        parama.printStackTrace();
      }
      return false;
    }
    
    public boolean a(aduq.a parama, boolean paramBoolean)
    {
      return true;
    }
    
    public String b(aduq.a parama)
    {
      return aQ(parama.md5, parama.bvD);
    }
    
    public boolean b(aduq.a parama)
    {
      boolean bool = true;
      String str = alab.getFileMD5String(b(parama));
      if (!parama.md5.equalsIgnoreCase(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 1, "checkDownloadFile.verify failed|" + str + "|" + parama);
        }
        bool = false;
      }
      return bool;
    }
  }
  
  public static abstract interface b
  {
    public abstract String a(aduq.a parama);
    
    public abstract boolean a(aduq.a parama);
    
    public abstract boolean a(aduq.a parama, boolean paramBoolean);
    
    public abstract String b(aduq.a parama);
    
    public abstract boolean b(aduq.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adup
 * JD-Core Version:    0.7.0.1
 */