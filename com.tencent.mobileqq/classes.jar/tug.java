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

public class tug
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private yhn jdField_a_of_type_Yhn;
  private Map<String, Integer> b;
  
  public tug(Context paramContext, yhn paramyhn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yhn = paramyhn;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
  }
  
  public int a(FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramStComment.id.get(), Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt + 1) {
      b((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramStComment);
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(0)).typeFlag.get() == 1))
    {
      a(1, paramStComment);
      return;
    }
    a(0, paramStComment);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      if (localStComment.id.get().equals(paramString)) {
        localStComment.typeFlag.set(0);
      }
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStReply != null))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)((Iterator)localObject).next();
        if (paramString.equals(localStComment.id.get()))
        {
          localStComment.vecReply.get().add(paramStReply);
          localObject = (Integer)this.b.get(paramString);
          if (localObject != null)
          {
            paramStReply = (FeedCloudMeta.StReply)localObject;
            if (((Integer)localObject).intValue() > 0) {}
          }
          else
          {
            paramStReply = Integer.valueOf(0);
          }
          this.b.put(paramString, Integer.valueOf(paramStReply.intValue() + 1));
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(i)).id.get())) {
          break label102;
        }
        if (this.jdField_a_of_type_JavaUtilList.remove(i) == null) {
          break label97;
        }
      }
      label97:
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        this.b.remove(paramString);
        return bool1;
      }
      label102:
      i -= 1;
    }
  }
  
  public boolean a(String paramString, FeedCloudMeta.StComment paramStComment)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(i)).id.get())) {
          break label86;
        }
        if (this.jdField_a_of_type_JavaUtilList.set(i, paramStComment) == null) {
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
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
        localObject = (Integer)this.b.get(paramString1);
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
        this.b.put(paramString1, localObject);
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
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public boolean a(Collection<FeedCloudMeta.StComment> paramCollection)
  {
    boolean bool = false;
    if (paramCollection != null) {
      bool = this.jdField_a_of_type_JavaUtilList.addAll(paramCollection);
    }
    return bool;
  }
  
  public void b(FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramStComment.id.get(), Integer.valueOf(paramStComment.vecReply.size()));
      notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      if ((this.jdField_a_of_type_JavaUtilList.get(0) != null) && (((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(0)).typeFlag.get() == 1)) {
        ((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(0)).typeFlag.set(0);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
      this.jdField_a_of_type_JavaUtilList = localLinkedList;
    }
  }
  
  public void c(FeedCloudMeta.StComment paramStComment)
  {
    Integer localInteger;
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramStComment.id.get());
      if (localInteger == null) {
        break label75;
      }
    }
    label75:
    for (int i = localInteger.intValue() + 10;; i = 13)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramStComment.id.get(), Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)getItem(paramInt);
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (!(paramView instanceof MoreCommentPanelView)) {}
    }
    else
    {
      paramViewGroup = new QCircleCommentItemView(this.jdField_a_of_type_AndroidContentContext);
      ((QCircleCommentItemView)paramViewGroup).setOnCommentElementClickListener(this.jdField_a_of_type_Yhn);
      paramViewGroup.setTag(paramViewGroup);
    }
    QCircleCommentItemView localQCircleCommentItemView = (QCircleCommentItemView)paramViewGroup.getTag();
    localQCircleCommentItemView.setPosition(paramInt);
    paramView = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localStComment.id.get());
    if (paramView != null) {}
    for (paramInt = paramView.intValue();; paramInt = 3)
    {
      if (getCount() == 1) {
        paramInt = localStComment.vecReply.size();
      }
      paramView = (Integer)this.b.get(localStComment.id.get());
      if ((paramView == null) || (paramView.intValue() <= 0)) {
        paramView = Integer.valueOf(0);
      }
      for (;;)
      {
        FeedCloudMeta.StFeed localStFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        int i = paramView.intValue();
        if (getCount() == 1) {}
        for (;;)
        {
          localQCircleCommentItemView.setData(localStComment, paramInt, localStFeed, i, bool);
          return paramViewGroup;
          bool = false;
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tug
 * JD-Core Version:    0.7.0.1
 */