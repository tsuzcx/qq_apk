import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class wvw
  extends SimpleObserver<List<xiw>>
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  wvw(wvs paramwvs) {}
  
  public void a(List<xiw> paramList)
  {
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      xiw localxiw = (xiw)paramList.get(i);
      if (!localxiw.a) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localxiw.b);
      }
      i += 1;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onComplete()
  {
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.jdField_a_of_type_Wvs.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onError(@NonNull Error paramError)
  {
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.jdField_a_of_type_Wvs.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvw
 * JD-Core Version:    0.7.0.1
 */