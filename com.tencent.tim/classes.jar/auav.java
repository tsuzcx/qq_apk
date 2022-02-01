import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class auav
  extends smq.f
{
  auav(auau paramauau) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.this$0.bJj = audx.e(paramByteStringMicro1);
    if ((paramBoolean) && (!TextUtils.isEmpty(this.this$0.bJj)))
    {
      QLog.d("TroopFileModel", 2, "downURL:" + this.this$0.bJj);
      this.this$0.str_download_dns = paramString3;
      this.this$0.aEI = ("" + paramInt3);
      this.this$0.aEJ = audx.e(paramByteStringMicro1);
      this.this$0.aEK = paramString4;
      this.this$0.aEJ = audx.e(paramByteStringMicro1);
      smq.a(this.this$0.mAppInterface, paramString3, "" + paramInt3, this.this$0.aEJ, audx.d(this.this$0.c.b()), "/", paramString4, this.this$0.c.b(), new auaw(this));
    }
    do
    {
      return;
      QLog.e("TroopFileModel", 1, "get preview url failed for troop, retCode[" + paramInt1 + "], retMeg[" + paramString1 + "]");
      anot.a(this.this$0.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.this$0.c.b().TroopUin, "-1", audx.lb(this.this$0.getFileName()), "1");
    } while (this.this$0.a == null);
    this.this$0.a.jM(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auav
 * JD-Core Version:    0.7.0.1
 */