package android.arch.lifecycle;

public abstract interface GenericLifecycleObserver
  extends LifecycleObserver
{
  public abstract void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.GenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */