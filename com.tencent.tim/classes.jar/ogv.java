import UserGrowth.stCommentJumpText;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ogv
{
  private static final String TAG = ogv.class.getSimpleName();
  private ohl b;
  private Map<String, ArrayList<stSimpleMetaComment>> fh = new HashMap();
  private Map<String, Integer> fi = new HashMap();
  private Map<String, ogv.a> fj = new HashMap();
  private Handler mMainHandler;
  
  public ogv(ohl paramohl)
  {
    this.b = paramohl;
  }
  
  private static ArrayList<stSimpleMetaComment> a(stSimpleMetaComment[] paramArrayOfstSimpleMetaComment)
  {
    paramArrayOfstSimpleMetaComment = Arrays.asList(paramArrayOfstSimpleMetaComment);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfstSimpleMetaComment.size() > 0)
    {
      int i = 0;
      if (i < paramArrayOfstSimpleMetaComment.size())
      {
        if (paramArrayOfstSimpleMetaComment.get(i) != null)
        {
          localArrayList.add(paramArrayOfstSimpleMetaComment.get(i));
          if (i == 0) {
            ooz.w("weishi-comment", "end, comment word:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).wording + ", id:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).id);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ooz.e("weishi-comment", "comment is null");
        }
      }
    }
    return localArrayList;
  }
  
  private void ap(String paramString, boolean paramBoolean)
  {
    if (this.fj.get(paramString) == null)
    {
      ogv.a locala = new ogv.a();
      locala.axb = paramBoolean;
      this.fj.put(paramString, locala);
      return;
    }
    paramString = (ogv.a)this.fj.get(paramString);
    if (paramString != null)
    {
      paramString.axb = paramBoolean;
      return;
    }
    ooz.e(TAG, "updateResponseState, commentResponse is null.");
  }
  
  private static ArrayList<stSimpleMetaComment> b(ArrayList<stSimpleMetaComment> paramArrayList, ArrayList<stCommentJumpText> paramArrayList1, int paramInt)
  {
    int m = 0;
    if (paramArrayList.size() == 0) {
      return new ArrayList();
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramArrayList1.size() > 0)
    {
      i = 0;
      if (i < paramArrayList1.size())
      {
        stCommentJumpText localstCommentJumpText = (stCommentJumpText)paramArrayList1.get(i);
        stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
        localstSimpleMetaComment.isTempData = true;
        j = localstCommentJumpText.index;
        localstSimpleMetaComment.wording = localstCommentJumpText.text;
        if (j >= paramInt)
        {
          localHashMap.put(Integer.valueOf(j), localstSimpleMetaComment);
          label105:
          if (j != -1) {
            break label191;
          }
          ooz.i("comment", localstCommentJumpText.index + ",尾部拉量入口: " + localstSimpleMetaComment.wording);
        }
        for (;;)
        {
          i += 1;
          break;
          ooz.i("comment", "oldsize:" + paramInt + ", index:" + j);
          break label105;
          label191:
          ooz.i("comment", localstCommentJumpText.index + ",拉量入口: " + localstSimpleMetaComment.wording);
        }
      }
    }
    if ((paramArrayList.size() <= 20) && (localHashMap.containsKey(Integer.valueOf(-1))))
    {
      localHashMap.remove(Integer.valueOf(-1));
      ooz.e("weishi-comment", "评论小于等于20条，移除尾部拉量入口");
    }
    int j = paramArrayList.size() + localHashMap.size();
    ooz.e("weishi-comment", "size1:" + paramArrayList.size() + ",size2:" + localHashMap.size());
    paramArrayList1 = new stSimpleMetaComment[j];
    if (localHashMap.keySet().contains(Integer.valueOf(-1)))
    {
      j -= 1;
      paramArrayList1[(paramArrayList1.length - 1)] = ((stSimpleMetaComment)localHashMap.get(Integer.valueOf(-1)));
    }
    for (;;)
    {
      int k = 0;
      i = m;
      if (k < j)
      {
        if (localHashMap.keySet().contains(Integer.valueOf(k + paramInt)))
        {
          paramArrayList1[k] = ((stSimpleMetaComment)localHashMap.get(Integer.valueOf(k + paramInt)));
          i += 1;
        }
        for (;;)
        {
          k += 1;
          break;
          m = k - i;
          if (m >= paramArrayList.size()) {
            break label463;
          }
          paramArrayList1[k] = ((stSimpleMetaComment)paramArrayList.get(m));
        }
        label463:
        ooz.w("weishi-comment", "combineComment end!");
      }
      ooz.e("weishi-comment", "combineComment success");
      return a(paramArrayList1);
    }
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (this.fj.get(paramString1) == null)
    {
      ogv.a locala = new ogv.a();
      locala.attachInfo = paramString2;
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        locala.hasMore = paramBoolean1;
        this.fj.put(paramString1, locala);
        return;
      }
    }
    paramString1 = (ogv.a)this.fj.get(paramString1);
    if (paramString1 != null)
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = paramBoolean2;; paramBoolean1 = false)
      {
        paramString1.hasMore = paramBoolean1;
        paramString1.attachInfo = paramString2;
        return;
      }
    }
    ooz.e(TAG, "updateResponseState, commentResponse is null.");
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    paramstSimpleMetaFeed = new onv(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new ohc(this, paramstSimpleMetaComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    ooz.e(TAG, "reply.poster_id:" + paramstSimpleMetaReply.poster.id + ",reply.receiver_id:" + paramstSimpleMetaReply.receiver.id + ",reply.beReplyCommendId:" + paramstSimpleMetaReply.beReplyReplyId);
    paramstSimpleMetaFeed = new onw(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new oha(this, paramstSimpleMetaReply), 6));
    return 0L;
  }
  
  public String a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.id.startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), acfp.m(2131704187), null }));
      return "";
    }
    paramstSimpleMetaFeed = new ono(paramstSimpleMetaFeed.id, paramstSimpleMetaComment);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new ogz(this, paramstSimpleMetaComment), 7));
    return paramstSimpleMetaComment.id;
  }
  
  public String a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply == null) || (paramstSimpleMetaReply.id.startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(6), Integer.valueOf(-1), acfp.m(2131704185), null }));
      return "";
    }
    paramstSimpleMetaFeed = new ono(paramstSimpleMetaFeed.id, paramstSimpleMetaComment);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new ohb(this, paramstSimpleMetaComment, paramstSimpleMetaReply), 8));
    return paramstSimpleMetaReply.id;
  }
  
  public sct a(Object... paramVarArgs)
  {
    return new sct(6, paramVarArgs);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    ooz.e(TAG, "---添加评论，wording:" + paramstSimpleMetaComment.wording + "poster_id:" + paramstSimpleMetaComment.poster_id + ",receiver_id:" + paramstSimpleMetaComment.receiver_id);
    paramstSimpleMetaFeed = new onx(paramstSimpleMetaFeed, paramstSimpleMetaComment);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new ogy(this), 5));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    paramstSimpleMetaFeed = new onv(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    oks.a().b(new okz(paramstSimpleMetaFeed, getHandler(), new ohd(this), 9));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean)
  {
    ooz.i(TAG, "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
    paramstSimpleMetaFeed = new okz(new onr(paramString, paramstSimpleMetaFeed.id, 1), getHandler(), new ogx(this, paramstSimpleMetaFeed, paramBoolean), 1000);
    oks.a().b(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null)
    {
      ooz.e(TAG, "getComments , feed is null ");
      return;
    }
    String str = getAttachInfo(paramstSimpleMetaFeed.id);
    ooz.w(TAG, "getComments loadMore: " + paramBoolean + ", attachInfo:" + str);
    if ((paramBoolean) && (TextUtils.isEmpty(str)))
    {
      ooz.e(TAG, "getComments and loadMore, attachInfo is empty ");
      return;
    }
    if (!paramBoolean)
    {
      str = "";
      ooz.e(TAG, "first getComments, set attachInfo empty ");
    }
    ap(paramstSimpleMetaFeed.id, false);
    a(paramstSimpleMetaFeed, str, paramBoolean);
  }
  
  public int aU(String paramString)
  {
    paramString = (Integer)this.fi.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public String getAttachInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (ogv.a)this.fj.get(paramString);
    if ((paramString != null) && (paramString.axb) && (paramString.hasMore) && (paramString.attachInfo != null)) {
      return paramString.attachInfo;
    }
    return "";
  }
  
  public Handler getHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new ogw(this, Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void release()
  {
    this.fh.clear();
    this.fj.clear();
    this.fi.clear();
  }
  
  public ArrayList<stSimpleMetaComment> t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.fh.get(paramString);
  }
  
  static class a
  {
    public String attachInfo;
    public boolean axb;
    public boolean hasMore;
    
    public String toString()
    {
      return "CommentResponse{hasMore=" + this.hasMore + ", attachInfo='" + this.attachInfo + '\'' + ", hasResponse='" + this.axb + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogv
 * JD-Core Version:    0.7.0.1
 */