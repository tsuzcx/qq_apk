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

public class ygr
  implements ygv
{
  public static final String a;
  public static final String b = anzj.a(2131702038);
  public static final String c = anzj.a(2131702040);
  public static final String d = anzj.a(2131702039);
  public static final String e = anzj.a(2131702041);
  public static final String f = anzj.a(2131702037);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private ygs jdField_a_of_type_Ygs;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131702036);
  }
  
  public ygr(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, ygs paramygs)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Ygs = paramygs;
  }
  
  public boolean a()
  {
    yuk.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131702042), 0).a();
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
      xlj.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      yup.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = yup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yup.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, yup.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          xlj.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131702035), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = blir.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((blir)localObject).c(d);
        }
        for (;;)
        {
          ((blir)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((blir)localObject).d(f);
          ((blir)localObject).a(new ygt((blir)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ygs));
          ((blir)localObject).show();
          bool = false;
          break;
          ((blir)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localblir.c(d);
        localblir.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localblir.d(f);
      localblir.a(new ygt(localblir, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ygs));
      localblir.show();
      return false;
      localblir.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localblir.a(jdField_a_of_type_JavaLangString, 3);
        }
        localblir.c(c);
        localblir.c(e);
      }
      else
      {
        localblir.c(c);
        localblir.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygr
 * JD-Core Version:    0.7.0.1
 */