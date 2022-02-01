import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class krg
  implements ViewBase.OnClickListener
{
  krg(kqz paramkqz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (kmt.a(this.a.jdField_b_of_type_Ktm))
    {
      int j = 5;
      int i = j;
      if (this.a.jdField_b_of_type_Ktm.a.advertisementInfo != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_Ktm.a.advertisementInfo.mAdVideoUrl))
        {
          i = j;
          if (!TextUtils.isEmpty(this.a.jdField_b_of_type_Ktm.a.advertisementInfo.mAdViewId)) {
            i = 6;
          }
        }
      }
      kmt.a(this.a.jdField_b_of_type_Kte.getVafContext().getContext(), this.a.c, this.a.jdField_b_of_type_Ktm, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krg
 * JD-Core Version:    0.7.0.1
 */