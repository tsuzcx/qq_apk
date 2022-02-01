package com.google.ical.util;

import java.io.Serializable;

public class Predicates
{
  private static final Predicate<?> ALWAYS_FALSE;
  private static final Predicate<?> ALWAYS_TRUE;
  
  static
  {
    if (!Predicates.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ALWAYS_TRUE = new AlwaysTruePredicate(null);
      ALWAYS_FALSE = new AlwaysFalsePredicate(null);
      return;
    }
  }
  
  public static <T> Predicate<T> alwaysFalse()
  {
    return ALWAYS_FALSE;
  }
  
  public static <T> Predicate<T> alwaysTrue()
  {
    return ALWAYS_TRUE;
  }
  
  public static <T> Predicate<T> and(Predicate<? super T>... paramVarArgs)
  {
    assert (paramVarArgs != null);
    return new AndPredicate(paramVarArgs, null);
  }
  
  public static <T> Predicate<T> not(Predicate<? super T> paramPredicate)
  {
    assert (paramPredicate != null);
    return new NotPredicate(paramPredicate, null);
  }
  
  public static <T> Predicate<T> or(Predicate<? super T>... paramVarArgs)
  {
    assert (paramVarArgs != null);
    return new OrPredicate(paramVarArgs, null);
  }
  
  static class AlwaysFalsePredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = -565481022115659695L;
    
    public boolean apply(T paramT)
    {
      return false;
    }
  }
  
  static class AlwaysTruePredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = 8759914710239461322L;
    
    public boolean apply(T paramT)
    {
      return true;
    }
  }
  
  static class AndPredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = 1022358602593297546L;
    private final Predicate<? super T>[] components;
    
    private AndPredicate(Predicate<? super T>... paramVarArgs)
    {
      this.components = paramVarArgs;
    }
    
    public boolean apply(T paramT)
    {
      Predicate[] arrayOfPredicate = this.components;
      int j = arrayOfPredicate.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfPredicate[i].apply(paramT)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
  }
  
  static class NotPredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = -5113445916422049953L;
    private final Predicate<? super T> predicate;
    
    private NotPredicate(Predicate<? super T> paramPredicate)
    {
      this.predicate = paramPredicate;
    }
    
    public boolean apply(T paramT)
    {
      return !this.predicate.apply(paramT);
    }
  }
  
  static class OrPredicate<T>
    implements Predicate<T>, Serializable
  {
    private static final long serialVersionUID = -7942366790698074803L;
    private final Predicate<? super T>[] components;
    
    private OrPredicate(Predicate<? super T>... paramVarArgs)
    {
      this.components = paramVarArgs;
    }
    
    public boolean apply(T paramT)
    {
      boolean bool2 = false;
      Predicate[] arrayOfPredicate = this.components;
      int j = arrayOfPredicate.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfPredicate[i].apply(paramT)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.util.Predicates
 * JD-Core Version:    0.7.0.1
 */