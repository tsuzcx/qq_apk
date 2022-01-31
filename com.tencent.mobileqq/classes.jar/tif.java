import android.text.TextUtils;

public class tif
{
  public int a;
  public String a;
  public int b;
  
  public tif()
  {
    this.jdField_a_of_type_JavaLangString = "";
    tcs localtcs = (tcs)tcz.a(10);
    String str = vxy.a();
    this.jdField_a_of_type_JavaLangString = ((String)localtcs.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = ((Integer)localtcs.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int))).intValue();
    this.b = ((Integer)localtcs.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.b))).intValue();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localtcs.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localtcs.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
    ved.a(thv.b(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Int += 1;
    ((tcs)tcz.a(10)).b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    ved.a(thv.b(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    b();
    ved.a(thv.b(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_Int < this.b;
  }
  
  public void b()
  {
    String str = vxy.a();
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString))
    {
      tcs localtcs = (tcs)tcz.a(10);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localtcs.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localtcs.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */