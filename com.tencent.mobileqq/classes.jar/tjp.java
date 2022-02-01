import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.util.ArrayList;
import java.util.List;

public class tjp
{
  private final String jdField_a_of_type_JavaLangString;
  private List<BaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tjq jdField_a_of_type_Tjq;
  private List<BaseData> b = new ArrayList();
  
  public tjp(String paramString, tjq paramtjq)
  {
    this.jdField_a_of_type_Tjq = paramtjq;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Tjq != null)) {
        this.jdField_a_of_type_Tjq.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<BaseData> paramList)
  {
    this.b = paramList;
    ukq.a("REPORT_LINK", "requestAdData adDatas callback");
    a();
  }
  
  public void b(List<BaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    ukq.a("REPORT_LINK", "requestAdData recommendDatas callback");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjp
 * JD-Core Version:    0.7.0.1
 */