import android.os.Handler;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import java.util.Observable;
import java.util.Observer;

public class gyh
  implements Observer
{
  public gyh(AvatarWallAdapter paramAvatarWallAdapter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    label4:
    do
    {
      int i;
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!(paramObject instanceof TroopUploadingThread.UploadState));
          i = this.a.b - this.a.j;
        } while (i >= 8);
        paramObservable = (TroopUploadingThread.UploadState)paramObject;
        if (paramObservable.a == 0)
        {
          this.a.a(paramObservable.b, i);
          return;
        }
        this.a.a.post(new gyi(this, paramObject));
      } while ((paramObservable.a != 1) || (paramObservable.c < 0));
      paramObject = (AvatarWallAdapter.AvatarInfo)this.a.getItem(i);
    } while ((paramObject == null) || (paramObject.a == null));
    paramObject = paramObject.a;
    String str = AbsDownloader.d(AvatarTroopUtil.b(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
    this.a.a(paramObject, str);
    paramObservable = AbsDownloader.d(AvatarTroopUtil.a(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
    this.a.a(paramObject, paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyh
 * JD-Core Version:    0.7.0.1
 */