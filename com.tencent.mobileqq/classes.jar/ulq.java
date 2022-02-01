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
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ulq
  extends BaseAdapter
{
  public static int a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<stSimpleMetaComment> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private zgz jdField_a_of_type_Zgz;
  private String jdField_b_of_type_JavaLangString = "focus";
  HashSet<Integer> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private String c;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ulq(Context paramContext, zgz paramzgz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      uya.a("comment", "create mComments ...");
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_Zgz = paramzgz;
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
      uya.a("comment", "复用 mComments ...");
    }
  }
  
  public int a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramstSimpleMetaComment.id, Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(int paramInt, stSimpleMetaComment paramstSimpleMetaComment)
  {
    uya.d("comment", "addComment ...2");
    if ((paramstSimpleMetaComment != null) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramstSimpleMetaComment);
    }
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    Integer localInteger;
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramstSimpleMetaComment.id);
      if (localInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = localInteger.intValue() + 10;; i = 10)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramstSimpleMetaComment.id, Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if (paramstSimpleMetaReply == null) {}
    stSimpleMetaComment localstSimpleMetaComment;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          uya.d("comment", "addCommentReply :" + paramstSimpleMetaReply.wording + ",mComments size:" + this.jdField_a_of_type_JavaUtilList.size());
        } while (TextUtils.isEmpty(paramString));
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
    } while (!paramString.equals(localstSimpleMetaComment.id));
    localstSimpleMetaComment.replyList.add(0, paramstSimpleMetaReply);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    uya.d("comment", "removeComment ...");
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
        if (!paramString.equals(((stSimpleMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id)) {
          break label95;
        }
        if (this.jdField_a_of_type_JavaUtilList.remove(i) == null) {
          break label90;
        }
      }
      label90:
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return bool1;
      }
      label95:
      i -= 1;
    }
  }
  
  public boolean a(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    boolean bool2 = false;
    uya.d("comment", "updateComment ...");
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
        if (!paramString.equals(((stSimpleMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id)) {
          break label90;
        }
        if (this.jdField_a_of_type_JavaUtilList.set(i, paramstSimpleMetaComment) == null) {
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
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    uya.d("comment", "removeCommentReply ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public boolean a(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool2 = false;
    uya.d("comment", "updateCommentReply ............. mComments.size:" + this.jdField_a_of_type_JavaUtilList.size());
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramstSimpleMetaReply.id))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public boolean a(Collection<stSimpleMetaComment> paramCollection)
  {
    boolean bool = false;
    if (paramCollection != null) {
      bool = this.jdField_a_of_type_JavaUtilList.addAll(paramCollection);
    }
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
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
    stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)getItem(paramInt);
    Object localObject1;
    if (localstSimpleMetaComment.isTempData)
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localstSimpleMetaComment.hashCode())))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localstSimpleMetaComment.hashCode()));
        localObject2 = uvl.c(this.jdField_b_of_type_JavaLangString);
        localObject1 = localObject2;
        if (!((String)localObject2).equals("comment_tag")) {
          localObject1 = (String)localObject2 + jdField_a_of_type_Int;
        }
        uvl.b(this.jdField_b_of_type_JavaLangString, a(), (String)localObject1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      }
      for (;;)
      {
        localObject1 = new MoreCommentPanel(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)((MoreCommentPanel)localObject1).findViewById(2131371365)).setTextColor(-7829368);
        ((MoreCommentPanel)localObject1).setOnClickListener(new ulr(this, paramInt));
        ((MoreCommentPanel)localObject1).setHintText(localstSimpleMetaComment.wording);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        uya.b("beacon-comment", "重复的position:" + paramInt + ",不上报");
      }
    }
    if (paramView != null)
    {
      localObject1 = paramView;
      if (!(paramView instanceof MoreCommentPanel)) {}
    }
    else
    {
      localObject1 = new WsCommentView(this.jdField_a_of_type_AndroidContentContext);
      ((WsCommentView)localObject1).setOnCommentElementClickListener(this.jdField_a_of_type_Zgz);
      ((View)localObject1).setTag(localObject1);
    }
    paramView = (WsCommentView)((View)localObject1).getTag();
    paramView.setPosition(paramInt);
    paramView.setDisplayNum(3);
    Object localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localstSimpleMetaComment.id);
    if (localObject2 != null) {}
    for (int i = ((Integer)localObject2).intValue();; i = 3)
    {
      paramView.setData(localstSimpleMetaComment, i, this.jdField_a_of_type_JavaLangString);
      paramView = (View)localObject1;
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulq
 * JD-Core Version:    0.7.0.1
 */