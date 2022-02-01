import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class apwp
  extends QIPCModule
{
  public static apwp a;
  private apwr a;
  
  private apwp()
  {
    super("Module_CheckInServer");
  }
  
  public static apwp a()
  {
    if (jdField_a_of_type_Apwp == null) {}
    try
    {
      if (jdField_a_of_type_Apwp == null) {
        jdField_a_of_type_Apwp = new apwp();
      }
      return jdField_a_of_type_Apwp;
    }
    finally {}
  }
  
  private void ecw()
  {
    if (this.jdField_a_of_type_Apwr != null)
    {
      this.jdField_a_of_type_Apwr.ecw();
      this.jdField_a_of_type_Apwr = null;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "notifyUploadResult callbackId" + paramInt + ", data = " + paramBundle.toString());
    }
    paramBundle = EIPCResult.createResult(0, paramBundle);
    ecw();
    callbackResult(paramInt, paramBundle);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
    ecw();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "action = " + paramString + ", params = " + paramBundle + ",callbackId=" + paramInt);
    }
    ecw();
    apwo localapwo;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localapwo = new apwo();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localapwo.filePath = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new apwq(localapwo, paramInt);
        this.jdField_a_of_type_Apwr = paramString;
        paramString.ecx();
      }
    }
    for (;;)
    {
      return null;
      localapwo.filePath = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localapwo.cover = paramBundle.getString("BUNDLE_NAME_COVER");
      localapwo.videoDuration = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new apwt(localapwo, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        ecw();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwp
 * JD-Core Version:    0.7.0.1
 */