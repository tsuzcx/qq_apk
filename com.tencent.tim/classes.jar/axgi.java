import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class axgi
{
  private awtq c;
  private Set<Integer> dB;
  private Activity mActivity;
  private volatile boolean mIsInited;
  private View mRootView;
  private Map<Integer, axgh> qF = new HashMap();
  
  public axgi(Activity paramActivity, View paramView, awtq paramawtq)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramView;
    this.c = paramawtq;
    this.dB = I();
  }
  
  private Set<Integer> I()
  {
    HashSet localHashSet = new HashSet();
    int j = axcg.a.getId();
    int i = j;
    if (this.mActivity != null)
    {
      i = j;
      if (this.mActivity.getIntent() != null) {
        i = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
      }
    }
    if ((axcg.c.ob(i)) || (axcg.t.ob(i)) || (axcg.n.ob(i)) || (axcg.e.ob(i)) || (axcg.oe(i)))
    {
      localHashSet.add(Integer.valueOf(131072));
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(458752));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      localHashSet.add(Integer.valueOf(655360));
      localHashSet.add(Integer.valueOf(786432));
    }
    for (;;)
    {
      if (axcg.b(this.c) == 204)
      {
        localHashSet.remove(Integer.valueOf(786432));
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (axcg.b(this.c) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      return localHashSet;
      if (axcg.e.ob(i))
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
        localHashSet.add(Integer.valueOf(786432));
      }
      else if ((axcg.C.ob(i)) || (axcg.B.ob(i)))
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
      }
      else if (axcg.w.ob(i))
      {
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(786432));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(393216));
      }
      else
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
        localHashSet.add(Integer.valueOf(786432));
      }
    }
  }
  
  private void adM(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        this.qF.put(Integer.valueOf(paramInt), localObject);
      }
      return;
      localObject = new axco(this.mActivity, this.mRootView, this);
      continue;
      localObject = new awxv(this.mActivity, this.mRootView, this);
      continue;
      localObject = new awxg(this.mActivity, this.mRootView, this);
      continue;
      localObject = new awyk(this.mActivity, this.mRootView, this);
      continue;
      localObject = new awwq(this.mActivity, this.mRootView, this);
      continue;
      localObject = new axga(this.mActivity, this.mRootView, this);
      continue;
      localObject = new axaf(this.mActivity, this.mRootView, this);
      continue;
      localObject = new axap(this.mActivity, this.mRootView, this);
      continue;
      localObject = new axgv(this.mActivity, (ViewStub)this.mRootView.findViewById(2131362317), this);
      continue;
      localObject = new awyw(this.mActivity, this.mRootView, this);
      continue;
      localObject = new axcv(this.mActivity, this.mRootView, this);
    }
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.c;
  }
  
  private void eJn()
  {
    Iterator localIterator = this.dB.iterator();
    while (localIterator.hasNext()) {
      adM(((Integer)localIterator.next()).intValue());
    }
  }
  
  private void initView()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).initView();
    }
  }
  
  private int lF(int paramInt)
  {
    Iterator localIterator = this.dB.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >> 16 == localInteger.intValue() >> 16) {
        return localInteger.intValue();
      }
    }
    return 65536;
  }
  
  private void q(int paramInt, Object... paramVarArgs) {}
  
  public axbr a(int paramInt)
  {
    paramInt = lF(paramInt);
    axgh localaxgh = (axgh)this.qF.get(Integer.valueOf(paramInt));
    if ((localaxgh instanceof awxv)) {
      return ((awxv)localaxgh).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = lF(paramInt);
    axgh localaxgh = (axgh)this.qF.get(Integer.valueOf(i));
    if (localaxgh != null) {
      return localaxgh.a(paramInt, paramVarArgs);
    }
    return b(paramInt, paramVarArgs);
  }
  
  public void init()
  {
    try
    {
      if (!this.mIsInited)
      {
        eJn();
        initView();
        this.mIsInited = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean ol(int paramInt)
  {
    paramInt = lF(paramInt);
    return (axgh)this.qF.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void onActivityPause()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onActivityPause();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onActivityResume();
    }
  }
  
  public void onActivityStart()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onActivityStop();
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.qF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((axgh)this.qF.get(localInteger)).onDestroy();
    }
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    int i = lF(paramInt);
    axgh localaxgh = (axgh)this.qF.get(Integer.valueOf(i));
    if (localaxgh != null)
    {
      localaxgh.p(paramInt, paramVarArgs);
      return;
    }
    q(paramInt, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgi
 * JD-Core Version:    0.7.0.1
 */