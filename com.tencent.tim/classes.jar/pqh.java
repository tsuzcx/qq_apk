import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.a;
import com.tencent.biz.qqstory.view.widget.InnerListView.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

public class pqh
  extends prh
  implements View.OnClickListener, InnerListView.a, InnerListView.b
{
  public CommentLikeFeedItem a;
  private pqh.a a;
  protected pqj a;
  public String aur;
  protected Handler bf = new Handler();
  
  public pqh(pqj parampqj)
  {
    this.jdField_a_of_type_Pqj = parampqj;
    this.aur = QQStoryContext.a().mi();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Pqj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Pqh$a = new pqh.a();
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Pqj.jdField_a_of_type_Pqh$b != null) {
      this.jdField_a_of_type_Pqj.jdField_a_of_type_Pqh$b.a(this.jdField_a_of_type_Pqj, this.jdField_a_of_type_Pqh$a.ba, this.jdField_a_of_type_Pqh$a.nZ, this.jdField_a_of_type_Pqh$a.bjR, paramCommentEntry);
    }
    pqn localpqn = (pqn)this.jdField_a_of_type_Pqj.a();
    paramInt = rar.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      rar.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, rar.bX(localpqn.mFeedType), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().getCurrentUid();
    ausj localausj = ausj.b(this.jdField_a_of_type_Pqj.mActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localausj.addButton(acfp.m(2131706153));
        localausj.addButton(acfp.m(2131706121), 3);
      }
    }
    for (;;)
    {
      localausj.addCancelButton(acfp.m(2131706126));
      localausj.a(new pqh.c(localausj, paramCommentEntry, paramInt));
      localausj.show();
      return;
      localausj.addButton(acfp.m(2131706141));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localausj.addButton(acfp.m(2131706151), 3);
        }
        localausj.addButton(acfp.m(2131706150));
        localausj.addButton(acfp.m(2131706148));
      }
      else
      {
        localausj.addButton(acfp.m(2131706122));
        localausj.addButton(acfp.m(2131706140));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      qgg.a(this.jdField_a_of_type_Pqj.mActivity, paramCommentEntry.b(), null);
      rar.a("play_video", "multishoot_icon", 0, 0, new String[0]);
    }
    Object localObject;
    do
    {
      return;
      if (paramCommentEntry.commentType != 4) {
        break;
      }
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramCommentEntry)));
    qgg.c(this.jdField_a_of_type_Pqj.mContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().eU(paramCommentEntry.authorUnionId))
    {
      localObject = ausj.b(this.jdField_a_of_type_Pqj.mActivity);
      if (paramCommentEntry.status == 2) {
        ((ausj)localObject).addButton(acfp.m(2131706155));
      }
      for (;;)
      {
        ((ausj)localObject).addButton(acfp.m(2131706158), 3);
        ((ausj)localObject).addCancelButton(acfp.m(2131706136));
        ((ausj)localObject).a(new pqh.c((ausj)localObject, paramCommentEntry, paramInt));
        ((ausj)localObject).show();
        return;
        ((ausj)localObject).addButton(acfp.m(2131706142));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = rar.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      rar.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, rar.bX(this.jdField_a_of_type_Pqj.mFeedType), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Pqj.lK.get(paramInt);
    this.jdField_a_of_type_Pqh$a.ba = paramInnerListView;
    this.jdField_a_of_type_Pqh$a.nZ = paramView;
    this.jdField_a_of_type_Pqh$a.bjR = paramInt;
    if (!aqiw.isNetSupport(this.jdField_a_of_type_Pqj.mContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706130), 0).show();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Pqj.lK.get(paramInt), paramInt);
    this.jdField_a_of_type_Pqh$a.ba = paramInnerListView;
    this.jdField_a_of_type_Pqh$a.nZ = paramView;
    this.jdField_a_of_type_Pqh$a.bjR = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Pqj.lK.get(i);
      ausj localausj = ausj.b(this.jdField_a_of_type_Pqj.mActivity);
      localausj.addButton(acfp.m(2131706133));
      localausj.addButton(acfp.m(2131706119), 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new pqh.c(localausj, localCommentEntry, i));
      localausj.show();
      continue;
      this.jdField_a_of_type_Pqj.a().bmm();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
  
  public class a
    extends plt
  {
    public ViewGroup ba;
    public int bjR;
    public View nZ;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(pqj parampqj, View paramView, String paramString);
    
    public abstract void a(pqj parampqj, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry);
  }
  
  public class c
    implements ausj.a
  {
    private final CommentEntry a;
    private final int bjS;
    private final ausj mActionSheet;
    
    public c(ausj paramausj, CommentEntry paramCommentEntry, int paramInt)
    {
      this.mActionSheet = paramausj;
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
      this.bjS = paramInt;
    }
    
    public void OnClick(View paramView, int paramInt)
    {
      paramView = this.mActionSheet.getContent(paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
      }
      if (acfp.m(2131706156).equals(paramView))
      {
        this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.vT(this.bjS);
        paramView = this.jdField_a_of_type_Pqh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
        if ((paramView != null) && (paramView.isVip()))
        {
          paramInt = 1;
          if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Pqh.aur)) {
            break label177;
          }
          paramView = "2";
          label124:
          rar.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Pqh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
      }
      label171:
      label177:
      do
      {
        for (;;)
        {
          this.mActionSheet.dismiss();
          return;
          paramInt = 2;
          break;
          paramView = "1";
          break label124;
          if (acfp.m(2131706145).equals(paramView))
          {
            this.jdField_a_of_type_Pqh.bf.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
          }
          else if (acfp.m(2131706137).equals(paramView))
          {
            qem.a(this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.mActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
            rar.a("play_video", "report_reply", rar.a(this.jdField_a_of_type_Pqh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", rar.bX(this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.mFeedType), "", this.jdField_a_of_type_Pqh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          }
          else
          {
            if (!acfp.m(2131706160).equals(paramView)) {
              break label407;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
            this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.notifyDataSetChanged();
            this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
            pre.a().auz = "";
            pqj.a(this.jdField_a_of_type_Pqh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.mFeedType, new pqi(this));
          }
        }
      } while (!acfp.m(2131706132).equals(paramView));
      label407:
      label496:
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
          if (!aofy.Z(paramView)) {
            break label496;
          }
          paramView = anbk.nn(paramView);
          ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_Pqh.jdField_a_of_type_Pqj.mContext.getSystemService("clipboard");
          paramView = ClipData.newPlainText("comment content", paramView);
          alkw.a(localClipboardManager, paramView);
          localClipboardManager.setPrimaryClip(paramView);
        }
        catch (Exception paramView) {}
        if (!QLog.isColorLevel()) {
          break label171;
        }
        QLog.e("FeedCommentEventHandler", 2, paramView.toString());
        return;
      }
    }
  }
  
  public static abstract class d
  {
    public abstract void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry);
    
    public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqh
 * JD-Core Version:    0.7.0.1
 */