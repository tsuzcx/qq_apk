import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class wjl
  implements wjp
{
  public static final String a;
  public static final String b = alud.a(2131703534);
  public static final String c = alud.a(2131703536);
  public static final String d = alud.a(2131703535);
  public static final String e = alud.a(2131703537);
  public static final String f = alud.a(2131703533);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private wjm jdField_a_of_type_Wjm;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131703532);
  }
  
  public wjl(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, wjm paramwjm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Wjm = paramwjm;
  }
  
  public boolean a()
  {
    wxe.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131703538), 0).a();
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
      vod.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      wxj.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = wxj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wxj.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, wxj.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          vod.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, alud.a(2131703531), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bhuf)localObject).c(d);
        }
        for (;;)
        {
          ((bhuf)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bhuf)localObject).d(f);
          ((bhuf)localObject).a(new wjn((bhuf)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wjm));
          ((bhuf)localObject).show();
          bool = false;
          break;
          ((bhuf)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbhuf.c(d);
        localbhuf.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbhuf.d(f);
      localbhuf.a(new wjn(localbhuf, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wjm));
      localbhuf.show();
      return false;
      localbhuf.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbhuf.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbhuf.c(c);
        localbhuf.c(e);
      }
      else
      {
        localbhuf.c(c);
        localbhuf.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjl
 * JD-Core Version:    0.7.0.1
 */