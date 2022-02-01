import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;

public class vkb
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = true;
  int b;
  
  public vkb(WSPublicAccReport paramWSPublicAccReport) {}
  
  public int a()
  {
    this.jdField_a_of_type_Boolean = false;
    return this.b;
  }
  
  public long a()
  {
    this.jdField_a_of_type_Boolean = false;
    return System.currentTimeMillis() - WSPublicAccReport.access$000(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSPublicAccReport);
  }
  
  public void a(String paramString)
  {
    int i = 1;
    this.jdField_a_of_type_Int = 1;
    if (new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication).a(paramString)) {}
    for (;;)
    {
      this.b = i;
      return;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkb
 * JD-Core Version:    0.7.0.1
 */