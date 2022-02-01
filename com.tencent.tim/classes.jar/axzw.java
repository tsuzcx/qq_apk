import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class axzw
  extends axzd
{
  private axzr<axze, axzw.a> a = new axzr();
  private axzd.b f;
  private int mAddingObserverCounter;
  private boolean mHandlingEvent;
  private final WeakReference<axzf> mLifecycleOwner;
  private boolean mNewEventOccurred;
  private ArrayList<axzd.b> mParentStates = new ArrayList();
  
  public axzw(@NonNull axzf paramaxzf)
  {
    this.mLifecycleOwner = new WeakReference(paramaxzf);
    this.f = axzd.b.b;
  }
  
  private static axzd.a a(axzd.b paramb)
  {
    switch (paramb.value)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramb);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return axzd.a.f;
    case 3: 
      return axzd.a.e;
    case 4: 
      return axzd.a.d;
    }
    throw new IllegalArgumentException();
  }
  
  static axzd.b a(axzd.a parama)
  {
    switch (parama.value)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + parama);
    case 0: 
    case 4: 
      return axzd.b.c;
    case 1: 
    case 3: 
      return axzd.b.d;
    case 2: 
      return axzd.b.e;
    }
    return axzd.b.a;
  }
  
  static axzd.b a(@NonNull axzd.b paramb1, @Nullable axzd.b paramb2)
  {
    if ((paramb2 != null) && (paramb2.a(paramb1) < 0)) {
      return paramb2;
    }
    return paramb1;
  }
  
  private axzd.b a(axze paramaxze)
  {
    paramaxze = this.a.ceil(paramaxze);
    if (paramaxze != null)
    {
      paramaxze = ((axzw.a)paramaxze.getValue()).f;
      if (this.mParentStates.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (axzd.b localb = (axzd.b)this.mParentStates.get(this.mParentStates.size() - 1);; localb = null)
    {
      return a(a(this.f, paramaxze), localb);
      paramaxze = null;
      break;
    }
  }
  
  private void a(axzd.b paramb)
  {
    if (this.f == paramb) {
      return;
    }
    this.f = paramb;
    if ((this.mHandlingEvent) || (this.mAddingObserverCounter != 0))
    {
      this.mNewEventOccurred = true;
      return;
    }
    this.mHandlingEvent = true;
    sync();
    this.mHandlingEvent = false;
  }
  
  private static axzd.a b(axzd.b paramb)
  {
    switch (paramb.value)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramb);
    case 0: 
    case 1: 
      return axzd.a.a;
    case 2: 
      return axzd.a.b;
    case 3: 
      return axzd.a.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b(axzd.b paramb)
  {
    this.mParentStates.add(paramb);
  }
  
  private void h(axzf paramaxzf)
  {
    axzs.d locald = this.a.a();
    while ((locald.hasNext()) && (!this.mNewEventOccurred))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      axzw.a locala = (axzw.a)localEntry.getValue();
      while ((locala.f.a(this.f) < 0) && (!this.mNewEventOccurred) && (this.a.contains(localEntry.getKey())))
      {
        b(locala.f);
        locala.b(paramaxzf, b(locala.f));
        popParentState();
      }
    }
  }
  
  private void i(axzf paramaxzf)
  {
    Iterator localIterator = this.a.descendingIterator();
    while ((localIterator.hasNext()) && (!this.mNewEventOccurred))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      axzw.a locala = (axzw.a)localEntry.getValue();
      while ((locala.f.a(this.f) > 0) && (!this.mNewEventOccurred) && (this.a.contains(localEntry.getKey())))
      {
        axzd.a locala1 = a(locala.f);
        b(a(locala1));
        locala.b(paramaxzf, locala1);
        popParentState();
      }
    }
  }
  
  private boolean isSynced()
  {
    if (this.a.size() == 0) {
      return true;
    }
    axzd.b localb1 = ((axzw.a)this.a.eldest().getValue()).f;
    axzd.b localb2 = ((axzw.a)this.a.newest().getValue()).f;
    if ((localb1 == localb2) && (this.f == localb2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void popParentState()
  {
    this.mParentStates.remove(this.mParentStates.size() - 1);
  }
  
  private void sync()
  {
    axzf localaxzf = (axzf)this.mLifecycleOwner.get();
    if (localaxzf == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!isSynced())
    {
      this.mNewEventOccurred = false;
      if (this.f.a(((axzw.a)this.a.eldest().getValue()).f) < 0) {
        i(localaxzf);
      }
      Map.Entry localEntry = this.a.newest();
      if ((!this.mNewEventOccurred) && (localEntry != null) && (this.f.a(((axzw.a)localEntry.getValue()).f) > 0)) {
        h(localaxzf);
      }
    }
    this.mNewEventOccurred = false;
  }
  
  @NonNull
  public axzd.b a()
  {
    return this.f;
  }
  
  public void a(@NonNull axzd.a parama)
  {
    a(a(parama));
  }
  
  public void a(@NonNull axze paramaxze)
  {
    axzd.b localb;
    axzw.a locala;
    if (this.f == axzd.b.a)
    {
      localb = axzd.b.a;
      locala = new axzw.a(paramaxze, localb);
      if ((axzw.a)this.a.putIfAbsent(paramaxze, locala) == null) {
        break label49;
      }
    }
    label49:
    axzf localaxzf;
    do
    {
      return;
      localb = axzd.b.b;
      break;
      localaxzf = (axzf)this.mLifecycleOwner.get();
    } while (localaxzf == null);
    if ((this.mAddingObserverCounter != 0) || (this.mHandlingEvent)) {}
    for (int i = 1;; i = 0)
    {
      localb = a(paramaxze);
      this.mAddingObserverCounter += 1;
      while ((locala.f.a(localb) < 0) && (this.a.contains(paramaxze)))
      {
        b(locala.f);
        locala.b(localaxzf, b(locala.f));
        popParentState();
        localb = a(paramaxze);
      }
    }
    if (i == 0) {
      sync();
    }
    this.mAddingObserverCounter -= 1;
  }
  
  public void b(@NonNull axze paramaxze)
  {
    this.a.remove(paramaxze);
  }
  
  static class a
  {
    axzc a;
    axzd.b f;
    
    a(axze paramaxze, axzd.b paramb)
    {
      this.a = axzg.a(paramaxze);
      this.f = paramb;
    }
    
    void b(axzf paramaxzf, axzd.a parama)
    {
      axzd.b localb = axzw.a(parama);
      this.f = axzw.a(this.f, localb);
      this.a.a(paramaxzf, parama);
      this.f = localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzw
 * JD-Core Version:    0.7.0.1
 */