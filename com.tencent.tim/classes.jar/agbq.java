import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class agbq
  implements DialogInterface.OnClickListener
{
  agbq(agbp paramagbp, String paramString, aglz paramaglz, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = new StringBuilder();
    if (this.jdField_a_of_type_Agbp.this$0.ccM) {}
    for (paramDialogInterface = "https://";; paramDialogInterface = "http://")
    {
      String str = paramDialogInterface + this.jdField_a_of_type_Agbp.this$0.bGu + ":" + this.jdField_a_of_type_Agbp.this$0.bGv + "/ftn_compress_getfile/rkey=" + this.jdField_a_of_type_Agbp.this$0.bGt + "&filetype=" + this.jdField_a_of_type_Agbp.this$0.nFileType + "&path=";
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, str);
      }
      paramDialogInterface = this.val$path;
      try
      {
        localObject = URLEncoder.encode(this.val$path, "utf8");
        paramDialogInterface = (DialogInterface)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      paramDialogInterface = str + paramDialogInterface + "&";
      this.jdField_a_of_type_Aglz.z(paramDialogInterface, this.aN);
      ahau.JH("0X80052CE");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbq
 * JD-Core Version:    0.7.0.1
 */