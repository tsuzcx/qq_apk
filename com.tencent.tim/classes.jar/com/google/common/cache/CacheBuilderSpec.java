package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtIncompatible
public final class CacheBuilderSpec
{
  private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
  private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
  private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
  @VisibleForTesting
  long accessExpirationDuration;
  @VisibleForTesting
  TimeUnit accessExpirationTimeUnit;
  @VisibleForTesting
  Integer concurrencyLevel;
  @VisibleForTesting
  Integer initialCapacity;
  @VisibleForTesting
  LocalCache.Strength keyStrength;
  @VisibleForTesting
  Long maximumSize;
  @VisibleForTesting
  Long maximumWeight;
  @VisibleForTesting
  Boolean recordStats;
  @VisibleForTesting
  long refreshDuration;
  @VisibleForTesting
  TimeUnit refreshTimeUnit;
  private final String specification;
  @VisibleForTesting
  LocalCache.Strength valueStrength;
  @VisibleForTesting
  long writeExpirationDuration;
  @VisibleForTesting
  TimeUnit writeExpirationTimeUnit;
  
  private CacheBuilderSpec(String paramString)
  {
    this.specification = paramString;
  }
  
  public static CacheBuilderSpec disableCaching()
  {
    return parse("maximumSize=0");
  }
  
  @Nullable
  private static Long durationInNanos(long paramLong, @Nullable TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      return null;
    }
    return Long.valueOf(paramTimeUnit.toNanos(paramLong));
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static CacheBuilderSpec parse(String paramString)
  {
    CacheBuilderSpec localCacheBuilderSpec = new CacheBuilderSpec(paramString);
    if (!paramString.isEmpty())
    {
      Iterator localIterator = KEYS_SPLITTER.split(paramString).iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str));
        boolean bool;
        label72:
        label90:
        ValueParser localValueParser;
        if (!paramString.isEmpty())
        {
          bool = true;
          Preconditions.checkArgument(bool, "blank key-value pair");
          if (paramString.size() > 2) {
            break label170;
          }
          bool = true;
          Preconditions.checkArgument(bool, "key-value pair %s with more than one equals sign", str);
          str = (String)paramString.get(0);
          localValueParser = (ValueParser)VALUE_PARSERS.get(str);
          if (localValueParser == null) {
            break label175;
          }
          bool = true;
          label130:
          Preconditions.checkArgument(bool, "unknown key %s", str);
          if (paramString.size() != 1) {
            break label180;
          }
        }
        label170:
        label175:
        label180:
        for (paramString = null;; paramString = (String)paramString.get(1))
        {
          localValueParser.parse(localCacheBuilderSpec, str, paramString);
          break;
          bool = false;
          break label72;
          bool = false;
          break label90;
          bool = false;
          break label130;
        }
      }
    }
    return localCacheBuilderSpec;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CacheBuilderSpec)) {
        return false;
      }
      paramObject = (CacheBuilderSpec)paramObject;
    } while ((Objects.equal(this.initialCapacity, paramObject.initialCapacity)) && (Objects.equal(this.maximumSize, paramObject.maximumSize)) && (Objects.equal(this.maximumWeight, paramObject.maximumWeight)) && (Objects.equal(this.concurrencyLevel, paramObject.concurrencyLevel)) && (Objects.equal(this.keyStrength, paramObject.keyStrength)) && (Objects.equal(this.valueStrength, paramObject.valueStrength)) && (Objects.equal(this.recordStats, paramObject.recordStats)) && (Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(paramObject.writeExpirationDuration, paramObject.writeExpirationTimeUnit))) && (Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(paramObject.accessExpirationDuration, paramObject.accessExpirationTimeUnit))) && (Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(paramObject.refreshDuration, paramObject.refreshTimeUnit))));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit) });
  }
  
  CacheBuilder<Object, Object> toCacheBuilder()
  {
    CacheBuilder localCacheBuilder = CacheBuilder.newBuilder();
    if (this.initialCapacity != null) {
      localCacheBuilder.initialCapacity(this.initialCapacity.intValue());
    }
    if (this.maximumSize != null) {
      localCacheBuilder.maximumSize(this.maximumSize.longValue());
    }
    if (this.maximumWeight != null) {
      localCacheBuilder.maximumWeight(this.maximumWeight.longValue());
    }
    if (this.concurrencyLevel != null) {
      localCacheBuilder.concurrencyLevel(this.concurrencyLevel.intValue());
    }
    if (this.keyStrength != null)
    {
      switch (1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()])
      {
      default: 
        throw new AssertionError();
      }
      localCacheBuilder.weakKeys();
    }
    if (this.valueStrength != null) {
      switch (1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.valueStrength.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 2: 
        localCacheBuilder.softValues();
      }
    }
    for (;;)
    {
      if ((this.recordStats != null) && (this.recordStats.booleanValue())) {
        localCacheBuilder.recordStats();
      }
      if (this.writeExpirationTimeUnit != null) {
        localCacheBuilder.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
      }
      if (this.accessExpirationTimeUnit != null) {
        localCacheBuilder.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
      }
      if (this.refreshTimeUnit != null) {
        localCacheBuilder.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
      }
      return localCacheBuilder;
      localCacheBuilder.weakValues();
    }
  }
  
  public String toParsableString()
  {
    return this.specification;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
  }
  
  static class AccessDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.accessExpirationTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "expireAfterAccess already set");
        paramCacheBuilderSpec.accessExpirationDuration = paramLong;
        paramCacheBuilderSpec.accessExpirationTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
  
  static class ConcurrencyLevelParser
    extends CacheBuilderSpec.IntegerParser
  {
    protected void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      if (paramCacheBuilderSpec.concurrencyLevel == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "concurrency level was already set to ", paramCacheBuilderSpec.concurrencyLevel);
        paramCacheBuilderSpec.concurrencyLevel = Integer.valueOf(paramInt);
        return;
      }
    }
  }
  
  static abstract class DurationParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        bool = true;
        Preconditions.checkArgument(bool, "value of key %s omitted", paramString1);
      }
      for (;;)
      {
        try
        {
          switch (paramString2.charAt(paramString2.length() - 1))
          {
          case 'd': 
            throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { paramString1, paramString2 }));
          }
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }));
        }
        bool = false;
        break;
        TimeUnit localTimeUnit = TimeUnit.DAYS;
        for (;;)
        {
          parseDuration(paramCacheBuilderSpec, Long.parseLong(paramString2.substring(0, paramString2.length() - 1)), localTimeUnit);
          return;
          localTimeUnit = TimeUnit.HOURS;
          continue;
          localTimeUnit = TimeUnit.MINUTES;
          continue;
          localTimeUnit = TimeUnit.SECONDS;
        }
      }
    }
    
    protected abstract void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit);
  }
  
  static class InitialCapacityParser
    extends CacheBuilderSpec.IntegerParser
  {
    protected void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      if (paramCacheBuilderSpec.initialCapacity == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "initial capacity was already set to ", paramCacheBuilderSpec.initialCapacity);
        paramCacheBuilderSpec.initialCapacity = Integer.valueOf(paramInt);
        return;
      }
    }
  }
  
  static abstract class IntegerParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value of key %s omitted", paramString1);
        try
        {
          parseInteger(paramCacheBuilderSpec, Integer.parseInt(paramString2));
          return;
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
        }
      }
    }
    
    protected abstract void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt);
  }
  
  static class KeyStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    private final LocalCache.Strength strength;
    
    public KeyStrengthParser(LocalCache.Strength paramStrength)
    {
      this.strength = paramStrength;
    }
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      boolean bool2 = true;
      if (paramString2 == null)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "key %s does not take values", paramString1);
        if (paramCacheBuilderSpec.keyStrength != null) {
          break label56;
        }
      }
      label56:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "%s was already set to %s", paramString1, paramCacheBuilderSpec.keyStrength);
        paramCacheBuilderSpec.keyStrength = this.strength;
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  static abstract class LongParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value of key %s omitted", paramString1);
        try
        {
          parseLong(paramCacheBuilderSpec, Long.parseLong(paramString2));
          return;
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
        }
      }
    }
    
    protected abstract void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong);
  }
  
  static class MaximumSizeParser
    extends CacheBuilderSpec.LongParser
  {
    protected void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      boolean bool2 = true;
      if (paramCacheBuilderSpec.maximumSize == null)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "maximum size was already set to ", paramCacheBuilderSpec.maximumSize);
        if (paramCacheBuilderSpec.maximumWeight != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "maximum weight was already set to ", paramCacheBuilderSpec.maximumWeight);
        paramCacheBuilderSpec.maximumSize = Long.valueOf(paramLong);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  static class MaximumWeightParser
    extends CacheBuilderSpec.LongParser
  {
    protected void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      boolean bool2 = true;
      if (paramCacheBuilderSpec.maximumWeight == null)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "maximum weight was already set to ", paramCacheBuilderSpec.maximumWeight);
        if (paramCacheBuilderSpec.maximumSize != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "maximum size was already set to ", paramCacheBuilderSpec.maximumSize);
        paramCacheBuilderSpec.maximumWeight = Long.valueOf(paramLong);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  static class RecordStatsParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      boolean bool2 = false;
      if (paramString2 == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "recordStats does not take values");
        bool1 = bool2;
        if (paramCacheBuilderSpec.recordStats == null) {
          bool1 = true;
        }
        Preconditions.checkArgument(bool1, "recordStats already set");
        paramCacheBuilderSpec.recordStats = Boolean.valueOf(true);
        return;
      }
    }
  }
  
  static class RefreshDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.refreshTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "refreshAfterWrite already set");
        paramCacheBuilderSpec.refreshDuration = paramLong;
        paramCacheBuilderSpec.refreshTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
  
  static abstract interface ValueParser
  {
    public abstract void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2);
  }
  
  static class ValueStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    private final LocalCache.Strength strength;
    
    public ValueStrengthParser(LocalCache.Strength paramStrength)
    {
      this.strength = paramStrength;
    }
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      boolean bool2 = true;
      if (paramString2 == null)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "key %s does not take values", paramString1);
        if (paramCacheBuilderSpec.valueStrength != null) {
          break label56;
        }
      }
      label56:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "%s was already set to %s", paramString1, paramCacheBuilderSpec.valueStrength);
        paramCacheBuilderSpec.valueStrength = this.strength;
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  static class WriteDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.writeExpirationTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "expireAfterWrite already set");
        paramCacheBuilderSpec.writeExpirationDuration = paramLong;
        paramCacheBuilderSpec.writeExpirationTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheBuilderSpec
 * JD-Core Version:    0.7.0.1
 */