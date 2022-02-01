package com.tencent.mobileqq.emoticonview;

import afll;
import afon;
import afoo;
import afqr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.widget.ListView;
import java.util.List;

class EmotionPanelViewPagerAdapter$1
  implements Runnable
{
  EmotionPanelViewPagerAdapter$1(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, afll paramafll, afoo paramafoo, ListView paramListView) {}
  
  public void run()
  {
    if (this.cSK == 1)
    {
      if (this.this$0.bZY) {}
      for (localObject = afqr.a(this.this$0.app, this.b.TL, this.this$0.la);; localObject = afqr.a(this.this$0.app, this.this$0.bZr, this.b.TL, this.this$0.businessType))
      {
        EmotionPanelViewPagerAdapter.a(this.this$0, this.jdField_c_of_type_Afoo.d, this.b, (List)localObject);
        this.this$0.a(this.cSK, this.jdField_c_of_type_Afoo, this.b, this.jdField_c_of_type_ComTencentWidgetListView, (List)localObject);
        return;
      }
    }
    Object localObject = afon.a();
    QQAppInterface localQQAppInterface = this.this$0.app;
    int j = this.cSK;
    EmoticonPackage localEmoticonPackage = this.jdField_c_of_type_Afoo.d;
    if (this.this$0.mBaseChatPie != null) {}
    for (int i = this.this$0.mBaseChatPie.a().cZ;; i = -1)
    {
      localObject = ((afon)localObject).a(localQQAppInterface, j, localEmoticonPackage, i, this.this$0.businessType, this.this$0.bZn);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */