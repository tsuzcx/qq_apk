package com.tencent.open.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem;
import java.util.List;

public class PermissionView
  extends FrameLayout
  implements View.OnClickListener
{
  static final int a = 17;
  protected float a;
  protected Context a;
  protected LayoutInflater a;
  protected ListView a;
  protected RelativeLayout.LayoutParams a;
  protected RelativeLayout a;
  protected TextView a;
  protected PermissionView.PermissionAdapter a;
  protected boolean a;
  protected PermissionView.Permission[] a;
  protected RelativeLayout b;
  
  public PermissionView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903329, this, true);
    a();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission.length)
    {
      int k = j;
      if (this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission[i].jdField_a_of_type_Int > 0)
      {
        if (j == 0) {
          break label66;
        }
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission[i].jdField_b_of_type_JavaLangString);
      }
      for (k = 0;; k = j)
      {
        i += 1;
        j = k;
        break;
        label66:
        localStringBuilder.append("_").append(this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission[i].jdField_b_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131232106));
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentOpenWidgetPermissionView$PermissionAdapter = new PermissionView.PermissionAdapter(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232109));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232110));
    this.b = ((RelativeLayout)findViewById(2131232107));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentOpenWidgetPermissionView$PermissionAdapter);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams());
  }
  
  public void a(PermissionView.Tag paramTag, int paramInt)
  {
    PermissionView.Permission localPermission = this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission[paramInt];
    paramTag.jdField_a_of_type_AndroidWidgetTextView.setText("● " + localPermission.jdField_a_of_type_JavaLangString);
    paramTag.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission[paramTag.jdField_a_of_type_Int].jdField_a_of_type_Int = 1;
    paramTag.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837788);
  }
  
  public boolean a(List paramList)
  {
    boolean bool2 = true;
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((SdkAuthorize.AuthItem)paramList.get(i)).is_new.get() == 0) {
        paramList.remove(i);
      }
      i -= 1;
    }
    PermissionView.Permission[] arrayOfPermission = new PermissionView.Permission[paramList.size()];
    i = 0;
    boolean bool1;
    if (i < paramList.size())
    {
      arrayOfPermission[i] = new PermissionView.Permission();
      arrayOfPermission[i].jdField_b_of_type_JavaLangString = ((SdkAuthorize.AuthItem)paramList.get(i)).api_list.get();
      arrayOfPermission[i].jdField_a_of_type_Int = ((SdkAuthorize.AuthItem)paramList.get(i)).default_flag.get();
      arrayOfPermission[i].jdField_b_of_type_Int = ((SdkAuthorize.AuthItem)paramList.get(i)).id.get();
      PermissionView.Permission localPermission = arrayOfPermission[i];
      if (((SdkAuthorize.AuthItem)paramList.get(i)).is_new.get() == 0) {}
      for (bool1 = false;; bool1 = true)
      {
        localPermission.jdField_a_of_type_Boolean = bool1;
        arrayOfPermission[i].jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthItem)paramList.get(i)).title.get();
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission = arrayOfPermission;
    if ((this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission != null) && (this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission.length > 0))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission != null)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission.length > 17) {
          break label285;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenWidgetPermissionView$PermissionAdapter.notifyDataSetChanged();
      return bool1;
      bool1 = false;
      break;
      label285:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.b.setOnClickListener(this);
      paramList = getResources().getString(2131563174).replace("N", this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission.length + "");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
    }
  }
  
  public PermissionView.Permission[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetRelativeLayout)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(0, 0, 0, (int)(37.0F * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetListView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_a_of_type_ComTencentOpenWidgetPermissionView$PermissionAdapter.notifyDataSetChanged();
    }
    while (paramView != this.b) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetListView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentOpenWidgetPermissionView$PermissionAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.widget.PermissionView
 * JD-Core Version:    0.7.0.1
 */