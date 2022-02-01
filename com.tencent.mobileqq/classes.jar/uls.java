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

public class uls
{
  private static final String jdField_a_of_type_JavaLangString = uls.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<stSimpleMetaComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private umj jdField_a_of_type_Umj;
  private Map<String, Integer> b = new HashMap();
  private Map<String, uma> c = new HashMap();
  
  public uls(umj paramumj)
  {
    this.jdField_a_of_type_Umj = paramumj;
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
            uya.c("weishi-comment", "end, comment word:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).wording + ", id:" + ((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).id);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          uya.d("weishi-comment", "comment is null");
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
      uma localuma = new uma();
      localuma.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localuma.jdField_a_of_type_Boolean = paramBoolean1;
        this.c.put(paramString1, localuma);
        return;
      }
    }
    paramString1 = (uma)this.c.get(paramString1);
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
    uya.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.c.get(paramString) == null)
    {
      uma localuma = new uma();
      localuma.b = paramBoolean;
      this.c.put(paramString, localuma);
      return;
    }
    paramString = (uma)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.b = paramBoolean;
      return;
    }
    uya.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
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
          uya.a("comment", localstCommentJumpText.index + ",尾部拉量入口: " + localstSimpleMetaComment.wording);
        }
        for (;;)
        {
          i += 1;
          break;
          uya.a("comment", "oldsize:" + paramInt + ", index:" + j);
          break label105;
          label191:
          uya.a("comment", localstCommentJumpText.index + ",拉量入口: " + localstSimpleMetaComment.wording);
        }
      }
    }
    if ((paramArrayList.size() <= 20) && (localHashMap.containsKey(Integer.valueOf(-1))))
    {
      localHashMap.remove(Integer.valueOf(-1));
      uya.d("weishi-comment", "评论小于等于20条，移除尾部拉量入口");
    }
    int j = paramArrayList.size() + localHashMap.size();
    uya.d("weishi-comment", "size1:" + paramArrayList.size() + ",size2:" + localHashMap.size());
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
        uya.c("weishi-comment", "combineComment end!");
      }
      uya.d("weishi-comment", "combineComment success");
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
    paramstSimpleMetaFeed = new uwo(paramstSimpleMetaFeed.id, paramstSimpleComment.id, paramstSimpleComment.isDing);
    urc.a().a(new urj(paramstSimpleMetaFeed, a(), new uly(this, paramstSimpleComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    paramstSimpleMetaFeed = new uwo(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    urc.a().a(new urj(paramstSimpleMetaFeed, a(), new ulx(this, paramstSimpleMetaComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    uya.d(jdField_a_of_type_JavaLangString, "reply.poster_id:" + paramstSimpleMetaReply.poster.id + ",reply.receiver_id:" + paramstSimpleMetaReply.receiver.id + ",reply.beReplyCommendId:" + paramstSimpleMetaReply.beReplyReplyId);
    paramstSimpleMetaFeed = new uwp(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    urc.a().a(new urj(paramstSimpleMetaFeed, a(), new ulw(this, paramstSimpleMetaReply), 6));
    return 0L;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new ult(this, Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (uma)this.c.get(paramString);
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
  
  public unv a(Object... paramVarArgs)
  {
    return new unv(6, paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.b.clear();
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    uya.d(jdField_a_of_type_JavaLangString, "---添加评论，wording:" + paramstSimpleMetaComment.wording + "poster_id:" + paramstSimpleMetaComment.poster_id + ",receiver_id:" + paramstSimpleMetaComment.receiver_id);
    paramstSimpleMetaFeed = new uwq(paramstSimpleMetaFeed, paramstSimpleMetaComment);
    urc.a().a(new urj(paramstSimpleMetaFeed, a(), new ulv(this, paramstSimpleMetaComment), 5));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    paramstSimpleMetaFeed = new uwo(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    urc.a().a(new urj(paramstSimpleMetaFeed, a(), new ulz(this), 9));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean)
  {
    uya.a(jdField_a_of_type_JavaLangString, "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
    long l = System.currentTimeMillis();
    paramstSimpleMetaFeed = new urj(new uwj(paramString, paramstSimpleMetaFeed.id, 1), a(), new ulu(this, l, paramstSimpleMetaFeed, paramBoolean), 1000);
    urc.a().a(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null)
    {
      uya.d(jdField_a_of_type_JavaLangString, "getComments , feed is null ");
      return;
    }
    String str = a(paramstSimpleMetaFeed.id);
    uya.c(jdField_a_of_type_JavaLangString, "getComments loadMore: " + paramBoolean + ", attachInfo:" + str);
    if ((paramBoolean) && (TextUtils.isEmpty(str)))
    {
      uya.d(jdField_a_of_type_JavaLangString, "getComments and loadMore, attachInfo is empty ");
      return;
    }
    if (!paramBoolean)
    {
      str = "";
      uya.d(jdField_a_of_type_JavaLangString, "first getComments, set attachInfo empty ");
    }
    a(paramstSimpleMetaFeed.id, false);
    a(paramstSimpleMetaFeed, str, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uls
 * JD-Core Version:    0.7.0.1
 */