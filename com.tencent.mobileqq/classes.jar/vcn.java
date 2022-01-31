import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class vcn
  extends mxh
{
  WeakReference<vcm> b;
  WeakReference<ImageView> c;
  
  public vcn(vcm paramvcm, ImageView paramImageView)
  {
    this.b = new WeakReference(paramvcm);
    this.c = new WeakReference(paramImageView);
  }
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list result, code=" + paramInt);
    }
    vcm localvcm = (vcm)this.b.get();
    paramBundle = (ImageView)this.c.get();
    if ((localvcm == null) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "weak reference null.");
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if ((paramInt == 0) && (paramArrayOfByte != null)) {
          try
          {
            Object localObject = new qqstory_710_message.RspStoryMessageList();
            ((qqstory_710_message.RspStoryMessageList)localObject).mergeFrom(paramArrayOfByte);
            if ((((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.has()) && (((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.get() == 0) && (((qqstory_710_message.RspStoryMessageList)localObject).message_num.get() > 0) && (!((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().isEmpty()))
            {
              paramArrayOfByte = ((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().iterator();
              for (;;)
              {
                if (paramArrayOfByte.hasNext())
                {
                  localObject = new uur((qqstory_710_message.StoryMessage)paramArrayOfByte.next());
                  if (((uur)localObject).d)
                  {
                    paramArrayOfByte = ((uur)localObject).a;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from MessageData. unionId=" + paramArrayOfByte);
                    }
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break;
                    }
                    tsr.a(paramBundle, tsr.b(paramArrayOfByte), true, (int)bbdv.a(vcm.b(localvcm), 33.0F));
                    return null;
                  }
                }
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "parse RspStoryMessageList error", paramArrayOfByte);
            }
          }
        }
      }
      paramArrayOfByte = bbef.b();
      QQStoryContext.a();
      paramArrayOfByte = bayh.a(QQStoryContext.a(), 1, Long.toString(vcm.a(localvcm)), 3, paramArrayOfByte, paramArrayOfByte);
      if (paramArrayOfByte != null) {
        paramBundle.setImageDrawable(paramArrayOfByte);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcn
 * JD-Core Version:    0.7.0.1
 */