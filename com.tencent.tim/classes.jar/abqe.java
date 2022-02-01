import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class abqe
{
  public HashMap<String, abqd> iu;
  private WeakReference<Context> mContextRef;
  private int mGameId;
  
  public abqe(Context paramContext, int paramInt)
  {
    this.mContextRef = new WeakReference(paramContext);
    this.mGameId = paramInt;
  }
  
  public void A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    abqd localabqd;
    if (!TextUtils.isEmpty(paramString1))
    {
      localabqd = null;
      if (this.iu != null) {
        localabqd = (abqd)this.iu.get(paramString1);
      }
      if (localabqd == null) {
        break label45;
      }
      localabqd.a(paramString2, paramString4, this);
    }
    label45:
    do
    {
      do
      {
        return;
      } while ("destroy".equals(paramString3));
      localabqd = a(paramString1);
    } while (localabqd == null);
    if (this.iu == null) {
      this.iu = new HashMap();
    }
    this.iu.put(paramString1, localabqd);
    A(paramString1, paramString2, paramString3, paramString4);
  }
  
  public abqd a(String paramString)
  {
    abpw localabpw = null;
    Object localObject = null;
    if ("Dialog".equals(paramString))
    {
      localabpw = new abpw();
      if (this.mContextRef != null) {
        break label38;
      }
    }
    label38:
    for (paramString = localObject;; paramString = (Context)this.mContextRef.get())
    {
      localabpw.am(paramString);
      return localabpw;
    }
  }
  
  public void a(abqd paramabqd)
  {
    if ((this.iu != null) && (paramabqd != null)) {
      this.iu.remove(paramabqd.getNameSpace());
    }
  }
  
  public void aq(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = abmt.a(this.mGameId);
    if (paramString1 != null)
    {
      paramString1 = paramString1.b();
      if (paramString1 != null) {
        paramString1.runRenderTask(new NativeUIManager.1(this, paramString1, paramString2, paramString3));
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.iu != null)
    {
      Iterator localIterator = this.iu.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (abqd)this.iu.get(localObject);
          if (localObject != null) {
            ((abqd)localObject).onDestroy();
          }
        }
      }
      this.iu.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqe
 * JD-Core Version:    0.7.0.1
 */