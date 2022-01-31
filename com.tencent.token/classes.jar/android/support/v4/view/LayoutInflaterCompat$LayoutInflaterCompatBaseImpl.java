package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class LayoutInflaterCompat$LayoutInflaterCompatBaseImpl
{
  public LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof LayoutInflaterCompat.Factory2Wrapper)) {
      return ((LayoutInflaterCompat.Factory2Wrapper)paramLayoutInflater).mDelegateFactory;
    }
    return null;
  }
  
  public void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    if (paramLayoutInflaterFactory != null) {}
    for (paramLayoutInflaterFactory = new LayoutInflaterCompat.Factory2Wrapper(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
    {
      setFactory2(paramLayoutInflater, paramLayoutInflaterFactory);
      return;
    }
  }
  
  public void setFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
    if ((localFactory instanceof LayoutInflater.Factory2))
    {
      LayoutInflaterCompat.forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      return;
    }
    LayoutInflaterCompat.forceSetFactory2(paramLayoutInflater, paramFactory2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */