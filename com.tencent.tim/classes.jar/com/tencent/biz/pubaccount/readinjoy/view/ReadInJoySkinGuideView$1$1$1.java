package com.tencent.biz.pubaccount.readinjoy.view;

import anxx;
import anyz;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import kbp;
import kxm;
import kxm.b;
import nhd;
import org.json.JSONException;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(nhd paramnhd, anxx paramanxx) {}
  
  public void run()
  {
    this.jdField_a_of_type_Nhd.a.this$0.a.b((anyz)this.jdField_a_of_type_Anxx);
    this.jdField_a_of_type_Nhd.a.this$0.a.dTW();
    kxm.b localb = new kxm.b();
    try
    {
      localb.f();
      localb.a("guide_id", this.jdField_a_of_type_Nhd.a.all);
      localb.a("channel_id", this.jdField_a_of_type_Nhd.a.aMH);
      kbp.a(this.jdField_a_of_type_Nhd.a.val$app, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Nhd.a.all, "" + kxm.nR(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Nhd.a.this$0), localb.build(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */