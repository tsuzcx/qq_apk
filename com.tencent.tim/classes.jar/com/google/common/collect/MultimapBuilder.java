package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Beta
@GwtCompatible
public abstract class MultimapBuilder<K0, V0>
{
  private static final int DEFAULT_EXPECTED_KEYS = 8;
  
  public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(Class<K0> paramClass)
  {
    Preconditions.checkNotNull(paramClass);
    return new MultimapBuilder.4(paramClass);
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys()
  {
    return hashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "expectedKeys");
    return new MultimapBuilder.1(paramInt);
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys()
  {
    return linkedHashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "expectedKeys");
    return new MultimapBuilder.2(paramInt);
  }
  
  public static MultimapBuilderWithKeys<Comparable> treeKeys()
  {
    return treeKeys(Ordering.natural());
  }
  
  public static <K0> MultimapBuilderWithKeys<K0> treeKeys(Comparator<K0> paramComparator)
  {
    Preconditions.checkNotNull(paramComparator);
    return new MultimapBuilder.3(paramComparator);
  }
  
  public abstract <K extends K0, V extends V0> Multimap<K, V> build();
  
  public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
  {
    Multimap localMultimap = build();
    localMultimap.putAll(paramMultimap);
    return localMultimap;
  }
  
  static final class ArrayListSupplier<V>
    implements Supplier<List<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    ArrayListSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public List<V> get()
    {
      return new ArrayList(this.expectedValuesPerKey);
    }
  }
  
  static final class EnumSetSupplier<V extends Enum<V>>
    implements Supplier<Set<V>>, Serializable
  {
    private final Class<V> clazz;
    
    EnumSetSupplier(Class<V> paramClass)
    {
      this.clazz = ((Class)Preconditions.checkNotNull(paramClass));
    }
    
    public Set<V> get()
    {
      return EnumSet.noneOf(this.clazz);
    }
  }
  
  static final class HashSetSupplier<V>
    implements Supplier<Set<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    HashSetSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public Set<V> get()
    {
      return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  static final class LinkedHashSetSupplier<V>
    implements Supplier<Set<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    LinkedHashSetSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public Set<V> get()
    {
      return Sets.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  static enum LinkedListSupplier
    implements Supplier<List<Object>>
  {
    INSTANCE;
    
    private LinkedListSupplier() {}
    
    public static <V> Supplier<List<V>> instance()
    {
      return INSTANCE;
    }
    
    public List<Object> get()
    {
      return new LinkedList();
    }
  }
  
  public static abstract class ListMultimapBuilder<K0, V0>
    extends MultimapBuilder<K0, V0>
  {
    ListMultimapBuilder()
    {
      super();
    }
    
    public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();
    
    public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (ListMultimap)super.build(paramMultimap);
    }
  }
  
  public static abstract class MultimapBuilderWithKeys<K0>
  {
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues()
    {
      return arrayListValues(2);
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues(int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      return new MultimapBuilder.MultimapBuilderWithKeys.1(this, paramInt);
    }
    
    abstract <K extends K0, V> Map<K, Collection<V>> createMap();
    
    public <V0 extends Enum<V0>> MultimapBuilder.SetMultimapBuilder<K0, V0> enumSetValues(Class<V0> paramClass)
    {
      Preconditions.checkNotNull(paramClass, "valueClass");
      return new MultimapBuilder.MultimapBuilderWithKeys.6(this, paramClass);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues()
    {
      return hashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues(int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      return new MultimapBuilder.MultimapBuilderWithKeys.3(this, paramInt);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues()
    {
      return linkedHashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues(int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      return new MultimapBuilder.MultimapBuilderWithKeys.4(this, paramInt);
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> linkedListValues()
    {
      return new MultimapBuilder.MultimapBuilderWithKeys.2(this);
    }
    
    public MultimapBuilder.SortedSetMultimapBuilder<K0, Comparable> treeSetValues()
    {
      return treeSetValues(Ordering.natural());
    }
    
    public <V0> MultimapBuilder.SortedSetMultimapBuilder<K0, V0> treeSetValues(Comparator<V0> paramComparator)
    {
      Preconditions.checkNotNull(paramComparator, "comparator");
      return new MultimapBuilder.MultimapBuilderWithKeys.5(this, paramComparator);
    }
  }
  
  public static abstract class SetMultimapBuilder<K0, V0>
    extends MultimapBuilder<K0, V0>
  {
    SetMultimapBuilder()
    {
      super();
    }
    
    public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (SetMultimap)super.build(paramMultimap);
    }
  }
  
  public static abstract class SortedSetMultimapBuilder<K0, V0>
    extends MultimapBuilder.SetMultimapBuilder<K0, V0>
  {
    public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (SortedSetMultimap)super.build(paramMultimap);
    }
  }
  
  static final class TreeSetSupplier<V>
    implements Supplier<SortedSet<V>>, Serializable
  {
    private final Comparator<? super V> comparator;
    
    TreeSetSupplier(Comparator<? super V> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public SortedSet<V> get()
    {
      return new TreeSet(this.comparator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder
 * JD-Core Version:    0.7.0.1
 */