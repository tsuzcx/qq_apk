import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.LinkedList;
import java.util.List;

public abstract class ipz
{
  private String TAG = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  ipz.b jdField_a_of_type_Ipz$b;
  private iqb jdField_a_of_type_Iqb;
  private List<ipy> outputs = new LinkedList();
  
  public ipz()
  {
    Log.d(this.TAG, "ImageSource: ");
  }
  
  public ipz a(ipy paramipy)
  {
    Log.d(this.TAG, "addTarget: " + paramipy);
    this.outputs.add(paramipy);
    paramipy.a(this.jdField_a_of_type_Iqb);
    return this;
  }
  
  public void a(ipz.b paramb)
  {
    this.jdField_a_of_type_Ipz$b = paramb;
  }
  
  public void apr()
  {
    Log.d(this.TAG, "isolated: ");
    this.outputs.clear();
  }
  
  protected void b(List<iqa> paramList, long paramLong)
  {
    int k = 0;
    if (this.outputs.size() == 0) {}
    for (;;)
    {
      return;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        ((iqa)paramList.get(i)).lq(this.outputs.size());
        i += 1;
      }
      while (j < this.outputs.size())
      {
        ((ipy)this.outputs.get(j)).a(paramList, paramLong);
        j += 1;
      }
    }
  }
  
  public void destroy()
  {
    Log.d(this.TAG, "destroy");
    int i = 0;
    while (i < this.outputs.size())
    {
      ((ipy)this.outputs.get(i)).destroy();
      i += 1;
    }
    onDestroy();
  }
  
  public void init()
  {
    Log.d(this.TAG, "init");
    this.jdField_a_of_type_Iqb = new iqb();
    this.jdField_a_of_type_Iqb.a = this;
    onInit();
    int i = 0;
    while (i < this.outputs.size())
    {
      ((ipy)this.outputs.get(i)).a(this.jdField_a_of_type_Iqb);
      i += 1;
    }
  }
  
  protected abstract void onDestroy();
  
  protected abstract void onInit();
  
  public static abstract interface a
  {
    public abstract void aps();
  }
  
  public static abstract interface b
  {
    public abstract void a(Frame paramFrame, ipy paramipy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipz
 * JD-Core Version:    0.7.0.1
 */