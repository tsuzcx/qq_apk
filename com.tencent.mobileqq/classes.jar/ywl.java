import android.os.Handler;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class ywl
  implements zcm
{
  ywl(ywh paramywh) {}
  
  public void a(int paramInt, List<wum> paramList)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    wjj.a().dispatch(new zck(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywl
 * JD-Core Version:    0.7.0.1
 */