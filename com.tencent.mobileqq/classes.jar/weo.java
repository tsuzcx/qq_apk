import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class weo
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected weh a;
  protected wei a;
  protected wej a;
  protected wek a;
  protected final wen a;
  protected wep a;
  
  public weo(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Wej = new wel();
    this.jdField_a_of_type_Wen = new wen();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Weh = new weh(this, -2.0F);
    this.jdField_a_of_type_Wep = new wep(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Wek = new wek(this);
    this.jdField_a_of_type_Wei = this.jdField_a_of_type_Wek;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Wej.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Wej.a(1);
  }
  
  protected void a(wei paramwei)
  {
    wei localwei = this.jdField_a_of_type_Wei;
    this.jdField_a_of_type_Wei = paramwei;
    this.jdField_a_of_type_Wei.a(localwei);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 2: 
      return this.jdField_a_of_type_Wei.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Wei.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     weo
 * JD-Core Version:    0.7.0.1
 */