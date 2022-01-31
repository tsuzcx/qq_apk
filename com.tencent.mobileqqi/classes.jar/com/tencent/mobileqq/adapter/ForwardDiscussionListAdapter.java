package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.utils.ImageUtil;
import eyb;

public class ForwardDiscussionListAdapter
  extends ResourceCursorAdapter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eyb(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public ForwardDiscussionListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, Cursor paramCursor)
  {
    super(paramContext, paramInt, paramCursor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramInt = (int)(72.0F * this.jdField_a_of_type_Float);
    this.b = paramInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131231395);
    ImageView localImageView = (ImageView)paramView.findViewById(2131230940);
    paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
    String str = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    paramView.setBackgroundResource(2130837850);
    System.currentTimeMillis();
    Object localObject = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(str, true);
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = ImageUtil.c();
    }
    localImageView.setBackgroundDrawable(paramContext);
    System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean) {
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramCursor = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      if (paramCursor != null)
      {
        paramContext = paramCursor;
        if (paramCursor.length() != 0) {}
      }
      else
      {
        paramContext = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562504);
      }
      localTextView.setText(paramContext);
      localObject = (QQServiceEntry.Tag)paramView.getTag();
      paramCursor = (Cursor)localObject;
      if (localObject == null) {
        paramCursor = new QQServiceEntry.Tag();
      }
      paramCursor.a = str;
      paramCursor.b = paramContext;
      localImageView.setTag(paramCursor);
      paramView.setTag(paramCursor);
      return;
      localImageView.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardDiscussionListAdapter
 * JD-Core Version:    0.7.0.1
 */