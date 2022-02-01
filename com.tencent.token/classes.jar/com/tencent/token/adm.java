package com.tencent.token;

import android.app.Activity;
import com.tencent.turingfd.sdk.qps.Grapefruit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class adm
{
  public static List<ado> a = new ArrayList();
  public static adr b;
  public static Set<String> c = new HashSet();
  public static final ado d = new a();
  public static adr e = new b();
  
  public final class a
    implements ado
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Grapefruit paramGrapefruit)
    {
      Iterator localIterator = adm.a.iterator();
      while (localIterator.hasNext())
      {
        ado localado = (ado)localIterator.next();
        if (localado != null) {
          localado.a(paramString, paramInt1, paramInt2, paramGrapefruit);
        }
      }
    }
  }
  
  public final class b
    implements adr
  {
    public final void a(Activity paramActivity)
    {
      Object localObject = adm.b;
      if (localObject != null) {
        ((adr)localObject).a(paramActivity);
      }
      int i;
      if (adm.c.contains(paramActivity.getClass().getName())) {
        i = 100;
      } else {
        i = 999;
      }
      localObject = adn.a();
      paramActivity.getApplicationContext();
      ((adn)localObject).a(paramActivity.getClass().getName(), i, adm.d);
    }
    
    public final void b(Activity paramActivity)
    {
      adn localadn = adn.a();
      paramActivity.getApplicationContext();
      localadn.a(paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adm
 * JD-Core Version:    0.7.0.1
 */