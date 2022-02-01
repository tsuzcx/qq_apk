import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class vuz
  implements aadu<QCircleBaseRequest>
{
  private final int jdField_a_of_type_Int;
  private final WeakReference<aadt> jdField_a_of_type_JavaLangRefWeakReference;
  private final List<aadq> jdField_a_of_type_JavaUtilList;
  private final List<aadr> b;
  
  public vuz(List<aadq> paramList, List<aadr> paramList1, WeakReference<aadt> paramWeakReference, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest)
  {
    if (paramQCircleBaseRequest == null)
    {
      QLog.d("QCircleSendChain", 1, "addRequest is null");
      return;
    }
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.d("QCircleSendChain", 1, "handleIndex over interceptors's size");
      return;
    }
    ((aadq)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(paramQCircleBaseRequest, new vuz(this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int + 1));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject)
  {
    Object localObject;
    if (this.b != null)
    {
      QLog.d("QCircleSendChain", 1, "handleRsp reqInterceptors");
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aadr)((Iterator)localObject).next()).a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject, this);
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (aadt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((aadt)localObject).a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuz
 * JD-Core Version:    0.7.0.1
 */