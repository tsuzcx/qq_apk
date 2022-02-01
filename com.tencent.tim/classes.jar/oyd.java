import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqcircle.comment.MoreCommentPanelView;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class oyd
  extends BaseAdapter
{
  private sdw a;
  private Map<String, Integer> fg;
  private Map<String, Integer> fr;
  private List<FeedCloudMeta.StComment> kZ;
  private Context mContext;
  private FeedCloudMeta.StFeed mFeed;
  
  public oyd(Context paramContext, sdw paramsdw)
  {
    this.mContext = paramContext;
    this.kZ = new ArrayList();
    this.a = paramsdw;
    this.fg = new HashMap();
    this.fr = new HashMap();
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
        Object localObject = this.kZ.iterator();
        FeedCloudMeta.StComment localStComment;
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localStComment = (FeedCloudMeta.StComment)((Iterator)localObject).next();
        } while (!paramString1.equals(localStComment.id.get()));
        i = localStComment.vecReply.size() - 1;
        if (i < 0) {
          break label233;
        }
        if (!paramString2.equals(((FeedCloudMeta.StReply)localStComment.vecReply.get(i)).id.get())) {
          break label226;
        }
        if (localStComment.vecReply.get().remove(i) == null) {
          break label220;
        }
        bool1 = true;
        label137:
        localObject = (Integer)this.fr.get(paramString1);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((Integer)localObject).intValue() > 0) {}
        }
        else
        {
          paramString2 = Integer.valueOf(0);
        }
        localObject = paramString2;
        if (localStComment.vecReply.size() - i <= paramString2.intValue()) {
          localObject = Integer.valueOf(paramString2.intValue() - 1);
        }
        this.fr.put(paramString1, localObject);
      }
    }
    for (;;)
    {
      return bool1;
      label220:
      bool1 = false;
      break label137;
      label226:
      i -= 1;
      break;
      label233:
      bool1 = false;
    }
  }
  
  public int a(FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void a(int paramInt, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.kZ.size())) {
      this.kZ.add(paramInt, paramStComment);
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if ((this.kZ.size() > 0) && (((FeedCloudMeta.StComment)this.kZ.get(0)).typeFlag.get() == 1))
    {
      a(1, paramStComment);
      return;
    }
    a(0, paramStComment);
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStReply != null))
    {
      Object localObject = this.kZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)((Iterator)localObject).next();
        if (paramString.equals(localStComment.id.get()))
        {
          localStComment.vecReply.get().add(paramStReply);
          localObject = (Integer)this.fr.get(paramString);
          if (localObject != null)
          {
            paramStReply = (FeedCloudMeta.StReply)localObject;
            if (((Integer)localObject).intValue() > 0) {}
          }
          else
          {
            paramStReply = Integer.valueOf(0);
          }
          this.fr.put(paramString, Integer.valueOf(paramStReply.intValue() + 1));
        }
      }
    }
  }
  
  public boolean a(String paramString, FeedCloudMeta.StComment paramStComment)
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
        if (!paramString.equals(((FeedCloudMeta.StComment)this.kZ.get(i)).id.get())) {
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
  
  public boolean a(String paramString1, String paramString2, FeedCloudMeta.StReply paramStReply)
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
        FeedCloudMeta.StComment localStComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localStComment = (FeedCloudMeta.StComment)localIterator.next();
        } while (!paramString1.equals(localStComment.id.get()));
        i = localStComment.vecReply.size() - 1;
        if (i < 0) {
          break label166;
        }
        if (!paramString2.equals(((FeedCloudMeta.StReply)localStComment.vecReply.get(i)).id.get())) {
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
  
  public void b(FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(paramStComment.vecReply.size()));
      notifyDataSetChanged();
    }
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
  
  public void beD()
  {
    this.kZ.clear();
    this.fg.clear();
    this.fr.clear();
  }
  
  public void c(FeedCloudMeta.StComment paramStComment)
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
    for (int i = localInteger.intValue() + 10;; i = 13)
    {
      this.fg.put(paramStComment.id.get(), Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public boolean c(Collection<FeedCloudMeta.StComment> paramCollection)
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
        if (!paramString.equals(((FeedCloudMeta.StComment)this.kZ.get(i)).id.get())) {
          break label102;
        }
        if (this.kZ.remove(i) == null) {
          break label97;
        }
      }
      label97:
      for (bool1 = true;; bool1 = false)
      {
        this.fg.remove(paramString);
        this.fr.remove(paramString);
        return bool1;
      }
      label102:
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
    boolean bool = true;
    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)getItem(paramInt);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (!(paramView instanceof MoreCommentPanelView)) {}
    }
    else
    {
      localObject = new QCircleCommentItemView(this.mContext);
      ((QCircleCommentItemView)localObject).setOnCommentElementClickListener(this.a);
      ((View)localObject).setTag(localObject);
    }
    QCircleCommentItemView localQCircleCommentItemView = (QCircleCommentItemView)((View)localObject).getTag();
    localQCircleCommentItemView.setPosition(paramInt);
    paramView = (Integer)this.fg.get(localStComment.id.get());
    if (paramView != null) {}
    for (int i = paramView.intValue();; i = 3)
    {
      if (getCount() == 1) {
        i = localStComment.vecReply.size();
      }
      paramView = (Integer)this.fr.get(localStComment.id.get());
      if ((paramView == null) || (paramView.intValue() <= 0)) {
        paramView = Integer.valueOf(0);
      }
      for (;;)
      {
        FeedCloudMeta.StFeed localStFeed = this.mFeed;
        int j = paramView.intValue();
        if (getCount() == 1) {}
        for (;;)
        {
          localQCircleCommentItemView.setData(localStComment, i, localStFeed, j, bool);
          EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
          return localObject;
          bool = false;
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void qt(String paramString)
  {
    Iterator localIterator = this.kZ.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      if (localStComment.id.get().equals(paramString)) {
        localStComment.typeFlag.set(0);
      }
    }
  }
  
  public void qu(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = null;
    if (this.kZ.size() > 0)
    {
      if ((this.kZ.get(0) != null) && (((FeedCloudMeta.StComment)this.kZ.get(0)).typeFlag.get() == 1)) {
        ((FeedCloudMeta.StComment)this.kZ.get(0)).typeFlag.set(0);
      }
      Iterator localIterator = this.kZ.iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
        if (localStComment.id.get().equals(paramString))
        {
          localStComment.typeFlag.set(1);
          localObject = localStComment;
        }
        else
        {
          localLinkedList.add(localStComment);
        }
      }
      if (localObject != null) {
        localLinkedList.add(0, localObject);
      }
      this.kZ = localLinkedList;
    }
  }
  
  public void vh(int paramInt)
  {
    if (this.kZ.size() > paramInt + 1) {
      b((FeedCloudMeta.StComment)this.kZ.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyd
 * JD-Core Version:    0.7.0.1
 */