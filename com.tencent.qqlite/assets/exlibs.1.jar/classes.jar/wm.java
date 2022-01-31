import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.AddFriendActivity;

class wm
  implements View.OnClickListener
{
  wm(wl paramwl) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      int i = ((wn)localObject).a;
      this.a.a.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(this.a.a.jdField_a_of_type_AndroidWidgetGridView, paramView, i, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wm
 * JD-Core Version:    0.7.0.1
 */