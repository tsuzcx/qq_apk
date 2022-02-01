import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class zqx
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected zqq a;
  protected zqr a;
  protected zqs a;
  protected zqt a;
  protected final zqw a;
  public zqy a;
  
  public zqx(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Zqs = new zqu();
    this.jdField_a_of_type_Zqw = new zqw();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zqq = new zqq(this, -2.0F);
    this.jdField_a_of_type_Zqy = new zqy(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Zqt = new zqt(this);
    this.jdField_a_of_type_Zqr = this.jdField_a_of_type_Zqt;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Zqs.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Zqs.a(1);
  }
  
  protected void a(zqr paramzqr)
  {
    zqr localzqr = this.jdField_a_of_type_Zqr;
    this.jdField_a_of_type_Zqr = paramzqr;
    this.jdField_a_of_type_Zqr.a(localzqr);
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
      return this.jdField_a_of_type_Zqr.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Zqr.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqx
 * JD-Core Version:    0.7.0.1
 */