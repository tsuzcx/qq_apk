import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class won
  implements wnz
{
  private String aTK;
  private String aTL;
  private int bgJ;
  private HashMap<Integer, wop> gJ;
  private Activity mActivity;
  
  public won(@NonNull Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.gJ = new HashMap();
    this.bgJ = 0;
  }
  
  public boolean d(int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FriendShipViewManager", 1, "play , url = " + paramString1 + " md5:" + paramString2);
    this.aTK = paramString1;
    this.aTL = paramString2;
    if (this.aTK != null) {
      this.aTK = this.aTK.trim();
    }
    if (this.aTL != null) {
      this.aTL = this.aTL.trim();
    }
    gq(3);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnDestroy");
    }
    Iterator localIterator = this.gJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null)
      {
        ((wop)localEntry.getValue()).cancel();
        ((wop)localEntry.getValue()).doOnDestroy();
      }
    }
    this.gJ.clear();
    this.bgJ = 0;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnPause");
    }
    wop localwop = (wop)this.gJ.get(Integer.valueOf(this.bgJ));
    if (localwop != null) {
      localwop.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnResume");
    }
    wop localwop = (wop)this.gJ.get(Integer.valueOf(this.bgJ));
    if (localwop != null) {
      localwop.doOnResume();
    }
  }
  
  public boolean gq(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "play anim " + paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    wop localwop = (wop)this.gJ.get(Integer.valueOf(this.bgJ));
    if (localwop != null)
    {
      localwop.cancel();
      localwop.doOnDestroy();
      this.gJ.put(Integer.valueOf(this.bgJ), null);
      this.bgJ = 0;
    }
    localwop = (wop)this.gJ.get(Integer.valueOf(paramInt));
    if (localwop == null)
    {
      localwop = wol.a(paramInt, this.mActivity);
      if (localwop == null) {
        return false;
      }
      this.gJ.put(Integer.valueOf(paramInt), localwop);
    }
    for (;;)
    {
      if ((localwop instanceof wog)) {
        ((wog)localwop).dA(this.aTK, this.aTL);
      }
      localwop.a(new woo(this, localwop));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     won
 * JD-Core Version:    0.7.0.1
 */