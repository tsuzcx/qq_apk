import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class esl
  extends TroopFeedViewFactory.ViewProvider
{
  public esl(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130903369, null);
    }
    paramView = (esm)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new esm(this);
      ((esm)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297046));
      ((esm)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296934));
      ((esm)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297846));
      ((esm)localObject).b = ((TextView)localView.findViewById(2131297845));
      ((esm)localObject).c = ((TextView)localView.findViewById(2131297848));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((esm)localObject).jdField_a_of_type_Int = paramInt;
    ((esm)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((esm)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((esm)localObject).b.setText(paramTroopFeedItem.content);
    ((esm)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.b(paramTroopFeedItem.ex_1))
    {
      ((esm)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((esm)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838402);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      if (this.a.b)
      {
        localView.setOnLongClickListener(this.a.jdField_a_of_type_Esi);
        localView.setOnTouchListener(this.a.jdField_a_of_type_Esi);
      }
      return localView;
      ((esm)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esl
 * JD-Core Version:    0.7.0.1
 */