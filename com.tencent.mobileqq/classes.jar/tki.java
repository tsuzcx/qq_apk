import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class tki
  extends SimpleObserver<List<tfv>>
{
  tki(tkh paramtkh, tka paramtka) {}
  
  public void a(List<tfv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    tjt localtjt = new tjt(tkh.a(this.jdField_a_of_type_Tkh));
    localtjt.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      tfv localtfv = (tfv)localIterator.next();
      String str = localtfv.jdField_a_of_type_JavaLangString;
      localtjt.jdField_a_of_type_JavaUtilMap.put(localtfv.b, str);
      localtjt.jdField_a_of_type_JavaUtilList.add(localtfv.b);
    }
    paramList = tkf.a(paramList);
    if ((paramList != null) && (!tkh.a(this.jdField_a_of_type_Tkh).a())) {
      localtjt.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localtjt);
    paramList = this.jdField_a_of_type_Tka;
    if (!tkh.a(this.jdField_a_of_type_Tkh).a()) {}
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
    paramError.add(tkh.a(this.jdField_a_of_type_Tkh));
    this.jdField_a_of_type_Tka.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tki
 * JD-Core Version:    0.7.0.1
 */