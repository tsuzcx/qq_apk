package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;

@RequiresApi(21)
class LayoutInflaterCompat$LayoutInflaterCompatApi21Impl
  extends LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
{
  public void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    if (paramLayoutInflaterFactory != null) {}
    for (paramLayoutInflaterFactory = new LayoutInflaterCompat.Factory2Wrapper(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
    {
      paramLayoutInflater.setFactory2(paramLayoutInflaterFactory);
      return;
    }
  }
  
  public void setFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */