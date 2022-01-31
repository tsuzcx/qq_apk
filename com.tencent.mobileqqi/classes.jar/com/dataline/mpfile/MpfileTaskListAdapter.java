package com.dataline.mpfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.data.BaseFileAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import dy;
import java.io.File;
import java.util.List;

public class MpfileTaskListAdapter
  extends BaseFileAdapter
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List jdField_a_of_type_JavaUtilList;
  private View.OnClickListener b;
  
  public MpfileTaskListAdapter(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    super(paramContext, paramOnClickListener1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903522, null);
    }
    MpfileTaskInfo localMpfileTaskInfo = (MpfileTaskInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localMpfileTaskInfo != null)
    {
      paramView = (MpfileTaskListAdapter.ItemHolder)((View)localObject).getTag();
      if (paramView == null)
      {
        localObject = new MpfileTaskListAdapter.ItemHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903522, paramViewGroup, false);
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232745));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(new dy(this));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject);
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232749));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131232738));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232750));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131232739));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232747));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232740));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231505));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232743));
        ((MpfileTaskListAdapter.ItemHolder)localObject).d = ((TextView)paramView.findViewById(2131231881));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
        ((MpfileTaskListAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131231699));
        paramView.setTag(localObject);
        paramViewGroup = (ViewGroup)localObject;
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComDatalineMpfileMpfileTaskInfo = localMpfileTaskInfo;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMpfileTaskInfo.d);
        localObject = FileUtil.a(localMpfileTaskInfo.e);
        if ((localObject != null) && (FileManagerUtil.a((String)localObject) == 0)) {
          if (new File(localMpfileTaskInfo.e).exists())
          {
            paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838612);
            paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localMpfileTaskInfo.e);
            localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131558578), new Object[] { FileUtil.a(localMpfileTaskInfo.jdField_b_of_type_Long) });
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            if ((localMpfileTaskInfo.g == MpfileTaskInfo.jdField_b_of_type_Int) && (localMpfileTaskInfo.jdField_b_of_type_Long != 0L)) {
              break label593;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        }
        for (;;)
        {
          if (a(paramInt, paramView, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, paramViewGroup.jdField_a_of_type_AndroidWidgetButton, localMpfileTaskInfo))
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup.d.setVisibility(4);
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          return paramView;
          if ((MpfileDataCenter.k != null) && (MpfileDataCenter.k.length() > 0))
          {
            localObject = String.format("http://%s:%d/qqmpfile/?action=thumbnail&fileid=%s", new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), localMpfileTaskInfo.jdField_c_of_type_JavaLangString });
            paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838612);
            paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage((String)localObject);
            break;
          }
          FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, localMpfileTaskInfo.e);
          break;
          FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, localMpfileTaskInfo.e);
          break;
          label593:
          float f = (float)localMpfileTaskInfo.jdField_c_of_type_Long / (float)localMpfileTaskInfo.jdField_b_of_type_Long;
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(f * 100.0F));
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskListAdapter
 * JD-Core Version:    0.7.0.1
 */