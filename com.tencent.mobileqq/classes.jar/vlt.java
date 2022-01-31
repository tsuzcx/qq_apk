import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class vlt
  extends SimpleObserver<List<vhg>>
{
  vlt(vls paramvls, vll paramvll) {}
  
  public void a(List<vhg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    vle localvle = new vle(vls.a(this.jdField_a_of_type_Vls));
    localvle.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vhg localvhg = (vhg)localIterator.next();
      String str = localvhg.jdField_a_of_type_JavaLangString;
      localvle.jdField_a_of_type_JavaUtilMap.put(localvhg.b, str);
      localvle.jdField_a_of_type_JavaUtilList.add(localvhg.b);
    }
    paramList = vlq.a(paramList);
    if ((paramList != null) && (!vls.a(this.jdField_a_of_type_Vls).a())) {
      localvle.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localvle);
    paramList = this.jdField_a_of_type_Vll;
    if (!vls.a(this.jdField_a_of_type_Vls).a()) {}
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
    paramError.add(vls.a(this.jdField_a_of_type_Vls));
    this.jdField_a_of_type_Vll.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlt
 * JD-Core Version:    0.7.0.1
 */