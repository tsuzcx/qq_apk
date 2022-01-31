package android.support.v7.view.menu;

class BaseWrapper
{
  final Object mWrappedObject;
  
  BaseWrapper(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    this.mWrappedObject = paramObject;
  }
  
  public Object getWrappedObject()
  {
    return this.mWrappedObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.BaseWrapper
 * JD-Core Version:    0.7.0.1
 */