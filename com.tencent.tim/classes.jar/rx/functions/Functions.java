package rx.functions;

public final class Functions
{
  private Functions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static FuncN<Void> fromAction(Action0 paramAction0)
  {
    return new Functions.11(paramAction0);
  }
  
  public static <T0> FuncN<Void> fromAction(Action1<? super T0> paramAction1)
  {
    return new Functions.12(paramAction1);
  }
  
  public static <T0, T1> FuncN<Void> fromAction(Action2<? super T0, ? super T1> paramAction2)
  {
    return new Functions.13(paramAction2);
  }
  
  public static <T0, T1, T2> FuncN<Void> fromAction(Action3<? super T0, ? super T1, ? super T2> paramAction3)
  {
    return new Functions.14(paramAction3);
  }
  
  public static <R> FuncN<R> fromFunc(Func0<? extends R> paramFunc0)
  {
    return new Functions.1(paramFunc0);
  }
  
  public static <T0, R> FuncN<R> fromFunc(Func1<? super T0, ? extends R> paramFunc1)
  {
    return new Functions.2(paramFunc1);
  }
  
  public static <T0, T1, R> FuncN<R> fromFunc(Func2<? super T0, ? super T1, ? extends R> paramFunc2)
  {
    return new Functions.3(paramFunc2);
  }
  
  public static <T0, T1, T2, R> FuncN<R> fromFunc(Func3<? super T0, ? super T1, ? super T2, ? extends R> paramFunc3)
  {
    return new Functions.4(paramFunc3);
  }
  
  public static <T0, T1, T2, T3, R> FuncN<R> fromFunc(Func4<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> paramFunc4)
  {
    return new Functions.5(paramFunc4);
  }
  
  public static <T0, T1, T2, T3, T4, R> FuncN<R> fromFunc(Func5<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc5)
  {
    return new Functions.6(paramFunc5);
  }
  
  public static <T0, T1, T2, T3, T4, T5, R> FuncN<R> fromFunc(Func6<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc6)
  {
    return new Functions.7(paramFunc6);
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, R> FuncN<R> fromFunc(Func7<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc7)
  {
    return new Functions.8(paramFunc7);
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, R> FuncN<R> fromFunc(Func8<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc8)
  {
    return new Functions.9(paramFunc8);
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> FuncN<R> fromFunc(Func9<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc9)
  {
    return new Functions.10(paramFunc9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.functions.Functions
 * JD-Core Version:    0.7.0.1
 */