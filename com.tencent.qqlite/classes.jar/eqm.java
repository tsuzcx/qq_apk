import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class eqm
  extends TroopFeedViewFactory.ViewProvider
{
  public eqm(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView2 = paramView;
    if (paramView == null) {
      localView2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext).inflate(2130903367, null);
    }
    eqn localeqn = (eqn)localView2.getTag();
    if (localeqn == null)
    {
      localeqn = new eqn(this);
      localeqn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView2.findViewById(2131297050));
      localeqn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131296936));
      localeqn.b = ((TextView)localView2.findViewById(2131296566));
      localeqn.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView2.findViewById(2131297852));
      localView2.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory);
      localView2.setTag(localeqn);
    }
    for (;;)
    {
      localeqn.jdField_a_of_type_Int = paramInt;
      localeqn.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localeqn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localeqn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localeqn.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localeqn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localeqn.b.setVisibility(0);
      localeqn.b.setSingleLine(false);
      localeqn.b.setMaxLines(2);
      localeqn.b.setText("");
      localeqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localeqn.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838390);
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (StringUtil.b(paramTroopFeedItem.picPath)) {
          break label1155;
        }
      }
      for (;;)
      {
        try
        {
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if (((paramTroopFeedItem.type != 5) || (paramTroopFeedItem.type != 19) || (paramTroopFeedItem.type != 99)) && (!StringUtil.b(paramTroopFeedItem.publishUin)) && (!StringUtil.b(paramTroopFeedItem.feedTime)))
          {
            paramView = str + " " + paramTroopFeedItem.publishUin;
            ((TextView)localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296532)).setText(paramTroopFeedItem.publishUin);
            try
            {
              str = " 发表于 " + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
              ((TextView)localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297853)).setText(str);
              str = paramView + str;
              paramView = str;
              paramInt = 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              paramInt = 0;
              continue;
              if ((paramTroopFeedItem.type != 5) && (paramTroopFeedItem.type != 19)) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localeqn.b.setText(paramTroopFeedItem.content);
              localeqn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localeqn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              if ((paramTroopFeedItem.type != 133) && (paramTroopFeedItem.type != 18) && (paramTroopFeedItem.type != 0)) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              if (paramInt == 0) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqn.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.type != 12) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838395);
              if (paramInt == 0) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqn.b.setVisibility(8);
              continue;
              if ((paramTroopFeedItem.type != 10) && (paramTroopFeedItem.type != 132)) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838394);
              if (paramInt == 0) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqn.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.orginType != 99) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localeqn.b.setText(paramTroopFeedItem.content);
              localeqn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localeqn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              continue;
            }
            if (paramTroopFeedItem.type == 131)
            {
              localeqn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
              if (paramInt == 0) {
                continue;
              }
              localeqn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqn.b.setVisibility(8);
              paramTroopFeedItem = paramView;
              if (!paramBoolean) {
                paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
              }
              localView2.setContentDescription(paramTroopFeedItem);
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_Boolean)
              {
                localView2.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Eql);
                localView2.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Eql);
              }
              return localView2;
              if (paramTroopFeedItem.type == 132)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c == null) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838392);
                }
                paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c;
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838390);
              }
              paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          paramInt = 0;
          paramView = localNumberFormatException;
          continue;
        }
        label1155:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqm
 * JD-Core Version:    0.7.0.1
 */