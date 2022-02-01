import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.lottieNew.LottieAnimationView.CacheStrategy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.tim.todo.widget.StrikeThruTextView;
import java.util.ArrayList;
import java.util.List;

public class aupl
  extends aupf
{
  public aupl(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter)
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
      paramViewGroup.time = ((TextView)paramView.findViewById(2131379961));
      paramViewGroup.b = ((LottieAnimationView)paramView.findViewById(2131369420));
      paramViewGroup.afD = ((TextView)paramView.findViewById(2131379958));
      paramViewGroup.aN = ((RelativeLayout)paramView.findViewById(2131379960));
      paramViewGroup.time.setAlpha(0.3F);
      paramViewGroup.afD.setAlpha(0.3F);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.d = ((TodoInfo)paramObject);
      if (((TodoInfo)paramObject).status == 2) {
        paramViewGroup.a.setItDone(true);
      }
      a(paramViewGroup);
      paramViewGroup.b.setAnimation("LottieCheckBoxGuide/click_checkbox.json", LottieAnimationView.CacheStrategy.Weak);
      paramViewGroup.b.setProgress(1.0F);
      paramViewGroup.b.setOnClickListener(paramOnClickListener);
      paramViewGroup.b.setTag(-10, paramObject);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      return paramView;
      paramViewGroup = (aupf.a)paramView.getTag();
    }
  }
  
  public List<atiw> b(Object paramObject)
  {
    paramObject = new ArrayList();
    paramObject.add(d);
    paramObject.add(m);
    paramObject.add(b);
    return paramObject;
  }
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(m);
    localArrayList.add(b);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupl
 * JD-Core Version:    0.7.0.1
 */