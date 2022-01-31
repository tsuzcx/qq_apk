import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsf
  extends uro
{
  public List<String> a = new ArrayList();
  public int b;
  
  public wsf(qqstory_service.RspGetPhotographyGuide paramRspGetPhotographyGuide)
  {
    super(paramRspGetPhotographyGuide.result);
    Object localObject = paramRspGetPhotographyGuide.word.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)((Iterator)localObject).next();
        this.a.add(localByteStringMicro.toStringUtf8());
      }
    }
    this.b = paramRspGetPhotographyGuide.seqno.get();
  }
  
  public String toString()
  {
    return "GetPhotographyGuideResponse{, wordList=" + this.a.size() + ", seqno=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsf
 * JD-Core Version:    0.7.0.1
 */