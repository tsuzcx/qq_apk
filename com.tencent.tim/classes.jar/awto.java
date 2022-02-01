import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class awto
{
  protected static final String cTf = BaseApplicationImpl.getContext().getCacheDir().getPath();
  protected static final String cTg;
  protected static final String cTh = BaseApplicationImpl.getContext().getFilesDir().getParent();
  
  static
  {
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      cTg = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
      cTf = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();
      return;
    }
    cTg = BaseApplicationImpl.getContext().getFilesDir().getPath();
  }
  
  public static class a
  {
    public static final String cTi = awto.cTg + File.separator + "ae";
    public static final String cTj = awto.cTf + File.separator + "ae";
  }
  
  public static class b
  {
    public static final String PATH = awto.a.cTj + File.separator + "tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awto
 * JD-Core Version:    0.7.0.1
 */