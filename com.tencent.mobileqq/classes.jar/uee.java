import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class uee
{
  static volatile uee jdField_a_of_type_Uee;
  Context jdField_a_of_type_AndroidContentContext;
  uef jdField_a_of_type_Uef;
  
  private uee(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static uee a(Context paramContext)
  {
    if (jdField_a_of_type_Uee == null) {}
    try
    {
      if (jdField_a_of_type_Uee == null) {
        jdField_a_of_type_Uee = new uee(paramContext);
      }
      return jdField_a_of_type_Uee;
    }
    finally {}
  }
  
  public uef a()
  {
    if (this.jdField_a_of_type_Uef == null) {
      this.jdField_a_of_type_Uef = new uef();
    }
    return this.jdField_a_of_type_Uef;
  }
  
  public void a()
  {
    TVK_SDKMgr.setOnLogListener(a());
  }
  
  public void a(Context paramContext)
  {
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */