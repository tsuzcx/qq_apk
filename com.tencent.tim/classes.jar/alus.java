import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class alus
  extends acfd
{
  alus(alur paramalur) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    acff localacff;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localacff = (acff)this.this$0.app.getManager(51);
      ExtensionInfo localExtensionInfo = localacff.a(paramString2, true);
      i = 0;
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs >= paramLong.longValue()) {
        break label152;
      }
      ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
      i = j;
    }
    label152:
    for (;;)
    {
      if (i != 0) {
        localacff.a((ExtensionInfo)localObject);
      }
      if (alur.a(this.this$0) == null) {}
      for (localObject = null;; localObject = (aluv)alur.a(this.this$0).get())
      {
        if (localObject != null) {
          ((aluv)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alus
 * JD-Core Version:    0.7.0.1
 */