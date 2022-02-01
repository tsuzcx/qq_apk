package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible(emulated=true)
public final class MapMaker
{
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  static final int UNSET_INT = -1;
  int concurrencyLevel = -1;
  int initialCapacity = -1;
  Equivalence<Object> keyEquivalence;
  MapMakerInternalMap.Strength keyStrength;
  boolean useCustomMap;
  MapMakerInternalMap.Strength valueStrength;
  
  @CanIgnoreReturnValue
  public MapMaker concurrencyLevel(int paramInt)
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
  
  int getConcurrencyLevel()
  {
    if (this.concurrencyLevel == -1) {
      return 4;
    }
    return this.concurrencyLevel;
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
  
  MapMakerInternalMap.Strength getKeyStrength()
  {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  MapMakerInternalMap.Strength getValueStrength()
  {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  @CanIgnoreReturnValue
  public MapMaker initialCapacity(int paramInt)
  {
    boolean bool2 = true;
    if (this.initialCapacity == -1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "initial capacity was already set to %s", this.initialCapacity);
      if (paramInt < 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.initialCapacity = paramInt;
      return this;
      bool1 = false;
      break;
    }
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  MapMaker keyEquivalence(Equivalence<Object> paramEquivalence)
  {
    if (this.keyEquivalence == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "key equivalence was already set to %s", this.keyEquivalence);
      this.keyEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      this.useCustomMap = true;
      return this;
    }
  }
  
  @GwtIncompatible
  <K, V> MapMakerInternalMap<K, V, ?, ?> makeCustomMap()
  {
    return MapMakerInternalMap.create(this);
  }
  
  public <K, V> ConcurrentMap<K, V> makeMap()
  {
    if (!this.useCustomMap) {
      return new ConcurrentHashMap(getInitialCapacity(), 0.75F, getConcurrencyLevel());
    }
    return MapMakerInternalMap.create(this);
  }
  
  MapMaker setKeyStrength(MapMakerInternalMap.Strength paramStrength)
  {
    if (this.keyStrength == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Key strength was already set to %s", this.keyStrength);
      this.keyStrength = ((MapMakerInternalMap.Strength)Preconditions.checkNotNull(paramStrength));
      if (paramStrength != MapMakerInternalMap.Strength.STRONG) {
        this.useCustomMap = true;
      }
      return this;
    }
  }
  
  MapMaker setValueStrength(MapMakerInternalMap.Strength paramStrength)
  {
    if (this.valueStrength == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Value strength was already set to %s", this.valueStrength);
      this.valueStrength = ((MapMakerInternalMap.Strength)Preconditions.checkNotNull(paramStrength));
      if (paramStrength != MapMakerInternalMap.Strength.STRONG) {
        this.useCustomMap = true;
      }
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
    if (this.keyStrength != null) {
      localToStringHelper.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
    }
    if (this.valueStrength != null) {
      localToStringHelper.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
    }
    if (this.keyEquivalence != null) {
      localToStringHelper.addValue("keyEquivalence");
    }
    return localToStringHelper.toString();
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public MapMaker weakKeys()
  {
    return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public MapMaker weakValues()
  {
    return setValueStrength(MapMakerInternalMap.Strength.WEAK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapMaker
 * JD-Core Version:    0.7.0.1
 */