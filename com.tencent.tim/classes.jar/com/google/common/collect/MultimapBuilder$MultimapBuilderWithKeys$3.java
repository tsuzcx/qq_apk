package com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$3
  extends MultimapBuilder.SetMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$3(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, int paramInt) {}
  
  public <K extends K0, V> SetMultimap<K, V> build()
  {
    return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder.HashSetSupplier(this.val$expectedValuesPerKey));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.3
 * JD-Core Version:    0.7.0.1
 */