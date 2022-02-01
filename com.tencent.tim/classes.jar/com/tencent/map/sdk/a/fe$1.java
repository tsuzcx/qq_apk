package com.tencent.map.sdk.a;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class fe$1
  extends ek
{
  public final void a(fe paramfe)
    throws IOException
  {
    if ((paramfe instanceof eu))
    {
      paramfe = (eu)paramfe;
      paramfe.a(ff.e);
      Map.Entry localEntry = (Map.Entry)((Iterator)paramfe.g()).next();
      paramfe.a.add(localEntry.getValue());
      paramfe.a.add(new dy((String)localEntry.getKey()));
      return;
    }
    int j = fe.a(paramfe);
    int i = j;
    if (j == 0) {
      i = fe.b(paramfe);
    }
    if (i == 13)
    {
      fe.a(paramfe, 9);
      return;
    }
    if (i == 12)
    {
      fe.a(paramfe, 8);
      return;
    }
    if (i == 14)
    {
      fe.a(paramfe, 10);
      return;
    }
    throw new IllegalStateException("Expected a name but was " + paramfe.f() + "  at line " + fe.c(paramfe) + " column " + fe.d(paramfe));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fe.1
 * JD-Core Version:    0.7.0.1
 */