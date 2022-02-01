import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agjb
  extends agie
{
  agjb(agir.h paramh, agir.j paramj, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$h.mFileName + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$h.mFileSize, false), true);
        return;
      }
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$h.mFileSize, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$h.mFileName + " start upload Discfile");
    }
    paramBoolean = agmx.aI(agir.a(this.jdField_a_of_type_Agir$h.this$0));
    paramString2 = "";
    int i = 0;
    paramString5 = "";
    if (paramBundle != null)
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort");
      paramString5 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new agig(agir.a(this.jdField_a_of_type_Agir$h.this$0), paramString3, this.val$sha, this.jdField_a_of_type_Agir$h.mFileSize, paramString4, paramInt, paramBoolean, paramString2, i, this.jdField_a_of_type_Agir$h.mFilePath, paramString5, new agjc(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$h.mFileName + " add to rsCenter");
    }
    agir.h.a(this.jdField_a_of_type_Agir$h, ahav.d().longValue());
    agir.a(this.jdField_a_of_type_Agir$h.this$0).a().a(agir.h.a(this.jdField_a_of_type_Agir$h), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjb
 * JD-Core Version:    0.7.0.1
 */