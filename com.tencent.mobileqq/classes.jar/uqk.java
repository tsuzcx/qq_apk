import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class uqk
  implements uqo
{
  public static final String a;
  public static final String b = ajya.a(2131703150);
  public static final String c = ajya.a(2131703152);
  public static final String d = ajya.a(2131703151);
  public static final String e = ajya.a(2131703153);
  public static final String f = ajya.a(2131703149);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uql jdField_a_of_type_Uql;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131703148);
  }
  
  public uqk(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uql paramuql)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uql = paramuql;
  }
  
  public boolean a()
  {
    ved.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131703154), 0).a();
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
      tvc.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      vei.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vei.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, vei.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          tvc.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
      {
        bcql.a(BaseApplication.getContext(), 1, ajya.a(2131703147), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bfpc)localObject).c(d);
        }
        for (;;)
        {
          ((bfpc)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bfpc)localObject).d(f);
          ((bfpc)localObject).a(new uqm((bfpc)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uql));
          ((bfpc)localObject).show();
          bool = false;
          break;
          ((bfpc)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbfpc.c(d);
        localbfpc.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbfpc.d(f);
      localbfpc.a(new uqm(localbfpc, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uql));
      localbfpc.show();
      return false;
      localbfpc.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbfpc.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbfpc.c(c);
        localbfpc.c(e);
      }
      else
      {
        localbfpc.c(c);
        localbfpc.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqk
 * JD-Core Version:    0.7.0.1
 */