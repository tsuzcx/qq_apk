import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class qsf
  implements qsh
{
  public static final String ayp = acfp.m(2131704935);
  public static final String ayq = acfp.m(2131704937);
  public static final String ayr = acfp.m(2131704939);
  public static final String ays = acfp.m(2131704938);
  public static final String ayt = acfp.m(2131704940);
  public static final String ayu = acfp.m(2131704936);
  private qsf.a a;
  private CommentLikeFeedItem d;
  private Context mContext;
  private int mSource;
  
  public qsf(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, qsf.a parama)
  {
    this.mContext = paramContext;
    this.mSource = paramInt;
    this.d = paramCommentLikeFeedItem;
    this.a = parama;
  }
  
  public boolean Ku()
  {
    ram.i("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704941), 0).show();
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
      qgg.a(this.mContext, paramCommentEntry.b(), null);
      rar.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = rar.a(this.d);
      if (!this.d.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      rar.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, rar.bX(this.mSource), "", this.d.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          qgg.c(this.mContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!aqiw.isNetSupport(this.mContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704934), 0).show();
        bool = false;
        break;
      }
      if (QQStoryContext.a().eU(paramCommentEntry.authorUnionId))
      {
        localObject = ausj.b(this.mContext);
        if (paramCommentEntry.status == 2) {
          ((ausj)localObject).addButton(ays);
        }
        for (;;)
        {
          ((ausj)localObject).addButton(ayp, 3);
          ((ausj)localObject).addCancelButton(ayu);
          ((ausj)localObject).a(new qsf.b((ausj)localObject, paramCommentEntry, paramInt1, this.a));
          ((ausj)localObject).show();
          bool = false;
          break;
          ((ausj)localObject).addButton(ayt);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ausj localausj = ausj.b(this.mContext);
    if (QQStoryContext.a().eU(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localausj.addButton(ays);
        localausj.addButton(ayp, 3);
      }
    }
    for (;;)
    {
      localausj.addCancelButton(ayu);
      localausj.a(new qsf.b(localausj, paramCommentEntry, paramInt1, this.a));
      localausj.show();
      return false;
      localausj.addButton(ayt);
      break;
      if (this.d.getOwner().isMe())
      {
        if ((this.d.getOwner().isVip()) || (paramInt2 == 2)) {
          localausj.addButton(ayp, 3);
        }
        localausj.addButton(ayr);
        localausj.addButton(ayt);
      }
      else
      {
        localausj.addButton(ayr);
        localausj.addButton(ayt);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(CommentEntry paramCommentEntry, int paramInt);
    
    public abstract void h(CommentEntry paramCommentEntry);
    
    public abstract void i(CommentEntry paramCommentEntry);
    
    public abstract void j(CommentEntry paramCommentEntry);
    
    public abstract void ww(int paramInt);
  }
  
  public static class b
    implements ausj.a
  {
    private final CommentEntry a;
    private final int bjS;
    private final ausj mActionSheet;
    private WeakReference<qsf.a> mCallback;
    
    public b(ausj paramausj, CommentEntry paramCommentEntry, int paramInt, qsf.a parama)
    {
      this.mActionSheet = paramausj;
      this.a = paramCommentEntry;
      this.bjS = paramInt;
      this.mCallback = new WeakReference(parama);
    }
    
    public void OnClick(View paramView, int paramInt)
    {
      paramView = this.mActionSheet.getContent(paramInt);
      ram.b("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
      if (this.mCallback.get() == null)
      {
        ram.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
        return;
      }
      qsf.a locala = (qsf.a)this.mCallback.get();
      if (qsf.ayp.equals(paramView)) {
        locala.ww(this.bjS);
      }
      for (;;)
      {
        this.mActionSheet.dismiss();
        return;
        if (qsf.ayq.equals(paramView)) {
          locala.e(this.a, this.bjS);
        } else if (qsf.ayr.equals(paramView)) {
          locala.h(this.a);
        } else if (qsf.ays.equals(paramView)) {
          locala.i(this.a);
        } else if (qsf.ayt.equals(paramView)) {
          locala.j(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsf
 * JD-Core Version:    0.7.0.1
 */