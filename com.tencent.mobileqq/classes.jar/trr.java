import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class trr
{
  public long a;
  public AdvertisementInfo a;
  public String a;
  public boolean a;
  public long b;
  public long c;
  public long d;
  
  public void a(Bundle paramBundle)
  {
    long l1;
    long l2;
    long l3;
    if (paramBundle != null)
    {
      String str = paramBundle.getString("adid", "");
      l1 = paramBundle.getLong("navigationStart", 0L);
      l2 = paramBundle.getLong("htmlLoaded", 0L);
      l3 = paramBundle.getLong("domComplete", 0L);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.equals(this.jdField_a_of_type_JavaLangString))) {
        break label71;
      }
    }
    label71:
    do
    {
      return;
      if (l1 > 0L) {
        this.b = l1;
      }
      if (l2 > 0L) {
        this.c = l2;
      }
    } while (l3 <= 0L);
    this.d = l3;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Long > 0L) && ((this.b > 0L) || (this.c > 0L) || (this.d > 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trr
 * JD-Core Version:    0.7.0.1
 */