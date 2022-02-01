import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class afmh
{
  private SparseArrayCompat<SparseArrayCompat<aflk>> b = new SparseArrayCompat(10);
  private SparseArrayCompat<aflk> c = new SparseArrayCompat();
  
  public afmh(EmoticonPanelController paramEmoticonPanelController)
  {
    a(1, new afmw(paramEmoticonPanelController));
    a(2, new afna(paramEmoticonPanelController));
    a(3, new afmn(paramEmoticonPanelController));
    a(4, new afno(paramEmoticonPanelController));
    a(5, new afnh(paramEmoticonPanelController));
    a(6, new afnn(paramEmoticonPanelController));
    a(7, new afnd(paramEmoticonPanelController));
    a(8, new afnp(paramEmoticonPanelController));
  }
  
  private void a(int paramInt, aflk paramaflk)
  {
    this.c.put(paramInt, paramaflk);
    int[] arrayOfInt = paramaflk.C();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.b.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.b.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramaflk);
      i += 1;
    }
  }
  
  private void a(aflk paramaflk, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramaflk.dae();
      return;
    case 2: 
      paramaflk.daf();
      return;
    case 9: 
      paramaflk.onAttachedToWindow();
      return;
    case 10: 
      paramaflk.onDetachedFromWindow();
      return;
    case 8: 
      paramaflk.onDestory();
      return;
    case 3: 
      paramaflk.onPageSelected(paramInt2);
      return;
    case 5: 
      paramaflk.onShow();
      return;
    case 4: 
      paramaflk.yQ(paramBoolean);
      return;
    case 7: 
      paramaflk.onPause();
      return;
    }
    paramaflk.onResume();
  }
  
  public void CS(int paramInt)
  {
    z(paramInt, -1, false);
  }
  
  public <T extends aflk> T a(int paramInt)
  {
    return (aflk)this.c.get(paramInt);
  }
  
  public void z(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.b.get(paramInt1);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        a((aflk)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmh
 * JD-Core Version:    0.7.0.1
 */