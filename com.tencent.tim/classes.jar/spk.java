import android.view.View;

public class spk
{
  private int byA;
  private int byz;
  
  public spk(int paramInt1, int paramInt2)
  {
    this.byz = paramInt1;
    this.byA = paramInt2;
  }
  
  public static spk a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new spk(0, -1);
    case 0: 
      return new spk(0, 0);
    case 1: 
      return new spk(0, -1);
    }
    return new spk(0, -2);
  }
  
  public static spk b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new spk(1, -1);
    case 3: 
      return new spk(1, 0);
    case 1: 
      return new spk(1, -1);
    }
    return new spk(1, -2);
  }
  
  public void eh(View paramView)
  {
    if (this.byz == 0) {
      switch (this.byA)
      {
      default: 
        paramView.setPivotX(this.byA);
      }
    }
    while (this.byz != 1)
    {
      return;
      paramView.setPivotX(paramView.getWidth() * 0.5F);
      return;
      paramView.setPivotX(paramView.getWidth());
      return;
    }
    switch (this.byA)
    {
    default: 
      paramView.setPivotY(this.byA);
      return;
    case -1: 
      paramView.setPivotY(paramView.getHeight() * 0.5F);
      return;
    }
    paramView.setPivotY(paramView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spk
 * JD-Core Version:    0.7.0.1
 */