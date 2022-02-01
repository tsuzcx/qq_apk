package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

class MediaType$1
  implements Function<Collection<String>, ImmutableMultiset<String>>
{
  MediaType$1(MediaType paramMediaType) {}
  
  public ImmutableMultiset<String> apply(Collection<String> paramCollection)
  {
    return ImmutableMultiset.copyOf(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.net.MediaType.1
 * JD-Core Version:    0.7.0.1
 */