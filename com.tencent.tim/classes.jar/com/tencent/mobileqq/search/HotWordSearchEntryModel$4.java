package com.tencent.mobileqq.search;

import amju;
import amju.a;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

public class HotWordSearchEntryModel$4
  implements Runnable
{
  public HotWordSearchEntryModel$4(amju paramamju, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo, amju.a parama) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight))) {
      return;
    }
    int i = this.this$0.rootView.getHeight();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.this$0.bC.getLayoutParams();
    localLayoutParams.height = i;
    this.this$0.bC.setLayoutParams(localLayoutParams);
    amju.a(this.this$0.context, this.this$0.bC, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight, this.jdField_a_of_type_Amju$a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */