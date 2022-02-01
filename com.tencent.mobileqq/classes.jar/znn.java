import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDefaultDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;

public class znn
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RFWDownloadStrategy jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private znn(znp paramznp)
  {
    if (!TextUtils.isEmpty(znp.a(paramznp))) {
      this.jdField_a_of_type_JavaLangString = znp.a(paramznp);
    }
    this.jdField_a_of_type_Boolean = znp.a(paramznp);
    long l;
    int i;
    if (znp.a(paramznp) > 0L)
    {
      l = znp.a(paramznp);
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = znp.a(paramznp);
      if (znp.b(paramznp) <= 0) {
        break label107;
      }
      i = znp.b(paramznp);
      label69:
      this.jdField_b_of_type_Int = i;
      this.jdField_b_of_type_Boolean = znp.b(paramznp);
      if (znp.a(paramznp) == null) {
        break label113;
      }
    }
    label107:
    label113:
    for (paramznp = znp.a(paramznp);; paramznp = new RFWDefaultDownloadStrategy())
    {
      this.jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy = paramznp;
      return;
      l = 1000L;
      break;
      i = 50;
      break label69;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public RFWDownloadStrategy a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znn
 * JD-Core Version:    0.7.0.1
 */