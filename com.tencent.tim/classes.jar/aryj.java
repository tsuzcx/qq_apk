import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.database.AbstractDbCacheManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aryj
  extends AbstractDbCacheManager
{
  protected aryj.b a;
  protected final ArrayList<WeakReference<aryj.a>> eY = new ArrayList();
  protected Cursor mCursor;
  protected String mSelection;
  protected String mSortOrder;
  
  protected aryj(Context paramContext, Class<? extends aryh> paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    elX();
  }
  
  public void Mh()
  {
    Object localObject = W();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aryj.a locala = (aryj.a)((Iterator)localObject).next();
        if (locala != null) {
          locala.a(this);
        }
      }
    }
  }
  
  protected List<aryj.a> W()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.eY)
      {
        if (this.eY.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.eY.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (aryj.a)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  public void Xr(String paramString)
  {
    try
    {
      delete(paramString);
      return;
    }
    finally {}
  }
  
  public aryh a(int paramInt)
  {
    try
    {
      aryh localaryh = a(this.mCursor, paramInt);
      return localaryh;
    }
    finally {}
  }
  
  public void a(aryh paramaryh, int paramInt)
  {
    try
    {
      a(paramInt, new aryh[] { paramaryh });
      return;
    }
    finally {}
  }
  
  void a(aryj.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(aryh[] paramArrayOfaryh, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfaryh);
      return;
    }
    finally {}
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      super.b(paramSQLiteDatabase, paramInt);
      return;
    }
    a(paramSQLiteDatabase, this.mSelection);
  }
  
  public void b(aryh paramaryh, String paramString)
  {
    try
    {
      a(paramaryh, paramString);
      return;
    }
    finally {}
  }
  
  protected void elX()
  {
    try
    {
      this.mCursor = b(this.mSelection, this.mSortOrder);
      return;
    }
    finally {}
  }
  
  public int getCount()
  {
    for (;;)
    {
      try
      {
        if (this.mCursor != null)
        {
          i = this.mCursor.getCount();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onChanged()
  {
    try
    {
      if (this.mCursor != null) {
        this.mCursor.close();
      }
      elX();
      Mh();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(aryj paramaryj);
  }
  
  static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryj
 * JD-Core Version:    0.7.0.1
 */