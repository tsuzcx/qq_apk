import android.text.TextUtils;

public class wyn
{
  public int a;
  public String a;
  public int b;
  
  public wyn()
  {
    this.jdField_a_of_type_JavaLangString = "";
    wta localwta = (wta)wth.a(10);
    String str = zof.a();
    this.jdField_a_of_type_JavaLangString = ((String)localwta.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = ((Integer)localwta.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int))).intValue();
    this.b = ((Integer)localwta.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.b))).intValue();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localwta.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localwta.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
    yuk.a(wyd.b(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Int += 1;
    ((wta)wth.a(10)).b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    yuk.a(wyd.b(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    b();
    yuk.a(wyd.b(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_Int < this.b;
  }
  
  public void b()
  {
    String str = zof.a();
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString))
    {
      wta localwta = (wta)wth.a(10);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localwta.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localwta.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */