import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class uqn
  implements uqr
{
  public static final String a;
  public static final String b = ajyc.a(2131703139);
  public static final String c = ajyc.a(2131703141);
  public static final String d = ajyc.a(2131703140);
  public static final String e = ajyc.a(2131703142);
  public static final String f = ajyc.a(2131703138);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uqo jdField_a_of_type_Uqo;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131703137);
  }
  
  public uqn(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uqo paramuqo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uqo = paramuqo;
  }
  
  public boolean a()
  {
    veg.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131703143), 0).a();
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
      tvf.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      vel.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vel.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, vel.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          tvf.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131703136), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bfol.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bfol)localObject).c(d);
        }
        for (;;)
        {
          ((bfol)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bfol)localObject).d(f);
          ((bfol)localObject).a(new uqp((bfol)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uqo));
          ((bfol)localObject).show();
          bool = false;
          break;
          ((bfol)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbfol.c(d);
        localbfol.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbfol.d(f);
      localbfol.a(new uqp(localbfol, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uqo));
      localbfol.show();
      return false;
      localbfol.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbfol.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbfol.c(c);
        localbfol.c(e);
      }
      else
      {
        localbfol.c(c);
        localbfol.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqn
 * JD-Core Version:    0.7.0.1
 */