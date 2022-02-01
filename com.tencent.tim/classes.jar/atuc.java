import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

class atuc
  extends atsn
{
  atuc(atub paramatub) {}
  
  protected void c(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    label105:
    for (;;)
    {
      try
      {
        if (atvz.cen)
        {
          paramString4 = "183.61.37.13";
          paramString5 = "443";
          if (this.a.a != null) {
            this.a.a.a(paramBoolean, paramString4, paramString5, paramInt1, paramString1, paramString3, paramString2, this.a.bHG);
          }
        }
        else
        {
          if ((paramString4 == null) || (paramString4.length() <= 0)) {
            break label105;
          }
          paramString5 = String.valueOf(paramInt2);
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("FMObserver<FileAssistant>", 2, " callback is null");
          continue;
          paramString4 = paramString5;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuc
 * JD-Core Version:    0.7.0.1
 */