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

public class ycw
  implements yda
{
  public static final String a;
  public static final String b = anni.a(2131701931);
  public static final String c = anni.a(2131701933);
  public static final String d = anni.a(2131701932);
  public static final String e = anni.a(2131701934);
  public static final String f = anni.a(2131701930);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private ycx jdField_a_of_type_Ycx;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131701929);
  }
  
  public ycw(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, ycx paramycx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Ycx = paramycx;
  }
  
  public boolean a()
  {
    yqp.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anni.a(2131701935), 0).a();
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
      xho.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      yqu.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = yqu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yqu.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, yqu.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          xho.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, anni.a(2131701928), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bkho.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bkho)localObject).c(d);
        }
        for (;;)
        {
          ((bkho)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bkho)localObject).d(f);
          ((bkho)localObject).a(new ycy((bkho)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ycx));
          ((bkho)localObject).show();
          bool = false;
          break;
          ((bkho)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bkho localbkho = bkho.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbkho.c(d);
        localbkho.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbkho.d(f);
      localbkho.a(new ycy(localbkho, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ycx));
      localbkho.show();
      return false;
      localbkho.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbkho.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbkho.c(c);
        localbkho.c(e);
      }
      else
      {
        localbkho.c(c);
        localbkho.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycw
 * JD-Core Version:    0.7.0.1
 */