package com.tencent.token;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class dl
  extends dk
{
  dl(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  dl(dk.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  dk.a b()
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
    extends dk.a
  {
    a(dk.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new dl(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dl
 * JD-Core Version:    0.7.0.1
 */