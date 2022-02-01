package com.google.gson.internal;

class LinkedHashTreeMap$KeySet$1
  extends LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>
{
  LinkedHashTreeMap$KeySet$1(LinkedHashTreeMap.KeySet paramKeySet)
  {
    super(paramKeySet.this$0);
  }
  
  public K next()
  {
    return nextNode().key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.KeySet.1
 * JD-Core Version:    0.7.0.1
 */