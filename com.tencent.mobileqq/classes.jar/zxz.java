import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;

public class zxz
{
  private volatile int jdField_a_of_type_Int = 4;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private String b;
  private String c;
  private String d;
  
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
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 4;
  }
  
  public String c()
  {
    if (this.d == null) {
      this.d = bgjb.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.d;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      bgjb.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.d = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String d()
  {
    if (this.c == null) {
      this.c = bgjb.a(BaseApplicationImpl.getContext(), "subscribe_ad_livePageInfo_cache");
    }
    return this.c;
  }
  
  public void d(String paramString)
  {
    if (paramString != null) {
      bgjb.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.c = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */