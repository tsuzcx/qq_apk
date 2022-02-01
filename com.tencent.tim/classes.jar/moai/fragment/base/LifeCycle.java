package moai.fragment.base;

public abstract interface LifeCycle
{
  public abstract void initDataSource();
  
  public abstract void onBackground();
  
  public abstract void onBindEvent(boolean paramBoolean);
  
  public abstract void onForeground();
  
  public abstract void onRelease();
  
  public abstract void onWindowConfiguration(boolean paramBoolean);
  
  public abstract int refreshData();
  
  public abstract void render(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.LifeCycle
 * JD-Core Version:    0.7.0.1
 */