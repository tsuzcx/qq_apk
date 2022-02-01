import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahau
{
  public static void JH(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      ahau.a locala = new ahau.a();
      locala.bJE = paramString;
      locala.bJD = paramString;
      if (locala.cew) {}
      for (int i = 0;; i = 1)
      {
        anot.b((QQAppInterface)localObject, "CliOper", "", "", locala.bJD, locala.bJE, locala.cYX, locala.cYY, i, String.valueOf(locala.uTime), locala.bJH, ahau.a.a(locala), locala.bJF);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, ahau.a parama)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (parama.cew) {}
      for (int i = 0;; i = 1)
      {
        anot.b(paramString, "CliOper", "", "", parama.bJD, parama.bJE, parama.cYX, parama.cYY, i, String.valueOf(parama.uTime), parama.bJH, ahau.a.a(parama), parama.bJF);
        return;
      }
    }
  }
  
  public static class a
  {
    public String bJD = "share_file";
    public String bJE;
    public String bJF;
    private String bJG;
    public String bJH;
    public int cYX = 0;
    public int cYY = 1;
    public boolean cew = true;
    public long nFileSize;
    public long uTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahau
 * JD-Core Version:    0.7.0.1
 */