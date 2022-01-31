import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class eqt
  extends TroopFeedViewFactory.ViewProvider
{
  public eqt(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130903366, null);
    }
    paramView = (equ)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new equ(this);
      ((equ)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297046));
      ((equ)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296932));
      ((equ)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297842));
      ((equ)localObject).b = ((TextView)localView.findViewById(2131297841));
      ((equ)localObject).c = ((TextView)localView.findViewById(2131297844));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((equ)localObject).jdField_a_of_type_Int = paramInt;
    ((equ)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((equ)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((equ)localObject).b.setText(paramTroopFeedItem.content);
    ((equ)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.b(paramTroopFeedItem.ex_1))
    {
      ((equ)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((equ)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838383);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      if (this.a.b)
      {
        localView.setOnLongClickListener(this.a.jdField_a_of_type_Eqq);
        localView.setOnTouchListener(this.a.jdField_a_of_type_Eqq);
      }
      return localView;
      ((equ)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqt
 * JD-Core Version:    0.7.0.1
 */