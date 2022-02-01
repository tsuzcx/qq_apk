import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ogt
  extends BaseAdapter
{
  public static int beU = 1;
  private String Ur = "focus";
  private sdw a;
  HashSet<Integer> ac = new HashSet();
  HashSet<Integer> ad = new HashSet();
  private String aqa;
  private String aqb;
  private stSimpleMetaFeed b;
  private Map<String, Integer> fg;
  private List<stSimpleMetaComment> kZ;
  private Context mContext;
  private String mFeedId;
  
  public ogt(Context paramContext, sdw paramsdw)
  {
    this.mContext = paramContext;
    if (this.kZ == null)
    {
      ooz.i("comment", "create mComments ...");
      this.kZ = new ArrayList();
    }
    for (;;)
    {
      this.a = paramsdw;
      this.fg = new HashMap();
      return;
      ooz.i("comment", "复用 mComments ...");
    }
  }
  
  public boolean L(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    ooz.e("comment", "removeCommentReply ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        Iterator localIterator = this.kZ.iterator();
        stSimpleMetaComment localstSimpleMetaComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
        } while (!paramString1.equals(localstSimpleMetaComment.id));
        i = localstSimpleMetaComment.replyList.size() - 1;
        if (i < 0) {
          break label149;
        }
        if (!paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(i)).id)) {
          break label142;
        }
        if (localstSimpleMetaComment.replyList.remove(i) == null) {
          break label136;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label136:
      bool1 = false;
      continue;
      label142:
      i -= 1;
      break;
      label149:
      bool1 = false;
    }
  }
  
  public int a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      this.fg.put(paramstSimpleMetaComment.id, Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void a(int paramInt, stSimpleMetaComment paramstSimpleMetaComment)
  {
    ooz.e("comment", "addComment ...2");
    if ((paramstSimpleMetaComment != null) && (paramInt <= this.kZ.size())) {
      this.kZ.add(paramInt, paramstSimpleMetaComment);
    }
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    Integer localInteger;
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      localInteger = (Integer)this.fg.get(paramstSimpleMetaComment.id);
      if (localInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = localInteger.intValue() + 10;; i = 10)
    {
      this.fg.put(paramstSimpleMetaComment.id, Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply)
  {
    ooz.e("comment", "addCommentReply :" + paramstSimpleMetaReply.wording + ",mComments size:" + this.kZ.size());
    if ((!TextUtils.isEmpty(paramString)) && (paramstSimpleMetaReply != null))
    {
      Iterator localIterator = this.kZ.iterator();
      while (localIterator.hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
        if (paramString.equals(localstSimpleMetaComment.id)) {
          localstSimpleMetaComment.replyList.add(0, paramstSimpleMetaReply);
        }
      }
    }
  }
  
  public boolean a(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    boolean bool2 = false;
    ooz.e("comment", "updateComment ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.kZ.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((stSimpleMetaComment)this.kZ.get(i)).id)) {
          break label90;
        }
        if (this.kZ.set(i, paramstSimpleMetaComment) == null) {
          break label84;
        }
      }
      label84:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      label90:
      i -= 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool2 = false;
    ooz.e("comment", "updateCommentReply ............. mComments.size:" + this.kZ.size());
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramstSimpleMetaReply.id))
      {
        Iterator localIterator = this.kZ.iterator();
        stSimpleMetaComment localstSimpleMetaComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
        } while (!paramString1.equals(localstSimpleMetaComment.id));
        i = localstSimpleMetaComment.replyList.size() - 1;
        if (i < 0) {
          break label184;
        }
        if (!paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(i)).id)) {
          break label175;
        }
        if (localstSimpleMetaComment.replyList.set(i, paramstSimpleMetaReply) == null) {
          break label169;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label169:
      bool1 = false;
      continue;
      label175:
      i -= 1;
      break;
      label184:
      bool1 = false;
    }
  }
  
  public void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      this.b = paramstSimpleMetaFeed;
      this.mFeedId = paramstSimpleMetaFeed.id;
    }
  }
  
  public void bW(String paramString1, String paramString2)
  {
    this.Ur = paramString1;
    this.aqb = paramString2;
  }
  
  public void beD()
  {
    this.kZ.clear();
    this.fg.clear();
  }
  
  public void beE()
  {
    if (this.ac != null) {
      this.ac.clear();
    }
  }
  
  public boolean c(Collection<stSimpleMetaComment> paramCollection)
  {
    boolean bool = false;
    if (paramCollection != null) {
      bool = this.kZ.addAll(paramCollection);
    }
    return bool;
  }
  
  public boolean eF(String paramString)
  {
    boolean bool2 = false;
    ooz.e("comment", "removeComment ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.kZ.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((stSimpleMetaComment)this.kZ.get(i)).id)) {
          break label95;
        }
        if (this.kZ.remove(i) == null) {
          break label90;
        }
      }
      label90:
      for (bool1 = true;; bool1 = false)
      {
        this.fg.remove(paramString);
        return bool1;
      }
      label95:
      i -= 1;
    }
  }
  
  public int getCount()
  {
    return this.kZ.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.kZ.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public String getPlayScene()
  {
    return this.aqb;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)getItem(paramInt);
    Object localObject1;
    if (localstSimpleMetaComment.isTempData)
    {
      if (!this.ac.contains(Integer.valueOf(localstSimpleMetaComment.hashCode())))
      {
        this.ac.add(Integer.valueOf(localstSimpleMetaComment.hashCode()));
        localObject2 = WSPublicAccReport.getTagPositionId(this.Ur);
        localObject1 = localObject2;
        if (!((String)localObject2).equals("comment_tag")) {
          localObject1 = (String)localObject2 + beU;
        }
        WSPublicAccReport.getInstance().reportCommentTagExposure(this.Ur, getPlayScene(), (String)localObject1, this.b);
      }
      for (;;)
      {
        localObject1 = new MoreCommentPanel(this.mContext);
        ((TextView)((MoreCommentPanel)localObject1).findViewById(2131371940)).setTextColor(-7829368);
        ((MoreCommentPanel)localObject1).setOnClickListener(new ogu(this, paramInt));
        ((MoreCommentPanel)localObject1).setHintText(localstSimpleMetaComment.wording);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        ooz.d("beacon-comment", "重复的position:" + paramInt + ",不上报");
      }
    }
    if (paramView != null)
    {
      localObject1 = paramView;
      if (!(paramView instanceof MoreCommentPanel)) {}
    }
    else
    {
      localObject1 = new WsCommentView(this.mContext);
      ((WsCommentView)localObject1).setOnCommentElementClickListener(this.a);
      ((View)localObject1).setTag(localObject1);
    }
    paramView = (WsCommentView)((View)localObject1).getTag();
    paramView.setPosition(paramInt);
    paramView.setDisplayNum(3);
    Object localObject2 = (Integer)this.fg.get(localstSimpleMetaComment.id);
    if (localObject2 != null) {}
    for (int i = ((Integer)localObject2).intValue();; i = 3)
    {
      paramView.setData(localstSimpleMetaComment, i, this.aqa);
      paramView = (View)localObject1;
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void px(String paramString)
  {
    this.aqa = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogt
 * JD-Core Version:    0.7.0.1
 */