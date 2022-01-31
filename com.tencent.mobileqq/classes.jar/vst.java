import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class vst
{
  static volatile vst jdField_a_of_type_Vst;
  Context jdField_a_of_type_AndroidContentContext;
  vsu jdField_a_of_type_Vsu;
  
  private vst(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static vst a(Context paramContext)
  {
    if (jdField_a_of_type_Vst == null) {}
    try
    {
      if (jdField_a_of_type_Vst == null) {
        jdField_a_of_type_Vst = new vst(paramContext);
      }
      return jdField_a_of_type_Vst;
    }
    finally {}
  }
  
  public vsu a()
  {
    if (this.jdField_a_of_type_Vsu == null) {
      this.jdField_a_of_type_Vsu = new vsu();
    }
    return this.jdField_a_of_type_Vsu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vst
 * JD-Core Version:    0.7.0.1
 */