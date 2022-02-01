package com.tencent.token;

import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class alf
{
  private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String c;
  
  public final boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof alf)) && (((alf)paramObject).c.equals(this.c));
  }
  
  public final int hashCode()
  {
    return this.c.hashCode();
  }
  
  public final String toString()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alf
 * JD-Core Version:    0.7.0.1
 */