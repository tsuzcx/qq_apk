import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class yud
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected ytw a;
  protected ytx a;
  protected yty a;
  protected ytz a;
  protected final yuc a;
  public yue a;
  
  public yud(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Yty = new yua();
    this.jdField_a_of_type_Yuc = new yuc();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ytw = new ytw(this, -2.0F);
    this.jdField_a_of_type_Yue = new yue(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Ytz = new ytz(this);
    this.jdField_a_of_type_Ytx = this.jdField_a_of_type_Ytz;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Yty.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Yty.a(1);
  }
  
  protected void a(ytx paramytx)
  {
    ytx localytx = this.jdField_a_of_type_Ytx;
    this.jdField_a_of_type_Ytx = paramytx;
    this.jdField_a_of_type_Ytx.a(localytx);
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
      return this.jdField_a_of_type_Ytx.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Ytx.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yud
 * JD-Core Version:    0.7.0.1
 */