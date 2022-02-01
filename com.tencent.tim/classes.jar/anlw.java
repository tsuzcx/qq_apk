import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import java.util.Iterator;
import java.util.List;

public class anlw
  implements anlv
{
  private anlv jdField_a_of_type_Anlv;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private LoadParam a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.mLoadItems.add(paramLoadItem);
    localLoadParam.mReportSeq = paramLoadParam.mReportSeq;
    localLoadParam.mCallType = paramLoadParam.mCallType;
    return localLoadParam;
  }
  
  private void a(LoadParam paramLoadParam, anlz paramanlz, int paramInt)
  {
    LoadParam localLoadParam = a(paramLoadParam, (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(paramInt));
    this.jdField_a_of_type_Anlv = new anlp();
    this.jdField_a_of_type_Anlv.a(localLoadParam, new anlx(this, paramInt, paramLoadParam, paramanlz));
  }
  
  public void QI(String paramString)
  {
    if (this.jdField_a_of_type_Anlv != null) {
      this.jdField_a_of_type_Anlv.QI(paramString);
    }
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Object localObject = null;
    Iterator localIterator = paramLoadParam.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramLoadParam, (LoadParam.LoadItem)localIterator.next());
      this.jdField_a_of_type_Anlv = new anlp();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_Anlv.a((LoadParam)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(LoadParam paramLoadParam, anlz paramanlz)
  {
    a(paramLoadParam, paramanlz, 0);
  }
  
  public boolean pr(String paramString)
  {
    if (this.jdField_a_of_type_Anlv != null) {
      return this.jdField_a_of_type_Anlv.pr(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlw
 * JD-Core Version:    0.7.0.1
 */