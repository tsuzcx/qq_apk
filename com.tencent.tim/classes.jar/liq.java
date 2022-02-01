import android.content.Context;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo.a;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.a;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class liq
  extends lir
{
  private String TAG = "ReadInJoyDraftboxModule";
  
  public liq(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private List<ReadInJoyDraftboxItem> aQ()
  {
    List localList = this.mEntityManager.query(ReadInJoyDraftboxItem.class);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
        localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)aqja.c(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
      }
    }
    return localList;
  }
  
  public boolean Cy()
  {
    boolean bool = this.mEntityManager.drop(ReadInJoyDraftboxItem.class);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "deleteAllDraftsFromDb: " + bool);
    }
    return bool;
  }
  
  public long a(long paramLong, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent paramReadInJoyDraftboxContent)
  {
    if (paramReadInJoyDraftboxContent == null) {}
    label159:
    label313:
    label349:
    label359:
    label365:
    do
    {
      return -1L;
      ReadInJoyDraftboxItem localReadInJoyDraftboxItem = new ReadInJoyDraftboxItem();
      localReadInJoyDraftboxItem.type = paramReadInJoyDraftboxContent.articleType;
      localReadInJoyDraftboxItem.setId(paramLong);
      int i;
      if (paramLong == -1L)
      {
        i = 1000;
        localReadInJoyDraftboxItem.setStatus(i);
        String str = paramReadInJoyDraftboxContent.commentString;
        paramLong = System.currentTimeMillis() / 1000L;
        localReadInJoyDraftboxItem.time = paramLong;
        localReadInJoyDraftboxItem.digest = str;
        localReadInJoyDraftboxItem.title = paramReadInJoyDraftboxContent.answerTitle;
        if ((TextUtils.isEmpty(localReadInJoyDraftboxItem.title)) && ((str == null) || (str.length() != 0) || (paramReadInJoyDraftboxContent == null) || (paramReadInJoyDraftboxContent.adapterList == null) || (paramReadInJoyDraftboxContent.adapterList.size() <= 0) || (((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.adapterList.get(0)).type == -1) || (paramReadInJoyDraftboxContent.articleType == 3))) {
          break label349;
        }
        localReadInJoyDraftboxItem.content = aqja.marshall(paramReadInJoyDraftboxContent);
        localReadInJoyDraftboxItem.firstPic = null;
        paramReadInJoyDraftboxContent = paramReadInJoyDraftboxContent.adapterList;
        if ((paramReadInJoyDraftboxContent != null) && (paramReadInJoyDraftboxContent.size() > 0)) {
          localReadInJoyDraftboxItem.firstPic = aqja.marshall((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.get(0));
        }
        if (!a(localReadInJoyDraftboxItem)) {
          continue;
        }
        localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.mEntityManager.find(ReadInJoyDraftboxItem.class, "time = ?", new String[] { paramLong + "" });
        if (QLog.isColorLevel())
        {
          str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("saveDraftBox: ");
          if (localReadInJoyDraftboxItem == null) {
            break label359;
          }
          paramReadInJoyDraftboxContent = "success " + localReadInJoyDraftboxItem;
          QLog.d(str, 2, paramReadInJoyDraftboxContent);
        }
        if (localReadInJoyDraftboxItem == null) {
          break label365;
        }
      }
      for (paramLong = localReadInJoyDraftboxItem.getId();; paramLong = -1L)
      {
        return paramLong;
        i = 1001;
        break;
        localReadInJoyDraftboxItem.title = "";
        break label159;
        paramReadInJoyDraftboxContent = "failed: -1";
        break label313;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "saveDraftBox: failed: -1");
    return -1L;
  }
  
  public SpannableStringBuilder a(List<SocializeFeedsInfo.BiuCommentInfo> paramList, Context paramContext, EditText paramEditText, int paramInt)
  {
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    int j;
    int i;
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
    if (paramList != null)
    {
      localStringBuilder = new StringBuilder();
      localArrayList = new ArrayList();
      j = localStringBuilder.length();
      int k = paramList.size();
      i = 0;
      if (i <= k - 1)
      {
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(i);
        switch (localBiuCommentInfo.aSO)
        {
        default: 
          if (i <= 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = ReadInJoyUserInfoModule.a(localBiuCommentInfo.i.longValue(), null);
        if (localObject == null) {
          continue;
        }
        localObject = ((ReadInJoyUserInfo)localObject).nick;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject;
        String str2;
        String str3;
        QLog.d(this.TAG, 2, localNumberFormatException.getMessage());
        continue;
      }
      localObject = BiuNicknameSpan.d((CharSequence)localObject);
      str2 = "@" + (String)localObject;
      localObject = str2;
      if (localBiuCommentInfo.aSO == 1) {
        localObject = str2 + " ";
      }
      localStringBuilder.append((String)localObject);
      if (localBiuCommentInfo.ahj == null)
      {
        str2 = "";
        localStringBuilder.append(str2);
        localArrayList.add(new nql(j, j + ((String)localObject).length(), new BiuNicknameSpan(localBiuCommentInfo.i.toString(), localBiuCommentInfo.x.longValue(), (CharSequence)localObject, paramContext, paramEditText.getPaint(), paramInt)));
        j = localStringBuilder.length();
        i += 1;
        break;
        if (localBiuCommentInfo.a == null) {
          continue;
        }
        str2 = localBiuCommentInfo.a.iZ();
        str3 = localBiuCommentInfo.a.getJumpUrl();
        if (localBiuCommentInfo.ahj == null)
        {
          localObject = "";
          localStringBuilder.append(str2).append((String)localObject);
          localArrayList.add(new nql(j, str2.length() + j, new nqj(str3, 13421772)));
          continue;
        }
        localObject = localBiuCommentInfo.ahj;
        continue;
        if (localBiuCommentInfo.a == null) {
          continue;
        }
        str2 = localBiuCommentInfo.a.iZ();
        localBiuCommentInfo.a.getJumpUrl();
        if (localBiuCommentInfo.ahj == null)
        {
          localObject = "";
          localStringBuilder.append(str2).append((String)localObject);
          localObject = TopicInfo.a().a(Long.valueOf(localBiuCommentInfo.a.getId()).longValue()).a(str2).a();
          localArrayList.add(new nql(j, str2.length() + j, new TopicSpan((TopicInfo)localObject)));
          continue;
        }
        localObject = localBiuCommentInfo.ahj;
        continue;
        localObject = ReadInJoyUserInfoModule.getDefaultNickName();
        break label666;
      }
      str2 = anbk.nn(localBiuCommentInfo.ahj);
      continue;
      if (localBiuCommentInfo.ahj == null) {}
      for (String str1 = "";; str1 = anbk.nn(localBiuCommentInfo.ahj))
      {
        localStringBuilder.append(str1);
        break;
      }
      paramList = new SpannableStringBuilder(new aofk(localStringBuilder, 3, 20));
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramEditText = (nql)paramContext.next();
        paramList.setSpan(paramEditText.A(), paramEditText.getStartPos(), paramEditText.getEndPos(), 33);
      }
      return paramList;
      return null;
      label666:
      if (str1 == null) {
        str1 = "";
      }
    }
  }
  
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a(long paramLong)
  {
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem = a(paramLong);
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent2 = null;
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
    if (localReadInJoyDraftboxItem != null)
    {
      localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
      if (localReadInJoyDraftboxItem.content != null)
      {
        localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
        if (localReadInJoyDraftboxItem.content.length > 0)
        {
          localReadInJoyDraftboxContent2 = (ReadInJoyDraftboxItem.ReadInJoyDraftboxContent)aqja.c(localReadInJoyDraftboxItem.content, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent.CREATOR);
          localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
          if (QLog.isColorLevel())
          {
            QLog.d(this.TAG, 2, "getReadInJoyContentById: " + paramLong + " " + localReadInJoyDraftboxContent2.toString());
            localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
          }
        }
      }
    }
    return localReadInJoyDraftboxContent1;
  }
  
  public ReadInJoyDraftboxItem a(long paramLong)
  {
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.mEntityManager.find(ReadInJoyDraftboxItem.class, paramLong);
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = this.TAG;
      localStringBuilder = new StringBuilder().append("loadDraftboxFromDbById: ").append(paramLong).append(" ");
      if (localReadInJoyDraftboxItem == null) {
        break label112;
      }
    }
    label112:
    for (String str1 = localReadInJoyDraftboxItem.toString();; str1 = "null")
    {
      QLog.d(str2, 2, str1);
      if ((localReadInJoyDraftboxItem != null) && (localReadInJoyDraftboxItem.firstPic != null)) {
        localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)aqja.c(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
      }
      return localReadInJoyDraftboxItem;
    }
  }
  
  public void a(ReadInJoyDraftboxFragment.a parama)
  {
    List localList = aQ();
    if (QLog.isColorLevel())
    {
      QLog.d(this.TAG, 2, "loadAllDraftsFromDb:\n");
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
          QLog.d(this.TAG, 2, new Object[] { localReadInJoyDraftboxItem });
        }
      }
      QLog.d(this.TAG, 2, "loadAllDraftsFromDb: empty\n");
    }
    parama.notify(localList);
  }
  
  public boolean aQ(long paramLong)
  {
    Object localObject = a(paramLong);
    localObject = Boolean.valueOf(this.mEntityManager.remove((Entity)localObject));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "deleteDraftboxFromDb: " + paramLong + " : " + localObject);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     liq
 * JD-Core Version:    0.7.0.1
 */