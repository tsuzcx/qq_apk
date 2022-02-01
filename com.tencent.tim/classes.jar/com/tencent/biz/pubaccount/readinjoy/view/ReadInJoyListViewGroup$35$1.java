package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import lcc;
import ndh;
import nfx;

public class ReadInJoyListViewGroup$35$1
  implements Runnable
{
  public ReadInJoyListViewGroup$35$1(nfx paramnfx, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_Nfx.this$0);
    int i = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Nfx.this$0).getCount();
    if (this.jdField_a_of_type_Nfx.val$position < i)
    {
      Object localObject = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Nfx.this$0).getItem(this.jdField_a_of_type_Nfx.val$position);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Nfx.this$0.getContext().getString(2131695157), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    lcc.a().aCi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.35.1
 * JD-Core Version:    0.7.0.1
 */