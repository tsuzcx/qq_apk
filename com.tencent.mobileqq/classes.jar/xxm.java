import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class xxm
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected xxf a;
  protected xxg a;
  protected xxh a;
  protected xxi a;
  protected final xxl a;
  protected xxn a;
  
  public xxm(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Xxh = new xxj();
    this.jdField_a_of_type_Xxl = new xxl();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xxf = new xxf(this, -2.0F);
    this.jdField_a_of_type_Xxn = new xxn(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Xxi = new xxi(this);
    this.jdField_a_of_type_Xxg = this.jdField_a_of_type_Xxi;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Xxh.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Xxh.a(1);
  }
  
  protected void a(xxg paramxxg)
  {
    xxg localxxg = this.jdField_a_of_type_Xxg;
    this.jdField_a_of_type_Xxg = paramxxg;
    this.jdField_a_of_type_Xxg.a(localxxg);
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
      return this.jdField_a_of_type_Xxg.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Xxg.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxm
 * JD-Core Version:    0.7.0.1
 */