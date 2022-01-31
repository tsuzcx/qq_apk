import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;

public class vth
  implements Runnable
{
  public vth(AIOImageListScene paramAIOImageListScene) {}
  
  public void run()
  {
    if ((this.a.a != null) && (!((AIOPhotoListAdapter)this.a.a).a(false))) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vth
 * JD-Core Version:    0.7.0.1
 */