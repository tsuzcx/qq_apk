import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;

public class axvy
{
  private static axvy a;
  private WeakReference<DoodleLayout> jn;
  private WeakReference<DoodleLayout> jo;
  
  public static axvy a()
  {
    if (a == null) {
      a = new axvy();
    }
    return a;
  }
  
  public DoodleLayout a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (this.jn != null)
      {
        localObject1 = localObject2;
        if (this.jn.get() != null) {
          localObject1 = (DoodleLayout)this.jn.get();
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) && (QLog.isColorLevel())) {
        QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jo != null)
      {
        localObject1 = localObject2;
        if (this.jo.get() != null) {
          localObject1 = (DoodleLayout)this.jo.get();
        }
      }
    }
  }
  
  public void a(int paramInt, DoodleLayout paramDoodleLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "bind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jn = new WeakReference(paramDoodleLayout);
      return;
    }
    this.jo = new WeakReference(paramDoodleLayout);
  }
  
  public void aeL(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "unbind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jn = null;
      return;
    }
    this.jo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvy
 * JD-Core Version:    0.7.0.1
 */