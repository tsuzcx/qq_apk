import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;

public class yeb
{
  private volatile int jdField_a_of_type_Int = 4;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private String b;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(COMM.StCommonExt paramStCommonExt)
  {
    this.jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public COMM.StCommonExt b()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public String b()
  {
    if (this.b == null) {
      this.b = bczr.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      bczr.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.b = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 4;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Int == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */