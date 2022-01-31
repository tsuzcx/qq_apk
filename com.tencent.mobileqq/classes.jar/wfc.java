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

public class wfc
  implements wfg
{
  public static final String a;
  public static final String b = alpo.a(2131703522);
  public static final String c = alpo.a(2131703524);
  public static final String d = alpo.a(2131703523);
  public static final String e = alpo.a(2131703525);
  public static final String f = alpo.a(2131703521);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private wfd jdField_a_of_type_Wfd;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131703520);
  }
  
  public wfc(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, wfd paramwfd)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Wfd = paramwfd;
  }
  
  public boolean a()
  {
    wsv.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131703526), 0).a();
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
      vju.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      wta.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = wta.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wta.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, wta.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          vju.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131703519), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bhpy)localObject).c(d);
        }
        for (;;)
        {
          ((bhpy)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bhpy)localObject).d(f);
          ((bhpy)localObject).a(new wfe((bhpy)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wfd));
          ((bhpy)localObject).show();
          bool = false;
          break;
          ((bhpy)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbhpy.c(d);
        localbhpy.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbhpy.d(f);
      localbhpy.a(new wfe(localbhpy, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wfd));
      localbhpy.show();
      return false;
      localbhpy.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbhpy.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbhpy.c(c);
        localbhpy.c(e);
      }
      else
      {
        localbhpy.c(c);
        localbhpy.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfc
 * JD-Core Version:    0.7.0.1
 */