package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class StrSubstitutor
{
  public static final char DEFAULT_ESCAPE = '$';
  public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
  public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
  public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
  private boolean enableSubstitutionInVariables;
  private char escapeChar;
  private StrMatcher prefixMatcher;
  private StrMatcher suffixMatcher;
  private StrMatcher valueDelimiterMatcher;
  private StrLookup<?> variableResolver;
  
  public StrSubstitutor()
  {
    this((StrLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public <V> StrSubstitutor(Map<String, V> paramMap)
  {
    this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2)
  {
    this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
  }
  
  public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar)
  {
    this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
  }
  
  public <V> StrSubstitutor(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar, String paramString3)
  {
    this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar, paramString3);
  }
  
  public StrSubstitutor(StrLookup<?> paramStrLookup)
  {
    this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public StrSubstitutor(StrLookup<?> paramStrLookup, String paramString1, String paramString2, char paramChar)
  {
    setVariableResolver(paramStrLookup);
    setVariablePrefix(paramString1);
    setVariableSuffix(paramString2);
    setEscapeChar(paramChar);
    setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
  }
  
  public StrSubstitutor(StrLookup<?> paramStrLookup, String paramString1, String paramString2, char paramChar, String paramString3)
  {
    setVariableResolver(paramStrLookup);
    setVariablePrefix(paramString1);
    setVariableSuffix(paramString2);
    setEscapeChar(paramChar);
    setValueDelimiter(paramString3);
  }
  
  public StrSubstitutor(StrLookup<?> paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar)
  {
    this(paramStrLookup, paramStrMatcher1, paramStrMatcher2, paramChar, DEFAULT_VALUE_DELIMITER);
  }
  
  public StrSubstitutor(StrLookup<?> paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar, StrMatcher paramStrMatcher3)
  {
    setVariableResolver(paramStrLookup);
    setVariablePrefixMatcher(paramStrMatcher1);
    setVariableSuffixMatcher(paramStrMatcher2);
    setEscapeChar(paramChar);
    setValueDelimiterMatcher(paramStrMatcher3);
  }
  
  private void checkCyclicSubstitution(String paramString, List<String> paramList)
  {
    if (!paramList.contains(paramString)) {
      return;
    }
    paramString = new StrBuilder(256);
    paramString.append("Infinite loop in property interpolation of ");
    paramString.append((String)paramList.remove(0));
    paramString.append(": ");
    paramString.appendWithSeparators(paramList, "->");
    throw new IllegalStateException(paramString.toString());
  }
  
  public static <V> String replace(Object paramObject, Map<String, V> paramMap)
  {
    return new StrSubstitutor(paramMap).replace(paramObject);
  }
  
  public static <V> String replace(Object paramObject, Map<String, V> paramMap, String paramString1, String paramString2)
  {
    return new StrSubstitutor(paramMap, paramString1, paramString2).replace(paramObject);
  }
  
  public static String replace(Object paramObject, Properties paramProperties)
  {
    if (paramProperties == null) {
      return paramObject.toString();
    }
    HashMap localHashMap = new HashMap();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localHashMap.put(str, paramProperties.getProperty(str));
    }
    return replace(paramObject, localHashMap);
  }
  
  public static String replaceSystemProperties(Object paramObject)
  {
    return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(paramObject);
  }
  
  private int substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2, List<String> paramList)
  {
    StrMatcher localStrMatcher1 = getVariablePrefixMatcher();
    StrMatcher localStrMatcher2 = getVariableSuffixMatcher();
    int i7 = getEscapeChar();
    StrMatcher localStrMatcher3 = getValueDelimiterMatcher();
    boolean bool = isEnableSubstitutionInVariables();
    int i6;
    int i1;
    int m;
    Object localObject1;
    int k;
    int n;
    Object localObject2;
    label62:
    int i8;
    int i;
    int i5;
    int i3;
    int i2;
    if (paramList == null)
    {
      i6 = 1;
      i1 = 0;
      m = 0;
      localObject1 = paramStrBuilder.buffer;
      k = paramInt1 + paramInt2;
      n = paramInt1;
      localObject2 = paramList;
      if (n >= k) {
        break label705;
      }
      i8 = localStrMatcher1.isMatch((char[])localObject1, n, paramInt1, k);
      if (i8 != 0) {
        break label147;
      }
      i = n + 1;
      i5 = i1;
      i3 = m;
      paramList = (List<String>)localObject1;
      i2 = k;
    }
    for (Object localObject3 = localObject2;; localObject3 = localObject2)
    {
      localObject2 = localObject3;
      k = i2;
      localObject1 = paramList;
      m = i3;
      i1 = i5;
      n = i;
      break label62;
      i6 = 0;
      break;
      label147:
      if ((n <= paramInt1) || (localObject1[(n - 1)] != i7)) {
        break label206;
      }
      paramStrBuilder.deleteCharAt(n - 1);
      paramList = paramStrBuilder.buffer;
      i3 = m - 1;
      i5 = 1;
      i2 = k - 1;
      i = n;
    }
    label206:
    int j = n + i8;
    int i4 = 0;
    for (;;)
    {
      label216:
      localObject3 = localObject2;
      i = j;
      i2 = k;
      paramList = (List<String>)localObject1;
      i3 = m;
      i5 = i1;
      if (j >= k) {
        break;
      }
      if (bool)
      {
        i = localStrMatcher1.isMatch((char[])localObject1, j, paramInt1, k);
        if (i != 0)
        {
          i4 += 1;
          j += i;
          continue;
        }
      }
      i = localStrMatcher2.isMatch((char[])localObject1, j, paramInt1, k);
      if (i != 0) {
        break label315;
      }
      j += 1;
    }
    label315:
    Object localObject4;
    if (i4 == 0)
    {
      localObject3 = new String((char[])localObject1, n + i8, j - n - i8);
      paramList = (List<String>)localObject3;
      if (bool)
      {
        paramList = new StrBuilder((String)localObject3);
        substitute(paramList, 0, paramList.length());
        paramList = paramList.toString();
      }
      j += i;
      if (localStrMatcher3 == null) {
        break label722;
      }
      localObject3 = paramList.toCharArray();
      i = 0;
      label406:
      if (i >= localObject3.length) {
        break label722;
      }
      if ((!bool) && (localStrMatcher1.isMatch((char[])localObject3, i, i, localObject3.length) != 0))
      {
        localObject3 = null;
        localObject4 = paramList;
        paramList = (List<String>)localObject3;
        label447:
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(new String((char[])localObject1, paramInt1, paramInt2));
        }
        checkCyclicSubstitution((String)localObject4, (List)localObject3);
        ((List)localObject3).add(localObject4);
        localObject2 = resolveVariable((String)localObject4, paramStrBuilder, n, j);
        if (localObject2 != null) {
          break label736;
        }
        localObject2 = paramList;
      }
    }
    label705:
    label722:
    label736:
    for (;;)
    {
      i = j;
      i2 = k;
      paramList = (List<String>)localObject1;
      i3 = m;
      if (localObject2 != null)
      {
        i = ((String)localObject2).length();
        paramStrBuilder.replace(n, j, (String)localObject2);
        i1 = 1;
        n = i + substitute(paramStrBuilder, n, i, (List)localObject3) - (j - n);
        i = j + n;
        i2 = k + n;
        i3 = m + n;
        paramList = paramStrBuilder.buffer;
      }
      ((List)localObject3).remove(((List)localObject3).size() - 1);
      i5 = i1;
      break;
      i2 = localStrMatcher3.isMatch((char[])localObject3, i);
      if (i2 != 0)
      {
        localObject4 = paramList.substring(0, i);
        paramList = paramList.substring(i + i2);
        break label447;
      }
      i += 1;
      break label406;
      i4 -= 1;
      j += i;
      break label216;
      if (i6 != 0)
      {
        if (i1 != 0) {
          return 1;
        }
        return 0;
      }
      return m;
      localObject3 = null;
      localObject4 = paramList;
      paramList = (List<String>)localObject3;
      break label447;
    }
  }
  
  public char getEscapeChar()
  {
    return this.escapeChar;
  }
  
  public StrMatcher getValueDelimiterMatcher()
  {
    return this.valueDelimiterMatcher;
  }
  
  public StrMatcher getVariablePrefixMatcher()
  {
    return this.prefixMatcher;
  }
  
  public StrLookup<?> getVariableResolver()
  {
    return this.variableResolver;
  }
  
  public StrMatcher getVariableSuffixMatcher()
  {
    return this.suffixMatcher;
  }
  
  public boolean isEnableSubstitutionInVariables()
  {
    return this.enableSubstitutionInVariables;
  }
  
  public String replace(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return replace(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public String replace(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      return null;
    }
    paramCharSequence = new StrBuilder(paramInt2).append(paramCharSequence, paramInt1, paramInt2);
    substitute(paramCharSequence, 0, paramInt2);
    return paramCharSequence.toString();
  }
  
  public String replace(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = new StrBuilder().append(paramObject);
    substitute(paramObject, 0, paramObject.length());
    return paramObject.toString();
  }
  
  public String replace(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    StrBuilder localStrBuilder;
    do
    {
      return str;
      localStrBuilder = new StrBuilder(paramString);
      str = paramString;
    } while (!substitute(localStrBuilder, 0, paramString.length()));
    return localStrBuilder.toString();
  }
  
  public String replace(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramInt2).append(paramString, paramInt1, paramInt2);
    if (!substitute(localStrBuilder, 0, paramInt2)) {
      return paramString.substring(paramInt1, paramInt1 + paramInt2);
    }
    return localStrBuilder.toString();
  }
  
  public String replace(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return null;
    }
    paramStringBuffer = new StrBuilder(paramStringBuffer.length()).append(paramStringBuffer);
    substitute(paramStringBuffer, 0, paramStringBuffer.length());
    return paramStringBuffer.toString();
  }
  
  public String replace(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null) {
      return null;
    }
    paramStringBuffer = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
    substitute(paramStringBuffer, 0, paramInt2);
    return paramStringBuffer.toString();
  }
  
  public String replace(StrBuilder paramStrBuilder)
  {
    if (paramStrBuilder == null) {
      return null;
    }
    paramStrBuilder = new StrBuilder(paramStrBuilder.length()).append(paramStrBuilder);
    substitute(paramStrBuilder, 0, paramStrBuilder.length());
    return paramStrBuilder.toString();
  }
  
  public String replace(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    if (paramStrBuilder == null) {
      return null;
    }
    paramStrBuilder = new StrBuilder(paramInt2).append(paramStrBuilder, paramInt1, paramInt2);
    substitute(paramStrBuilder, 0, paramInt2);
    return paramStrBuilder.toString();
  }
  
  public String replace(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramArrayOfChar.length).append(paramArrayOfChar);
    substitute(localStrBuilder, 0, paramArrayOfChar.length);
    return localStrBuilder.toString();
  }
  
  public String replace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    paramArrayOfChar = new StrBuilder(paramInt2).append(paramArrayOfChar, paramInt1, paramInt2);
    substitute(paramArrayOfChar, 0, paramInt2);
    return paramArrayOfChar.toString();
  }
  
  public boolean replaceIn(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return false;
    }
    return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
  }
  
  public boolean replaceIn(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null) {}
    StrBuilder localStrBuilder;
    do
    {
      return false;
      localStrBuilder = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
    } while (!substitute(localStrBuilder, 0, paramInt2));
    paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, localStrBuilder.toString());
    return true;
  }
  
  public boolean replaceIn(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return false;
    }
    return replaceIn(paramStringBuilder, 0, paramStringBuilder.length());
  }
  
  public boolean replaceIn(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramStringBuilder == null) {}
    StrBuilder localStrBuilder;
    do
    {
      return false;
      localStrBuilder = new StrBuilder(paramInt2).append(paramStringBuilder, paramInt1, paramInt2);
    } while (!substitute(localStrBuilder, 0, paramInt2));
    paramStringBuilder.replace(paramInt1, paramInt1 + paramInt2, localStrBuilder.toString());
    return true;
  }
  
  public boolean replaceIn(StrBuilder paramStrBuilder)
  {
    if (paramStrBuilder == null) {
      return false;
    }
    return substitute(paramStrBuilder, 0, paramStrBuilder.length());
  }
  
  public boolean replaceIn(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    if (paramStrBuilder == null) {
      return false;
    }
    return substitute(paramStrBuilder, paramInt1, paramInt2);
  }
  
  protected String resolveVariable(String paramString, StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    paramStrBuilder = getVariableResolver();
    if (paramStrBuilder == null) {
      return null;
    }
    return paramStrBuilder.lookup(paramString);
  }
  
  public void setEnableSubstitutionInVariables(boolean paramBoolean)
  {
    this.enableSubstitutionInVariables = paramBoolean;
  }
  
  public void setEscapeChar(char paramChar)
  {
    this.escapeChar = paramChar;
  }
  
  public StrSubstitutor setValueDelimiter(char paramChar)
  {
    return setValueDelimiterMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrSubstitutor setValueDelimiter(String paramString)
  {
    if (StringUtils.isEmpty(paramString))
    {
      setValueDelimiterMatcher(null);
      return this;
    }
    return setValueDelimiterMatcher(StrMatcher.stringMatcher(paramString));
  }
  
  public StrSubstitutor setValueDelimiterMatcher(StrMatcher paramStrMatcher)
  {
    this.valueDelimiterMatcher = paramStrMatcher;
    return this;
  }
  
  public StrSubstitutor setVariablePrefix(char paramChar)
  {
    return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrSubstitutor setVariablePrefix(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Variable prefix must not be null!");
    }
    return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
  }
  
  public StrSubstitutor setVariablePrefixMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher == null) {
      throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }
    this.prefixMatcher = paramStrMatcher;
    return this;
  }
  
  public void setVariableResolver(StrLookup<?> paramStrLookup)
  {
    this.variableResolver = paramStrLookup;
  }
  
  public StrSubstitutor setVariableSuffix(char paramChar)
  {
    return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrSubstitutor setVariableSuffix(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Variable suffix must not be null!");
    }
    return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
  }
  
  public StrSubstitutor setVariableSuffixMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher == null) {
      throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }
    this.suffixMatcher = paramStrMatcher;
    return this;
  }
  
  protected boolean substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    return substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.StrSubstitutor
 * JD-Core Version:    0.7.0.1
 */