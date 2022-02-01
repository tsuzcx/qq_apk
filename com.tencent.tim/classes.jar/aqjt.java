import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class aqjt
  extends aqju
{
  aqoa a;
  private int dZH = 2131559139;
  
  public aqjt(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void Xy(int paramInt)
  {
    this.dZH = paramInt;
  }
  
  public void a(aqoa paramaqoa, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramaqoa == null) {}
    do
    {
      return;
      this.a = paramaqoa;
      String[] arrayOfString = new String[paramaqoa.size()];
      int i = 0;
      while (i < paramaqoa.size())
      {
        arrayOfString[i] = paramaqoa.a(i).getTitle();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      paramaqoa = paramaqoa.Cl();
    } while (paramaqoa == null);
    setTitle(paramaqoa);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    aqob localaqob = this.a.a(paramInt);
    if (localaqob != null) {
      return localaqob.getItemId();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.dZH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjt
 * JD-Core Version:    0.7.0.1
 */