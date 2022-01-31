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

class upu
  extends mml
{
  WeakReference<upt> b;
  WeakReference<ImageView> c;
  
  public upu(upt paramupt, ImageView paramImageView)
  {
    this.b = new WeakReference(paramupt);
    this.c = new WeakReference(paramImageView);
  }
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list result, code=" + paramInt);
    }
    upt localupt = (upt)this.b.get();
    paramBundle = (ImageView)this.c.get();
    if ((localupt == null) || (paramBundle == null)) {
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
                  localObject = new uhy((qqstory_710_message.StoryMessage)paramArrayOfByte.next());
                  if (((uhy)localObject).d)
                  {
                    paramArrayOfByte = ((uhy)localObject).a;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from MessageData. unionId=" + paramArrayOfByte);
                    }
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break;
                    }
                    tfy.a(paramBundle, tfy.b(paramArrayOfByte), true, (int)bacc.a(upt.b(localupt), 33.0F));
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
      paramArrayOfByte = bacm.b();
      QQStoryContext.a();
      paramArrayOfByte = azwp.a(QQStoryContext.a(), 1, Long.toString(upt.a(localupt)), 3, paramArrayOfByte, paramArrayOfByte);
      if (paramArrayOfByte != null) {
        paramBundle.setImageDrawable(paramArrayOfByte);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */