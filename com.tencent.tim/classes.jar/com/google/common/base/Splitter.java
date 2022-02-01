package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated=true)
public final class Splitter
{
  private final int limit;
  private final boolean omitEmptyStrings;
  private final Strategy strategy;
  private final CharMatcher trimmer;
  
  private Splitter(Strategy paramStrategy)
  {
    this(paramStrategy, false, CharMatcher.none(), 2147483647);
  }
  
  private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher, int paramInt)
  {
    this.strategy = paramStrategy;
    this.omitEmptyStrings = paramBoolean;
    this.trimmer = paramCharMatcher;
    this.limit = paramInt;
  }
  
  public static Splitter fixedLength(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The length may not be less than 1");
      return new Splitter(new Splitter.4(paramInt));
    }
  }
  
  public static Splitter on(char paramChar)
  {
    return on(CharMatcher.is(paramChar));
  }
  
  public static Splitter on(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    return new Splitter(new Splitter.1(paramCharMatcher));
  }
  
  private static Splitter on(CommonPattern paramCommonPattern)
  {
    if (!paramCommonPattern.matcher("").matches()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The pattern may not match the empty string: %s", paramCommonPattern);
      return new Splitter(new Splitter.3(paramCommonPattern));
    }
  }
  
  public static Splitter on(String paramString)
  {
    if (paramString.length() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The separator may not be the empty string.");
      if (paramString.length() != 1) {
        break;
      }
      return on(paramString.charAt(0));
    }
    return new Splitter(new Splitter.2(paramString));
  }
  
  @GwtIncompatible
  public static Splitter on(Pattern paramPattern)
  {
    return on(new JdkPattern(paramPattern));
  }
  
  @GwtIncompatible
  public static Splitter onPattern(String paramString)
  {
    return on(Platform.compilePattern(paramString));
  }
  
  private Iterator<String> splittingIterator(CharSequence paramCharSequence)
  {
    return this.strategy.iterator(this, paramCharSequence);
  }
  
  public Splitter limit(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "must be greater than zero: %s", paramInt);
      return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, paramInt);
    }
  }
  
  public Splitter omitEmptyStrings()
  {
    return new Splitter(this.strategy, true, this.trimmer, this.limit);
  }
  
  public Iterable<String> split(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return new Splitter.5(this, paramCharSequence);
  }
  
  @Beta
  public List<String> splitToList(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    paramCharSequence = splittingIterator(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    while (paramCharSequence.hasNext()) {
      localArrayList.add(paramCharSequence.next());
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Splitter trimResults()
  {
    return trimResults(CharMatcher.whitespace());
  }
  
  public Splitter trimResults(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    return new Splitter(this.strategy, this.omitEmptyStrings, paramCharMatcher, this.limit);
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(char paramChar)
  {
    return withKeyValueSeparator(on(paramChar));
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(Splitter paramSplitter)
  {
    return new MapSplitter(this, paramSplitter, null);
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(String paramString)
  {
    return withKeyValueSeparator(on(paramString));
  }
  
  @Beta
  public static final class MapSplitter
  {
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    private final Splitter entrySplitter;
    private final Splitter outerSplitter;
    
    private MapSplitter(Splitter paramSplitter1, Splitter paramSplitter2)
    {
      this.outerSplitter = paramSplitter1;
      this.entrySplitter = ((Splitter)Preconditions.checkNotNull(paramSplitter2));
    }
    
    public Map<String, String> split(CharSequence paramCharSequence)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      paramCharSequence = this.outerSplitter.split(paramCharSequence).iterator();
      if (paramCharSequence.hasNext())
      {
        String str1 = (String)paramCharSequence.next();
        Iterator localIterator = this.entrySplitter.splittingIterator(str1);
        Preconditions.checkArgument(localIterator.hasNext(), "Chunk [%s] is not a valid entry", str1);
        String str2 = (String)localIterator.next();
        if (!localLinkedHashMap.containsKey(str2))
        {
          bool = true;
          label92:
          Preconditions.checkArgument(bool, "Duplicate key [%s] found.", str2);
          Preconditions.checkArgument(localIterator.hasNext(), "Chunk [%s] is not a valid entry", str1);
          localLinkedHashMap.put(str2, (String)localIterator.next());
          if (localIterator.hasNext()) {
            break label161;
          }
        }
        label161:
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "Chunk [%s] is not a valid entry", str1);
          break;
          bool = false;
          break label92;
        }
      }
      return Collections.unmodifiableMap(localLinkedHashMap);
    }
  }
  
  static abstract class SplittingIterator
    extends AbstractIterator<String>
  {
    int limit;
    int offset = 0;
    final boolean omitEmptyStrings;
    final CharSequence toSplit;
    final CharMatcher trimmer;
    
    protected SplittingIterator(Splitter paramSplitter, CharSequence paramCharSequence)
    {
      this.trimmer = paramSplitter.trimmer;
      this.omitEmptyStrings = paramSplitter.omitEmptyStrings;
      this.limit = paramSplitter.limit;
      this.toSplit = paramCharSequence;
    }
    
    protected String computeNext()
    {
      int j = this.offset;
      int i;
      if (this.offset != -1)
      {
        i = separatorStart(this.offset);
        if (i == -1) {
          i = this.toSplit.length();
        }
        for (this.offset = -1;; this.offset = separatorEnd(i))
        {
          if (this.offset != j) {
            break label283;
          }
          this.offset += 1;
          if (this.offset < this.toSplit.length()) {
            break;
          }
          this.offset = -1;
          break;
        }
      }
      label283:
      for (;;)
      {
        if ((j < i) && (this.trimmer.matches(this.toSplit.charAt(j)))) {
          j += 1;
        } else {
          for (;;)
          {
            if ((i > j) && (this.trimmer.matches(this.toSplit.charAt(i - 1))))
            {
              i -= 1;
            }
            else
            {
              if ((this.omitEmptyStrings) && (j == i))
              {
                j = this.offset;
                break;
              }
              if (this.limit == 1)
              {
                i = this.toSplit.length();
                this.offset = -1;
                for (;;)
                {
                  k = i;
                  if (i <= j) {
                    break;
                  }
                  k = i;
                  if (!this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                    break;
                  }
                  i -= 1;
                }
              }
              this.limit -= 1;
              int k = i;
              return this.toSplit.subSequence(j, k).toString();
              return (String)endOfData();
            }
          }
        }
      }
    }
    
    abstract int separatorEnd(int paramInt);
    
    abstract int separatorStart(int paramInt);
  }
  
  static abstract interface Strategy
  {
    public abstract Iterator<String> iterator(Splitter paramSplitter, CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter
 * JD-Core Version:    0.7.0.1
 */