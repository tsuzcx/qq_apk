import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class wot
  extends SimpleObserver<List<wkm>>
{
  wot(wos paramwos, wol paramwol) {}
  
  public void a(List<wkm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    woe localwoe = new woe(wos.a(this.jdField_a_of_type_Wos));
    localwoe.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      wkm localwkm = (wkm)localIterator.next();
      String str = localwkm.jdField_a_of_type_JavaLangString;
      localwoe.jdField_a_of_type_JavaUtilMap.put(localwkm.b, str);
      localwoe.jdField_a_of_type_JavaUtilList.add(localwkm.b);
    }
    paramList = woq.a(paramList);
    if ((paramList != null) && (!wos.a(this.jdField_a_of_type_Wos).a())) {
      localwoe.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localwoe);
    paramList = this.jdField_a_of_type_Wol;
    if (!wos.a(this.jdField_a_of_type_Wos).a()) {}
    for (boolean bool = true;; bool = false)
    {
      paramList.a(localArrayList, bool);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    int i = 0;
    if ((paramError instanceof ErrorMessage)) {
      i = ((ErrorMessage)paramError).errorCode;
    }
    paramError = new ArrayList();
    paramError.add(wos.a(this.jdField_a_of_type_Wos));
    this.jdField_a_of_type_Wol.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wot
 * JD-Core Version:    0.7.0.1
 */