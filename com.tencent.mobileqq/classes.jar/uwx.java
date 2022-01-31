import android.text.TextUtils;

public class uwx
{
  public int a;
  public String a;
  public int b;
  
  public uwx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    urk localurk = (urk)urr.a(10);
    String str = xmq.a();
    this.jdField_a_of_type_JavaLangString = ((String)localurk.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = ((Integer)localurk.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int))).intValue();
    this.b = ((Integer)localurk.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.b))).intValue();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localurk.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localurk.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
    wsv.a(uwn.b(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Int += 1;
    ((urk)urr.a(10)).b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    wsv.a(uwn.b(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    b();
    wsv.a(uwn.b(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_Int < this.b;
  }
  
  public void b()
  {
    String str = xmq.a();
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString))
    {
      urk localurk = (urk)urr.a(10);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localurk.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localurk.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwx
 * JD-Core Version:    0.7.0.1
 */