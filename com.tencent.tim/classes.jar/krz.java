import java.util.ArrayList;
import java.util.List;

public class krz
{
  private static List<ktr.d> mListeners;
  
  private krz()
  {
    mListeners = new ArrayList();
  }
  
  public static krz a()
  {
    return krz.a.b();
  }
  
  public void a(ktr.d paramd)
  {
    if ((paramd == null) || (mListeners == null)) {}
    while (mListeners.contains(paramd)) {
      return;
    }
    mListeners.add(paramd);
  }
  
  public void aGb()
  {
    if (mListeners != null) {
      mListeners.clear();
    }
  }
  
  public List<ktr.d> ar()
  {
    if (mListeners == null) {
      return null;
    }
    return mListeners;
  }
  
  public void b(ktr.d paramd)
  {
    if ((mListeners == null) || (mListeners.size() == 0)) {
      return;
    }
    mListeners.remove(paramd);
  }
  
  static class a
  {
    private static final krz a = new krz(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krz
 * JD-Core Version:    0.7.0.1
 */