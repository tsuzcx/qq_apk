import android.os.Bundle;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLoadMoreVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class uad
  extends mml
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
        localObject1 = (sqd)sqg.a(5);
        Object localObject3 = paramBundle.getString("extra_feedid");
        localObject2 = (spt)sqg.a(19);
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
            localObject3 = ((spt)localObject2).a((String)localObject3);
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
              paramArrayOfByte = ((sqd)localObject1).a(localStoryVideoItem.mVid, localStoryVideoItem);
              ((VideoCollectionItem)localObject3).videoVidList.add(paramArrayOfByte.mVid);
              paramArrayOfByte = new uhj(paramArrayOfByte.mVid, paramArrayOfByte);
              ((VideoCollectionItem)localObject3).collectionVideoUIItemList.add(paramArrayOfByte);
              paramInt += 1;
            }
            else
            {
              ((spt)localObject2).a((VideoCollectionItem)localObject3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */