import UserGrowth.stCommentJumpText;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class uzs
{
  private static final String jdField_a_of_type_JavaLangString = uzs.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<stSimpleMetaComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vaj jdField_a_of_type_Vaj;
  private Map<String, Integer> b = new HashMap();
  private Map<String, vaa> c = new HashMap();
  
  public uzs(vaj paramvaj)
  {
    this.jdField_a_of_type_Vaj = paramvaj;
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
            vmp.c("weishi-comment", "end, comment word:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).wording + ", id:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).id);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          vmp.d("weishi-comment", "comment is null");
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (this.c.get(paramString1) == null)
    {
      vaa localvaa = new vaa();
      localvaa.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localvaa.jdField_a_of_type_Boolean = paramBoolean1;
        this.c.put(paramString1, localvaa);
        return;
      }
    }
    paramString1 = (vaa)this.c.get(paramString1);
    if (paramString1 != null)
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = paramBoolean2;; paramBoolean1 = false)
      {
        paramString1.jdField_a_of_type_Boolean = paramBoolean1;
        paramString1.jdField_a_of_type_JavaLangString = paramString2;
        return;
      }
    }
    vmp.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.c.get(paramString) == null)
    {
      vaa localvaa = new vaa();
      localvaa.b = paramBoolean;
      this.c.put(paramString, localvaa);
      return;
    }
    paramString = (vaa)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.b = paramBoolean;
      return;
    }
    vmp.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
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
          vmp.a("comment", localstCommentJumpText.index + ",尾部拉量入口: " + localstSimpleMetaComment.wording);
        }
        for (;;)
        {
          i += 1;
          break;
          vmp.a("comment", "oldsize:" + paramInt + ", index:" + j);
          break label105;
          label191:
          vmp.a("comment", localstCommentJumpText.index + ",拉量入口: " + localstSimpleMetaComment.wording);
        }
      }
    }
    if ((paramArrayList.size() <= 20) && (localHashMap.containsKey(Integer.valueOf(-1))))
    {
      localHashMap.remove(Integer.valueOf(-1));
      vmp.d("weishi-comment", "评论小于等于20条，移除尾部拉量入口");
    }
    int j = paramArrayList.size() + localHashMap.size();
    vmp.d("weishi-comment", "size1:" + paramArrayList.size() + ",size2:" + localHashMap.size());
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
        vmp.c("weishi-comment", "combineComment end!");
      }
      vmp.d("weishi-comment", "combineComment success");
      return a(paramArrayList1);
    }
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.b.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleComment paramstSimpleComment)
  {
    paramstSimpleMetaFeed = new vld(paramstSimpleMetaFeed.id, paramstSimpleComment.id, paramstSimpleComment.isDing);
    vfk.a().a(new vfr(paramstSimpleMetaFeed, a(), new uzy(this, paramstSimpleComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    paramstSimpleMetaFeed = new vld(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    vfk.a().a(new vfr(paramstSimpleMetaFeed, a(), new uzx(this, paramstSimpleMetaComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    vmp.d(jdField_a_of_type_JavaLangString, "reply.poster_id:" + paramstSimpleMetaReply.poster.id + ",reply.receiver_id:" + paramstSimpleMetaReply.receiver.id + ",reply.beReplyCommendId:" + paramstSimpleMetaReply.beReplyReplyId);
    paramstSimpleMetaFeed = new vle(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    vfk.a().a(new vfr(paramstSimpleMetaFeed, a(), new uzw(this, paramstSimpleMetaReply), 6));
    return 0L;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new uzt(this, Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (vaa)this.c.get(paramString);
    if ((paramString != null) && (paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_JavaLangString != null)) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public ArrayList<stSimpleMetaComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public vbv a(Object... paramVarArgs)
  {
    return new vbv(6, paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.b.clear();
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    vmp.d(jdField_a_of_type_JavaLangString, "---添加评论，wording:" + paramstSimpleMetaComment.wording + "poster_id:" + paramstSimpleMetaComment.poster_id + ",receiver_id:" + paramstSimpleMetaComment.receiver_id);
    paramstSimpleMetaFeed = new vlf(paramstSimpleMetaFeed, paramstSimpleMetaComment);
    vfk.a().a(new vfr(paramstSimpleMetaFeed, a(), new uzv(this, paramstSimpleMetaComment), 5));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    paramstSimpleMetaFeed = new vld(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    vfk.a().a(new vfr(paramstSimpleMetaFeed, a(), new uzz(this), 9));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean)
  {
    vmp.a(jdField_a_of_type_JavaLangString, "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
    long l = System.currentTimeMillis();
    paramstSimpleMetaFeed = new vfr(new vky(paramString, paramstSimpleMetaFeed.id, 1), a(), new uzu(this, l, paramstSimpleMetaFeed, paramBoolean), 1000);
    vfk.a().a(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null)
    {
      vmp.d(jdField_a_of_type_JavaLangString, "getComments , feed is null ");
      return;
    }
    String str = a(paramstSimpleMetaFeed.id);
    vmp.c(jdField_a_of_type_JavaLangString, "getComments loadMore: " + paramBoolean + ", attachInfo:" + str);
    if ((paramBoolean) && (TextUtils.isEmpty(str)))
    {
      vmp.d(jdField_a_of_type_JavaLangString, "getComments and loadMore, attachInfo is empty ");
      return;
    }
    if (!paramBoolean)
    {
      str = "";
      vmp.d(jdField_a_of_type_JavaLangString, "first getComments, set attachInfo empty ");
    }
    a(paramstSimpleMetaFeed.id, false);
    a(paramstSimpleMetaFeed, str, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzs
 * JD-Core Version:    0.7.0.1
 */