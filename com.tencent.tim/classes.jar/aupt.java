import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.todo.common.UnfinishedTodoItemBuilder.OnCheckBoxClickListener.1;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.List;

class aupt
  extends AnimatorListenerAdapter
{
  aupt(aupr paramaupr) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((aunv)this.a.a.a.a.adapter).hq().remove(aupq.a.a(this.a.a.a));
    this.a.a.a.a.adapter.notifyDataSetChanged();
    ((aunu)this.a.a.a.a.app.getBusinessHandler(181)).b(aupq.a.a(this.a.a.a).todoId, 2, aupq.a.a(this.a.a.a).content, aupq.a.a(this.a.a.a).remindTime);
    aupe.L(this.a.a.a.a.app, "0X80091C2", 1);
    aupf.isAnimating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupt
 * JD-Core Version:    0.7.0.1
 */