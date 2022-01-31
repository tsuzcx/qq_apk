import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class txb
  extends SimpleObserver<List<tso>>
{
  txb(txa paramtxa, twt paramtwt) {}
  
  public void a(List<tso> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    twm localtwm = new twm(txa.a(this.jdField_a_of_type_Txa));
    localtwm.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      tso localtso = (tso)localIterator.next();
      String str = localtso.jdField_a_of_type_JavaLangString;
      localtwm.jdField_a_of_type_JavaUtilMap.put(localtso.b, str);
      localtwm.jdField_a_of_type_JavaUtilList.add(localtso.b);
    }
    paramList = twy.a(paramList);
    if ((paramList != null) && (!txa.a(this.jdField_a_of_type_Txa).a())) {
      localtwm.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localtwm);
    paramList = this.jdField_a_of_type_Twt;
    if (!txa.a(this.jdField_a_of_type_Txa).a()) {}
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
    paramError.add(txa.a(this.jdField_a_of_type_Txa));
    this.jdField_a_of_type_Twt.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txb
 * JD-Core Version:    0.7.0.1
 */