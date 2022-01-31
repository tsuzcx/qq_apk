import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class txq
  implements twi
{
  public final String a;
  public final List<String> a;
  private twj jdField_a_of_type_Twj;
  private twm jdField_a_of_type_Twm;
  private two jdField_a_of_type_Two;
  
  public txq(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Twj = new twj();
    this.jdField_a_of_type_Twj.b = true;
    this.jdField_a_of_type_Twj.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Twm = new twm(new twl("TROOP_GROUD_ID"));
    this.jdField_a_of_type_Twm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, "TROOP_FEED_ID");
    this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Twm);
    this.jdField_a_of_type_Two = new two(new twl("TROOP_GROUD_ID"), this.jdField_a_of_type_JavaLangString, "TROOP_FEED_ID");
    this.jdField_a_of_type_Two.jdField_a_of_type_Twm = this.jdField_a_of_type_Twm;
  }
  
  public twj a(@Nullable twl paramtwl, int paramInt)
  {
    return this.jdField_a_of_type_Twj;
  }
  
  public two a()
  {
    return this.jdField_a_of_type_Two;
  }
  
  public void a() {}
  
  public void a(@Nullable twl paramtwl, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(@Nullable twl paramtwl, String paramString) {}
  
  public void a(twn paramtwn) {}
  
  public void b() {}
  
  public void b(twn paramtwn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */