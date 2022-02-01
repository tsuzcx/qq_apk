import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class apun
  extends Observable
{
  protected TroopUploadingThread a;
  
  public abstract void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList);
  
  public ArrayList<apul> dW()
  {
    if (this.a != null) {
      return this.a.dW();
    }
    return null;
  }
  
  public void g(Observer paramObserver)
  {
    super.deleteObserver(paramObserver);
  }
  
  public void notifyObservers(Object paramObject)
  {
    super.setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apun
 * JD-Core Version:    0.7.0.1
 */