import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class tlw
  implements tpv
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  
  tlw(KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    tlo.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      tlo.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(URL paramURL, sfc paramsfc)
  {
    tlo.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL != null)
      {
        tfd.b(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        paramsfc = baqn.a(paramURL.toString());
        if (paramsfc != null)
        {
          String str = paramsfc.getAbsolutePath();
          long l2 = paramsfc.length();
          tlo.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          tjz.a().a(true, l1, l2);
        }
      }
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlw
 * JD-Core Version:    0.7.0.1
 */