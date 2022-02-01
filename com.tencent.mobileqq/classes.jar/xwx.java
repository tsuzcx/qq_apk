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

public class xwx
  implements xxb
{
  public static final String a;
  public static final String b = anvx.a(2131702624);
  public static final String c = anvx.a(2131702626);
  public static final String d = anvx.a(2131702625);
  public static final String e = anvx.a(2131702627);
  public static final String f = anvx.a(2131702623);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private xwy jdField_a_of_type_Xwy;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131702622);
  }
  
  public xwx(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, xwy paramxwy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Xwy = paramxwy;
  }
  
  public boolean a()
  {
    ykq.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131702628), 0).a();
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
      xbp.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      ykv.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      ykv.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, ykv.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          xbp.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131702621), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((bkzi)localObject).c(d);
        }
        for (;;)
        {
          ((bkzi)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((bkzi)localObject).d(f);
          ((bkzi)localObject).a(new xwz((bkzi)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xwy));
          ((bkzi)localObject).show();
          bool = false;
          break;
          ((bkzi)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbkzi.c(d);
        localbkzi.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbkzi.d(f);
      localbkzi.a(new xwz(localbkzi, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xwy));
      localbkzi.show();
      return false;
      localbkzi.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbkzi.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbkzi.c(c);
        localbkzi.c(e);
      }
      else
      {
        localbkzi.c(c);
        localbkzi.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwx
 * JD-Core Version:    0.7.0.1
 */