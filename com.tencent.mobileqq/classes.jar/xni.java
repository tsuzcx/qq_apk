import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class xni
  extends SimpleObserver<List<xiw>>
{
  xni(xnh paramxnh, xna paramxna) {}
  
  public void a(List<xiw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    xmt localxmt = new xmt(xnh.a(this.jdField_a_of_type_Xnh));
    localxmt.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xiw localxiw = (xiw)localIterator.next();
      String str = localxiw.jdField_a_of_type_JavaLangString;
      localxmt.jdField_a_of_type_JavaUtilMap.put(localxiw.b, str);
      localxmt.jdField_a_of_type_JavaUtilList.add(localxiw.b);
    }
    paramList = xnf.a(paramList);
    if ((paramList != null) && (!xnh.a(this.jdField_a_of_type_Xnh).a())) {
      localxmt.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localxmt);
    paramList = this.jdField_a_of_type_Xna;
    if (!xnh.a(this.jdField_a_of_type_Xnh).a()) {}
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
    paramError.add(xnh.a(this.jdField_a_of_type_Xnh));
    this.jdField_a_of_type_Xna.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xni
 * JD-Core Version:    0.7.0.1
 */