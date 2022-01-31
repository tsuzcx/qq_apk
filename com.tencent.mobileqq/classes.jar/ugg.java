import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.view.AlbumImageView;
import java.util.List;

class ugg
  extends Handler
{
  public ugg(ugc paramugc, Looper paramLooper)
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
      wsv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    } while ((ugc.a(this.a) != 1) || (ugc.a(this.a) == null));
    Object localObject = ugc.a(this.a);
    int i = ugc.a(this.a, (List)localObject, ugc.c(this.a));
    int j = ugc.a(this.a, (List)localObject, i + 1);
    if ((((List)localObject).size() <= 1) || (i == j) || (i < 0))
    {
      ugc.b(this.a);
      wsv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
      return;
    }
    ugc.a(this.a, j);
    paramMessage = (uer)((List)localObject).get(i);
    localObject = (uer)((List)localObject).get(j);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ugc.a(this.a));
    this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((uer)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ugc.a(this.a));
    paramMessage = AnimationUtils.loadAnimation(ugc.a(this.a), 2130772234);
    paramMessage.setAnimationListener(new ugh(this));
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
    wsv.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */