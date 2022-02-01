package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=true)
public final class CacheBuilder<K, V>
{
  static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new CacheBuilder.2();
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  private static final int DEFAULT_EXPIRATION_NANOS = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final int DEFAULT_REFRESH_NANOS = 0;
  static final CacheStats EMPTY_STATS;
  static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new CacheBuilder.1());
  static final Ticker NULL_TICKER = new CacheBuilder.3();
  static final int UNSET_INT = -1;
  private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
  int concurrencyLevel = -1;
  long expireAfterAccessNanos = -1L;
  long expireAfterWriteNanos = -1L;
  int initialCapacity = -1;
  Equivalence<Object> keyEquivalence;
  LocalCache.Strength keyStrength;
  long maximumSize = -1L;
  long maximumWeight = -1L;
  long refreshNanos = -1L;
  RemovalListener<? super K, ? super V> removalListener;
  Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
  boolean strictParsing = true;
  Ticker ticker;
  Equivalence<Object> valueEquivalence;
  LocalCache.Strength valueStrength;
  Weigher<? super K, ? super V> weigher;
  
  static
  {
    EMPTY_STATS = new CacheStats(0L, 0L, 0L, 0L, 0L, 0L);
  }
  
  private void checkNonLoadingCache()
  {
    if (this.refreshNanos == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "refreshAfterWrite requires a LoadingCache");
      return;
    }
  }
  
  private void checkWeightWithWeigher()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.weigher == null) {
      if (this.maximumWeight == -1L) {
        Preconditions.checkState(bool1, "maximumWeight requires weigher");
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      if (this.strictParsing)
      {
        if (this.maximumWeight != -1L) {}
        for (bool1 = bool2;; bool1 = false)
        {
          Preconditions.checkState(bool1, "weigher requires maximumWeight");
          return;
        }
      }
    } while (this.maximumWeight != -1L);
    logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
  }
  
  @GwtIncompatible
  public static CacheBuilder<Object, Object> from(CacheBuilderSpec paramCacheBuilderSpec)
  {
    return paramCacheBuilderSpec.toCacheBuilder().lenientParsing();
  }
  
  @GwtIncompatible
  public static CacheBuilder<Object, Object> from(String paramString)
  {
    return from(CacheBuilderSpec.parse(paramString));
  }
  
  public static CacheBuilder<Object, Object> newBuilder()
  {
    return new CacheBuilder();
  }
  
  public <K1 extends K, V1 extends V> Cache<K1, V1> build()
  {
    checkWeightWithWeigher();
    checkNonLoadingCache();
    return new LocalCache.LocalManualCache(this);
  }
  
  public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> paramCacheLoader)
  {
    checkWeightWithWeigher();
    return new LocalCache.LocalLoadingCache(this, paramCacheLoader);
  }
  
  public CacheBuilder<K, V> concurrencyLevel(int paramInt)
  {
    boolean bool2 = true;
    if (this.concurrencyLevel == -1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "concurrency level was already set to %s", this.concurrencyLevel);
      if (paramInt <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.concurrencyLevel = paramInt;
      return this;
      bool1 = false;
      break;
    }
  }
  
  public CacheBuilder<K, V> expireAfterAccess(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    if (this.expireAfterAccessNanos == -1L)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
      if (paramLong < 0L) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
      this.expireAfterAccessNanos = paramTimeUnit.toNanos(paramLong);
      return this;
      bool1 = false;
      break;
    }
  }
  
  public CacheBuilder<K, V> expireAfterWrite(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    if (this.expireAfterWriteNanos == -1L)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
      if (paramLong < 0L) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
      this.expireAfterWriteNanos = paramTimeUnit.toNanos(paramLong);
      return this;
      bool1 = false;
      break;
    }
  }
  
  int getConcurrencyLevel()
  {
    if (this.concurrencyLevel == -1) {
      return 4;
    }
    return this.concurrencyLevel;
  }
  
  long getExpireAfterAccessNanos()
  {
    if (this.expireAfterAccessNanos == -1L) {
      return 0L;
    }
    return this.expireAfterAccessNanos;
  }
  
  long getExpireAfterWriteNanos()
  {
    if (this.expireAfterWriteNanos == -1L) {
      return 0L;
    }
    return this.expireAfterWriteNanos;
  }
  
  int getInitialCapacity()
  {
    if (this.initialCapacity == -1) {
      return 16;
    }
    return this.initialCapacity;
  }
  
  Equivalence<Object> getKeyEquivalence()
  {
    return (Equivalence)MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
  }
  
  LocalCache.Strength getKeyStrength()
  {
    return (LocalCache.Strength)MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
  }
  
  long getMaximumWeight()
  {
    if ((this.expireAfterWriteNanos == 0L) || (this.expireAfterAccessNanos == 0L)) {
      return 0L;
    }
    if (this.weigher == null) {
      return this.maximumSize;
    }
    return this.maximumWeight;
  }
  
  long getRefreshNanos()
  {
    if (this.refreshNanos == -1L) {
      return 0L;
    }
    return this.refreshNanos;
  }
  
  <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener()
  {
    return (RemovalListener)MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
  }
  
  Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier()
  {
    return this.statsCounterSupplier;
  }
  
  Ticker getTicker(boolean paramBoolean)
  {
    if (this.ticker != null) {
      return this.ticker;
    }
    if (paramBoolean) {
      return Ticker.systemTicker();
    }
    return NULL_TICKER;
  }
  
  Equivalence<Object> getValueEquivalence()
  {
    return (Equivalence)MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
  }
  
  LocalCache.Strength getValueStrength()
  {
    return (LocalCache.Strength)MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
  }
  
  <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher()
  {
    return (Weigher)MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
  }
  
  public CacheBuilder<K, V> initialCapacity(int paramInt)
  {
    boolean bool2 = true;
    if (this.initialCapacity == -1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "initial capacity was already set to %s", this.initialCapacity);
      if (paramInt < 0) {
        break label45;
      }
    }
    label45:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.initialCapacity = paramInt;
      return this;
      bool1 = false;
      break;
    }
  }
  
  boolean isRecordingStats()
  {
    return this.statsCounterSupplier == CACHE_STATS_COUNTER;
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> keyEquivalence(Equivalence<Object> paramEquivalence)
  {
    if (this.keyEquivalence == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "key equivalence was already set to %s", this.keyEquivalence);
      this.keyEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      return this;
    }
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> lenientParsing()
  {
    this.strictParsing = false;
    return this;
  }
  
  public CacheBuilder<K, V> maximumSize(long paramLong)
  {
    boolean bool2 = true;
    if (this.maximumSize == -1L)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "maximum size was already set to %s", this.maximumSize);
      if (this.maximumWeight != -1L) {
        break label95;
      }
      bool1 = true;
      label40:
      Preconditions.checkState(bool1, "maximum weight was already set to %s", this.maximumWeight);
      if (this.weigher != null) {
        break label100;
      }
      bool1 = true;
      label60:
      Preconditions.checkState(bool1, "maximum size can not be combined with weigher");
      if (paramLong < 0L) {
        break label105;
      }
    }
    label95:
    label100:
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "maximum size must not be negative");
      this.maximumSize = paramLong;
      return this;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
      bool1 = false;
      break label60;
    }
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> maximumWeight(long paramLong)
  {
    boolean bool2 = true;
    if (this.maximumWeight == -1L)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "maximum weight was already set to %s", this.maximumWeight);
      if (this.maximumSize != -1L) {
        break label79;
      }
      bool1 = true;
      label40:
      Preconditions.checkState(bool1, "maximum size was already set to %s", this.maximumSize);
      this.maximumWeight = paramLong;
      if (paramLong < 0L) {
        break label84;
      }
    }
    label79:
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "maximum weight must not be negative");
      return this;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public CacheBuilder<K, V> recordStats()
  {
    this.statsCounterSupplier = CACHE_STATS_COUNTER;
    return this;
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> refreshAfterWrite(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    Preconditions.checkNotNull(paramTimeUnit);
    if (this.refreshNanos == -1L)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "refresh was already set to %s ns", this.refreshNanos);
      if (paramLong <= 0L) {
        break label71;
      }
    }
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "duration must be positive: %s %s", paramLong, paramTimeUnit);
      this.refreshNanos = paramTimeUnit.toNanos(paramLong);
      return this;
      bool1 = false;
      break;
    }
  }
  
  @CheckReturnValue
  public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> paramRemovalListener)
  {
    if (this.removalListener == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      this.removalListener = ((RemovalListener)Preconditions.checkNotNull(paramRemovalListener));
      return this;
    }
  }
  
  CacheBuilder<K, V> setKeyStrength(LocalCache.Strength paramStrength)
  {
    if (this.keyStrength == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Key strength was already set to %s", this.keyStrength);
      this.keyStrength = ((LocalCache.Strength)Preconditions.checkNotNull(paramStrength));
      return this;
    }
  }
  
  CacheBuilder<K, V> setValueStrength(LocalCache.Strength paramStrength)
  {
    if (this.valueStrength == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Value strength was already set to %s", this.valueStrength);
      this.valueStrength = ((LocalCache.Strength)Preconditions.checkNotNull(paramStrength));
      return this;
    }
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> softValues()
  {
    return setValueStrength(LocalCache.Strength.SOFT);
  }
  
  public CacheBuilder<K, V> ticker(Ticker paramTicker)
  {
    if (this.ticker == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      this.ticker = ((Ticker)Preconditions.checkNotNull(paramTicker));
      return this;
    }
  }
  
  public String toString()
  {
    MoreObjects.ToStringHelper localToStringHelper = MoreObjects.toStringHelper(this);
    if (this.initialCapacity != -1) {
      localToStringHelper.add("initialCapacity", this.initialCapacity);
    }
    if (this.concurrencyLevel != -1) {
      localToStringHelper.add("concurrencyLevel", this.concurrencyLevel);
    }
    if (this.maximumSize != -1L) {
      localToStringHelper.add("maximumSize", this.maximumSize);
    }
    if (this.maximumWeight != -1L) {
      localToStringHelper.add("maximumWeight", this.maximumWeight);
    }
    if (this.expireAfterWriteNanos != -1L) {
      localToStringHelper.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
    }
    if (this.expireAfterAccessNanos != -1L) {
      localToStringHelper.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
    }
    if (this.keyStrength != null) {
      localToStringHelper.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
    }
    if (this.valueStrength != null) {
      localToStringHelper.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
    }
    if (this.keyEquivalence != null) {
      localToStringHelper.addValue("keyEquivalence");
    }
    if (this.valueEquivalence != null) {
      localToStringHelper.addValue("valueEquivalence");
    }
    if (this.removalListener != null) {
      localToStringHelper.addValue("removalListener");
    }
    return localToStringHelper.toString();
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> valueEquivalence(Equivalence<Object> paramEquivalence)
  {
    if (this.valueEquivalence == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "value equivalence was already set to %s", this.valueEquivalence);
      this.valueEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      return this;
    }
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> weakKeys()
  {
    return setKeyStrength(LocalCache.Strength.WEAK);
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> weakValues()
  {
    return setValueStrength(LocalCache.Strength.WEAK);
  }
  
  @GwtIncompatible
  public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> paramWeigher)
  {
    boolean bool2 = true;
    if (this.weigher == null)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (this.strictParsing) {
        if (this.maximumSize != -1L) {
          break label64;
        }
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "weigher can not be combined with maximum size", this.maximumSize);
      this.weigher = ((Weigher)Preconditions.checkNotNull(paramWeigher));
      return this;
      bool1 = false;
      break;
    }
  }
  
  static enum NullListener
    implements RemovalListener<Object, Object>
  {
    INSTANCE;
    
    private NullListener() {}
    
    public void onRemoval(RemovalNotification<Object, Object> paramRemovalNotification) {}
  }
  
  static enum OneWeigher
    implements Weigher<Object, Object>
  {
    INSTANCE;
    
    private OneWeigher() {}
    
    public int weigh(Object paramObject1, Object paramObject2)
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheBuilder
 * JD-Core Version:    0.7.0.1
 */