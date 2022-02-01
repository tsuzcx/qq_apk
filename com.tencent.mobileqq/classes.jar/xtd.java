import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.theme.ThemeUtil;

public class xtd
  extends xsq
{
  public Context a;
  public View a;
  public TextView a;
  protected final xsw a;
  public TextView b;
  public TextView c;
  
  public xtd(View paramView, xsw paramxsw)
  {
    this.jdField_a_of_type_Xsw = paramxsw;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381639));
    this.b = ((TextView)paramView.findViewById(2131380859));
    this.c = ((TextView)paramView.findViewById(2131381034));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370116);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      if (this.b != null) {
        this.b.setTextColor(Color.parseColor("#44608a"));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.c.setTextColor(Color.parseColor("#6991b8"));
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
      }
    }
    this.c.setOnClickListener(new xte(this));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Xsw.a)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713391));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F), 0, 0, 0);
      this.b.setText("");
      if (paramInt != 1) {
        break label174;
      }
      this.c.setVisibility(0);
      a(this.jdField_a_of_type_Xsw.a);
    }
    for (;;)
    {
      paramVideoCollectionItem = this.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1) {
        i = 4;
      }
      paramVideoCollectionItem.setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(zdu.c(paramVideoCollectionItem.collectionTime));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      if (paramVideoCollectionItem.collectionCount <= 0)
      {
        this.b.setText("");
        break;
      }
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698929, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      break;
      label174:
      this.c.setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 17.0F);
    if (paramBoolean)
    {
      this.c.setText(anvx.a(2131713370));
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846905);
      localDrawable.setBounds(0, 0, i, i);
      this.c.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    this.c.setText(anvx.a(2131713381));
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846904);
    localDrawable.setBounds(0, 0, i, i);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */