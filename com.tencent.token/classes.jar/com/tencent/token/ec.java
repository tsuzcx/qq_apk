package com.tencent.token;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class ec
  extends eb
{
  ec(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  ec(eb.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  eb.a b()
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
    extends eb.a
  {
    a(eb.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new ec(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ec
 * JD-Core Version:    0.7.0.1
 */