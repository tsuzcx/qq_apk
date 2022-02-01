import android.view.ViewGroup;

public class amlw
  extends amlt<ampw, amxx>
{
  private aqdf a;
  
  public amlw(aqdf paramaqdf)
  {
    this.a = paramaqdf;
  }
  
  protected amsq a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return new agnu(this.a);
    case 0: 
      return new amtj();
    case 1: 
      return new atwu(this.a);
    case 2: 
      return new atwn(this.a);
    case 3: 
      return new atwo(this.a);
    }
    return new atwt(this.a);
  }
  
  protected amxz a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return new amzj(paramViewGroup, 2131563021);
    case 0: 
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return new amzh(paramViewGroup, bool, false);
      }
    case 1: 
      return new amzj(paramViewGroup, 2131563021);
    case 2: 
      return new amzj(paramViewGroup, 2131563021);
    }
    return new amzj(paramViewGroup, 2131563021);
  }
  
  public int getItemViewType(int paramInt)
  {
    ampw localampw = (ampw)a(paramInt);
    if ((localampw instanceof ampf)) {
      return 0;
    }
    if ((localampw instanceof atws)) {
      return 1;
    }
    if ((localampw instanceof atwp)) {
      return 2;
    }
    if ((localampw instanceof atwq)) {
      return 3;
    }
    if ((localampw instanceof atwr)) {
      return 4;
    }
    return 4;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlw
 * JD-Core Version:    0.7.0.1
 */