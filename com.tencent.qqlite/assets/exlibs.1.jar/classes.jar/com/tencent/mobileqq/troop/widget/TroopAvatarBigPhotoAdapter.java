package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import esg;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopAvatarBigPhotoAdapter
  extends BaseAdapter
{
  public static final String a = "TroopAvatarBigPhotoAdapter";
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List a;
  protected Map a;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  public TroopAvatarBigPhotoAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131492904));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((localObject != null) && ((localObject instanceof Bitmap)) && (!((Bitmap)localObject).isRecycled())) {
          ((Bitmap)localObject).recycle();
        }
      }
    }
  }
  
  public void a(int paramInt, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    label55:
    label335:
    label376:
    for (;;)
    {
      return;
      URLImageView localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      if ((getItem(paramInt) instanceof String)) {}
      for (String str = (String)getItem(paramInt);; str = null)
      {
        if (TextUtils.isEmpty(str)) {
          break label376;
        }
        Object localObject1;
        Object localObject2;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = str;
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + (String)localObject1);
          }
          localObject2 = Uri.parse((String)localObject1).getScheme();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https")))) {
            break label303;
          }
        }
        for (;;)
        {
          try
          {
            localObject1 = new File((String)localObject1).toURL();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            Setting localSetting = (Setting)((EntityManager)localObject2).a(Setting.class, "troop_" + this.b);
            ((EntityManager)localObject2).a();
            if (((localSetting != null) && (localSetting.bHeadType != 0)) || (str == null) || (!str.equals("-5"))) {
              break label335;
            }
            localURLImageView.setImageResource(2130838309);
            return;
          }
          catch (MalformedURLException paramViewHolder) {}
          if (AvatarTroopUtil.b(str))
          {
            if ((str != null) && (str.equals("-5")))
            {
              localObject1 = AvatarTroopUtil.a(str, this.b, 0);
              localObject1 = AvatarTroopUtil.b((String)localObject1);
              break label55;
            }
            localObject1 = AvatarTroopUtil.a(str, this.b, 1);
            continue;
          }
          localObject1 = str;
          break label55;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
          return;
          try
          {
            localObject1 = new URL((String)localObject1);
          }
          catch (MalformedURLException paramViewHolder) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        return;
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, URLDrawableHelper.d, null, true));
        a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        localURLImageView.setURLDrawableDownListener(new esg(this, paramViewHolder));
        return;
      }
    }
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903212, null);
    }
    if (localView.getTag() == null)
    {
      paramView = new TroopAvatarBigPhotoAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131296283));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131296282));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramInt, paramView);
      return localView;
      paramView = (TroopAvatarBigPhotoAdapter.ViewHolder)localView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter
 * JD-Core Version:    0.7.0.1
 */