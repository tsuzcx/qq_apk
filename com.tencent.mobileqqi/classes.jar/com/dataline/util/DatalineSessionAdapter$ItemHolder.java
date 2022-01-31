package com.dataline.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class DatalineSessionAdapter$ItemHolder
  implements Cloneable
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DatalineSessionAdapter.ItemHolder.FileItemHolder jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$FileItemHolder = new DatalineSessionAdapter.ItemHolder.FileItemHolder(this);
  private DatalineSessionAdapter.ItemHolder.ImageItemHolder jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$ImageItemHolder = new DatalineSessionAdapter.ItemHolder.ImageItemHolder(this);
  private DatalineSessionAdapter.ItemHolder.MutiImageItemHolder jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$MutiImageItemHolder = new DatalineSessionAdapter.ItemHolder.MutiImageItemHolder(this);
  private DatalineSessionAdapter.ItemHolder.TextItemHolder jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$TextItemHolder = new DatalineSessionAdapter.ItemHolder.TextItemHolder(this);
  public BubbleInfo a;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private TextView b;
  
  public DatalineSessionAdapter$ItemHolder(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public ProgressBar a()
  {
    return this.jdField_a_of_type_AndroidWidgetProgressBar;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public DatalineSessionAdapter.ItemHolder.FileItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$FileItemHolder;
  }
  
  public DatalineSessionAdapter.ItemHolder.ImageItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$ImageItemHolder;
  }
  
  public DatalineSessionAdapter.ItemHolder.MutiImageItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$MutiImageItemHolder;
  }
  
  public DatalineSessionAdapter.ItemHolder.TextItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder$TextItemHolder;
  }
  
  public DataLineMsgSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = paramProgressBar;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(DataLineMsgSet paramDataLineMsgSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public void b(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.w("DatalineSessionAdapter", 2, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.ItemHolder
 * JD-Core Version:    0.7.0.1
 */