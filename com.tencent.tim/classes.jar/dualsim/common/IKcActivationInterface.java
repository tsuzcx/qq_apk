package dualsim.common;

public abstract interface IKcActivationInterface
{
  public abstract void clearCallback();
  
  public abstract String getActivationUrl();
  
  public abstract boolean onJsConfirm(String paramString1, String paramString2);
  
  public abstract void setCallback(Callback paramCallback);
  
  public static abstract interface Callback
  {
    public abstract void loadUrl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dualsim.common.IKcActivationInterface
 * JD-Core Version:    0.7.0.1
 */