import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qxf
  extends qxm
  implements ppv.b<qxf.a, qxf.b>
{
  private boolean isReset;
  
  public void a(@NonNull qxf.a parama, @Nullable qxf.b paramb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramb != null))
    {
      ram.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      parama = (psr)psx.a(10);
      paramb = paramb.wordList;
      if ((paramb != null) && (paramb.size() > 0)) {
        parama.n("StorySvc.get_photography_guide.word", paramb.get(0));
      }
      for (;;)
      {
        completed();
        return;
        parama.n("StorySvc.get_photography_guide.word", acfp.m(2131706957));
      }
    }
    ram.w("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, parama });
    f(paramErrorMessage);
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void reset()
  {
    try
    {
      this.isReset = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    ram.w("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    qxf.a locala = new qxf.a();
    ppv.a().a(locala, this);
  }
  
  public static class a
    extends ppw
  {
    public static final String CMD = ppf.fQ("StorySvc.get_photography_guide");
    
    public ppu a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
      try
      {
        localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
        return new qxf.b(localRspGetPhotographyGuide);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      return new qqstory_service.ReqGetPhotographyGuide().toByteArray();
    }
    
    public String mg()
    {
      return CMD;
    }
    
    public String toString()
    {
      return "GetPhotographyGuideRequest{}";
    }
  }
  
  public static class b
    extends ppu
  {
    public int seqno;
    public List<String> wordList = new ArrayList();
    
    public b(qqstory_service.RspGetPhotographyGuide paramRspGetPhotographyGuide)
    {
      super();
      Object localObject = paramRspGetPhotographyGuide.word.get();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ByteStringMicro localByteStringMicro = (ByteStringMicro)((Iterator)localObject).next();
          this.wordList.add(localByteStringMicro.toStringUtf8());
        }
      }
      this.seqno = paramRspGetPhotographyGuide.seqno.get();
    }
    
    public String toString()
    {
      return "GetPhotographyGuideResponse{, wordList=" + this.wordList.size() + ", seqno=" + this.seqno + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxf
 * JD-Core Version:    0.7.0.1
 */