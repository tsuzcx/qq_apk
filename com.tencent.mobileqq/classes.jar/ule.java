import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ule
  extends QQUIEventReceiver<uld, uis>
{
  public ule(@NonNull uld paramuld)
  {
    super(paramuld);
  }
  
  public void a(@NonNull uld paramuld, @NonNull uis paramuis)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramuis.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wxe.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramuis.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramuld.d();
      bool1 = bool2;
    }
    for (;;)
    {
      uld.a(paramuld).a(bool1);
      return;
      wxe.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramuis.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramuld.a(paramuis.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramuis.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uis.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ule
 * JD-Core Version:    0.7.0.1
 */