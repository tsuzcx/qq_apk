import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class ayuz
  implements aolm.c
{
  private static ayuz a;
  public ayuz.b a;
  private Lock lock = new ReentrantLock();
  private HashMap<String, ayuz.a> rA = new HashMap();
  
  public ayuz()
  {
    this.jdField_a_of_type_Ayuz$b = new ayuz.b();
  }
  
  public static ayuz a()
  {
    if (jdField_a_of_type_Ayuz == null) {
      jdField_a_of_type_Ayuz = new ayuz();
    }
    return jdField_a_of_type_Ayuz;
  }
  
  private void a(FilterDesc paramFilterDesc, long paramLong, int paramInt)
  {
    if (paramFilterDesc != null) {}
    try
    {
      Object localObject2 = ((axpr)axov.a(5)).a;
      Object localObject1 = new ArrayList();
      if (localObject2 != null) {
        localObject1 = ((ayva.a)localObject2).a(0).filterList;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          } while (((QIMFilterCategoryItem)localObject2).categoryId != 103);
          localObject2 = ((QIMFilterCategoryItem)localObject2).za.iterator();
        }
      } while (!((String)((Iterator)localObject2).next()).equals(paramFilterDesc.name));
      long l = paramFilterDesc.bundle.getLong("requestStartTime", System.currentTimeMillis());
      sqn.n("record_filter_download", sqn.a(paramInt, System.currentTimeMillis() - l, paramFilterDesc.resurl, paramLong, paramFilterDesc.name));
      QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener report.");
      return;
    }
    catch (Exception paramFilterDesc)
    {
      QLog.i("VideoFilterListDownloader", 2, "Report exception.");
    }
  }
  
  private void a(FilterDesc paramFilterDesc, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    for (;;)
    {
      int i;
      try
      {
        ayuz.a locala = (ayuz.a)this.rA.get(paramFilterDesc.name);
        if ((locala != null) && (locala.GD != null))
        {
          i = 0;
          if (i < locala.GD.size())
          {
            ayuz.c localc = (ayuz.c)((WeakReference)locala.GD.get(i)).get();
            if (localc != null) {
              localArrayList.add(localc);
            }
          }
          else
          {
            locala.GD.clear();
            this.rA.remove(paramFilterDesc.name);
          }
        }
        else
        {
          this.lock.unlock();
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i = 0;
            if (i < localArrayList.size())
            {
              paramFilterDesc = (ayuz.c)localArrayList.get(i);
              if (paramFilterDesc != null) {
                paramFilterDesc.YO(paramBoolean);
              }
              i += 1;
              continue;
            }
          }
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      i += 1;
    }
  }
  
  /* Error */
  private boolean a(FilterDesc paramFilterDesc, ayuz.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	ayuz:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 166 1 0
    //   9: aload_0
    //   10: getfield 31	ayuz:rA	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 114	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   17: invokevirtual 170	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 8	ayuz$a
    //   23: astore 4
    //   25: aload 4
    //   27: ifnonnull +63 -> 90
    //   30: new 8	ayuz$a
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 202	ayuz$a:<init>	(Layuz;)V
    //   38: astore 4
    //   40: aload 4
    //   42: aload_1
    //   43: putfield 206	ayuz$a:d	Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   46: aload 4
    //   48: getfield 173	ayuz$a:GD	Ljava/util/ArrayList;
    //   51: new 182	java/lang/ref/WeakReference
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 209	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   59: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: aload_0
    //   64: getfield 31	ayuz:rA	Ljava/util/HashMap;
    //   67: aload_1
    //   68: getfield 114	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   71: aload 4
    //   73: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: iconst_0
    //   78: istore_3
    //   79: aload_0
    //   80: getfield 36	ayuz:lock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 196 1 0
    //   88: iload_3
    //   89: ireturn
    //   90: aload 4
    //   92: getfield 173	ayuz$a:GD	Ljava/util/ArrayList;
    //   95: new 182	java/lang/ref/WeakReference
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 209	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   103: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -30 -> 79
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 36	ayuz:lock	Ljava/util/concurrent/locks/Lock;
    //   117: invokeinterface 196 1 0
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ayuz
    //   0	124	1	paramFilterDesc	FilterDesc
    //   0	124	2	paramc	ayuz.c
    //   78	31	3	bool	boolean
    //   23	68	4	locala	ayuz.a
    // Exception table:
    //   from	to	target	type
    //   9	25	112	finally
    //   30	77	112	finally
    //   90	107	112	finally
  }
  
  private void b(FilterDesc paramFilterDesc)
  {
    ThreadManager.getSubThreadHandler().post(new VideoFilterListDownloader.1(this, paramFilterDesc));
  }
  
  public static boolean b(FilterDesc paramFilterDesc)
  {
    String str = paramFilterDesc.getResFold(aywt.bej);
    ayva.a();
    File localFile = new File(str + "params.json");
    boolean bool = false;
    if (!localFile.exists()) {
      bool = true;
    }
    if ((!bool) && (paramFilterDesc.respicname != null) && (!paramFilterDesc.respicname.equals("")) && (!new File(str + paramFilterDesc.respicname).exists()))
    {
      QLog.i("VideoFilterListDownloader", 2, "check false respicname file not exists :" + paramFilterDesc.name);
      return true;
    }
    return bool;
  }
  
  public void a(FilterDesc paramFilterDesc, ayuz.c paramc)
  {
    if (!a(paramFilterDesc, paramc)) {
      b(paramFilterDesc);
    }
  }
  
  public void g(aomh paramaomh)
  {
    paramaomh = (FilterDesc)paramaomh.b.U();
    if (paramaomh != null) {
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener onFailed file: " + paramaomh.resurl);
    }
  }
  
  class a
  {
    public ArrayList<WeakReference<ayuz.c>> GD = new ArrayList();
    public FilterDesc d;
    
    a() {}
  }
  
  public class b
    implements aolm.b
  {
    b() {}
    
    public void onResp(aomh paramaomh)
    {
      boolean bool = false;
      FilterDesc localFilterDesc = (FilterDesc)paramaomh.b.U();
      if (localFilterDesc != null)
      {
        if (paramaomh.mResult == 0) {
          break label96;
        }
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + localFilterDesc.resurl);
        ayuz.a(ayuz.this, localFilterDesc, 0L, 5);
      }
      for (;;)
      {
        ayuz.a(ayuz.this, localFilterDesc, bool);
        return;
        label96:
        if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
        {
          QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
          aqhq.deleteFile(paramaomh.b.atY);
        }
        else
        {
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
          try
          {
            String str = aywt.bej;
            aqhq.W(paramaomh.b.atY, str, false);
            if (localFilterDesc.bundle == null) {
              localFilterDesc.bundle = new Bundle();
            }
            ayuz.a(ayuz.this, localFilterDesc, aqhq.getFileSizes(paramaomh.b.atY), 0);
            aqhq.deleteFile(paramaomh.b.atY);
            bool = true;
          }
          catch (IOException paramaomh)
          {
            paramaomh.printStackTrace();
            QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
            ayuz.a(ayuz.this, localFilterDesc, 0L, 4);
          }
        }
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface c
  {
    public abstract void YO(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuz
 * JD-Core Version:    0.7.0.1
 */