import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pcx
{
  private int mScene;
  
  private pcx(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  private void N(byte[] paramArrayOfByte)
  {
    pcr.a().g(this.mScene, paramArrayOfByte);
  }
  
  private FeedCloudCommon.BytesEntry a(String paramString, byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    localBytesEntry.key.set(paramString);
    localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return localBytesEntry;
  }
  
  private FeedCloudCommon.StCommonExt a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte1 != null) {
      localArrayList.add(a("SessionID", paramArrayOfByte1));
    }
    if (paramArrayOfByte2 != null) {
      localArrayList.add(a("SubSessionID", paramArrayOfByte2));
    }
    if (localArrayList.size() > 0)
    {
      localStCommonExt.mapBytesInfo.set(localArrayList);
      QLog.d("QCircleReporterAgent", 2, "buildSessionCommonExt() valid session and subsession!scene:" + this.mScene);
      return localStCommonExt;
    }
    QLog.e("QCircleReporterAgent", 2, "buildSessionCommonExt() no session and subsession!scene:" + this.mScene);
    return localStCommonExt;
  }
  
  public static pcx a(int paramInt)
  {
    return new pcx(paramInt);
  }
  
  public FeedCloudCommon.StCommonExt b(boolean paramBoolean)
  {
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = pcr.a().G();
    if (!paramBoolean) {
      arrayOfByte1 = pcr.a().e(this.mScene);
    }
    return a(arrayOfByte2, arrayOfByte1);
  }
  
  public void b(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    QLog.d("QCircleReporterAgent", 1, "updateSubSession,scene:" + this.mScene);
    int i;
    if ((paramStCommonExt != null) && (paramStCommonExt.has()) && (paramStCommonExt.mapBytesInfo.has()))
    {
      paramStCommonExt = paramStCommonExt.mapBytesInfo.get().iterator();
      while (paramStCommonExt.hasNext())
      {
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)paramStCommonExt.next();
        if ((localBytesEntry != null) && ("SubSessionID".equals(localBytesEntry.key.get())))
        {
          paramStCommonExt = localBytesEntry.value.get().toByteArray();
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (paramStCommonExt != null) {
        N(paramStCommonExt);
      }
      if (i != 0)
      {
        QLog.d("QCircleReporterAgent", 1, "find subsession!");
        return;
      }
      QLog.e("QCircleReporterAgent", 1, "can't find subsession!");
      return;
      i = 0;
      paramStCommonExt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcx
 * JD-Core Version:    0.7.0.1
 */