import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.BaseAdapter;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.List;

class aupj
  extends AnimatorListenerAdapter
{
  aupj(aupf paramaupf, TodoInfo paramTodoInfo) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((aunv)this.a.adapter).hq().remove(this.c);
    this.a.adapter.notifyDataSetChanged();
    aupf.a(this.a).b(2131364767, this.c);
    aupf.isAnimating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupj
 * JD-Core Version:    0.7.0.1
 */