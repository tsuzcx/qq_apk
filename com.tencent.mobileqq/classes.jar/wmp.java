import android.annotation.TargetApi;
import android.os.SystemClock;

@TargetApi(14)
public class wmp
  extends zqh
{
  private int jdField_a_of_type_Int = 941000;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private String jdField_a_of_type_JavaLangString;
  private wmr jdField_a_of_type_Wmr;
  private String b;
  
  public wmp(String paramString1, String paramString2, wmr paramwmr)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Wmr = paramwmr;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.jdField_a_of_type_Wmr.a(941001, paramString, "");
    }
    for (;;)
    {
      yuk.d(wmk.jdField_a_of_type_JavaLangString, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.jdField_a_of_type_Int) });
      zom.g(this.jdField_a_of_type_JavaLangString);
      return;
      if (paramString.equals(String.valueOf(941002))) {
        this.jdField_a_of_type_Wmr.a(941002, paramString, "");
      } else {
        this.jdField_a_of_type_Wmr.a(this.jdField_a_of_type_Int, paramString, "");
      }
    }
  }
  
  public void onSuccess(String paramString)
  {
    yuk.a(wmk.jdField_a_of_type_JavaLangString, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Wmr.a(0, "", this.b);
    zom.g(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */