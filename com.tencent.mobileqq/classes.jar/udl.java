import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.4;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class udl
  implements View.OnClickListener, uds, udz
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  public BubbleTextView a;
  public XEditTextEx a;
  private uby jdField_a_of_type_Uby;
  private udp jdField_a_of_type_Udp;
  private udq jdField_a_of_type_Udq;
  private udv jdField_a_of_type_Udv;
  private udw jdField_a_of_type_Udw;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public udl(Context paramContext, View paramView, ucw paramucw, boolean paramBoolean, int paramInt, udp paramudp)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramucw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Udp = paramudp;
    this.jdField_a_of_type_Boolean = paramBoolean;
    f();
    a(paramucw.a());
  }
  
  public static CommentEntry a(int paramInt)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.type = 1;
    localCommentEntry.content = (ajjy.a(2131637346) + vms.a(paramInt) + ajjy.a(2131637345));
    localCommentEntry.status = 0;
    return localCommentEntry;
  }
  
  private CommentEntry a(String paramString)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    localCommentEntry.authorUin = tfy.a().c();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.content = paramString;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 1;
    if (this.jdField_a_of_type_Udq.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry != null)
    {
      localCommentEntry.replierUnionId = this.jdField_a_of_type_Udq.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId;
      localCommentEntry.replierName = this.jdField_a_of_type_Udq.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName;
      localCommentEntry.replierRole = this.jdField_a_of_type_Udq.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorRole;
    }
    if (((Integer)((spz)sqg.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    urk.a("Q.qqstory.detail.DetailCommentHelper", "create comment entry: %s.", localCommentEntry.toString());
    return localCommentEntry;
  }
  
  public static CommentEntry a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.commentId = paramInt1;
    localCommentEntry.fakeId = paramLong;
    localCommentEntry.feedId = paramString1;
    localCommentEntry.commentType = paramInt2;
    localCommentEntry.authorUin = tfy.a().c();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.content = paramString2;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 0;
    if (((Integer)((spz)sqg.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    urk.a("Q.qqstory.detail.DetailCommentHelper", "create fake vote comment entry: %s.", localCommentEntry.toString());
    return localCommentEntry;
  }
  
  public static CommentEntry a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = a(paramString1, paramInt, paramLong, 4, paramString2);
    paramString1.putExtra("vid", paramString3);
    paramString1.putExtra("feedid", paramString4);
    paramString1.putExtra("pvid", paramString5);
    try
    {
      paramString1.putExtra("styles", new JSONArray(paramString6));
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      urk.e("Q.qqstory.detail.DetailCommentHelper", "createGamePKCommentEntry styles error. styles=%s", new Object[] { paramString6 });
    }
    return paramString1;
  }
  
  private void a(List<StoryVideoItem> paramList)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new udm(this));
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId)))
      {
        if ((paramList == null) || (paramList.size() <= 1)) {
          break label136;
        }
        if (this.jdField_a_of_type_Uby != null) {
          break label141;
        }
        this.jdField_a_of_type_Uby = new uby(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "2_", 10000, bool);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_Uby);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new udn(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new udo(this));
      return;
      label136:
      bool = false;
      break;
      label141:
      this.jdField_a_of_type_Uby.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      this.jdField_a_of_type_Uby.jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Udq.a(paramCommentEntry))
    {
      this.jdField_a_of_type_Udq.a(paramCommentEntry, paramInt);
      d(false);
    }
    a(2, new String[] { paramCommentEntry.authorName, paramCommentEntry.authorUnionId, String.valueOf(paramCommentEntry.authorUin) });
    this.jdField_a_of_type_Udw.a(true);
    sob.a().a = "4";
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299097);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131300153));
    this.jdField_a_of_type_Udw = new udw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem))) {}
    for (this.jdField_a_of_type_Udv = new udu(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this);; this.jdField_a_of_type_Udv = new udr(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this))
    {
      this.jdField_a_of_type_Udq = new udq(this);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) || (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) || (((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).isPublic()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isSubscribe())) {
        break;
      }
      a(3, new String[0]);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      return;
    }
    a(1, new String[0]);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Udv.a())
    {
      sob.a().a = "1";
      a(true);
    }
    int i = urp.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; str = "")
    {
      urp.a("home_page", "clk_reply", urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), urp.a(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, str });
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Udp.b(paramInt);
    paramInt = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      urp.a("play_video", "del_reply", paramInt, 0, new String[] { str, urp.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajjy.a(2131637343));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
      continue;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajjy.a(2131637347));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      continue;
      if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
      {
        String str2 = paramVarArgs[0];
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() == 2) {
                bool1 = true;
              }
            }
          }
          str1 = null;
          if (bool1) {
            str1 = ((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).ownerUnionId;
          }
          str1 = udd.a(paramVarArgs[1], paramVarArgs[2], bool1, str1);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajjy.a(2131637344) + str1 + "：");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    tfy.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry);
    urp.a("play_video", "report_reply", urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", urp.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    new Handler().postDelayed(new DetailCommentHelper.4(this, paramCommentEntry, paramInt), 500L);
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Udv.a(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Udw.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Udw.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    paramCommentEntry.status = 1;
    this.jdField_a_of_type_Udp.a();
    this.jdField_a_of_type_Udp.b(paramCommentEntry);
    paramCommentEntry = "";
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
      paramCommentEntry = ((QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).qq;
    }
    int i = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      urp.a("play_video", "retry_reply", i, 0, new String[] { str, urp.a(this.jdField_b_of_type_Int), paramCommentEntry, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Udv.b(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Udp.c();
    if (!paramBoolean)
    {
      sob.a().a = "2";
      this.jdField_a_of_type_Udp.P_();
      return;
    }
    if (this.jdField_a_of_type_Udq.jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_Udp.f_(this.jdField_a_of_type_Udq.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Udp.P_();
  }
  
  public boolean b()
  {
    urk.c("Q.qqstory.detail.DetailCommentHelper", "on emoji button click.");
    sob.a().a = "2";
    int i = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      urp.a("home_page", "switch_face", i, 0, new String[] { str, urp.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      bbmy.a(BaseApplication.getContext(), 1, skt.a(2131633891), 0).a();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Udw.c();
  }
  
  public void c(CommentEntry paramCommentEntry)
  {
    try
    {
      paramCommentEntry = paramCommentEntry.content;
      if (axku.a(paramCommentEntry))
      {
        paramCommentEntry = awbk.b(paramCommentEntry);
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramCommentEntry));
        int i = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
        for (paramCommentEntry = "2";; paramCommentEntry = "1")
        {
          urp.a("home_page", "copy_reply", i, 0, new String[] { paramCommentEntry, urp.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
        }
      }
    }
    catch (Exception paramCommentEntry)
    {
      while (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.detail.DetailCommentHelper", 2, paramCommentEntry.toString());
        return;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Udp.d();
      udq.a(this.jdField_a_of_type_Udq);
      a(1, new String[0]);
    }
  }
  
  public void d()
  {
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext)) {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131637348), 0).a();
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    } while (str.length() <= 0);
    urk.a("Q.qqstory.detail.DetailCommentHelper", "comment content is %s when click send button.", str);
    Object localObject = str;
    if (axku.a(str)) {
      localObject = awbk.a(str);
    }
    localObject = a((String)localObject);
    this.jdField_a_of_type_Udp.a((CommentEntry)localObject);
    d(true);
    c();
    udq.a(this.jdField_a_of_type_Udq);
    a(1, new String[0]);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_Uby != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_Uby);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Int != 3);
    bbmy.a(BaseApplication.getContext(), 1, skt.a(2131633891), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udl
 * JD-Core Version:    0.7.0.1
 */