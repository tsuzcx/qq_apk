package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.DecimalFormat;

public abstract class GroupAreaWrapper$BaseInfo
  implements View.OnClickListener
{
  public int a;
  public QQAppInterface a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public GroupAreaWrapper$BaseInfo()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903317, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.ActivityAndTopicViewHolder();
    paramViewGroup.a = ((TextView)paramContext.findViewById(2131297675));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297677));
    paramViewGroup.c = ((TextView)paramContext.findViewById(2131297681));
    paramViewGroup.d = ((TextView)paramContext.findViewById(2131297682));
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131297683));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131297679));
    paramContext.setTag(paramViewGroup);
    a(paramContext);
    return paramContext;
  }
  
  protected abstract void a(View paramView);
  
  protected abstract void a(TextView paramTextView);
  
  public void b(View paramView)
  {
    NearbyTroops.ActivityAndTopicViewHolder localActivityAndTopicViewHolder = (NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag();
    localActivityAndTopicViewHolder.a.setText(this.jdField_a_of_type_JavaLangString);
    localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.b);
    localActivityAndTopicViewHolder.c.setText(this.c);
    DecimalFormat localDecimalFormat = new DecimalFormat("#.#");
    Object localObject = "";
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 0))
    {
      if (this.jdField_a_of_type_Int < 100) {
        break label242;
      }
      localObject = localDecimalFormat.format(Math.ceil(this.jdField_a_of_type_Int / 50) * 0.05D) + "km";
    }
    for (;;)
    {
      localActivityAndTopicViewHolder.d.setText(this.d + " " + (String)localObject);
      localActivityAndTopicViewHolder.d.setCompoundDrawablePadding(8);
      localActivityAndTopicViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130838263, 0, 0, 0);
      a(localActivityAndTopicViewHolder.e);
      localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      try
      {
        localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.e));
        localObject = (RelativeLayout)paramView.findViewById(2131297674);
        if (localObject != null) {
          ((RelativeLayout)localObject).setOnClickListener(this);
        }
        paramView = (RelativeLayout)paramView.findViewById(2131297678);
        if (paramView != null) {
          paramView.setOnClickListener(this);
        }
        return;
        label242:
        localObject = "0.1km";
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297674)
    {
      localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.f);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    while (i != 2131297678) {
      return;
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.g);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramView.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.BaseInfo
 * JD-Core Version:    0.7.0.1
 */