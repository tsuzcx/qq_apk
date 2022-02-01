package com.tencent.token;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class ek
{
  private static final es<String, Typeface> a = new es(16);
  private static final el b = new el("fonts");
  private static final Object c = new Object();
  private static final ex<String, ArrayList<el.a<c>>> d = new ex();
  private static final Comparator<byte[]> e = new Comparator() {};
  
  public static Typeface a(Context paramContext, final ej paramej, do.a arg2, boolean paramBoolean, int paramInt1, final int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramej.f);
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(paramInt2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = (Typeface)a.a(localObject1);
    if (localObject2 != null)
    {
      if (??? != null) {
        ???.a((Typeface)localObject2);
      }
      return localObject2;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = b(paramContext, paramej, paramInt2);
      if (??? != null) {
        if (paramContext.b == 0) {
          ???.a(paramContext.a, null);
        } else {
          ???.a(paramContext.b, null);
        }
      }
      return paramContext.a;
    }
    paramej = new Callable() {};
    if (paramBoolean) {}
    try
    {
      paramContext = ((c)b.a(paramej, paramInt1)).a;
      return paramContext;
    }
    catch (InterruptedException paramContext) {}
    if (??? == null) {
      paramContext = null;
    } else {
      paramContext = new el.a() {};
    }
    synchronized (c)
    {
      if (d.containsKey(localObject1))
      {
        if (paramContext != null) {
          ((ArrayList)d.get(localObject1)).add(paramContext);
        }
        return null;
      }
      if (paramContext != null)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(paramContext);
        d.put(localObject1, localObject2);
      }
      paramContext = b;
      ??? = new el.a() {};
      paramContext.a(new el.2(paramContext, paramej, new Handler(), ???));
      return null;
    }
    return null;
  }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, b[] paramArrayOfb)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfb[i];
      if (((b)localObject).e == 0)
      {
        localObject = ((b)localObject).a;
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, dx.a(paramContext, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static boolean a(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static b[] a(Context paramContext, ej paramej, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    Object localObject = null;
    paramString = localObject;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT > 16)
        {
          paramString = localObject;
          paramContext = paramContext.getContentResolver();
          paramString = localObject;
          paramej = paramej.c;
          paramString = localObject;
          paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramej }, null, null);
        }
        else
        {
          paramString = localObject;
          paramContext = paramContext.getContentResolver();
          paramString = localObject;
          paramej = paramej.c;
          paramString = localObject;
          paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramej }, null);
        }
        paramej = localArrayList;
        if (paramContext != null)
        {
          paramej = localArrayList;
          paramString = paramContext;
          if (paramContext.getCount() > 0)
          {
            paramString = paramContext;
            int m = paramContext.getColumnIndex("result_code");
            paramString = paramContext;
            localArrayList = new ArrayList();
            paramString = paramContext;
            int n = paramContext.getColumnIndex("_id");
            paramString = paramContext;
            int i1 = paramContext.getColumnIndex("file_id");
            paramString = paramContext;
            int i2 = paramContext.getColumnIndex("font_ttc_index");
            paramString = paramContext;
            int i3 = paramContext.getColumnIndex("font_weight");
            paramString = paramContext;
            int i4 = paramContext.getColumnIndex("font_italic");
            paramej = localArrayList;
            paramString = paramContext;
            if (paramContext.moveToNext())
            {
              if (m == -1) {
                break label543;
              }
              paramString = paramContext;
              i = paramContext.getInt(m);
              if (i2 == -1) {
                break label548;
              }
              paramString = paramContext;
              j = paramContext.getInt(i2);
              if (i1 == -1)
              {
                paramString = paramContext;
                paramej = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
              }
              else
              {
                paramString = paramContext;
                paramej = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
              }
              if (i3 == -1) {
                break label554;
              }
              paramString = paramContext;
              k = paramContext.getInt(i3);
              if (i4 == -1) {
                break label562;
              }
              paramString = paramContext;
              if (paramContext.getInt(i4) != 1) {
                break label562;
              }
              bool = true;
              paramString = paramContext;
              localArrayList.add(new b(paramej, j, k, bool, i));
              continue;
            }
          }
        }
        if (paramContext != null) {
          paramContext.close();
        }
        return (b[])paramej.toArray(new b[0]);
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
      label543:
      int i = 0;
      continue;
      label548:
      int j = 0;
      continue;
      label554:
      int k = 400;
      continue;
      label562:
      boolean bool = false;
    }
  }
  
  private static c b(Context paramContext, ej paramej, int paramInt)
  {
    try
    {
      localObject3 = paramContext.getPackageManager();
      localObject1 = paramContext.getResources();
      localObject2 = paramej.a;
      localProviderInfo = ((PackageManager)localObject3).resolveContentProvider((String)localObject2, 0);
      if (localProviderInfo == null) {
        break label307;
      }
      if (!localProviderInfo.packageName.equals(paramej.b)) {
        break label260;
      }
      localObject2 = a(((PackageManager)localObject3).getPackageInfo(localProviderInfo.packageName, 64).signatures);
      Collections.sort((List)localObject2, e);
      if (paramej.d != null) {
        localObject1 = paramej.d;
      } else {
        localObject1 = dn.a((Resources)localObject1, paramej.e);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject2;
        ProviderInfo localProviderInfo;
        int j;
        label260:
        label307:
        continue;
        int i = 0;
        continue;
        i += 1;
        continue;
        Object localObject1 = null;
      }
    }
    if (i < ((List)localObject1).size())
    {
      localObject3 = new ArrayList((Collection)((List)localObject1).get(i));
      Collections.sort((List)localObject3, e);
      if (a((List)localObject2, (List)localObject3))
      {
        localObject1 = localProviderInfo;
        if (localObject1 == null) {
          paramej = new a(1, null);
        } else {
          paramej = new a(0, a(paramContext, paramej, ((ProviderInfo)localObject1).authority));
        }
        j = paramej.a;
        i = -3;
        if (j == 0)
        {
          paramContext = ds.a(paramContext, paramej.b, paramInt);
          if (paramContext != null) {
            i = 0;
          }
          return new c(paramContext, i);
        }
        if (paramej.a == 1) {
          i = -2;
        }
        return new c(null, i);
        paramContext = new StringBuilder("Found content provider ");
        paramContext.append((String)localObject2);
        paramContext.append(", but package was not ");
        paramContext.append(paramej.b);
        throw new PackageManager.NameNotFoundException(paramContext.toString());
        throw new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(localObject2)));
        return new c(null, -1);
      }
    }
  }
  
  public static final class a
  {
    final int a;
    final ek.b[] b;
    
    public a(int paramInt, ek.b[] paramArrayOfb)
    {
      this.a = paramInt;
      this.b = paramArrayOfb;
    }
  }
  
  public static final class b
  {
    public final Uri a;
    public final int b;
    public final int c;
    public final boolean d;
    final int e;
    
    public b(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.a = ((Uri)ew.a(paramUri));
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramBoolean;
      this.e = paramInt3;
    }
  }
  
  static final class c
  {
    final Typeface a;
    final int b;
    
    c(Typeface paramTypeface, int paramInt)
    {
      this.a = paramTypeface;
      this.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ek
 * JD-Core Version:    0.7.0.1
 */