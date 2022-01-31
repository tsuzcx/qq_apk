import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ugv
  extends QQUIEventReceiver<ugu, uej>
{
  public ugv(@NonNull ugu paramugu)
  {
    super(paramugu);
  }
  
  public void a(@NonNull ugu paramugu, @NonNull uej paramuej)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramuej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wsv.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramuej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramugu.d();
      bool1 = bool2;
    }
    for (;;)
    {
      ugu.a(paramugu).a(bool1);
      return;
      wsv.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramuej.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramugu.a(paramuej.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramuej.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uej.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */