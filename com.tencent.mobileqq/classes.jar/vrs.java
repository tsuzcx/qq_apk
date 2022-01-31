import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class vrs
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected vrl a;
  protected vrm a;
  protected vrn a;
  protected vro a;
  protected final vrr a;
  protected vrt a;
  
  public vrs(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Vrn = new vrp();
    this.jdField_a_of_type_Vrr = new vrr();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vrl = new vrl(this, -2.0F);
    this.jdField_a_of_type_Vrt = new vrt(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Vro = new vro(this);
    this.jdField_a_of_type_Vrm = this.jdField_a_of_type_Vro;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Vrn.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Vrn.a(1);
  }
  
  protected void a(vrm paramvrm)
  {
    vrm localvrm = this.jdField_a_of_type_Vrm;
    this.jdField_a_of_type_Vrm = paramvrm;
    this.jdField_a_of_type_Vrm.a(localvrm);
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
      return this.jdField_a_of_type_Vrm.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Vrm.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrs
 * JD-Core Version:    0.7.0.1
 */