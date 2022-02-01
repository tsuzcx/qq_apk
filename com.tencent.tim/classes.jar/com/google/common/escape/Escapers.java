package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Escapers
{
  private static final Escaper NULL_ESCAPER = new Escapers.1();
  
  static UnicodeEscaper asUnicodeEscaper(Escaper paramEscaper)
  {
    Preconditions.checkNotNull(paramEscaper);
    if ((paramEscaper instanceof UnicodeEscaper)) {
      return (UnicodeEscaper)paramEscaper;
    }
    if ((paramEscaper instanceof CharEscaper)) {
      return wrap((CharEscaper)paramEscaper);
    }
    throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + paramEscaper.getClass().getName());
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static String computeReplacement(CharEscaper paramCharEscaper, char paramChar)
  {
    return stringOrNull(paramCharEscaper.escape(paramChar));
  }
  
  public static String computeReplacement(UnicodeEscaper paramUnicodeEscaper, int paramInt)
  {
    return stringOrNull(paramUnicodeEscaper.escape(paramInt));
  }
  
  public static Escaper nullEscaper()
  {
    return NULL_ESCAPER;
  }
  
  private static String stringOrNull(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    return new String(paramArrayOfChar);
  }
  
  private static UnicodeEscaper wrap(CharEscaper paramCharEscaper)
  {
    return new Escapers.2(paramCharEscaper);
  }
  
  @Beta
  public static final class Builder
  {
    private final Map<Character, String> replacementMap = new HashMap();
    private char safeMax = 65535;
    private char safeMin = '\000';
    private String unsafeReplacement = null;
    
    @CanIgnoreReturnValue
    public Builder addEscape(char paramChar, String paramString)
    {
      Preconditions.checkNotNull(paramString);
      this.replacementMap.put(Character.valueOf(paramChar), paramString);
      return this;
    }
    
    public Escaper build()
    {
      return new Escapers.Builder.1(this, this.replacementMap, this.safeMin, this.safeMax);
    }
    
    @CanIgnoreReturnValue
    public Builder setSafeRange(char paramChar1, char paramChar2)
    {
      this.safeMin = paramChar1;
      this.safeMax = paramChar2;
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder setUnsafeReplacement(@Nullable String paramString)
    {
      this.unsafeReplacement = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Escapers
 * JD-Core Version:    0.7.0.1
 */