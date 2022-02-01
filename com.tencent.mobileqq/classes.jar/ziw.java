import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ziw
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected zip a;
  protected ziq a;
  protected zir a;
  protected zis a;
  protected final ziv a;
  public zix a;
  
  public ziw(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Zir = new zit();
    this.jdField_a_of_type_Ziv = new ziv();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zip = new zip(this, -2.0F);
    this.jdField_a_of_type_Zix = new zix(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Zis = new zis(this);
    this.jdField_a_of_type_Ziq = this.jdField_a_of_type_Zis;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Zir.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Zir.a(1);
  }
  
  protected void a(ziq paramziq)
  {
    ziq localziq = this.jdField_a_of_type_Ziq;
    this.jdField_a_of_type_Ziq = paramziq;
    this.jdField_a_of_type_Ziq.a(localziq);
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
      return this.jdField_a_of_type_Ziq.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Ziq.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ziw
 * JD-Core Version:    0.7.0.1
 */