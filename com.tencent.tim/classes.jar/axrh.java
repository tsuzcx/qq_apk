public abstract class axrh
  extends aquy
{
  public abstract void ax(String paramString, boolean paramBoolean);
  
  public abstract void c(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(aquz paramaquz)
  {
    super.onCancel(paramaquz);
    onCancel(paramaquz.key);
  }
  
  public abstract void onCancel(String paramString);
  
  public void onDone(aquz paramaquz)
  {
    String str = paramaquz.key;
    if (paramaquz.getStatus() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      c(str, bool, paramaquz.errCode);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    vS(2);
  }
  
  public void onNetWifi2Mobile()
  {
    super.onNetWifi2Mobile();
    vS(1);
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    vS(3);
  }
  
  public void onProgress(aquz paramaquz)
  {
    super.onProgress(paramaquz);
    int i = (int)paramaquz.fj;
    onProgress(paramaquz.key, i);
  }
  
  public abstract void onProgress(String paramString, int paramInt);
  
  public boolean onStart(aquz paramaquz)
  {
    super.onStart(paramaquz);
    ax(paramaquz.key, true);
    return true;
  }
  
  public abstract void vS(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrh
 * JD-Core Version:    0.7.0.1
 */