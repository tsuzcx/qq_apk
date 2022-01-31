import android.annotation.TargetApi;
import android.os.SystemClock;

@TargetApi(14)
public class ukz
  extends xos
{
  private int jdField_a_of_type_Int = 941000;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private String jdField_a_of_type_JavaLangString;
  private ulb jdField_a_of_type_Ulb;
  private String b;
  
  public ukz(String paramString1, String paramString2, ulb paramulb)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Ulb = paramulb;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.jdField_a_of_type_Ulb.a(941001, paramString, "");
    }
    for (;;)
    {
      wsv.d(uku.jdField_a_of_type_JavaLangString, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.jdField_a_of_type_Int) });
      xmx.g(this.jdField_a_of_type_JavaLangString);
      return;
      if (paramString.equals(String.valueOf(941002))) {
        this.jdField_a_of_type_Ulb.a(941002, paramString, "");
      } else {
        this.jdField_a_of_type_Ulb.a(this.jdField_a_of_type_Int, paramString, "");
      }
    }
  }
  
  public void onSuccess(String paramString)
  {
    wsv.a(uku.jdField_a_of_type_JavaLangString, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Ulb.a(0, "", this.b);
    xmx.g(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukz
 * JD-Core Version:    0.7.0.1
 */