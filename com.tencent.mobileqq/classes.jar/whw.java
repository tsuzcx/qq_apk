import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.view.AlbumImageView;
import java.util.List;

class whw
  extends Handler
{
  public whw(whs paramwhs, Looper paramLooper)
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
      yuk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    } while ((whs.a(this.a) != 1) || (whs.a(this.a) == null));
    Object localObject = whs.a(this.a);
    int i = whs.a(this.a, (List)localObject, whs.c(this.a));
    int j = whs.a(this.a, (List)localObject, i + 1);
    if ((((List)localObject).size() <= 1) || (i == j) || (i < 0))
    {
      whs.b(this.a);
      yuk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
      return;
    }
    whs.a(this.a, j);
    paramMessage = (wgh)((List)localObject).get(i);
    localObject = (wgh)((List)localObject).get(j);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, whs.a(this.a));
    this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((wgh)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, whs.a(this.a));
    paramMessage = AnimationUtils.loadAnimation(whs.a(this.a), 2130772244);
    paramMessage.setAnimationListener(new whx(this));
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
    yuk.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whw
 * JD-Core Version:    0.7.0.1
 */