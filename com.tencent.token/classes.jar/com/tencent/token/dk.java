package com.tencent.token;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class dk
  extends dj
{
  dk(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  dk(dj.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  dj.a b()
  {
    return new a(this.b);
  }
  
  public boolean isAutoMirrored()
  {
    return this.c.isAutoMirrored();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.c.setAutoMirrored(paramBoolean);
  }
  
  static final class a
    extends dj.a
  {
    a(dj.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new dk(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dk
 * JD-Core Version:    0.7.0.1
 */