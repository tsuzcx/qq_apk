import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class uug
  extends SimpleObserver<List<vhg>>
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  uug(uuc paramuuc) {}
  
  public void a(List<vhg> paramList)
  {
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      vhg localvhg = (vhg)paramList.get(i);
      if (!localvhg.a) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localvhg.b);
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
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.jdField_a_of_type_Uuc.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onError(@NonNull Error paramError)
  {
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.jdField_a_of_type_Uuc.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uug
 * JD-Core Version:    0.7.0.1
 */