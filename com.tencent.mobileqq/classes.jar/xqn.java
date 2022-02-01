import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class xqn
{
  static volatile xqn jdField_a_of_type_Xqn;
  Context jdField_a_of_type_AndroidContentContext;
  xqo jdField_a_of_type_Xqo;
  
  private xqn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static xqn a(Context paramContext)
  {
    if (jdField_a_of_type_Xqn == null) {}
    try
    {
      if (jdField_a_of_type_Xqn == null) {
        jdField_a_of_type_Xqn = new xqn(paramContext);
      }
      return jdField_a_of_type_Xqn;
    }
    finally {}
  }
  
  public xqo a()
  {
    if (this.jdField_a_of_type_Xqo == null) {
      this.jdField_a_of_type_Xqo = new xqo();
    }
    return this.jdField_a_of_type_Xqo;
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
 * Qualified Name:     xqn
 * JD-Core Version:    0.7.0.1
 */