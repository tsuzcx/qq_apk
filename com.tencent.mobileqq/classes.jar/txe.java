import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class txe
  extends SimpleObserver<List<tsr>>
{
  txe(txd paramtxd, tww paramtww) {}
  
  public void a(List<tsr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    twp localtwp = new twp(txd.a(this.jdField_a_of_type_Txd));
    localtwp.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      tsr localtsr = (tsr)localIterator.next();
      String str = localtsr.jdField_a_of_type_JavaLangString;
      localtwp.jdField_a_of_type_JavaUtilMap.put(localtsr.b, str);
      localtwp.jdField_a_of_type_JavaUtilList.add(localtsr.b);
    }
    paramList = txb.a(paramList);
    if ((paramList != null) && (!txd.a(this.jdField_a_of_type_Txd).a())) {
      localtwp.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localtwp);
    paramList = this.jdField_a_of_type_Tww;
    if (!txd.a(this.jdField_a_of_type_Txd).a()) {}
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
    paramError.add(txd.a(this.jdField_a_of_type_Txd));
    this.jdField_a_of_type_Tww.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txe
 * JD-Core Version:    0.7.0.1
 */