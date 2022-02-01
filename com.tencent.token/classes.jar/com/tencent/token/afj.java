package com.tencent.token;

import android.security.keystore.KeyGenParameterSpec.Builder;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class afj
{
  public abstract afj a(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec a();
  
  public abstract afj b(String... paramVarArgs);
  
  public static final class a
    extends afj
  {
    public KeyGenParameterSpec.Builder a = null;
    
    public a(String paramString, int paramInt)
    {
      this.a = new KeyGenParameterSpec.Builder(paramString, paramInt);
    }
    
    public final afj a(String... paramVarArgs)
    {
      this.a.setDigests(paramVarArgs);
      return this;
    }
    
    public final AlgorithmParameterSpec a()
    {
      return this.a.build();
    }
    
    public final afj b(String... paramVarArgs)
    {
      this.a.setSignaturePaddings(paramVarArgs);
      return this;
    }
  }
  
  public static final class b
    extends afj
  {
    public final String a;
    public int b;
    public String[] c;
    public String[] d;
    
    public b(String paramString, int paramInt)
    {
      if (paramString != null)
      {
        if (!paramString.isEmpty())
        {
          this.a = paramString;
          this.b = paramInt;
          return;
        }
        throw new IllegalArgumentException("keystoreAlias must not be empty");
      }
      throw new NullPointerException("keystoreAlias == null");
    }
    
    public final afj a(String... paramVarArgs)
    {
      this.c = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public final AlgorithmParameterSpec a()
    {
      Class localClass1 = Class.forName("android.security.keystore.KeyGenParameterSpec");
      Class localClass2 = Integer.TYPE;
      Class localClass3 = Boolean.TYPE;
      return (AlgorithmParameterSpec)localClass1.getConstructor(new Class[] { String.class, localClass2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, localClass2, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, localClass3, localClass3, localClass2 }).newInstance(new Object[] { this.a, Integer.valueOf(-1), null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, Integer.valueOf(-1) });
    }
    
    public final afj b(String... paramVarArgs)
    {
      this.d = ((String[])paramVarArgs.clone());
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afj
 * JD-Core Version:    0.7.0.1
 */