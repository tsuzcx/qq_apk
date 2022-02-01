import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class weq
  extends QQUIEventReceiver<wep, wce>
{
  public weq(@NonNull wep paramwep)
  {
    super(paramwep);
  }
  
  public void a(@NonNull wep paramwep, @NonNull wce paramwce)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramwce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yqp.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramwce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramwep.d();
      bool1 = bool2;
    }
    for (;;)
    {
      wep.a(paramwep).a(bool1);
      return;
      yqp.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramwce.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramwep.a(paramwce.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramwce.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weq
 * JD-Core Version:    0.7.0.1
 */