import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class iol
{
  public int aqS;
  public int level;
  public String versionName;
  public int width;
  
  public static iol a()
  {
    imf localimf = ijc.a(BaseApplicationImpl.getContext());
    if (!localimf.isEmpty())
    {
      iol localiol = new iol();
      if (localiol.b(localimf)) {}
      return localiol;
    }
    return null;
  }
  
  public boolean b(imf paramimf)
  {
    try
    {
      this.aqS = paramimf.getIntValue("OpenGLBlowUp/IsOpen", 0);
      this.width = paramimf.getIntValue("OpenGLBlowUp/width", 0);
      this.level = paramimf.getIntValue("OpenGLBlowUp/level", 0);
      this.versionName = paramimf.getStringValue("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.aqS + " width: " + this.width + " level: " + this.level + " versionName: " + this.versionName);
      }
      return true;
    }
    catch (Exception paramimf) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iol
 * JD-Core Version:    0.7.0.1
 */