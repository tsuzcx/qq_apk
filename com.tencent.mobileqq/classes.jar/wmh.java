import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class wmh
  extends SimpleObserver<List<wzh>>
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  wmh(wmd paramwmd) {}
  
  public void a(List<wzh> paramList)
  {
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      wzh localwzh = (wzh)paramList.get(i);
      if (!localwzh.a) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localwzh.b);
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
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.jdField_a_of_type_Wmd.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onError(@NonNull Error paramError)
  {
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.jdField_a_of_type_Wmd.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmh
 * JD-Core Version:    0.7.0.1
 */