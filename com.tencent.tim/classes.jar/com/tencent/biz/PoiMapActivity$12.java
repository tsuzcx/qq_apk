package com.tencent.biz;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PoiMapActivity$12
  implements Runnable
{
  PoiMapActivity$12(PoiMapActivity paramPoiMapActivity, boolean paramBoolean1, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void run()
  {
    label118:
    PoiMapActivity localPoiMapActivity;
    String str;
    ArrayList localArrayList;
    if (this.this$0.aaI) {
      if (this.aaK)
      {
        this.this$0.report("rec_locate", "call_foursquare", "", "", "", "");
        QLog.d("PoiMapActivity", 1, "hasPoiListForFoursquareFinal: true");
        this.this$0.hb.setVisibility(8);
        if (this.this$0.dn != null) {
          this.this$0.dn.setVisibility(8);
        }
        if (!this.val$category.equals(this.this$0.aZ[0]))
        {
          this.this$0.aBQ = 0;
          this.this$0.a[0].lr(true);
        }
        if (TextUtils.isEmpty(this.val$keyword)) {
          break label235;
        }
        if (this.val$keyword.equals(this.this$0.Tl))
        {
          localPoiMapActivity = this.this$0;
          str = this.val$keyword;
          localArrayList = this.jh;
          if (this.aCb <= 0) {
            break label230;
          }
        }
      }
    }
    label230:
    for (boolean bool = true;; bool = false)
    {
      localPoiMapActivity.b(str, localArrayList, bool);
      return;
      this.this$0.hb.setVisibility(8);
      break;
      this.this$0.hb.setVisibility(8);
      if (this.this$0.dn == null) {
        break label118;
      }
      this.this$0.dn.setVisibility(0);
      break label118;
    }
    label235:
    this.this$0.a(this.jh, this.aCc, this.aCd, this.val$category, this.aCb, this.val$page, this.aaL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.12
 * JD-Core Version:    0.7.0.1
 */