import android.text.TextUtils;
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

public class vua
{
  private int jdField_a_of_type_Int;
  private List<FeedCloudCommon.BytesEntry> jdField_a_of_type_JavaUtilList;
  
  private vua(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    paramArrayOfByte1 = this.jdField_a_of_type_JavaUtilList;
    if (paramArrayOfByte1 != null) {
      localArrayList.addAll(paramArrayOfByte1);
    }
    if (localArrayList.size() > 0)
    {
      localStCommonExt.mapBytesInfo.set(localArrayList);
      QLog.d("QCircleReporterAgent", 2, "buildSessionCommonExt() valid session and subsession!scene:" + this.jdField_a_of_type_Int);
      return localStCommonExt;
    }
    QLog.e("QCircleReporterAgent", 2, "buildSessionCommonExt() no session and subsession!scene:" + this.jdField_a_of_type_Int);
    return localStCommonExt;
  }
  
  public static vua a(int paramInt)
  {
    return new vua(paramInt);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    vtt.a().a(this.jdField_a_of_type_Int, paramArrayOfByte);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = vtt.a().a();
    if (!paramBoolean) {
      arrayOfByte1 = vtt.a().a(this.jdField_a_of_type_Int);
    }
    return a(arrayOfByte2, arrayOfByte1);
  }
  
  public void a(FeedCloudCommon.BytesEntry paramBytesEntry)
  {
    if (paramBytesEntry != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramBytesEntry);
    }
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    QLog.d("QCircleReporterAgent", 1, "updateSubSession,scene:" + this.jdField_a_of_type_Int);
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
        a(paramStCommonExt);
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
  
  public void a(String paramString)
  {
    ArrayList localArrayList;
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      i = localArrayList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)localArrayList.get(i);
        if ((localBytesEntry != null) && (TextUtils.equals(localBytesEntry.key.get(), paramString)))
        {
          localArrayList.remove(i);
          this.jdField_a_of_type_JavaUtilList = localArrayList;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vua
 * JD-Core Version:    0.7.0.1
 */