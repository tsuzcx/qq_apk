import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class vqc
  extends SimpleObserver<List<vlp>>
{
  vqc(vqb paramvqb, vpu paramvpu) {}
  
  public void a(List<vlp> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    vpn localvpn = new vpn(vqb.a(this.jdField_a_of_type_Vqb));
    localvpn.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vlp localvlp = (vlp)localIterator.next();
      String str = localvlp.jdField_a_of_type_JavaLangString;
      localvpn.jdField_a_of_type_JavaUtilMap.put(localvlp.b, str);
      localvpn.jdField_a_of_type_JavaUtilList.add(localvlp.b);
    }
    paramList = vpz.a(paramList);
    if ((paramList != null) && (!vqb.a(this.jdField_a_of_type_Vqb).a())) {
      localvpn.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localvpn);
    paramList = this.jdField_a_of_type_Vpu;
    if (!vqb.a(this.jdField_a_of_type_Vqb).a()) {}
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
    paramError.add(vqb.a(this.jdField_a_of_type_Vqb));
    this.jdField_a_of_type_Vpu.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqc
 * JD-Core Version:    0.7.0.1
 */