import com.tencent.qphone.base.util.QLog;
import java.io.File;

class mqb
  implements mpt.a<mir.a>
{
  mqb(mpy parammpy) {}
  
  public boolean b(mir.a parama)
  {
    try
    {
      parama = new File(parama.path);
      if (parama.isFile())
      {
        boolean bool = parama.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable parama)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", parama);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqb
 * JD-Core Version:    0.7.0.1
 */