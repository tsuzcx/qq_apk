package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;

public class AIOPhotoListAdapter
  extends AbstractImageAdapter
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  
  public AIOPhotoListAdapter(Activity paramActivity, int paramInt, AIOImageListModel paramAIOImageListModel, IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = paramAIOImageListModel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
  }
  
  public AIOImageInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AIOImageInfo paramAIOImageInfo, View paramView)
  {
    Object localObject1 = (AIOPhotoListAdapter.Holder)paramView.getTag();
    Object localObject2;
    ImageView localImageView;
    if (paramAIOImageInfo != null)
    {
      localObject2 = paramAIOImageInfo.a;
      paramView = ((AIOPhotoListAdapter.Holder)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
      localImageView = ((AIOPhotoListAdapter.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      localObject1 = ((AIOPhotoListAdapter.Holder)localObject1).b;
      if (((AIOImageData)localObject2).a(1) == null) {
        break label156;
      }
      localObject2 = ((AIOImageData)localObject2).a(1);
      Drawable localDrawable = paramView.getDrawable();
      if (!(localDrawable instanceof URLDrawable)) {
        break label140;
      }
      if (!((String)localObject2).equals(((URLDrawable)localDrawable).getURL().toString())) {
        paramView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, URLDrawableHelper.e, null));
      }
    }
    for (;;)
    {
      switch (paramAIOImageInfo.b())
      {
      default: 
        localImageView.setVisibility(4);
        ((ImageView)localObject1).setVisibility(4);
        return;
        label140:
        paramView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, URLDrawableHelper.e, null));
        continue;
        label156:
        paramView.setImageDrawable(URLDrawableHelper.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject2).a, ((AIOImageData)localObject2).d, 1);
      }
    }
    localImageView.setVisibility(0);
    ((ImageView)localObject1).setVisibility(0);
    return;
    localImageView.setVisibility(4);
    ((ImageView)localObject1).setVisibility(4);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903512, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      paramView = new AIOPhotoListAdapter.Holder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131298328));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298329));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131298330));
      paramViewGroup.setTag(paramView);
    }
    a(a(paramInt), paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */