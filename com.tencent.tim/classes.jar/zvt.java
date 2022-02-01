import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class zvt
  extends ztv
{
  zvt(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    ((zuc)this.mOtherCommonData).cfh = 6291456;
    paramIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvt
 * JD-Core Version:    0.7.0.1
 */