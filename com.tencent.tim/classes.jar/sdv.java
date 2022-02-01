import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.subscribe.comment.CommentView;
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class sdv
  extends BaseAdapter
{
  private sdw a;
  private String aqa;
  private Map<String, Integer> fg;
  private List<CertifiedAccountMeta.StComment> kZ;
  private Context mContext;
  
  public sdv(Context paramContext, sdw paramsdw)
  {
    this.mContext = paramContext;
    this.kZ = new ArrayList();
    this.a = paramsdw;
    this.fg = new HashMap();
  }
  
  public boolean L(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        Iterator localIterator = this.kZ.iterator();
        CertifiedAccountMeta.StComment localStComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        } while (!paramString1.equals(localStComment.id.get()));
        i = localStComment.vecReply.size() - 1;
        if (i < 0) {
          break label153;
        }
        if (!paramString2.equals(((CertifiedAccountMeta.StReply)localStComment.vecReply.get(i)).id.get())) {
          break label146;
        }
        if (localStComment.vecReply.get().remove(i) == null) {
          break label140;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label140:
      bool1 = false;
      continue;
      label146:
      i -= 1;
      break;
      label153:
      bool1 = false;
    }
  }
  
  public int a(CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void a(int paramInt, CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.kZ.size())) {
      this.kZ.add(paramInt, paramStComment);
    }
  }
  
  public void a(CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(paramStComment.vecReply.size()));
      notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStReply != null))
    {
      Iterator localIterator = this.kZ.iterator();
      while (localIterator.hasNext())
      {
        CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        if (paramString.equals(localStComment.id.get())) {
          localStComment.vecReply.get().add(0, paramStReply);
        }
      }
    }
  }
  
  public boolean a(String paramString, CertifiedAccountMeta.StComment paramStComment)
  {
    boolean bool2 = false;
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
        if (!paramString.equals(((CertifiedAccountMeta.StComment)this.kZ.get(i)).id.get())) {
          break label86;
        }
        if (this.kZ.set(i, paramStComment) == null) {
          break label80;
        }
      }
      label80:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      label86:
      i -= 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, CertifiedAccountMeta.StReply paramStReply)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramStReply.id.get()))
      {
        Iterator localIterator = this.kZ.iterator();
        CertifiedAccountMeta.StComment localStComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        } while (!paramString1.equals(localStComment.id.get()));
        i = localStComment.vecReply.size() - 1;
        if (i < 0) {
          break label166;
        }
        if (!paramString2.equals(((CertifiedAccountMeta.StReply)localStComment.vecReply.get(i)).id.get())) {
          break label157;
        }
        if (localStComment.vecReply.get().set(i, paramStReply) == null) {
          break label151;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label151:
      bool1 = false;
      continue;
      label157:
      i -= 1;
      break;
      label166:
      bool1 = false;
    }
  }
  
  public void b(CertifiedAccountMeta.StComment paramStComment)
  {
    Integer localInteger;
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      localInteger = (Integer)this.fg.get(paramStComment.id.get());
      if (localInteger == null) {
        break label75;
      }
    }
    label75:
    for (int i = localInteger.intValue() + 10;; i = 10)
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public void beD()
  {
    this.kZ.clear();
    this.fg.clear();
  }
  
  public boolean c(Collection<CertifiedAccountMeta.StComment> paramCollection)
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
        if (!paramString.equals(((CertifiedAccountMeta.StComment)this.kZ.get(i)).id.get())) {
          break label91;
        }
        if (this.kZ.remove(i) == null) {
          break label86;
        }
      }
      label86:
      for (bool1 = true;; bool1 = false)
      {
        this.fg.remove(paramString);
        return bool1;
      }
      label91:
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)getItem(paramInt);
    if ((paramView == null) || ((paramView instanceof MoreCommentPanel)))
    {
      paramView = new CommentView(this.mContext);
      ((CommentView)paramView).setOnCommentElementClickListener(this.a);
      paramView.setTag(paramView);
    }
    for (;;)
    {
      CommentView localCommentView = (CommentView)paramView.getTag();
      localCommentView.setPosition(paramInt);
      localCommentView.setDisplayNum(3);
      Integer localInteger = (Integer)this.fg.get(localStComment.id.get());
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = 3)
      {
        localCommentView.setData(localStComment, i, this.aqa);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
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
  
  public void vh(int paramInt)
  {
    if (this.kZ.size() > paramInt + 1) {
      a((CertifiedAccountMeta.StComment)this.kZ.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdv
 * JD-Core Version:    0.7.0.1
 */