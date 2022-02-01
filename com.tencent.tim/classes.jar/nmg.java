import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastVideoViewCreator.VideoViewHolder.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class nmg
  implements kxm.a
{
  nmg(nmf.a parama, VideoData paramVideoData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.vid, paramString1)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.coverUrl = paramString2;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.width = paramInt1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.height = paramInt2;
      }
      ThreadManager.getUIHandler().post(new WebFastVideoViewCreator.VideoViewHolder.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmg
 * JD-Core Version:    0.7.0.1
 */