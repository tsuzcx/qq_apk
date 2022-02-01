package dualsim.common;

import android.content.Context;

public abstract interface IKingCardInterface
{
  public abstract IKcActivationInterface generateActivationInterface(Context paramContext);
  
  public abstract IKcActivationViewer generateActivationView(Context paramContext);
  
  public abstract String getGuid();
  
  public abstract OrderCheckResult getResult();
  
  public abstract void registerOnChangeListener(OnChangeListener paramOnChangeListener);
  
  public abstract void unRegisterOnChangeListener(OnChangeListener paramOnChangeListener);
  
  public static abstract interface OnChangeListener
  {
    public abstract void onChanged(OrderCheckResult paramOrderCheckResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dualsim.common.IKingCardInterface
 * JD-Core Version:    0.7.0.1
 */