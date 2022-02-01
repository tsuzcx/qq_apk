import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class xdo
  extends SimpleObserver<List<wzh>>
{
  xdo(xdn paramxdn, xdg paramxdg) {}
  
  public void a(List<wzh> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    xcz localxcz = new xcz(xdn.a(this.jdField_a_of_type_Xdn));
    localxcz.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      wzh localwzh = (wzh)localIterator.next();
      String str = localwzh.jdField_a_of_type_JavaLangString;
      localxcz.jdField_a_of_type_JavaUtilMap.put(localwzh.b, str);
      localxcz.jdField_a_of_type_JavaUtilList.add(localwzh.b);
    }
    paramList = xdl.a(paramList);
    if ((paramList != null) && (!xdn.a(this.jdField_a_of_type_Xdn).a())) {
      localxcz.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localxcz);
    paramList = this.jdField_a_of_type_Xdg;
    if (!xdn.a(this.jdField_a_of_type_Xdn).a()) {}
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
    paramError.add(xdn.a(this.jdField_a_of_type_Xdn));
    this.jdField_a_of_type_Xdg.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdo
 * JD-Core Version:    0.7.0.1
 */