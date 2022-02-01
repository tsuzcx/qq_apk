import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class qxg
  extends qxm
{
  private qxg.b a;
  private boolean isReset;
  
  public qxg(qxg.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(@NonNull qxg.c paramc, @Nullable qxg.d paramd, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.w("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (isReset())
    {
      ram.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      completed();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ram.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      f(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramd));
    completed();
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return "GetUserGuideInfoStep";
  }
  
  public boolean isReset()
  {
    try
    {
      boolean bool = this.isReset;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    ram.w("Q.qqstory.home.GetUserGuideInfoStep", "run");
    qxg.c localc = new qxg.c();
    ppv.a().a(localc, new qxg.a(this));
  }
  
  public static class a
    implements ppv.b<qxg.c, qxg.d>
  {
    private WeakReference<qxg> co;
    
    public a(qxg paramqxg)
    {
      this.co = new WeakReference(paramqxg);
    }
    
    public void a(@NonNull qxg.c paramc, @Nullable qxg.d paramd, @NonNull ErrorMessage paramErrorMessage)
    {
      ram.w("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
      qxg localqxg = (qxg)this.co.get();
      if (localqxg == null) {
        return;
      }
      localqxg.a(paramc, paramd, paramErrorMessage);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(qxg.d paramd);
  }
  
  public static class c
    extends ppw<qxg.d>
  {
    public static final String CMD = ppf.fQ("StorySvc.get_user_guide");
    
    public qxg.d a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspGetUserGuide localRspGetUserGuide = new qqstory_service.RspGetUserGuide();
      try
      {
        localRspGetUserGuide.mergeFrom(paramArrayOfByte);
        return new qxg.d(localRspGetUserGuide);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          ram.e("Q.qqstory.home.GetUserGuideInfoStep", "decodeResponse error=%s", paramArrayOfByte);
        }
      }
    }
    
    protected byte[] encode()
    {
      return new qqstory_service.ReqGetUserGuide().toByteArray();
    }
    
    public String mg()
    {
      return CMD;
    }
  }
  
  public static class d
    extends ppu
  {
    public String azb;
    public String azc;
    public String imageUrl;
    public int seqno;
    public String word;
    
    public d(qqstory_service.RspGetUserGuide paramRspGetUserGuide)
    {
      if (paramRspGetUserGuide.pic_url.has())
      {
        localObject1 = paramRspGetUserGuide.pic_url.get().toStringUtf8();
        this.imageUrl = ((String)localObject1);
        if (!paramRspGetUserGuide.word.has()) {
          break label129;
        }
        localObject1 = paramRspGetUserGuide.word.get().toStringUtf8();
        label53:
        this.word = ((String)localObject1);
        this.seqno = paramRspGetUserGuide.seqno.get();
        if (!paramRspGetUserGuide.confirm_word.has()) {
          break label134;
        }
      }
      label129:
      label134:
      for (Object localObject1 = paramRspGetUserGuide.confirm_word.get().toStringUtf8();; localObject1 = null)
      {
        this.azb = ((String)localObject1);
        localObject1 = localObject2;
        if (paramRspGetUserGuide.cancel_word.has()) {
          localObject1 = paramRspGetUserGuide.cancel_word.get().toStringUtf8();
        }
        this.azc = ((String)localObject1);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label53;
      }
    }
    
    public String toString()
    {
      return "Response{imageUrl='" + this.imageUrl + '\'' + ", word='" + this.word + '\'' + ", seqno=" + this.seqno + ", confirmBtnTxt='" + this.azb + '\'' + ", cancelBtnTxt='" + this.azc + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxg
 * JD-Core Version:    0.7.0.1
 */