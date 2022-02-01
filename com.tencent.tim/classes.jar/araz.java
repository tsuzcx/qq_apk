import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebView;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class araz
{
  private araz.b jdField_a_of_type_Araz$b = new arba(this);
  final araz.c jdField_a_of_type_Araz$c;
  final araz.d jdField_a_of_type_Araz$d;
  final int eeb;
  final ConcurrentHashMap<Integer, Object> ji;
  
  public araz(araz.d paramd, int paramInt, araz.c paramc)
  {
    this.jdField_a_of_type_Araz$d = paramd;
    this.eeb = paramInt;
    this.jdField_a_of_type_Araz$c = paramc;
    int i = 0;
    while (i < 32)
    {
      int k = j;
      if ((1 << i & paramInt) != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    this.ji = new ConcurrentHashMap(j);
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.ji.values().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject = paramBundle.next();
      if ((localObject instanceof araz.a)) {
        ((araz.a)localObject).P(paramInt, localBundle);
      }
    }
  }
  
  public <T> T q(int paramInt)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      Object localObject4;
      try
      {
        if ((this.eeb & paramInt) == 0) {
          break label250;
        }
        localObject4 = this.ji.get(Integer.valueOf(paramInt));
        Object localObject1 = localObject4;
        if (localObject4 != null) {
          break label136;
        }
        if (this.jdField_a_of_type_Araz$c == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Araz$c.f(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new arbs();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof araz.a))
        {
          localObject4 = (araz.a)localObject3;
          ((araz.a)localObject4).jdField_a_of_type_Araz$b = this.jdField_a_of_type_Araz$b;
          ((araz.a)localObject4).egS();
        }
        this.ji.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new arbk(this.jdField_a_of_type_Araz$b);
          break;
          localObject3 = new arcd();
          break;
          localObject3 = new arbt();
          break;
          localObject3 = new arbf(this.jdField_a_of_type_Araz$b.getActivity());
          break;
          localObject3 = new arbz();
          break;
          localObject3 = new arcb(this.jdField_a_of_type_Araz$b.getActivity());
          break;
          localObject3 = new arbi();
          break;
          localObject3 = new arbo();
          break;
          localObject3 = null;
        }
        localObject3 = localObject4;
      } while (localObject4 != null);
      localObject3 = localObject4;
      switch (paramInt)
      {
      }
    }
  }
  
  public static class a
  {
    protected araz.b a;
    
    public void P(int paramInt, Bundle paramBundle) {}
    
    public void egS() {}
  }
  
  public static abstract interface b
  {
    public abstract WebViewFragment b();
    
    public abstract araz c();
    
    public abstract Activity getActivity();
    
    public abstract WebView getWebView();
  }
  
  public static abstract interface c
  {
    public abstract Object f(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract WebViewFragment a();
    
    public abstract WebView b();
    
    public abstract Activity getHostActivity();
  }
  
  public static abstract interface e
  {
    public abstract araz b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     araz
 * JD-Core Version:    0.7.0.1
 */