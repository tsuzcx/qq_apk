import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

class mzh
  extends aook
{
  mzh(mzg parammzg) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (aoko)paramMessage.obj;
    if ((localObject == null) || ((((aoko)localObject).fileType != 24) && (((aoko)localObject).fileType != 32))) {}
    while ((((aoko)localObject).fileType == 24) && (((aoko)localObject).commandId != 54)) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1004: 
    case 1005: 
    case 2001: 
    case 2003: 
    default: 
      return;
    }
    paramMessage = (Bundle)this.a.es.remove(Long.valueOf(((aoko)localObject).uniseq));
    paramMessage.putLong("uniseq", ((aoko)localObject).uniseq);
    paramMessage.putString("pic_server_id", ((aoko)localObject).fileUrl);
    qqstory_bhd_upload_pic.RspStoryVideo localRspStoryVideo = new qqstory_bhd_upload_pic.RspStoryVideo();
    try
    {
      localRspStoryVideo.mergeFrom(((aoko)localObject).fL);
      if (localRspStoryVideo.retcode.get() == 0)
      {
        localObject = localRspStoryVideo.cdn_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramMessage.putString("cdn_url", (String)localObject);
        }
      }
      label214:
      this.a.a.j(83, paramMessage);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      break label214;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzh
 * JD-Core Version:    0.7.0.1
 */