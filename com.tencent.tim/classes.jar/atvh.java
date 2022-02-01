import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

class atvh
  extends atsn
{
  atvh(atvg paramatvg) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PreviewStep_1", 4, "SUCCESS OnFileWeiYunPreview harcode[" + atvz.cen + "]");
    }
    if (atvz.cen)
    {
      paramString4 = "183.61.37.13";
      paramString5 = "443";
      if (this.a.a != null) {}
    }
    else
    {
      if ((paramString4 != null) && (paramString4.length() > 0)) {}
      for (;;)
      {
        paramString5 = String.valueOf(paramInt2);
        break;
        paramString4 = paramString5;
      }
    }
    this.a.a.a(paramBoolean, paramString4, paramString5, paramInt1, paramString1, paramString2, paramString3, this.a.bHG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvh
 * JD-Core Version:    0.7.0.1
 */