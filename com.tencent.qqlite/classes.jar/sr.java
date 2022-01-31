import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.qphone.base.util.QLog;

public class sr
  implements LoadedBack
{
  public sr(SosoPlugin paramSosoPlugin) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SosoPlugin.c(this.a), 2, "get offline format white list, loaded, code : " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sr
 * JD-Core Version:    0.7.0.1
 */