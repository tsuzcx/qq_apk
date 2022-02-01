import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.SharePreferenceUtils;

public class zoz
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
    if (this.b == null) {
      this.b = SharePreferenceUtils.get(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.b;
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
    if (paramString != null) {
      SharePreferenceUtils.set(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.b = paramString;
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
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = SharePreferenceUtils.get(BaseApplicationImpl.getContext(), "subscribe_ad_livePageInfo_cache");
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      SharePreferenceUtils.set(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoz
 * JD-Core Version:    0.7.0.1
 */