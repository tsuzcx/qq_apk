import android.os.Handler;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class utl
  implements uzm
{
  utl(uth paramuth) {}
  
  public void a(int paramInt, List<srl> paramList)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    sgi.a().dispatch(new uzk(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utl
 * JD-Core Version:    0.7.0.1
 */