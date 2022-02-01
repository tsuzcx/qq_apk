package com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$1
  extends MultimapBuilder.ListMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$1(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, int paramInt) {}
  
  public <K extends K0, V> ListMultimap<K, V> build()
  {
    return Multimaps.newListMultimap(this.this$0.createMap(), new MultimapBuilder.ArrayListSupplier(this.val$expectedValuesPerKey));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1
 * JD-Core Version:    0.7.0.1
 */