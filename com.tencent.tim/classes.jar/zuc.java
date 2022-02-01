import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.HashMap;

public class zuc
  implements OtherCommonData
{
  public long Ly;
  public boolean btu;
  private boolean btv;
  public int cfh = (int)aopb.hm();
  public HashMap<String, PicInfo> selectedQzonePhotos;
  
  public boolean VO()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.btv;
  }
  
  public void a(boolean paramBoolean, PhotoCommonBaseData<zuc> paramPhotoCommonBaseData)
  {
    this.btv = paramBoolean;
    if (paramBoolean)
    {
      paramPhotoCommonBaseData.needMediaInfo = true;
      atao.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuc
 * JD-Core Version:    0.7.0.1
 */