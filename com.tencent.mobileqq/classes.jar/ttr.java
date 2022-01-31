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

public class ttr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private yde jdField_a_of_type_Yde;
  
  public ttr(Context paramContext, yde paramyde)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yde = paramyde;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
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
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
        if (paramString.equals(localStComment.id.get())) {
          localStComment.vecReply.get().add(0, paramStReply);
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
          break label91;
        }
        if (this.jdField_a_of_type_JavaUtilList.remove(i) == null) {
          break label86;
        }
      }
      label86:
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return bool1;
      }
      label91:
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
          break label153;
        }
        if (!paramString2.equals(((FeedCloudMeta.StReply)localStComment.vecReply.get(i)).id.get())) {
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
    for (int i = localInteger.intValue() + 10;; i = 10)
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
    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)getItem(paramInt);
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (!(paramView instanceof MoreCommentPanelView)) {}
    }
    else
    {
      paramViewGroup = new QCircleCommentItemView(this.jdField_a_of_type_AndroidContentContext);
      ((QCircleCommentItemView)paramViewGroup).setOnCommentElementClickListener(this.jdField_a_of_type_Yde);
      paramViewGroup.setTag(paramViewGroup);
    }
    paramView = (QCircleCommentItemView)paramViewGroup.getTag();
    paramView.setPosition(paramInt);
    paramView.setDisplayNum(3);
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localStComment.id.get());
    if (localInteger != null) {}
    for (paramInt = localInteger.intValue();; paramInt = 3)
    {
      if (getCount() == 1)
      {
        paramInt = localStComment.vecReply.size();
        paramView.setDisplayNum(paramInt);
      }
      paramView.setData(localStComment, paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      return paramViewGroup;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttr
 * JD-Core Version:    0.7.0.1
 */