import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class amks
{
  private arhz S;
  private acnk jdField_a_of_type_Acnk;
  private acnl jdField_a_of_type_Acnl = new amkt(this);
  private WeakReference<QQAppInterface> aW;
  private long[] as = { 1001L, 1002L };
  private int cLF;
  private String caF = "";
  private String caG;
  private String friendUin;
  private WeakReference<Context> k;
  private String keyword;
  private int uinType;
  private ChatMessage x;
  
  public amks(String paramString)
  {
    this.caG = paramString;
  }
  
  public static int c(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (ChatActivityUtils.b(paramQQAppInterface, paramInt, paramString)) {
      return 5;
    }
    if (ChatActivityUtils.fY(paramInt)) {
      return 3;
    }
    switch (paramInt)
    {
    default: 
      return -1;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  private void reset()
  {
    this.caF = "0";
    QQAppInterface localQQAppInterface = (QQAppInterface)this.aW.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Acnl);
    }
    if (this.S != null) {
      this.S = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ChatMessage paramChatMessage)
  {
    if (this.S != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UinSearcher", 2, "searching, skip");
      }
      return;
    }
    this.aW = new WeakReference(paramQQAppInterface);
    this.k = new WeakReference(paramContext);
    if (this.jdField_a_of_type_Acnk == null) {
      this.jdField_a_of_type_Acnk = ((acnk)paramQQAppInterface.getBusinessHandler(152));
    }
    this.keyword = paramString;
    this.x = paramChatMessage;
    paramString = paramChatMessage.selfuin;
    if ((!paramChatMessage.isSend()) && (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {}
    for (this.friendUin = paramChatMessage.senderuin;; this.friendUin = paramChatMessage.frienduin)
    {
      this.uinType = paramChatMessage.istroop;
      this.caF = (System.currentTimeMillis() + "");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Acnl);
      paramQQAppInterface = (CardHandler)paramQQAppInterface.getBusinessHandler(2);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString, this.friendUin, 1, 0L, (byte)1, 0L, 0L, null, "", 8192L, 10004, null, (byte)0);
      }
      try
      {
        this.S = new arhz(paramContext);
        this.S.setGravity(17);
        this.S.setBackground(null);
        this.S.setProgressBackground(2130839657);
        if (this.S.getWindow() != null) {
          this.S.getWindow().setDimAmount(0.0F);
        }
        this.S.setOnDismissListener(new amkw(this));
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          this.S.show();
        }
      }
      catch (RuntimeException paramQQAppInterface)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramQQAppInterface, new Object[0]);
        }
      }
      this.jdField_a_of_type_Acnk.a(this.keyword, this.caF, 20, amkl.b(this.as), null, null, 0, 0.0D, 0.0D, null, "{ \"search_by_id_only\": 1 }");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amks
 * JD-Core Version:    0.7.0.1
 */