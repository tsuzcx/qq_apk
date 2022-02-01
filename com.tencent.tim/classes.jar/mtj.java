import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class mtj
  extends Handler
{
  mtj(mtg parammtg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 5: 
    default: 
      super.handleMessage(paramMessage);
    }
    Object localObject1;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        mtg.a(this.this$0).sendEmptyMessageDelayed(0, 3000L);
                      } while (mtg.a(this.this$0) == null);
                      long l1 = mtg.a(this.this$0).jdField_a_of_type_Mxy.cY();
                      long l2 = mtg.a(this.this$0).cX();
                      if (l2 > l1) {
                        l1 = l2;
                      }
                      for (;;)
                      {
                        l1 = 3000L - (System.currentTimeMillis() - l1);
                        if (l1 <= 0L) {
                          break;
                        }
                        mtg.a(this.this$0).removeMessages(0);
                        mtg.a(this.this$0).sendEmptyMessageDelayed(0, l1);
                        return;
                      }
                    } while ((mtg.a(this.this$0) == null) || (mtg.a(this.this$0) == null) || (mtg.a(this.this$0).jdField_a_of_type_Mrx == null));
                    if (mtg.a(this.this$0).isPlaying())
                    {
                      mtg.a(this.this$0).jdField_a_of_type_Mrx.nZ(false);
                      return;
                    }
                    mtg.a(this.this$0).jdField_a_of_type_Mrx.aRI();
                    return;
                    if (mtg.a(this.this$0))
                    {
                      mtg.a(this.this$0).sendEmptyMessage(3);
                      mtg.a(this.this$0).sendEmptyMessageDelayed(2, 50L);
                    }
                    mtg.a(this.this$0).EK();
                    return;
                    mtg.a(this.this$0).aTn();
                    return;
                    mtg.a(this.this$0, false);
                  } while (!(mtg.a(this.this$0) instanceof mtg.l));
                  paramMessage = (mtg.l)mtg.a(this.this$0);
                } while ((paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) || (paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d == null) || (!paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.isAD) || (paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b == null));
                localObject1 = paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.We;
              } while (mtg.a(this.this$0).contains(localObject1));
              mtg.a(this.this$0).add(localObject1);
              localObject1 = jzk.a(paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b);
              if (paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.j(mtg.a(this.this$0)))
              {
                jzk.a(new kku.a().a(mtg.a(this.this$0)).a(jzk.aEK).b(jzk.aFA).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b).a());
                return;
              }
              jzk.a(new kku.a().a(mtg.a(this.this$0)).a(jzk.aEK).b(jzk.aFy).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b).a());
              return;
            } while ((mtg.a(this.this$0) == null) || (mtg.a(this.this$0) == null) || (!mtg.a(this.this$0).isPlaying()) || (!(mtg.a(this.this$0) instanceof mtg.b)) || (knd.a((mtg.b)mtg.a(this.this$0))));
            mtg.a(this.this$0, true, (mtg.b)mtg.a(this.this$0));
            return;
          } while (!(mtg.a(this.this$0) instanceof mtg.l));
          muj.a(((mtg.l)mtg.a(this.this$0)).jdField_a_of_type_Mrw.getView(), 8, 600);
          return;
        } while (!(mtg.a(this.this$0) instanceof mtg.b));
        localb = (mtg.b)mtg.a(this.this$0);
        localObject1 = localb.ly;
      } while (localObject1 == null);
      Object localObject2 = paramMessage.obj;
      paramMessage = localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b;
      localAdvertisementInfo = jzk.a(paramMessage);
      if (localObject2 != null)
      {
        mtg.b(this.this$0, true);
        if (localb.lF != null) {
          localb.lF.setVisibility(8);
        }
        muj.a(localb.lJ, 250, 8, Utils.dp2px(200.0D));
        muj.e((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        jzk.a(new kku.a().a(mtg.a(this.this$0)).a(jzk.aEJ).b(jzk.aFJ).a(localAdvertisementInfo).a(paramMessage).d(jzk.aGz).a());
        return;
      }
    } while (mtg.b(this.this$0));
    mtg.b localb = (mtg.b)mtg.a(this.this$0);
    localb.lM.setVisibility(8);
    localb.rv.setVisibility(0);
    localb.B.setProgress(100);
    muj.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (((mtg.b)mtg.a(this.this$0)).lF != null)
    {
      mtg.a(this.this$0, (mtg.b)mtg.a(this.this$0));
      ((mtg.b)mtg.a(this.this$0)).lF.setVisibility(0);
    }
    muj.e(((mtg.b)mtg.a(this.this$0)).lJ, 250, 0, 250, Utils.dp2px(200.0D));
    if ((knc.d(paramMessage)) && (mtg.a(this.this$0) != null)) {
      mtg.a(this.this$0).doOnResume();
    }
    jzk.a(new kku.a().a(mtg.a(this.this$0)).a(jzk.aEK).b(jzk.aFJ).a(localAdvertisementInfo).a(paramMessage).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtj
 * JD-Core Version:    0.7.0.1
 */