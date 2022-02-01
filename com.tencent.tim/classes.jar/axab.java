import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class axab
  extends awwn
{
  private View Mp;
  private TextView agY;
  
  public axab(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void eIp()
  {
    if (!aOe()) {
      return;
    }
    this.agY.setVisibility(8);
  }
  
  public void hide()
  {
    if (aOe())
    {
      this.Mp.setVisibility(8);
      this.agY.setVisibility(8);
    }
  }
  
  protected void jm(View paramView)
  {
    this.Mp = paramView.findViewById(2131366639);
    this.agY = ((TextView)paramView.findViewById(2131366641));
  }
  
  public void show()
  {
    eHc();
    this.Mp.setVisibility(0);
    this.agY.setVisibility(0);
    this.agY.setText(2131693775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axab
 * JD-Core Version:    0.7.0.1
 */