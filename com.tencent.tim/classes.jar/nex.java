import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nex
  implements ViewBase.OnClickListener
{
  nex(new paramnew) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      FastWebArticleInfo localFastWebArticleInfo;
      try
      {
        String str = paramViewBase.getEventAttachedData();
        int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
        paramViewBase = this.a.b.articleInfo;
        localFastWebArticleInfo = this.a.b.d;
        switch (i)
        {
        case 1004: 
          if (TextUtils.isEmpty(str)) {
            return;
          }
          kxm.C(this.a.c, str);
          return;
        }
      }
      catch (Exception paramViewBase)
      {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "findClickableViewListener error!  msg=" + paramViewBase);
        return;
      }
      ReadInJoyFastWebBottomSocialViewNew.a(this.a.this$0, this.a.c, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.b(this.a.this$0, this.a.c, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.c(this.a.this$0, this.a.c, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.d(this.a.this$0, this.a.c, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.e(this.a.this$0, this.a.c, paramViewBase, localFastWebArticleInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nex
 * JD-Core Version:    0.7.0.1
 */