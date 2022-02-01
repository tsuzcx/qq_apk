import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class aguv
  extends smq.f
{
  aguv(aguu paramaguu) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.this$0.bJj = ahav.e(paramByteStringMicro1);
    short s;
    if ((paramBoolean) && (!TextUtils.isEmpty(this.this$0.bJj)))
    {
      QLog.d("TroopFileModel<FileAssistant>", 2, "downURL:" + this.this$0.bJj);
      this.this$0.str_download_dns = paramString3;
      this.this$0.aEI = ("" + paramInt3);
      this.this$0.aEJ = ahav.e(paramByteStringMicro1);
      this.this$0.aEK = paramString4;
      this.this$0.aEJ = ahav.e(paramByteStringMicro1);
      if ((!apsv.bS(this.this$0.mAppInterface)) || (!apsv.bT(this.this$0.mAppInterface)) || (paramBundle == null)) {
        break label418;
      }
      paramString1 = paramBundle.getString("strHttpsDomain");
      if (TextUtils.isEmpty(paramString1)) {
        break label418;
      }
      s = (short)paramBundle.getInt("httpsPort", 0);
      if (s != 0) {
        break label413;
      }
      paramBoolean = true;
      s = 443;
    }
    for (;;)
    {
      smq.a(this.this$0.mAppInterface, paramString3, "" + paramInt3, this.this$0.aEJ, ahav.d(this.this$0.c.b()), "/", paramString4, this.this$0.c.b(), new aguw(this, paramBoolean, paramString1, s));
      do
      {
        return;
        QLog.e("TroopFileModel<FileAssistant>", 1, "get preview url failed for troop, retCode[" + paramInt1 + "], retMeg[" + paramString1 + "]");
        anot.a(this.this$0.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.this$0.c.b().TroopUin, "-1", ahav.lb(this.this$0.getFileName()), "1");
      } while (this.this$0.a == null);
      this.this$0.a.jM(paramInt1);
      return;
      label413:
      paramBoolean = true;
      continue;
      label418:
      s = 0;
      paramString1 = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguv
 * JD-Core Version:    0.7.0.1
 */