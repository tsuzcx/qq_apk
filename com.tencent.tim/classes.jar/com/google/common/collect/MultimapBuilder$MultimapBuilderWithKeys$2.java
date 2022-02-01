package com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$2
  extends MultimapBuilder.ListMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$2(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys) {}
  
  public <K extends K0, V> ListMultimap<K, V> build()
  {
    return Multimaps.newListMultimap(this.this$0.createMap(), MultimapBuilder.LinkedListSupplier.instance());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.2
 * JD-Core Version:    0.7.0.1
 */