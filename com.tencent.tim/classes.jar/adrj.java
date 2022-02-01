import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppManagerPanel.a;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;
import java.util.ArrayList;

public class adrj
{
  protected static boolean bQy = false;
  
  public static void a(adrj.a parama)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(parama), 5, null, true);
  }
  
  public static void cTZ()
  {
    if (!bQy) {
      bQy = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ch(ArrayList<ArkAppManagerPanel.a> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrj
 * JD-Core Version:    0.7.0.1
 */