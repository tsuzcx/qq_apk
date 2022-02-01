import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class xic
  implements xig
{
  public static final String a;
  public static final String b = amtj.a(2131702273);
  public static final String c = amtj.a(2131702275);
  public static final String d = amtj.a(2131702274);
  public static final String e = amtj.a(2131702276);
  public static final String f = amtj.a(2131702272);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private xid jdField_a_of_type_Xid;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131702271);
  }
  
  public xic(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, xid paramxid)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Xid = paramxid;
  }
  
  public boolean a()
  {
    xvv.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131702277), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      wmu.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      xwa.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = xwa.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      xwa.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, xwa.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          wmu.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131702270), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bjnw)localObject).c(d);
        }
        for (;;)
        {
          ((bjnw)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bjnw)localObject).d(f);
          ((bjnw)localObject).a(new xie((bjnw)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xid));
          ((bjnw)localObject).show();
          bool = false;
          break;
          ((bjnw)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbjnw.c(d);
        localbjnw.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbjnw.d(f);
      localbjnw.a(new xie(localbjnw, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xid));
      localbjnw.show();
      return false;
      localbjnw.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbjnw.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbjnw.c(c);
        localbjnw.c(e);
      }
      else
      {
        localbjnw.c(c);
        localbjnw.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xic
 * JD-Core Version:    0.7.0.1
 */