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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class qsb
  implements View.OnClickListener, qsf.a, qsi.a
{
  public BubbleTextView a;
  private qrj jdField_a_of_type_Qrj;
  private qsb.a jdField_a_of_type_Qsb$a;
  private qsb.b jdField_a_of_type_Qsb$b;
  private qsh jdField_a_of_type_Qsh;
  private qsi jdField_a_of_type_Qsi;
  private boolean aBk;
  private boolean aFh = true;
  public XEditTextEx b;
  private int bnQ;
  private CommentLikeFeedItem d;
  private Context mContext;
  private View mRootView;
  private int mSource;
  private View ot;
  
  public qsb(Context paramContext, View paramView, qru paramqru, boolean paramBoolean, int paramInt, qsb.a parama)
  {
    this.mContext = paramContext;
    this.mRootView = paramView;
    this.d = paramqru.d;
    this.mSource = paramInt;
    this.jdField_a_of_type_Qsb$a = parama;
    this.aFh = paramBoolean;
    initData();
    ez(paramqru.bS());
  }
  
  private CommentEntry a(String paramString)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.feedId = this.d.feedId;
    localCommentEntry.authorUin = qem.getQQAppInterface().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().getCurrentUid();
    localCommentEntry.content = paramString;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 1;
    if (this.jdField_a_of_type_Qsb$b.a != null)
    {
      localCommentEntry.replierUnionId = this.jdField_a_of_type_Qsb$b.a.authorUnionId;
      localCommentEntry.replierName = this.jdField_a_of_type_Qsb$b.a.authorName;
      localCommentEntry.replierRole = this.jdField_a_of_type_Qsb$b.a.authorRole;
    }
    if (((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    ram.b("Q.qqstory.detail.DetailCommentHelper", "create comment entry: %s.", localCommentEntry.toString());
    return localCommentEntry;
  }
  
  public static CommentEntry a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.commentId = paramInt1;
    localCommentEntry.fakeId = paramLong;
    localCommentEntry.feedId = paramString1;
    localCommentEntry.commentType = paramInt2;
    localCommentEntry.authorUin = qem.getQQAppInterface().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().getCurrentUid();
    localCommentEntry.content = paramString2;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 0;
    if (((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    ram.b("Q.qqstory.detail.DetailCommentHelper", "create fake vote comment entry: %s.", localCommentEntry.toString());
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
      ram.e("Q.qqstory.detail.DetailCommentHelper", "createGamePKCommentEntry styles error. styles=%s", new Object[] { paramString6 });
    }
    return paramString1;
  }
  
  public static CommentEntry b(int paramInt)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.type = 1;
    localCommentEntry.content = (acfp.m(2131704929) + rpq.aL(paramInt) + acfp.m(2131704928));
    localCommentEntry.status = 0;
    return localCommentEntry;
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Qsb$b.a(paramCommentEntry))
    {
      this.jdField_a_of_type_Qsb$b.f(paramCommentEntry, paramInt);
      tk(false);
    }
    e(2, new String[] { paramCommentEntry.authorName, paramCommentEntry.authorUnionId, String.valueOf(paramCommentEntry.authorUin) });
    this.jdField_a_of_type_Qsi.setKeyBoardState(true);
    pre.a().auz = "4";
  }
  
  private void ez(List<StoryVideoItem> paramList)
  {
    boolean bool = true;
    this.b.setOnEditorActionListener(new qsc(this));
    if (this.aFh) {
      if ((this.d != null) && (!TextUtils.isEmpty(this.d.feedId)))
      {
        if ((paramList == null) || (paramList.size() <= 1)) {
          break label136;
        }
        if (this.jdField_a_of_type_Qrj != null) {
          break label141;
        }
        this.jdField_a_of_type_Qrj = new qrj(this.mContext, this.d.feedId, "2_", 10000, bool);
        this.b.addTextChangedListener(this.jdField_a_of_type_Qrj);
      }
    }
    for (;;)
    {
      this.b.setOnTouchListener(new qsd(this));
      this.b.setOnFocusChangeListener(new qse(this));
      return;
      label136:
      bool = false;
      break;
      label141:
      this.jdField_a_of_type_Qrj.mFeedId = this.d.feedId;
      this.jdField_a_of_type_Qrj.aET = bool;
    }
  }
  
  private void initData()
  {
    this.ot = this.mRootView.findViewById(2131365322);
    this.b = ((XEditTextEx)this.mRootView.findViewById(2131366528));
    this.jdField_a_of_type_Qsi = new qsi(this.mContext, this.mRootView, this);
    if ((this.d != null) && ((this.d.getOwner() instanceof ShareGroupItem))) {}
    for (this.jdField_a_of_type_Qsh = new qsg(this.mContext, this.mSource, this.d, this);; this.jdField_a_of_type_Qsh = new qsf(this.mContext, this.mSource, this.d, this))
    {
      this.jdField_a_of_type_Qsb$b = new qsb.b();
      if ((this.d == null) || (!(this.d.getOwner() instanceof ShareGroupItem)) || (((ShareGroupItem)this.d.getOwner()).isPublic()) || (this.d.getOwner().isSubscribe())) {
        break;
      }
      e(3, new String[0]);
      this.b.setOnClickListener(this);
      return;
    }
    e(1, new String[0]);
  }
  
  private void tk(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.clearFocus();
    }
    this.b.setText("");
  }
  
  public boolean Ks()
  {
    return this.jdField_a_of_type_Qsi.Ks();
  }
  
  public boolean Kt()
  {
    ram.i("Q.qqstory.detail.DetailCommentHelper", "on emoji button click.");
    pre.a().auz = "2";
    int i = rar.a(this.d);
    if (this.d.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      rar.a("home_page", "switch_face", i, 0, new String[] { str, rar.bX(this.mSource), "", this.d.feedId });
      if (this.bnQ != 3) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 1, ppf.getString(2131701931), 0).show();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qsh.b(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void bmx()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void bpX()
  {
    if (this.jdField_a_of_type_Qsh.Ku())
    {
      pre.a().auz = "1";
      setKeyBoardState(true);
    }
    int i = rar.b(this.d);
    if ((this.d.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.d.getOwner().getUnionId();; str = "")
    {
      rar.a("home_page", "clk_reply", rar.a(this.d), 0, new String[] { String.valueOf(i), rar.bX(this.mSource), this.d.feedId, str });
      return;
    }
  }
  
  public void bqb()
  {
    this.jdField_a_of_type_Qsi.bqb();
  }
  
  public void bqc()
  {
    if (!aqiw.isNetSupport(this.mContext)) {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704931), 0).show();
    }
    String str;
    do
    {
      return;
      str = this.b.getText().toString();
    } while (str.length() <= 0);
    ram.b("Q.qqstory.detail.DetailCommentHelper", "comment content is %s when click send button.", str);
    Object localObject = str;
    if (aofy.Z(str)) {
      localObject = anbk.nm(str);
    }
    localObject = a((String)localObject);
    this.jdField_a_of_type_Qsb$a.f((CommentEntry)localObject);
    tk(true);
    bqb();
    qsb.b.a(this.jdField_a_of_type_Qsb$b);
    e(1, new String[0]);
  }
  
  public void c(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qsh.a(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void destroy()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Qrj != null)) {
      this.b.removeTextChangedListener(this.jdField_a_of_type_Qrj);
    }
  }
  
  public void e(int paramInt, String... paramVarArgs)
  {
    boolean bool2 = false;
    this.bnQ = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.b.requestLayout();
      return;
      this.b.setHint(acfp.m(2131704926));
      this.b.setEnabled(true);
      this.b.setFocusable(false);
      this.b.setFocusableInTouchMode(false);
      continue;
      this.b.setHint(acfp.m(2131704930));
      this.b.setEnabled(true);
      this.b.setFocusable(true);
      this.b.setFocusableInTouchMode(true);
      continue;
      if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
      {
        String str2 = paramVarArgs[0];
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          boolean bool1 = bool2;
          if (this.d != null)
          {
            bool1 = bool2;
            if (this.d.getOwner() != null)
            {
              bool1 = bool2;
              if (this.d.getOwner().getRelationType() == 2) {
                bool1 = true;
              }
            }
          }
          str1 = null;
          if (bool1) {
            str1 = ((ShareGroupItem)this.d.getOwner()).ownerUnionId;
          }
          str1 = qrx.a(paramVarArgs[1], paramVarArgs[2], bool1, str1);
        }
        this.b.setHint(acfp.m(2131704927) + str1 + "：");
        this.b.setEnabled(true);
        this.b.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
      }
    }
  }
  
  public void e(CommentEntry paramCommentEntry, int paramInt)
  {
    new Handler().postDelayed(new DetailCommentHelper.4(this, paramCommentEntry, paramInt), 500L);
  }
  
  public void h(CommentEntry paramCommentEntry)
  {
    qem.a(this.mContext, paramCommentEntry);
    rar.a("play_video", "report_reply", rar.a(this.d), 0, new String[] { "", rar.bX(this.mSource), "", this.d.feedId });
  }
  
  public void i(CommentEntry paramCommentEntry)
  {
    paramCommentEntry.status = 1;
    this.jdField_a_of_type_Qsb$a.azy();
    this.jdField_a_of_type_Qsb$a.g(paramCommentEntry);
    paramCommentEntry = "";
    if ((this.d.getOwner() instanceof QQUserUIItem)) {
      paramCommentEntry = ((QQUserUIItem)this.d.getOwner()).qq;
    }
    int i = rar.a(this.d);
    if (this.d.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      rar.a("play_video", "retry_reply", i, 0, new String[] { str, rar.bX(this.mSource), paramCommentEntry, this.d.feedId });
      return;
    }
  }
  
  public void j(CommentEntry paramCommentEntry)
  {
    try
    {
      paramCommentEntry = paramCommentEntry.content;
      if (aofy.Z(paramCommentEntry))
      {
        paramCommentEntry = anbk.nn(paramCommentEntry);
        ClipboardManager localClipboardManager = (ClipboardManager)this.mContext.getSystemService("clipboard");
        paramCommentEntry = ClipData.newPlainText("comment content", paramCommentEntry);
        alkw.a(localClipboardManager, paramCommentEntry);
        localClipboardManager.setPrimaryClip(paramCommentEntry);
        int i = rar.a(this.d);
        if (this.d.getOwner().isMe()) {}
        for (paramCommentEntry = "2";; paramCommentEntry = "1")
        {
          rar.a("home_page", "copy_reply", i, 0, new String[] { paramCommentEntry, rar.bX(this.mSource), "", this.d.feedId });
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.bnQ == 3) {
        QQToast.a(BaseApplication.getContext(), 1, ppf.getString(2131701931), 0).show();
      }
    }
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qsi.setKeyBoardState(paramBoolean);
  }
  
  public void tl(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qsb$a.bor();
    if (!paramBoolean)
    {
      pre.a().auz = "2";
      this.jdField_a_of_type_Qsb$a.boq();
      return;
    }
    if (this.jdField_a_of_type_Qsb$b.bnS != -1)
    {
      this.jdField_a_of_type_Qsb$a.wk(this.jdField_a_of_type_Qsb$b.bnS);
      return;
    }
    this.jdField_a_of_type_Qsb$a.boq();
  }
  
  public void tm(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qsb$a.bos();
      qsb.b.a(this.jdField_a_of_type_Qsb$b);
      e(1, new String[0]);
    }
  }
  
  public void ww(int paramInt)
  {
    this.jdField_a_of_type_Qsb$a.wl(paramInt);
    paramInt = rar.a(this.d);
    if (this.d.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      rar.a("play_video", "del_reply", paramInt, 0, new String[] { str, rar.bX(this.mSource), "", this.d.feedId });
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void azy();
    
    public abstract void boq();
    
    public abstract void bor();
    
    public abstract void bos();
    
    public abstract void f(CommentEntry paramCommentEntry);
    
    public abstract void g(CommentEntry paramCommentEntry);
    
    public abstract void wk(int paramInt);
    
    public abstract void wl(int paramInt);
  }
  
  class b
  {
    public CommentEntry a;
    public int bnS = -1;
    private int bnT = -1;
    
    b() {}
    
    private void clear()
    {
      this.a = null;
      this.bnS = -1;
      this.bnT = -1;
    }
    
    public boolean a(CommentEntry paramCommentEntry)
    {
      return paramCommentEntry.commentId != this.bnT;
    }
    
    public void f(CommentEntry paramCommentEntry, int paramInt)
    {
      this.a = paramCommentEntry;
      this.bnT = paramCommentEntry.commentId;
      this.bnS = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsb
 * JD-Core Version:    0.7.0.1
 */