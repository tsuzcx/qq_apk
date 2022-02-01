import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLoadMoreVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qqe
  implements psj
{
  protected HashMap<String, String> fq = new HashMap();
  private plv<String, ShareGroupItem> h = new plv(300);
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext b()
  {
    return QQStoryContext.a();
  }
  
  public static boolean b(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return false;
    }
    long l = paramShareGroupItem.groupUin;
    return aizp.a().J(QQStoryContext.a(), String.valueOf(l));
  }
  
  public ShareGroupItem a(ShareGroupItem paramShareGroupItem)
  {
    paramShareGroupItem = (ShareGroupItem)this.h.a(paramShareGroupItem.shareGroupId, paramShareGroupItem);
    ShareGroupEntry localShareGroupEntry = paramShareGroupItem.convertTo();
    b().getEntityManagerFactory().createEntityManager().persistOrReplace(localShareGroupEntry);
    return paramShareGroupItem;
  }
  
  public ShareGroupItem a(String paramString)
  {
    rom.checkNotNull(paramString);
    Object localObject = (ShareGroupItem)this.h.a(paramString);
    if (localObject != null)
    {
      ram.w("Q.qqstory.discover.ShareGroupManager", "read sg cc:%s, unionId:" + ((ShareGroupItem)localObject).headerUnionIdList, new Object[] { ((ShareGroupItem)localObject).shareGroupId });
      return localObject;
    }
    localObject = a(b().getEntityManagerFactory().createEntityManager(), ShareGroupEntry.class, ShareGroupEntry.class.getSimpleName(), ShareGroupEntry.getShareGroupSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ram.w("Q.qqstory.discover.ShareGroupManager", "find not find share group:%s", new Object[] { paramString });
      return null;
    }
    localObject = new ShareGroupItem((ShareGroupEntry)((List)localObject).get(0));
    return (ShareGroupItem)this.h.a(paramString, (plu)localObject);
  }
  
  public ShareGroupItem b(String paramString)
  {
    ShareGroupItem localShareGroupItem2 = a(paramString);
    ShareGroupItem localShareGroupItem1 = localShareGroupItem2;
    if (localShareGroupItem2 == null)
    {
      localShareGroupItem1 = new ShareGroupItem();
      localShareGroupItem1.shareGroupId = paramString;
      localShareGroupItem1.name = paramString;
      localShareGroupItem1.ownerUnionId = QQStoryContext.a().getCurrentUid();
      localShareGroupItem1.assertItem();
      ram.w("Q.qqstory.discover.ShareGroupManager", "create one fake groupItem:%s", new Object[] { localShareGroupItem1 });
    }
    return localShareGroupItem1;
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public static class a
    extends jnm.b
  {
    public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      bool = true;
      int i = 0;
      Object localObject1;
      Object localObject2;
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        paramBundle = new qqstory_struct.ErrorInfo();
        paramBundle.error_code.set(paramInt);
        localObject1 = paramBundle.error_desc;
        localObject2 = new StringBuilder().append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ",data is null";
          ((PBBytesField)localObject1).set(ByteStringMicro.copyFromUtf8(paramArrayOfByte));
          paramArrayOfByte = paramBundle;
        }
      }
      do
      {
        for (;;)
        {
          return paramArrayOfByte;
          paramArrayOfByte = ", data is valid";
          break;
          Object localObject4 = new qqstory_service.RspLoadMoreVideoList();
          localObject1 = (psu)psx.a(5);
          Object localObject3 = paramBundle.getString("extra_feedid");
          localObject2 = (psn)psx.a(19);
          for (;;)
          {
            try
            {
              ((qqstory_service.RspLoadMoreVideoList)localObject4).mergeFrom(paramArrayOfByte);
              paramBundle = (qqstory_struct.ErrorInfo)((qqstory_service.RspLoadMoreVideoList)localObject4).result.get();
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
            {
              paramBundle = null;
              continue;
              paramArrayOfByte = "";
              continue;
              bool = false;
              continue;
            }
            try
            {
              localObject3 = ((psn)localObject2).a((String)localObject3);
              paramArrayOfByte = paramBundle;
              if (localObject3 == null) {
                break;
              }
              paramArrayOfByte = paramBundle;
              if (paramBundle.error_code.get() != 0) {
                break;
              }
              if (!((qqstory_service.RspLoadMoreVideoList)localObject4).next_cookie.has()) {
                continue;
              }
              paramArrayOfByte = ((qqstory_service.RspLoadMoreVideoList)localObject4).next_cookie.get().toStringUtf8();
              if (((qqstory_service.RspLoadMoreVideoList)localObject4).is_end.get() != 1) {
                continue;
              }
              localObject4 = ((qqstory_service.RspLoadMoreVideoList)localObject4).video_list.get();
              ((VideoCollectionItem)localObject3).nextCookie = paramArrayOfByte;
              paramInt = i;
              if (paramInt < ((List)localObject4).size())
              {
                paramArrayOfByte = (qqstory_struct.GroupStoryInfo)((List)localObject4).get(paramInt);
                StoryVideoItem localStoryVideoItem = new StoryVideoItem();
                localStoryVideoItem.convertFrom("dummy", paramArrayOfByte);
                paramArrayOfByte = ((psu)localObject1).a(localStoryVideoItem.mVid, localStoryVideoItem);
                ((VideoCollectionItem)localObject3).videoVidList.add(paramArrayOfByte.mVid);
                paramArrayOfByte = new VideoCollectionItem.b(paramArrayOfByte.mVid, paramArrayOfByte);
                ((VideoCollectionItem)localObject3).collectionVideoUIItemList.add(paramArrayOfByte);
                paramInt += 1;
              }
              else
              {
                ((psn)localObject2).a((VideoCollectionItem)localObject3);
                a((VideoCollectionItem)localObject3, bool);
                return paramBundle;
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
            {
              paramArrayOfByte = paramBundle;
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.discover.ShareGroupManager", 2, "doGetMoreVideoByVideoCollectionItem exception:" + localInvalidProtocolBufferMicroException1);
      return paramBundle;
    }
    
    public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqe
 * JD-Core Version:    0.7.0.1
 */