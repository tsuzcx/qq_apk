import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class tvh
  implements Observer
{
  public tvh(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    label4:
    int i;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!(paramObject instanceof TroopUploadingThread.UploadState));
          paramObservable = (TroopUploadingThread.UploadState)paramObject;
        } while (paramObservable.a == 0);
        this.a.jdField_a_of_type_AndroidOsHandler.post(new tvi(this, paramObservable));
      } while ((paramObservable.a != 1) || (paramObservable.c < 0) || (this.a.jdField_a_of_type_AndroidNetUri == null));
      paramObject = ImageUtil.b(this.a, this.a.jdField_a_of_type_AndroidNetUri);
      i = AvatarWallAdapter.b(paramObject, AbsDownloader.d(AvatarTroopUtil.b(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1))));
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "origin photo,result:" + i);
      }
      i = AvatarWallAdapter.a(paramObject, AbsDownloader.d(AvatarTroopUtil.a(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1))));
    } while (!QLog.isColorLevel());
    QLog.d("Q.troopinfo", 2, "thumb photo,result:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */