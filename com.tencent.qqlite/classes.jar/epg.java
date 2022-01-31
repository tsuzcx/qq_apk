import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

public class epg
  implements Observer
{
  public epg(AvatarWallAdapter paramAvatarWallAdapter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    label4:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label4;
                break label4;
                break label4;
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
              if ((paramObservable.c >= 0) && (paramObservable.c <= 1)) {
                this.a.h = false;
              }
              this.a.jdField_a_of_type_AndroidOsHandler.post(new eph(this, paramObservable));
            } while ((paramObservable.a != 1) || (paramObservable.c < 0));
            paramObject = this.a.a(i);
          } while ((paramObject == null) || (paramObject.jdField_a_of_type_JavaLangString == null));
          paramObject = paramObject.jdField_a_of_type_JavaLangString;
          String str = AbsDownloader.d(AvatarTroopUtil.b(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
          int i = this.a.b(paramObject, str);
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, "origin photo,result:" + i);
          }
          paramObservable = AbsDownloader.d(AvatarTroopUtil.a(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
          i = this.a.a(paramObject, paramObservable);
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, "thumb photo,result:" + i);
          }
        } while (this.a.h);
        this.a.h = true;
      } while (this.a.i);
      paramObservable = null;
      if (this.a.jdField_a_of_type_MqqUtilWeakReference != null) {
        paramObservable = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      }
    } while (paramObservable == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epg
 * JD-Core Version:    0.7.0.1
 */