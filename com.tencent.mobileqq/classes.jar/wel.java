import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class wel
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected wee a;
  protected wef a;
  protected weg a;
  protected weh a;
  protected final wek a;
  protected wem a;
  
  public wel(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Weg = new wei();
    this.jdField_a_of_type_Wek = new wek();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wee = new wee(this, -2.0F);
    this.jdField_a_of_type_Wem = new wem(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Weh = new weh(this);
    this.jdField_a_of_type_Wef = this.jdField_a_of_type_Weh;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Weg.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Weg.a(1);
  }
  
  protected void a(wef paramwef)
  {
    wef localwef = this.jdField_a_of_type_Wef;
    this.jdField_a_of_type_Wef = paramwef;
    this.jdField_a_of_type_Wef.a(localwef);
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
      return this.jdField_a_of_type_Wef.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Wef.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wel
 * JD-Core Version:    0.7.0.1
 */