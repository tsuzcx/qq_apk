package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import ceb;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import java.util.ArrayList;

public class ChatTextSizeSettingActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 0;
  public static final String a = "setting_text_size";
  public static final int b = 1;
  public static final String b = "chat_text_size_type";
  public static final int c = 2;
  public static final int d = 3;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ceb(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList b = new ArrayList();
  private ViewGroup c;
  private ViewGroup d;
  public int e;
  private ViewGroup e;
  
  public ChatTextSizeSettingActivity()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  public static int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131427359);
    switch (i)
    {
    default: 
      return paramContext.getResources().getDimensionPixelSize(2131427359);
    case 1: 
      return paramContext.getResources().getDimensionPixelSize(2131427360);
    case 2: 
      return paramContext.getResources().getDimensionPixelSize(2131427361);
    }
    return paramContext.getResources().getDimensionPixelSize(2131427362);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ImageView)((ViewGroup)this.jdField_a_of_type_JavaUtilArrayList.get(i)).findViewById(2131231318);
      if (i == paramInt) {
        ((ImageView)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)localObject).setVisibility(4);
      }
    }
    Object localObject = getSharedPreferences("setting_text_size", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("chat_text_size_type", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903124);
    setTitle(getString(2131562124));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231315));
    this.c = ((ViewGroup)findViewById(2131231319));
    this.d = ((ViewGroup)findViewById(2131231320));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231321));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.add(Integer.valueOf(getResources().getDimensionPixelSize(2131427359)));
    this.b.add(Integer.valueOf(getResources().getDimensionPixelSize(2131427360)));
    this.b.add(Integer.valueOf(getResources().getDimensionPixelSize(2131427361)));
    this.b.add(Integer.valueOf(getResources().getDimensionPixelSize(2131427362)));
    this.jdField_e_of_type_Int = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    a(this.jdField_e_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */