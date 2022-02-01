import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class agje
  extends smq.l
{
  agje(agir.m paramm) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (agir.m.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + agir.m.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + agir.m.a(this.a));
      agir.m.a(this.a).ch(agir.j(agir.m.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + agir.m.a(this.a));
      agir.m.a(this.a).ch(agir.j(agir.m.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + agir.m.a(this.a));
      agir.m.a(this.a).ch(agir.j(agir.m.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + agir.m.a(this.a) + "] filename " + agir.m.a(this.a));
    agir.m.a(this.a, paramString1);
    agir.m.a(this.a).putString("_m_ForwardUuid", agir.m.b(this.a));
    if (agir.m.a(this.a) != 102)
    {
      agir.m.a(this.a).w(agir.m.b(this.a), agir.m.a(this.a));
      return;
    }
    agir.m.a(this.a, paramInt2);
    agir.m.a(this.a).putString("_m_ForwardBusType", String.valueOf(agir.m.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!agir.m.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(agir.m.c(this.a));
      i = 0;
      paramInt2 = i;
      if (agir.m.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(agir.m.d(this.a));
        j = 0;
        i = j;
        if (agir.m.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(agir.m.e(this.a));
            if (agir.a(this.a.this$0) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + agir.m.a(this.a));
            agir.m.a(this.a).ch(agir.j(agir.m.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + agir.m.c(this.a) + "] is error filename " + agir.m.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + agir.m.d(this.a) + "] is error filename " + agir.m.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + agir.m.e(this.a) + "] is error filename " + agir.m.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + agir.m.a(this.a));
          agir.b(agir.a(this.a.this$0), agir.m.b(this.a), agir.m.b(this.a), agir.m.b(this.a), agir.m.a(this.a), 0, paramInt1, paramInt2, i, false, agir.m.a(this.a), agir.m.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agje
 * JD-Core Version:    0.7.0.1
 */