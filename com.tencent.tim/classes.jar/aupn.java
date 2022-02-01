import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aupn
  extends aupf
{
  public aupn(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter);
  }
  
  public View b(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131563221, paramViewGroup, false);
      paramViewGroup = new aupn.a();
      paramViewGroup.eU = ((ViewGroup)paramView.findViewById(2131379979));
      paramViewGroup.textView = ((TextView)paramView.findViewById(2131380986));
      paramViewGroup.imageView = ((ImageView)paramView.findViewById(2131369072));
      paramView.setTag(-100, paramViewGroup);
      QLog.d("SwitchTodoItemBuilder", 4, new Object[] { Integer.valueOf(this.adapter.getItemViewType(paramInt)) });
      paramOnLongClickListener = (auoi)this.app.getManager(376);
      if (!((aupp)paramObject).aJx()) {
        break label224;
      }
      paramViewGroup.textView.setText(this.context.getResources().getString(2131721214, new Object[] { Integer.valueOf(paramOnLongClickListener.OL()) }));
      paramViewGroup.imageView.setRotation(180.0F);
    }
    for (;;)
    {
      paramViewGroup.eU.setOnClickListener(paramOnClickListener);
      return paramView;
      QLog.d("SwitchTodoItemBuilder", 4, new Object[] { Integer.valueOf(this.adapter.getItemViewType(paramInt)) });
      paramViewGroup = (aupn.a)paramView.getTag(-100);
      break;
      label224:
      paramViewGroup.textView.setText(this.context.getResources().getString(2131721215, new Object[] { Integer.valueOf(paramOnLongClickListener.OL()) }));
      paramViewGroup.imageView.setRotation(0.0F);
    }
  }
  
  public List<atiw> b(Object paramObject)
  {
    return new ArrayList();
  }
  
  public List<atiw> gt()
  {
    return new ArrayList();
  }
  
  class a
  {
    ViewGroup eU;
    ImageView imageView;
    TextView textView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupn
 * JD-Core Version:    0.7.0.1
 */