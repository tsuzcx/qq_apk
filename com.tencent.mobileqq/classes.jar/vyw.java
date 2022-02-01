import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.view.AlbumImageView;
import java.util.List;

class vyw
  extends Handler
{
  public vyw(vys paramvys, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      ykq.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    } while ((vys.a(this.a) != 1) || (vys.a(this.a) == null));
    Object localObject = vys.a(this.a);
    int i = vys.a(this.a, (List)localObject, vys.c(this.a));
    int j = vys.a(this.a, (List)localObject, i + 1);
    if ((((List)localObject).size() <= 1) || (i == j) || (i < 0))
    {
      vys.b(this.a);
      ykq.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
      return;
    }
    vys.a(this.a, j);
    paramMessage = (vxh)((List)localObject).get(i);
    localObject = (vxh)((List)localObject).get(j);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, vys.a(this.a));
    this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((vxh)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, vys.a(this.a));
    paramMessage = AnimationUtils.loadAnimation(vys.a(this.a), 2130772241);
    paramMessage.setAnimationListener(new vyx(this));
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
    ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyw
 * JD-Core Version:    0.7.0.1
 */