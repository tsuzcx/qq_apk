package com.google.common.collect;

import java.util.Comparator;

class MultimapBuilder$MultimapBuilderWithKeys$5
  extends MultimapBuilder.SortedSetMultimapBuilder<K0, V0>
{
  MultimapBuilder$MultimapBuilderWithKeys$5(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, Comparator paramComparator) {}
  
  public <K extends K0, V extends V0> SortedSetMultimap<K, V> build()
  {
    return Multimaps.newSortedSetMultimap(this.this$0.createMap(), new MultimapBuilder.TreeSetSupplier(this.val$comparator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.5
 * JD-Core Version:    0.7.0.1
 */