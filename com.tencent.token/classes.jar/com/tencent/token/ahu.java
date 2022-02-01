package com.tencent.token;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class ahu
{
  public final agx c()
  {
    if ((this instanceof agx)) {
      return (agx)this;
    }
    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(this)));
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      aep localaep = new aep((Writer)localObject);
      localaep.m = true;
      ady.X.a(localaep, this);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahu
 * JD-Core Version:    0.7.0.1
 */