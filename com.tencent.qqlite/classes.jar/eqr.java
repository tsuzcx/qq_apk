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

public class eqr
  extends TroopFeedViewFactory.ViewProvider
{
  public eqr(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView2 = paramView;
    if (paramView == null) {
      localView2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext).inflate(2130903365, null);
    }
    eqs localeqs = (eqs)localView2.getTag();
    if (localeqs == null)
    {
      localeqs = new eqs(this);
      localeqs.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView2.findViewById(2131297046));
      localeqs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131296932));
      localeqs.b = ((TextView)localView2.findViewById(2131296566));
      localeqs.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView2.findViewById(2131297836));
      localView2.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory);
      localView2.setTag(localeqs);
    }
    for (;;)
    {
      localeqs.jdField_a_of_type_Int = paramInt;
      localeqs.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localeqs.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localeqs.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localeqs.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localeqs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localeqs.b.setVisibility(0);
      localeqs.b.setSingleLine(false);
      localeqs.b.setMaxLines(2);
      localeqs.b.setText("");
      localeqs.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localeqs.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838378);
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
            ((TextView)localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296532)).setText(paramTroopFeedItem.publishUin);
            try
            {
              str = " 发表于 " + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
              ((TextView)localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297837)).setText(str);
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
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localeqs.b.setText(paramTroopFeedItem.content);
              localeqs.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localeqs.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              if ((paramTroopFeedItem.type != 133) && (paramTroopFeedItem.type != 18) && (paramTroopFeedItem.type != 0)) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              if (paramInt == 0) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqs.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.type != 12) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838383);
              if (paramInt == 0) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqs.b.setVisibility(8);
              continue;
              if ((paramTroopFeedItem.type != 10) && (paramTroopFeedItem.type != 132)) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838382);
              if (paramInt == 0) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqs.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.orginType != 99) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localeqs.b.setText(paramTroopFeedItem.content);
              localeqs.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localeqs.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              continue;
            }
            if (paramTroopFeedItem.type == 131)
            {
              localeqs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
              if (paramInt == 0) {
                continue;
              }
              localeqs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localeqs.b.setVisibility(8);
              paramTroopFeedItem = paramView;
              if (!paramBoolean) {
                paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
              }
              localView2.setContentDescription(paramTroopFeedItem);
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_Boolean)
              {
                localView2.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Eqq);
                localView2.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Eqq);
              }
              return localView2;
              if (paramTroopFeedItem.type == 132)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c == null) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838380);
                }
                paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c;
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838378);
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
 * Qualified Name:     eqr
 * JD-Core Version:    0.7.0.1
 */