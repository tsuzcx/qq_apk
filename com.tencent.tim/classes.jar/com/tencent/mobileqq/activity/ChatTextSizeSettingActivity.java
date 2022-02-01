package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import ura;

public class ChatTextSizeSettingActivity
  extends IphoneTitleBarActivity
{
  private static int bFS;
  public int bFT = 0;
  private ViewGroup cN;
  private ViewGroup cO;
  private ViewGroup cP;
  private ViewGroup cQ;
  private ArrayList<ViewGroup> oY = new ArrayList();
  private ArrayList<Integer> oZ = new ArrayList();
  private View.OnClickListener onClickListener = new ura(this);
  
  public static int ag(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131296477);
    switch (i)
    {
    default: 
      return paramContext.getResources().getDimensionPixelSize(2131296477);
    case 1: 
      return paramContext.getResources().getDimensionPixelSize(2131296476);
    case 2: 
      return paramContext.getResources().getDimensionPixelSize(2131296475);
    }
    return paramContext.getResources().getDimensionPixelSize(2131296474);
  }
  
  public static int vp()
  {
    return vq() + 2;
  }
  
  public static int vq()
  {
    if (bFS != 0) {
      return bFS;
    }
    float f;
    switch (BaseApplicationImpl.getContext().getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296477);
    }
    for (;;)
    {
      bFS = (int)(f / BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      return bFS;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296476);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296475);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296474);
    }
  }
  
  public void Ay(int paramInt)
  {
    int i = 0;
    if (i < this.oY.size())
    {
      localObject = (ImageView)((ViewGroup)this.oY.get(i)).findViewById(2131379548);
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
    bFS = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558939);
    setTitle(getString(2131697057));
    this.cN = ((ViewGroup)findViewById(2131379551));
    this.cO = ((ViewGroup)findViewById(2131379550));
    this.cP = ((ViewGroup)findViewById(2131379549));
    this.cQ = ((ViewGroup)findViewById(2131379547));
    this.oY.add(this.cN);
    this.oY.add(this.cO);
    this.oY.add(this.cP);
    this.oY.add(this.cQ);
    this.cN.setOnClickListener(this.onClickListener);
    this.cO.setOnClickListener(this.onClickListener);
    this.cP.setOnClickListener(this.onClickListener);
    this.cQ.setOnClickListener(this.onClickListener);
    this.oZ.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296477)));
    this.oZ.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296476)));
    this.oZ.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296475)));
    this.oZ.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296474)));
    this.bFT = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    Ay(this.bFT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */