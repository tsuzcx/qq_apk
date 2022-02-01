import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahxr
{
  public boolean ciP;
  public AtomicBoolean da = new AtomicBoolean(false);
  public int engine;
  public Bitmap fl;
  public Bitmap fm;
  public int id;
  public boolean isDownloading;
  public String name;
  public int progress;
  public String tag;
  public long validTime;
  
  public int Fr()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.tag)) {
      if (!this.tag.startsWith("act")) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.Item", 2, "getTagType id = " + this.id + " type = " + i);
      }
      return i;
      if (this.tag.startsWith("free"))
      {
        String[] arrayOfString = this.tag.split("-");
        if ((arrayOfString.length >= 3) && (!TextUtils.isEmpty(arrayOfString[1])) && (TextUtils.isDigitsOnly(arrayOfString[1])) && (!TextUtils.isEmpty(arrayOfString[2])) && (TextUtils.isDigitsOnly(arrayOfString[2])))
        {
          long l1 = Long.parseLong(arrayOfString[1]);
          long l2 = Long.parseLong(arrayOfString[2]);
          long l3 = NetConnInfoCenter.getServerTime();
          if ((l3 > l1) && (l3 < l2))
          {
            i = 2;
            continue;
          }
        }
      }
      i = 0;
    }
  }
  
  public String toString()
  {
    return "HiBoomItem: id = " + this.id + " name = " + this.name + " engine = " + this.engine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxr
 * JD-Core Version:    0.7.0.1
 */