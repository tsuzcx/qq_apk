import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class mtd
  implements kxv.a
{
  mtd(mtc.a parama, HashMap paramHashMap) {}
  
  public void b(kxz paramkxz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + mtc.access$000().get() + ", vid = " + paramkxz.vid);
    }
    if ((mtc.access$000().get()) || (!this.a.vid.equals(paramkxz.vid))) {}
    for (;;)
    {
      return;
      paramkxz = paramkxz.ko.iterator();
      while (paramkxz.hasNext())
      {
        kxz localkxz = (kxz)paramkxz.next();
        if ((localkxz.aiJ) && (!TextUtils.isEmpty(localkxz.adD)) && (localkxz.adD.equals(String.valueOf(this.a.bitrate))))
        {
          this.a.width = localkxz.width;
          this.a.height = localkxz.height;
          mtc.b(this.a, localkxz.url, this.ei, this.a.wI);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.a.tag);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtd
 * JD-Core Version:    0.7.0.1
 */