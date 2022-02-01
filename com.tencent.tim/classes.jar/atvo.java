import android.os.Handler;
import android.os.Looper;
import com.tencent.tim.filemanager.core.WpsFileEditObserver.1;
import java.util.Observable;
import java.util.Observer;

public class atvo
  implements Observer
{
  private final void onUpdate(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    paramObject = (Object[])paramObject[1];
    switch (i)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    Zj((String)paramObject[0]);
  }
  
  public void Zj(String paramString) {}
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new WpsFileEditObserver.1(this, paramObject));
      return;
    }
    onUpdate(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvo
 * JD-Core Version:    0.7.0.1
 */