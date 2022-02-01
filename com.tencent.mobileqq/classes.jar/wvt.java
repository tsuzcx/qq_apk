import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class wvt
{
  static volatile wvt jdField_a_of_type_Wvt;
  Context jdField_a_of_type_AndroidContentContext;
  wvu jdField_a_of_type_Wvu;
  
  private wvt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static wvt a(Context paramContext)
  {
    if (jdField_a_of_type_Wvt == null) {}
    try
    {
      if (jdField_a_of_type_Wvt == null) {
        jdField_a_of_type_Wvt = new wvt(paramContext);
      }
      return jdField_a_of_type_Wvt;
    }
    finally {}
  }
  
  public wvu a()
  {
    if (this.jdField_a_of_type_Wvu == null) {
      this.jdField_a_of_type_Wvu = new wvu();
    }
    return this.jdField_a_of_type_Wvu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvt
 * JD-Core Version:    0.7.0.1
 */