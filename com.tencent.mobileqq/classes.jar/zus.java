import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class zus
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected zul a;
  protected zum a;
  protected zun a;
  protected zuo a;
  protected final zur a;
  public zut a;
  
  public zus(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Zun = new zup();
    this.jdField_a_of_type_Zur = new zur();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zul = new zul(this, -2.0F);
    this.jdField_a_of_type_Zut = new zut(this, 3.0F, 1.0F);
    this.jdField_a_of_type_Zuo = new zuo(this);
    this.jdField_a_of_type_Zum = this.jdField_a_of_type_Zuo;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_Zun.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_Zun.a(1);
  }
  
  protected void a(zum paramzum)
  {
    zum localzum = this.jdField_a_of_type_Zum;
    this.jdField_a_of_type_Zum = paramzum;
    this.jdField_a_of_type_Zum.a(localzum);
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
      return this.jdField_a_of_type_Zum.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_Zum.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zus
 * JD-Core Version:    0.7.0.1
 */