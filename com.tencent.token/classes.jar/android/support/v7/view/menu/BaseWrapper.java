package android.support.v7.view.menu;

class BaseWrapper<T>
{
  final T mWrappedObject;
  
  BaseWrapper(T paramT)
  {
    if (paramT != null)
    {
      this.mWrappedObject = paramT;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public T getWrappedObject()
  {
    return this.mWrappedObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.BaseWrapper
 * JD-Core Version:    0.7.0.1
 */