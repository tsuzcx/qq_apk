import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class ipy
  extends iqc
{
  private String TAG = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private ipz.a a;
  private boolean inited;
  private Vector<iqa> j;
  private List<Pair<ipy, Integer>> outputs = new LinkedList();
  
  public ipy(int paramInt)
  {
    this.j = new Vector(paramInt);
    this.j.setSize(paramInt);
  }
  
  private void a(iqa paramiqa, int paramInt, long paramLong)
  {
    if (a(paramiqa, paramInt))
    {
      a(this.j, paramLong);
      this.j.clear();
      this.j.setSize(this.j.capacity());
    }
  }
  
  private boolean a(iqa paramiqa, int paramInt)
  {
    this.j.set(paramInt, paramiqa);
    paramInt = 0;
    while (paramInt < this.j.size())
    {
      if (this.j.get(paramInt) == null) {
        return false;
      }
      paramInt += 1;
    }
    return true;
  }
  
  @NotNull
  protected abstract Frame a(List<iqa> paramList, long paramLong);
  
  public ipy a()
  {
    this.outputs.clear();
    this.j.clear();
    this.j.setSize(this.j.capacity());
    return this;
  }
  
  public ipy a(ipy paramipy, int paramInt)
  {
    Log.d(this.TAG, "addTarget: " + paramipy);
    if (paramInt >= paramipy.j.size())
    {
      Log.e(this.TAG, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.j.size() + ", out of bounds");
      return this;
    }
    this.outputs.add(new Pair(paramipy, Integer.valueOf(paramInt)));
    paramipy.a(this.jdField_a_of_type_Iqb);
    return this;
  }
  
  public void a(iqb paramiqb)
  {
    super.a(paramiqb);
    if (!this.inited)
    {
      Log.d(this.TAG, "init: ");
      onInit();
      if (this.jdField_a_of_type_Ipz$a != null)
      {
        this.jdField_a_of_type_Ipz$a.aps();
        this.jdField_a_of_type_Ipz$a = null;
      }
      this.inited = true;
    }
    int i = 0;
    while (i < this.outputs.size())
    {
      ((ipy)((Pair)this.outputs.get(i)).first).a(this.jdField_a_of_type_Iqb);
      i += 1;
    }
  }
  
  public void a(List<iqa> paramList, long paramLong)
  {
    int k = 0;
    Object localObject = a(paramList, paramLong);
    iqa localiqa = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((iqa)paramList.get(i)).frame == localObject) {
        localiqa = (iqa)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((iqa)paramList.get(i)).unlock();
      }
    }
    if (this.outputs.isEmpty()) {
      if (this.jdField_a_of_type_Iqb.a.a != null) {
        this.jdField_a_of_type_Iqb.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (localiqa != null)
      {
        localiqa.unlock();
        return;
        if (localiqa == null)
        {
          localiqa = iqa.a((Frame)localObject);
          localiqa.lq(this.outputs.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = k;
          while (i < paramList.size())
          {
            if (((iqa)paramList.get(i)).fp != null) {
              ((List)localObject).addAll(((iqa)paramList.get(i)).fp);
            }
            i += 1;
          }
          localiqa.lq(this.outputs.size());
          localiqa.unlock();
        }
        localiqa.fp = ((List)localObject);
        paramList = this.outputs.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((ipy)((Pair)localObject).first).a(localiqa, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void destroy()
  {
    if (this.inited)
    {
      Log.d(this.TAG, "destroy: ");
      onDestroy();
      this.inited = false;
    }
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext()) {
      ((ipy)((Pair)localIterator.next()).first).destroy();
    }
    this.outputs.clear();
    this.j.clear();
    this.j.setSize(this.j.capacity());
  }
  
  protected abstract void onDestroy();
  
  protected abstract void onInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipy
 * JD-Core Version:    0.7.0.1
 */