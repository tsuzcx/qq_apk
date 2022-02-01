import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class agtb
  extends agie
{
  agtb(agta paramagta, agkw.a parama) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    QLog.i("VideoForC2C<QFile>", 2, "[" + this.jdField_a_of_type_Agta.c.nSessionId + "],[getOnlinePlay]  ID[" + paramLong2 + "]onUpdateGetOfflineDownloadInfo");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Agta.c.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      this.jdField_a_of_type_Agta.c.strFileMd5 = paramString6;
    }
    this.jdField_a_of_type_Agta.c.bUseMediaPlatform = paramBoolean2;
    ahav.a(this.jdField_a_of_type_Agta.c, this.jdField_a_of_type_Agta.mApp, new agtc(this, paramLong1, paramBoolean1, paramString3, paramBundle, paramShort, paramString2, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtb
 * JD-Core Version:    0.7.0.1
 */