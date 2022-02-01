import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class uqu
  implements uyg
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  
  uqu(String paramString, KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    uqf.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      uqf.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(URL paramURL, suk paramsuk)
  {
    uqf.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL != null)
      {
        uhc.b(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        paramsuk = beqz.a(paramURL.toString());
        if (paramsuk != null)
        {
          String str = paramsuk.getAbsolutePath();
          long l2 = paramsuk.length();
          uqf.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          if ("feeds".equals(this.jdField_a_of_type_JavaLangString)) {
            uoc.a().a(true, l1, l2);
          }
          uoc.a().a(true, l1, l2, paramURL.toString(), this.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqu
 * JD-Core Version:    0.7.0.1
 */