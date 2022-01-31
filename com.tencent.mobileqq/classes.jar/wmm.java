import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class wmm
  implements urr<vft, vfu>
{
  wmm(wml paramwml, boolean paramBoolean) {}
  
  public void a(@NonNull vft paramvft, @Nullable vfu arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (wml.a(this.jdField_a_of_type_Wml).get())
    {
      wxe.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    wxe.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramvft = new wmo(this.jdField_a_of_type_Wml, paramErrorMessage);
    paramvft.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      umc.a().dispatch(paramvft);
      return;
    }
    paramvft.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((uvn)uwa.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Wml)
    {
      umc.a().dispatch(paramvft);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmm
 * JD-Core Version:    0.7.0.1
 */