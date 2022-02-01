import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.common.UnfinishedTodoItemBuilder.OnCheckBoxClickListener.1;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.tim.todo.widget.StrikeThruTextView;
import java.util.ArrayList;
import java.util.List;

public class aupq
  extends aupf
{
  public aupq(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter);
  }
  
  public View b(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131563218, paramViewGroup, false);
      paramViewGroup = new aupf.a(this);
      paramViewGroup.a = ((StrikeThruTextView)paramView.findViewById(2131379962));
      paramViewGroup.b = ((LottieAnimationView)paramView.findViewById(2131369420));
      paramViewGroup.b.setAnimation("LottieCheckBoxGuide/click_checkbox.json");
      paramViewGroup.time = ((TextView)paramView.findViewById(2131379961));
      paramViewGroup.afD = ((TextView)paramView.findViewById(2131379958));
      paramViewGroup.aN = ((RelativeLayout)paramView.findViewById(2131379960));
      paramViewGroup.divider = paramView.findViewById(2131379957);
      paramView.setTag(paramViewGroup);
      paramViewGroup.d = ((TodoInfo)paramObject);
      if (((TodoInfo)paramObject).status == 1) {
        paramViewGroup.a.setItDone(false);
      }
      paramViewGroup.a.clearAnimation();
      a(paramViewGroup);
      paramViewGroup.b.setTag(-10, paramObject);
      paramViewGroup.b.setProgress(0.0F);
      paramViewGroup.b.setOnClickListener(new aupq.a(paramViewGroup, (TodoInfo)paramObject));
      paramObject = (RelativeLayout.LayoutParams)paramViewGroup.divider.getLayoutParams();
      if ((paramInt != this.adapter.getCount() - 1) && ((paramInt + 1 >= this.adapter.getCount()) || (!(this.adapter.getItem(paramInt + 1) instanceof aupp)))) {
        break label307;
      }
      paramObject.addRule(5, 0);
    }
    for (;;)
    {
      paramViewGroup.divider.setLayoutParams(paramObject);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      return paramView;
      paramViewGroup = (aupf.a)paramView.getTag();
      break;
      label307:
      paramObject.addRule(5, 2131379956);
    }
  }
  
  public List<atiw> b(Object paramObject)
  {
    paramObject = new ArrayList();
    paramObject.add(d);
    paramObject.add(b);
    return paramObject;
  }
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(b);
    return localArrayList;
  }
  
  public class a
    implements View.OnClickListener
  {
    private aupf.a jdField_a_of_type_Aupf$a;
    private TodoInfo e;
    
    public a(aupf.a parama, TodoInfo paramTodoInfo)
    {
      this.jdField_a_of_type_Aupf$a = parama;
      this.e = paramTodoInfo;
    }
    
    public void onClick(View paramView)
    {
      if (aupf.isAnimating) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ((Vibrator)aupq.this.context.getSystemService("vibrator")).vibrate(10L);
        aqge.ce(2131230774, false);
        aupf.isAnimating = true;
        this.jdField_a_of_type_Aupf$a.b.playAnimation();
        this.jdField_a_of_type_Aupf$a.a.postDelayed(new UnfinishedTodoItemBuilder.OnCheckBoxClickListener.1(this), 266L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupq
 * JD-Core Version:    0.7.0.1
 */