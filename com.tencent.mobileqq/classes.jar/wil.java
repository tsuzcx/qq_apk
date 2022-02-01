import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wil
  extends QQUIEventReceiver<wik, wfz>
{
  public wil(@NonNull wik paramwik)
  {
    super(paramwik);
  }
  
  public void a(@NonNull wik paramwik, @NonNull wfz paramwfz)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramwfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yuk.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramwfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramwik.d();
      bool1 = bool2;
    }
    for (;;)
    {
      wik.a(paramwik).a(bool1);
      return;
      yuk.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramwfz.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramwik.a(paramwfz.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramwfz.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wfz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wil
 * JD-Core Version:    0.7.0.1
 */