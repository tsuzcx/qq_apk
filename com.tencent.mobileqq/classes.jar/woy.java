import android.text.TextUtils;

public class woy
{
  public int a;
  public String a;
  public int b;
  
  public woy()
  {
    this.jdField_a_of_type_JavaLangString = "";
    wjl localwjl = (wjl)wjs.a(10);
    String str = zdu.a();
    this.jdField_a_of_type_JavaLangString = ((String)localwjl.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = ((Integer)localwjl.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int))).intValue();
    this.b = ((Integer)localwjl.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.b))).intValue();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localwjl.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localwjl.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
    ykq.a(woo.b(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Int += 1;
    ((wjl)wjs.a(10)).b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    ykq.a(woo.b(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    b();
    ykq.a(woo.b(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_Int < this.b;
  }
  
  public void b()
  {
    String str = zdu.a();
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString))
    {
      wjl localwjl = (wjl)wjs.a(10);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localwjl.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localwjl.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woy
 * JD-Core Version:    0.7.0.1
 */