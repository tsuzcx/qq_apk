package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import fay;
import faz;
import fba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainer
  extends RelativeLayout
{
  protected static final float a = 600.0F;
  public static final int a = 0;
  protected static final String a = "CardContainer";
  protected static final float b = 640.0F;
  public static final int b = 1;
  protected static final String b = "http://i.gtimg.cn/open/app_icon";
  protected static final float c = 0.9375F;
  public static final int c = -1;
  private static final int g = 10001;
  public Drawable a;
  public Handler a;
  protected LayoutInflater a;
  public View a;
  protected ImageView a;
  protected ListView a;
  protected RelativeLayout a;
  protected TextView a;
  protected URLDrawableDownListener.Adapter a;
  public AnyScaleTypeImageView a;
  protected CardContainer.PermissionAdapter a;
  protected CardLargeView a;
  protected List a;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  public AnyScaleTypeImageView b;
  protected ImageView c;
  protected TextView c;
  protected int d;
  protected ImageView d;
  protected TextView d;
  protected final int e;
  protected TextView e;
  protected final int f;
  protected TextView f;
  protected TextView g;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new fay(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new faz(this);
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramAttributeSet.widthPixels;
    this.jdField_f_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public String a()
  {
    String str = AuthorityActivity.A;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int j = str.length();
    if (j >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(j - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int i = 2;
      j = 0;
      while (j < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(j, i));
        j += 2;
        i += 2;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - j)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
    }
    localStringBuilder.append("/").append(str).append("_").append("android").append("_").append("ad").append("_").append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    ThreadManager.b(new fba(this));
    if (paramInt == this.jdField_d_of_type_Int) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramBoolean) {
        break label93;
      }
      paramString1 = String.format(super.getContext().getString(2131362152), new Object[] { paramString1 });
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    for (;;)
    {
      if (paramBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      return;
      label93:
      this.g.setText(paramString1);
      this.jdField_e_of_type_AndroidWidgetTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    Object localObject;
    boolean bool;
    while (paramGetAuthApiListResponse.hasNext())
    {
      localObject = (SdkAuthorize.AuthItem)paramGetAuthApiListResponse.next();
      if (((SdkAuthorize.AuthItem)localObject).is_new.get() != 0)
      {
        CardContainer.Permission localPermission = new CardContainer.Permission();
        localPermission.jdField_b_of_type_JavaLangString = ((SdkAuthorize.AuthItem)localObject).api_list.get();
        localPermission.jdField_a_of_type_Int = ((SdkAuthorize.AuthItem)localObject).default_flag.get();
        localPermission.jdField_b_of_type_Int = ((SdkAuthorize.AuthItem)localObject).id.get();
        if (((SdkAuthorize.AuthItem)localObject).is_new.get() == 0) {}
        for (bool = false;; bool = true)
        {
          localPermission.jdField_a_of_type_Boolean = bool;
          localPermission.jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthItem)localObject).title.get();
          if (QLog.isColorLevel()) {
            QLog.d("CardContainer", 2, "--> Permission p, api: " + localPermission.jdField_b_of_type_JavaLangString + " | flag: " + localPermission.jdField_a_of_type_Int + " | id: " + localPermission.jdField_b_of_type_Int + " | isNew: " + localPermission.jdField_a_of_type_Boolean + " | title: " + localPermission.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_JavaUtilList.add(localPermission);
          break;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      bool = true;
      if (!bool) {
        break label301;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(1);
      paramGetAuthApiListResponse = (SdkAuthorize.GetAuthApiListResponse)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("CardContainer", 2, "--> has been authority.");
        paramGetAuthApiListResponse = (SdkAuthorize.GetAuthApiListResponse)localObject;
      }
    }
    for (;;)
    {
      setAdImageByURL(paramGetAuthApiListResponse, a());
      return bool;
      bool = false;
      break;
      label301:
      paramGetAuthApiListResponse = this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(0);
      if (QLog.isColorLevel()) {
        QLog.d("CardContainer", 2, "--> has not been authority.");
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter == null)
      {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter = new CardContainer.PermissionAdapter(this);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter);
      }
      else
      {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter.notifyDataSetChanged();
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297474));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297462));
    this.jdField_a_of_type_ComTencentOpenAgentCardLargeView = ((CardLargeView)super.findViewById(2131297463));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131297479));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131297467));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297464);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297477));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297481));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297478));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297482));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297483));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297465));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297469));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297466));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297471));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297472));
    this.g = ((TextView)super.findViewById(2131297473));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131297486));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = super.getResources().getDimension(2131493155);
    f1 = this.jdField_e_of_type_Int - f1 * 2.0F;
    float f2 = f1 / 0.9375F;
    super.setMeasuredDimension((int)f1, (int)f2);
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
      for (paramAnyScaleTypeImageView = new ColorDrawable(0);; paramAnyScaleTypeImageView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, paramAnyScaleTypeImageView, paramAnyScaleTypeImageView);
        paramAnyScaleTypeImageView.setAutoDownload(true);
        if (QLog.isColorLevel()) {
          QLog.d("CardContainer", 2, "-->url drawabel status: " + paramAnyScaleTypeImageView.getStatus());
        }
        if (paramAnyScaleTypeImageView.getStatus() != 1) {
          break;
        }
        localAnyScaleTypeImageView.setVisibility(0);
        localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
        return;
      }
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
        }
        paramAnyScaleTypeImageView = null;
        continue;
        localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */