import NS_MOBILE_FEEDS.single_feed;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.contentbox.QZoneMsgFragment;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQShareCell;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

public class avtn
  implements avts
{
  public avtn(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void a(MQMsg paramMQMsg, View paramView, int paramInt)
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "clicktype:" + paramInt);
    if (paramMQMsg == null) {
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "MsgOnClickListener msg null");
    }
    switch (paramInt)
    {
    default: 
      this.this$0.b(paramMQMsg);
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      label255:
      do
      {
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
          ((avto)this.this$0.app.getManager(293)).a(paramMQMsg.msgInteractData.likeCell, paramMQMsg.pushTime);
        }
        LpReportInfo_pf00064.allReport(133, 5, String.valueOf(paramMQMsg.msgType));
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
        {
          if ((paramMQMsg.msgInteractData.feed == null) || (paramMQMsg.msgInteractData.feed.singlefeed == null) || (paramMQMsg.msgInteractData.feed.singlefeed.size() <= 0)) {
            break label255;
          }
          paramView = new Intent();
          QzonePluginProxyActivity.x(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 3);
          avpw.b(this.this$0.getActivity(), avpw.d.a(), paramView);
        }
        for (;;)
        {
          LpReportInfo_pf00064.allReport(133, 8, String.valueOf(paramMQMsg.msgType));
          return;
          if (paramMQMsg.msgInteractData.shareToFriend != null)
          {
            paramView = new Intent(this.this$0.getActivity(), ForwardRecentActivity.class);
            paramView.putExtra("forward_type", 2);
            paramView.putExtra("req_type", 1);
            paramView.putExtra("req_share_id", "1103584836");
            paramView.putExtra("image_url_remote", paramMQMsg.msgInteractData.shareToFriend.imgUrl);
            paramView.putExtra("detail_url", paramMQMsg.msgInteractData.shareToFriend.jumpUrl);
            paramView.putExtra("title", paramMQMsg.msgInteractData.shareToFriend.title);
            paramView.putExtra("desc", paramMQMsg.msgInteractData.shareToFriend.content);
            this.this$0.startActivity(paramView);
          }
        }
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
        {
          if ((paramMQMsg.msgInteractData.feed == null) || (paramMQMsg.msgInteractData.feed.singlefeed == null) || (paramMQMsg.msgInteractData.feed.singlefeed.size() <= 0)) {
            break label504;
          }
          paramView = new Intent();
          QzonePluginProxyActivity.x(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 4);
          avpw.b(this.this$0.getActivity(), avpw.d.a(), paramView);
        }
        for (;;)
        {
          LpReportInfo_pf00064.allReport(133, 7, String.valueOf(paramMQMsg.msgType));
          return;
          if (paramMQMsg.msgInteractData.shareToQzone != null)
          {
            paramView = new QZoneShareData();
            paramView.mTitle = paramMQMsg.msgInteractData.shareToQzone.title;
            paramView.mSummary = paramMQMsg.msgInteractData.shareToQzone.content;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
            paramView.ER = localArrayList;
            paramView.targetUrl = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
            avqq.a(this.this$0.getActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView, null, 0);
          }
        }
        paramMQMsg = aqik.c(this.this$0.app, this.this$0.getActivity(), "mqqzone://arouse/activefeed");
      } while (paramMQMsg == null);
      label504:
      paramMQMsg.ace();
      return;
    }
    this.this$0.b(paramMQMsg);
    LpReportInfo_pf00064.allReport(133, 6, String.valueOf(paramMQMsg.msgType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtn
 * JD-Core Version:    0.7.0.1
 */