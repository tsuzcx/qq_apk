import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;

public class wfr
  extends wfe
{
  public Context a;
  public View a;
  public TextView a;
  protected final wfk a;
  public TextView b;
  public TextView c;
  
  public wfr(View paramView, wfk paramwfk)
  {
    this.jdField_a_of_type_Wfk = paramwfk;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380365));
    this.b = ((TextView)paramView.findViewById(2131379659));
    this.c = ((TextView)paramView.findViewById(2131379821));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369458);
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
    this.c.setOnClickListener(new wfs(this));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Wfk.a)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714333));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F), 0, 0, 0);
      this.b.setText("");
      if (paramInt != 1) {
        break label174;
      }
      this.c.setVisibility(0);
      a(this.jdField_a_of_type_Wfk.a);
    }
    for (;;)
    {
      paramVideoCollectionItem = this.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1) {
        i = 4;
      }
      paramVideoCollectionItem.setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(xqz.c(paramVideoCollectionItem.collectionTime));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      if (paramVideoCollectionItem.collectionCount <= 0)
      {
        this.b.setText("");
        break;
      }
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699917, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      break;
      label174:
      this.c.setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = xsm.a(this.jdField_a_of_type_AndroidContentContext, 17.0F);
    if (paramBoolean)
    {
      this.c.setText(alud.a(2131714312));
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846446);
      localDrawable.setBounds(0, 0, i, i);
      this.c.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    this.c.setText(alud.a(2131714323));
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846445);
    localDrawable.setBounds(0, 0, i, i);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfr
 * JD-Core Version:    0.7.0.1
 */