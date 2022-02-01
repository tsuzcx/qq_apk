package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.ui.qqpim.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class h
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
  
  public static h a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    h localh = new h();
    localh.c = paramString1;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("pkglist")) {
        localh.e = b(paramString2.getString("pkglist"));
      }
      if (paramString2.has("mode")) {
        localh.d = paramString2.getInt("mode");
      }
      if (paramString2.has("img1")) {
        localh.f = paramString2.getString("img1");
      }
      if (paramString2.has("img2")) {
        localh.g = paramString2.getString("img2");
      }
      if (paramString2.has("img3")) {
        localh.h = paramString2.getString("img3");
      }
      if (paramString2.has("text1")) {
        localh.i = paramString2.getString("text1");
      }
      if (paramString2.has("text2")) {
        localh.j = paramString2.getString("text2");
      }
      if (paramString2.has("text3")) {
        localh.k = paramString2.getString("text3");
      }
      if (paramString2.has("text4")) {
        localh.l = paramString2.getString("text4");
      }
      if (paramString2.has("text5")) {
        localh.m = paramString2.getString("text5");
      }
      if (paramString2.has("text6")) {
        localh.n = paramString2.getString("text6");
      }
      if (paramString2.has("text7")) {
        localh.o = paramString2.getString("text7");
      }
      if (paramString2.has("text8")) {
        localh.p = paramString2.getString("text8");
      }
      if (paramString2.has("lastpkg")) {
        localh.q = paramString2.getString("lastpkg");
      }
      if (paramString2.has("interval")) {
        localh.s = paramString2.getInt("interval");
      }
      if (paramString2.has("begin")) {
        localh.t = paramString2.getLong("begin");
      }
      if (paramString2.has("end")) {
        localh.u = paramString2.getLong("end");
      }
      paramString1 = localh;
      if (paramString2.has("timestamp"))
      {
        localh.r = paramString2.getLong("timestamp");
        return localh;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = null;
    }
    return paramString1;
  }
  
  static String a(int paramInt, String paramString)
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
  
  private String b(Context paramContext, HashSet<String> paramHashSet)
  {
    int i1 = a;
    int i2 = this.d;
    Object localObject1;
    Object localObject2;
    if (i1 == i2)
    {
      localObject1 = this.e.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (((paramHashSet != null) && (paramHashSet.contains(localObject2))) || (a.b(paramContext, (String)localObject2)));
      return localObject2;
    }
    if (b == i2)
    {
      localObject1 = new ArrayList();
      localObject2 = this.e.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (((paramHashSet == null) || (!paramHashSet.contains(str))) && (!a.b(paramContext, str))) {
          ((ArrayList)localObject1).add(str);
        }
      }
      if (((ArrayList)localObject1).size() == 1) {
        return (String)((ArrayList)localObject1).get(0);
      }
      i1 = -1;
      if (!TextUtils.isEmpty(this.q))
      {
        ((ArrayList)localObject1).remove(this.q);
        if (((ArrayList)localObject1).size() == 1) {
          return (String)((ArrayList)localObject1).get(0);
        }
        i1 = this.e.indexOf(this.q);
      }
      paramContext = ((ArrayList)localObject1).iterator();
      while (paramContext.hasNext())
      {
        paramHashSet = (String)paramContext.next();
        if (this.e.indexOf(paramHashSet) > i1) {
          return paramHashSet;
        }
      }
      if (((ArrayList)localObject1).size() > 0) {
        return (String)((ArrayList)localObject1).get(0);
      }
    }
    return null;
  }
  
  static ArrayList<String> b(String paramString)
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
  
  public j a(Context paramContext, HashSet<String> paramHashSet)
  {
    paramHashSet = b(paramContext, paramHashSet);
    if (TextUtils.isEmpty(paramHashSet)) {
      return null;
    }
    int i1 = this.e.indexOf(paramHashSet);
    if (i1 < 0) {
      return null;
    }
    paramContext = new j();
    paramContext.a = paramHashSet;
    paramContext.d = a(i1, this.i);
    paramContext.e = a(i1, this.j);
    paramContext.f = a(i1, this.k);
    paramContext.g = a(i1, this.l);
    paramContext.b = a(i1, this.f);
    paramContext.c = a(i1, this.g);
    paramContext.h = new ArrayList();
    paramHashSet = a(i1, this.m);
    if (!TextUtils.isEmpty(paramHashSet)) {
      paramContext.h.add(paramHashSet);
    }
    paramHashSet = a(i1, this.n);
    if (!TextUtils.isEmpty(paramHashSet)) {
      paramContext.h.add(paramHashSet);
    }
    paramHashSet = a(i1, this.o);
    if (!TextUtils.isEmpty(paramHashSet)) {
      paramContext.h.add(paramHashSet);
    }
    paramHashSet = a(i1, this.p);
    if (!TextUtils.isEmpty(paramHashSet)) {
      paramContext.h.add(paramHashSet);
    }
    return paramContext;
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
    this.r = System.currentTimeMillis();
    paramString = b();
    if ((paramString != null) && (!TextUtils.isEmpty(this.c))) {
      ed.b(this.c, paramString.toString());
    }
  }
  
  public boolean a()
  {
    if ((this.s > 0L) && (System.currentTimeMillis() - this.r < this.s * 3600000L)) {
      return false;
    }
    if ((this.t > 0L) && (System.currentTimeMillis() < this.t * 1000L)) {
      return false;
    }
    return (this.u <= 0L) || (System.currentTimeMillis() <= this.u * 1000L);
  }
  
  public JSONObject b()
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
  
  public String toString()
  {
    JSONObject localJSONObject = b();
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "invalid guideinfo.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.h
 * JD-Core Version:    0.7.0.1
 */