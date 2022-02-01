import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class kfr
{
  ReadinjoyTabFrame.a a;
  protected Activity activity;
  protected Map<Integer, Set<Long>> dB = new HashMap();
  protected Map<Integer, Boolean> dC = new HashMap();
  protected Map<Integer, Map<Long, mgu>> dD = new HashMap();
  protected Map<Integer, mgu> dE = new HashMap();
  int mChannelCoverId;
  
  protected kfr() {}
  
  protected kfr(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void O(boolean paramBoolean, int paramInt) {}
  
  public Map<Long, mgu> a(Integer paramInteger)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramInteger = (Map)this.dD.get(paramInteger);
    if ((paramInteger != null) && (!paramInteger.isEmpty())) {
      localConcurrentHashMap.putAll(paramInteger);
    }
    return localConcurrentHashMap;
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.dB.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.dB.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public mye a()
  {
    return null;
  }
  
  public myp a()
  {
    return null;
  }
  
  public void a(ReadinjoyTabFrame.a parama, int paramInt)
  {
    this.a = parama;
    this.mChannelCoverId = paramInt;
  }
  
  public void aBY() {}
  
  public void aBZ() {}
  
  public void aCe() {}
  
  public Map<Long, mgu> b(Integer paramInteger)
  {
    Map localMap = (Map)this.dD.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.dD.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.dC.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public void finish() {}
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public void i(ViewGroup paramViewGroup) {}
  
  public ViewGroup j()
  {
    return null;
  }
  
  public void lP(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate()
  {
    awit.Xk(true);
  }
  
  public void onDestroy()
  {
    awit.Xk(false);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfr
 * JD-Core Version:    0.7.0.1
 */