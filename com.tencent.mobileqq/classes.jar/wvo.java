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

class wvo
  extends naa
{
  WeakReference<wvn> b;
  WeakReference<ImageView> c;
  
  public wvo(wvn paramwvn, ImageView paramImageView)
  {
    this.b = new WeakReference(paramwvn);
    this.c = new WeakReference(paramImageView);
  }
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list result, code=" + paramInt);
    }
    wvn localwvn = (wvn)this.b.get();
    paramBundle = (ImageView)this.c.get();
    if ((localwvn == null) || (paramBundle == null)) {
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
                  localObject = new wns((qqstory_710_message.StoryMessage)paramArrayOfByte.next());
                  if (((wns)localObject).d)
                  {
                    paramArrayOfByte = ((wns)localObject).a;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from MessageData. unionId=" + paramArrayOfByte);
                    }
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break;
                    }
                    vls.a(paramBundle, vls.b(paramArrayOfByte), true, (int)bdgz.a(wvn.b(localwvn), 33.0F));
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
      paramArrayOfByte = bdhj.b();
      QQStoryContext.a();
      paramArrayOfByte = bdbk.a(QQStoryContext.a(), 1, Long.toString(wvn.a(localwvn)), 3, paramArrayOfByte, paramArrayOfByte);
      if (paramArrayOfByte != null) {
        paramBundle.setImageDrawable(paramArrayOfByte);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvo
 * JD-Core Version:    0.7.0.1
 */