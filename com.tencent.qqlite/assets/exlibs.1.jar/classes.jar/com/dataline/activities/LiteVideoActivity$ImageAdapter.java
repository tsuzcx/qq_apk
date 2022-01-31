package com.dataline.activities;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import bq;
import com.dataline.util.file.ImageInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiteVideoActivity$ImageAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public LiteVideoActivity$ImageAdapter(LiteVideoActivity paramLiteVideoActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a();
  }
  
  private void a(List paramList)
  {
    Collections.sort(paramList, LiteVideoActivity.a());
  }
  
  public ImageInfo a(int paramInt)
  {
    return (ImageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public URL a(String paramString)
  {
    try
    {
      paramString = new URL("videothumb", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    List localList = MediaStoreUtil.b(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.getApplicationContext(), "1=1 )GROUP BY (_data", 0);
    if (localList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localList);
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageInfo localImageInfo = a(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903166, null);
      localObject = new bq(this);
      ((bq)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296957));
      ((bq)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296991));
      ((bq)localObject).b = ((ImageView)paramViewGroup.findViewById(2131296992));
      paramViewGroup.setTag(localObject);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.a, this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.b));
      ((bq)localObject).jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      ((bq)localObject).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.getResources().getDrawable(2130839067);
      paramView = URLDrawable.getDrawable(a(localImageInfo.a()), paramView, paramView, false);
      ((bq)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      ((bq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localImageInfo.d());
    }
    while (LiteVideoActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity, localImageInfo))
    {
      ((bq)localObject).b.setVisibility(0);
      return paramViewGroup;
      bq localbq = (bq)paramView.getTag();
      localObject = localbq;
      paramViewGroup = paramView;
      if (LiteVideoActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity))
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.a, this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.b));
        localObject = localbq;
        paramViewGroup = paramView;
      }
    }
    ((bq)localObject).b.setVisibility(4);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteVideoActivity.ImageAdapter
 * JD-Core Version:    0.7.0.1
 */