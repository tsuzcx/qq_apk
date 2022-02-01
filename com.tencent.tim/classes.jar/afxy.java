import com.tencent.qphone.base.util.QLog;

class afxy
  extends afsr
{
  afxy(afxx paramafxx) {}
  
  protected void bm(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        Object[] arrayOfObject;
        do
        {
          String str;
          do
          {
            return;
            arrayOfObject = (Object[])paramObject;
            str = (String)arrayOfObject[0];
            if (QLog.isColorLevel()) {
              QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
            }
            if (!paramBoolean) {
              break;
            }
            paramObject = (String)arrayOfObject[1];
          } while (afxx.a(this.this$0) == null);
          afxx.a(this.this$0).dk(str, paramObject);
          return;
        } while (paramObject == null);
        int i = ((Integer)arrayOfObject[1]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
        }
        if (i != 20) {
          break;
        }
      } while (afxx.a(this.this$0) == null);
      afxx.a(this.this$0).bPe();
      return;
    } while (afxx.a(this.this$0) == null);
    afxx.a(this.this$0).showToast(2131720702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxy
 * JD-Core Version:    0.7.0.1
 */