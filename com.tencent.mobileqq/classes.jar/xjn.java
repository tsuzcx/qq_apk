import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class xjn
  extends SimpleObserver<List<xfb>>
{
  xjn(xjm paramxjm, xjf paramxjf) {}
  
  public void a(List<xfb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    xiy localxiy = new xiy(xjm.a(this.jdField_a_of_type_Xjm));
    localxiy.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xfb localxfb = (xfb)localIterator.next();
      String str = localxfb.jdField_a_of_type_JavaLangString;
      localxiy.jdField_a_of_type_JavaUtilMap.put(localxfb.b, str);
      localxiy.jdField_a_of_type_JavaUtilList.add(localxfb.b);
    }
    paramList = xjk.a(paramList);
    if ((paramList != null) && (!xjm.a(this.jdField_a_of_type_Xjm).a())) {
      localxiy.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localxiy);
    paramList = this.jdField_a_of_type_Xjf;
    if (!xjm.a(this.jdField_a_of_type_Xjm).a()) {}
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
    paramError.add(xjm.a(this.jdField_a_of_type_Xjm));
    this.jdField_a_of_type_Xjf.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */