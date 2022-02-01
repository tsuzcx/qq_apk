import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ayuf
  extends aygy
  implements View.OnClickListener
{
  private Button jdField_if;
  private LinearLayout mA;
  
  public ayuf(@NonNull ayub paramayub)
  {
    super(paramayub);
  }
  
  private void eTG()
  {
    aqha.a(a().getActivity(), 230).setMessage(2131718244).setPositiveButton(2131717752, new ayui(this)).setNegativeButton(2131691970, new ayuh(this)).show();
  }
  
  public ayub a()
  {
    return (ayub)this.b;
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      this.mA.setVisibility(8);
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate()
  {
    super.onCreate();
    this.mA = ((LinearLayout)y(2131376008));
    this.jdField_if = ((Button)y(2131367290));
    this.jdField_if.setOnClickListener(new ayug(this));
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.mA.setVisibility(8);
      return;
    }
    this.mA.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuf
 * JD-Core Version:    0.7.0.1
 */