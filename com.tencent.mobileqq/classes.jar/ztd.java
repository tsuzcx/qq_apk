import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage;

public class ztd
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public ztd(Oidb_0xcd1.EmptyPackagePage paramEmptyPackagePage)
  {
    this.jdField_a_of_type_Int = paramEmptyPackagePage.enable.get();
    this.jdField_a_of_type_JavaLangString = paramEmptyPackagePage.wording.get();
    this.b = paramEmptyPackagePage.jump_wording.get();
    this.c = paramEmptyPackagePage.jump_url.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztd
 * JD-Core Version:    0.7.0.1
 */