import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;

class zbs
  extends accn
{
  zbs(zbq paramzbq) {}
  
  private void a(short paramShort1, short paramShort2)
  {
    if ((paramShort1 == -23447) && (zbq.a(this.this$0) != null))
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)zbq.a(this.this$0).getBusinessHandler(1);
      if (localFriendListHandler != null)
      {
        localFriendListHandler.notifyUI(113, true, null);
        if (paramShort2 != 0) {
          break label73;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
        }
        localFriendListHandler.a(null, null, 6, null);
      }
    }
    return;
    label73:
    this.this$0.Bo(false);
  }
  
  private void a(short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    String str;
    int i;
    if (QLog.isColorLevel())
    {
      str = "";
      i = 0;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        if (!QLog.isColorLevel()) {
          break label124;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label124:
    for (;;)
    {
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", new Object[] { str }));
      }
      return;
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str;
    int i;
    boolean bool;
    if (paramBoolean)
    {
      str = "";
      i = 0;
      paramBoolean = false;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        zbq.b localb = zbq.a(this.this$0, s);
        bool = paramBoolean;
        if (localb != null)
        {
          bool = paramBoolean;
          if (localShort != null)
          {
            bool = paramBoolean;
            if (localb.M != localShort.shortValue())
            {
              localb.M = localShort.shortValue();
              bool = true;
            }
          }
        }
        if ((localb == null) || (!QLog.isColorLevel())) {
          break label254;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label254:
    for (;;)
    {
      i += 1;
      paramBoolean = bool;
      break;
      if (paramBoolean)
      {
        zbq.b(this.this$0);
        zbq.a(this.this$0);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", new Object[] { Boolean.valueOf(paramBoolean), str }));
      }
      return;
      a(paramArrayOfShort, paramMap);
      return;
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    if (paramBoolean)
    {
      localb = zbq.a(this.this$0, paramShort1);
      if ((localb != null) && (localb.M != paramShort2))
      {
        localb.M = paramShort2;
        zbq.b(this.this$0);
        zbq.a(this.this$0);
        a(paramShort1, paramShort2);
      }
      if ((localb != null) && (QLog.isColorLevel())) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
      }
    }
    while (!QLog.isColorLevel())
    {
      zbq.b localb;
      return;
    }
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbs
 * JD-Core Version:    0.7.0.1
 */