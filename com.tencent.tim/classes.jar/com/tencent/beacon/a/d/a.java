package com.tencent.beacon.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.base.util.e;
import java.util.Map;
import java.util.Set;

public class a
  implements SharedPreferences
{
  private static volatile a a;
  private boolean b;
  private g c;
  private a d;
  private SharedPreferences e;
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private <T> Object a(@NonNull String paramString, T paramT)
  {
    if (!this.b) {
      return paramT;
    }
    Object localObject1 = this.c.a(paramString, paramT);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1 != paramT) {}
    }
    else
    {
      localObject2 = c.d().c();
      if (this.e == null) {
        this.e = ((Context)localObject2).getSharedPreferences("DENGTA_META", 0);
      }
      if (!(paramT instanceof Boolean)) {
        break label121;
      }
      localObject1 = Boolean.valueOf(this.e.getBoolean(paramString, ((Boolean)paramT).booleanValue()));
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1 != paramT)
        {
          this.c.b(paramString, localObject1);
          localObject2 = localObject1;
        }
      }
      if (localObject2 == null) {
        break;
      }
      return localObject2;
      label121:
      if ((paramT instanceof String)) {
        localObject1 = this.e.getString(paramString, (String)paramT);
      } else if ((paramT instanceof Integer)) {
        localObject1 = Integer.valueOf(this.e.getInt(paramString, ((Integer)paramT).intValue()));
      } else if ((paramT instanceof Long)) {
        localObject1 = Long.valueOf(this.e.getLong(paramString, ((Long)paramT).longValue()));
      } else if ((paramT instanceof Float)) {
        localObject1 = Float.valueOf(this.e.getFloat(paramString, ((Float)paramT).floatValue()));
      }
    }
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/beacon/a/d/a:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_1
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: invokestatic 128	com/tencent/beacon/a/c/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_1
    //   24: invokevirtual 132	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload_3
    //   30: aload 4
    //   32: ldc 134
    //   34: invokevirtual 138	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   37: astore_3
    //   38: new 140	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: aload 4
    //   51: ldc 143
    //   53: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 153	com/tencent/beacon/a/d/g:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/a/d/g;
    //   66: putfield 33	com/tencent/beacon/a/d/a:c	Lcom/tencent/beacon/a/d/g;
    //   69: aload_0
    //   70: new 8	com/tencent/beacon/a/d/a$a
    //   73: dup
    //   74: aload_0
    //   75: getfield 33	com/tencent/beacon/a/d/a:c	Lcom/tencent/beacon/a/d/g;
    //   78: invokespecial 156	com/tencent/beacon/a/d/a$a:<init>	(Lcom/tencent/beacon/a/d/g;)V
    //   81: putfield 158	com/tencent/beacon/a/d/a:d	Lcom/tencent/beacon/a/d/a$a;
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 31	com/tencent/beacon/a/d/a:b	Z
    //   89: goto -74 -> 15
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic 163	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   97: invokestatic 168	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   100: ldc 170
    //   102: ldc 172
    //   104: aload_1
    //   105: invokevirtual 175	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 31	com/tencent/beacon/a/d/a:b	Z
    //   113: goto -98 -> 15
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	a
    //   0	121	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   22	35	3	str	String
    //   27	23	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	92	java/io/IOException
    //   29	47	92	java/io/IOException
    //   47	89	92	java/io/IOException
    //   2	7	116	finally
    //   18	29	116	finally
    //   29	47	116	finally
    //   47	89	116	finally
    //   93	113	116	finally
  }
  
  public boolean contains(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public a edit()
  {
    if (!this.b)
    {
      e.a("BeaconProperties has not init!");
      a(c.d().c());
    }
    return this.d;
  }
  
  public Map<String, ?> getAll()
  {
    return this.c.b();
  }
  
  public boolean getBoolean(@NonNull String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, Boolean.valueOf(paramBoolean));
    if ((paramString instanceof Boolean)) {
      paramBoolean = ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public float getFloat(@NonNull String paramString, float paramFloat)
  {
    paramString = a(paramString, Float.valueOf(paramFloat));
    if ((paramString instanceof Number)) {
      paramFloat = ((Number)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public int getInt(@NonNull String paramString, int paramInt)
  {
    paramString = a(paramString, Integer.valueOf(paramInt));
    if ((paramString instanceof Number)) {
      paramInt = ((Number)paramString).intValue();
    }
    return paramInt;
  }
  
  public long getLong(@NonNull String paramString, long paramLong)
  {
    paramString = a(paramString, Long.valueOf(paramLong));
    if ((paramString instanceof Number)) {
      paramLong = ((Number)paramString).longValue();
    }
    return paramLong;
  }
  
  public String getString(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if ((paramString1 instanceof String)) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public Set<String> getStringSet(@NonNull String paramString, @Nullable Set<String> paramSet)
  {
    if (!this.b) {
      return paramSet;
    }
    return this.c.a(paramString, paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public static class a
    implements SharedPreferences.Editor
  {
    private g a;
    
    a(g paramg)
    {
      this.a = paramg;
    }
    
    public void apply() {}
    
    public SharedPreferences.Editor clear()
    {
      this.a.a();
      return this;
    }
    
    public boolean commit()
    {
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      this.a.b(paramString, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public SharedPreferences.Editor putFloat(@NonNull String paramString, float paramFloat)
    {
      this.a.b(paramString, Float.valueOf(paramFloat));
      return this;
    }
    
    public SharedPreferences.Editor putInt(@NonNull String paramString, int paramInt)
    {
      this.a.b(paramString, Integer.valueOf(paramInt));
      return this;
    }
    
    public SharedPreferences.Editor putLong(@NonNull String paramString, long paramLong)
    {
      this.a.b(paramString, Long.valueOf(paramLong));
      return this;
    }
    
    public SharedPreferences.Editor putString(@NonNull String paramString1, @NonNull String paramString2)
    {
      this.a.b(paramString1, paramString2);
      return this;
    }
    
    public SharedPreferences.Editor putStringSet(@NonNull String paramString, @NonNull Set<String> paramSet)
    {
      this.a.b(paramString, paramSet);
      return this;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      this.a.b(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.d.a
 * JD-Core Version:    0.7.0.1
 */