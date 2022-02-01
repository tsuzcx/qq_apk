package com.tencent.token;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public final class amq
  implements amw<PointF>
{
  private final List<amc> a = new ArrayList();
  private PointF b = new PointF(0.0F, 0.0F);
  
  private boolean b()
  {
    return !this.a.isEmpty();
  }
  
  public final ama<PointF> a()
  {
    if (!b()) {
      return new amh(this.b);
    }
    return new amd(this.a);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("initialPoint=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amq
 * JD-Core Version:    0.7.0.1
 */