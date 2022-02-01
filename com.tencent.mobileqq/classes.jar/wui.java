import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFilterList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wui
  extends wpa<wuj>
{
  @NonNull
  public final String a;
  public final int c;
  
  public wui(@NonNull String paramString)
  {
    this(paramString, 20);
  }
  
  public wui(@NonNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  public String a()
  {
    return wnu.a("StorySvc.video_filter_list");
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    return new wuj(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetFilterList localReqGetFilterList = new qqstory_service.ReqGetFilterList();
    localReqGetFilterList.count.set(this.c);
    localReqGetFilterList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqGetFilterList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wui
 * JD-Core Version:    0.7.0.1
 */