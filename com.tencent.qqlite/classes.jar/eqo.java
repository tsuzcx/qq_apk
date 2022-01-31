import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class eqo
  extends TroopFeedViewFactory.ViewProvider
{
  public eqo(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130903368, null);
    }
    paramView = (eqp)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new eqp(this);
      ((eqp)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297050));
      ((eqp)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296936));
      ((eqp)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297858));
      ((eqp)localObject).b = ((TextView)localView.findViewById(2131297857));
      ((eqp)localObject).c = ((TextView)localView.findViewById(2131297860));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((eqp)localObject).jdField_a_of_type_Int = paramInt;
    ((eqp)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((eqp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((eqp)localObject).b.setText(paramTroopFeedItem.content);
    ((eqp)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.b(paramTroopFeedItem.ex_1))
    {
      ((eqp)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((eqp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838395);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      if (this.a.b)
      {
        localView.setOnLongClickListener(this.a.jdField_a_of_type_Eql);
        localView.setOnTouchListener(this.a.jdField_a_of_type_Eql);
      }
      return localView;
      ((eqp)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqo
 * JD-Core Version:    0.7.0.1
 */