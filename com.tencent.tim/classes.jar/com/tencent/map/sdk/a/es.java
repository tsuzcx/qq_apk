package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.Collection;

public final class es
  implements ef
{
  private final ei a;
  
  public es(ei paramei)
  {
    this.a = paramei;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    Type localType = paramfd.b;
    Class localClass = paramfd.a;
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = eh.a(localType, localClass);
    return new a(paramdn, localType, paramdn.a(fd.a(localType)), this.a.a(paramfd));
  }
  
  final class a<E>
    extends ee<Collection<E>>
  {
    private final dn b;
    private final Type c;
    private final ee<E> d;
    private final en<? extends Collection<E>> e;
    
    public a(Type paramType, ee<E> paramee, en<? extends Collection<E>> paramen)
    {
      this.b = paramType;
      this.c = paramee;
      this.d = new fb(paramType, paramen, paramee);
      Object localObject;
      this.e = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.es
 * JD-Core Version:    0.7.0.1
 */