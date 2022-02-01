package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class lm
{
  public static int a = 1;
  public static int b = 2;
  private String c;
  private int d = b;
  private ArrayList<String> e = new ArrayList();
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private long r;
  private long s;
  private long t;
  private long u;
  
  public static lm a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    lm locallm = new lm();
    locallm.c = paramString1;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("pkglist")) {
        locallm.e = b(paramString2.getString("pkglist"));
      }
      if (paramString2.has("mode")) {
        locallm.d = paramString2.getInt("mode");
      }
      if (paramString2.has("img1")) {
        locallm.f = paramString2.getString("img1");
      }
      if (paramString2.has("img2")) {
        locallm.g = paramString2.getString("img2");
      }
      if (paramString2.has("img3")) {
        locallm.h = paramString2.getString("img3");
      }
      if (paramString2.has("text1")) {
        locallm.i = paramString2.getString("text1");
      }
      if (paramString2.has("text2")) {
        locallm.j = paramString2.getString("text2");
      }
      if (paramString2.has("text3")) {
        locallm.k = paramString2.getString("text3");
      }
      if (paramString2.has("text4")) {
        locallm.l = paramString2.getString("text4");
      }
      if (paramString2.has("text5")) {
        locallm.m = paramString2.getString("text5");
      }
      if (paramString2.has("text6")) {
        locallm.n = paramString2.getString("text6");
      }
      if (paramString2.has("text7")) {
        locallm.o = paramString2.getString("text7");
      }
      if (paramString2.has("text8")) {
        locallm.p = paramString2.getString("text8");
      }
      if (paramString2.has("lastpkg")) {
        locallm.q = paramString2.getString("lastpkg");
      }
      if (paramString2.has("interval")) {
        locallm.s = paramString2.getInt("interval");
      }
      if (paramString2.has("begin")) {
        locallm.t = paramString2.getLong("begin");
      }
      if (paramString2.has("end")) {
        locallm.u = paramString2.getLong("end");
      }
      paramString1 = locallm;
      if (paramString2.has("timestamp"))
      {
        locallm.r = paramString2.getLong("timestamp");
        return locallm;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = null;
    }
    return paramString1;
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = b(paramString);
      if (paramString.size() > paramInt) {
        return (String)paramString.get(paramInt);
      }
    }
    return null;
  }
  
  private static ArrayList<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split("\\|");
    if (paramString != null)
    {
      int i2 = paramString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localArrayList.add(paramString[i1]);
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("mode", this.d);
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject2.put("scene", this.c);
      }
      Object localObject = c();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject2.put("pkglist", localObject);
      }
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject2.put("img1", this.f);
      }
      if (!TextUtils.isEmpty(this.g)) {
        localJSONObject2.put("img2", this.g);
      }
      if (!TextUtils.isEmpty(this.h)) {
        localJSONObject2.put("img3", this.h);
      }
      if (!TextUtils.isEmpty(this.i)) {
        localJSONObject2.put("text1", this.i);
      }
      if (!TextUtils.isEmpty(this.j)) {
        localJSONObject2.put("text2", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        localJSONObject2.put("text3", this.k);
      }
      if (!TextUtils.isEmpty(this.l)) {
        localJSONObject2.put("text4", this.l);
      }
      if (!TextUtils.isEmpty(this.m)) {
        localJSONObject2.put("text5", this.m);
      }
      if (!TextUtils.isEmpty(this.n)) {
        localJSONObject2.put("text6", this.n);
      }
      if (!TextUtils.isEmpty(this.o)) {
        localJSONObject2.put("text7", this.o);
      }
      if (!TextUtils.isEmpty(this.p)) {
        localJSONObject2.put("text8", this.p);
      }
      if (!TextUtils.isEmpty(this.q)) {
        localJSONObject2.put("lastpkg", this.q);
      }
      if (this.r > 0L) {
        localJSONObject2.put("timestamp", this.r);
      }
      if (this.s > 0L) {
        localJSONObject2.put("interval", this.s);
      }
      if (this.t > 0L) {
        localJSONObject2.put("begin", this.t);
      }
      localObject = localJSONObject2;
      if (this.u > 0L)
      {
        localJSONObject2.put("end", this.u);
        return localJSONObject2;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      JSONObject localJSONObject1 = null;
      return localJSONObject1;
    }
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      if (this.e.indexOf(str) != this.e.size() - 1) {
        localStringBuilder.append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public final lo a(Context paramContext, HashSet<String> paramHashSet)
  {
    int i1 = a;
    int i2 = this.d;
    Iterator localIterator;
    Object localObject;
    if (i1 == i2)
    {
      localIterator = this.e.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
      } while (((paramHashSet != null) && (paramHashSet.contains(localObject))) || (zx.b(paramContext, (String)localObject)));
      paramContext = (Context)localObject;
    }
    else
    {
      if (b == i2)
      {
        localObject = new ArrayList();
        localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((paramHashSet == null) || (!paramHashSet.contains(str))) && (!zx.b(paramContext, str))) {
            ((ArrayList)localObject).add(str);
          }
        }
        if (((ArrayList)localObject).size() == 1)
        {
          paramContext = (String)((ArrayList)localObject).get(0);
          break label297;
        }
        i1 = -1;
        if (!TextUtils.isEmpty(this.q))
        {
          ((ArrayList)localObject).remove(this.q);
          if (((ArrayList)localObject).size() == 1)
          {
            paramContext = (String)((ArrayList)localObject).get(0);
            break label297;
          }
          i1 = this.e.indexOf(this.q);
        }
        paramHashSet = ((ArrayList)localObject).iterator();
        while (paramHashSet.hasNext())
        {
          paramContext = (String)paramHashSet.next();
          if (this.e.indexOf(paramContext) > i1) {
            break label297;
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          paramContext = (String)((ArrayList)localObject).get(0);
          break label297;
        }
      }
      paramContext = null;
    }
    label297:
    if (TextUtils.isEmpty(paramContext)) {
      return null;
    }
    i1 = this.e.indexOf(paramContext);
    if (i1 < 0) {
      return null;
    }
    paramHashSet = new lo();
    paramHashSet.a = paramContext;
    paramHashSet.d = a(i1, this.i);
    paramHashSet.e = a(i1, this.j);
    paramHashSet.f = a(i1, this.k);
    paramHashSet.g = a(i1, this.l);
    paramHashSet.b = a(i1, this.f);
    paramHashSet.c = a(i1, this.g);
    paramHashSet.h = new ArrayList();
    paramContext = a(i1, this.m);
    if (!TextUtils.isEmpty(paramContext)) {
      paramHashSet.h.add(paramContext);
    }
    paramContext = a(i1, this.n);
    if (!TextUtils.isEmpty(paramContext)) {
      paramHashSet.h.add(paramContext);
    }
    paramContext = a(i1, this.o);
    if (!TextUtils.isEmpty(paramContext)) {
      paramHashSet.h.add(paramContext);
    }
    paramContext = a(i1, this.p);
    if (!TextUtils.isEmpty(paramContext)) {
      paramHashSet.h.add(paramContext);
    }
    return paramHashSet;
  }
  
  public final void a(String paramString)
  {
    this.q = paramString;
    this.r = System.currentTimeMillis();
    paramString = b();
    if ((paramString != null) && (!TextUtils.isEmpty(this.c))) {
      aic.b(this.c, paramString.toString());
    }
  }
  
  public final boolean a()
  {
    if ((this.s > 0L) && (Math.abs(System.currentTimeMillis() - this.r) < this.s * 3600000L)) {
      return false;
    }
    if ((this.t > 0L) && (System.currentTimeMillis() < this.t * 1000L)) {
      return false;
    }
    return (this.u <= 0L) || (System.currentTimeMillis() <= this.u * 1000L);
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = b();
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "invalid guideinfo.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lm
 * JD-Core Version:    0.7.0.1
 */