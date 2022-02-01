package com.tencent.qidian;

import acfp;
import albb;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asib;
import asic;
import com.tencent.image.URLImageView;
import com.tencent.qidian.data.QidianExternalInfo;
import java.util.Iterator;
import java.util.List;

class QidianProfileCardActivity$8
  implements Runnable
{
  QidianProfileCardActivity$8(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131561086, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131365322);
    Object localObject1;
    int j;
    Object localObject2;
    if ((this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems() != null) && (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().size() > 0))
    {
      localObject1 = this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (asib)((Iterator)localObject1).next();
        if (j < 4) {
          break label401;
        }
      }
    }
    for (int i = j;; i = 0)
    {
      if ((this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos() != null) && (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
      {
        localObject1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131561085, null);
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131379769);
        localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131365322);
        localObject3 = new PhotoWallViewForQiDianProfile(this.this$0.getApplicationContext());
        ((PhotoWallViewForQiDianProfile)localObject3).setPhotoWallCallback(this.this$0.jdField_b_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$b);
        localObject4 = this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
        ((PhotoWallViewForQiDianProfile)localObject3).g(this.this$0.getApplicationContext(), (List)localObject4);
        ((PhotoWallViewForQiDianProfile)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ((LinearLayout)localObject2).addView((View)localObject3);
        this.this$0.lL.addView((View)localObject1);
      }
      j = i;
      if (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null)
      {
        j = i;
        if (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems() != null)
        {
          j = i;
          if (this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().size() > 0)
          {
            localObject1 = this.this$0.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().iterator();
            j = i;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (asic)((Iterator)localObject1).next();
              if (i < 4) {
                break label574;
              }
              j = i;
            }
          }
        }
      }
      if (j > 0) {
        this.this$0.lL.addView(localLinearLayout1);
      }
      return;
      label401:
      Object localObject3 = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131561087, null);
      Object localObject4 = (URLImageView)((RelativeLayout)localObject3).findViewById(2131368698);
      TextView localTextView1 = (TextView)((RelativeLayout)localObject3).findViewById(2131372190);
      ImageView localImageView = (ImageView)((RelativeLayout)localObject3).findViewById(2131364412);
      TextView localTextView2 = (TextView)((RelativeLayout)localObject3).findViewById(2131365721);
      ((URLImageView)localObject4).post(new QidianProfileCardActivity.8.1(this, (asib)localObject2, (URLImageView)localObject4));
      localTextView1.setText(String.valueOf(((asib)localObject2).name));
      ((RelativeLayout)localObject3).setOnClickListener(QidianProfileCardActivity.a(this.this$0));
      localTextView2.setText(acfp.m(2131711157));
      ((RelativeLayout)localObject3).setTag(new albb(51, String.valueOf(((asib)localObject2).mN)));
      localImageView.setVisibility(8);
      localLinearLayout2.addView((View)localObject3, new LinearLayout.LayoutParams(0, -2, 1.0F));
      j += 1;
      break;
      label574:
      localObject3 = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131561087, null);
      localObject4 = (URLImageView)((RelativeLayout)localObject3).findViewById(2131368698);
      localTextView1 = (TextView)((RelativeLayout)localObject3).findViewById(2131372190);
      localImageView = (ImageView)((RelativeLayout)localObject3).findViewById(2131364412);
      localTextView2 = (TextView)((RelativeLayout)localObject3).findViewById(2131365721);
      ((URLImageView)localObject4).post(new QidianProfileCardActivity.8.2(this, (asic)localObject2, (URLImageView)localObject4));
      localTextView1.setText(((asic)localObject2).name);
      ((RelativeLayout)localObject3).setOnClickListener(QidianProfileCardActivity.a(this.this$0));
      if (((asic)localObject2).type == 0)
      {
        localTextView2.setText(2131700363);
        ((RelativeLayout)localObject3).setTag(new albb(49, ((asic)localObject2).uin));
        label714:
        if ((((asic)localObject2).type != 0) || (((asic)localObject2).verity != 1)) {
          break label804;
        }
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130843486);
      }
      for (;;)
      {
        localLinearLayout2.addView((View)localObject3, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        if (((asic)localObject2).type != 1) {
          break label714;
        }
        localTextView2.setText(2131700364);
        ((RelativeLayout)localObject3).setTag(new albb(50, localObject2));
        break label714;
        label804:
        if ((((asic)localObject2).type == 1) && (((asic)localObject2).verity == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130845302);
        }
        else
        {
          localImageView.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */