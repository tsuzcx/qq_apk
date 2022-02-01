import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class mtk
  implements VideoFeedsRecyclerView.a
{
  mtk(mtg parammtg) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    mtg.e(this.this$0, paramBoolean);
    if ((paramViewHolder instanceof mtg.g)) {
      ((mtg.g)paramViewHolder).jdField_a_of_type_Mrx.nY(mtg.a(this.this$0));
    }
  }
  
  public void aSa() {}
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    mtg.a(this.this$0).removeMessages(7);
    mtg.g localg = mtg.a(this.this$0);
    Object localObject;
    if ((paramViewHolder instanceof mtg.e))
    {
      localObject = (mtg.e)paramViewHolder;
      if ((localg != null) && (localg.jdField_a_of_type_Mrx != null)) {
        localg.jdField_a_of_type_Mrx.onVisibilityChanged(false);
      }
      if ((((mtg.e)localObject).aUv >= this.this$0.getItemCount() - 5) && (mtg.a(this.this$0) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((mtg.e)localObject).aUv + ", getCount() = " + this.this$0.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        mtg.a(this.this$0).aSb();
      }
    }
    if (((localg instanceof mtg.k)) && (mtg.a(this.this$0) != null)) {
      mtg.a(this.this$0).b((mtg.k)localg);
    }
    if (((paramViewHolder instanceof mtg.i)) && (((mtg.i)paramViewHolder).itemType == 6))
    {
      mtg.a(this.this$0);
      mtg.a(this.this$0, null);
    }
    boolean bool;
    ReportInfo.b localb;
    if ((paramViewHolder instanceof mtg.g))
    {
      localObject = (mtg.l)paramViewHolder;
      mtg.a(this.this$0, (mtg.g)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.toLogString());
      }
      if ((mtg.a(this.this$0) != null) && (mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)) {
        mtg.a(this.this$0).G(mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d);
      }
      if (mtg.c(this.this$0)) {
        break label767;
      }
      mtg.a(this.this$0).jdField_a_of_type_Mrx.Z(false, mtg.d(this.this$0));
      mtg.c(this.this$0, true);
      bool = false;
      if ((mtg.a(this.this$0) != null) && (mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (!mtg.e(this.this$0)))
      {
        localb = new ReportInfo.b();
        if (mtg.a(this.this$0) == null) {
          break label800;
        }
        localb.aSA = mtg.a(this.this$0).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label800:
    for (int i = mtg.a(this.this$0).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      kct.b(mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, i, 7, -1, localb, mtg.a(this.this$0).Wz);
      if (mtg.f(this.this$0))
      {
        TraceCompat.beginSection("playVideo");
        this.this$0.e((mtg.l)localObject);
        TraceCompat.endSection();
        mtg.d(this.this$0, false);
      }
      for (;;)
      {
        if (mtg.a(this.this$0) != null) {
          mtg.a(this.this$0).v(mtg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d);
        }
        mtg.a(this.this$0, mtg.a(this.this$0), localg, bool);
        mtg.a(this.this$0, System.currentTimeMillis());
        if ((mtg.a(this.this$0) != null) && (!AppSetting.enableTalkBack))
        {
          mtg.a(this.this$0).removeMessages(0);
          mtg.a(this.this$0).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.b(paramViewHolder);
        if (mtg.a(this.this$0) != null) {
          mtg.a(this.this$0).a(mtg.a(this.this$0));
        }
        if (mtg.a(this.this$0) != null)
        {
          mtg.a(this.this$0, mtg.a(this.this$0).a, false);
          mtg.a(this.this$0, mtg.a(this.this$0).b, false);
        }
        if ((paramViewHolder instanceof mtg.l))
        {
          mtg.a(this.this$0, ((mtg.l)paramViewHolder).a, true);
          mtg.a(this.this$0, ((mtg.l)paramViewHolder).b, true);
          mtg.a(this.this$0, (mtg.l)paramViewHolder);
        }
        return;
        label767:
        mtg.a(this.this$0).jdField_a_of_type_Mrx.onVisibilityChanged(true);
        bool = true;
        break;
        mtg.d(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtk
 * JD-Core Version:    0.7.0.1
 */