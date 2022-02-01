package com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$6
  extends MultimapBuilder.SetMultimapBuilder<K0, V0>
{
  MultimapBuilder$MultimapBuilderWithKeys$6(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, Class paramClass) {}
  
  public <K extends K0, V extends V0> SetMultimap<K, V> build()
  {
    MultimapBuilder.EnumSetSupplier localEnumSetSupplier = new MultimapBuilder.EnumSetSupplier(this.val$valueClass);
    return Multimaps.newSetMultimap(this.this$0.createMap(), localEnumSetSupplier);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.6
 * JD-Core Version:    0.7.0.1
 */