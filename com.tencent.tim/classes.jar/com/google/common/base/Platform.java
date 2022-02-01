package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Platform
{
  private static final Logger logger = Logger.getLogger(Platform.class.getName());
  private static final PatternCompiler patternCompiler = loadPatternCompiler();
  
  static CommonPattern compilePattern(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return patternCompiler.compile(paramString);
  }
  
  static String formatCompact4Digits(double paramDouble)
  {
    return String.format(Locale.ROOT, "%.4g", new Object[] { Double.valueOf(paramDouble) });
  }
  
  static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> paramClass, String paramString)
  {
    paramString = (WeakReference)Enums.getEnumConstants(paramClass).get(paramString);
    if (paramString == null) {
      return Optional.absent();
    }
    return Optional.of(paramClass.cast(paramString.get()));
  }
  
  private static PatternCompiler loadPatternCompiler()
  {
    return new JdkPatternCompiler(null);
  }
  
  private static void logPatternCompilerError(ServiceConfigurationError paramServiceConfigurationError)
  {
    logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", paramServiceConfigurationError);
  }
  
  static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher)
  {
    return paramCharMatcher.precomputedInternal();
  }
  
  static boolean stringIsNullOrEmpty(@Nullable String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
  
  static long systemNanoTime()
  {
    return System.nanoTime();
  }
  
  static boolean usingJdkPatternCompiler()
  {
    return patternCompiler instanceof JdkPatternCompiler;
  }
  
  static final class JdkPatternCompiler
    implements PatternCompiler
  {
    public CommonPattern compile(String paramString)
    {
      return new JdkPattern(Pattern.compile(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Platform
 * JD-Core Version:    0.7.0.1
 */