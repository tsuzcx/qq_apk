import android.content.ContentValues;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.2;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.3;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class aebo
  extends acxq
{
  private static final Object CACHE_LOCK = new Object();
  public static int MAX_COUNT = 9;
  private Comparator<ColorNote> mComparator = new aebp(this);
  private EntityManager mEntityManager;
  ArrayList<aebo.a> vh;
  protected List<ColorNote> yc = new ArrayList();
  
  public aebo(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    long l = paramColorNote1.mTime - paramColorNote2.mTime;
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return 1;
    }
    return -1;
  }
  
  private void a(int paramInt, ColorNote paramColorNote)
  {
    if (this.vh == null) {
      return;
    }
    ArrayList localArrayList = (ArrayList)this.vh.clone();
    int j = localArrayList.size();
    int i = 0;
    label29:
    if (i < j)
    {
      if (paramInt != 1) {
        break label62;
      }
      ((aebo.a)localArrayList.get(i)).h(paramColorNote);
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label62:
      if (paramInt == 2) {
        ((aebo.a)localArrayList.get(i)).i(paramColorNote);
      }
    }
  }
  
  public final int Cf()
  {
    try
    {
      int i = r(false).size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ColorNote a(String paramString)
  {
    try
    {
      paramString = a(paramString, 0);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ColorNote a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject = r(false);
        if (localObject == null) {
          break label86;
        }
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label86;
        }
        localObject = (ColorNote)localIterator.next();
        boolean bool = ((ColorNote)localObject).getUniKey().equals(paramString);
        if (!bool) {
          continue;
        }
        paramString = (String)localObject;
        return paramString;
      }
      finally {}
      Object localObject = a(false, paramInt);
      continue;
      label86:
      paramString = null;
    }
  }
  
  public ColorNote a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    ColorNote localColorNote = a(paramString2);
    for (;;)
    {
      try
      {
        localObject = ColorNote.class.getDeclaredField(paramString3);
        localClass = ((Field)localObject).getType();
        ((Field)localObject).setAccessible(true);
        if (localColorNote != null) {
          ((Field)localObject).set(localColorNote, paramObject);
        }
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(notColumn.class))) {
          break label381;
        }
        localObject = new ContentValues();
        if (localClass != Long.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Long)paramObject);
      }
      catch (NoSuchFieldException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error NoSuchFieldException! ", paramString1);
        return null;
        if (localClass != String.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (String)paramObject);
        continue;
      }
      catch (IllegalAccessException paramString1)
      {
        Object localObject;
        Class localClass;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error IllegalAccessException! ", paramString1);
        continue;
        if (localClass != Byte.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Byte)paramObject);
        continue;
        if (localClass != [B.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (byte[])paramObject);
        continue;
        if (localClass != Short.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Short)paramObject);
        continue;
        if (localClass != Boolean.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Boolean)paramObject);
        continue;
        if (localClass != Float.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Float)paramObject);
        continue;
        if (localClass != Double.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Double)paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
        continue;
      }
      if (localColorNote == null) {
        continue;
      }
      a(paramString1, 0, localColorNote.getTableName(), (ContentValues)localObject, "mUniKey=?", new String[] { paramString2 }, null);
      return localColorNote;
      if (localClass != Integer.TYPE) {
        continue;
      }
      ((ContentValues)localObject).put(paramString3, (Integer)paramObject);
    }
    label381:
    return null;
  }
  
  public ArrayList<ColorNote> a(String paramString, ProxyListener paramProxyListener)
  {
    return a(paramString, paramProxyListener, 0);
  }
  
  public ArrayList<ColorNote> a(String arg1, ProxyListener paramProxyListener, int paramInt)
  {
    paramProxyListener = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      Iterator localIterator = this.yc.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (localColorNote.mExtra == paramInt) {
          paramProxyListener.add(localColorNote);
        }
      }
    }
    this.yc.removeAll(paramProxyListener);
    jE(paramProxyListener);
    return paramProxyListener;
  }
  
  public List<ColorNote> a(boolean paramBoolean, int paramInt)
  {
    try
    {
      if ((this.yc.isEmpty()) && (paramBoolean))
      {
        localList = this.mEntityManager.query(ColorNote.class);
        if ((localList != null) && (!localList.isEmpty())) {
          this.yc = localList;
        }
      }
      List localList = g(this.yc, paramInt);
      return localList;
    }
    finally {}
  }
  
  public void a(aebo.a parama)
  {
    if (this.vh == null) {
      this.vh = new ArrayList();
    }
    if (!this.vh.contains(parama)) {
      this.vh.add(parama);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String arg1, ColorNote paramColorNote, ProxyListener paramProxyListener)
  {
    if (paramColorNote != null) {}
    synchronized (CACHE_LOCK)
    {
      this.yc.remove(paramColorNote);
      ThreadManagerV2.excute(new ColorNoteProxy.2(this, paramColorNote), 32, null, false);
      return;
    }
  }
  
  protected void a(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      o(paramColorNote);
      return;
    }
    n(paramColorNote);
  }
  
  public boolean a(String paramString, ColorNote paramColorNote)
  {
    List localList = this.yc;
    ArrayList localArrayList = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (aebs.h(localColorNote)) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList.removeAll(localArrayList);
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      a(paramString, (ColorNote)((Iterator)???).next(), null);
    }
    if (paramColorNote != null) {
      a(paramString, paramColorNote, null, false);
    }
    return true;
  }
  
  public boolean a(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!f(paramColorNote)) && (aeee.Wn())) {
      if (paramColorNote.getServiceType() == 16973824) {
        anot.a(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
    }
    do
    {
      synchronized (CACHE_LOCK)
      {
        if (aebs.h(paramColorNote))
        {
          this.yc.add(0, paramColorNote);
          if (paramColorNote.getServiceType() != 16973824) {
            a(paramString, paramColorNote, paramProxyListener, paramBoolean);
          }
          paramBoolean = true;
          return paramBoolean;
        }
        this.yc.add(paramColorNote);
      }
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteProxy", 2, "addColorNote error! isAfterSyncMsg = " + aeee.Wn());
    return false;
  }
  
  public List<ColorNote> aT(List<ColorNote> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (!paramList.isEmpty())
        {
          i = paramList.size() - 1;
          if (i >= 0)
          {
            ColorNote localColorNote = (ColorNote)paramList.get(i);
            if ((localColorNote.isOpen()) && (!aebs.j(localColorNote))) {
              break label96;
            }
            localArrayList.add(localColorNote);
            break label96;
          }
        }
        Collections.sort(localArrayList, this.mComparator);
        paramList = g(localArrayList, 0);
        return paramList;
      }
      finally {}
      label96:
      i -= 1;
    }
  }
  
  public void b(aebo.a parama)
  {
    if (this.vh != null) {
      this.vh.remove(parama);
    }
  }
  
  public void cVI()
  {
    Object localObject2 = this.yc;
    synchronized (CACHE_LOCK)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (aebs.i(localColorNote))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteProxy", 2, "clearAllUpcomingMindFlag ~~ " + localColorNote);
          }
          localColorNote.mExtLong &= 0L;
          a(this.app.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
    }
  }
  
  public boolean canAddColorNote()
  {
    Object localObject2 = r(false);
    int j;
    label106:
    for (int i = ((List)localObject2).size();; i = j)
    {
      synchronized (CACHE_LOCK)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
          j = i;
          if (aebs.h(localColorNote)) {
            j = i - 1;
          }
          if (localColorNote.getServiceType() != 16973824) {
            continue;
          }
          i = j - 1;
          break label106;
        }
        if (i < MAX_COUNT) {
          return true;
        }
      }
      return false;
    }
  }
  
  protected void destory()
  {
    if (this.mEntityManager != null) {
      this.mEntityManager.close();
    }
  }
  
  public void e(ColorNote paramColorNote)
  {
    Object localObject2 = this.yc;
    synchronized (CACHE_LOCK)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (localColorNote.equals(paramColorNote))
        {
          localColorNote.mExtLong |= 1L;
          a(this.app.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
      return;
    }
  }
  
  public List<ColorNote> ep()
  {
    try
    {
      List localList = aT(this.yc);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean f(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.yc.isEmpty())
    {
      bool1 = bool2;
      if (a(paramColorNote.getUniKey(), paramColorNote.mExtra) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  List<ColorNote> g(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
        if (localColorNote.mExtra == paramInt) {
          localArrayList.add(localColorNote);
        }
      }
    }
    return localArrayList;
  }
  
  protected void init()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteProxy", 2, "init ~~ ");
    }
    this.mEntityManager = this.app.a().createEntityManager();
    Object localObject = this.mEntityManager.query(ColorNote.class, true, null, null, null, null, null, null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.yc = ((List)localObject);
      aeee.e(this.app.getApp(), false, false);
    }
    localObject = aeaw.a();
    if ((localObject != null) && (((aeav)localObject).getMaxCount() != -1))
    {
      MAX_COUNT = ((aeav)localObject).getMaxCount();
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteConfigProcessor", 2, "init MAX_COUNT " + MAX_COUNT);
      }
    }
    aeee.e(BaseApplicationImpl.getContext(), 3, true);
  }
  
  protected void jE(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManagerV2.excute(new ColorNoteProxy.3(this, paramList), 32, null, false);
  }
  
  protected void n(ColorNote paramColorNote)
  {
    if (this.mEntityManager != null) {
      this.mEntityManager.persist(paramColorNote);
    }
    a(1, paramColorNote);
  }
  
  protected void o(ColorNote paramColorNote)
  {
    n(paramColorNote);
  }
  
  public final List<ColorNote> r(boolean paramBoolean)
  {
    try
    {
      List localList = a(paramBoolean, 0);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(ColorNote paramColorNote);
    
    public abstract void i(ColorNote paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebo
 * JD-Core Version:    0.7.0.1
 */