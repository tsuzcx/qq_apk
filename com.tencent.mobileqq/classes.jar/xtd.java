import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class xtd
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected xsw a;
  protected xsx a;
  protected xsy a;
  protected xsz a;
  protected final xtc a;
  protected xte a;
  
  public xtd(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Xsy = new xta();
    this.jdField_a_of_type_Xtc = new xtc();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xsw = new xsw(this, -2.0F);
    this.jdField_a_of_type_Xte = new xte(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Xsz = new xsz(this);
    this.jdField_a_of_type_Xsx = this.jdField_a_of_type_Xsz;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Xsy.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Xsy.a(1);
  }
  
  protected void a(xsx paramxsx)
  {
    xsx localxsx = this.jdField_a_of_type_Xsx;
    this.jdField_a_of_type_Xsx = paramxsx;
    this.jdField_a_of_type_Xsx.a(localxsx);
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
      return this.jdField_a_of_type_Xsx.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Xsx.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */