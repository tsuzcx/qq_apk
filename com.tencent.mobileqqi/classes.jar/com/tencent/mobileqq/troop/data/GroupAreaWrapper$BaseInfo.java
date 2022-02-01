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
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903384, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.ActivityAndTopicViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131232388));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131232390));
    paramViewGroup.c = ((TextView)paramContext.findViewById(2131232394));
    paramViewGroup.d = ((TextView)paramContext.findViewById(2131232395));
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131232396));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131232392));
    paramContext.setTag(paramViewGroup);
    a(paramContext);
    return paramContext;
  }
  
  protected abstract void a(View paramView);
  
  protected abstract void a(TextView paramTextView);
  
  public void b(View paramView)
  {
    NearbyTroops.ActivityAndTopicViewHolder localActivityAndTopicViewHolder = (NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag();
    localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    localActivityAndTopicViewHolder.b.setText(this.b);
    localActivityAndTopicViewHolder.c.setText(this.c);
    Object localObject = new DecimalFormat("#.#");
    if (this.jdField_a_of_type_Int >= 100) {
      localObject = ((DecimalFormat)localObject).format(Math.ceil(this.jdField_a_of_type_Int / 50) * 0.05D) + "km";
    }
    for (;;)
    {
      localActivityAndTopicViewHolder.d.setText(this.d + " " + (String)localObject);
      localActivityAndTopicViewHolder.d.setCompoundDrawablePadding(8);
      localActivityAndTopicViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130838383, 0, 0, 0);
      a(localActivityAndTopicViewHolder.e);
      localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      try
      {
        localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.e));
        localObject = (RelativeLayout)paramView.findViewById(2131232387);
        if (localObject != null) {
          ((RelativeLayout)localObject).setOnClickListener(this);
        }
        paramView = (RelativeLayout)paramView.findViewById(2131232391);
        if (paramView != null) {
          paramView.setOnClickListener(this);
        }
        return;
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
    if (i == 2131232387)
    {
      localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.f);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    while (i != 2131232391) {
      return;
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.g);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramView.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.BaseInfo
 * JD-Core Version:    0.7.0.1
 */