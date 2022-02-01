import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.2;
import mqq.os.MqqHandler;

public class agui
  extends aoak
{
  agui(aguh paramaguh) {}
  
  public void A(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.downloadStartTime;
    long l3 = this.this$0.downloadStartTime;
    long l4 = this.this$0.aae;
    if (paramBoolean)
    {
      if ((this.this$0.ba != null) && (this.this$0.ba.getBoolean("isMiniProgram", false))) {
        aodb.aN(this.this$0.mAppInterface, "0X800A4B3");
      }
      if (aguh.a(this.this$0) != null)
      {
        aguh.a(this.this$0).setFilePath(paramString1);
        aguh.a(this.this$0).fileSize = ahav.getFileSizes(paramString1);
        paramString1 = aoal.fr(aguh.a(this.this$0).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null)) {
          anot.a(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, l3 - l4 + "", l1 - l2 + "", paramString1, paramString2);
        }
      }
      if (this.this$0.a != null)
      {
        aguh.a(this.this$0).removeMessages(8001);
        aguh.a(this.this$0).removeMessages(8002);
        aguh.a(this.this$0).post(new DocsExportFileModel.1.1(this));
      }
      return;
    }
    paramString1 = acfp.m(2131705189);
    aguh.a(this.this$0, paramString1, paramString2);
  }
  
  public void F(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    aguh.a(this.this$0, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void Ou(int paramInt)
  {
    if ((this.this$0.a != null) && (paramInt <= 100)) {
      aguh.a(this.this$0).post(new DocsExportFileModel.1.2(this, paramInt));
    }
  }
  
  public void fN(String paramString1, String paramString2)
  {
    aguh.a(this.this$0, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agui
 * JD-Core Version:    0.7.0.1
 */