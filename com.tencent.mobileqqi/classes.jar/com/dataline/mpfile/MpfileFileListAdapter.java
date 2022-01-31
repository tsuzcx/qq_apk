package com.dataline.mpfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.List;

public class MpfileFileListAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public MpfileFileListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
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
  
  public int getItemViewType(int paramInt)
  {
    if (((MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).g == MpfileItemInfo.e) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903518, null);
      }
      paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((TextView)paramViewGroup.findViewById(2131231294)).setText(paramView.jdField_a_of_type_JavaLangString);
      ((ImageView)paramViewGroup.findViewById(2131231293)).setImageResource(2130838596);
      return paramViewGroup;
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903520, null);
    }
    paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((TextView)paramViewGroup.findViewById(2131231294)).setText(paramView.jdField_a_of_type_JavaLangString);
    AsyncImageView localAsyncImageView = (AsyncImageView)paramViewGroup.findViewById(2131231293);
    String str1 = String.format("%s/%s", new Object[] { MpfileDataCenter.a(), paramView.jdField_a_of_type_JavaLangString });
    String str2 = FileUtil.a(str1);
    if ((str2 != null) && (FileManagerUtil.a(str2) == 0) && (MpfileDataCenter.k != null) && (MpfileDataCenter.k.length() > 0))
    {
      str1 = String.format("http://%s:%d/qqmpfile/?action=thumbnail&fileid=%s", new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), paramView.b });
      localAsyncImageView.setDefaultImage(2130838612);
      localAsyncImageView.setAsyncImage(str1);
    }
    for (;;)
    {
      ((TextView)paramViewGroup.findViewById(2131232795)).setText(FileUtil.a(paramView.jdField_a_of_type_Long));
      ((TextView)paramViewGroup.findViewById(2131232799)).setText(paramView.c);
      return paramViewGroup;
      FileManagerUtil.a(localAsyncImageView, str1);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.MpfileFileListAdapter
 * JD-Core Version:    0.7.0.1
 */