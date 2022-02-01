import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class ayak
{
  private static ArrayList<aybu> Gl = new ArrayList();
  
  public static aycc a(String paramString, aycb paramaycb, ayca paramayca)
  {
    if (paramString.equals(ayan.class.getName())) {
      return new ayan(paramaycb, paramayca);
    }
    return null;
  }
  
  public static void a(aybu paramaybu)
  {
    Gl.remove(paramaybu);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + Gl.size() + " newCode=" + paramaybu.hashCode());
    }
  }
  
  public static void a(LWMotionEvent paramLWMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent size: " + Gl.size());
    }
    Iterator localIterator = Gl.iterator();
    while (localIterator.hasNext())
    {
      aybu localaybu = (aybu)localIterator.next();
      if (localaybu != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localaybu.hashCode());
        }
        localaybu.b(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(aybu paramaybu)
  {
    Gl.add(paramaybu);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + Gl.size() + " newCode=" + paramaybu.hashCode());
    }
  }
  
  public static void ePu()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent size: " + Gl.size());
    }
    Iterator localIterator = Gl.iterator();
    while (localIterator.hasNext())
    {
      aybu localaybu = (aybu)localIterator.next();
      if (localaybu != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localaybu.hashCode());
        }
        localaybu.ePC();
      }
    }
  }
  
  public static void j(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(ayan.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130845451);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayak
 * JD-Core Version:    0.7.0.1
 */