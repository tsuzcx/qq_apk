package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StrTokenizer
  implements Cloneable, ListIterator<String>
{
  private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer();
  private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
  private char[] chars;
  private StrMatcher delimMatcher = StrMatcher.splitMatcher();
  private boolean emptyAsNull = false;
  private boolean ignoreEmptyTokens = true;
  private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
  private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
  private int tokenPos;
  private String[] tokens;
  private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
  
  static
  {
    CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
    CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
    CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
    CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
    CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
    CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
    TSV_TOKENIZER_PROTOTYPE = new StrTokenizer();
    TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
    TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
    TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
    TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
    TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
    TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
  }
  
  public StrTokenizer()
  {
    this.chars = null;
  }
  
  public StrTokenizer(String paramString)
  {
    if (paramString != null)
    {
      this.chars = paramString.toCharArray();
      return;
    }
    this.chars = null;
  }
  
  public StrTokenizer(String paramString, char paramChar)
  {
    this(paramString);
    setDelimiterChar(paramChar);
  }
  
  public StrTokenizer(String paramString, char paramChar1, char paramChar2)
  {
    this(paramString, paramChar1);
    setQuoteChar(paramChar2);
  }
  
  public StrTokenizer(String paramString1, String paramString2)
  {
    this(paramString1);
    setDelimiterString(paramString2);
  }
  
  public StrTokenizer(String paramString, StrMatcher paramStrMatcher)
  {
    this(paramString);
    setDelimiterMatcher(paramStrMatcher);
  }
  
  public StrTokenizer(String paramString, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2)
  {
    this(paramString, paramStrMatcher1);
    setQuoteMatcher(paramStrMatcher2);
  }
  
  public StrTokenizer(char[] paramArrayOfChar)
  {
    this.chars = ArrayUtils.clone(paramArrayOfChar);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, char paramChar)
  {
    this(paramArrayOfChar);
    setDelimiterChar(paramChar);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, char paramChar1, char paramChar2)
  {
    this(paramArrayOfChar, paramChar1);
    setQuoteChar(paramChar2);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, String paramString)
  {
    this(paramArrayOfChar);
    setDelimiterString(paramString);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, StrMatcher paramStrMatcher)
  {
    this(paramArrayOfChar);
    setDelimiterMatcher(paramStrMatcher);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2)
  {
    this(paramArrayOfChar, paramStrMatcher1);
    setQuoteMatcher(paramStrMatcher2);
  }
  
  private void addToken(List<String> paramList, String paramString)
  {
    String str = paramString;
    if (StringUtils.isEmpty(paramString))
    {
      if (isIgnoreEmptyTokens()) {
        return;
      }
      str = paramString;
      if (isEmptyTokenAsNull()) {
        str = null;
      }
    }
    paramList.add(str);
  }
  
  private void checkTokenized()
  {
    if (this.tokens == null)
    {
      if (this.chars == null)
      {
        localList = tokenize(null, 0, 0);
        this.tokens = ((String[])localList.toArray(new String[localList.size()]));
      }
    }
    else {
      return;
    }
    List localList = tokenize(this.chars, 0, this.chars.length);
    this.tokens = ((String[])localList.toArray(new String[localList.size()]));
  }
  
  private static StrTokenizer getCSVClone()
  {
    return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
  }
  
  public static StrTokenizer getCSVInstance()
  {
    return getCSVClone();
  }
  
  public static StrTokenizer getCSVInstance(String paramString)
  {
    StrTokenizer localStrTokenizer = getCSVClone();
    localStrTokenizer.reset(paramString);
    return localStrTokenizer;
  }
  
  public static StrTokenizer getCSVInstance(char[] paramArrayOfChar)
  {
    StrTokenizer localStrTokenizer = getCSVClone();
    localStrTokenizer.reset(paramArrayOfChar);
    return localStrTokenizer;
  }
  
  private static StrTokenizer getTSVClone()
  {
    return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
  }
  
  public static StrTokenizer getTSVInstance()
  {
    return getTSVClone();
  }
  
  public static StrTokenizer getTSVInstance(String paramString)
  {
    StrTokenizer localStrTokenizer = getTSVClone();
    localStrTokenizer.reset(paramString);
    return localStrTokenizer;
  }
  
  public static StrTokenizer getTSVInstance(char[] paramArrayOfChar)
  {
    StrTokenizer localStrTokenizer = getTSVClone();
    localStrTokenizer.reset(paramArrayOfChar);
    return localStrTokenizer;
  }
  
  private boolean isQuote(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt4)
    {
      if ((paramInt1 + i >= paramInt2) || (paramArrayOfChar[(paramInt1 + i)] != paramArrayOfChar[(paramInt3 + i)])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int readNextToken(char[] paramArrayOfChar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List<String> paramList)
  {
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        i = Math.max(getIgnoredMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2), getTrimmerMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2));
        if ((i != 0) && (getDelimiterMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2) <= 0) && (getQuoteMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2) <= 0)) {}
      }
      else
      {
        if (paramInt1 < paramInt2) {
          break;
        }
        addToken(paramList, "");
        return -1;
      }
      paramInt1 += i;
    }
    int i = getDelimiterMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2);
    if (i > 0)
    {
      addToken(paramList, "");
      return i + paramInt1;
    }
    i = getQuoteMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2);
    if (i > 0) {
      return readWithQuotes(paramArrayOfChar, paramInt1 + i, paramInt2, paramStrBuilder, paramList, paramInt1, i);
    }
    return readWithQuotes(paramArrayOfChar, paramInt1, paramInt2, paramStrBuilder, paramList, 0, 0);
  }
  
  private int readWithQuotes(char[] paramArrayOfChar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List<String> paramList, int paramInt3, int paramInt4)
  {
    paramStrBuilder.clear();
    int i;
    int j;
    int k;
    if (paramInt4 > 0)
    {
      i = 1;
      j = 0;
      k = i;
      i = paramInt1;
    }
    for (;;)
    {
      if (i >= paramInt2) {
        break label310;
      }
      if (k != 0)
      {
        if (isQuote(paramArrayOfChar, i, paramInt2, paramInt3, paramInt4))
        {
          if (isQuote(paramArrayOfChar, i + paramInt4, paramInt2, paramInt3, paramInt4))
          {
            paramStrBuilder.append(paramArrayOfChar, i, paramInt4);
            i += paramInt4 * 2;
            j = paramStrBuilder.size();
            continue;
            i = 0;
            break;
          }
          i += paramInt4;
          k = 0;
          continue;
        }
        paramStrBuilder.append(paramArrayOfChar[i]);
        j = paramStrBuilder.size();
        i += 1;
        continue;
      }
      int m = getDelimiterMatcher().isMatch(paramArrayOfChar, i, paramInt1, paramInt2);
      if (m > 0)
      {
        addToken(paramList, paramStrBuilder.substring(0, j));
        return m + i;
      }
      if ((paramInt4 > 0) && (isQuote(paramArrayOfChar, i, paramInt2, paramInt3, paramInt4)))
      {
        i += paramInt4;
        k = 1;
      }
      else
      {
        m = getIgnoredMatcher().isMatch(paramArrayOfChar, i, paramInt1, paramInt2);
        if (m > 0)
        {
          i += m;
        }
        else
        {
          m = getTrimmerMatcher().isMatch(paramArrayOfChar, i, paramInt1, paramInt2);
          if (m > 0)
          {
            paramStrBuilder.append(paramArrayOfChar, i, m);
            i += m;
          }
          else
          {
            paramStrBuilder.append(paramArrayOfChar[i]);
            j = paramStrBuilder.size();
            i += 1;
          }
        }
      }
    }
    label310:
    addToken(paramList, paramStrBuilder.substring(0, j));
    return -1;
  }
  
  public void add(String paramString)
  {
    throw new UnsupportedOperationException("add() is unsupported");
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = cloneReset();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  Object cloneReset()
    throws CloneNotSupportedException
  {
    StrTokenizer localStrTokenizer = (StrTokenizer)super.clone();
    if (localStrTokenizer.chars != null) {
      localStrTokenizer.chars = ((char[])localStrTokenizer.chars.clone());
    }
    localStrTokenizer.reset();
    return localStrTokenizer;
  }
  
  public String getContent()
  {
    if (this.chars == null) {
      return null;
    }
    return new String(this.chars);
  }
  
  public StrMatcher getDelimiterMatcher()
  {
    return this.delimMatcher;
  }
  
  public StrMatcher getIgnoredMatcher()
  {
    return this.ignoredMatcher;
  }
  
  public StrMatcher getQuoteMatcher()
  {
    return this.quoteMatcher;
  }
  
  public String[] getTokenArray()
  {
    checkTokenized();
    return (String[])this.tokens.clone();
  }
  
  public List<String> getTokenList()
  {
    checkTokenized();
    ArrayList localArrayList = new ArrayList(this.tokens.length);
    String[] arrayOfString = this.tokens;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public StrMatcher getTrimmerMatcher()
  {
    return this.trimmerMatcher;
  }
  
  public boolean hasNext()
  {
    checkTokenized();
    return this.tokenPos < this.tokens.length;
  }
  
  public boolean hasPrevious()
  {
    checkTokenized();
    return this.tokenPos > 0;
  }
  
  public boolean isEmptyTokenAsNull()
  {
    return this.emptyAsNull;
  }
  
  public boolean isIgnoreEmptyTokens()
  {
    return this.ignoreEmptyTokens;
  }
  
  public String next()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos;
      this.tokenPos = (i + 1);
      return arrayOfString[i];
    }
    throw new NoSuchElementException();
  }
  
  public int nextIndex()
  {
    return this.tokenPos;
  }
  
  public String nextToken()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos;
      this.tokenPos = (i + 1);
      return arrayOfString[i];
    }
    return null;
  }
  
  public String previous()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos - 1;
      this.tokenPos = i;
      return arrayOfString[i];
    }
    throw new NoSuchElementException();
  }
  
  public int previousIndex()
  {
    return this.tokenPos - 1;
  }
  
  public String previousToken()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos - 1;
      this.tokenPos = i;
      return arrayOfString[i];
    }
    return null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("remove() is unsupported");
  }
  
  public StrTokenizer reset()
  {
    this.tokenPos = 0;
    this.tokens = null;
    return this;
  }
  
  public StrTokenizer reset(String paramString)
  {
    reset();
    if (paramString != null)
    {
      this.chars = paramString.toCharArray();
      return this;
    }
    this.chars = null;
    return this;
  }
  
  public StrTokenizer reset(char[] paramArrayOfChar)
  {
    reset();
    this.chars = ArrayUtils.clone(paramArrayOfChar);
    return this;
  }
  
  public void set(String paramString)
  {
    throw new UnsupportedOperationException("set() is unsupported");
  }
  
  public StrTokenizer setDelimiterChar(char paramChar)
  {
    return setDelimiterMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setDelimiterMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher == null)
    {
      this.delimMatcher = StrMatcher.noneMatcher();
      return this;
    }
    this.delimMatcher = paramStrMatcher;
    return this;
  }
  
  public StrTokenizer setDelimiterString(String paramString)
  {
    return setDelimiterMatcher(StrMatcher.stringMatcher(paramString));
  }
  
  public StrTokenizer setEmptyTokenAsNull(boolean paramBoolean)
  {
    this.emptyAsNull = paramBoolean;
    return this;
  }
  
  public StrTokenizer setIgnoreEmptyTokens(boolean paramBoolean)
  {
    this.ignoreEmptyTokens = paramBoolean;
    return this;
  }
  
  public StrTokenizer setIgnoredChar(char paramChar)
  {
    return setIgnoredMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setIgnoredMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.ignoredMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public StrTokenizer setQuoteChar(char paramChar)
  {
    return setQuoteMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setQuoteMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.quoteMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public StrTokenizer setTrimmerMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.trimmerMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public int size()
  {
    checkTokenized();
    return this.tokens.length;
  }
  
  public String toString()
  {
    if (this.tokens == null) {
      return "StrTokenizer[not tokenized yet]";
    }
    return "StrTokenizer" + getTokenList();
  }
  
  protected List<String> tokenize(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramArrayOfChar == null) || (paramInt2 == 0))
    {
      localObject = Collections.emptyList();
      return localObject;
    }
    StrBuilder localStrBuilder = new StrBuilder();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt1 < 0) {
        break;
      }
      localObject = localArrayList;
      if (paramInt1 >= paramInt2) {
        break;
      }
      int i = readNextToken(paramArrayOfChar, paramInt1, paramInt2, localStrBuilder, localArrayList);
      paramInt1 = i;
      if (i >= paramInt2)
      {
        addToken(localArrayList, "");
        paramInt1 = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.StrTokenizer
 * JD-Core Version:    0.7.0.1
 */