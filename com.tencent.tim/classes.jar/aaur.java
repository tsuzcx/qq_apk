import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.cache.SDCardMountMonitorReceiver.a;
import java.io.File;

public class aaur
  implements SDCardMountMonitorReceiver.a
{
  private static final Object LOCK_mInstance = new Object();
  private static aaur jdField_a_of_type_Aaur;
  private String JE = "";
  private aaur.a jdField_a_of_type_Aaur$a;
  
  private aaur()
  {
    ahJ();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static aaur a()
  {
    if (jdField_a_of_type_Aaur == null) {}
    synchronized (LOCK_mInstance)
    {
      if (jdField_a_of_type_Aaur == null) {
        jdField_a_of_type_Aaur = new aaur();
      }
      return jdField_a_of_type_Aaur;
    }
  }
  
  private void ahJ()
  {
    this.JE = avsu.Gj();
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.JE);
    }
    try
    {
      File localFile = new File(this.JE);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StorageManager", 2, "create root path directory error", localException);
    }
  }
  
  public String fW()
  {
    return this.JE;
  }
  
  public void hg(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + paramBoolean);
    }
    String str = avsu.Gj();
    if ((this.jdField_a_of_type_Aaur$a != null) && (!str.equals(this.JE)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Aaur$a.H(1, this.JE);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Aaur$a.H(0, this.JE);
  }
  
  public static abstract interface a
  {
    public abstract void H(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaur
 * JD-Core Version:    0.7.0.1
 */