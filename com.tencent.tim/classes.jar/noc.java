import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.a;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xc90.CommunityConfigInfo;
import tencent.im.oidb.oidb_0xc90.RspBody;

public class noc
  extends ReadInJoyDiandianHeaderController.b
{
  public noc(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController)
  {
    super(paramReadInJoyDiandianHeaderController);
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0xc90.RspBody paramRspBody)
  {
    Object localObject = paramRspBody.rpt_community_info_item.get();
    this.a.kw = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oidb_0xc90.CommunityConfigInfo localCommunityConfigInfo = (oidb_0xc90.CommunityConfigInfo)((Iterator)localObject).next();
      CommunityConfigInfo localCommunityConfigInfo1 = new CommunityConfigInfo();
      localCommunityConfigInfo1.name = localCommunityConfigInfo.bytes_name.get().toStringUtf8();
      localCommunityConfigInfo1.jumpUrl = localCommunityConfigInfo.bytes_jump_home_page_url.get().toStringUtf8();
      localCommunityConfigInfo1.bid = localCommunityConfigInfo.uint64_community_bid.get();
      localCommunityConfigInfo1.picUrl = localCommunityConfigInfo.bytes_pic_url.get().toStringUtf8();
      localCommunityConfigInfo1.dynamicCount = localCommunityConfigInfo.uint32_dynamic_count.get();
      localCommunityConfigInfo1.followStatus = localCommunityConfigInfo.uint32_follow_status.get();
      this.a.kw.add(localCommunityConfigInfo1);
    }
    this.a.amV = paramRspBody.bytes_jump_concern_community_url.get().toStringUtf8();
    this.a.amX = paramRspBody.bytes_more_url_wording.get().toStringUtf8();
    this.a.amW = paramRspBody.bytes_community_title_wording.get().toStringUtf8();
    this.a.amY = paramRspBody.bytes_jump_community_channel_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(this.a.amW))
    {
      this.a.tz.setText(this.a.amW);
      this.a.tz.setVisibility(0);
      if (TextUtils.isEmpty(this.a.amX)) {
        break label456;
      }
      this.a.tA.setText(this.a.amX);
      this.a.tA.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.amV)) {
        this.a.tA.setOnClickListener(new nod(this));
      }
      if ((this.a.kw == null) || (this.a.kw.size() <= 0) || (ReadInJoyDiandianHeaderController.a(this.a).isVisible())) {
        break label471;
      }
      this.a.a = new ReadInJoyDiandianHeaderController.a(this.a, this.a.kw);
      this.a.c.setAdapter(this.a.a);
      this.a.fr.setVisibility(0);
      return;
      this.a.tz.setVisibility(8);
      break;
      label456:
      this.a.tA.setVisibility(8);
    }
    label471:
    this.a.fr.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noc
 * JD-Core Version:    0.7.0.1
 */