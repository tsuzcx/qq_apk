import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class zsb
  extends zrv
{
  public zsb(PhotoCropActivity paramPhotoCropActivity)
  {
    super(paramPhotoCropActivity);
  }
  
  public void Ft(int paramInt)
  {
    this.a.getIntent().putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsb
 * JD-Core Version:    0.7.0.1
 */