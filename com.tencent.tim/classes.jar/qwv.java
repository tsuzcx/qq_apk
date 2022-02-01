import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class qwv
{
  private static final boolean aFW = new File(ats + "testserver").exists();
  private static final String ats = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  
  public static boolean KG()
  {
    if (aFW) {}
    return false;
  }
  
  public static void a(qwv.a<Integer> parama)
  {
    parama = new WeakReference(parama);
    qxh localqxh = new qxh(null);
    localqxh.a(new qww(parama));
    localqxh.a(new qwx(parama));
    localqxh.run();
  }
  
  public static abstract interface a<T>
  {
    public abstract void al(T paramT);
    
    public abstract void e(ErrorMessage paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwv
 * JD-Core Version:    0.7.0.1
 */