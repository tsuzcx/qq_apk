import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearByFaceDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.FaceManager.1;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aqdm
  implements Manager
{
  List<aqdk.b> ID;
  List<aqdk.a> IE;
  List<aqdk.f> IF;
  aqdm.a jdField_a_of_type_Aqdm$a;
  aqdm.b jdField_a_of_type_Aqdm$b;
  aqdm.c jdField_a_of_type_Aqdm$c;
  NearByFaceDownloader jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  ConcurrentHashMap<String, Long> faceTimestamps = new ConcurrentHashMap(4);
  MQLruCache<String, Object> m;
  QQAppInterface v;
  
  public aqdm(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
      this.m = BaseApplicationImpl.sImageCache;
    }
    while (!(paramAppInterface instanceof QQAppInterface)) {
      return;
    }
    this.v = ((QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_Aqdm$b = new aqdm.b(null);
    this.v.addDefaultObservers(this.jdField_a_of_type_Aqdm$b);
    this.jdField_a_of_type_Aqdm$a = new aqdm.a(null);
    this.v.addDefaultObservers(this.jdField_a_of_type_Aqdm$a);
    this.jdField_a_of_type_Aqdm$c = new aqdm.c(null);
    this.v.addObserver(this.jdField_a_of_type_Aqdm$c);
    this.ID = new Vector();
    this.IE = new Vector();
    this.IF = new Vector();
  }
  
  private void a(int paramInt, Object paramObject, boolean paramBoolean, Object... paramVarArgs)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (((paramObject instanceof aqdk.d)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = (aqdk.d)paramObject;
      if ((TextUtils.isEmpty(((aqdk.d)localObject).uin)) || (!((aqdk.d)localObject).uin.equals((String)paramVarArgs[0]))) {
        break label272;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1)
      {
        paramObject = new FaceManager.1(this, paramObject, paramInt, paramBoolean, paramVarArgs);
        ThreadManager.getUIHandler().post(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("FaceManager", 2, "dispatchMessage , needDis:" + bool1 + ",type: " + paramInt + ",args: " + paramVarArgs);
        }
      }
      return;
      if (((paramObject instanceof aqdk.c)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
      {
        localObject = (aqdk.c)paramObject;
        bool1 = bool2;
        if (!TextUtils.isEmpty(((aqdk.c)localObject).discussionUin))
        {
          bool1 = bool2;
          if (((aqdk.c)localObject).discussionUin.equals((String)paramVarArgs[1])) {
            bool1 = true;
          }
        }
      }
      else
      {
        if (((paramObject instanceof aqdk.e)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
        {
          localObject = (aqdk.e)paramObject;
          if ((!TextUtils.isEmpty(((aqdk.e)localObject).discussionUin)) && (((aqdk.e)localObject).discussionUin.equals((String)paramVarArgs[1])))
          {
            bool1 = true;
            continue;
          }
        }
        bool1 = false;
        continue;
        label272:
        bool1 = false;
      }
    }
  }
  
  public static byte c(byte paramByte)
  {
    if (!anlm.Vr()) {}
    byte b = paramByte;
    if (paramByte != 4)
    {
      b = paramByte;
      if (paramByte != 5) {
        b = 1;
      }
    }
    return b;
  }
  
  public static byte d(int paramInt)
  {
    if (paramInt == 32) {
      return 1;
    }
    return 2;
  }
  
  public static <T> List<List<T>> l(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt < 1)) {
      return null;
    }
    int n = paramList.size();
    int i;
    ArrayList localArrayList;
    int j;
    if (n % paramInt == 0)
    {
      i = n / paramInt;
      localArrayList = new ArrayList();
      j = 0;
      label42:
      if (j >= i) {
        break label104;
      }
      if (j != i - 1) {
        break label94;
      }
    }
    label94:
    for (int k = n;; k = (j + 1) * paramInt)
    {
      localArrayList.add(paramList.subList(j * paramInt, k));
      j += 1;
      break label42;
      i = n / paramInt + 1;
      break;
    }
    label104:
    return localArrayList;
  }
  
  public Bitmap O(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.m)
    {
      Bitmap localBitmap2 = (Bitmap)this.m.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.faceTimestamps != null)
        {
          localBitmap1 = localBitmap2;
          if (this.faceTimestamps.containsKey(paramString))
          {
            long l = ((Long)this.faceTimestamps.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > 86400000L)
            {
              this.faceTimestamps.remove(paramString);
              this.m.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      return localBitmap1;
    }
  }
  
  public void Um(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.m)
    {
      this.m.remove(paramString);
      return;
    }
  }
  
  public FaceDownloader a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader = new NearByFaceDownloader(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
      NearByFaceDownloader localNearByFaceDownloader = this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
      return localNearByFaceDownloader;
    }
    finally {}
  }
  
  public String a(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (aqfo.isExistSDCard()) {
      localStringBuilder.append(acbn.bmF);
    }
    for (;;)
    {
      localStringBuilder.append("stranger_").append(Integer.toString(paramFaceInfo.idType)).append("_");
      String str = MD5.toMD5(paramFaceInfo.uin);
      str = MD5.toMD5(str + paramFaceInfo.uin);
      localStringBuilder.append(MD5.toMD5(str + paramFaceInfo.uin));
      localStringBuilder.append(".jpg_");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.tim/files/head/_stranger/");
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    synchronized (this.m)
    {
      this.m.put(paramString, paramBitmap, paramByte);
      if (this.faceTimestamps != null) {
        this.faceTimestamps.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      return;
    }
  }
  
  public boolean a(FaceInfo paramFaceInfo)
  {
    paramFaceInfo = a(paramFaceInfo);
    if (TextUtils.isEmpty(paramFaceInfo)) {
      return false;
    }
    return new File(paramFaceInfo).exists();
  }
  
  public final void b(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.ID != null) && (this.ID.size() > 0)) {
      synchronized (this.ID)
      {
        Iterator localIterator = this.ID.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (aqdk.b)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void bx(Object paramObject)
  {
    if ((paramObject == null) || (this.v == null)) {}
    do
    {
      return;
      if ((paramObject instanceof aqdk.b)) {
        synchronized (this.ID)
        {
          if (!this.ID.contains(paramObject)) {
            this.ID.add((aqdk.b)paramObject);
          }
          return;
        }
      }
      if ((paramObject instanceof aqdk.a)) {
        synchronized (this.IE)
        {
          if (!this.IE.contains(paramObject)) {
            this.IE.add((aqdk.a)paramObject);
          }
          return;
        }
      }
    } while (!(paramObject instanceof aqdk.f));
    synchronized (this.IF)
    {
      if (!this.IF.contains(paramObject)) {
        this.IF.add((aqdk.f)paramObject);
      }
      return;
    }
  }
  
  public void by(Object paramObject)
  {
    if (this.v == null) {}
    do
    {
      return;
      if ((paramObject instanceof aqdk.b)) {
        synchronized (this.ID)
        {
          this.ID.remove(paramObject);
          return;
        }
      }
      if ((paramObject instanceof aqdk.a)) {
        synchronized (this.IE)
        {
          this.IE.remove(paramObject);
          return;
        }
      }
    } while (!(paramObject instanceof aqdk.f));
    synchronized (this.IF)
    {
      this.IF.remove(paramObject);
      return;
    }
  }
  
  public final void c(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.IE != null) && (this.IE.size() > 0)) {
      synchronized (this.IE)
      {
        Iterator localIterator = this.IE.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (aqdk.a)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public final void d(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.IF != null) && (this.IF.size() > 0)) {
      synchronized (this.IF)
      {
        Iterator localIterator = this.IF.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (aqdk.f)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void d(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(paramSetting);
  }
  
  /* Error */
  public void e(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 235	aqdm:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 237	com/tencent/mobileqq/app/NearByFaceDownloader
    //   15: dup
    //   16: aload_0
    //   17: getfield 51	aqdm:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   20: invokespecial 240	com/tencent/mobileqq/app/NearByFaceDownloader:<init>	(Lcom/tencent/mobileqq/nearby/NearbyAppInterface;)V
    //   23: putfield 235	aqdm:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   26: aload_0
    //   27: getfield 235	aqdm:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: getfield 235	aqdm:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   37: aload_1
    //   38: invokevirtual 344	com/tencent/mobileqq/app/NearByFaceDownloader:b	(Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: ldc 134
    //   47: iconst_1
    //   48: aload_2
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	aqdm
    //   0	64	1	paramFaceInfo	FaceInfo
    //   6	2	2	localNearByFaceDownloader	NearByFaceDownloader
    //   44	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   11	26	44	java/lang/OutOfMemoryError
    //   2	7	59	finally
    //   11	26	59	finally
    //   26	41	59	finally
    //   45	56	59	finally
  }
  
  public void g(ArrayList<String> paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().g(paramArrayList, paramLong);
  }
  
  public Setting getFaceSetting(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getFaceSetting(paramString);
  }
  
  public void onDestroy()
  {
    if (this.v != null)
    {
      this.ID.clear();
      this.v.removeObserver(this.jdField_a_of_type_Aqdm$b);
      this.IE.clear();
      this.v.removeObserver(this.jdField_a_of_type_Aqdm$a);
      this.v.removeObserver(this.jdField_a_of_type_Aqdm$c);
    }
  }
  
  class a
    extends acdv
  {
    private a() {}
    
    protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      aqdm.this.c(1007, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
    }
  }
  
  class b
    extends acfd
  {
    private b() {}
    
    protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      aqdm.this.b(4, paramBoolean, new Object[] { paramString });
    }
    
    public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
    {
      aqdm.this.b(39, paramBoolean, new Object[] { paramString });
    }
    
    protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      aqdm.this.b(6, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
    }
    
    protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      aqdm.this.b(5, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
    }
    
    protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      aqdm.this.b(30, paramBoolean, new Object[] { paramString });
    }
  }
  
  class c
    extends acnd
  {
    private c() {}
    
    protected void h(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      aqdm.this.d(106, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdm
 * JD-Core Version:    0.7.0.1
 */