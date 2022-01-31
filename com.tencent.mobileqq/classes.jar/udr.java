import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class udr
  implements udv
{
  public static final String a;
  public static final String b = ajjy.a(2131637354);
  public static final String c = ajjy.a(2131637356);
  public static final String d = ajjy.a(2131637355);
  public static final String e = ajjy.a(2131637357);
  public static final String f = ajjy.a(2131637353);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uds jdField_a_of_type_Uds;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131637352);
  }
  
  public udr(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uds paramuds)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uds = paramuds;
  }
  
  public boolean a()
  {
    urk.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131637358), 0).a();
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
      tij.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      urp.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      urp.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, urp.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          tij.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131637351), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = begr.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((begr)localObject).c(d);
        }
        for (;;)
        {
          ((begr)localObject).a(jdField_a_of_type_JavaLangString, 3);
          ((begr)localObject).d(f);
          ((begr)localObject).a(new udt((begr)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uds));
          ((begr)localObject).show();
          bool = false;
          break;
          ((begr)localObject).c(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbegr.c(d);
        localbegr.a(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localbegr.d(f);
      localbegr.a(new udt(localbegr, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uds));
      localbegr.show();
      return false;
      localbegr.c(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localbegr.a(jdField_a_of_type_JavaLangString, 3);
        }
        localbegr.c(c);
        localbegr.c(e);
      }
      else
      {
        localbegr.c(c);
        localbegr.c(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udr
 * JD-Core Version:    0.7.0.1
 */