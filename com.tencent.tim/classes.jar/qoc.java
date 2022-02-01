import android.app.Dialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qoc
  extends qmm.b
{
  private boolean aEu;
  private String axL = "";
  private pty jdField_c_of_type_Pty;
  private qjq jdField_c_of_type_Qjq;
  
  public boolean F(View paramView)
  {
    if (!super.F(paramView)) {
      return false;
    }
    if (this.jdField_c_of_type_Qjq == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_c_of_type_Qjq.b();
    paramView = rrt.a(this.b.getActivity(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.b.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(true);
      }
      paramView.setOnDismissListener(new qod(this, localVideoViewVideoHolder));
    }
    if (rpw.isWeishiInstalled(this.b.getActivity())) {}
    for (paramView = "1";; paramView = "2")
    {
      rar.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public Map<Subscriber, String> N()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new qoc.a(this), "");
    return localHashMap;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    this.jdField_c_of_type_Qjq = paramqjq;
    StoryVideoItem localStoryVideoItem = paramqjq.b();
    this.jdField_c_of_type_Pty = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_c_of_type_Pty == null) || (this.jdField_c_of_type_Pty.styleType != 6))
    {
      this.b.hide();
      return;
    }
    this.b.show();
    if (TextUtils.equals(this.axL, paramqjq.vid)) {
      this.aEu = false;
    }
    for (;;)
    {
      paramqjq = this.jdField_c_of_type_Pty.title;
      String str1 = this.jdField_c_of_type_Pty.body;
      String str2 = this.jdField_c_of_type_Pty.iconUrl;
      ram.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramqjq, str1, str2);
      paramc.imageView.setVisibility(0);
      paramc.xj.setVisibility(0);
      paramc.xj.setTypeface(null, 0);
      paramc.content.setVisibility(0);
      qmm.a(str2, paramc.imageView, paramc.defaultDrawable, paramc.bnm, paramc.bnm);
      paramc.xj.setText(paramqjq);
      paramc.content.setText(str1);
      if (!this.aEu) {
        break;
      }
      rar.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.aEu = true;
      this.axL = paramqjq.vid;
    }
  }
  
  public static class a
    extends pml<qoc, pxn.a>
  {
    public a(qoc paramqoc)
    {
      super();
    }
    
    public void a(@NonNull qoc paramqoc, @NonNull pxn.a parama)
    {
      if ((qoc.a(paramqoc) != null) && (parama.b.isSuccess()) && (parama.mS.contains(qoc.a(paramqoc).vid)))
      {
        ram.b("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", parama.mT.toString());
        paramqoc.b.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxn.a.class;
    }
    
    public void b(@NonNull qoc paramqoc, @NonNull pxn.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoc
 * JD-Core Version:    0.7.0.1
 */