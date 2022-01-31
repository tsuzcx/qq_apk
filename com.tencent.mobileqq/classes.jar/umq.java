import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class umq
  extends slu
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  
  public umq(qqstory_service.RspGetUserGuide paramRspGetUserGuide)
  {
    if (paramRspGetUserGuide.pic_url.has())
    {
      localObject1 = paramRspGetUserGuide.pic_url.get().toStringUtf8();
      this.a = ((String)localObject1);
      if (!paramRspGetUserGuide.word.has()) {
        break label129;
      }
      localObject1 = paramRspGetUserGuide.word.get().toStringUtf8();
      label53:
      this.c = ((String)localObject1);
      this.b = paramRspGetUserGuide.seqno.get();
      if (!paramRspGetUserGuide.confirm_word.has()) {
        break label134;
      }
    }
    label129:
    label134:
    for (Object localObject1 = paramRspGetUserGuide.confirm_word.get().toStringUtf8();; localObject1 = null)
    {
      this.d = ((String)localObject1);
      localObject1 = localObject2;
      if (paramRspGetUserGuide.cancel_word.has()) {
        localObject1 = paramRspGetUserGuide.cancel_word.get().toStringUtf8();
      }
      this.e = ((String)localObject1);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label53;
    }
  }
  
  public String toString()
  {
    return "Response{imageUrl='" + this.a + '\'' + ", word='" + this.c + '\'' + ", seqno=" + this.b + ", confirmBtnTxt='" + this.d + '\'' + ", cancelBtnTxt='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umq
 * JD-Core Version:    0.7.0.1
 */