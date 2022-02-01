import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class qbr
  extends ppv.c<pzs, pzs.a>
{
  qbr(qbq paramqbq, String[] paramArrayOfString) {}
  
  public void a(@NonNull pzs parampzs, @Nullable pzs.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((parama == null) || (parama.errorCode != 0))
    {
      if (parama != null) {}
      for (int i = parama.errorCode;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        qbq.a(this.a, false);
        return;
      }
    }
    if (((Boolean)((psr)psx.a(10)).c("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (parampzs = qdv.j(this.bT[1], qbq.a(this.a));; parampzs = this.bT[1])
    {
      parampzs = this.bT[0] + "?token=" + parama.awp + "&" + parampzs;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", parampzs });
      }
      this.a.p("EncryptUrlJob_coverUrl", parama.coverUrl);
      this.a.p("EncryptUrlJob_encryptedUrl", parampzs);
      qbq.b(this.a, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbr
 * JD-Core Version:    0.7.0.1
 */